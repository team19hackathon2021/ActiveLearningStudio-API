package org.curriki.api.enus.vertx;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.tool.TimeTool;
import org.computate.vertx.api.ApiCounter;
import org.computate.vertx.api.ApiRequest;
import org.curriki.api.enus.config.ConfigKeys;
import org.curriki.api.enus.model.resource.CurrikiResource;
import org.curriki.api.enus.request.SiteRequestEnUS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailConfig;
import io.vertx.ext.web.client.WebClient;
import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.mysqlclient.MySQLPool;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.Cursor;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowStream;
import io.vertx.sqlclient.SqlConnection;

/**
 * Map.hackathonMission: to create a new Java class to run Vert.x verticle as a background worker to perform tasks in the background. 
 * Map.hackathonColumn: Quarkus app development
 */
public class WorkerVerticle extends WorkerVerticleGen<AbstractVerticle> {
	private static final Logger LOG = LoggerFactory.getLogger(WorkerVerticle.class);

	public static final Integer FACET_LIMIT = 100;

	public final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss VV");

	/**
	 * A io.vertx.ext.jdbc.JDBCClient for connecting to the relational database PostgreSQL. 
	 **/
	private PgPool pgPool;

	/**
	 * A io.vertx.ext.jdbc.JDBCClient for connecting to the relational database MySQL. 
	 **/
	private MySQLPool mysqlPool;

	public PgPool getPgPool() {
		return pgPool;
	}

	public void setPgPool(PgPool pgPool) {
		this.pgPool = pgPool;
	}

	private WebClient webClient;

	WorkerExecutor workerExecutor;

	JDBCClient jdbcClient;

	Integer commitWithin;

	/**	
	 *	This is called by Vert.x when the verticle instance is deployed. 
	 *	Initialize a new site context object for storing information about the entire site in English. 
	 *	Setup the startPromise to handle the configuration steps and starting the server. 
	 **/
	@Override()
	public void start(Promise<Void> startPromise) throws Exception, Exception {
		commitWithin = config().getInteger(ConfigKeys.SOLR_WORKER_COMMIT_WITHIN_MILLIS);

		try {
			configureData().onSuccess(a -> 
				configureWebClient().onSuccess(b -> 
					configureSharedWorkerExecutor().onSuccess(c -> 
						configureEmail().onSuccess(d -> 
							configureMoonshotsData().onSuccess(e -> 
								importData().onSuccess(f -> 
									refreshAllData().onSuccess(g -> {
										startPromise.complete();
									}).onFailure(ex -> startPromise.fail(ex))
								).onFailure(ex -> startPromise.fail(ex))
							).onFailure(ex -> startPromise.fail(ex))
						).onFailure(ex -> startPromise.fail(ex))
					).onFailure(ex -> startPromise.fail(ex))
				).onFailure(ex -> startPromise.fail(ex))
			).onFailure(ex -> startPromise.fail(ex));
		} catch (Exception ex) {
			LOG.error("Couldn't start verticle. ", ex);
		}
	}

