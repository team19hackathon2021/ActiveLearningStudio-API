package org.curriki.api.enus.vertx;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import java.util.HashMap;
import org.curriki.api.enus.request.SiteRequestEnUS;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.vertx.api.ApiRequest;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.curriki.api.enus.model.base.BaseModel;
import java.math.RoundingMode;
import org.slf4j.Logger;
import java.math.MathContext;
import io.vertx.core.Promise;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.curriki.api.enus.config.ConfigKeys;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.vertx.core.Future;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import java.util.Objects;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import io.vertx.core.json.JsonArray;
import org.computate.search.wrap.Wrap;
import io.vertx.core.AbstractVerticle;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.vertx.MainVerticle&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class MainVerticleGen<DEV> extends AbstractVerticle {

/*
CREATE TABLE CurrikiResource(
	pk bigserial primary key
	, inheritPk text
	, created timestamp with time zone
	, archived boolean
	, deleted boolean
	, sessionId text
	, userKey bigint
	, resourceId text
	, licenseId text
	, contributorId bigint
	, contributionDate timestamp with time zone
	, description text
	, title text
	, keywordsStr text
	, generatedKeywordsStr text
	, language text
	, lastEditorId bigint
	, lastEditDate timestamp with time zone
	, currikiLicense text
	, externalUrl text
	, resourceChecked text
	, content text
	, resourceCheckRequestNote text
	, resourceCheckDate timestamp with time zone
	, resourceCheckId bigint
	, resourceCheckNote text
	, studentFacing text
	, source text
	, reviewStatus text
	, lastReviewDate timestamp with time zone
	, reviewByID bigint
	, reviewRating decimal
	, technicalCompleteness integer
	, contentAccuracy integer
	, pedagogy integer
	, ratingComment text
	, standardsAlignment integer
	, standardsAlignmentComment text
	, subjectMatter integer
	, subjectMatterComment text
	, supportsTeaching integer
	, supportsTeachingComment text
	, assessmentsQuality integer
	, assessmentsQualityComment text
	, interactivityQuality integer
	, interactivityQualityComment text
	, instructionalQuality integer
	, instructionalQualityComment text
	, deeperLearning integer
	, deeperLearningComment text
	, partner text
	, createDate timestamp with time zone
	, type text
	, featured text
	, page text
	, active text
	, Public text
	, xwd_id integer
	, mediaType text
	, access text
	, memberRating decimal
	, aligned text
	, pageUrl text
	, indexed text
	, lastIndexDate timestamp with time zone
	, indexRequired text
	, indexRequiredDate timestamp with time zone
	, rescrape text
	, goButton text
	, downloadButton text
	, topOfSearch text
	, remove text
	, spam text
	, topOfSearchInt integer
	, partnerInt integer
	, reviewResource text
	, oldUrl text
	, contentDisplayOk text
	, metadata text
	, approvalStatus text
	, approvalStatusDate timestamp with time zone
	, spamUser text
	);
CREATE TABLE SiteUser(
	pk bigserial primary key
	, inheritPk text
	, created timestamp with time zone
	, archived boolean
	, deleted boolean
	, sessionId text
	, userKey bigint
	, userId text
	, userName text
	, userEmail text
	, userFirstName text
	, userLastName text
	, userFullName text
	);

DROP TABLE CurrikiResource CASCADE;
DROP TABLE SiteUser CASCADE;
*/

	protected static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);
	public static final String configureDataConnectionError1 = "Could not open the database client connection. ";
	public static final String configureDataConnectionError = configureDataConnectionError1;
	public static final String configureDataConnectionSuccess1 = "The database client connection was successful. ";
	public static final String configureDataConnectionSuccess = configureDataConnectionSuccess1;
	public static final String configureDataInitError1 = "Could not initialize the database. ";
	public static final String configureDataInitError = configureDataInitError1;
	public static final String configureDataInitSuccess1 = "The database was initialized successfully. ";
	public static final String configureDataInitSuccess = configureDataInitSuccess1;

	public static final String configureOpenApiError1 = "Could not configure the auth server and API. ";
	public static final String configureOpenApiError = configureOpenApiError1;
	public static final String configureOpenApiSuccess1 = "The auth server and API was configured successfully. ";
	public static final String configureOpenApiSuccess = configureOpenApiSuccess1;

	public static final String configureSharedWorkerExecutorFail1 = "Could not configure the shared worker executor. ";
	public static final String configureSharedWorkerExecutorFail = configureSharedWorkerExecutorFail1;
	public static final String configureSharedWorkerExecutorComplete1 = "The shared worker executor \"{}\" was configured successfully. ";
	public static final String configureSharedWorkerExecutorComplete = configureSharedWorkerExecutorComplete1;

	public static final String configureHealthChecksComplete1 = "The health checks were configured successfully. ";
	public static final String configureHealthChecksComplete = configureHealthChecksComplete1;
	public static final String configureHealthChecksFail1 = "Could not configure the health checks. ";
	public static final String configureHealthChecksFail = configureHealthChecksFail1;
	public static final String configureHealthChecksErrorDatabase1 = "The database is not configured properly. ";
	public static final String configureHealthChecksErrorDatabase = configureHealthChecksErrorDatabase1;
	public static final String configureHealthChecksEmptySolr1 = "The Solr search engine is empty. ";
	public static final String configureHealthChecksEmptySolr = configureHealthChecksEmptySolr1;
	public static final String configureHealthChecksErrorSolr1 = "The Solr search engine is not configured properly. ";
	public static final String configureHealthChecksErrorSolr = configureHealthChecksErrorSolr1;
	public static final String configureHealthChecksErrorVertx1 = "The Vert.x application is not configured properly. ";
	public static final String configureHealthChecksErrorVertx = configureHealthChecksErrorVertx1;

	public static final String configureWebsocketsComplete1 = "Configure websockets succeeded. ";
	public static final String configureWebsocketsComplete = configureWebsocketsComplete1;
	public static final String configureWebsocketsFail1 = "Configure websockets failed. ";
	public static final String configureWebsocketsFail = configureWebsocketsFail1;

	public static final String configureEmailComplete1 = "Configure sending email succeeded. ";
	public static final String configureEmailComplete = configureEmailComplete1;
	public static final String configureEmailFail1 = "Configure sending email failed. ";
	public static final String configureEmailFail = configureEmailFail1;

	public static final String configureApiFail1 = "The API was not configured properly. ";
	public static final String configureApiFail = configureApiFail1;
	public static final String configureApiComplete1 = "The API was configured properly. ";
	public static final String configureApiComplete = configureApiComplete1;

	public static final String configureUiFail1 = "The UI was not configured properly. ";
	public static final String configureUiFail = configureUiFail1;
	public static final String configureUiComplete1 = "The UI was configured properly. ";
	public static final String configureUiComplete = configureUiComplete1;

	public static final String startServerErrorServer1 = "The server is not configured properly. ";
	public static final String startServerErrorServer = startServerErrorServer1;
	public static final String startServerSuccessServer1 = "The HTTP server is running: %s";
	public static final String startServerSuccessServer = startServerSuccessServer1;
	public static final String startServerBeforeServer1 = "HTTP server starting: %s";
	public static final String startServerBeforeServer = startServerBeforeServer1;
	public static final String startServerSsl1 = "Configuring SSL: %s";
	public static final String startServerSsl = startServerSsl1;

	public static final String stopFail1 = "Could not close the database client connection. ";
	public static final String stopFail = stopFail1;
	public static final String stopComplete1 = "The database client connection was closed. ";
	public static final String stopComplete = stopComplete1;


	//////////////
	// initDeep //
	//////////////

	public MainVerticle initDeepMainVerticle(SiteRequestEnUS siteRequest_) {
		initDeepMainVerticle();
		return (MainVerticle)this;
	}

	public void initDeepMainVerticle() {
		initMainVerticle();
	}

	public void initMainVerticle() {
	}

	public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepMainVerticle(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainMainVerticle(v);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.obtainForClass(v);
			}
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainMainVerticle(String var) {
		MainVerticle oMainVerticle = (MainVerticle)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// relate //
	///////////////

	public boolean relateForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = relateMainVerticle(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateMainVerticle(String var, Object val) {
		MainVerticle oMainVerticle = (MainVerticle)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetMainVerticle(entityVar,  siteRequest_, o);
	}
	public static Object staticSetMainVerticle(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchMainVerticle(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchMainVerticle(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrMainVerticle(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrMainVerticle(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqMainVerticle(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqMainVerticle(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	/////////////
	// define //
	/////////////

	public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineMainVerticle(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineMainVerticle(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return null;
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	public static final String[] MainVerticleVals = new String[] { configureDataConnectionError1, configureDataConnectionSuccess1, configureDataInitError1, configureDataInitSuccess1, configureOpenApiError1, configureOpenApiSuccess1, configureSharedWorkerExecutorFail1, configureSharedWorkerExecutorComplete1, configureHealthChecksComplete1, configureHealthChecksFail1, configureHealthChecksErrorDatabase1, configureHealthChecksEmptySolr1, configureHealthChecksErrorSolr1, configureHealthChecksErrorVertx1, configureWebsocketsComplete1, configureWebsocketsFail1, configureEmailComplete1, configureEmailFail1, configureApiFail1, configureApiComplete1, configureUiFail1, configureUiComplete1, startServerErrorServer1, startServerSuccessServer1, startServerBeforeServer1, startServerSsl1, stopFail1, stopComplete1 };



	public static String displayNameForClass(String var) {
		return MainVerticle.displayNameMainVerticle(var);
	}
	public static String displayNameMainVerticle(String var) {
		switch(var) {
		default:
			return null;
		}
	}
}
