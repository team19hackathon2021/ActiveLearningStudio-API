package org.curriki.api.enus.model.resource;

import org.curriki.api.enus.request.SiteRequestEnUS;
import org.curriki.api.enus.model.user.SiteUser;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.search.list.SearchResult;
import org.computate.vertx.verticle.EmailVerticle;
import org.curriki.api.enus.config.ConfigKeys;
import org.computate.vertx.api.BaseApiServiceImpl;
import io.vertx.ext.web.client.WebClient;
import java.util.Objects;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.EventBus;
import io.vertx.pgclient.PgPool;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.web.templ.handlebars.HandlebarsTemplateEngine;
import io.vertx.core.eventbus.DeliveryOptions;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.time.Instant;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import org.apache.commons.lang3.StringUtils;
import java.security.Principal;
import org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.PrintWriter;
import java.util.Collection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import org.apache.commons.lang3.math.NumberUtils;
import io.vertx.ext.web.Router;
import io.vertx.core.Vertx;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import io.vertx.ext.reactivestreams.ReactiveWriteStream;
import io.vertx.core.MultiMap;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.sqlclient.Transaction;
import io.vertx.sqlclient.SqlConnection;
import io.vertx.sqlclient.Tuple;
import io.vertx.sqlclient.Row;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Timestamp;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.AsyncResult;
import java.net.URLEncoder;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.CompositeFuture;
import io.vertx.core.http.HttpHeaders;
import java.nio.charset.Charset;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import java.util.HashMap;
import io.vertx.ext.auth.User;
import java.util.Optional;
import java.util.stream.Stream;
import java.net.URLDecoder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map.Entry;
import java.util.Iterator;
import org.computate.search.tool.SearchTool;
import org.computate.search.response.solr.SolrResponse;
import java.util.Base64;
import java.time.ZonedDateTime;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.curriki.api.enus.model.user.SiteUserEnUSApiServiceImpl;
import org.computate.vertx.search.list.SearchList;


/**
 * Translate: false
 **/
public class CurrikiResourceEnUSGenApiServiceImpl extends BaseApiServiceImpl implements CurrikiResourceEnUSGenApiService {

	protected static final Logger LOG = LoggerFactory.getLogger(CurrikiResourceEnUSGenApiServiceImpl.class);

	public CurrikiResourceEnUSGenApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider, HandlebarsTemplateEngine templateEngine) {
		super(eventBus, config, workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider, templateEngine);
	}

	// Search //

	@Override
	public void searchCurrikiResource(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, "ActiveLearningStudio-API-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {

				List<String> roles = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_REQUIRED + "_CurrikiResource")).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
				List<String> roleReads = Arrays.asList("");
				if(
						!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roleReads)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roleReads)
						) {
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED", 
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", "roles required: " + String.join(", ", roles))
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					searchCurrikiResourceList(siteRequest, false, true, false).onSuccess(listCurrikiResource -> {
						response200SearchCurrikiResource(listCurrikiResource).onSuccess(response -> {
							eventHandler.handle(Future.succeededFuture(response));
							LOG.debug(String.format("searchCurrikiResource succeeded. "));
						}).onFailure(ex -> {
							LOG.error(String.format("searchCurrikiResource failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("searchCurrikiResource failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("searchCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || "invalid_grant: Refresh token expired".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("searchCurrikiResource failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("searchCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}



	public Future<ServiceResponse> response200SearchCurrikiResource(SearchList<CurrikiResource> listCurrikiResource) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listCurrikiResource.getSiteRequest_(SiteRequestEnUS.class);
			SolrResponse responseSearch = listCurrikiResource.getQueryResponse();
			List<SolrResponse.Doc> solrDocuments = listCurrikiResource.getQueryResponse().getResponse().getDocs();
			Long searchInMillis = Long.valueOf(responseSearch.getResponseHeader().getqTime());
			Long startNum = listCurrikiResource.getRequest().getStart();
			Long foundNum = responseSearch.getResponse().getNumFound();
			Integer returnedNum = responseSearch.getResponse().getDocs().size();
			String searchTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(searchInMillis), TimeUnit.MILLISECONDS.toMillis(searchInMillis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(searchInMillis)));
			String nextCursorMark = responseSearch.getNextCursorMark();
			String exceptionSearch = Optional.ofNullable(responseSearch.getError()).map(error -> error.getMsg()).orElse(null);
			List<String> fls = listCurrikiResource.getRequest().getFields();

			JsonObject json = new JsonObject();
			json.put("startNum", startNum);
			json.put("foundNum", foundNum);
			json.put("returnedNum", returnedNum);
			if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves")) {
				json.put("searchTime", searchTime);
			}
			if(nextCursorMark != null) {
				json.put("nextCursorMark", nextCursorMark);
			}
			JsonArray l = new JsonArray();
			listCurrikiResource.getList().stream().forEach(o -> {
				JsonObject json2 = JsonObject.mapFrom(o);
				if(fls.size() > 0) {
					Set<String> fieldNames = new HashSet<String>();
					fieldNames.addAll(json2.fieldNames());
					if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves")) {
						fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
						fieldNames.remove("pk");
						fieldNames.remove("created");
					}
					else if(fls.size() >= 1) {
						fieldNames.removeAll(fls);
					}
					for(String fieldName : fieldNames) {
						if(!fls.contains(fieldName))
							json2.remove(fieldName);
					}
				}
				l.add(json2);
			});
			json.put("list", l);

			SolrResponse.FacetFields facetFields = Optional.ofNullable(responseSearch.getFacetCounts()).map(f -> f.getFacetFields()).orElse(null);
			if(facetFields != null) {
				JsonObject facetFieldsJson = new JsonObject();
				json.put("facet_fields", facetFieldsJson);
				for(SolrResponse.FacetField facetField : facetFields.getFacets().values()) {
					String facetFieldVar = StringUtils.substringBefore(facetField.getName(), "_docvalues_");
					JsonObject facetFieldCounts = new JsonObject();
					facetFieldsJson.put(facetFieldVar, facetFieldCounts);
					facetField.getCounts().forEach((name, count) -> {
						facetFieldCounts.put(name, count);
					});
				}
			}

			SolrResponse.FacetRanges facetRanges = Optional.ofNullable(responseSearch.getFacetCounts()).map(f -> f.getFacetRanges()).orElse(null);
			if(facetRanges != null) {
				JsonObject rangeJson = new JsonObject();
				json.put("facet_ranges", rangeJson);
				for(SolrResponse.FacetRange rangeFacet : facetRanges.getRanges().values()) {
					JsonObject rangeFacetJson = new JsonObject();
					String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
					rangeJson.put(rangeFacetVar, rangeFacetJson);
					JsonObject rangeFacetCountsMap = new JsonObject();
					rangeFacetJson.put("counts", rangeFacetCountsMap);
					rangeFacet.getCounts().forEach((name, count) -> {
						rangeFacetCountsMap.put(name, count);
					});
				}
			}

			SolrResponse.FacetPivots facetPivots = Optional.ofNullable(responseSearch.getFacetCounts()).map(f -> f.getFacetPivots()).orElse(null);
			if(facetPivots != null) {
				JsonObject facetPivotJson = new JsonObject();
				json.put("facet_pivot", facetPivotJson);
				for(SolrResponse.FacetPivot facetPivot : facetPivots.getPivots().values()) {
					String[] varsIndexed = facetPivot.getName().trim().split(",");
					String[] entityVars = new String[varsIndexed.length];
					for(Integer i = 0; i < entityVars.length; i++) {
						String entityIndexed = varsIndexed[i];
						entityVars[i] = StringUtils.substringBefore(entityIndexed, "_docvalues_");
					}
					JsonArray pivotArray = new JsonArray();
					facetPivotJson.put(StringUtils.join(entityVars, ","), pivotArray);
					responsePivotSearchCurrikiResource(facetPivot.getPivot(), pivotArray);
				}
			}
			if(exceptionSearch != null) {
				json.put("exceptionSearch", exceptionSearch);
			}
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200SearchCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void responsePivotSearchCurrikiResource(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
		for(SolrResponse.Pivot pivotField : pivots) {
			String entityIndexed = pivotField.getField();
			String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
			JsonObject pivotJson = new JsonObject();
			pivotArray.add(pivotJson);
			pivotJson.put("field", entityVar);
			pivotJson.put("value", pivotField.getValue());
			pivotJson.put("count", pivotField.getCount());
			Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
			List<SolrResponse.Pivot> pivotFields2 = pivotField.getPivot();
			if(pivotRanges != null) {
				JsonObject rangeJson = new JsonObject();
				pivotJson.put("ranges", rangeJson);
				for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
					JsonObject rangeFacetJson = new JsonObject();
					String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
					rangeJson.put(rangeFacetVar, rangeFacetJson);
					JsonObject rangeFacetCountsObject = new JsonObject();
					rangeFacetJson.put("counts", rangeFacetCountsObject);
					rangeFacet.getCounts().forEach((value, count) -> {
						rangeFacetCountsObject.put(value, count);
					});
				}
			}
			if(pivotFields2 != null) {
				JsonArray pivotArray2 = new JsonArray();
				pivotJson.put("pivot", pivotArray2);
				responsePivotSearchCurrikiResource(pivotFields2, pivotArray2);
			}
		}
	}

	// PATCH //

	@Override
	public void patchCurrikiResource(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("patchCurrikiResource started. "));
		user(serviceRequest, SiteRequestEnUS.class, "ActiveLearningStudio-API-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);

				List<String> roles = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_REQUIRED + "_CurrikiResource")).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
				if(
						!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
						) {
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED", 
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", "roles required: " + String.join(", ", roles))
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					searchCurrikiResourceList(siteRequest, false, true, true).onSuccess(listCurrikiResource -> {
						try {
							List<String> roles2 = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_ADMIN)).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
							if(listCurrikiResource.getQueryResponse().getResponse().getNumFound() > 1
									&& !CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles2)
									&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles2)
									) {
								String message = String.format("roles required: " + String.join(", ", roles2));
								LOG.error(message);
								error(siteRequest, eventHandler, new RuntimeException(message));
							} else {

								ApiRequest apiRequest = new ApiRequest();
								apiRequest.setRows(listCurrikiResource.getRequest().getRows());
								apiRequest.setNumFound(listCurrikiResource.getQueryResponse().getResponse().getNumFound());
								apiRequest.setNumPATCH(0L);
								apiRequest.initDeepApiRequest(siteRequest);
								siteRequest.setApiRequest_(apiRequest);
								if(apiRequest.getNumFound() == 1L)
									apiRequest.setOriginal(listCurrikiResource.first());
								apiRequest.setPk(Optional.ofNullable(listCurrikiResource.first()).map(o2 -> o2.getPk()).orElse(null));
								eventBus.publish("websocketCurrikiResource", JsonObject.mapFrom(apiRequest).toString());

								listPATCHCurrikiResource(apiRequest, listCurrikiResource).onSuccess(e -> {
									response200PATCHCurrikiResource(siteRequest).onSuccess(response -> {
										LOG.debug(String.format("patchCurrikiResource succeeded. "));
										eventHandler.handle(Future.succeededFuture(response));
									}).onFailure(ex -> {
										LOG.error(String.format("patchCurrikiResource failed. "), ex);
										error(siteRequest, eventHandler, ex);
									});
								}).onFailure(ex -> {
									LOG.error(String.format("patchCurrikiResource failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							}
						} catch(Exception ex) {
							LOG.error(String.format("patchCurrikiResource failed. "), ex);
							error(siteRequest, eventHandler, ex);
						}
					}).onFailure(ex -> {
						LOG.error(String.format("patchCurrikiResource failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("patchCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || "invalid_grant: Refresh token expired".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("patchCurrikiResource failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("patchCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<Void> listPATCHCurrikiResource(ApiRequest apiRequest, SearchList<CurrikiResource> listCurrikiResource) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		SiteRequestEnUS siteRequest = listCurrikiResource.getSiteRequest_(SiteRequestEnUS.class);
		listCurrikiResource.getList().forEach(o -> {
			SiteRequestEnUS siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequestEnUS.class);
			o.setSiteRequest_(siteRequest2);
			futures.add(Future.future(promise1 -> {
				patchCurrikiResourceFuture(o, false).onSuccess(a -> {
					promise1.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("listPATCHCurrikiResource failed. "), ex);
					promise1.fail(ex);
				});
			}));
		});
		CompositeFuture.all(futures).onSuccess( a -> {
			if(apiRequest != null) {
				apiRequest.setNumPATCH(apiRequest.getNumPATCH() + listCurrikiResource.getQueryResponse().getResponse().getDocs().size());
				if(apiRequest.getNumFound() == 1L)
					listCurrikiResource.first().apiRequestCurrikiResource();
				eventBus.publish("websocketCurrikiResource", JsonObject.mapFrom(apiRequest).toString());
			}
			listCurrikiResource.next().onSuccess(next -> {
				if(next) {
					listPATCHCurrikiResource(apiRequest, listCurrikiResource);
				} else {
					promise.complete();
				}
			}).onFailure(ex -> {
				LOG.error(String.format("listPATCHCurrikiResource failed. "), ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			LOG.error(String.format("listPATCHCurrikiResource failed. "), ex);
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override
	public void patchCurrikiResourceFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, "ActiveLearningStudio-API-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);
				serviceRequest.getParams().getJsonObject("query").put("rows", 1);
				searchCurrikiResourceList(siteRequest, false, true, true).onSuccess(listCurrikiResource -> {
					try {
						CurrikiResource o = listCurrikiResource.first();
						if(o != null && listCurrikiResource.getQueryResponse().getResponse().getNumFound() == 1) {
							ApiRequest apiRequest = new ApiRequest();
							apiRequest.setRows(1L);
							apiRequest.setNumFound(1L);
							apiRequest.setNumPATCH(0L);
							apiRequest.initDeepApiRequest(siteRequest);
							siteRequest.setApiRequest_(apiRequest);
							if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
								siteRequest.getRequestVars().put( "refresh", "false" );
							}
							if(apiRequest.getNumFound() == 1L)
								apiRequest.setOriginal(o);
							apiRequest.setPk(Optional.ofNullable(listCurrikiResource.first()).map(o2 -> o2.getPk()).orElse(null));
							eventBus.publish("websocketCurrikiResource", JsonObject.mapFrom(apiRequest).toString());
							patchCurrikiResourceFuture(o, false).onSuccess(a -> {
								eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
							}).onFailure(ex -> {
								eventHandler.handle(Future.failedFuture(ex));
							});
						} else {
							eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
						}
					} catch(Exception ex) {
						LOG.error(String.format("patchCurrikiResource failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("patchCurrikiResource failed. "), ex);
					error(siteRequest, eventHandler, ex);
				});
			} catch(Exception ex) {
				LOG.error(String.format("patchCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			LOG.error(String.format("patchCurrikiResource failed. "), ex);
			error(null, eventHandler, ex);
		});
	}

	public Future<CurrikiResource> patchCurrikiResourceFuture(CurrikiResource o, Boolean inheritPk) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		Promise<CurrikiResource> promise = Promise.promise();

		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			pgPool.withTransaction(sqlConnection -> {
				Promise<CurrikiResource> promise1 = Promise.promise();
				siteRequest.setSqlConnection(sqlConnection);
				sqlPATCHCurrikiResource(o, inheritPk).onSuccess(currikiResource -> {
					defineCurrikiResource(currikiResource).onSuccess(c -> {
						relateCurrikiResource(currikiResource).onSuccess(d -> {
							indexCurrikiResource(currikiResource).onSuccess(e -> {
								promise1.complete(currikiResource);
							}).onFailure(ex -> {
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							promise1.fail(ex);
						});
					}).onFailure(ex -> {
						promise1.fail(ex);
					});
				}).onFailure(ex -> {
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				siteRequest.setSqlConnection(null);
				promise.fail(ex);
			}).compose(currikiResource -> {
				Promise<CurrikiResource> promise2 = Promise.promise();
				refreshCurrikiResource(currikiResource).onSuccess(a -> {
					promise2.complete(currikiResource);
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(currikiResource -> {
				promise.complete(currikiResource);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("patchCurrikiResourceFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<CurrikiResource> sqlPATCHCurrikiResource(CurrikiResource o, Boolean inheritPk) {
		Promise<CurrikiResource> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE CurrikiResource SET ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			Set<String> methodNames = jsonObject.fieldNames();
			CurrikiResource o2 = new CurrikiResource();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			for(String entityVar : methodNames) {
				switch(entityVar) {
					case "setInheritPk":
							o2.setInheritPk(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_inheritPk + "=$" + num);
							num++;
							bParams.add(o2.sqlInheritPk());
						break;
					case "setArchived":
							o2.setArchived(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_archived + "=$" + num);
							num++;
							bParams.add(o2.sqlArchived());
						break;
					case "setDeleted":
							o2.setDeleted(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_deleted + "=$" + num);
							num++;
							bParams.add(o2.sqlDeleted());
						break;
					case "setResourceId":
							o2.setResourceId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_resourceId + "=$" + num);
							num++;
							bParams.add(o2.sqlResourceId());
						break;
					case "setLicenseId":
							o2.setLicenseId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_licenseId + "=$" + num);
							num++;
							bParams.add(o2.sqlLicenseId());
						break;
					case "setContributorId":
							o2.setContributorId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_contributorId + "=$" + num);
							num++;
							bParams.add(o2.sqlContributorId());
						break;
					case "setContributionDate":
							o2.setContributionDate(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_contributionDate + "=$" + num);
							num++;
							bParams.add(o2.sqlContributionDate());
						break;
					case "setDescription":
							o2.setDescription(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_description + "=$" + num);
							num++;
							bParams.add(o2.sqlDescription());
						break;
					case "setTitle":
							o2.setTitle(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_title + "=$" + num);
							num++;
							bParams.add(o2.sqlTitle());
						break;
					case "setKeywordsStr":
							o2.setKeywordsStr(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_keywordsStr + "=$" + num);
							num++;
							bParams.add(o2.sqlKeywordsStr());
						break;
					case "setGeneratedKeywordsStr":
							o2.setGeneratedKeywordsStr(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_generatedKeywordsStr + "=$" + num);
							num++;
							bParams.add(o2.sqlGeneratedKeywordsStr());
						break;
					case "setLanguage":
							o2.setLanguage(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_language + "=$" + num);
							num++;
							bParams.add(o2.sqlLanguage());
						break;
					case "setLastEditorId":
							o2.setLastEditorId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_lastEditorId + "=$" + num);
							num++;
							bParams.add(o2.sqlLastEditorId());
						break;
					case "setLastEditDate":
							o2.setLastEditDate(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_lastEditDate + "=$" + num);
							num++;
							bParams.add(o2.sqlLastEditDate());
						break;
					case "setCurrikiLicense":
							o2.setCurrikiLicense(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_currikiLicense + "=$" + num);
							num++;
							bParams.add(o2.sqlCurrikiLicense());
						break;
					case "setExternalUrl":
							o2.setExternalUrl(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_externalUrl + "=$" + num);
							num++;
							bParams.add(o2.sqlExternalUrl());
						break;
					case "setResourceChecked":
							o2.setResourceChecked(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_resourceChecked + "=$" + num);
							num++;
							bParams.add(o2.sqlResourceChecked());
						break;
					case "setContent":
							o2.setContent(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_content + "=$" + num);
							num++;
							bParams.add(o2.sqlContent());
						break;
					case "setResourceCheckRequestNote":
							o2.setResourceCheckRequestNote(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_resourceCheckRequestNote + "=$" + num);
							num++;
							bParams.add(o2.sqlResourceCheckRequestNote());
						break;
					case "setResourceCheckDate":
							o2.setResourceCheckDate(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_resourceCheckDate + "=$" + num);
							num++;
							bParams.add(o2.sqlResourceCheckDate());
						break;
					case "setResourceCheckId":
							o2.setResourceCheckId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_resourceCheckId + "=$" + num);
							num++;
							bParams.add(o2.sqlResourceCheckId());
						break;
					case "setResourceCheckNote":
							o2.setResourceCheckNote(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_resourceCheckNote + "=$" + num);
							num++;
							bParams.add(o2.sqlResourceCheckNote());
						break;
					case "setStudentFacing":
							o2.setStudentFacing(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_studentFacing + "=$" + num);
							num++;
							bParams.add(o2.sqlStudentFacing());
						break;
					case "setSource":
							o2.setSource(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_source + "=$" + num);
							num++;
							bParams.add(o2.sqlSource());
						break;
					case "setReviewStatus":
							o2.setReviewStatus(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_reviewStatus + "=$" + num);
							num++;
							bParams.add(o2.sqlReviewStatus());
						break;
					case "setLastReviewDate":
							o2.setLastReviewDate(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_lastReviewDate + "=$" + num);
							num++;
							bParams.add(o2.sqlLastReviewDate());
						break;
					case "setReviewByID":
							o2.setReviewByID(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_reviewByID + "=$" + num);
							num++;
							bParams.add(o2.sqlReviewByID());
						break;
					case "setReviewRating":
							o2.setReviewRating(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_reviewRating + "=$" + num);
							num++;
							bParams.add(o2.sqlReviewRating());
						break;
					case "setTechnicalCompleteness":
							o2.setTechnicalCompleteness(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_technicalCompleteness + "=$" + num);
							num++;
							bParams.add(o2.sqlTechnicalCompleteness());
						break;
					case "setContentAccuracy":
							o2.setContentAccuracy(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_contentAccuracy + "=$" + num);
							num++;
							bParams.add(o2.sqlContentAccuracy());
						break;
					case "setPedagogy":
							o2.setPedagogy(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_pedagogy + "=$" + num);
							num++;
							bParams.add(o2.sqlPedagogy());
						break;
					case "setRatingComment":
							o2.setRatingComment(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_ratingComment + "=$" + num);
							num++;
							bParams.add(o2.sqlRatingComment());
						break;
					case "setStandardsAlignment":
							o2.setStandardsAlignment(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_standardsAlignment + "=$" + num);
							num++;
							bParams.add(o2.sqlStandardsAlignment());
						break;
					case "setStandardsAlignmentComment":
							o2.setStandardsAlignmentComment(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_standardsAlignmentComment + "=$" + num);
							num++;
							bParams.add(o2.sqlStandardsAlignmentComment());
						break;
					case "setSubjectMatter":
							o2.setSubjectMatter(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_subjectMatter + "=$" + num);
							num++;
							bParams.add(o2.sqlSubjectMatter());
						break;
					case "setSubjectMatterComment":
							o2.setSubjectMatterComment(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_subjectMatterComment + "=$" + num);
							num++;
							bParams.add(o2.sqlSubjectMatterComment());
						break;
					case "setSupportsTeaching":
							o2.setSupportsTeaching(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_supportsTeaching + "=$" + num);
							num++;
							bParams.add(o2.sqlSupportsTeaching());
						break;
					case "setSupportsTeachingComment":
							o2.setSupportsTeachingComment(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_supportsTeachingComment + "=$" + num);
							num++;
							bParams.add(o2.sqlSupportsTeachingComment());
						break;
					case "setAssessmentsQuality":
							o2.setAssessmentsQuality(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_assessmentsQuality + "=$" + num);
							num++;
							bParams.add(o2.sqlAssessmentsQuality());
						break;
					case "setAssessmentsQualityComment":
							o2.setAssessmentsQualityComment(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_assessmentsQualityComment + "=$" + num);
							num++;
							bParams.add(o2.sqlAssessmentsQualityComment());
						break;
					case "setInteractivityQuality":
							o2.setInteractivityQuality(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_interactivityQuality + "=$" + num);
							num++;
							bParams.add(o2.sqlInteractivityQuality());
						break;
					case "setInteractivityQualityComment":
							o2.setInteractivityQualityComment(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_interactivityQualityComment + "=$" + num);
							num++;
							bParams.add(o2.sqlInteractivityQualityComment());
						break;
					case "setInstructionalQuality":
							o2.setInstructionalQuality(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_instructionalQuality + "=$" + num);
							num++;
							bParams.add(o2.sqlInstructionalQuality());
						break;
					case "setInstructionalQualityComment":
							o2.setInstructionalQualityComment(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_instructionalQualityComment + "=$" + num);
							num++;
							bParams.add(o2.sqlInstructionalQualityComment());
						break;
					case "setDeeperLearning":
							o2.setDeeperLearning(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_deeperLearning + "=$" + num);
							num++;
							bParams.add(o2.sqlDeeperLearning());
						break;
					case "setDeeperLearningComment":
							o2.setDeeperLearningComment(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_deeperLearningComment + "=$" + num);
							num++;
							bParams.add(o2.sqlDeeperLearningComment());
						break;
					case "setPartner":
							o2.setPartner(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_partner + "=$" + num);
							num++;
							bParams.add(o2.sqlPartner());
						break;
					case "setCreateDate":
							o2.setCreateDate(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_createDate + "=$" + num);
							num++;
							bParams.add(o2.sqlCreateDate());
						break;
					case "setType":
							o2.setType(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_type + "=$" + num);
							num++;
							bParams.add(o2.sqlType());
						break;
					case "setFeatured":
							o2.setFeatured(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_featured + "=$" + num);
							num++;
							bParams.add(o2.sqlFeatured());
						break;
					case "setPage":
							o2.setPage(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_page + "=$" + num);
							num++;
							bParams.add(o2.sqlPage());
						break;
					case "setActive":
							o2.setActive(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_active + "=$" + num);
							num++;
							bParams.add(o2.sqlActive());
						break;
					case "setPublic":
							o2.setPublic(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_Public + "=$" + num);
							num++;
							bParams.add(o2.sqlPublic());
						break;
					case "setXwd_id":
							o2.setXwd_id(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_xwd_id + "=$" + num);
							num++;
							bParams.add(o2.sqlXwd_id());
						break;
					case "setMediaType":
							o2.setMediaType(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_mediaType + "=$" + num);
							num++;
							bParams.add(o2.sqlMediaType());
						break;
					case "setAccess":
							o2.setAccess(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_access + "=$" + num);
							num++;
							bParams.add(o2.sqlAccess());
						break;
					case "setMemberRating":
							o2.setMemberRating(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_memberRating + "=$" + num);
							num++;
							bParams.add(o2.sqlMemberRating());
						break;
					case "setAligned":
							o2.setAligned(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_aligned + "=$" + num);
							num++;
							bParams.add(o2.sqlAligned());
						break;
					case "setPageUrl":
							o2.setPageUrl(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_pageUrl + "=$" + num);
							num++;
							bParams.add(o2.sqlPageUrl());
						break;
					case "setIndexed":
							o2.setIndexed(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_indexed + "=$" + num);
							num++;
							bParams.add(o2.sqlIndexed());
						break;
					case "setLastIndexDate":
							o2.setLastIndexDate(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_lastIndexDate + "=$" + num);
							num++;
							bParams.add(o2.sqlLastIndexDate());
						break;
					case "setIndexRequired":
							o2.setIndexRequired(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_indexRequired + "=$" + num);
							num++;
							bParams.add(o2.sqlIndexRequired());
						break;
					case "setIndexRequiredDate":
							o2.setIndexRequiredDate(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_indexRequiredDate + "=$" + num);
							num++;
							bParams.add(o2.sqlIndexRequiredDate());
						break;
					case "setRescrape":
							o2.setRescrape(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_rescrape + "=$" + num);
							num++;
							bParams.add(o2.sqlRescrape());
						break;
					case "setGoButton":
							o2.setGoButton(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_goButton + "=$" + num);
							num++;
							bParams.add(o2.sqlGoButton());
						break;
					case "setDownloadButton":
							o2.setDownloadButton(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_downloadButton + "=$" + num);
							num++;
							bParams.add(o2.sqlDownloadButton());
						break;
					case "setTopOfSearch":
							o2.setTopOfSearch(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_topOfSearch + "=$" + num);
							num++;
							bParams.add(o2.sqlTopOfSearch());
						break;
					case "setRemove":
							o2.setRemove(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_remove + "=$" + num);
							num++;
							bParams.add(o2.sqlRemove());
						break;
					case "setSpam":
							o2.setSpam(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_spam + "=$" + num);
							num++;
							bParams.add(o2.sqlSpam());
						break;
					case "setTopOfSearchInt":
							o2.setTopOfSearchInt(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_topOfSearchInt + "=$" + num);
							num++;
							bParams.add(o2.sqlTopOfSearchInt());
						break;
					case "setPartnerInt":
							o2.setPartnerInt(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_partnerInt + "=$" + num);
							num++;
							bParams.add(o2.sqlPartnerInt());
						break;
					case "setReviewResource":
							o2.setReviewResource(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_reviewResource + "=$" + num);
							num++;
							bParams.add(o2.sqlReviewResource());
						break;
					case "setOldUrl":
							o2.setOldUrl(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_oldUrl + "=$" + num);
							num++;
							bParams.add(o2.sqlOldUrl());
						break;
					case "setContentDisplayOk":
							o2.setContentDisplayOk(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_contentDisplayOk + "=$" + num);
							num++;
							bParams.add(o2.sqlContentDisplayOk());
						break;
					case "setMetadata":
							o2.setMetadata(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_metadata + "=$" + num);
							num++;
							bParams.add(o2.sqlMetadata());
						break;
					case "setApprovalStatus":
							o2.setApprovalStatus(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_approvalStatus + "=$" + num);
							num++;
							bParams.add(o2.sqlApprovalStatus());
						break;
					case "setApprovalStatusDate":
							o2.setApprovalStatusDate(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_approvalStatusDate + "=$" + num);
							num++;
							bParams.add(o2.sqlApprovalStatusDate());
						break;
					case "setSpamUser":
							o2.setSpamUser(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(CurrikiResource.VAR_spamUser + "=$" + num);
							num++;
							bParams.add(o2.sqlSpamUser());
						break;
				}
			}
			bSql.append(" WHERE pk=$" + num);
			if(bParams.size() > 0) {
				bParams.add(pk);
				num++;
				futures2.add(0, Future.future(a -> {
					sqlConnection.preparedQuery(bSql.toString())
							.execute(Tuple.tuple(bParams)
							).onSuccess(b -> {
						a.handle(Future.succeededFuture());
					}).onFailure(ex -> {
						RuntimeException ex2 = new RuntimeException("value CurrikiResource failed", ex);
						LOG.error(String.format("relateCurrikiResource failed. "), ex2);
						a.handle(Future.failedFuture(ex2));
					});
				}));
			}
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					CurrikiResource o3 = new CurrikiResource();
					o3.setSiteRequest_(o.getSiteRequest_());
					o3.setPk(pk);
					promise.complete(o3);
				}).onFailure(ex -> {
					LOG.error(String.format("sqlPATCHCurrikiResource failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPATCHCurrikiResource failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPATCHCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}


	public Future<ServiceResponse> response200PATCHCurrikiResource(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200PATCHCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// POST //

	@Override
	public void postCurrikiResource(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("postCurrikiResource started. "));
		user(serviceRequest, SiteRequestEnUS.class, "ActiveLearningStudio-API-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);

				List<String> roles = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_REQUIRED + "_CurrikiResource")).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
				if(
						!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
						) {
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED", 
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", "roles required: " + String.join(", ", roles))
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					ApiRequest apiRequest = new ApiRequest();
					apiRequest.setRows(1L);
					apiRequest.setNumFound(1L);
					apiRequest.setNumPATCH(0L);
					apiRequest.initDeepApiRequest(siteRequest);
					siteRequest.setApiRequest_(apiRequest);
					eventBus.publish("websocketCurrikiResource", JsonObject.mapFrom(apiRequest).toString());
					JsonObject params = new JsonObject();
					params.put("body", siteRequest.getJsonObject());
					params.put("path", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("header", new JsonObject());
					params.put("form", new JsonObject());
					JsonObject query = new JsonObject();
					Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
					Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					if(softCommit)
						query.put("softCommit", softCommit);
					if(commitWithin != null)
						query.put("commitWithin", commitWithin);
					params.put("query", query);
					JsonObject context = new JsonObject().put("params", params).put("user", Optional.ofNullable(siteRequest.getUser()).map(user -> user.attributes().getJsonObject("tokenPrincipal")).orElse(null));
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request("ActiveLearningStudio-API-enUS-CurrikiResource", json, new DeliveryOptions().addHeader("action", "postCurrikiResourceFuture")).onSuccess(a -> {
						JsonObject responseMessage = (JsonObject)a.body();
						JsonObject responseBody = new JsonObject(new String(Base64.getDecoder().decode(responseMessage.getString("payload")), Charset.forName("UTF-8")));
						apiRequest.setPk(Long.parseLong(responseBody.getString("pk")));
						eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(responseBody.encodePrettily()))));
						LOG.debug(String.format("postCurrikiResource succeeded. "));
					}).onFailure(ex -> {
						LOG.error(String.format("postCurrikiResource failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("postCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || "invalid_grant: Refresh token expired".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("postCurrikiResource failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("postCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	@Override
	public void postCurrikiResourceFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, "ActiveLearningStudio-API-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			ApiRequest apiRequest = new ApiRequest();
			apiRequest.setRows(1L);
			apiRequest.setNumFound(1L);
			apiRequest.setNumPATCH(0L);
			apiRequest.initDeepApiRequest(siteRequest);
			siteRequest.setApiRequest_(apiRequest);
			if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
				siteRequest.getRequestVars().put( "refresh", "false" );
			}
			postCurrikiResourceFuture(siteRequest, false).onSuccess(o -> {
				eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
			}).onFailure(ex -> {
				eventHandler.handle(Future.failedFuture(ex));
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || "invalid_grant: Refresh token expired".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("postCurrikiResource failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("postCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<CurrikiResource> postCurrikiResourceFuture(SiteRequestEnUS siteRequest, Boolean inheritPk) {
		Promise<CurrikiResource> promise = Promise.promise();

		try {
			pgPool.withTransaction(sqlConnection -> {
				Promise<CurrikiResource> promise1 = Promise.promise();
				siteRequest.setSqlConnection(sqlConnection);
				createCurrikiResource(siteRequest).onSuccess(currikiResource -> {
					sqlPOSTCurrikiResource(currikiResource, inheritPk).onSuccess(b -> {
						defineCurrikiResource(currikiResource).onSuccess(c -> {
							relateCurrikiResource(currikiResource).onSuccess(d -> {
								indexCurrikiResource(currikiResource).onSuccess(e -> {
									promise1.complete(currikiResource);
								}).onFailure(ex -> {
									promise1.fail(ex);
								});
							}).onFailure(ex -> {
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							promise1.fail(ex);
						});
					}).onFailure(ex -> {
						promise1.fail(ex);
					});
				}).onFailure(ex -> {
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				siteRequest.setSqlConnection(null);
				promise.fail(ex);
			}).compose(currikiResource -> {
				Promise<CurrikiResource> promise2 = Promise.promise();
				refreshCurrikiResource(currikiResource).onSuccess(a -> {
					try {
						ApiRequest apiRequest = siteRequest.getApiRequest_();
						if(apiRequest != null) {
							apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
							currikiResource.apiRequestCurrikiResource();
							eventBus.publish("websocketCurrikiResource", JsonObject.mapFrom(apiRequest).toString());
						}
						promise2.complete(currikiResource);
					} catch(Exception ex) {
						LOG.error(String.format("postCurrikiResourceFuture failed. "), ex);
						promise.fail(ex);
					}
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(currikiResource -> {
				promise.complete(currikiResource);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("postCurrikiResourceFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> sqlPOSTCurrikiResource(CurrikiResource o, Boolean inheritPk) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE CurrikiResource SET ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			CurrikiResource o2 = new CurrikiResource();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			if(siteRequest.getSessionId() != null) {
				if(bParams.size() > 0) {
					bSql.append(", ");
				}
				bSql.append("sessionId=$" + num);
				num++;
				bParams.add(siteRequest.getSessionId());
			}
			if(siteRequest.getUserKey() != null) {
				if(bParams.size() > 0) {
					bSql.append(", ");
				}
				bSql.append("userKey=$" + num);
				num++;
				bParams.add(siteRequest.getUserKey());
			}

			if(jsonObject != null) {
				Set<String> entityVars = jsonObject.fieldNames();
				for(String entityVar : entityVars) {
					switch(entityVar) {
					case CurrikiResource.VAR_inheritPk:
						o2.setInheritPk(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_inheritPk + "=$" + num);
						num++;
						bParams.add(o2.sqlInheritPk());
						break;
					case CurrikiResource.VAR_created:
						o2.setCreated(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_created + "=$" + num);
						num++;
						bParams.add(o2.sqlCreated());
						break;
					case CurrikiResource.VAR_archived:
						o2.setArchived(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_archived + "=$" + num);
						num++;
						bParams.add(o2.sqlArchived());
						break;
					case CurrikiResource.VAR_deleted:
						o2.setDeleted(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_deleted + "=$" + num);
						num++;
						bParams.add(o2.sqlDeleted());
						break;
					case CurrikiResource.VAR_sessionId:
						o2.setSessionId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_sessionId + "=$" + num);
						num++;
						bParams.add(o2.sqlSessionId());
						break;
					case CurrikiResource.VAR_userKey:
						o2.setUserKey(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_userKey + "=$" + num);
						num++;
						bParams.add(o2.sqlUserKey());
						break;
					case CurrikiResource.VAR_resourceId:
						o2.setResourceId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_resourceId + "=$" + num);
						num++;
						bParams.add(o2.sqlResourceId());
						break;
					case CurrikiResource.VAR_licenseId:
						o2.setLicenseId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_licenseId + "=$" + num);
						num++;
						bParams.add(o2.sqlLicenseId());
						break;
					case CurrikiResource.VAR_contributorId:
						o2.setContributorId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_contributorId + "=$" + num);
						num++;
						bParams.add(o2.sqlContributorId());
						break;
					case CurrikiResource.VAR_contributionDate:
						o2.setContributionDate(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_contributionDate + "=$" + num);
						num++;
						bParams.add(o2.sqlContributionDate());
						break;
					case CurrikiResource.VAR_description:
						o2.setDescription(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_description + "=$" + num);
						num++;
						bParams.add(o2.sqlDescription());
						break;
					case CurrikiResource.VAR_title:
						o2.setTitle(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_title + "=$" + num);
						num++;
						bParams.add(o2.sqlTitle());
						break;
					case CurrikiResource.VAR_keywordsStr:
						o2.setKeywordsStr(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_keywordsStr + "=$" + num);
						num++;
						bParams.add(o2.sqlKeywordsStr());
						break;
					case CurrikiResource.VAR_generatedKeywordsStr:
						o2.setGeneratedKeywordsStr(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_generatedKeywordsStr + "=$" + num);
						num++;
						bParams.add(o2.sqlGeneratedKeywordsStr());
						break;
					case CurrikiResource.VAR_language:
						o2.setLanguage(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_language + "=$" + num);
						num++;
						bParams.add(o2.sqlLanguage());
						break;
					case CurrikiResource.VAR_lastEditorId:
						o2.setLastEditorId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_lastEditorId + "=$" + num);
						num++;
						bParams.add(o2.sqlLastEditorId());
						break;
					case CurrikiResource.VAR_lastEditDate:
						o2.setLastEditDate(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_lastEditDate + "=$" + num);
						num++;
						bParams.add(o2.sqlLastEditDate());
						break;
					case CurrikiResource.VAR_currikiLicense:
						o2.setCurrikiLicense(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_currikiLicense + "=$" + num);
						num++;
						bParams.add(o2.sqlCurrikiLicense());
						break;
					case CurrikiResource.VAR_externalUrl:
						o2.setExternalUrl(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_externalUrl + "=$" + num);
						num++;
						bParams.add(o2.sqlExternalUrl());
						break;
					case CurrikiResource.VAR_resourceChecked:
						o2.setResourceChecked(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_resourceChecked + "=$" + num);
						num++;
						bParams.add(o2.sqlResourceChecked());
						break;
					case CurrikiResource.VAR_content:
						o2.setContent(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_content + "=$" + num);
						num++;
						bParams.add(o2.sqlContent());
						break;
					case CurrikiResource.VAR_resourceCheckRequestNote:
						o2.setResourceCheckRequestNote(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_resourceCheckRequestNote + "=$" + num);
						num++;
						bParams.add(o2.sqlResourceCheckRequestNote());
						break;
					case CurrikiResource.VAR_resourceCheckDate:
						o2.setResourceCheckDate(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_resourceCheckDate + "=$" + num);
						num++;
						bParams.add(o2.sqlResourceCheckDate());
						break;
					case CurrikiResource.VAR_resourceCheckId:
						o2.setResourceCheckId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_resourceCheckId + "=$" + num);
						num++;
						bParams.add(o2.sqlResourceCheckId());
						break;
					case CurrikiResource.VAR_resourceCheckNote:
						o2.setResourceCheckNote(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_resourceCheckNote + "=$" + num);
						num++;
						bParams.add(o2.sqlResourceCheckNote());
						break;
					case CurrikiResource.VAR_studentFacing:
						o2.setStudentFacing(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_studentFacing + "=$" + num);
						num++;
						bParams.add(o2.sqlStudentFacing());
						break;
					case CurrikiResource.VAR_source:
						o2.setSource(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_source + "=$" + num);
						num++;
						bParams.add(o2.sqlSource());
						break;
					case CurrikiResource.VAR_reviewStatus:
						o2.setReviewStatus(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_reviewStatus + "=$" + num);
						num++;
						bParams.add(o2.sqlReviewStatus());
						break;
					case CurrikiResource.VAR_lastReviewDate:
						o2.setLastReviewDate(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_lastReviewDate + "=$" + num);
						num++;
						bParams.add(o2.sqlLastReviewDate());
						break;
					case CurrikiResource.VAR_reviewByID:
						o2.setReviewByID(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_reviewByID + "=$" + num);
						num++;
						bParams.add(o2.sqlReviewByID());
						break;
					case CurrikiResource.VAR_reviewRating:
						o2.setReviewRating(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_reviewRating + "=$" + num);
						num++;
						bParams.add(o2.sqlReviewRating());
						break;
					case CurrikiResource.VAR_technicalCompleteness:
						o2.setTechnicalCompleteness(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_technicalCompleteness + "=$" + num);
						num++;
						bParams.add(o2.sqlTechnicalCompleteness());
						break;
					case CurrikiResource.VAR_contentAccuracy:
						o2.setContentAccuracy(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_contentAccuracy + "=$" + num);
						num++;
						bParams.add(o2.sqlContentAccuracy());
						break;
					case CurrikiResource.VAR_pedagogy:
						o2.setPedagogy(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_pedagogy + "=$" + num);
						num++;
						bParams.add(o2.sqlPedagogy());
						break;
					case CurrikiResource.VAR_ratingComment:
						o2.setRatingComment(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_ratingComment + "=$" + num);
						num++;
						bParams.add(o2.sqlRatingComment());
						break;
					case CurrikiResource.VAR_standardsAlignment:
						o2.setStandardsAlignment(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_standardsAlignment + "=$" + num);
						num++;
						bParams.add(o2.sqlStandardsAlignment());
						break;
					case CurrikiResource.VAR_standardsAlignmentComment:
						o2.setStandardsAlignmentComment(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_standardsAlignmentComment + "=$" + num);
						num++;
						bParams.add(o2.sqlStandardsAlignmentComment());
						break;
					case CurrikiResource.VAR_subjectMatter:
						o2.setSubjectMatter(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_subjectMatter + "=$" + num);
						num++;
						bParams.add(o2.sqlSubjectMatter());
						break;
					case CurrikiResource.VAR_subjectMatterComment:
						o2.setSubjectMatterComment(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_subjectMatterComment + "=$" + num);
						num++;
						bParams.add(o2.sqlSubjectMatterComment());
						break;
					case CurrikiResource.VAR_supportsTeaching:
						o2.setSupportsTeaching(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_supportsTeaching + "=$" + num);
						num++;
						bParams.add(o2.sqlSupportsTeaching());
						break;
					case CurrikiResource.VAR_supportsTeachingComment:
						o2.setSupportsTeachingComment(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_supportsTeachingComment + "=$" + num);
						num++;
						bParams.add(o2.sqlSupportsTeachingComment());
						break;
					case CurrikiResource.VAR_assessmentsQuality:
						o2.setAssessmentsQuality(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_assessmentsQuality + "=$" + num);
						num++;
						bParams.add(o2.sqlAssessmentsQuality());
						break;
					case CurrikiResource.VAR_assessmentsQualityComment:
						o2.setAssessmentsQualityComment(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_assessmentsQualityComment + "=$" + num);
						num++;
						bParams.add(o2.sqlAssessmentsQualityComment());
						break;
					case CurrikiResource.VAR_interactivityQuality:
						o2.setInteractivityQuality(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_interactivityQuality + "=$" + num);
						num++;
						bParams.add(o2.sqlInteractivityQuality());
						break;
					case CurrikiResource.VAR_interactivityQualityComment:
						o2.setInteractivityQualityComment(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_interactivityQualityComment + "=$" + num);
						num++;
						bParams.add(o2.sqlInteractivityQualityComment());
						break;
					case CurrikiResource.VAR_instructionalQuality:
						o2.setInstructionalQuality(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_instructionalQuality + "=$" + num);
						num++;
						bParams.add(o2.sqlInstructionalQuality());
						break;
					case CurrikiResource.VAR_instructionalQualityComment:
						o2.setInstructionalQualityComment(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_instructionalQualityComment + "=$" + num);
						num++;
						bParams.add(o2.sqlInstructionalQualityComment());
						break;
					case CurrikiResource.VAR_deeperLearning:
						o2.setDeeperLearning(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_deeperLearning + "=$" + num);
						num++;
						bParams.add(o2.sqlDeeperLearning());
						break;
					case CurrikiResource.VAR_deeperLearningComment:
						o2.setDeeperLearningComment(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_deeperLearningComment + "=$" + num);
						num++;
						bParams.add(o2.sqlDeeperLearningComment());
						break;
					case CurrikiResource.VAR_partner:
						o2.setPartner(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_partner + "=$" + num);
						num++;
						bParams.add(o2.sqlPartner());
						break;
					case CurrikiResource.VAR_createDate:
						o2.setCreateDate(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_createDate + "=$" + num);
						num++;
						bParams.add(o2.sqlCreateDate());
						break;
					case CurrikiResource.VAR_type:
						o2.setType(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_type + "=$" + num);
						num++;
						bParams.add(o2.sqlType());
						break;
					case CurrikiResource.VAR_featured:
						o2.setFeatured(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_featured + "=$" + num);
						num++;
						bParams.add(o2.sqlFeatured());
						break;
					case CurrikiResource.VAR_page:
						o2.setPage(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_page + "=$" + num);
						num++;
						bParams.add(o2.sqlPage());
						break;
					case CurrikiResource.VAR_active:
						o2.setActive(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_active + "=$" + num);
						num++;
						bParams.add(o2.sqlActive());
						break;
					case CurrikiResource.VAR_Public:
						o2.setPublic(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_Public + "=$" + num);
						num++;
						bParams.add(o2.sqlPublic());
						break;
					case CurrikiResource.VAR_xwd_id:
						o2.setXwd_id(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_xwd_id + "=$" + num);
						num++;
						bParams.add(o2.sqlXwd_id());
						break;
					case CurrikiResource.VAR_mediaType:
						o2.setMediaType(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_mediaType + "=$" + num);
						num++;
						bParams.add(o2.sqlMediaType());
						break;
					case CurrikiResource.VAR_access:
						o2.setAccess(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_access + "=$" + num);
						num++;
						bParams.add(o2.sqlAccess());
						break;
					case CurrikiResource.VAR_memberRating:
						o2.setMemberRating(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_memberRating + "=$" + num);
						num++;
						bParams.add(o2.sqlMemberRating());
						break;
					case CurrikiResource.VAR_aligned:
						o2.setAligned(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_aligned + "=$" + num);
						num++;
						bParams.add(o2.sqlAligned());
						break;
					case CurrikiResource.VAR_pageUrl:
						o2.setPageUrl(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_pageUrl + "=$" + num);
						num++;
						bParams.add(o2.sqlPageUrl());
						break;
					case CurrikiResource.VAR_indexed:
						o2.setIndexed(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_indexed + "=$" + num);
						num++;
						bParams.add(o2.sqlIndexed());
						break;
					case CurrikiResource.VAR_lastIndexDate:
						o2.setLastIndexDate(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_lastIndexDate + "=$" + num);
						num++;
						bParams.add(o2.sqlLastIndexDate());
						break;
					case CurrikiResource.VAR_indexRequired:
						o2.setIndexRequired(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_indexRequired + "=$" + num);
						num++;
						bParams.add(o2.sqlIndexRequired());
						break;
					case CurrikiResource.VAR_indexRequiredDate:
						o2.setIndexRequiredDate(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_indexRequiredDate + "=$" + num);
						num++;
						bParams.add(o2.sqlIndexRequiredDate());
						break;
					case CurrikiResource.VAR_rescrape:
						o2.setRescrape(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_rescrape + "=$" + num);
						num++;
						bParams.add(o2.sqlRescrape());
						break;
					case CurrikiResource.VAR_goButton:
						o2.setGoButton(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_goButton + "=$" + num);
						num++;
						bParams.add(o2.sqlGoButton());
						break;
					case CurrikiResource.VAR_downloadButton:
						o2.setDownloadButton(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_downloadButton + "=$" + num);
						num++;
						bParams.add(o2.sqlDownloadButton());
						break;
					case CurrikiResource.VAR_topOfSearch:
						o2.setTopOfSearch(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_topOfSearch + "=$" + num);
						num++;
						bParams.add(o2.sqlTopOfSearch());
						break;
					case CurrikiResource.VAR_remove:
						o2.setRemove(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_remove + "=$" + num);
						num++;
						bParams.add(o2.sqlRemove());
						break;
					case CurrikiResource.VAR_spam:
						o2.setSpam(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_spam + "=$" + num);
						num++;
						bParams.add(o2.sqlSpam());
						break;
					case CurrikiResource.VAR_topOfSearchInt:
						o2.setTopOfSearchInt(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_topOfSearchInt + "=$" + num);
						num++;
						bParams.add(o2.sqlTopOfSearchInt());
						break;
					case CurrikiResource.VAR_partnerInt:
						o2.setPartnerInt(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_partnerInt + "=$" + num);
						num++;
						bParams.add(o2.sqlPartnerInt());
						break;
					case CurrikiResource.VAR_reviewResource:
						o2.setReviewResource(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_reviewResource + "=$" + num);
						num++;
						bParams.add(o2.sqlReviewResource());
						break;
					case CurrikiResource.VAR_oldUrl:
						o2.setOldUrl(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_oldUrl + "=$" + num);
						num++;
						bParams.add(o2.sqlOldUrl());
						break;
					case CurrikiResource.VAR_contentDisplayOk:
						o2.setContentDisplayOk(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_contentDisplayOk + "=$" + num);
						num++;
						bParams.add(o2.sqlContentDisplayOk());
						break;
					case CurrikiResource.VAR_metadata:
						o2.setMetadata(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_metadata + "=$" + num);
						num++;
						bParams.add(o2.sqlMetadata());
						break;
					case CurrikiResource.VAR_approvalStatus:
						o2.setApprovalStatus(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_approvalStatus + "=$" + num);
						num++;
						bParams.add(o2.sqlApprovalStatus());
						break;
					case CurrikiResource.VAR_approvalStatusDate:
						o2.setApprovalStatusDate(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_approvalStatusDate + "=$" + num);
						num++;
						bParams.add(o2.sqlApprovalStatusDate());
						break;
					case CurrikiResource.VAR_spamUser:
						o2.setSpamUser(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(CurrikiResource.VAR_spamUser + "=$" + num);
						num++;
						bParams.add(o2.sqlSpamUser());
						break;
					}
				}
			}
			bSql.append(" WHERE pk=$" + num);
			if(bParams.size() > 0) {
			bParams.add(pk);
			num++;
				futures2.add(0, Future.future(a -> {
					sqlConnection.preparedQuery(bSql.toString())
							.execute(Tuple.tuple(bParams)
							).onSuccess(b -> {
						a.handle(Future.succeededFuture());
					}).onFailure(ex -> {
						RuntimeException ex2 = new RuntimeException("value CurrikiResource failed", ex);
						LOG.error(String.format("relateCurrikiResource failed. "), ex2);
						a.handle(Future.failedFuture(ex2));
					});
				}));
			}
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("sqlPOSTCurrikiResource failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPOSTCurrikiResource failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPOSTCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}


	public Future<ServiceResponse> response200POSTCurrikiResource(CurrikiResource o) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			JsonObject json = JsonObject.mapFrom(o);
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200POSTCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// PUTImport //

	@Override
	public void putimportCurrikiResource(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("putimportCurrikiResource started. "));
		user(serviceRequest, SiteRequestEnUS.class, "ActiveLearningStudio-API-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);

				List<String> roles = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_REQUIRED + "_CurrikiResource")).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
				if(
						!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
						) {
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED", 
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", "roles required: " + String.join(", ", roles))
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					try {
						ApiRequest apiRequest = new ApiRequest();
						JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
						apiRequest.setRows(Long.valueOf(jsonArray.size()));
						apiRequest.setNumFound(Long.valueOf(jsonArray.size()));
						apiRequest.setNumPATCH(0L);
						apiRequest.initDeepApiRequest(siteRequest);
						siteRequest.setApiRequest_(apiRequest);
						eventBus.publish("websocketCurrikiResource", JsonObject.mapFrom(apiRequest).toString());
						varsCurrikiResource(siteRequest).onSuccess(d -> {
							listPUTImportCurrikiResource(apiRequest, siteRequest).onSuccess(e -> {
								response200PUTImportCurrikiResource(siteRequest).onSuccess(response -> {
									LOG.debug(String.format("putimportCurrikiResource succeeded. "));
									eventHandler.handle(Future.succeededFuture(response));
								}).onFailure(ex -> {
									LOG.error(String.format("putimportCurrikiResource failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							}).onFailure(ex -> {
								LOG.error(String.format("putimportCurrikiResource failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("putimportCurrikiResource failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					} catch(Exception ex) {
						LOG.error(String.format("putimportCurrikiResource failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}
			} catch(Exception ex) {
				LOG.error(String.format("putimportCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || "invalid_grant: Refresh token expired".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putimportCurrikiResource failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("putimportCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<Void> listPUTImportCurrikiResource(ApiRequest apiRequest, SiteRequestEnUS siteRequest) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
		try {
			jsonArray.forEach(obj -> {
				futures.add(Future.future(promise1 -> {
					JsonObject params = new JsonObject();
					params.put("body", obj);
					params.put("path", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("header", new JsonObject());
					params.put("form", new JsonObject());
					JsonObject query = new JsonObject();
					Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
					Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					if(softCommit)
						query.put("softCommit", softCommit);
					if(commitWithin != null)
						query.put("commitWithin", commitWithin);
					params.put("query", query);
					JsonObject context = new JsonObject().put("params", params).put("user", Optional.ofNullable(siteRequest.getUser()).map(user -> user.attributes().getJsonObject("tokenPrincipal")).orElse(null));
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request("ActiveLearningStudio-API-enUS-CurrikiResource", json, new DeliveryOptions().addHeader("action", "putimportCurrikiResourceFuture")).onSuccess(a -> {
						promise1.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listPUTImportCurrikiResource failed. "), ex);
						promise1.fail(ex);
					});
				}));
			});
			CompositeFuture.all(futures).onSuccess(a -> {
				apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(String.format("listPUTImportCurrikiResource failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("listPUTImportCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	@Override
	public void putimportCurrikiResourceFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, "ActiveLearningStudio-API-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {
				ApiRequest apiRequest = new ApiRequest();
				apiRequest.setRows(1L);
				apiRequest.setNumFound(1L);
				apiRequest.setNumPATCH(0L);
				apiRequest.initDeepApiRequest(siteRequest);
				siteRequest.setApiRequest_(apiRequest);
				body.put("inheritPk", body.getValue("pk"));
				if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
					siteRequest.getRequestVars().put( "refresh", "false" );
				}

				SearchList<CurrikiResource> searchList = new SearchList<CurrikiResource>();
				searchList.setStore(true);
				searchList.q("*:*");
				searchList.setC(CurrikiResource.class);
				searchList.fq("deleted_docvalues_boolean:false");
				searchList.fq("archived_docvalues_boolean:false");
				searchList.fq("inheritPk_docvalues_string:" + SearchTool.escapeQueryChars(body.getString("pk")));
				searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
					try {
						if(searchList.size() >= 1) {
							CurrikiResource o = searchList.getList().stream().findFirst().orElse(null);
							CurrikiResource o2 = new CurrikiResource();
							JsonObject body2 = new JsonObject();
							for(String f : body.fieldNames()) {
								Object bodyVal = body.getValue(f);
								if(bodyVal instanceof JsonArray) {
									JsonArray bodyVals = (JsonArray)bodyVal;
									Collection<?> vals = (Collection<?>)o.obtainForClass(f);
									if(bodyVals.size() == vals.size()) {
										Boolean match = true;
										for(Object val : vals) {
											if(val != null) {
												if(!bodyVals.contains(val.toString())) {
													match = false;
													break;
												}
											} else {
												match = false;
												break;
											}
										}
										if(!match) {
											body2.put("set" + StringUtils.capitalize(f), bodyVal);
										}
									} else {
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
									}
								} else {
									o2.defineForClass(f, bodyVal);
									o2.relateForClass(f, bodyVal);
									if(!StringUtils.containsAny(f, "pk", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
								}
							}
							for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
								if(!body.fieldNames().contains(f)) {
									if(!StringUtils.containsAny(f, "pk", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
										body2.putNull("set" + StringUtils.capitalize(f));
								}
							}
							if(body2.size() > 0) {
								siteRequest.setJsonObject(body2);
								patchCurrikiResourceFuture(o, true).onSuccess(b -> {
									LOG.info("Import CurrikiResource {} succeeded, modified CurrikiResource. ", body.getValue("pk"));
									eventHandler.handle(Future.succeededFuture());
								}).onFailure(ex -> {
									LOG.error(String.format("putimportCurrikiResourceFuture failed. "), ex);
									eventHandler.handle(Future.failedFuture(ex));
								});
							} else {
								eventHandler.handle(Future.succeededFuture());
							}
						} else {
							postCurrikiResourceFuture(siteRequest, true).onSuccess(b -> {
								LOG.info("Import CurrikiResource {} succeeded, created new CurrikiResource. ", body.getValue("pk"));
								eventHandler.handle(Future.succeededFuture());
							}).onFailure(ex -> {
								LOG.error(String.format("putimportCurrikiResourceFuture failed. "), ex);
								eventHandler.handle(Future.failedFuture(ex));
							});
						}
					} catch(Exception ex) {
						LOG.error(String.format("putimportCurrikiResourceFuture failed. "), ex);
						eventHandler.handle(Future.failedFuture(ex));
					}
				}).onFailure(ex -> {
					LOG.error(String.format("putimportCurrikiResourceFuture failed. "), ex);
					eventHandler.handle(Future.failedFuture(ex));
				});
			} catch(Exception ex) {
				LOG.error(String.format("putimportCurrikiResourceFuture failed. "), ex);
				eventHandler.handle(Future.failedFuture(ex));
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || "invalid_grant: Refresh token expired".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putimportCurrikiResource failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("putimportCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<ServiceResponse> response200PUTImportCurrikiResource(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200PUTImportCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// SearchPage //

	@Override
	public void searchpageCurrikiResourceId(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		searchpageCurrikiResource(serviceRequest, eventHandler);
	}

	@Override
	public void searchpageCurrikiResource(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, "ActiveLearningStudio-API-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {

				List<String> roles = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_REQUIRED + "_CurrikiResource")).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
				List<String> roleReads = Arrays.asList("");
				if(
						!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roleReads)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roleReads)
						) {
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED", 
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", "roles required: " + String.join(", ", roles))
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					searchCurrikiResourceList(siteRequest, false, true, false).onSuccess(listCurrikiResource -> {
						response200SearchPageCurrikiResource(listCurrikiResource).onSuccess(response -> {
							eventHandler.handle(Future.succeededFuture(response));
							LOG.debug(String.format("searchpageCurrikiResource succeeded. "));
						}).onFailure(ex -> {
							LOG.error(String.format("searchpageCurrikiResource failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("searchpageCurrikiResource failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("searchpageCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || "invalid_grant: Refresh token expired".equals(ex.getMessage())) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("searchpageCurrikiResource failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("searchpageCurrikiResource failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public void searchpageCurrikiResourcePageInit(CurrikiResourcePage page, SearchList<CurrikiResource> listCurrikiResource) {
	}
	public String templateSearchPageCurrikiResource() {
		return Optional.ofNullable(config.getString(ConfigKeys.TEMPLATE_PATH)).orElse("templates") + "/enUS/CurrikiResourcePage";
	}
	public Future<ServiceResponse> response200SearchPageCurrikiResource(SearchList<CurrikiResource> listCurrikiResource) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listCurrikiResource.getSiteRequest_(SiteRequestEnUS.class);
			CurrikiResourcePage page = new CurrikiResourcePage();
			MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
			siteRequest.setRequestHeaders(requestHeaders);

			if(listCurrikiResource.size() == 1)
				siteRequest.setRequestPk(listCurrikiResource.get(0).getPk());
			page.setSearchListCurrikiResource_(listCurrikiResource);
			page.setSiteRequest_(siteRequest);
			page.promiseDeepCurrikiResourcePage(siteRequest).onSuccess(a -> {
				JsonObject json = JsonObject.mapFrom(page);
				templateEngine.render(json, templateSearchPageCurrikiResource()).onSuccess(buffer -> {
					promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("response200SearchPageCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// General //

	public Future<CurrikiResource> createCurrikiResource(SiteRequestEnUS siteRequest) {
		Promise<CurrikiResource> promise = Promise.promise();
		try {
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			String userId = siteRequest.getUserId();
			Long userKey = siteRequest.getUserKey();
			ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))))).orElse(ZonedDateTime.now(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))));

			sqlConnection.preparedQuery("INSERT INTO CurrikiResource(created, userKey) VALUES($1, $2) RETURNING pk")
					.collecting(Collectors.toList())
					.execute(Tuple.of(created.toOffsetDateTime(), userKey)).onSuccess(result -> {
				Row createLine = result.value().stream().findFirst().orElseGet(() -> null);
				Long pk = createLine.getLong(0);
				CurrikiResource o = new CurrikiResource();
				o.setPk(pk);
				o.setSiteRequest_(siteRequest);
				promise.complete(o);
			}).onFailure(ex -> {
				RuntimeException ex2 = new RuntimeException(ex);
				LOG.error("createCurrikiResource failed. ", ex2);
				promise.fail(ex2);
			});
		} catch(Exception ex) {
			LOG.error(String.format("createCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public void searchCurrikiResourceQ(SearchList<CurrikiResource> searchList, String entityVar, String valueIndexed, String varIndexed) {
		searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
		if(!"*".equals(entityVar)) {
		}
	}

	public String searchCurrikiResourceFq(SearchList<CurrikiResource> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		if(StringUtils.startsWith(valueIndexed, "[")) {
			String[] fqs = StringUtils.substringBefore(StringUtils.substringAfter(valueIndexed, "["), "]").split(" TO ");
			if(fqs.length != 2)
				throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
			String fq1 = fqs[0].equals("*") ? fqs[0] : CurrikiResource.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequestEnUS.class), fqs[0]);
			String fq2 = fqs[1].equals("*") ? fqs[1] : CurrikiResource.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequestEnUS.class), fqs[1]);
			 return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
		} else {
			return varIndexed + ":" + SearchTool.escapeQueryChars(CurrikiResource.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequestEnUS.class), valueIndexed)).replace("\\", "\\\\");
		}
	}

	public void searchCurrikiResourceSort(SearchList<CurrikiResource> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		searchList.sort(varIndexed, valueIndexed);
	}

	public void searchCurrikiResourceRows(SearchList<CurrikiResource> searchList, Long valueRows) {
			searchList.rows(valueRows != null ? valueRows : 10L);
	}

	public void searchCurrikiResourceStart(SearchList<CurrikiResource> searchList, Long valueStart) {
		searchList.start(valueStart);
	}

	public void searchCurrikiResourceVar(SearchList<CurrikiResource> searchList, String var, String value) {
		searchList.getSiteRequest_(SiteRequestEnUS.class).getRequestVars().put(var, value);
	}

	public void searchCurrikiResourceUri(SearchList<CurrikiResource> searchList) {
	}

	public Future<ServiceResponse> varsCurrikiResource(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			ServiceRequest serviceRequest = siteRequest.getServiceRequest();

			serviceRequest.getParams().getJsonObject("query").stream().filter(paramRequest -> "var".equals(paramRequest.getKey()) && paramRequest.getValue() != null).findFirst().ifPresent(paramRequest -> {
				String entityVar = null;
				String valueIndexed = null;
				Object paramValuesObject = paramRequest.getValue();
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					for(Object paramObject : paramObjects) {
						entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
						valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
						siteRequest.getRequestVars().put(entityVar, valueIndexed);
					}
				} catch(Exception ex) {
					LOG.error(String.format("searchCurrikiResource failed. "), ex);
					promise.fail(ex);
				}
			});
			promise.complete();
		} catch(Exception ex) {
			LOG.error(String.format("searchCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<SearchList<CurrikiResource>> searchCurrikiResourceList(SiteRequestEnUS siteRequest, Boolean populate, Boolean store, Boolean modify) {
		Promise<SearchList<CurrikiResource>> promise = Promise.promise();
		try {
			ServiceRequest serviceRequest = siteRequest.getServiceRequest();
			String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
			String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
			SearchList<CurrikiResource> searchList = new SearchList<CurrikiResource>();
			searchList.setPopulate(populate);
			searchList.setStore(store);
			searchList.q("*:*");
			searchList.setC(CurrikiResource.class);
			searchList.setSiteRequest_(siteRequest);
			if(entityList != null)
				searchList.fl(entityList);

			String id = serviceRequest.getParams().getJsonObject("path").getString("id");
			if(id != null && NumberUtils.isCreatable(id)) {
				searchList.fq("(pk_docvalues_long:" + SearchTool.escapeQueryChars(id) + " OR objectId_docvalues_string:" + SearchTool.escapeQueryChars(id) + ")");
			} else if(id != null) {
				searchList.fq("objectId_docvalues_string:" + SearchTool.escapeQueryChars(id));
			}

			serviceRequest.getParams().getJsonObject("query").forEach(paramRequest -> {
				String entityVar = null;
				String valueIndexed = null;
				String varIndexed = null;
				String valueSort = null;
				Long valueStart = null;
				Long valueRows = null;
				String valueCursorMark = null;
				String paramName = paramRequest.getKey();
				Object paramValuesObject = paramRequest.getValue();
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					if(paramValuesObject != null && "facet.pivot".equals(paramName)) {
						Matcher mFacetPivot = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher(StringUtils.join(paramObjects.getList().toArray(), ","));
						boolean foundFacetPivot = mFacetPivot.find();
						if(foundFacetPivot) {
							String solrLocalParams = mFacetPivot.group(1);
							String[] entityVars = mFacetPivot.group(2).trim().split(",");
							String[] varsIndexed = new String[entityVars.length];
							for(Integer i = 0; i < entityVars.length; i++) {
								entityVar = entityVars[i];
								varsIndexed[i] = CurrikiResource.varIndexedCurrikiResource(entityVar);
							}
							searchList.facetPivot((solrLocalParams == null ? "" : solrLocalParams) + StringUtils.join(varsIndexed, ","));
						}
					} else if(paramValuesObject != null) {
						for(Object paramObject : paramObjects) {
							switch(paramName) {
								case "q":
									Matcher mQ = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|\\^|$)))").matcher((String)paramObject);
									boolean foundQ = mQ.find();
									if(foundQ) {
										StringBuffer sb = new StringBuffer();
										while(foundQ) {
											entityVar = mQ.group(1).trim();
											valueIndexed = mQ.group(2).trim();
											varIndexed = CurrikiResource.varIndexedCurrikiResource(entityVar);
											String entityQ = searchCurrikiResourceFq(searchList, entityVar, valueIndexed, varIndexed);
											mQ.appendReplacement(sb, entityQ);
											foundQ = mQ.find();
										}
										mQ.appendTail(sb);
										searchList.q(sb.toString());
									}
									break;
								case "fq":
									Matcher mFq = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|$)))").matcher((String)paramObject);
									boolean foundFq = mFq.find();
									if(foundFq) {
										StringBuffer sb = new StringBuffer();
										while(foundFq) {
											entityVar = mFq.group(1).trim();
											valueIndexed = mFq.group(2).trim();
											varIndexed = CurrikiResource.varIndexedCurrikiResource(entityVar);
											String entityFq = searchCurrikiResourceFq(searchList, entityVar, valueIndexed, varIndexed);
											mFq.appendReplacement(sb, entityFq);
											foundFq = mFq.find();
										}
										mFq.appendTail(sb);
										searchList.fq(sb.toString());
									}
									break;
								case "sort":
									entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
									valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
									varIndexed = CurrikiResource.varIndexedCurrikiResource(entityVar);
									searchCurrikiResourceSort(searchList, entityVar, valueIndexed, varIndexed);
									break;
								case "start":
									valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
									searchCurrikiResourceStart(searchList, valueStart);
									break;
								case "rows":
									valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
									searchCurrikiResourceRows(searchList, valueRows);
									break;
								case "facet":
									searchList.facet((Boolean)paramObject);
									break;
								case "facet.range.start":
									String startMathStr = (String)paramObject;
									Date start = SearchTool.parseMath(startMathStr);
									searchList.facetRangeStart(start.toInstant().toString());
									break;
								case "facet.range.end":
									String endMathStr = (String)paramObject;
									Date end = SearchTool.parseMath(endMathStr);
									searchList.facetRangeEnd(end.toInstant().toString());
									break;
								case "facet.range.gap":
									String gap = (String)paramObject;
									searchList.facetRangeGap(gap);
									break;
								case "facet.range":
									Matcher mFacetRange = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
									boolean foundFacetRange = mFacetRange.find();
									if(foundFacetRange) {
										String solrLocalParams = mFacetRange.group(1);
										entityVar = mFacetRange.group(2).trim();
										varIndexed = CurrikiResource.varIndexedCurrikiResource(entityVar);
										searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
									}
									break;
								case "facet.field":
									entityVar = (String)paramObject;
									varIndexed = CurrikiResource.varIndexedCurrikiResource(entityVar);
									if(varIndexed != null)
										searchList.facetField(varIndexed);
									break;
								case "var":
									entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
									valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
									searchCurrikiResourceVar(searchList, entityVar, valueIndexed);
									break;
								case "cursorMark":
									valueCursorMark = (String)paramObject;
									searchList.cursorMark((String)paramObject);
									break;
							}
						}
						searchCurrikiResourceUri(searchList);
					}
				} catch(Exception e) {
					ExceptionUtils.rethrow(e);
				}
			});
			if("*:*".equals(searchList.getQuery()) && searchList.getSorts().size() == 0) {
				searchList.sort("created_docvalues_date", "desc");
			}
			searchCurrikiResource2(siteRequest, populate, store, modify, searchList);
			searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
				promise.complete(searchList);
			}).onFailure(ex -> {
				LOG.error(String.format("searchCurrikiResource failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("searchCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void searchCurrikiResource2(SiteRequestEnUS siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<CurrikiResource> searchList) {
	}

	public Future<Void> defineCurrikiResource(CurrikiResource o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Long pk = o.getPk();
			sqlConnection.preparedQuery("SELECT * FROM CurrikiResource WHERE pk=$1")
					.collecting(Collectors.toList())
					.execute(Tuple.of(pk)
					).onSuccess(result -> {
				try {
					for(Row definition : result.value()) {
						for(Integer i = 0; i < definition.size(); i++) {
							String columnName = definition.getColumnName(i);
							Object columnValue = definition.getValue(i);
							if(!"pk".equals(columnName)) {
								try {
									o.defineForClass(columnName, columnValue);
								} catch(Exception e) {
									LOG.error(String.format("defineCurrikiResource failed. "), e);
								}
							}
						}
					}
					promise.complete();
				} catch(Exception ex) {
					LOG.error(String.format("defineCurrikiResource failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				RuntimeException ex2 = new RuntimeException(ex);
				LOG.error(String.format("defineCurrikiResource failed. "), ex2);
				promise.fail(ex2);
			});
		} catch(Exception ex) {
			LOG.error(String.format("defineCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> relateCurrikiResource(CurrikiResource o) {
		Promise<Void> promise = Promise.promise();
			promise.complete();
		return promise.future();
	}

	public Future<Void> indexCurrikiResource(CurrikiResource o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			o.promiseDeepForClass(siteRequest).onSuccess(a -> {
				JsonObject json = new JsonObject();
				JsonObject add = new JsonObject();
				json.put("add", add);
				JsonObject doc = new JsonObject();
				add.put("doc", doc);
				o.indexCurrikiResource(doc);
				String solrHostName = siteRequest.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
				Integer solrPort = siteRequest.getConfig().getInteger(ConfigKeys.SOLR_PORT);
				String solrCollection = siteRequest.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
				Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
				Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					else if(softCommit == null)
						softCommit = false;
				String solrRequestUri = String.format("/solr/%s/update%s%s%s", solrCollection, "?overwrite=true&wt=json", softCommit ? "&softCommit=true" : "", commitWithin != null ? ("&commitWithin=" + commitWithin) : "");
				webClient.post(solrPort, solrHostName, solrRequestUri).putHeader("Content-Type", "application/json").expect(ResponsePredicate.SC_OK).sendBuffer(json.toBuffer()).onSuccess(b -> {
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("indexCurrikiResource failed. "), new RuntimeException(ex));
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("indexCurrikiResource failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("indexCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> refreshCurrikiResource(CurrikiResource o) {
		Promise<Void> promise = Promise.promise();
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Boolean refresh = !"false".equals(siteRequest.getRequestVars().get("refresh"));
			if(refresh && !Optional.ofNullable(siteRequest.getJsonObject()).map(JsonObject::isEmpty).orElse(true)) {
				List<Future> futures = new ArrayList<>();

				for(int i=0; i < pks.size(); i++) {
					Long pk2 = pks.get(i);
					String classSimpleName2 = classes.get(i);
				}

				CompositeFuture.all(futures).onSuccess(b -> {
					JsonObject params = new JsonObject();
					params.put("body", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("header", new JsonObject());
					params.put("form", new JsonObject());
					params.put("path", new JsonObject());
					JsonObject query = new JsonObject();
					Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
					Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					if(softCommit)
						query.put("softCommit", softCommit);
					if(commitWithin != null)
						query.put("commitWithin", commitWithin);
					query.put("q", "*:*").put("fq", new JsonArray().add("pk:" + o.getPk()));
					params.put("query", query);
					JsonObject context = new JsonObject().put("params", params).put("user", Optional.ofNullable(siteRequest.getUser()).map(user -> user.attributes().getJsonObject("tokenPrincipal")).orElse(null));
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request("ActiveLearningStudio-API-enUS-CurrikiResource", json, new DeliveryOptions().addHeader("action", "patchCurrikiResourceFuture")).onSuccess(c -> {
						JsonObject responseMessage = (JsonObject)c.body();
						Integer statusCode = responseMessage.getInteger("statusCode");
						if(statusCode.equals(200))
							promise.complete();
						else
							promise.fail(new RuntimeException(responseMessage.getString("statusMessage")));
					}).onFailure(ex -> {
						LOG.error("Refresh relations failed. ", ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error("Refresh relations failed. ", ex);
					promise.fail(ex);
				});
			} else {
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error(String.format("refreshCurrikiResource failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
}