	/**	
	 **/
	private Future<Void> configureWebClient() {
		Promise<Void> promise = Promise.promise();

		try {
			webClient = WebClient.create(vertx);
			promise.complete();
		} catch(Exception ex) {
			LOG.error("Unable to configure site context. ", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**	
	 * 
	 * Val.ConnectionError.enUS:Could not open the database client connection. 
	 * Val.ConnectionSuccess.enUS:The database client connection was successful. 
	 * 
	 * Val.InitError.enUS:Could not initialize the database tables. 
	 * Val.InitSuccess.enUS:The database tables were created successfully. 
	 * 
	 *	Configure shared database connections across the cluster for massive scaling of the application. 
	 *	Return a promise that configures a shared database client connection. 
	 *	Load the database configuration into a shared io.vertx.ext.jdbc.JDBCClient for a scalable, clustered datasource connection pool. 
	 *	Initialize the database tables if not already created for the first time. 
	 **/
	private Future<Void> configureData() {
		Promise<Void> promise = Promise.promise();
		try {
			PgConnectOptions pgOptions = new PgConnectOptions();
			Integer jdbcMaxPoolSize = config().getInteger(ConfigKeys.JDBC_MAX_POOL_SIZE, 1);

			pgOptions.setPort(config().getInteger(ConfigKeys.JDBC_PORT));
			pgOptions.setHost(config().getString(ConfigKeys.JDBC_HOST));
			pgOptions.setDatabase(config().getString(ConfigKeys.JDBC_DATABASE));
			pgOptions.setUser(config().getString(ConfigKeys.JDBC_USERNAME));
			pgOptions.setPassword(config().getString(ConfigKeys.JDBC_PASSWORD));
			pgOptions.setIdleTimeout(config().getInteger(ConfigKeys.JDBC_MAX_IDLE_TIME, 24));
			pgOptions.setIdleTimeoutUnit(TimeUnit.HOURS);
			pgOptions.setConnectTimeout(config().getInteger(ConfigKeys.JDBC_CONNECT_TIMEOUT, 86400000));

			PoolOptions poolOptions = new PoolOptions();
			poolOptions.setMaxSize(jdbcMaxPoolSize);
			poolOptions.setMaxWaitQueueSize(config().getInteger(ConfigKeys.JDBC_MAX_WAIT_QUEUE_SIZE, 10));

			pgPool = PgPool.pool(vertx, pgOptions, poolOptions);

			LOG.info(configureDataInitSuccess);
			promise.complete();
		} catch (Exception ex) {
			LOG.error(configureDataInitError, ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**	
	 * Val.Fail.enUS:Could not configure the shared worker executor. 
	 * Val.Complete.enUS:The shared worker executor "{}" was configured successfully. 
	 * 
	 *	Configure a shared worker executor for running blocking tasks in the background. 
	 *	Return a promise that configures the shared worker executor. 
	 **/
	private Future<Void> configureSharedWorkerExecutor() {
		Promise<Void> promise = Promise.promise();
		try {
			String name = "WorkerVerticle-WorkerExecutor";
			Integer workerPoolSize = System.getenv(ConfigKeys.WORKER_POOL_SIZE) == null ? 5 : Integer.parseInt(System.getenv(ConfigKeys.WORKER_POOL_SIZE));
			workerExecutor = vertx.createSharedWorkerExecutor(name, workerPoolSize);
			LOG.info(configureSharedWorkerExecutorComplete, name);
			promise.complete();
		} catch (Exception ex) {
			LOG.error(configureSharedWorkerExecutorFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**	
	 * Configure sending email. 
	 * Val.Complete.enUS:Configure sending email succeeded. 
	 * Val.Fail.enUS:Configure sending email failed. 
	 **/
	private Future<Void> configureEmail() {
		Promise<Void> promise = Promise.promise();
		try {
			String emailHost = config().getString(ConfigKeys.EMAIL_HOST);
			if(StringUtils.isNotBlank(emailHost)) {
				MailConfig mailConfig = new MailConfig();
				mailConfig.setHostname(emailHost);
				mailConfig.setPort(config().getInteger(ConfigKeys.EMAIL_PORT));
				mailConfig.setSsl(config().getBoolean(ConfigKeys.EMAIL_SSL));
				mailConfig.setUsername(config().getString(ConfigKeys.EMAIL_USERNAME));
				mailConfig.setPassword(config().getString(ConfigKeys.EMAIL_PASSWORD));
				MailClient.createShared(vertx, mailConfig);
				LOG.info(configureEmailComplete);
				promise.complete();
			} else {
				LOG.info(configureEmailComplete);
				promise.complete();
			}
		} catch (Exception ex) {
			LOG.error(configureEmailFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**
	 * Val.Complete.enUS:The Moonshot database was configured successfully. 
	 * Val.Fail.enUS:The Moonshot database configuration failed. 
	 */
	private Future<Void> configureMoonshotsData() {
		Promise<Void> promise = Promise.promise();
		try {
			MySQLConnectOptions mysqlOptions = new MySQLConnectOptions();
			Integer jdbcMaxPoolSize = config().getInteger(ConfigKeys.MOONSHOTS_MAX_POOL_SIZE, 1);

			mysqlOptions.setPort(config().getInteger(ConfigKeys.MOONSHOTS_PORT));
			mysqlOptions.setHost(config().getString(ConfigKeys.MOONSHOTS_HOST));
			mysqlOptions.setDatabase(config().getString(ConfigKeys.MOONSHOTS_DATABASE));
			mysqlOptions.setUser(config().getString(ConfigKeys.MOONSHOTS_USERNAME));
			mysqlOptions.setPassword(config().getString(ConfigKeys.MOONSHOTS_PASSWORD));
			mysqlOptions.setIdleTimeout(config().getInteger(ConfigKeys.MOONSHOTS_MAX_IDLE_TIME, 24));
			mysqlOptions.setIdleTimeoutUnit(TimeUnit.HOURS);
			mysqlOptions.setConnectTimeout(config().getInteger(ConfigKeys.JDBC_CONNECT_TIMEOUT, 86400000));

			PoolOptions poolOptions = new PoolOptions();
			poolOptions.setMaxSize(jdbcMaxPoolSize);
			poolOptions.setMaxWaitQueueSize(config().getInteger(ConfigKeys.JDBC_MAX_WAIT_QUEUE_SIZE, 10));

			mysqlPool = MySQLPool.pool(vertx, mysqlOptions, poolOptions);

			LOG.info(configureDataInitSuccess);
			promise.complete();
		} catch (Exception ex) {
			LOG.error(configureDataInitError, ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**
	 * Val.Scheduling.enUS:Scheduling the %s import at %s
	 * Val.Skip.enUS:Skip importing %s data. 
	 */
	private void importTimer(String classSimpleName) {
		if(config().getBoolean(String.format("%s_%s", ConfigKeys.ENABLE_IMPORT_DATA, classSimpleName), true)) {
			// Load the import start time and period configuration. 
			String importStartTime = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_START_TIME, classSimpleName));
			String importPeriod = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
			// Get the duration of the import period. 
			// Calculate the next start time, or the next start time after that, if the start time is in less than a minute, 
			// to give the following code enough time to complete it's calculations to ensure the import starts correctly. 

			Duration nextStartDuration = null;
			ZonedDateTime nextStartTime = null;
			if(importPeriod != null) {
				Duration duration = TimeTool.parseNextDuration(importPeriod);
				if(importStartTime == null) {
					nextStartTime = Optional.of(ZonedDateTime.now(ZoneId.of(config().getString(ConfigKeys.SITE_ZONE))))
							.map(t -> Duration.between(Instant.now(), t).toMinutes() < 1L ? t.plus(duration) : t).get();
				} else {
					nextStartTime = Optional.of(ZonedDateTime.now(ZoneId.of(config().getString(ConfigKeys.SITE_ZONE))))
							.map(t -> Duration.between(Instant.now(), t).toMinutes() < 1L ? t.plus(duration) : t).get();
				}

				// Get the time now for the import start time zone. 
				ZonedDateTime now = ZonedDateTime.now(nextStartTime.getZone());
				BigDecimal[] divideAndRemainder = BigDecimal.valueOf(Duration.between(now, nextStartTime).toMillis())
						.divideAndRemainder(BigDecimal.valueOf(duration.toMillis()));
				nextStartDuration = Duration.between(now, nextStartTime);
				if(divideAndRemainder[0].compareTo(BigDecimal.ONE) >= 0) {
					nextStartDuration = Duration.ofMillis(divideAndRemainder[1].longValueExact());
					nextStartTime = now.plus(nextStartDuration);
				}
				LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
			}
			ZonedDateTime nextStartTime2 = nextStartTime;

			if(importStartTime == null) {
				importDataClass(classSimpleName, nextStartTime2);
			} else {
				vertx.setTimer(nextStartDuration.toMillis(), a -> {
					importDataClass(classSimpleName, nextStartTime2);
				});
			}
		} else {
			LOG.info(String.format(importTimerSkip, classSimpleName));
		}
	}

	/**	
	 * Import initial data
	 * Val.Complete.enUS:Configuring the import of %s data completed. 
	 * Val.Fail.enUS:Configuring the import of %s data failed. 
	 **/
	private void importDataClass(String classSimpleName, ZonedDateTime startDateTime) {
		if("CurrikiResource".equals(classSimpleName)) {
			try {
				mysqlPool.getConnection(a -> {
					if(a.succeeded()) {
						SqlConnection sqlConnection = a.result();
//						sqlConnection.setOptions(new SQLOptions().setFetchSize(config().getInteger(ConfigKeys.MOONSHOTS_FETCH_SIZE)));
						importDataCurrikiResource(sqlConnection).onComplete(b -> {
							String importPeriod = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
							if(importPeriod != null && startDateTime != null) {
								Duration duration = TimeTool.parseNextDuration(importPeriod);
								ZonedDateTime nextStartTime = startDateTime.plus(duration);
								LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
								Duration nextStartDuration = Duration.between(Instant.now(), nextStartTime);
								vertx.setTimer(nextStartDuration.toMillis(), c -> {
									importDataClass(classSimpleName, nextStartTime);
								});
							}
						});
					} else {
						LOG.error(String.format(importDataClassFail, classSimpleName), a.cause());
						String importPeriod = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
						if(importPeriod != null && startDateTime != null) {
							Duration duration = TimeTool.parseNextDuration(importPeriod);
							ZonedDateTime nextStartTime = startDateTime.plus(duration);
							LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
							Duration nextStartDuration = Duration.between(Instant.now(), nextStartTime);
							vertx.setTimer(nextStartDuration.toMillis(), c -> {
								importDataClass(classSimpleName, nextStartTime);
							});
						}
					}
				});
			} catch(Exception ex) {
				LOG.error(String.format(importDataClassFail, classSimpleName), ex);
				String importPeriod = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
				if(importPeriod != null && startDateTime != null) {
					Duration duration = TimeTool.parseNextDuration(importPeriod);
					ZonedDateTime nextStartTime = startDateTime.plus(duration);
					LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
					Duration nextStartDuration = Duration.between(Instant.now(), nextStartTime);
					vertx.setTimer(nextStartDuration.toMillis(), c -> {
						importDataClass(classSimpleName, nextStartTime);
					});
				}
			}
		}
	}

	/**	
	 * Import initial data
	 * Val.Skip.enUS:The data import is disabled. 
	 **/
	private Future<Void> importData() {
		Promise<Void> promise = Promise.promise();
		if(config().getBoolean(ConfigKeys.ENABLE_IMPORT_DATA)) {
			importTimer("CurrikiResource");
			promise.complete();
		}
		else {
			LOG.info(importDataSkip);
			promise.complete();
		}
		return promise.future();
	}

	/**	
	 * Val.Complete.enUS:Importing all CurrikiResource records completed. 
	 * Val.Fail.enUS:Importing CurrikiResource records failed. 
	 * Val.Skip.enUS:Skip importing CurrikiResource records. 
	 **/
	private Future<Void> importDataCurrikiResource(SqlConnection sqlConnection) {
		Promise<Void> promise = Promise.promise();

		try {
			Integer fetchSize = config().getInteger(ConfigKeys.MOONSHOTS_FETCH_SIZE);
			sqlConnection.begin().onSuccess(transaction -> {
				sqlConnection.prepare(
						"SELECT resourceid, licenseid, contributorid, contributiondate,"
						+ " description, title, keywords, generatedKeywords, language,"
						+ " lasteditorid, lasteditdate, currikilicense, externalurl,"
						+ " resourcechecked, content, resourcecheckrequestnote, resourcecheckdate,"
						+ " resourcecheckid, resourcechecknote, studentfacing, source, reviewstatus,"
						+ " lastreviewdate, reviewedbyid, reviewrating, technicalcompleteness,"
						+ " contentaccuracy, pedagogy, ratingcomment, standardsalignment,"
						+ " standardsalignmentcomment, subjectmatter, subjectmattercomment,"
						+ " supportsteaching, supportsteachingcomment, assessmentsquality,"
						+ " assessmentsqualitycomment, interactivityquality,"
						+ " interactivityqualitycomment, instructionalquality,"
						+ " instructionalqualitycomment, deeperlearning, deeperlearningcomment,"
						+ " partner, createdate, type, featured, page, active, public, xwd_id,"
						+ " mediatype, access, memberrating, aligned, pageurl, indexed,"
						+ " lastindexdate, indexrequired, indexrequireddate, rescrape, gobutton,"
						+ " downloadbutton, topofsearch, remove, spam, topofsearchint, partnerint,"
						+ " reviewresource, oldurl, contentdisplayok, metadata, approvalStatus,"
						+ " approvalStatusDate, spamUser from currikidb.resources"
						).onSuccess(preparedStatement -> {
					Cursor cursor = preparedStatement.cursor();
					importDataCurrikiResourceRow(cursor, fetchSize).onSuccess(a -> {
						transaction.commit();
						promise.complete();
					}).onFailure(ex -> {
						transaction.rollback();
						LOG.error(importDataCurrikiResourceComplete, ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error(importDataCurrikiResourceComplete, ex);
					promise.fail(ex);
				});
			});
		} catch(Exception ex) {
			LOG.error(importDataCurrikiResourceFail, ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**	
	 * Val.Fail.enUS:Importing CurrikiResource row failed. 
	 **/
	public Future<Void> importDataCurrikiResourceRow(Cursor cursor, Integer fetchSize) {
		Promise<Void> promise = Promise.promise();
		
		cursor.read(fetchSize).onSuccess(rowset -> {
			List<Future> futures = new ArrayList<>();
			rowset.forEach(row -> {
				futures.add(Future.future(promise1 -> {
					processRowCurrikiResource(row).onSuccess(a -> {
						promise1.complete();
					}).onFailure(ex -> {
						LOG.error(String.format(importDataCurrikiResourceRowFail), ex);
						promise1.fail(ex);
					});
				}));
			});
			CompositeFuture.all(futures).onSuccess( a -> {
				if(cursor.hasMore()) {
					importDataCurrikiResourceRow(cursor, fetchSize).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						promise.fail(ex);
					});
				} else {
					promise.complete();
				}
			}).onFailure(ex -> {
				LOG.error(String.format(importDataCurrikiResourceRowFail), ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			LOG.error(importDataCurrikiResourceComplete, ex);
			promise.fail(ex);
		});

		return promise.future();
	}

	/**	
	 * Val.Complete.enUS:Importing CurrikiResource row completed. 
	 * Val.Fail.enUS:Importing CurrikiResource row failed. 
	 * @param row 
	 **/
	private Future<Void> processRowCurrikiResource(Row row) {
		Promise<Void> promise = Promise.promise();
		ZoneId moonshotsZone = ZoneId.of(config().getString(ConfigKeys.MOONSHOTS_ZONE));

		try {
			Integer resourceId = row.getInteger(0);
			Integer licenseId = row.getInteger(1);
			Long contributorId = row.getLong(2);
			LocalDateTime contributionDate = row.getLocalDateTime(3);
			String description = row.getString(4);
			String title = row.getString(5);
			String keywordsStr = row.getString(6);
			String generatedKeywordsStr = row.getString(7);
			String language = row.getString(8);
			Long lastEditorId = row.getLong(9);
			LocalDateTime lastEditDate = row.getLocalDateTime(10);
			String currikiLicense = row.getString(11);
			String externalUrl = row.getString(12);
			String resourceChecked = row.getString(13);
			String content = row.getString(14);
			String resourceCheckRequestNote = row.getString(15);
			LocalDateTime resourceCheckDate = row.getLocalDateTime(16);
			Long resourceCheckId = row.getLong(17);
			String resourceCheckNote = row.getString(18);
			String studentFacing = row.getString(19);
			String source = row.getString(20);
			String reviewStatus = row.getString(21);
			LocalDateTime lastReviewDate = row.getLocalDateTime(22);
			Long reviewByID = row.getLong(23);
			BigDecimal reviewRating = Optional.ofNullable(row.getDouble(24)).map(o -> new BigDecimal(o)).orElse(null);
			Integer technicalCompleteness = row.getInteger(25);
			Integer contentAccuracy = row.getInteger(26);
			Integer pedagogy = row.getInteger(27);
			String ratingComment = row.getString(28);
			Integer standardsAlignment = row.getInteger(29);
			String standardsAlignmentComment = row.getString(30);
			Integer subjectMatter = row.getInteger(31);
			String subjectMatterComment = row.getString(32);
			Integer supportsTeaching = row.getInteger(33);
			String supportsTeachingComment = row.getString(34);
			Integer assessmentsQuality = row.getInteger(35);
			String assessmentsQualityComment = row.getString(36);
			Integer interactivityQuality = row.getInteger(37);
			String interactivityQualityComment = row.getString(38);
			Integer instructionalQuality = row.getInteger(39);
			String instructionalQualityComment = row.getString(40);
			Integer deeperLearning = row.getInteger(41);
			String deeperLearningComment = row.getString(42);
			String partner = row.getString(43);
			LocalDateTime createDate = row.getLocalDateTime(44);
			String type = row.getString(45);
			String featured = row.getString(46);
			String page = row.getString(47);
			String active = row.getString(48);
			String Public = row.getString(49);
			Integer xwd_id = row.getInteger(50);
			String mediaType = row.getString(51);
			String access = row.getString(52);
			BigDecimal memberRating = Optional.ofNullable(row.getDouble(53)).map(o -> new BigDecimal(o)).orElse(null);
			String aligned = row.getString(54);
			String pageUrl = row.getString(55);
			String indexed = row.getString(56);
			LocalDateTime lastIndexDate = row.getLocalDateTime(57);
			String indexRequired = row.getString(58);
			LocalDateTime indexRequiredDate = row.getLocalDateTime(59);
			String rescrape = row.getString(60);
			String goButton = row.getString(61);
			String downloadButton = row.getString(62);
			String topOfSearch = row.getString(63);
			String remove = row.getString(64);
			String spam = row.getString(65);
			Integer topOfSearchInt = row.getInteger(66);
			Integer partnerInt = row.getInteger(67);
			String reviewResource = row.getString(68);
			String oldUrl = row.getString(69);
			String contentDisplayOk = row.getString(70);
			String metadata = row.getString(71);
			String approvalStatus = row.getString(72);
			LocalDateTime approvalStatusDate = row.getLocalDateTime(73);
			String spamUser = row.getString(74);
			JsonObject body = new JsonObject();
			body.put(CurrikiResource.VAR_saves, new JsonArray()
					.add(CurrikiResource.VAR_inheritPk)
					.add(CurrikiResource.VAR_created)
					.add(CurrikiResource.VAR_resourceId)
					.add(CurrikiResource.VAR_licenseId)
					.add(CurrikiResource.VAR_contributorId)
					.add(CurrikiResource.VAR_contributionDate)
					.add(CurrikiResource.VAR_description)
					.add(CurrikiResource.VAR_title)
					.add(CurrikiResource.VAR_keywordsStr)
					.add(CurrikiResource.VAR_keywords)
					.add(CurrikiResource.VAR_generatedKeywordsStr)
					.add(CurrikiResource.VAR_generatedKeywords)
					.add(CurrikiResource.VAR_language)
					.add(CurrikiResource.VAR_lastEditorId)
					.add(CurrikiResource.VAR_lastEditDate)
					.add(CurrikiResource.VAR_currikiLicense)
					.add(CurrikiResource.VAR_externalUrl)
					.add(CurrikiResource.VAR_resourceChecked)
					.add(CurrikiResource.VAR_content)
					.add(CurrikiResource.VAR_resourceCheckRequestNote)
					.add(CurrikiResource.VAR_resourceCheckDate)
					.add(CurrikiResource.VAR_resourceCheckId)
					.add(CurrikiResource.VAR_resourceCheckNote)
					.add(CurrikiResource.VAR_studentFacing)
					.add(CurrikiResource.VAR_source)
					.add(CurrikiResource.VAR_reviewStatus)
					.add(CurrikiResource.VAR_lastReviewDate)
					.add(CurrikiResource.VAR_reviewByID)
					.add(CurrikiResource.VAR_reviewRating)
					.add(CurrikiResource.VAR_technicalCompleteness)
					.add(CurrikiResource.VAR_contentAccuracy)
					.add(CurrikiResource.VAR_pedagogy)
					.add(CurrikiResource.VAR_ratingComment)
					.add(CurrikiResource.VAR_standardsAlignment)
					.add(CurrikiResource.VAR_standardsAlignmentComment)
					.add(CurrikiResource.VAR_subjectMatter)
					.add(CurrikiResource.VAR_subjectMatterComment)
					.add(CurrikiResource.VAR_supportsTeaching)
					.add(CurrikiResource.VAR_supportsTeachingComment)
					.add(CurrikiResource.VAR_assessmentsQuality)
					.add(CurrikiResource.VAR_assessmentsQualityComment)
					.add(CurrikiResource.VAR_interactivityQuality)
					.add(CurrikiResource.VAR_interactivityQualityComment)
					.add(CurrikiResource.VAR_instructionalQuality)
					.add(CurrikiResource.VAR_instructionalQualityComment)
					.add(CurrikiResource.VAR_deeperLearning)
					.add(CurrikiResource.VAR_deeperLearningComment)
					.add(CurrikiResource.VAR_partner)
					.add(CurrikiResource.VAR_createDate)
					.add(CurrikiResource.VAR_type)
					.add(CurrikiResource.VAR_featured)
					.add(CurrikiResource.VAR_page)
					.add(CurrikiResource.VAR_active)
					.add(CurrikiResource.VAR_Public)
					.add(CurrikiResource.VAR_xwd_id)
					.add(CurrikiResource.VAR_mediaType)
					.add(CurrikiResource.VAR_access)
					.add(CurrikiResource.VAR_memberRating)
					.add(CurrikiResource.VAR_aligned)
					.add(CurrikiResource.VAR_pageUrl)
					.add(CurrikiResource.VAR_indexed)
					.add(CurrikiResource.VAR_lastIndexDate)
					.add(CurrikiResource.VAR_indexRequired)
					.add(CurrikiResource.VAR_indexRequiredDate)
					.add(CurrikiResource.VAR_rescrape)
					.add(CurrikiResource.VAR_goButton)
					.add(CurrikiResource.VAR_downloadButton)
					.add(CurrikiResource.VAR_topOfSearch)
					.add(CurrikiResource.VAR_remove)
					.add(CurrikiResource.VAR_spam)
					.add(CurrikiResource.VAR_topOfSearchInt)
					.add(CurrikiResource.VAR_partnerInt)
					.add(CurrikiResource.VAR_reviewResource)
					.add(CurrikiResource.VAR_oldUrl)
					.add(CurrikiResource.VAR_contentDisplayOk)
					.add(CurrikiResource.VAR_metadata)
					.add(CurrikiResource.VAR_approvalStatus)
					.add(CurrikiResource.VAR_approvalStatusDate)
					.add(CurrikiResource.VAR_spamUser));

			body.put(CurrikiResource.VAR_pk, Optional.ofNullable(resourceId).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_resourceId, Optional.ofNullable(resourceId).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_licenseId, Optional.ofNullable(licenseId).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_contributorId, Optional.ofNullable(contributorId).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_contributionDate, Optional.ofNullable(contributionDate).map(v -> v.atZone(moonshotsZone).format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null));
			body.put(CurrikiResource.VAR_description, StringUtils.substring(description, 0, 10000));
			body.put(CurrikiResource.VAR_title, title);
			body.put(CurrikiResource.VAR_keywordsStr, keywordsStr);
			body.put(CurrikiResource.VAR_generatedKeywordsStr, generatedKeywordsStr);
			body.put(CurrikiResource.VAR_language, language);
			body.put(CurrikiResource.VAR_lastEditorId, Optional.ofNullable(lastEditorId).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_lastEditDate, Optional.ofNullable(lastEditDate).map(v -> v.atZone(moonshotsZone).format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null));
			body.put(CurrikiResource.VAR_currikiLicense, currikiLicense);
			body.put(CurrikiResource.VAR_externalUrl, externalUrl);
			body.put(CurrikiResource.VAR_resourceChecked, resourceChecked);
			body.put(CurrikiResource.VAR_content, content);
			body.put(CurrikiResource.VAR_resourceCheckRequestNote, resourceCheckRequestNote);
			body.put(CurrikiResource.VAR_resourceCheckDate, Optional.ofNullable(resourceCheckDate).map(v -> v.atZone(moonshotsZone).format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null));
			body.put(CurrikiResource.VAR_resourceCheckId, Optional.ofNullable(resourceCheckId).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_resourceCheckNote, resourceCheckNote);
			body.put(CurrikiResource.VAR_studentFacing, studentFacing);
			body.put(CurrikiResource.VAR_source, source);
			body.put(CurrikiResource.VAR_reviewStatus, reviewStatus);
			body.put(CurrikiResource.VAR_lastReviewDate, Optional.ofNullable(lastReviewDate).map(v -> v.atZone(moonshotsZone).format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null));
			body.put(CurrikiResource.VAR_reviewByID, Optional.ofNullable(reviewByID).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_reviewRating, Optional.ofNullable(reviewRating).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_technicalCompleteness, Optional.ofNullable(technicalCompleteness).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_contentAccuracy, Optional.ofNullable(contentAccuracy).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_pedagogy, Optional.ofNullable(pedagogy).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_ratingComment, ratingComment);
			body.put(CurrikiResource.VAR_standardsAlignment, Optional.ofNullable(standardsAlignment).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_standardsAlignmentComment, standardsAlignmentComment);
			body.put(CurrikiResource.VAR_subjectMatter, Optional.ofNullable(subjectMatter).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_subjectMatterComment, subjectMatterComment);
			body.put(CurrikiResource.VAR_supportsTeaching, Optional.ofNullable(supportsTeaching).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_supportsTeachingComment, supportsTeachingComment);
			body.put(CurrikiResource.VAR_assessmentsQuality, Optional.ofNullable(assessmentsQuality).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_assessmentsQualityComment, assessmentsQualityComment);
			body.put(CurrikiResource.VAR_interactivityQuality, Optional.ofNullable(interactivityQuality).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_interactivityQualityComment, interactivityQualityComment);
			body.put(CurrikiResource.VAR_instructionalQuality, Optional.ofNullable(instructionalQuality).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_instructionalQualityComment, instructionalQualityComment);
			body.put(CurrikiResource.VAR_deeperLearning, Optional.ofNullable(deeperLearning).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_deeperLearningComment, deeperLearningComment);
			body.put(CurrikiResource.VAR_partner, partner);
			body.put(CurrikiResource.VAR_createDate, Optional.ofNullable(createDate).map(v -> v.atZone(moonshotsZone).format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null));
			body.put(CurrikiResource.VAR_type, type);
			body.put(CurrikiResource.VAR_featured, featured);
			body.put(CurrikiResource.VAR_page, page);
			body.put(CurrikiResource.VAR_active, active);
			body.put(CurrikiResource.VAR_Public, Public);
			body.put(CurrikiResource.VAR_xwd_id, Optional.ofNullable(xwd_id).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_mediaType, mediaType);
			body.put(CurrikiResource.VAR_access, access);
			body.put(CurrikiResource.VAR_memberRating, Optional.ofNullable(memberRating).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_aligned, aligned);
			body.put(CurrikiResource.VAR_pageUrl, pageUrl);
			body.put(CurrikiResource.VAR_indexed, indexed);
			body.put(CurrikiResource.VAR_lastIndexDate, Optional.ofNullable(lastIndexDate).map(v -> v.atZone(moonshotsZone).format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null));
			body.put(CurrikiResource.VAR_indexRequired, indexRequired);
			body.put(CurrikiResource.VAR_indexRequiredDate, Optional.ofNullable(indexRequiredDate).map(v -> v.atZone(moonshotsZone).format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null));
			body.put(CurrikiResource.VAR_rescrape, rescrape);
			body.put(CurrikiResource.VAR_goButton, goButton);
			body.put(CurrikiResource.VAR_downloadButton, downloadButton);
			body.put(CurrikiResource.VAR_topOfSearch, topOfSearch);
			body.put(CurrikiResource.VAR_remove, remove);
			body.put(CurrikiResource.VAR_spam, spam);
			body.put(CurrikiResource.VAR_topOfSearchInt, Optional.ofNullable(topOfSearchInt).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_partnerInt, Optional.ofNullable(partnerInt).map(v -> v.toString()).orElse(null));
			body.put(CurrikiResource.VAR_reviewResource, reviewResource);
			body.put(CurrikiResource.VAR_oldUrl, oldUrl);
			body.put(CurrikiResource.VAR_contentDisplayOk, contentDisplayOk);
			body.put(CurrikiResource.VAR_metadata, metadata);
			body.put(CurrikiResource.VAR_approvalStatus, approvalStatus);
			body.put(CurrikiResource.VAR_approvalStatusDate, Optional.ofNullable(approvalStatusDate).map(v -> v.atZone(moonshotsZone).format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null));
			body.put(CurrikiResource.VAR_spamUser, spamUser);

			JsonObject params = new JsonObject();
			params.put("body", body);
			params.put("path", new JsonObject());
			params.put("cookie", new JsonObject());
			params.put("header", new JsonObject());
			params.put("form", new JsonObject());
			params.put("query", new JsonObject()
					.put("var", new JsonArray().add("refresh:false"))
					.put("commitWithin", commitWithin)
					);
			JsonObject context = new JsonObject().put("params", params);
			JsonObject json = new JsonObject().put("context", context);
			vertx.eventBus().request("ActiveLearningStudio-API-enUS-CurrikiResource", json, new DeliveryOptions().addHeader("action", "putimportCurrikiResourceFuture")).onSuccess(a -> {
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(processRowCurrikiResourceFail, ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(processRowCurrikiResourceFail, ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**
	 * Val.Complete.enUS:Refresh all data completed. 
	 * Val.Started.enUS:Refresh all data started. 
	 * Val.Fail.enUS:Refresh all data failed. 
	 * Val.Skip.enUS:Refresh all data skipped. 
	 **/
	private Future<Void> refreshAllData() {
		Promise<Void> promise = Promise.promise();
		try {
			if(config().getBoolean(ConfigKeys.ENABLE_REFRESH_DATA, false)) {
			LOG.info(refreshAllDataStarted);
				refreshData("SiteUser").onSuccess(q -> {
					refreshData("CurrikiResource").onSuccess(a -> {
						LOG.info(refreshAllDataComplete);
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(refreshAllDataFail, ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error(refreshAllDataFail, ex);
					promise.fail(ex);
				});
			} else {
				LOG.info(refreshAllDataSkip);
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error(refreshAllDataFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**
	 * Sync %s data from the database to Solr. 
	 * Refresh %s data from the database to Solr. 
	 * Val.Complete.enUS:%s refresh completed. 
	 * Val.Started.enUS:%s data sync started. 
	 * Val.Skip.enUS:%s refresh skipped. 
	 * Val.Fail.enUS:%s refresh failed. 
	 * Val.CounterResetFail.enUS:%s data sync failed to reset counter. 
	 **/
	private Future<Void> refreshData(String tableName) {
		Promise<Void> promise = Promise.promise();
		if(config().getBoolean(String.format("%s_%s", ConfigKeys.ENABLE_REFRESH_DATA, tableName), false)) {
			vertx.setTimer(10000, timer -> {
				try {
					LOG.info(String.format(refreshDataStarted, tableName));
					pgPool.withTransaction(sqlConnection -> {
						Promise<Void> promise1 = Promise.promise();
						sqlConnection.query(String.format("SELECT count(pk) FROM %s", tableName)).execute().onSuccess(countRowSet -> {
							try {
								Optional<Long> rowCountOptional = Optional.ofNullable(countRowSet.iterator().next()).map(row -> row.getLong(0));
								if(rowCountOptional.isPresent()) {
									Integer apiCounterResume = config().getInteger(ConfigKeys.API_COUNTER_RESUME);
									Integer apiCounterFetch = config().getInteger(ConfigKeys.API_COUNTER_FETCH);
									ApiCounter apiCounter = new ApiCounter();
		
									SiteRequestEnUS siteRequest = new SiteRequestEnUS();
									siteRequest.setConfig(config());
									siteRequest.initDeepSiteRequestEnUS(siteRequest);
			
									ApiRequest apiRequest = new ApiRequest();
									apiRequest.setRows(apiCounterFetch.longValue());
									apiRequest.setNumFound(rowCountOptional.get());
									apiRequest.setNumPATCH(apiCounter.getQueueNum());
									apiRequest.setCreated(ZonedDateTime.now(ZoneId.of(config().getString(ConfigKeys.SITE_ZONE))));
									apiRequest.initDeepApiRequest(siteRequest);
									vertx.eventBus().publish(String.format("websocket%s", tableName), JsonObject.mapFrom(apiRequest));
			
									sqlConnection.prepare(String.format("SELECT pk FROM %s", tableName)).onSuccess(preparedStatement -> {
										apiCounter.setQueueNum(0L);
										apiCounter.setTotalNum(0L);
										try {
											RowStream<Row> stream = preparedStatement.createStream(apiCounterFetch);
											stream.pause();
											stream.fetch(apiCounterFetch);
											stream.exceptionHandler(ex -> {
												LOG.error(String.format(refreshDataFail, tableName), new RuntimeException(ex));
												promise1.fail(ex);
											});
											stream.endHandler(v -> {
												LOG.info(String.format(refreshDataComplete, tableName));
												promise1.complete();
											});
											stream.handler(row -> {
												apiCounter.incrementQueueNum();
												try {
													vertx.eventBus().request(
															String.format("ActiveLearningStudio-API-enUS-%s", tableName)
															, new JsonObject().put(
																	"context"
																	, new JsonObject().put(
																			"params"
																			, new JsonObject()
																					.put("body", new JsonObject().put("pk", row.getLong(0).toString()))
																					.put("path", new JsonObject())
																					.put("cookie", new JsonObject())
																					.put("query", new JsonObject().put("q", "*:*").put("fq", new JsonArray().add("pk:" + row.getLong(0))).put("var", new JsonArray().add("refresh:false")))
																	)
															)
															, new DeliveryOptions().addHeader("action", String.format("patch%sFuture", tableName))).onSuccess(a -> {
														apiCounter.incrementTotalNum();
														apiCounter.decrementQueueNum();
														if(apiCounter.getQueueNum().compareTo(apiCounterResume.longValue()) == 0) {
															stream.fetch(apiCounterFetch);
															apiRequest.setNumPATCH(apiCounter.getTotalNum());
															apiRequest.setTimeRemaining(apiRequest.calculateTimeRemaining());
															vertx.eventBus().publish(String.format("websocket%s", tableName), JsonObject.mapFrom(apiRequest));
														}
													}).onFailure(ex -> {
														LOG.error(String.format(refreshDataFail, tableName), ex);
														promise1.fail(ex);
													});
												} catch (Exception ex) {
													LOG.error(String.format(refreshDataFail, tableName), ex);
													promise1.fail(ex);
												}
											});
										} catch (Exception ex) {
											LOG.error(String.format(refreshDataFail, tableName), ex);
											promise1.fail(ex);
										}
									}).onFailure(ex -> {
										LOG.error(String.format(refreshDataFail, tableName), ex);
										promise1.fail(ex);
									});
								} else {
									promise1.complete();
								}
							} catch (Exception ex) {
								LOG.error(String.format(refreshDataFail, tableName), ex);
								promise1.fail(ex);
							}
						}).onFailure(ex -> {
							LOG.error(String.format(refreshDataFail, tableName), ex);
							promise1.fail(ex);
						});
						return promise1.future();
					}).onSuccess(a -> {
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format(refreshDataFail, tableName), ex);
						promise.fail(ex);
					});
				} catch (Exception ex) {
					LOG.error(String.format(refreshDataFail, tableName), ex);
					promise.fail(ex);
				}
			});
		} else {
			LOG.info(String.format(refreshDataSkip, tableName));
			promise.complete();
		}
		return promise.future();
	}
}
