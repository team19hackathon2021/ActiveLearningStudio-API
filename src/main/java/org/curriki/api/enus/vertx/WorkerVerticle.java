package org.curriki.api.enus.vertx;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.computate.search.tool.TimeTool;
import org.computate.vertx.api.ApiCounter;
import org.computate.vertx.api.ApiRequest;
import org.curriki.api.enus.config.ConfigKeys;
import org.curriki.api.enus.model.resource.CurrikiResource;
import org.curriki.api.enus.request.SiteRequestEnUS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailConfig;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.sql.SQLOptions;
import io.vertx.ext.sql.SQLRowStream;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowStream;

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
	public void  start(Promise<Void> startPromise) throws Exception, Exception {
		commitWithin = config().getInteger(ConfigKeys.SOLR_WORKER_COMMIT_WITHIN_MILLIS);

		try {
			configureWebClient().compose(a -> 
				configureSharedWorkerExecutor().compose(c -> 
					configureEmail().compose(d -> 
						configureMoonshotsData().compose(e -> 
							importData().compose(f -> 
								syncDbToSolr().compose(g -> 
									refreshAllData()
								)
							)
						)
					)
				)
			).onComplete(startPromise);
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
			JsonObject jdbcOptions = new JsonObject();
			jdbcOptions.put("driver_class", config().getString(ConfigKeys.MOONSHOTS_DRIVER_CLASS));
			jdbcOptions.put("url", String.format("jdbc:mysql://%s:%s@%s:%s/%s?useSSL=false&zeroDateTimeBehavior=convertToNull", 
					config().getString(ConfigKeys.MOONSHOTS_USERNAME)
					, config().getString(ConfigKeys.MOONSHOTS_PASSWORD)
					, config().getString(ConfigKeys.MOONSHOTS_HOST)
					, config().getString(ConfigKeys.MOONSHOTS_PORT)
					, config().getString(ConfigKeys.MOONSHOTS_DATABASE)
					));
			jdbcOptions.put("max_pool_size", config().getInteger(ConfigKeys.MOONSHOTS_MAX_POOL_SIZE));
			jdbcOptions.put("min_pool_size", config().getInteger(ConfigKeys.MOONSHOTS_MIN_POOL_SIZE));
			jdbcOptions.put("max_idle_time", config().getInteger(ConfigKeys.MOONSHOTS_MAX_IDLE_TIME));
			jdbcOptions.put("max_statements", config().getInteger(ConfigKeys.MOONSHOTS_MAX_STATEMENTS));
			jdbcOptions.put("max_statements_per_connection", config().getInteger(ConfigKeys.MOONSHOTS_MAX_STATEMENTS_PER_CONNECTION));

			jdbcClient = JDBCClient.createShared(vertx, jdbcOptions);
			LOG.info(configureMoonshotsDataComplete);
			promise.complete();
		} catch(Exception ex) {
			LOG.error(configureMoonshotsDataFail, ex);
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
			Duration duration = TimeTool.parseNextDuration(importPeriod);
			// Calculate the next start time, or the next start time after that, if the start time is in less than a minute, 
			// to give the following code enough time to complete it's calculations to ensure the import starts correctly. 

			ZonedDateTime nextStartTime;
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
			Duration nextStartDuration = Duration.between(now, nextStartTime);
			if(divideAndRemainder[0].compareTo(BigDecimal.ONE) >= 0) {
				nextStartDuration = Duration.ofMillis(divideAndRemainder[1].longValueExact());
				nextStartTime = now.plus(nextStartDuration);
			}
			LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
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
				jdbcClient.getConnection(a -> {
					if(a.succeeded()) {
						SQLConnection sqlConnection = a.result();
						sqlConnection.setOptions(new SQLOptions().setFetchSize(config().getInteger(ConfigKeys.MOONSHOTS_FETCH_SIZE)));
						importDataCurrikiResource(sqlConnection).onComplete(b -> {
							String importPeriod = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
							Duration duration = TimeTool.parseNextDuration(importPeriod);
							ZonedDateTime nextStartTime = startDateTime.plus(duration);
							LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
							Duration nextStartDuration = Duration.between(Instant.now(), nextStartTime);
							vertx.setTimer(nextStartDuration.toMillis(), c -> {
								importDataClass(classSimpleName, nextStartTime);
							});
						});
					} else {
						LOG.error(String.format(importDataClassFail, classSimpleName), a.cause());
						String importPeriod = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
						Duration duration = TimeTool.parseNextDuration(importPeriod);
						ZonedDateTime nextStartTime = startDateTime.plus(duration);
						LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
						Duration nextStartDuration = Duration.between(Instant.now(), nextStartTime);
						vertx.setTimer(nextStartDuration.toMillis(), c -> {
							importDataClass(classSimpleName, nextStartTime);
						});
					}
				});
			} catch(Exception ex) {
				LOG.error(String.format(importDataClassFail, classSimpleName), ex);
				String importPeriod = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
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
	private Future<Void> importDataCurrikiResource(SQLConnection sqlConnection) {
		Promise<Void> promise = Promise.promise();

		try {
			sqlConnection.queryStreamWithParams(
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
					, new JsonArray(), a -> {
				SQLRowStream sqlRowStream = a.result();
				Integer fetchSize = config().getInteger(ConfigKeys.MOONSHOTS_FETCH_SIZE);
				ApiCounter counter = new ApiCounter();
				sqlRowStream.pause();
				sqlRowStream.fetch(fetchSize);
				sqlRowStream.resultSetClosedHandler(b -> {
					sqlRowStream.moreResults();
				}).handler(row -> {
					counter.incrementQueueNum();
					processRowCurrikiResource(row).onSuccess(b -> {
						counter.decrementQueueNum();
						counter.incrementTotalNum();
						if(counter.getQueueNum().compareTo(0L) == 0) {
							sqlRowStream.fetch(fetchSize);
						}
					}).onFailure(ex -> {
						counter.decrementQueueNum();
						counter.incrementTotalNum();
						sqlRowStream.pause();
						LOG.error(importDataCurrikiResourceFail, ex);
						promise.fail(ex);
					});
				}).exceptionHandler(ex -> {
					LOG.error(importDataCurrikiResourceComplete, ex);
					promise.fail(ex);
				}).endHandler(b -> {
					LOG.info(importDataCurrikiResourceComplete);
					promise.complete();
				});
			});
		} catch(Exception ex) {
			LOG.error(importDataCurrikiResourceFail, ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**	
	 * Val.Complete.enUS:Importing CurrikiResource row completed. 
	 * Val.Fail.enUS:Importing CurrikiResource row failed. 
	 **/
	private Future<Void> processRowCurrikiResource(JsonArray row) {
		Promise<Void> promise = Promise.promise();

		try {
			String resourceId = row.getString(0);
			String licenseId = row.getString(1);
			String contributorId = row.getString(2);
			String contributionDate = row.getString(3);
			String description = row.getString(4);
			String title = row.getString(5);
			String keywordsStr = row.getString(6);
			String generatedKeywordsStr = row.getString(7);
			String language = row.getString(8);
			String lastEditorId = row.getString(9);
			String lastEditDate = row.getString(10);
			String currikiLicense = row.getString(11);
			String externalUrl = row.getString(12);
			String resourceChecked = row.getString(13);
			String content = row.getString(14);
			String resourceCheckRequestNote = row.getString(15);
			String resourceCheckDate = row.getString(16);
			String resourceCheckId = row.getString(17);
			String resourceCheckNote = row.getString(18);
			String studentFacing = row.getString(19);
			String source = row.getString(20);
			String reviewStatus = row.getString(21);
			String lastReviewDate = row.getString(22);
			String reviewByID = row.getString(23);
			String reviewRating = row.getString(24);
			String technicalCompleteness = row.getString(25);
			String contentAccuracy = row.getString(26);
			String pedagogy = row.getString(27);
			String ratingComment = row.getString(28);
			String standardsAlignment = row.getString(29);
			String standardsAlignmentComment = row.getString(30);
			String subjectMatter = row.getString(31);
			String subjectMatterComment = row.getString(32);
			String supportsTeaching = row.getString(33);
			String supportsTeachingComment = row.getString(34);
			String assessmentsQuality = row.getString(35);
			String assessmentsQualityComment = row.getString(36);
			String interactivityQuality = row.getString(37);
			String interactivityQualityComment = row.getString(38);
			String instructionalQuality = row.getString(39);
			String instructionalQualityComment = row.getString(40);
			String deeperLearning = row.getString(41);
			String deeperLearningComment = row.getString(42);
			String partner = row.getString(43);
			String createDate = row.getString(44);
			String type = row.getString(45);
			String featured = row.getString(46);
			String page = row.getString(47);
			String active = row.getString(48);
			String Public = row.getString(49);
			String xwd_id = row.getString(50);
			String mediaType = row.getString(51);
			String access = row.getString(52);
			String memberRating = row.getString(53);
			String aligned = row.getString(54);
			String pageUrl = row.getString(55);
			String indexed = row.getString(56);
			String lastIndexDate = row.getString(57);
			String indexRequired = row.getString(58);
			String indexRequiredDate = row.getString(59);
			String rescrape = row.getString(60);
			String goButton = row.getString(61);
			String downloadButton = row.getString(62);
			String topOfSearch = row.getString(63);
			String remove = row.getString(64);
			String spam = row.getString(65);
			String topOfSearchInt = row.getString(66);
			String partnerInt = row.getString(67);
			String reviewResource = row.getString(68);
			String oldUrl = row.getString(69);
			String contentDisplayOk = row.getString(70);
			String metadata = row.getString(71);
			String approvalStatus = row.getString(72);
			String approvalStatusDate = row.getString(73);
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

			body.put(CurrikiResource.VAR_pk, resourceId);
			body.put(CurrikiResource.VAR_resourceId, resourceId);
			body.put(CurrikiResource.VAR_licenseId, licenseId);
			body.put(CurrikiResource.VAR_contributorId, contributorId);
			body.put(CurrikiResource.VAR_contributionDate, contributionDate);
			body.put(CurrikiResource.VAR_description, description);
			body.put(CurrikiResource.VAR_title, title);
			body.put(CurrikiResource.VAR_keywordsStr, keywordsStr);
			body.put(CurrikiResource.VAR_generatedKeywordsStr, generatedKeywordsStr);
			body.put(CurrikiResource.VAR_language, language);
			body.put(CurrikiResource.VAR_lastEditorId, lastEditorId);
			body.put(CurrikiResource.VAR_lastEditDate, lastEditDate);
			body.put(CurrikiResource.VAR_currikiLicense, currikiLicense);
			body.put(CurrikiResource.VAR_externalUrl, externalUrl);
			body.put(CurrikiResource.VAR_resourceChecked, resourceChecked);
			body.put(CurrikiResource.VAR_content, content);
			body.put(CurrikiResource.VAR_resourceCheckRequestNote, resourceCheckRequestNote);
			body.put(CurrikiResource.VAR_resourceCheckDate, resourceCheckDate);
			body.put(CurrikiResource.VAR_resourceCheckId, resourceCheckId);
			body.put(CurrikiResource.VAR_resourceCheckNote, resourceCheckNote);
			body.put(CurrikiResource.VAR_studentFacing, studentFacing);
			body.put(CurrikiResource.VAR_source, source);
			body.put(CurrikiResource.VAR_reviewStatus, reviewStatus);
			body.put(CurrikiResource.VAR_lastReviewDate, lastReviewDate);
			body.put(CurrikiResource.VAR_reviewByID, reviewByID);
			body.put(CurrikiResource.VAR_reviewRating, reviewRating);
			body.put(CurrikiResource.VAR_technicalCompleteness, technicalCompleteness);
			body.put(CurrikiResource.VAR_contentAccuracy, contentAccuracy);
			body.put(CurrikiResource.VAR_pedagogy, pedagogy);
			body.put(CurrikiResource.VAR_ratingComment, ratingComment);
			body.put(CurrikiResource.VAR_standardsAlignment, standardsAlignment);
			body.put(CurrikiResource.VAR_standardsAlignmentComment, standardsAlignmentComment);
			body.put(CurrikiResource.VAR_subjectMatter, subjectMatter);
			body.put(CurrikiResource.VAR_subjectMatterComment, subjectMatterComment);
			body.put(CurrikiResource.VAR_supportsTeaching, supportsTeaching);
			body.put(CurrikiResource.VAR_supportsTeachingComment, supportsTeachingComment);
			body.put(CurrikiResource.VAR_assessmentsQuality, assessmentsQuality);
			body.put(CurrikiResource.VAR_assessmentsQualityComment, assessmentsQualityComment);
			body.put(CurrikiResource.VAR_interactivityQuality, interactivityQuality);
			body.put(CurrikiResource.VAR_interactivityQualityComment, interactivityQualityComment);
			body.put(CurrikiResource.VAR_instructionalQuality, instructionalQuality);
			body.put(CurrikiResource.VAR_instructionalQualityComment, instructionalQualityComment);
			body.put(CurrikiResource.VAR_deeperLearning, deeperLearning);
			body.put(CurrikiResource.VAR_deeperLearningComment, deeperLearningComment);
			body.put(CurrikiResource.VAR_partner, partner);
			body.put(CurrikiResource.VAR_createDate, createDate);
			body.put(CurrikiResource.VAR_type, type);
			body.put(CurrikiResource.VAR_featured, featured);
			body.put(CurrikiResource.VAR_page, page);
			body.put(CurrikiResource.VAR_active, active);
			body.put(CurrikiResource.VAR_Public, Public);
			body.put(CurrikiResource.VAR_xwd_id, xwd_id);
			body.put(CurrikiResource.VAR_mediaType, mediaType);
			body.put(CurrikiResource.VAR_access, access);
			body.put(CurrikiResource.VAR_memberRating, memberRating);
			body.put(CurrikiResource.VAR_aligned, aligned);
			body.put(CurrikiResource.VAR_pageUrl, pageUrl);
			body.put(CurrikiResource.VAR_indexed, indexed);
			body.put(CurrikiResource.VAR_lastIndexDate, lastIndexDate);
			body.put(CurrikiResource.VAR_indexRequired, indexRequired);
			body.put(CurrikiResource.VAR_indexRequiredDate, indexRequiredDate);
			body.put(CurrikiResource.VAR_rescrape, rescrape);
			body.put(CurrikiResource.VAR_goButton, goButton);
			body.put(CurrikiResource.VAR_downloadButton, downloadButton);
			body.put(CurrikiResource.VAR_topOfSearch, topOfSearch);
			body.put(CurrikiResource.VAR_remove, remove);
			body.put(CurrikiResource.VAR_spam, spam);
			body.put(CurrikiResource.VAR_topOfSearchInt, topOfSearchInt);
			body.put(CurrikiResource.VAR_partnerInt, partnerInt);
			body.put(CurrikiResource.VAR_reviewResource, reviewResource);
			body.put(CurrikiResource.VAR_oldUrl, oldUrl);
			body.put(CurrikiResource.VAR_contentDisplayOk, contentDisplayOk);
			body.put(CurrikiResource.VAR_metadata, metadata);
			body.put(CurrikiResource.VAR_approvalStatus, approvalStatus);
			body.put(CurrikiResource.VAR_approvalStatusDate, approvalStatusDate);
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
	 * Val.Complete.enUS:Syncing database to Solr completed. 
	 * Val.Fail.enUS:Syncing database to Solr failed. 
	 * Val.Skip.enUS:Skip syncing database to Solr. 
	 **/
	private Future<Void> syncDbToSolr() {
		Promise<Void> promise = Promise.promise();
		if(config().getBoolean(ConfigKeys.ENABLE_DB_SOLR_SYNC, false)) {
			Long millis = 1000L * config().getInteger(ConfigKeys.TIMER_DB_SOLR_SYNC_IN_SECONDS, 10);
			vertx.setTimer(millis, a -> {
				LOG.info(syncDbToSolrComplete);
				promise.complete();
			});
		} else {
			LOG.info(syncDbToSolrSkip);
			promise.complete();
		}
		return promise.future();
	}

	/**	
	 * Sync %s data from the database to Solr. 
	 * Val.Complete.enUS:%s data sync completed. 
	 * Val.Fail.enUS:%s data sync failed. 
	 * Val.CounterResetFail.enUS:%s data sync failed to reset counter. 
	 * Val.Skip.enUS:%s data sync skipped. 
	 * Val.Started.enUS:%s data sync started. 
	 **/
	private Future<Void> syncData(String tableName) {
		Promise<Void> promise = Promise.promise();
		try {
			if(config().getBoolean(String.format("%s_%s", ConfigKeys.ENABLE_DB_SOLR_SYNC, tableName), true)) {

				LOG.info(String.format(syncDataStarted, tableName));
				pgPool.withTransaction(sqlConnection -> {
					Promise<Void> promise1 = Promise.promise();
					sqlConnection.query(String.format("SELECT count(pk) FROM %s", tableName)).execute().onSuccess(countRowSet -> {
						try {
							Optional<Long> rowCountOptional = Optional.ofNullable(countRowSet.iterator().next()).map(row -> row.getLong(0));
							if(rowCountOptional.isPresent()) {
								Long apiCounterResume = config().getLong(ConfigKeys.API_COUNTER_RESUME);
								Long apiCounterFetch = config().getLong(ConfigKeys.API_COUNTER_FETCH);
								ApiCounter apiCounter = new ApiCounter();
	
								SiteRequestEnUS siteRequest = new SiteRequestEnUS();
								siteRequest.setConfig(config());
								siteRequest.initDeepSiteRequestEnUS(siteRequest);
		
								ApiRequest apiRequest = new ApiRequest();
								apiRequest.setRows(apiCounterFetch);
								apiRequest.setNumFound(rowCountOptional.get());
								apiRequest.setNumPATCH(apiCounter.getQueueNum());
								apiRequest.setCreated(ZonedDateTime.now(ZoneId.of(config().getString(ConfigKeys.SITE_ZONE))));
								apiRequest.initDeepApiRequest(siteRequest);
								vertx.eventBus().publish(String.format("websocket%s", tableName), JsonObject.mapFrom(apiRequest));
		
								sqlConnection.prepare(String.format("SELECT pk FROM %s", tableName)).onSuccess(preparedStatement -> {
									apiCounter.setQueueNum(0L);
									apiCounter.setTotalNum(0L);
									try {
										RowStream<Row> stream = preparedStatement.createStream(apiCounterFetch.intValue());
										stream.pause();
										stream.fetch(apiCounterFetch);
										stream.exceptionHandler(ex -> {
											LOG.error(String.format(syncDataFail, tableName), new RuntimeException(ex));
											promise1.fail(ex);
										});
										stream.endHandler(v -> {
											LOG.info(String.format(syncDataComplete, tableName));
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
													if(apiCounter.getQueueNum().compareTo(apiCounterResume) == 0) {
														stream.fetch(apiCounterFetch);
														apiRequest.setNumPATCH(apiCounter.getTotalNum());
														apiRequest.setTimeRemaining(apiRequest.calculateTimeRemaining());
														vertx.eventBus().publish(String.format("websocket%s", tableName), JsonObject.mapFrom(apiRequest));
													}
												}).onFailure(ex -> {
													LOG.error(String.format(syncDataFail, tableName), ex);
													promise1.fail(ex);
												});
											} catch (Exception ex) {
												LOG.error(String.format(syncDataFail, tableName), ex);
												promise1.fail(ex);
											}
										});
									} catch (Exception ex) {
										LOG.error(String.format(syncDataFail, tableName), ex);
										promise1.fail(ex);
									}
								}).onFailure(ex -> {
									LOG.error(String.format(syncDataFail, tableName), ex);
									promise1.fail(ex);
								});
							} else {
								promise1.complete();
							}
						} catch (Exception ex) {
							LOG.error(String.format(syncDataFail, tableName), ex);
							promise1.fail(ex);
						}
					}).onFailure(ex -> {
						LOG.error(String.format(syncDataFail, tableName), ex);
						promise1.fail(ex);
					});
					return promise1.future();
				}).onSuccess(a -> {
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format(syncDataFail, tableName), ex);
					promise.fail(ex);
				});
			} else {
				LOG.info(String.format(syncDataSkip, tableName));
				promise.complete();
			}
		} catch (Exception ex) {
			LOG.error(String.format(syncDataFail, tableName), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**	
	 * Val.Complete.enUS:Refresh all data completed. 
	 * Val.Fail.enUS:Refresh all data failed. 
	 * Val.Skip.enUS:Refresh all data skipped. 
	 **/
	private Future<Void> refreshAllData() {
		Promise<Void> promise = Promise.promise();
		vertx.setTimer(1000 * 10, a -> {
			if(config().getBoolean(ConfigKeys.ENABLE_REFRESH_DATA, false)) {
				refreshData("SiteUser").onSuccess(b -> {
					LOG.info(refreshAllDataComplete);
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(refreshAllDataFail, ex);
					promise.fail(ex);
				});
			} else {
				LOG.info(refreshAllDataSkip);
				promise.complete();
			}
		});
		return promise.future();
	}

	/**	
	 * Refresh %s data from the database to Solr. 
	 * Val.Complete.enUS:%s refresh completed. 
	 * Val.Fail.enUS:%s refresh failed. 
	 * Val.Skip.enUS:%s refresh skipped. 
	 **/
	private Future<Void> refreshData(String tableName) {
		Promise<Void> promise = Promise.promise();
		try {
			if(config().getBoolean(String.format("%s_%s", ConfigKeys.ENABLE_REFRESH_DATA, tableName), true)) {
				webClient.post(config().getInteger(ConfigKeys.AUTH_PORT), config().getString(ConfigKeys.AUTH_HOST_NAME), config().getString(ConfigKeys.AUTH_TOKEN_URI))
						.expect(ResponsePredicate.SC_OK)
						.ssl(config().getBoolean(ConfigKeys.AUTH_SSL))
						.authentication(new UsernamePasswordCredentials(config().getString(ConfigKeys.AUTH_RESOURCE), config().getString(ConfigKeys.AUTH_SECRET)))
						.putHeader("Content-Type", "application/x-www-form-urlencoded")
						.sendForm(MultiMap.caseInsensitiveMultiMap().set("grant_type", "client_credentials"))
						.onSuccess(tokenResponse -> {
					JsonObject token = tokenResponse.bodyAsJsonObject();
					JsonObject params = new JsonObject();
					params.put("body", new JsonObject());
					params.put("path", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("query", new JsonObject().put("q", "*:*").put("var", new JsonArray().add("refresh:false")));
					JsonObject context = new JsonObject().put("params", params).put("user", token);
					JsonObject json = new JsonObject().put("context", context);
					vertx.eventBus().request(String.format("ActiveLearningStudio-API-enUS-%s", tableName), json, new DeliveryOptions().addHeader("action", String.format("patch%s", tableName))).onSuccess(a -> {
						LOG.info(String.format(refreshDataComplete, tableName));
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format(refreshDataFail, tableName), ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error(String.format(refreshDataFail, tableName), ex);
					promise.fail(ex);
				});
			} else {
				LOG.info(String.format(refreshDataSkip, tableName));
				promise.complete();
			}
		} catch (Exception ex) {
			LOG.error(String.format(refreshDataFail, tableName), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
}
