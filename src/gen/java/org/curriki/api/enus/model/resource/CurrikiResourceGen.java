package org.curriki.api.enus.model.resource;

import org.curriki.api.enus.request.SiteRequestEnUS;
import org.curriki.api.enus.model.base.BaseModel;
import io.vertx.core.json.JsonObject;
import java.util.Date;
import java.util.Set;
import org.computate.vertx.api.ApiRequest;
import org.curriki.api.enus.config.ConfigKeys;
import java.util.Optional;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.MathContext;
import org.apache.commons.lang3.math.NumberUtils;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.RoundingMode;
import java.util.Map;
import java.lang.String;
import java.lang.Long;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.util.Locale;
import java.time.OffsetDateTime;
import io.vertx.core.json.JsonArray;
import java.math.BigDecimal;
import java.lang.Integer;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource">Find the class CurrikiResource in Solr. </a>
 * <br><br>Delete the class CurrikiResource in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the package org.curriki.api.enus.model.resource in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.curriki.api.enus.model.resource&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the project ActiveLearningStudio-API in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:ActiveLearningStudio\-API&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>
 **/
public abstract class CurrikiResourceGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(CurrikiResource.class);

	public static final String CurrikiResource_AName = "a resource";
	public static final String CurrikiResource_This = "this ";
	public static final String CurrikiResource_ThisName = "this resource";
	public static final String CurrikiResource_A = "a ";
	public static final String CurrikiResource_TheName = "the resource";
	public static final String CurrikiResource_NameSingular = "resource";
	public static final String CurrikiResource_NamePlural = "resources";
	public static final String CurrikiResource_NameActual = "current resource";
	public static final String CurrikiResource_AllName = "all the resources";
	public static final String CurrikiResource_SearchAllNameBy = "search resources by ";
	public static final String CurrikiResource_Title = "resources";
	public static final String CurrikiResource_ThePluralName = "the resources";
	public static final String CurrikiResource_NoNameFound = "no resource found";
	public static final String CurrikiResource_NameVar = "resource";
	public static final String CurrikiResource_OfName = "of resource";
	public static final String CurrikiResource_ANameAdjective = "a resource";
	public static final String CurrikiResource_NameAdjectiveSingular = "resource";
	public static final String CurrikiResource_NameAdjectivePlural = "resources";
	public static final String CurrikiResource_Color = "blue";
	public static final String CurrikiResource_IconGroup = "regular";
	public static final String CurrikiResource_IconName = "file";

	////////////////
	// resourceId //
	////////////////

	/**	 The entity resourceId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String resourceId;

	/**	<br> The entity resourceId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:resourceId">Find the entity resourceId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _resourceId(Wrap<String> w);

	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String o) {
		this.resourceId = CurrikiResource.staticSetResourceId(siteRequest_, o);
	}
	public static String staticSetResourceId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource resourceIdInit() {
		Wrap<String> resourceIdWrap = new Wrap<String>().var("resourceId");
		if(resourceId == null) {
			_resourceId(resourceIdWrap);
			setResourceId(resourceIdWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchResourceId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrResourceId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqResourceId(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrResourceId(siteRequest_, CurrikiResource.staticSearchResourceId(siteRequest_, CurrikiResource.staticSetResourceId(siteRequest_, o)));
	}

	public String sqlResourceId() {
		return resourceId;
	}

	///////////////
	// licenseId //
	///////////////

	/**	 The entity licenseId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String licenseId;

	/**	<br> The entity licenseId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:licenseId">Find the entity licenseId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _licenseId(Wrap<String> w);

	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String o) {
		this.licenseId = CurrikiResource.staticSetLicenseId(siteRequest_, o);
	}
	public static String staticSetLicenseId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource licenseIdInit() {
		Wrap<String> licenseIdWrap = new Wrap<String>().var("licenseId");
		if(licenseId == null) {
			_licenseId(licenseIdWrap);
			setLicenseId(licenseIdWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchLicenseId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrLicenseId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLicenseId(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrLicenseId(siteRequest_, CurrikiResource.staticSearchLicenseId(siteRequest_, CurrikiResource.staticSetLicenseId(siteRequest_, o)));
	}

	public String sqlLicenseId() {
		return licenseId;
	}

	///////////////////
	// contributorId //
	///////////////////

	/**	 The entity contributorId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long contributorId;

	/**	<br> The entity contributorId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:contributorId">Find the entity contributorId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contributorId(Wrap<Long> w);

	public Long getContributorId() {
		return contributorId;
	}

	public void setContributorId(Long contributorId) {
		this.contributorId = contributorId;
	}
	@JsonIgnore
	public void setContributorId(String o) {
		this.contributorId = CurrikiResource.staticSetContributorId(siteRequest_, o);
	}
	public static Long staticSetContributorId(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected CurrikiResource contributorIdInit() {
		Wrap<Long> contributorIdWrap = new Wrap<Long>().var("contributorId");
		if(contributorId == null) {
			_contributorId(contributorIdWrap);
			setContributorId(contributorIdWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Long staticSearchContributorId(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrContributorId(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqContributorId(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrContributorId(siteRequest_, CurrikiResource.staticSearchContributorId(siteRequest_, CurrikiResource.staticSetContributorId(siteRequest_, o)));
	}

	public Long sqlContributorId() {
		return contributorId;
	}

	//////////////////////
	// contributionDate //
	//////////////////////

	/**	 The entity contributionDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime contributionDate;

	/**	<br> The entity contributionDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:contributionDate">Find the entity contributionDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contributionDate(Wrap<ZonedDateTime> w);

	public ZonedDateTime getContributionDate() {
		return contributionDate;
	}

	public void setContributionDate(ZonedDateTime contributionDate) {
		this.contributionDate = contributionDate;
	}
	@JsonIgnore
	public void setContributionDate(Instant o) {
		this.contributionDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setContributionDate(String o) {
		this.contributionDate = CurrikiResource.staticSetContributionDate(siteRequest_, o);
	}
	public static ZonedDateTime staticSetContributionDate(SiteRequestEnUS siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setContributionDate(Date o) {
		this.contributionDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected CurrikiResource contributionDateInit() {
		Wrap<ZonedDateTime> contributionDateWrap = new Wrap<ZonedDateTime>().var("contributionDate");
		if(contributionDate == null) {
			_contributionDate(contributionDateWrap);
			setContributionDate(contributionDateWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Date staticSearchContributionDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSearchStrContributionDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqContributionDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrContributionDate(siteRequest_, CurrikiResource.staticSearchContributionDate(siteRequest_, CurrikiResource.staticSetContributionDate(siteRequest_, o)));
	}

	public OffsetDateTime sqlContributionDate() {
		return contributionDate == null ? null : contributionDate.toOffsetDateTime();
	}

	/////////////////
	// description //
	/////////////////

	/**	 The entity description
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String description;

	/**	<br> The entity description
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:description">Find the entity description in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _description(Wrap<String> w);

	public String getDescription() {
		return description;
	}
	public void setDescription(String o) {
		this.description = CurrikiResource.staticSetDescription(siteRequest_, o);
	}
	public static String staticSetDescription(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource descriptionInit() {
		Wrap<String> descriptionWrap = new Wrap<String>().var("description");
		if(description == null) {
			_description(descriptionWrap);
			setDescription(descriptionWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchDescription(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDescription(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDescription(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrDescription(siteRequest_, CurrikiResource.staticSearchDescription(siteRequest_, CurrikiResource.staticSetDescription(siteRequest_, o)));
	}

	public String sqlDescription() {
		return description;
	}

	///////////
	// title //
	///////////

	/**	 The entity title
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String title;

	/**	<br> The entity title
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:title">Find the entity title in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _title(Wrap<String> w);

	public String getTitle() {
		return title;
	}
	public void setTitle(String o) {
		this.title = CurrikiResource.staticSetTitle(siteRequest_, o);
	}
	public static String staticSetTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource titleInit() {
		Wrap<String> titleWrap = new Wrap<String>().var("title");
		if(title == null) {
			_title(titleWrap);
			setTitle(titleWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrTitle(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTitle(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrTitle(siteRequest_, CurrikiResource.staticSearchTitle(siteRequest_, CurrikiResource.staticSetTitle(siteRequest_, o)));
	}

	public String sqlTitle() {
		return title;
	}

	/////////////////
	// keywordsStr //
	/////////////////

	/**	 The entity keywordsStr
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String keywordsStr;

	/**	<br> The entity keywordsStr
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:keywordsStr">Find the entity keywordsStr in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _keywordsStr(Wrap<String> w);

	public String getKeywordsStr() {
		return keywordsStr;
	}
	public void setKeywordsStr(String o) {
		this.keywordsStr = CurrikiResource.staticSetKeywordsStr(siteRequest_, o);
	}
	public static String staticSetKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource keywordsStrInit() {
		Wrap<String> keywordsStrWrap = new Wrap<String>().var("keywordsStr");
		if(keywordsStr == null) {
			_keywordsStr(keywordsStrWrap);
			setKeywordsStr(keywordsStrWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrKeywordsStr(siteRequest_, CurrikiResource.staticSearchKeywordsStr(siteRequest_, CurrikiResource.staticSetKeywordsStr(siteRequest_, o)));
	}

	public String sqlKeywordsStr() {
		return keywordsStr;
	}

	//////////////
	// keywords //
	//////////////

	/**	 The entity keywords
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> keywords = new ArrayList<String>();

	/**	<br> The entity keywords
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:keywords">Find the entity keywords in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _keywords(List<String> l);

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public static String staticSetKeywords(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public CurrikiResource addKeywords(String...objets) {
		for(String o : objets) {
			addKeywords(o);
		}
		return (CurrikiResource)this;
	}
	public CurrikiResource addKeywords(String o) {
		if(o != null)
			this.keywords.add(o);
		return (CurrikiResource)this;
	}
	@JsonIgnore
	public void setKeywords(JsonArray objets) {
		keywords.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addKeywords(o);
		}
	}
	protected CurrikiResource keywordsInit() {
		_keywords(keywords);
		return (CurrikiResource)this;
	}

	public static String staticSearchKeywords(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrKeywords(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqKeywords(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrKeywords(siteRequest_, CurrikiResource.staticSearchKeywords(siteRequest_, CurrikiResource.staticSetKeywords(siteRequest_, o)));
	}

	//////////////////////////
	// generatedKeywordsStr //
	//////////////////////////

	/**	 The entity generatedKeywordsStr
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String generatedKeywordsStr;

	/**	<br> The entity generatedKeywordsStr
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:generatedKeywordsStr">Find the entity generatedKeywordsStr in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _generatedKeywordsStr(Wrap<String> w);

	public String getGeneratedKeywordsStr() {
		return generatedKeywordsStr;
	}
	public void setGeneratedKeywordsStr(String o) {
		this.generatedKeywordsStr = CurrikiResource.staticSetGeneratedKeywordsStr(siteRequest_, o);
	}
	public static String staticSetGeneratedKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource generatedKeywordsStrInit() {
		Wrap<String> generatedKeywordsStrWrap = new Wrap<String>().var("generatedKeywordsStr");
		if(generatedKeywordsStr == null) {
			_generatedKeywordsStr(generatedKeywordsStrWrap);
			setGeneratedKeywordsStr(generatedKeywordsStrWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchGeneratedKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrGeneratedKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqGeneratedKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrGeneratedKeywordsStr(siteRequest_, CurrikiResource.staticSearchGeneratedKeywordsStr(siteRequest_, CurrikiResource.staticSetGeneratedKeywordsStr(siteRequest_, o)));
	}

	public String sqlGeneratedKeywordsStr() {
		return generatedKeywordsStr;
	}

	///////////////////////
	// generatedKeywords //
	///////////////////////

	/**	 The entity generatedKeywords
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> generatedKeywords = new ArrayList<String>();

	/**	<br> The entity generatedKeywords
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:generatedKeywords">Find the entity generatedKeywords in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _generatedKeywords(List<String> l);

	public List<String> getGeneratedKeywords() {
		return generatedKeywords;
	}

	public void setGeneratedKeywords(List<String> generatedKeywords) {
		this.generatedKeywords = generatedKeywords;
	}
	public static String staticSetGeneratedKeywords(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public CurrikiResource addGeneratedKeywords(String...objets) {
		for(String o : objets) {
			addGeneratedKeywords(o);
		}
		return (CurrikiResource)this;
	}
	public CurrikiResource addGeneratedKeywords(String o) {
		if(o != null)
			this.generatedKeywords.add(o);
		return (CurrikiResource)this;
	}
	@JsonIgnore
	public void setGeneratedKeywords(JsonArray objets) {
		generatedKeywords.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addGeneratedKeywords(o);
		}
	}
	protected CurrikiResource generatedKeywordsInit() {
		_generatedKeywords(generatedKeywords);
		return (CurrikiResource)this;
	}

	public static String staticSearchGeneratedKeywords(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrGeneratedKeywords(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqGeneratedKeywords(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrGeneratedKeywords(siteRequest_, CurrikiResource.staticSearchGeneratedKeywords(siteRequest_, CurrikiResource.staticSetGeneratedKeywords(siteRequest_, o)));
	}

	//////////////
	// language //
	//////////////

	/**	 The entity language
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String language;

	/**	<br> The entity language
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:language">Find the entity language in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _language(Wrap<String> w);

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String o) {
		this.language = CurrikiResource.staticSetLanguage(siteRequest_, o);
	}
	public static String staticSetLanguage(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource languageInit() {
		Wrap<String> languageWrap = new Wrap<String>().var("language");
		if(language == null) {
			_language(languageWrap);
			setLanguage(languageWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchLanguage(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrLanguage(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLanguage(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrLanguage(siteRequest_, CurrikiResource.staticSearchLanguage(siteRequest_, CurrikiResource.staticSetLanguage(siteRequest_, o)));
	}

	public String sqlLanguage() {
		return language;
	}

	//////////////////
	// lastEditorId //
	//////////////////

	/**	 The entity lastEditorId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long lastEditorId;

	/**	<br> The entity lastEditorId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:lastEditorId">Find the entity lastEditorId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _lastEditorId(Wrap<Long> w);

	public Long getLastEditorId() {
		return lastEditorId;
	}

	public void setLastEditorId(Long lastEditorId) {
		this.lastEditorId = lastEditorId;
	}
	@JsonIgnore
	public void setLastEditorId(String o) {
		this.lastEditorId = CurrikiResource.staticSetLastEditorId(siteRequest_, o);
	}
	public static Long staticSetLastEditorId(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected CurrikiResource lastEditorIdInit() {
		Wrap<Long> lastEditorIdWrap = new Wrap<Long>().var("lastEditorId");
		if(lastEditorId == null) {
			_lastEditorId(lastEditorIdWrap);
			setLastEditorId(lastEditorIdWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Long staticSearchLastEditorId(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrLastEditorId(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLastEditorId(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrLastEditorId(siteRequest_, CurrikiResource.staticSearchLastEditorId(siteRequest_, CurrikiResource.staticSetLastEditorId(siteRequest_, o)));
	}

	public Long sqlLastEditorId() {
		return lastEditorId;
	}

	//////////////////
	// lastEditDate //
	//////////////////

	/**	 The entity lastEditDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime lastEditDate;

	/**	<br> The entity lastEditDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:lastEditDate">Find the entity lastEditDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _lastEditDate(Wrap<ZonedDateTime> w);

	public ZonedDateTime getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(ZonedDateTime lastEditDate) {
		this.lastEditDate = lastEditDate;
	}
	@JsonIgnore
	public void setLastEditDate(Instant o) {
		this.lastEditDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setLastEditDate(String o) {
		this.lastEditDate = CurrikiResource.staticSetLastEditDate(siteRequest_, o);
	}
	public static ZonedDateTime staticSetLastEditDate(SiteRequestEnUS siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setLastEditDate(Date o) {
		this.lastEditDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected CurrikiResource lastEditDateInit() {
		Wrap<ZonedDateTime> lastEditDateWrap = new Wrap<ZonedDateTime>().var("lastEditDate");
		if(lastEditDate == null) {
			_lastEditDate(lastEditDateWrap);
			setLastEditDate(lastEditDateWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Date staticSearchLastEditDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSearchStrLastEditDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqLastEditDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrLastEditDate(siteRequest_, CurrikiResource.staticSearchLastEditDate(siteRequest_, CurrikiResource.staticSetLastEditDate(siteRequest_, o)));
	}

	public OffsetDateTime sqlLastEditDate() {
		return lastEditDate == null ? null : lastEditDate.toOffsetDateTime();
	}

	////////////////////
	// currikiLicense //
	////////////////////

	/**	 The entity currikiLicense
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String currikiLicense;

	/**	<br> The entity currikiLicense
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:currikiLicense">Find the entity currikiLicense in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _currikiLicense(Wrap<String> w);

	public String getCurrikiLicense() {
		return currikiLicense;
	}
	public void setCurrikiLicense(String o) {
		this.currikiLicense = CurrikiResource.staticSetCurrikiLicense(siteRequest_, o);
	}
	public static String staticSetCurrikiLicense(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource currikiLicenseInit() {
		Wrap<String> currikiLicenseWrap = new Wrap<String>().var("currikiLicense");
		if(currikiLicense == null) {
			_currikiLicense(currikiLicenseWrap);
			setCurrikiLicense(currikiLicenseWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchCurrikiLicense(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrCurrikiLicense(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCurrikiLicense(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrCurrikiLicense(siteRequest_, CurrikiResource.staticSearchCurrikiLicense(siteRequest_, CurrikiResource.staticSetCurrikiLicense(siteRequest_, o)));
	}

	public String sqlCurrikiLicense() {
		return currikiLicense;
	}

	/////////////////
	// externalUrl //
	/////////////////

	/**	 The entity externalUrl
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String externalUrl;

	/**	<br> The entity externalUrl
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:externalUrl">Find the entity externalUrl in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _externalUrl(Wrap<String> w);

	public String getExternalUrl() {
		return externalUrl;
	}
	public void setExternalUrl(String o) {
		this.externalUrl = CurrikiResource.staticSetExternalUrl(siteRequest_, o);
	}
	public static String staticSetExternalUrl(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource externalUrlInit() {
		Wrap<String> externalUrlWrap = new Wrap<String>().var("externalUrl");
		if(externalUrl == null) {
			_externalUrl(externalUrlWrap);
			setExternalUrl(externalUrlWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchExternalUrl(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrExternalUrl(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqExternalUrl(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrExternalUrl(siteRequest_, CurrikiResource.staticSearchExternalUrl(siteRequest_, CurrikiResource.staticSetExternalUrl(siteRequest_, o)));
	}

	public String sqlExternalUrl() {
		return externalUrl;
	}

	/////////////////////
	// resourceChecked //
	/////////////////////

	/**	 The entity resourceChecked
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String resourceChecked;

	/**	<br> The entity resourceChecked
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:resourceChecked">Find the entity resourceChecked in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _resourceChecked(Wrap<String> w);

	public String getResourceChecked() {
		return resourceChecked;
	}
	public void setResourceChecked(String o) {
		this.resourceChecked = CurrikiResource.staticSetResourceChecked(siteRequest_, o);
	}
	public static String staticSetResourceChecked(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource resourceCheckedInit() {
		Wrap<String> resourceCheckedWrap = new Wrap<String>().var("resourceChecked");
		if(resourceChecked == null) {
			_resourceChecked(resourceCheckedWrap);
			setResourceChecked(resourceCheckedWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchResourceChecked(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrResourceChecked(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqResourceChecked(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrResourceChecked(siteRequest_, CurrikiResource.staticSearchResourceChecked(siteRequest_, CurrikiResource.staticSetResourceChecked(siteRequest_, o)));
	}

	public String sqlResourceChecked() {
		return resourceChecked;
	}

	/////////////
	// content //
	/////////////

	/**	 The entity content
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String content;

	/**	<br> The entity content
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:content">Find the entity content in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _content(Wrap<String> w);

	public String getContent() {
		return content;
	}
	public void setContent(String o) {
		this.content = CurrikiResource.staticSetContent(siteRequest_, o);
	}
	public static String staticSetContent(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource contentInit() {
		Wrap<String> contentWrap = new Wrap<String>().var("content");
		if(content == null) {
			_content(contentWrap);
			setContent(contentWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchContent(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrContent(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqContent(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrContent(siteRequest_, CurrikiResource.staticSearchContent(siteRequest_, CurrikiResource.staticSetContent(siteRequest_, o)));
	}

	public String sqlContent() {
		return content;
	}

	//////////////////////////////
	// resourceCheckRequestNote //
	//////////////////////////////

	/**	 The entity resourceCheckRequestNote
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String resourceCheckRequestNote;

	/**	<br> The entity resourceCheckRequestNote
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:resourceCheckRequestNote">Find the entity resourceCheckRequestNote in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _resourceCheckRequestNote(Wrap<String> w);

	public String getResourceCheckRequestNote() {
		return resourceCheckRequestNote;
	}
	public void setResourceCheckRequestNote(String o) {
		this.resourceCheckRequestNote = CurrikiResource.staticSetResourceCheckRequestNote(siteRequest_, o);
	}
	public static String staticSetResourceCheckRequestNote(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource resourceCheckRequestNoteInit() {
		Wrap<String> resourceCheckRequestNoteWrap = new Wrap<String>().var("resourceCheckRequestNote");
		if(resourceCheckRequestNote == null) {
			_resourceCheckRequestNote(resourceCheckRequestNoteWrap);
			setResourceCheckRequestNote(resourceCheckRequestNoteWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchResourceCheckRequestNote(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrResourceCheckRequestNote(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqResourceCheckRequestNote(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrResourceCheckRequestNote(siteRequest_, CurrikiResource.staticSearchResourceCheckRequestNote(siteRequest_, CurrikiResource.staticSetResourceCheckRequestNote(siteRequest_, o)));
	}

	public String sqlResourceCheckRequestNote() {
		return resourceCheckRequestNote;
	}

	///////////////////////
	// resourceCheckDate //
	///////////////////////

	/**	 The entity resourceCheckDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime resourceCheckDate;

	/**	<br> The entity resourceCheckDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:resourceCheckDate">Find the entity resourceCheckDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _resourceCheckDate(Wrap<ZonedDateTime> w);

	public ZonedDateTime getResourceCheckDate() {
		return resourceCheckDate;
	}

	public void setResourceCheckDate(ZonedDateTime resourceCheckDate) {
		this.resourceCheckDate = resourceCheckDate;
	}
	@JsonIgnore
	public void setResourceCheckDate(Instant o) {
		this.resourceCheckDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setResourceCheckDate(String o) {
		this.resourceCheckDate = CurrikiResource.staticSetResourceCheckDate(siteRequest_, o);
	}
	public static ZonedDateTime staticSetResourceCheckDate(SiteRequestEnUS siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setResourceCheckDate(Date o) {
		this.resourceCheckDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected CurrikiResource resourceCheckDateInit() {
		Wrap<ZonedDateTime> resourceCheckDateWrap = new Wrap<ZonedDateTime>().var("resourceCheckDate");
		if(resourceCheckDate == null) {
			_resourceCheckDate(resourceCheckDateWrap);
			setResourceCheckDate(resourceCheckDateWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Date staticSearchResourceCheckDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSearchStrResourceCheckDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqResourceCheckDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrResourceCheckDate(siteRequest_, CurrikiResource.staticSearchResourceCheckDate(siteRequest_, CurrikiResource.staticSetResourceCheckDate(siteRequest_, o)));
	}

	public OffsetDateTime sqlResourceCheckDate() {
		return resourceCheckDate == null ? null : resourceCheckDate.toOffsetDateTime();
	}

	/////////////////////
	// resourceCheckId //
	/////////////////////

	/**	 The entity resourceCheckId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long resourceCheckId;

	/**	<br> The entity resourceCheckId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:resourceCheckId">Find the entity resourceCheckId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _resourceCheckId(Wrap<Long> w);

	public Long getResourceCheckId() {
		return resourceCheckId;
	}

	public void setResourceCheckId(Long resourceCheckId) {
		this.resourceCheckId = resourceCheckId;
	}
	@JsonIgnore
	public void setResourceCheckId(String o) {
		this.resourceCheckId = CurrikiResource.staticSetResourceCheckId(siteRequest_, o);
	}
	public static Long staticSetResourceCheckId(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected CurrikiResource resourceCheckIdInit() {
		Wrap<Long> resourceCheckIdWrap = new Wrap<Long>().var("resourceCheckId");
		if(resourceCheckId == null) {
			_resourceCheckId(resourceCheckIdWrap);
			setResourceCheckId(resourceCheckIdWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Long staticSearchResourceCheckId(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrResourceCheckId(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqResourceCheckId(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrResourceCheckId(siteRequest_, CurrikiResource.staticSearchResourceCheckId(siteRequest_, CurrikiResource.staticSetResourceCheckId(siteRequest_, o)));
	}

	public Long sqlResourceCheckId() {
		return resourceCheckId;
	}

	///////////////////////
	// resourceCheckNote //
	///////////////////////

	/**	 The entity resourceCheckNote
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String resourceCheckNote;

	/**	<br> The entity resourceCheckNote
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:resourceCheckNote">Find the entity resourceCheckNote in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _resourceCheckNote(Wrap<String> w);

	public String getResourceCheckNote() {
		return resourceCheckNote;
	}
	public void setResourceCheckNote(String o) {
		this.resourceCheckNote = CurrikiResource.staticSetResourceCheckNote(siteRequest_, o);
	}
	public static String staticSetResourceCheckNote(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource resourceCheckNoteInit() {
		Wrap<String> resourceCheckNoteWrap = new Wrap<String>().var("resourceCheckNote");
		if(resourceCheckNote == null) {
			_resourceCheckNote(resourceCheckNoteWrap);
			setResourceCheckNote(resourceCheckNoteWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchResourceCheckNote(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrResourceCheckNote(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqResourceCheckNote(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrResourceCheckNote(siteRequest_, CurrikiResource.staticSearchResourceCheckNote(siteRequest_, CurrikiResource.staticSetResourceCheckNote(siteRequest_, o)));
	}

	public String sqlResourceCheckNote() {
		return resourceCheckNote;
	}

	///////////////////
	// studentFacing //
	///////////////////

	/**	 The entity studentFacing
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String studentFacing;

	/**	<br> The entity studentFacing
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:studentFacing">Find the entity studentFacing in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _studentFacing(Wrap<String> w);

	public String getStudentFacing() {
		return studentFacing;
	}
	public void setStudentFacing(String o) {
		this.studentFacing = CurrikiResource.staticSetStudentFacing(siteRequest_, o);
	}
	public static String staticSetStudentFacing(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource studentFacingInit() {
		Wrap<String> studentFacingWrap = new Wrap<String>().var("studentFacing");
		if(studentFacing == null) {
			_studentFacing(studentFacingWrap);
			setStudentFacing(studentFacingWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchStudentFacing(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrStudentFacing(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqStudentFacing(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrStudentFacing(siteRequest_, CurrikiResource.staticSearchStudentFacing(siteRequest_, CurrikiResource.staticSetStudentFacing(siteRequest_, o)));
	}

	public String sqlStudentFacing() {
		return studentFacing;
	}

	////////////
	// source //
	////////////

	/**	 The entity source
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String source;

	/**	<br> The entity source
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:source">Find the entity source in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _source(Wrap<String> w);

	public String getSource() {
		return source;
	}
	public void setSource(String o) {
		this.source = CurrikiResource.staticSetSource(siteRequest_, o);
	}
	public static String staticSetSource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource sourceInit() {
		Wrap<String> sourceWrap = new Wrap<String>().var("source");
		if(source == null) {
			_source(sourceWrap);
			setSource(sourceWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchSource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSource(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSource(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrSource(siteRequest_, CurrikiResource.staticSearchSource(siteRequest_, CurrikiResource.staticSetSource(siteRequest_, o)));
	}

	public String sqlSource() {
		return source;
	}

	//////////////////
	// reviewStatus //
	//////////////////

	/**	 The entity reviewStatus
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String reviewStatus;

	/**	<br> The entity reviewStatus
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:reviewStatus">Find the entity reviewStatus in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reviewStatus(Wrap<String> w);

	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String o) {
		this.reviewStatus = CurrikiResource.staticSetReviewStatus(siteRequest_, o);
	}
	public static String staticSetReviewStatus(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource reviewStatusInit() {
		Wrap<String> reviewStatusWrap = new Wrap<String>().var("reviewStatus");
		if(reviewStatus == null) {
			_reviewStatus(reviewStatusWrap);
			setReviewStatus(reviewStatusWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchReviewStatus(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrReviewStatus(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReviewStatus(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrReviewStatus(siteRequest_, CurrikiResource.staticSearchReviewStatus(siteRequest_, CurrikiResource.staticSetReviewStatus(siteRequest_, o)));
	}

	public String sqlReviewStatus() {
		return reviewStatus;
	}

	////////////////////
	// lastReviewDate //
	////////////////////

	/**	 The entity lastReviewDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime lastReviewDate;

	/**	<br> The entity lastReviewDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:lastReviewDate">Find the entity lastReviewDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _lastReviewDate(Wrap<ZonedDateTime> w);

	public ZonedDateTime getLastReviewDate() {
		return lastReviewDate;
	}

	public void setLastReviewDate(ZonedDateTime lastReviewDate) {
		this.lastReviewDate = lastReviewDate;
	}
	@JsonIgnore
	public void setLastReviewDate(Instant o) {
		this.lastReviewDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setLastReviewDate(String o) {
		this.lastReviewDate = CurrikiResource.staticSetLastReviewDate(siteRequest_, o);
	}
	public static ZonedDateTime staticSetLastReviewDate(SiteRequestEnUS siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setLastReviewDate(Date o) {
		this.lastReviewDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected CurrikiResource lastReviewDateInit() {
		Wrap<ZonedDateTime> lastReviewDateWrap = new Wrap<ZonedDateTime>().var("lastReviewDate");
		if(lastReviewDate == null) {
			_lastReviewDate(lastReviewDateWrap);
			setLastReviewDate(lastReviewDateWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Date staticSearchLastReviewDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSearchStrLastReviewDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqLastReviewDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrLastReviewDate(siteRequest_, CurrikiResource.staticSearchLastReviewDate(siteRequest_, CurrikiResource.staticSetLastReviewDate(siteRequest_, o)));
	}

	public OffsetDateTime sqlLastReviewDate() {
		return lastReviewDate == null ? null : lastReviewDate.toOffsetDateTime();
	}

	////////////////
	// reviewByID //
	////////////////

	/**	 The entity reviewByID
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long reviewByID;

	/**	<br> The entity reviewByID
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:reviewByID">Find the entity reviewByID in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reviewByID(Wrap<Long> w);

	public Long getReviewByID() {
		return reviewByID;
	}

	public void setReviewByID(Long reviewByID) {
		this.reviewByID = reviewByID;
	}
	@JsonIgnore
	public void setReviewByID(String o) {
		this.reviewByID = CurrikiResource.staticSetReviewByID(siteRequest_, o);
	}
	public static Long staticSetReviewByID(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected CurrikiResource reviewByIDInit() {
		Wrap<Long> reviewByIDWrap = new Wrap<Long>().var("reviewByID");
		if(reviewByID == null) {
			_reviewByID(reviewByIDWrap);
			setReviewByID(reviewByIDWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Long staticSearchReviewByID(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrReviewByID(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReviewByID(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrReviewByID(siteRequest_, CurrikiResource.staticSearchReviewByID(siteRequest_, CurrikiResource.staticSetReviewByID(siteRequest_, o)));
	}

	public Long sqlReviewByID() {
		return reviewByID;
	}

	//////////////////
	// reviewRating //
	//////////////////

	/**	 The entity reviewRating
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal reviewRating;

	/**	<br> The entity reviewRating
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:reviewRating">Find the entity reviewRating in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reviewRating(Wrap<BigDecimal> w);

	public BigDecimal getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(BigDecimal reviewRating) {
		this.reviewRating = reviewRating;
	}
	@JsonIgnore
	public void setReviewRating(String o) {
		this.reviewRating = CurrikiResource.staticSetReviewRating(siteRequest_, o);
	}
	public static BigDecimal staticSetReviewRating(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setReviewRating(Double o) {
			this.reviewRating = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	@JsonIgnore
	public void setReviewRating(Integer o) {
			this.reviewRating = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	protected CurrikiResource reviewRatingInit() {
		Wrap<BigDecimal> reviewRatingWrap = new Wrap<BigDecimal>().var("reviewRating");
		if(reviewRating == null) {
			_reviewRating(reviewRatingWrap);
			setReviewRating(reviewRatingWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Double staticSearchReviewRating(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrReviewRating(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReviewRating(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrReviewRating(siteRequest_, CurrikiResource.staticSearchReviewRating(siteRequest_, CurrikiResource.staticSetReviewRating(siteRequest_, o)));
	}

	public BigDecimal sqlReviewRating() {
		return reviewRating;
	}

	///////////////////////////
	// technicalCompleteness //
	///////////////////////////

	/**	 The entity technicalCompleteness
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer technicalCompleteness;

	/**	<br> The entity technicalCompleteness
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:technicalCompleteness">Find the entity technicalCompleteness in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _technicalCompleteness(Wrap<Integer> w);

	public Integer getTechnicalCompleteness() {
		return technicalCompleteness;
	}

	public void setTechnicalCompleteness(Integer technicalCompleteness) {
		this.technicalCompleteness = technicalCompleteness;
	}
	@JsonIgnore
	public void setTechnicalCompleteness(String o) {
		this.technicalCompleteness = CurrikiResource.staticSetTechnicalCompleteness(siteRequest_, o);
	}
	public static Integer staticSetTechnicalCompleteness(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource technicalCompletenessInit() {
		Wrap<Integer> technicalCompletenessWrap = new Wrap<Integer>().var("technicalCompleteness");
		if(technicalCompleteness == null) {
			_technicalCompleteness(technicalCompletenessWrap);
			setTechnicalCompleteness(technicalCompletenessWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchTechnicalCompleteness(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrTechnicalCompleteness(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTechnicalCompleteness(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrTechnicalCompleteness(siteRequest_, CurrikiResource.staticSearchTechnicalCompleteness(siteRequest_, CurrikiResource.staticSetTechnicalCompleteness(siteRequest_, o)));
	}

	public Integer sqlTechnicalCompleteness() {
		return technicalCompleteness;
	}

	/////////////////////
	// contentAccuracy //
	/////////////////////

	/**	 The entity contentAccuracy
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer contentAccuracy;

	/**	<br> The entity contentAccuracy
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:contentAccuracy">Find the entity contentAccuracy in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contentAccuracy(Wrap<Integer> w);

	public Integer getContentAccuracy() {
		return contentAccuracy;
	}

	public void setContentAccuracy(Integer contentAccuracy) {
		this.contentAccuracy = contentAccuracy;
	}
	@JsonIgnore
	public void setContentAccuracy(String o) {
		this.contentAccuracy = CurrikiResource.staticSetContentAccuracy(siteRequest_, o);
	}
	public static Integer staticSetContentAccuracy(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource contentAccuracyInit() {
		Wrap<Integer> contentAccuracyWrap = new Wrap<Integer>().var("contentAccuracy");
		if(contentAccuracy == null) {
			_contentAccuracy(contentAccuracyWrap);
			setContentAccuracy(contentAccuracyWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchContentAccuracy(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrContentAccuracy(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqContentAccuracy(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrContentAccuracy(siteRequest_, CurrikiResource.staticSearchContentAccuracy(siteRequest_, CurrikiResource.staticSetContentAccuracy(siteRequest_, o)));
	}

	public Integer sqlContentAccuracy() {
		return contentAccuracy;
	}

	//////////////
	// pedagogy //
	//////////////

	/**	 The entity pedagogy
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pedagogy;

	/**	<br> The entity pedagogy
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:pedagogy">Find the entity pedagogy in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pedagogy(Wrap<Integer> w);

	public Integer getPedagogy() {
		return pedagogy;
	}

	public void setPedagogy(Integer pedagogy) {
		this.pedagogy = pedagogy;
	}
	@JsonIgnore
	public void setPedagogy(String o) {
		this.pedagogy = CurrikiResource.staticSetPedagogy(siteRequest_, o);
	}
	public static Integer staticSetPedagogy(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource pedagogyInit() {
		Wrap<Integer> pedagogyWrap = new Wrap<Integer>().var("pedagogy");
		if(pedagogy == null) {
			_pedagogy(pedagogyWrap);
			setPedagogy(pedagogyWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchPedagogy(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrPedagogy(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPedagogy(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrPedagogy(siteRequest_, CurrikiResource.staticSearchPedagogy(siteRequest_, CurrikiResource.staticSetPedagogy(siteRequest_, o)));
	}

	public Integer sqlPedagogy() {
		return pedagogy;
	}

	///////////////////
	// ratingComment //
	///////////////////

	/**	 The entity ratingComment
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String ratingComment;

	/**	<br> The entity ratingComment
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:ratingComment">Find the entity ratingComment in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _ratingComment(Wrap<String> w);

	public String getRatingComment() {
		return ratingComment;
	}
	public void setRatingComment(String o) {
		this.ratingComment = CurrikiResource.staticSetRatingComment(siteRequest_, o);
	}
	public static String staticSetRatingComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource ratingCommentInit() {
		Wrap<String> ratingCommentWrap = new Wrap<String>().var("ratingComment");
		if(ratingComment == null) {
			_ratingComment(ratingCommentWrap);
			setRatingComment(ratingCommentWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchRatingComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrRatingComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRatingComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrRatingComment(siteRequest_, CurrikiResource.staticSearchRatingComment(siteRequest_, CurrikiResource.staticSetRatingComment(siteRequest_, o)));
	}

	public String sqlRatingComment() {
		return ratingComment;
	}

	////////////////////////
	// standardsAlignment //
	////////////////////////

	/**	 The entity standardsAlignment
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer standardsAlignment;

	/**	<br> The entity standardsAlignment
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:standardsAlignment">Find the entity standardsAlignment in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _standardsAlignment(Wrap<Integer> w);

	public Integer getStandardsAlignment() {
		return standardsAlignment;
	}

	public void setStandardsAlignment(Integer standardsAlignment) {
		this.standardsAlignment = standardsAlignment;
	}
	@JsonIgnore
	public void setStandardsAlignment(String o) {
		this.standardsAlignment = CurrikiResource.staticSetStandardsAlignment(siteRequest_, o);
	}
	public static Integer staticSetStandardsAlignment(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource standardsAlignmentInit() {
		Wrap<Integer> standardsAlignmentWrap = new Wrap<Integer>().var("standardsAlignment");
		if(standardsAlignment == null) {
			_standardsAlignment(standardsAlignmentWrap);
			setStandardsAlignment(standardsAlignmentWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchStandardsAlignment(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrStandardsAlignment(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqStandardsAlignment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrStandardsAlignment(siteRequest_, CurrikiResource.staticSearchStandardsAlignment(siteRequest_, CurrikiResource.staticSetStandardsAlignment(siteRequest_, o)));
	}

	public Integer sqlStandardsAlignment() {
		return standardsAlignment;
	}

	///////////////////////////////
	// standardsAlignmentComment //
	///////////////////////////////

	/**	 The entity standardsAlignmentComment
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String standardsAlignmentComment;

	/**	<br> The entity standardsAlignmentComment
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:standardsAlignmentComment">Find the entity standardsAlignmentComment in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _standardsAlignmentComment(Wrap<String> w);

	public String getStandardsAlignmentComment() {
		return standardsAlignmentComment;
	}
	public void setStandardsAlignmentComment(String o) {
		this.standardsAlignmentComment = CurrikiResource.staticSetStandardsAlignmentComment(siteRequest_, o);
	}
	public static String staticSetStandardsAlignmentComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource standardsAlignmentCommentInit() {
		Wrap<String> standardsAlignmentCommentWrap = new Wrap<String>().var("standardsAlignmentComment");
		if(standardsAlignmentComment == null) {
			_standardsAlignmentComment(standardsAlignmentCommentWrap);
			setStandardsAlignmentComment(standardsAlignmentCommentWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchStandardsAlignmentComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrStandardsAlignmentComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqStandardsAlignmentComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrStandardsAlignmentComment(siteRequest_, CurrikiResource.staticSearchStandardsAlignmentComment(siteRequest_, CurrikiResource.staticSetStandardsAlignmentComment(siteRequest_, o)));
	}

	public String sqlStandardsAlignmentComment() {
		return standardsAlignmentComment;
	}

	///////////////////
	// subjectMatter //
	///////////////////

	/**	 The entity subjectMatter
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer subjectMatter;

	/**	<br> The entity subjectMatter
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:subjectMatter">Find the entity subjectMatter in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _subjectMatter(Wrap<Integer> w);

	public Integer getSubjectMatter() {
		return subjectMatter;
	}

	public void setSubjectMatter(Integer subjectMatter) {
		this.subjectMatter = subjectMatter;
	}
	@JsonIgnore
	public void setSubjectMatter(String o) {
		this.subjectMatter = CurrikiResource.staticSetSubjectMatter(siteRequest_, o);
	}
	public static Integer staticSetSubjectMatter(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource subjectMatterInit() {
		Wrap<Integer> subjectMatterWrap = new Wrap<Integer>().var("subjectMatter");
		if(subjectMatter == null) {
			_subjectMatter(subjectMatterWrap);
			setSubjectMatter(subjectMatterWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchSubjectMatter(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrSubjectMatter(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSubjectMatter(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrSubjectMatter(siteRequest_, CurrikiResource.staticSearchSubjectMatter(siteRequest_, CurrikiResource.staticSetSubjectMatter(siteRequest_, o)));
	}

	public Integer sqlSubjectMatter() {
		return subjectMatter;
	}

	//////////////////////////
	// subjectMatterComment //
	//////////////////////////

	/**	 The entity subjectMatterComment
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String subjectMatterComment;

	/**	<br> The entity subjectMatterComment
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:subjectMatterComment">Find the entity subjectMatterComment in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _subjectMatterComment(Wrap<String> w);

	public String getSubjectMatterComment() {
		return subjectMatterComment;
	}
	public void setSubjectMatterComment(String o) {
		this.subjectMatterComment = CurrikiResource.staticSetSubjectMatterComment(siteRequest_, o);
	}
	public static String staticSetSubjectMatterComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource subjectMatterCommentInit() {
		Wrap<String> subjectMatterCommentWrap = new Wrap<String>().var("subjectMatterComment");
		if(subjectMatterComment == null) {
			_subjectMatterComment(subjectMatterCommentWrap);
			setSubjectMatterComment(subjectMatterCommentWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchSubjectMatterComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSubjectMatterComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSubjectMatterComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrSubjectMatterComment(siteRequest_, CurrikiResource.staticSearchSubjectMatterComment(siteRequest_, CurrikiResource.staticSetSubjectMatterComment(siteRequest_, o)));
	}

	public String sqlSubjectMatterComment() {
		return subjectMatterComment;
	}

	//////////////////////
	// supportsTeaching //
	//////////////////////

	/**	 The entity supportsTeaching
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer supportsTeaching;

	/**	<br> The entity supportsTeaching
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:supportsTeaching">Find the entity supportsTeaching in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _supportsTeaching(Wrap<Integer> w);

	public Integer getSupportsTeaching() {
		return supportsTeaching;
	}

	public void setSupportsTeaching(Integer supportsTeaching) {
		this.supportsTeaching = supportsTeaching;
	}
	@JsonIgnore
	public void setSupportsTeaching(String o) {
		this.supportsTeaching = CurrikiResource.staticSetSupportsTeaching(siteRequest_, o);
	}
	public static Integer staticSetSupportsTeaching(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource supportsTeachingInit() {
		Wrap<Integer> supportsTeachingWrap = new Wrap<Integer>().var("supportsTeaching");
		if(supportsTeaching == null) {
			_supportsTeaching(supportsTeachingWrap);
			setSupportsTeaching(supportsTeachingWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchSupportsTeaching(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrSupportsTeaching(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSupportsTeaching(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrSupportsTeaching(siteRequest_, CurrikiResource.staticSearchSupportsTeaching(siteRequest_, CurrikiResource.staticSetSupportsTeaching(siteRequest_, o)));
	}

	public Integer sqlSupportsTeaching() {
		return supportsTeaching;
	}

	/////////////////////////////
	// supportsTeachingComment //
	/////////////////////////////

	/**	 The entity supportsTeachingComment
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String supportsTeachingComment;

	/**	<br> The entity supportsTeachingComment
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:supportsTeachingComment">Find the entity supportsTeachingComment in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _supportsTeachingComment(Wrap<String> w);

	public String getSupportsTeachingComment() {
		return supportsTeachingComment;
	}
	public void setSupportsTeachingComment(String o) {
		this.supportsTeachingComment = CurrikiResource.staticSetSupportsTeachingComment(siteRequest_, o);
	}
	public static String staticSetSupportsTeachingComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource supportsTeachingCommentInit() {
		Wrap<String> supportsTeachingCommentWrap = new Wrap<String>().var("supportsTeachingComment");
		if(supportsTeachingComment == null) {
			_supportsTeachingComment(supportsTeachingCommentWrap);
			setSupportsTeachingComment(supportsTeachingCommentWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchSupportsTeachingComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSupportsTeachingComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSupportsTeachingComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrSupportsTeachingComment(siteRequest_, CurrikiResource.staticSearchSupportsTeachingComment(siteRequest_, CurrikiResource.staticSetSupportsTeachingComment(siteRequest_, o)));
	}

	public String sqlSupportsTeachingComment() {
		return supportsTeachingComment;
	}

	////////////////////////
	// assessmentsQuality //
	////////////////////////

	/**	 The entity assessmentsQuality
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer assessmentsQuality;

	/**	<br> The entity assessmentsQuality
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:assessmentsQuality">Find the entity assessmentsQuality in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _assessmentsQuality(Wrap<Integer> w);

	public Integer getAssessmentsQuality() {
		return assessmentsQuality;
	}

	public void setAssessmentsQuality(Integer assessmentsQuality) {
		this.assessmentsQuality = assessmentsQuality;
	}
	@JsonIgnore
	public void setAssessmentsQuality(String o) {
		this.assessmentsQuality = CurrikiResource.staticSetAssessmentsQuality(siteRequest_, o);
	}
	public static Integer staticSetAssessmentsQuality(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource assessmentsQualityInit() {
		Wrap<Integer> assessmentsQualityWrap = new Wrap<Integer>().var("assessmentsQuality");
		if(assessmentsQuality == null) {
			_assessmentsQuality(assessmentsQualityWrap);
			setAssessmentsQuality(assessmentsQualityWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchAssessmentsQuality(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrAssessmentsQuality(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAssessmentsQuality(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrAssessmentsQuality(siteRequest_, CurrikiResource.staticSearchAssessmentsQuality(siteRequest_, CurrikiResource.staticSetAssessmentsQuality(siteRequest_, o)));
	}

	public Integer sqlAssessmentsQuality() {
		return assessmentsQuality;
	}

	///////////////////////////////
	// assessmentsQualityComment //
	///////////////////////////////

	/**	 The entity assessmentsQualityComment
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String assessmentsQualityComment;

	/**	<br> The entity assessmentsQualityComment
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:assessmentsQualityComment">Find the entity assessmentsQualityComment in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _assessmentsQualityComment(Wrap<String> w);

	public String getAssessmentsQualityComment() {
		return assessmentsQualityComment;
	}
	public void setAssessmentsQualityComment(String o) {
		this.assessmentsQualityComment = CurrikiResource.staticSetAssessmentsQualityComment(siteRequest_, o);
	}
	public static String staticSetAssessmentsQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource assessmentsQualityCommentInit() {
		Wrap<String> assessmentsQualityCommentWrap = new Wrap<String>().var("assessmentsQualityComment");
		if(assessmentsQualityComment == null) {
			_assessmentsQualityComment(assessmentsQualityCommentWrap);
			setAssessmentsQualityComment(assessmentsQualityCommentWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchAssessmentsQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAssessmentsQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAssessmentsQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrAssessmentsQualityComment(siteRequest_, CurrikiResource.staticSearchAssessmentsQualityComment(siteRequest_, CurrikiResource.staticSetAssessmentsQualityComment(siteRequest_, o)));
	}

	public String sqlAssessmentsQualityComment() {
		return assessmentsQualityComment;
	}

	//////////////////////////
	// interactivityQuality //
	//////////////////////////

	/**	 The entity interactivityQuality
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer interactivityQuality;

	/**	<br> The entity interactivityQuality
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:interactivityQuality">Find the entity interactivityQuality in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _interactivityQuality(Wrap<Integer> w);

	public Integer getInteractivityQuality() {
		return interactivityQuality;
	}

	public void setInteractivityQuality(Integer interactivityQuality) {
		this.interactivityQuality = interactivityQuality;
	}
	@JsonIgnore
	public void setInteractivityQuality(String o) {
		this.interactivityQuality = CurrikiResource.staticSetInteractivityQuality(siteRequest_, o);
	}
	public static Integer staticSetInteractivityQuality(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource interactivityQualityInit() {
		Wrap<Integer> interactivityQualityWrap = new Wrap<Integer>().var("interactivityQuality");
		if(interactivityQuality == null) {
			_interactivityQuality(interactivityQualityWrap);
			setInteractivityQuality(interactivityQualityWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchInteractivityQuality(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrInteractivityQuality(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqInteractivityQuality(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrInteractivityQuality(siteRequest_, CurrikiResource.staticSearchInteractivityQuality(siteRequest_, CurrikiResource.staticSetInteractivityQuality(siteRequest_, o)));
	}

	public Integer sqlInteractivityQuality() {
		return interactivityQuality;
	}

	/////////////////////////////////
	// interactivityQualityComment //
	/////////////////////////////////

	/**	 The entity interactivityQualityComment
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String interactivityQualityComment;

	/**	<br> The entity interactivityQualityComment
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:interactivityQualityComment">Find the entity interactivityQualityComment in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _interactivityQualityComment(Wrap<String> w);

	public String getInteractivityQualityComment() {
		return interactivityQualityComment;
	}
	public void setInteractivityQualityComment(String o) {
		this.interactivityQualityComment = CurrikiResource.staticSetInteractivityQualityComment(siteRequest_, o);
	}
	public static String staticSetInteractivityQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource interactivityQualityCommentInit() {
		Wrap<String> interactivityQualityCommentWrap = new Wrap<String>().var("interactivityQualityComment");
		if(interactivityQualityComment == null) {
			_interactivityQualityComment(interactivityQualityCommentWrap);
			setInteractivityQualityComment(interactivityQualityCommentWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchInteractivityQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrInteractivityQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqInteractivityQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrInteractivityQualityComment(siteRequest_, CurrikiResource.staticSearchInteractivityQualityComment(siteRequest_, CurrikiResource.staticSetInteractivityQualityComment(siteRequest_, o)));
	}

	public String sqlInteractivityQualityComment() {
		return interactivityQualityComment;
	}

	//////////////////////////
	// instructionalQuality //
	//////////////////////////

	/**	 The entity instructionalQuality
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer instructionalQuality;

	/**	<br> The entity instructionalQuality
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:instructionalQuality">Find the entity instructionalQuality in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _instructionalQuality(Wrap<Integer> w);

	public Integer getInstructionalQuality() {
		return instructionalQuality;
	}

	public void setInstructionalQuality(Integer instructionalQuality) {
		this.instructionalQuality = instructionalQuality;
	}
	@JsonIgnore
	public void setInstructionalQuality(String o) {
		this.instructionalQuality = CurrikiResource.staticSetInstructionalQuality(siteRequest_, o);
	}
	public static Integer staticSetInstructionalQuality(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource instructionalQualityInit() {
		Wrap<Integer> instructionalQualityWrap = new Wrap<Integer>().var("instructionalQuality");
		if(instructionalQuality == null) {
			_instructionalQuality(instructionalQualityWrap);
			setInstructionalQuality(instructionalQualityWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchInstructionalQuality(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrInstructionalQuality(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqInstructionalQuality(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrInstructionalQuality(siteRequest_, CurrikiResource.staticSearchInstructionalQuality(siteRequest_, CurrikiResource.staticSetInstructionalQuality(siteRequest_, o)));
	}

	public Integer sqlInstructionalQuality() {
		return instructionalQuality;
	}

	/////////////////////////////////
	// instructionalQualityComment //
	/////////////////////////////////

	/**	 The entity instructionalQualityComment
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String instructionalQualityComment;

	/**	<br> The entity instructionalQualityComment
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:instructionalQualityComment">Find the entity instructionalQualityComment in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _instructionalQualityComment(Wrap<String> w);

	public String getInstructionalQualityComment() {
		return instructionalQualityComment;
	}
	public void setInstructionalQualityComment(String o) {
		this.instructionalQualityComment = CurrikiResource.staticSetInstructionalQualityComment(siteRequest_, o);
	}
	public static String staticSetInstructionalQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource instructionalQualityCommentInit() {
		Wrap<String> instructionalQualityCommentWrap = new Wrap<String>().var("instructionalQualityComment");
		if(instructionalQualityComment == null) {
			_instructionalQualityComment(instructionalQualityCommentWrap);
			setInstructionalQualityComment(instructionalQualityCommentWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchInstructionalQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrInstructionalQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqInstructionalQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrInstructionalQualityComment(siteRequest_, CurrikiResource.staticSearchInstructionalQualityComment(siteRequest_, CurrikiResource.staticSetInstructionalQualityComment(siteRequest_, o)));
	}

	public String sqlInstructionalQualityComment() {
		return instructionalQualityComment;
	}

	////////////////////
	// deeperLearning //
	////////////////////

	/**	 The entity deeperLearning
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer deeperLearning;

	/**	<br> The entity deeperLearning
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:deeperLearning">Find the entity deeperLearning in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _deeperLearning(Wrap<Integer> w);

	public Integer getDeeperLearning() {
		return deeperLearning;
	}

	public void setDeeperLearning(Integer deeperLearning) {
		this.deeperLearning = deeperLearning;
	}
	@JsonIgnore
	public void setDeeperLearning(String o) {
		this.deeperLearning = CurrikiResource.staticSetDeeperLearning(siteRequest_, o);
	}
	public static Integer staticSetDeeperLearning(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource deeperLearningInit() {
		Wrap<Integer> deeperLearningWrap = new Wrap<Integer>().var("deeperLearning");
		if(deeperLearning == null) {
			_deeperLearning(deeperLearningWrap);
			setDeeperLearning(deeperLearningWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchDeeperLearning(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrDeeperLearning(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDeeperLearning(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrDeeperLearning(siteRequest_, CurrikiResource.staticSearchDeeperLearning(siteRequest_, CurrikiResource.staticSetDeeperLearning(siteRequest_, o)));
	}

	public Integer sqlDeeperLearning() {
		return deeperLearning;
	}

	///////////////////////////
	// deeperLearningComment //
	///////////////////////////

	/**	 The entity deeperLearningComment
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String deeperLearningComment;

	/**	<br> The entity deeperLearningComment
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:deeperLearningComment">Find the entity deeperLearningComment in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _deeperLearningComment(Wrap<String> w);

	public String getDeeperLearningComment() {
		return deeperLearningComment;
	}
	public void setDeeperLearningComment(String o) {
		this.deeperLearningComment = CurrikiResource.staticSetDeeperLearningComment(siteRequest_, o);
	}
	public static String staticSetDeeperLearningComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource deeperLearningCommentInit() {
		Wrap<String> deeperLearningCommentWrap = new Wrap<String>().var("deeperLearningComment");
		if(deeperLearningComment == null) {
			_deeperLearningComment(deeperLearningCommentWrap);
			setDeeperLearningComment(deeperLearningCommentWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchDeeperLearningComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDeeperLearningComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDeeperLearningComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrDeeperLearningComment(siteRequest_, CurrikiResource.staticSearchDeeperLearningComment(siteRequest_, CurrikiResource.staticSetDeeperLearningComment(siteRequest_, o)));
	}

	public String sqlDeeperLearningComment() {
		return deeperLearningComment;
	}

	/////////////
	// partner //
	/////////////

	/**	 The entity partner
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String partner;

	/**	<br> The entity partner
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:partner">Find the entity partner in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _partner(Wrap<String> w);

	public String getPartner() {
		return partner;
	}
	public void setPartner(String o) {
		this.partner = CurrikiResource.staticSetPartner(siteRequest_, o);
	}
	public static String staticSetPartner(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource partnerInit() {
		Wrap<String> partnerWrap = new Wrap<String>().var("partner");
		if(partner == null) {
			_partner(partnerWrap);
			setPartner(partnerWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchPartner(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPartner(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPartner(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrPartner(siteRequest_, CurrikiResource.staticSearchPartner(siteRequest_, CurrikiResource.staticSetPartner(siteRequest_, o)));
	}

	public String sqlPartner() {
		return partner;
	}

	////////////////
	// createDate //
	////////////////

	/**	 The entity createDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime createDate;

	/**	<br> The entity createDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:createDate">Find the entity createDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _createDate(Wrap<ZonedDateTime> w);

	public ZonedDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(ZonedDateTime createDate) {
		this.createDate = createDate;
	}
	@JsonIgnore
	public void setCreateDate(Instant o) {
		this.createDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setCreateDate(String o) {
		this.createDate = CurrikiResource.staticSetCreateDate(siteRequest_, o);
	}
	public static ZonedDateTime staticSetCreateDate(SiteRequestEnUS siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setCreateDate(Date o) {
		this.createDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected CurrikiResource createDateInit() {
		Wrap<ZonedDateTime> createDateWrap = new Wrap<ZonedDateTime>().var("createDate");
		if(createDate == null) {
			_createDate(createDateWrap);
			setCreateDate(createDateWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Date staticSearchCreateDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSearchStrCreateDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqCreateDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrCreateDate(siteRequest_, CurrikiResource.staticSearchCreateDate(siteRequest_, CurrikiResource.staticSetCreateDate(siteRequest_, o)));
	}

	public OffsetDateTime sqlCreateDate() {
		return createDate == null ? null : createDate.toOffsetDateTime();
	}

	//////////
	// type //
	//////////

	/**	 The entity type
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String type;

	/**	<br> The entity type
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:type">Find the entity type in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _type(Wrap<String> w);

	public String getType() {
		return type;
	}
	public void setType(String o) {
		this.type = CurrikiResource.staticSetType(siteRequest_, o);
	}
	public static String staticSetType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource typeInit() {
		Wrap<String> typeWrap = new Wrap<String>().var("type");
		if(type == null) {
			_type(typeWrap);
			setType(typeWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrType(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqType(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrType(siteRequest_, CurrikiResource.staticSearchType(siteRequest_, CurrikiResource.staticSetType(siteRequest_, o)));
	}

	public String sqlType() {
		return type;
	}

	//////////////
	// featured //
	//////////////

	/**	 The entity featured
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String featured;

	/**	<br> The entity featured
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:featured">Find the entity featured in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _featured(Wrap<String> w);

	public String getFeatured() {
		return featured;
	}
	public void setFeatured(String o) {
		this.featured = CurrikiResource.staticSetFeatured(siteRequest_, o);
	}
	public static String staticSetFeatured(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource featuredInit() {
		Wrap<String> featuredWrap = new Wrap<String>().var("featured");
		if(featured == null) {
			_featured(featuredWrap);
			setFeatured(featuredWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchFeatured(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrFeatured(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqFeatured(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrFeatured(siteRequest_, CurrikiResource.staticSearchFeatured(siteRequest_, CurrikiResource.staticSetFeatured(siteRequest_, o)));
	}

	public String sqlFeatured() {
		return featured;
	}

	//////////
	// page //
	//////////

	/**	 The entity page
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String page;

	/**	<br> The entity page
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:page">Find the entity page in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _page(Wrap<String> w);

	public String getPage() {
		return page;
	}
	public void setPage(String o) {
		this.page = CurrikiResource.staticSetPage(siteRequest_, o);
	}
	public static String staticSetPage(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource pageInit() {
		Wrap<String> pageWrap = new Wrap<String>().var("page");
		if(page == null) {
			_page(pageWrap);
			setPage(pageWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchPage(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPage(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPage(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrPage(siteRequest_, CurrikiResource.staticSearchPage(siteRequest_, CurrikiResource.staticSetPage(siteRequest_, o)));
	}

	public String sqlPage() {
		return page;
	}

	////////////
	// active //
	////////////

	/**	 The entity active
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String active;

	/**	<br> The entity active
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:active">Find the entity active in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _active(Wrap<String> w);

	public String getActive() {
		return active;
	}
	public void setActive(String o) {
		this.active = CurrikiResource.staticSetActive(siteRequest_, o);
	}
	public static String staticSetActive(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource activeInit() {
		Wrap<String> activeWrap = new Wrap<String>().var("active");
		if(active == null) {
			_active(activeWrap);
			setActive(activeWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchActive(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrActive(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqActive(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrActive(siteRequest_, CurrikiResource.staticSearchActive(siteRequest_, CurrikiResource.staticSetActive(siteRequest_, o)));
	}

	public String sqlActive() {
		return active;
	}

	////////////
	// Public //
	////////////

	/**	 The entity Public
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String Public;

	/**	<br> The entity Public
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:Public">Find the entity Public in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _Public(Wrap<String> w);

	public String getPublic() {
		return Public;
	}
	public void setPublic(String o) {
		this.Public = CurrikiResource.staticSetPublic(siteRequest_, o);
	}
	public static String staticSetPublic(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource PublicInit() {
		Wrap<String> PublicWrap = new Wrap<String>().var("Public");
		if(Public == null) {
			_Public(PublicWrap);
			setPublic(PublicWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchPublic(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPublic(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPublic(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrPublic(siteRequest_, CurrikiResource.staticSearchPublic(siteRequest_, CurrikiResource.staticSetPublic(siteRequest_, o)));
	}

	public String sqlPublic() {
		return Public;
	}

	////////////
	// xwd_id //
	////////////

	/**	 The entity xwd_id
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer xwd_id;

	/**	<br> The entity xwd_id
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:xwd_id">Find the entity xwd_id in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _xwd_id(Wrap<Integer> w);

	public Integer getXwd_id() {
		return xwd_id;
	}

	public void setXwd_id(Integer xwd_id) {
		this.xwd_id = xwd_id;
	}
	@JsonIgnore
	public void setXwd_id(String o) {
		this.xwd_id = CurrikiResource.staticSetXwd_id(siteRequest_, o);
	}
	public static Integer staticSetXwd_id(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource xwd_idInit() {
		Wrap<Integer> xwd_idWrap = new Wrap<Integer>().var("xwd_id");
		if(xwd_id == null) {
			_xwd_id(xwd_idWrap);
			setXwd_id(xwd_idWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchXwd_id(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrXwd_id(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqXwd_id(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrXwd_id(siteRequest_, CurrikiResource.staticSearchXwd_id(siteRequest_, CurrikiResource.staticSetXwd_id(siteRequest_, o)));
	}

	public Integer sqlXwd_id() {
		return xwd_id;
	}

	///////////////
	// mediaType //
	///////////////

	/**	 The entity mediaType
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String mediaType;

	/**	<br> The entity mediaType
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:mediaType">Find the entity mediaType in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _mediaType(Wrap<String> w);

	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String o) {
		this.mediaType = CurrikiResource.staticSetMediaType(siteRequest_, o);
	}
	public static String staticSetMediaType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource mediaTypeInit() {
		Wrap<String> mediaTypeWrap = new Wrap<String>().var("mediaType");
		if(mediaType == null) {
			_mediaType(mediaTypeWrap);
			setMediaType(mediaTypeWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchMediaType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrMediaType(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqMediaType(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrMediaType(siteRequest_, CurrikiResource.staticSearchMediaType(siteRequest_, CurrikiResource.staticSetMediaType(siteRequest_, o)));
	}

	public String sqlMediaType() {
		return mediaType;
	}

	////////////
	// access //
	////////////

	/**	 The entity access
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String access;

	/**	<br> The entity access
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:access">Find the entity access in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _access(Wrap<String> w);

	public String getAccess() {
		return access;
	}
	public void setAccess(String o) {
		this.access = CurrikiResource.staticSetAccess(siteRequest_, o);
	}
	public static String staticSetAccess(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource accessInit() {
		Wrap<String> accessWrap = new Wrap<String>().var("access");
		if(access == null) {
			_access(accessWrap);
			setAccess(accessWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchAccess(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAccess(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAccess(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrAccess(siteRequest_, CurrikiResource.staticSearchAccess(siteRequest_, CurrikiResource.staticSetAccess(siteRequest_, o)));
	}

	public String sqlAccess() {
		return access;
	}

	//////////////////
	// memberRating //
	//////////////////

	/**	 The entity memberRating
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal memberRating;

	/**	<br> The entity memberRating
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:memberRating">Find the entity memberRating in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _memberRating(Wrap<BigDecimal> w);

	public BigDecimal getMemberRating() {
		return memberRating;
	}

	public void setMemberRating(BigDecimal memberRating) {
		this.memberRating = memberRating;
	}
	@JsonIgnore
	public void setMemberRating(String o) {
		this.memberRating = CurrikiResource.staticSetMemberRating(siteRequest_, o);
	}
	public static BigDecimal staticSetMemberRating(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setMemberRating(Double o) {
			this.memberRating = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	@JsonIgnore
	public void setMemberRating(Integer o) {
			this.memberRating = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	protected CurrikiResource memberRatingInit() {
		Wrap<BigDecimal> memberRatingWrap = new Wrap<BigDecimal>().var("memberRating");
		if(memberRating == null) {
			_memberRating(memberRatingWrap);
			setMemberRating(memberRatingWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Double staticSearchMemberRating(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrMemberRating(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqMemberRating(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrMemberRating(siteRequest_, CurrikiResource.staticSearchMemberRating(siteRequest_, CurrikiResource.staticSetMemberRating(siteRequest_, o)));
	}

	public BigDecimal sqlMemberRating() {
		return memberRating;
	}

	/////////////
	// aligned //
	/////////////

	/**	 The entity aligned
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String aligned;

	/**	<br> The entity aligned
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:aligned">Find the entity aligned in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _aligned(Wrap<String> w);

	public String getAligned() {
		return aligned;
	}
	public void setAligned(String o) {
		this.aligned = CurrikiResource.staticSetAligned(siteRequest_, o);
	}
	public static String staticSetAligned(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource alignedInit() {
		Wrap<String> alignedWrap = new Wrap<String>().var("aligned");
		if(aligned == null) {
			_aligned(alignedWrap);
			setAligned(alignedWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchAligned(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAligned(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAligned(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrAligned(siteRequest_, CurrikiResource.staticSearchAligned(siteRequest_, CurrikiResource.staticSetAligned(siteRequest_, o)));
	}

	public String sqlAligned() {
		return aligned;
	}

	/////////////
	// pageUrl //
	/////////////

	/**	 The entity pageUrl
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUrl;

	/**	<br> The entity pageUrl
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:pageUrl">Find the entity pageUrl in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUrl(Wrap<String> w);

	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String o) {
		this.pageUrl = CurrikiResource.staticSetPageUrl(siteRequest_, o);
	}
	public static String staticSetPageUrl(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource pageUrlInit() {
		Wrap<String> pageUrlWrap = new Wrap<String>().var("pageUrl");
		if(pageUrl == null) {
			_pageUrl(pageUrlWrap);
			setPageUrl(pageUrlWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchPageUrl(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageUrl(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageUrl(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrPageUrl(siteRequest_, CurrikiResource.staticSearchPageUrl(siteRequest_, CurrikiResource.staticSetPageUrl(siteRequest_, o)));
	}

	public String sqlPageUrl() {
		return pageUrl;
	}

	/////////////
	// indexed //
	/////////////

	/**	 The entity indexed
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String indexed;

	/**	<br> The entity indexed
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:indexed">Find the entity indexed in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _indexed(Wrap<String> w);

	public String getIndexed() {
		return indexed;
	}
	public void setIndexed(String o) {
		this.indexed = CurrikiResource.staticSetIndexed(siteRequest_, o);
	}
	public static String staticSetIndexed(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource indexedInit() {
		Wrap<String> indexedWrap = new Wrap<String>().var("indexed");
		if(indexed == null) {
			_indexed(indexedWrap);
			setIndexed(indexedWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchIndexed(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrIndexed(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqIndexed(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrIndexed(siteRequest_, CurrikiResource.staticSearchIndexed(siteRequest_, CurrikiResource.staticSetIndexed(siteRequest_, o)));
	}

	public String sqlIndexed() {
		return indexed;
	}

	///////////////////
	// lastIndexDate //
	///////////////////

	/**	 The entity lastIndexDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime lastIndexDate;

	/**	<br> The entity lastIndexDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:lastIndexDate">Find the entity lastIndexDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _lastIndexDate(Wrap<ZonedDateTime> w);

	public ZonedDateTime getLastIndexDate() {
		return lastIndexDate;
	}

	public void setLastIndexDate(ZonedDateTime lastIndexDate) {
		this.lastIndexDate = lastIndexDate;
	}
	@JsonIgnore
	public void setLastIndexDate(Instant o) {
		this.lastIndexDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setLastIndexDate(String o) {
		this.lastIndexDate = CurrikiResource.staticSetLastIndexDate(siteRequest_, o);
	}
	public static ZonedDateTime staticSetLastIndexDate(SiteRequestEnUS siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setLastIndexDate(Date o) {
		this.lastIndexDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected CurrikiResource lastIndexDateInit() {
		Wrap<ZonedDateTime> lastIndexDateWrap = new Wrap<ZonedDateTime>().var("lastIndexDate");
		if(lastIndexDate == null) {
			_lastIndexDate(lastIndexDateWrap);
			setLastIndexDate(lastIndexDateWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Date staticSearchLastIndexDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSearchStrLastIndexDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqLastIndexDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrLastIndexDate(siteRequest_, CurrikiResource.staticSearchLastIndexDate(siteRequest_, CurrikiResource.staticSetLastIndexDate(siteRequest_, o)));
	}

	public OffsetDateTime sqlLastIndexDate() {
		return lastIndexDate == null ? null : lastIndexDate.toOffsetDateTime();
	}

	///////////////////
	// indexRequired //
	///////////////////

	/**	 The entity indexRequired
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String indexRequired;

	/**	<br> The entity indexRequired
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:indexRequired">Find the entity indexRequired in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _indexRequired(Wrap<String> w);

	public String getIndexRequired() {
		return indexRequired;
	}
	public void setIndexRequired(String o) {
		this.indexRequired = CurrikiResource.staticSetIndexRequired(siteRequest_, o);
	}
	public static String staticSetIndexRequired(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource indexRequiredInit() {
		Wrap<String> indexRequiredWrap = new Wrap<String>().var("indexRequired");
		if(indexRequired == null) {
			_indexRequired(indexRequiredWrap);
			setIndexRequired(indexRequiredWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchIndexRequired(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrIndexRequired(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqIndexRequired(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrIndexRequired(siteRequest_, CurrikiResource.staticSearchIndexRequired(siteRequest_, CurrikiResource.staticSetIndexRequired(siteRequest_, o)));
	}

	public String sqlIndexRequired() {
		return indexRequired;
	}

	///////////////////////
	// indexRequiredDate //
	///////////////////////

	/**	 The entity indexRequiredDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime indexRequiredDate;

	/**	<br> The entity indexRequiredDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:indexRequiredDate">Find the entity indexRequiredDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _indexRequiredDate(Wrap<ZonedDateTime> w);

	public ZonedDateTime getIndexRequiredDate() {
		return indexRequiredDate;
	}

	public void setIndexRequiredDate(ZonedDateTime indexRequiredDate) {
		this.indexRequiredDate = indexRequiredDate;
	}
	@JsonIgnore
	public void setIndexRequiredDate(Instant o) {
		this.indexRequiredDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setIndexRequiredDate(String o) {
		this.indexRequiredDate = CurrikiResource.staticSetIndexRequiredDate(siteRequest_, o);
	}
	public static ZonedDateTime staticSetIndexRequiredDate(SiteRequestEnUS siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setIndexRequiredDate(Date o) {
		this.indexRequiredDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected CurrikiResource indexRequiredDateInit() {
		Wrap<ZonedDateTime> indexRequiredDateWrap = new Wrap<ZonedDateTime>().var("indexRequiredDate");
		if(indexRequiredDate == null) {
			_indexRequiredDate(indexRequiredDateWrap);
			setIndexRequiredDate(indexRequiredDateWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Date staticSearchIndexRequiredDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSearchStrIndexRequiredDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqIndexRequiredDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrIndexRequiredDate(siteRequest_, CurrikiResource.staticSearchIndexRequiredDate(siteRequest_, CurrikiResource.staticSetIndexRequiredDate(siteRequest_, o)));
	}

	public OffsetDateTime sqlIndexRequiredDate() {
		return indexRequiredDate == null ? null : indexRequiredDate.toOffsetDateTime();
	}

	//////////////
	// rescrape //
	//////////////

	/**	 The entity rescrape
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String rescrape;

	/**	<br> The entity rescrape
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:rescrape">Find the entity rescrape in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _rescrape(Wrap<String> w);

	public String getRescrape() {
		return rescrape;
	}
	public void setRescrape(String o) {
		this.rescrape = CurrikiResource.staticSetRescrape(siteRequest_, o);
	}
	public static String staticSetRescrape(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource rescrapeInit() {
		Wrap<String> rescrapeWrap = new Wrap<String>().var("rescrape");
		if(rescrape == null) {
			_rescrape(rescrapeWrap);
			setRescrape(rescrapeWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchRescrape(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrRescrape(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRescrape(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrRescrape(siteRequest_, CurrikiResource.staticSearchRescrape(siteRequest_, CurrikiResource.staticSetRescrape(siteRequest_, o)));
	}

	public String sqlRescrape() {
		return rescrape;
	}

	//////////////
	// goButton //
	//////////////

	/**	 The entity goButton
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String goButton;

	/**	<br> The entity goButton
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:goButton">Find the entity goButton in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _goButton(Wrap<String> w);

	public String getGoButton() {
		return goButton;
	}
	public void setGoButton(String o) {
		this.goButton = CurrikiResource.staticSetGoButton(siteRequest_, o);
	}
	public static String staticSetGoButton(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource goButtonInit() {
		Wrap<String> goButtonWrap = new Wrap<String>().var("goButton");
		if(goButton == null) {
			_goButton(goButtonWrap);
			setGoButton(goButtonWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchGoButton(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrGoButton(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqGoButton(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrGoButton(siteRequest_, CurrikiResource.staticSearchGoButton(siteRequest_, CurrikiResource.staticSetGoButton(siteRequest_, o)));
	}

	public String sqlGoButton() {
		return goButton;
	}

	////////////////////
	// downloadButton //
	////////////////////

	/**	 The entity downloadButton
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String downloadButton;

	/**	<br> The entity downloadButton
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:downloadButton">Find the entity downloadButton in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _downloadButton(Wrap<String> w);

	public String getDownloadButton() {
		return downloadButton;
	}
	public void setDownloadButton(String o) {
		this.downloadButton = CurrikiResource.staticSetDownloadButton(siteRequest_, o);
	}
	public static String staticSetDownloadButton(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource downloadButtonInit() {
		Wrap<String> downloadButtonWrap = new Wrap<String>().var("downloadButton");
		if(downloadButton == null) {
			_downloadButton(downloadButtonWrap);
			setDownloadButton(downloadButtonWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchDownloadButton(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDownloadButton(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDownloadButton(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrDownloadButton(siteRequest_, CurrikiResource.staticSearchDownloadButton(siteRequest_, CurrikiResource.staticSetDownloadButton(siteRequest_, o)));
	}

	public String sqlDownloadButton() {
		return downloadButton;
	}

	/////////////////
	// topOfSearch //
	/////////////////

	/**	 The entity topOfSearch
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String topOfSearch;

	/**	<br> The entity topOfSearch
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:topOfSearch">Find the entity topOfSearch in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _topOfSearch(Wrap<String> w);

	public String getTopOfSearch() {
		return topOfSearch;
	}
	public void setTopOfSearch(String o) {
		this.topOfSearch = CurrikiResource.staticSetTopOfSearch(siteRequest_, o);
	}
	public static String staticSetTopOfSearch(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource topOfSearchInit() {
		Wrap<String> topOfSearchWrap = new Wrap<String>().var("topOfSearch");
		if(topOfSearch == null) {
			_topOfSearch(topOfSearchWrap);
			setTopOfSearch(topOfSearchWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchTopOfSearch(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrTopOfSearch(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTopOfSearch(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrTopOfSearch(siteRequest_, CurrikiResource.staticSearchTopOfSearch(siteRequest_, CurrikiResource.staticSetTopOfSearch(siteRequest_, o)));
	}

	public String sqlTopOfSearch() {
		return topOfSearch;
	}

	////////////
	// remove //
	////////////

	/**	 The entity remove
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String remove;

	/**	<br> The entity remove
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:remove">Find the entity remove in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _remove(Wrap<String> w);

	public String getRemove() {
		return remove;
	}
	public void setRemove(String o) {
		this.remove = CurrikiResource.staticSetRemove(siteRequest_, o);
	}
	public static String staticSetRemove(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource removeInit() {
		Wrap<String> removeWrap = new Wrap<String>().var("remove");
		if(remove == null) {
			_remove(removeWrap);
			setRemove(removeWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchRemove(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrRemove(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRemove(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrRemove(siteRequest_, CurrikiResource.staticSearchRemove(siteRequest_, CurrikiResource.staticSetRemove(siteRequest_, o)));
	}

	public String sqlRemove() {
		return remove;
	}

	//////////
	// spam //
	//////////

	/**	 The entity spam
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String spam;

	/**	<br> The entity spam
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:spam">Find the entity spam in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _spam(Wrap<String> w);

	public String getSpam() {
		return spam;
	}
	public void setSpam(String o) {
		this.spam = CurrikiResource.staticSetSpam(siteRequest_, o);
	}
	public static String staticSetSpam(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource spamInit() {
		Wrap<String> spamWrap = new Wrap<String>().var("spam");
		if(spam == null) {
			_spam(spamWrap);
			setSpam(spamWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchSpam(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSpam(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSpam(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrSpam(siteRequest_, CurrikiResource.staticSearchSpam(siteRequest_, CurrikiResource.staticSetSpam(siteRequest_, o)));
	}

	public String sqlSpam() {
		return spam;
	}

	////////////////////
	// topOfSearchInt //
	////////////////////

	/**	 The entity topOfSearchInt
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer topOfSearchInt;

	/**	<br> The entity topOfSearchInt
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:topOfSearchInt">Find the entity topOfSearchInt in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _topOfSearchInt(Wrap<Integer> w);

	public Integer getTopOfSearchInt() {
		return topOfSearchInt;
	}

	public void setTopOfSearchInt(Integer topOfSearchInt) {
		this.topOfSearchInt = topOfSearchInt;
	}
	@JsonIgnore
	public void setTopOfSearchInt(String o) {
		this.topOfSearchInt = CurrikiResource.staticSetTopOfSearchInt(siteRequest_, o);
	}
	public static Integer staticSetTopOfSearchInt(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource topOfSearchIntInit() {
		Wrap<Integer> topOfSearchIntWrap = new Wrap<Integer>().var("topOfSearchInt");
		if(topOfSearchInt == null) {
			_topOfSearchInt(topOfSearchIntWrap);
			setTopOfSearchInt(topOfSearchIntWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchTopOfSearchInt(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrTopOfSearchInt(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTopOfSearchInt(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrTopOfSearchInt(siteRequest_, CurrikiResource.staticSearchTopOfSearchInt(siteRequest_, CurrikiResource.staticSetTopOfSearchInt(siteRequest_, o)));
	}

	public Integer sqlTopOfSearchInt() {
		return topOfSearchInt;
	}

	////////////////
	// partnerInt //
	////////////////

	/**	 The entity partnerInt
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer partnerInt;

	/**	<br> The entity partnerInt
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:partnerInt">Find the entity partnerInt in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _partnerInt(Wrap<Integer> w);

	public Integer getPartnerInt() {
		return partnerInt;
	}

	public void setPartnerInt(Integer partnerInt) {
		this.partnerInt = partnerInt;
	}
	@JsonIgnore
	public void setPartnerInt(String o) {
		this.partnerInt = CurrikiResource.staticSetPartnerInt(siteRequest_, o);
	}
	public static Integer staticSetPartnerInt(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResource partnerIntInit() {
		Wrap<Integer> partnerIntWrap = new Wrap<Integer>().var("partnerInt");
		if(partnerInt == null) {
			_partnerInt(partnerIntWrap);
			setPartnerInt(partnerIntWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Integer staticSearchPartnerInt(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrPartnerInt(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPartnerInt(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrPartnerInt(siteRequest_, CurrikiResource.staticSearchPartnerInt(siteRequest_, CurrikiResource.staticSetPartnerInt(siteRequest_, o)));
	}

	public Integer sqlPartnerInt() {
		return partnerInt;
	}

	////////////////////
	// reviewResource //
	////////////////////

	/**	 The entity reviewResource
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String reviewResource;

	/**	<br> The entity reviewResource
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:reviewResource">Find the entity reviewResource in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reviewResource(Wrap<String> w);

	public String getReviewResource() {
		return reviewResource;
	}
	public void setReviewResource(String o) {
		this.reviewResource = CurrikiResource.staticSetReviewResource(siteRequest_, o);
	}
	public static String staticSetReviewResource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource reviewResourceInit() {
		Wrap<String> reviewResourceWrap = new Wrap<String>().var("reviewResource");
		if(reviewResource == null) {
			_reviewResource(reviewResourceWrap);
			setReviewResource(reviewResourceWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchReviewResource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrReviewResource(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReviewResource(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrReviewResource(siteRequest_, CurrikiResource.staticSearchReviewResource(siteRequest_, CurrikiResource.staticSetReviewResource(siteRequest_, o)));
	}

	public String sqlReviewResource() {
		return reviewResource;
	}

	////////////
	// oldUrl //
	////////////

	/**	 The entity oldUrl
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String oldUrl;

	/**	<br> The entity oldUrl
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:oldUrl">Find the entity oldUrl in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _oldUrl(Wrap<String> w);

	public String getOldUrl() {
		return oldUrl;
	}
	public void setOldUrl(String o) {
		this.oldUrl = CurrikiResource.staticSetOldUrl(siteRequest_, o);
	}
	public static String staticSetOldUrl(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource oldUrlInit() {
		Wrap<String> oldUrlWrap = new Wrap<String>().var("oldUrl");
		if(oldUrl == null) {
			_oldUrl(oldUrlWrap);
			setOldUrl(oldUrlWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchOldUrl(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrOldUrl(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOldUrl(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrOldUrl(siteRequest_, CurrikiResource.staticSearchOldUrl(siteRequest_, CurrikiResource.staticSetOldUrl(siteRequest_, o)));
	}

	public String sqlOldUrl() {
		return oldUrl;
	}

	//////////////////////
	// contentDisplayOk //
	//////////////////////

	/**	 The entity contentDisplayOk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String contentDisplayOk;

	/**	<br> The entity contentDisplayOk
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:contentDisplayOk">Find the entity contentDisplayOk in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contentDisplayOk(Wrap<String> w);

	public String getContentDisplayOk() {
		return contentDisplayOk;
	}
	public void setContentDisplayOk(String o) {
		this.contentDisplayOk = CurrikiResource.staticSetContentDisplayOk(siteRequest_, o);
	}
	public static String staticSetContentDisplayOk(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource contentDisplayOkInit() {
		Wrap<String> contentDisplayOkWrap = new Wrap<String>().var("contentDisplayOk");
		if(contentDisplayOk == null) {
			_contentDisplayOk(contentDisplayOkWrap);
			setContentDisplayOk(contentDisplayOkWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchContentDisplayOk(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrContentDisplayOk(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqContentDisplayOk(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrContentDisplayOk(siteRequest_, CurrikiResource.staticSearchContentDisplayOk(siteRequest_, CurrikiResource.staticSetContentDisplayOk(siteRequest_, o)));
	}

	public String sqlContentDisplayOk() {
		return contentDisplayOk;
	}

	//////////////
	// metadata //
	//////////////

	/**	 The entity metadata
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String metadata;

	/**	<br> The entity metadata
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:metadata">Find the entity metadata in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _metadata(Wrap<String> w);

	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String o) {
		this.metadata = CurrikiResource.staticSetMetadata(siteRequest_, o);
	}
	public static String staticSetMetadata(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource metadataInit() {
		Wrap<String> metadataWrap = new Wrap<String>().var("metadata");
		if(metadata == null) {
			_metadata(metadataWrap);
			setMetadata(metadataWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchMetadata(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrMetadata(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqMetadata(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrMetadata(siteRequest_, CurrikiResource.staticSearchMetadata(siteRequest_, CurrikiResource.staticSetMetadata(siteRequest_, o)));
	}

	public String sqlMetadata() {
		return metadata;
	}

	////////////////////
	// approvalStatus //
	////////////////////

	/**	 The entity approvalStatus
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String approvalStatus;

	/**	<br> The entity approvalStatus
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:approvalStatus">Find the entity approvalStatus in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _approvalStatus(Wrap<String> w);

	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String o) {
		this.approvalStatus = CurrikiResource.staticSetApprovalStatus(siteRequest_, o);
	}
	public static String staticSetApprovalStatus(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource approvalStatusInit() {
		Wrap<String> approvalStatusWrap = new Wrap<String>().var("approvalStatus");
		if(approvalStatus == null) {
			_approvalStatus(approvalStatusWrap);
			setApprovalStatus(approvalStatusWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchApprovalStatus(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrApprovalStatus(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqApprovalStatus(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrApprovalStatus(siteRequest_, CurrikiResource.staticSearchApprovalStatus(siteRequest_, CurrikiResource.staticSetApprovalStatus(siteRequest_, o)));
	}

	public String sqlApprovalStatus() {
		return approvalStatus;
	}

	////////////////////////
	// approvalStatusDate //
	////////////////////////

	/**	 The entity approvalStatusDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime approvalStatusDate;

	/**	<br> The entity approvalStatusDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:approvalStatusDate">Find the entity approvalStatusDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _approvalStatusDate(Wrap<ZonedDateTime> w);

	public ZonedDateTime getApprovalStatusDate() {
		return approvalStatusDate;
	}

	public void setApprovalStatusDate(ZonedDateTime approvalStatusDate) {
		this.approvalStatusDate = approvalStatusDate;
	}
	@JsonIgnore
	public void setApprovalStatusDate(Instant o) {
		this.approvalStatusDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setApprovalStatusDate(String o) {
		this.approvalStatusDate = CurrikiResource.staticSetApprovalStatusDate(siteRequest_, o);
	}
	public static ZonedDateTime staticSetApprovalStatusDate(SiteRequestEnUS siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setApprovalStatusDate(Date o) {
		this.approvalStatusDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected CurrikiResource approvalStatusDateInit() {
		Wrap<ZonedDateTime> approvalStatusDateWrap = new Wrap<ZonedDateTime>().var("approvalStatusDate");
		if(approvalStatusDate == null) {
			_approvalStatusDate(approvalStatusDateWrap);
			setApprovalStatusDate(approvalStatusDateWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Date staticSearchApprovalStatusDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSearchStrApprovalStatusDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqApprovalStatusDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrApprovalStatusDate(siteRequest_, CurrikiResource.staticSearchApprovalStatusDate(siteRequest_, CurrikiResource.staticSetApprovalStatusDate(siteRequest_, o)));
	}

	public OffsetDateTime sqlApprovalStatusDate() {
		return approvalStatusDate == null ? null : approvalStatusDate.toOffsetDateTime();
	}

	//////////////
	// spamUser //
	//////////////

	/**	 The entity spamUser
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String spamUser;

	/**	<br> The entity spamUser
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=entiteVar_enUS_indexed_string:spamUser">Find the entity spamUser in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _spamUser(Wrap<String> w);

	public String getSpamUser() {
		return spamUser;
	}
	public void setSpamUser(String o) {
		this.spamUser = CurrikiResource.staticSetSpamUser(siteRequest_, o);
	}
	public static String staticSetSpamUser(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected CurrikiResource spamUserInit() {
		Wrap<String> spamUserWrap = new Wrap<String>().var("spamUser");
		if(spamUser == null) {
			_spamUser(spamUserWrap);
			setSpamUser(spamUserWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static String staticSearchSpamUser(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSpamUser(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSpamUser(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSearchStrSpamUser(siteRequest_, CurrikiResource.staticSearchSpamUser(siteRequest_, CurrikiResource.staticSetSpamUser(siteRequest_, o)));
	}

	public String sqlSpamUser() {
		return spamUser;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepCurrikiResource(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepCurrikiResource();
	}

	public Future<Void> promiseDeepCurrikiResource() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseCurrikiResource(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepBaseModel(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseCurrikiResource(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				resourceIdInit();
				licenseIdInit();
				contributorIdInit();
				contributionDateInit();
				descriptionInit();
				titleInit();
				keywordsStrInit();
				keywordsInit();
				generatedKeywordsStrInit();
				generatedKeywordsInit();
				languageInit();
				lastEditorIdInit();
				lastEditDateInit();
				currikiLicenseInit();
				externalUrlInit();
				resourceCheckedInit();
				contentInit();
				resourceCheckRequestNoteInit();
				resourceCheckDateInit();
				resourceCheckIdInit();
				resourceCheckNoteInit();
				studentFacingInit();
				sourceInit();
				reviewStatusInit();
				lastReviewDateInit();
				reviewByIDInit();
				reviewRatingInit();
				technicalCompletenessInit();
				contentAccuracyInit();
				pedagogyInit();
				ratingCommentInit();
				standardsAlignmentInit();
				standardsAlignmentCommentInit();
				subjectMatterInit();
				subjectMatterCommentInit();
				supportsTeachingInit();
				supportsTeachingCommentInit();
				assessmentsQualityInit();
				assessmentsQualityCommentInit();
				interactivityQualityInit();
				interactivityQualityCommentInit();
				instructionalQualityInit();
				instructionalQualityCommentInit();
				deeperLearningInit();
				deeperLearningCommentInit();
				partnerInit();
				createDateInit();
				typeInit();
				featuredInit();
				pageInit();
				activeInit();
				PublicInit();
				xwd_idInit();
				mediaTypeInit();
				accessInit();
				memberRatingInit();
				alignedInit();
				pageUrlInit();
				indexedInit();
				lastIndexDateInit();
				indexRequiredInit();
				indexRequiredDateInit();
				rescrapeInit();
				goButtonInit();
				downloadButtonInit();
				topOfSearchInit();
				removeInit();
				spamInit();
				topOfSearchIntInit();
				partnerIntInit();
				reviewResourceInit();
				oldUrlInit();
				contentDisplayOkInit();
				metadataInit();
				approvalStatusInit();
				approvalStatusDateInit();
				spamUserInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override public Future<Void> promiseDeepForClass(SiteRequestEnUS siteRequest_) {
		return promiseDeepCurrikiResource(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestCurrikiResource(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestCurrikiResource(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainCurrikiResource(v);
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
	public Object obtainCurrikiResource(String var) {
		CurrikiResource oCurrikiResource = (CurrikiResource)this;
		switch(var) {
			case "resourceId":
				return oCurrikiResource.resourceId;
			case "licenseId":
				return oCurrikiResource.licenseId;
			case "contributorId":
				return oCurrikiResource.contributorId;
			case "contributionDate":
				return oCurrikiResource.contributionDate;
			case "description":
				return oCurrikiResource.description;
			case "title":
				return oCurrikiResource.title;
			case "keywordsStr":
				return oCurrikiResource.keywordsStr;
			case "keywords":
				return oCurrikiResource.keywords;
			case "generatedKeywordsStr":
				return oCurrikiResource.generatedKeywordsStr;
			case "generatedKeywords":
				return oCurrikiResource.generatedKeywords;
			case "language":
				return oCurrikiResource.language;
			case "lastEditorId":
				return oCurrikiResource.lastEditorId;
			case "lastEditDate":
				return oCurrikiResource.lastEditDate;
			case "currikiLicense":
				return oCurrikiResource.currikiLicense;
			case "externalUrl":
				return oCurrikiResource.externalUrl;
			case "resourceChecked":
				return oCurrikiResource.resourceChecked;
			case "content":
				return oCurrikiResource.content;
			case "resourceCheckRequestNote":
				return oCurrikiResource.resourceCheckRequestNote;
			case "resourceCheckDate":
				return oCurrikiResource.resourceCheckDate;
			case "resourceCheckId":
				return oCurrikiResource.resourceCheckId;
			case "resourceCheckNote":
				return oCurrikiResource.resourceCheckNote;
			case "studentFacing":
				return oCurrikiResource.studentFacing;
			case "source":
				return oCurrikiResource.source;
			case "reviewStatus":
				return oCurrikiResource.reviewStatus;
			case "lastReviewDate":
				return oCurrikiResource.lastReviewDate;
			case "reviewByID":
				return oCurrikiResource.reviewByID;
			case "reviewRating":
				return oCurrikiResource.reviewRating;
			case "technicalCompleteness":
				return oCurrikiResource.technicalCompleteness;
			case "contentAccuracy":
				return oCurrikiResource.contentAccuracy;
			case "pedagogy":
				return oCurrikiResource.pedagogy;
			case "ratingComment":
				return oCurrikiResource.ratingComment;
			case "standardsAlignment":
				return oCurrikiResource.standardsAlignment;
			case "standardsAlignmentComment":
				return oCurrikiResource.standardsAlignmentComment;
			case "subjectMatter":
				return oCurrikiResource.subjectMatter;
			case "subjectMatterComment":
				return oCurrikiResource.subjectMatterComment;
			case "supportsTeaching":
				return oCurrikiResource.supportsTeaching;
			case "supportsTeachingComment":
				return oCurrikiResource.supportsTeachingComment;
			case "assessmentsQuality":
				return oCurrikiResource.assessmentsQuality;
			case "assessmentsQualityComment":
				return oCurrikiResource.assessmentsQualityComment;
			case "interactivityQuality":
				return oCurrikiResource.interactivityQuality;
			case "interactivityQualityComment":
				return oCurrikiResource.interactivityQualityComment;
			case "instructionalQuality":
				return oCurrikiResource.instructionalQuality;
			case "instructionalQualityComment":
				return oCurrikiResource.instructionalQualityComment;
			case "deeperLearning":
				return oCurrikiResource.deeperLearning;
			case "deeperLearningComment":
				return oCurrikiResource.deeperLearningComment;
			case "partner":
				return oCurrikiResource.partner;
			case "createDate":
				return oCurrikiResource.createDate;
			case "type":
				return oCurrikiResource.type;
			case "featured":
				return oCurrikiResource.featured;
			case "page":
				return oCurrikiResource.page;
			case "active":
				return oCurrikiResource.active;
			case "Public":
				return oCurrikiResource.Public;
			case "xwd_id":
				return oCurrikiResource.xwd_id;
			case "mediaType":
				return oCurrikiResource.mediaType;
			case "access":
				return oCurrikiResource.access;
			case "memberRating":
				return oCurrikiResource.memberRating;
			case "aligned":
				return oCurrikiResource.aligned;
			case "pageUrl":
				return oCurrikiResource.pageUrl;
			case "indexed":
				return oCurrikiResource.indexed;
			case "lastIndexDate":
				return oCurrikiResource.lastIndexDate;
			case "indexRequired":
				return oCurrikiResource.indexRequired;
			case "indexRequiredDate":
				return oCurrikiResource.indexRequiredDate;
			case "rescrape":
				return oCurrikiResource.rescrape;
			case "goButton":
				return oCurrikiResource.goButton;
			case "downloadButton":
				return oCurrikiResource.downloadButton;
			case "topOfSearch":
				return oCurrikiResource.topOfSearch;
			case "remove":
				return oCurrikiResource.remove;
			case "spam":
				return oCurrikiResource.spam;
			case "topOfSearchInt":
				return oCurrikiResource.topOfSearchInt;
			case "partnerInt":
				return oCurrikiResource.partnerInt;
			case "reviewResource":
				return oCurrikiResource.reviewResource;
			case "oldUrl":
				return oCurrikiResource.oldUrl;
			case "contentDisplayOk":
				return oCurrikiResource.contentDisplayOk;
			case "metadata":
				return oCurrikiResource.metadata;
			case "approvalStatus":
				return oCurrikiResource.approvalStatus;
			case "approvalStatusDate":
				return oCurrikiResource.approvalStatusDate;
			case "spamUser":
				return oCurrikiResource.spamUser;
			default:
				return super.obtainBaseModel(var);
		}
	}

	///////////////
	// relate //
	///////////////

	@Override public boolean relateForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = relateCurrikiResource(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateCurrikiResource(String var, Object val) {
		CurrikiResource oCurrikiResource = (CurrikiResource)this;
		switch(var) {
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetCurrikiResource(entityVar,  siteRequest_, o);
	}
	public static Object staticSetCurrikiResource(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "resourceId":
			return CurrikiResource.staticSetResourceId(siteRequest_, o);
		case "licenseId":
			return CurrikiResource.staticSetLicenseId(siteRequest_, o);
		case "contributorId":
			return CurrikiResource.staticSetContributorId(siteRequest_, o);
		case "contributionDate":
			return CurrikiResource.staticSetContributionDate(siteRequest_, o);
		case "description":
			return CurrikiResource.staticSetDescription(siteRequest_, o);
		case "title":
			return CurrikiResource.staticSetTitle(siteRequest_, o);
		case "keywordsStr":
			return CurrikiResource.staticSetKeywordsStr(siteRequest_, o);
		case "keywords":
			return CurrikiResource.staticSetKeywords(siteRequest_, o);
		case "generatedKeywordsStr":
			return CurrikiResource.staticSetGeneratedKeywordsStr(siteRequest_, o);
		case "generatedKeywords":
			return CurrikiResource.staticSetGeneratedKeywords(siteRequest_, o);
		case "language":
			return CurrikiResource.staticSetLanguage(siteRequest_, o);
		case "lastEditorId":
			return CurrikiResource.staticSetLastEditorId(siteRequest_, o);
		case "lastEditDate":
			return CurrikiResource.staticSetLastEditDate(siteRequest_, o);
		case "currikiLicense":
			return CurrikiResource.staticSetCurrikiLicense(siteRequest_, o);
		case "externalUrl":
			return CurrikiResource.staticSetExternalUrl(siteRequest_, o);
		case "resourceChecked":
			return CurrikiResource.staticSetResourceChecked(siteRequest_, o);
		case "content":
			return CurrikiResource.staticSetContent(siteRequest_, o);
		case "resourceCheckRequestNote":
			return CurrikiResource.staticSetResourceCheckRequestNote(siteRequest_, o);
		case "resourceCheckDate":
			return CurrikiResource.staticSetResourceCheckDate(siteRequest_, o);
		case "resourceCheckId":
			return CurrikiResource.staticSetResourceCheckId(siteRequest_, o);
		case "resourceCheckNote":
			return CurrikiResource.staticSetResourceCheckNote(siteRequest_, o);
		case "studentFacing":
			return CurrikiResource.staticSetStudentFacing(siteRequest_, o);
		case "source":
			return CurrikiResource.staticSetSource(siteRequest_, o);
		case "reviewStatus":
			return CurrikiResource.staticSetReviewStatus(siteRequest_, o);
		case "lastReviewDate":
			return CurrikiResource.staticSetLastReviewDate(siteRequest_, o);
		case "reviewByID":
			return CurrikiResource.staticSetReviewByID(siteRequest_, o);
		case "reviewRating":
			return CurrikiResource.staticSetReviewRating(siteRequest_, o);
		case "technicalCompleteness":
			return CurrikiResource.staticSetTechnicalCompleteness(siteRequest_, o);
		case "contentAccuracy":
			return CurrikiResource.staticSetContentAccuracy(siteRequest_, o);
		case "pedagogy":
			return CurrikiResource.staticSetPedagogy(siteRequest_, o);
		case "ratingComment":
			return CurrikiResource.staticSetRatingComment(siteRequest_, o);
		case "standardsAlignment":
			return CurrikiResource.staticSetStandardsAlignment(siteRequest_, o);
		case "standardsAlignmentComment":
			return CurrikiResource.staticSetStandardsAlignmentComment(siteRequest_, o);
		case "subjectMatter":
			return CurrikiResource.staticSetSubjectMatter(siteRequest_, o);
		case "subjectMatterComment":
			return CurrikiResource.staticSetSubjectMatterComment(siteRequest_, o);
		case "supportsTeaching":
			return CurrikiResource.staticSetSupportsTeaching(siteRequest_, o);
		case "supportsTeachingComment":
			return CurrikiResource.staticSetSupportsTeachingComment(siteRequest_, o);
		case "assessmentsQuality":
			return CurrikiResource.staticSetAssessmentsQuality(siteRequest_, o);
		case "assessmentsQualityComment":
			return CurrikiResource.staticSetAssessmentsQualityComment(siteRequest_, o);
		case "interactivityQuality":
			return CurrikiResource.staticSetInteractivityQuality(siteRequest_, o);
		case "interactivityQualityComment":
			return CurrikiResource.staticSetInteractivityQualityComment(siteRequest_, o);
		case "instructionalQuality":
			return CurrikiResource.staticSetInstructionalQuality(siteRequest_, o);
		case "instructionalQualityComment":
			return CurrikiResource.staticSetInstructionalQualityComment(siteRequest_, o);
		case "deeperLearning":
			return CurrikiResource.staticSetDeeperLearning(siteRequest_, o);
		case "deeperLearningComment":
			return CurrikiResource.staticSetDeeperLearningComment(siteRequest_, o);
		case "partner":
			return CurrikiResource.staticSetPartner(siteRequest_, o);
		case "createDate":
			return CurrikiResource.staticSetCreateDate(siteRequest_, o);
		case "type":
			return CurrikiResource.staticSetType(siteRequest_, o);
		case "featured":
			return CurrikiResource.staticSetFeatured(siteRequest_, o);
		case "page":
			return CurrikiResource.staticSetPage(siteRequest_, o);
		case "active":
			return CurrikiResource.staticSetActive(siteRequest_, o);
		case "Public":
			return CurrikiResource.staticSetPublic(siteRequest_, o);
		case "xwd_id":
			return CurrikiResource.staticSetXwd_id(siteRequest_, o);
		case "mediaType":
			return CurrikiResource.staticSetMediaType(siteRequest_, o);
		case "access":
			return CurrikiResource.staticSetAccess(siteRequest_, o);
		case "memberRating":
			return CurrikiResource.staticSetMemberRating(siteRequest_, o);
		case "aligned":
			return CurrikiResource.staticSetAligned(siteRequest_, o);
		case "pageUrl":
			return CurrikiResource.staticSetPageUrl(siteRequest_, o);
		case "indexed":
			return CurrikiResource.staticSetIndexed(siteRequest_, o);
		case "lastIndexDate":
			return CurrikiResource.staticSetLastIndexDate(siteRequest_, o);
		case "indexRequired":
			return CurrikiResource.staticSetIndexRequired(siteRequest_, o);
		case "indexRequiredDate":
			return CurrikiResource.staticSetIndexRequiredDate(siteRequest_, o);
		case "rescrape":
			return CurrikiResource.staticSetRescrape(siteRequest_, o);
		case "goButton":
			return CurrikiResource.staticSetGoButton(siteRequest_, o);
		case "downloadButton":
			return CurrikiResource.staticSetDownloadButton(siteRequest_, o);
		case "topOfSearch":
			return CurrikiResource.staticSetTopOfSearch(siteRequest_, o);
		case "remove":
			return CurrikiResource.staticSetRemove(siteRequest_, o);
		case "spam":
			return CurrikiResource.staticSetSpam(siteRequest_, o);
		case "topOfSearchInt":
			return CurrikiResource.staticSetTopOfSearchInt(siteRequest_, o);
		case "partnerInt":
			return CurrikiResource.staticSetPartnerInt(siteRequest_, o);
		case "reviewResource":
			return CurrikiResource.staticSetReviewResource(siteRequest_, o);
		case "oldUrl":
			return CurrikiResource.staticSetOldUrl(siteRequest_, o);
		case "contentDisplayOk":
			return CurrikiResource.staticSetContentDisplayOk(siteRequest_, o);
		case "metadata":
			return CurrikiResource.staticSetMetadata(siteRequest_, o);
		case "approvalStatus":
			return CurrikiResource.staticSetApprovalStatus(siteRequest_, o);
		case "approvalStatusDate":
			return CurrikiResource.staticSetApprovalStatusDate(siteRequest_, o);
		case "spamUser":
			return CurrikiResource.staticSetSpamUser(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchCurrikiResource(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchCurrikiResource(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "resourceId":
			return CurrikiResource.staticSearchResourceId(siteRequest_, (String)o);
		case "licenseId":
			return CurrikiResource.staticSearchLicenseId(siteRequest_, (String)o);
		case "contributorId":
			return CurrikiResource.staticSearchContributorId(siteRequest_, (Long)o);
		case "contributionDate":
			return CurrikiResource.staticSearchContributionDate(siteRequest_, (ZonedDateTime)o);
		case "description":
			return CurrikiResource.staticSearchDescription(siteRequest_, (String)o);
		case "title":
			return CurrikiResource.staticSearchTitle(siteRequest_, (String)o);
		case "keywordsStr":
			return CurrikiResource.staticSearchKeywordsStr(siteRequest_, (String)o);
		case "keywords":
			return CurrikiResource.staticSearchKeywords(siteRequest_, (String)o);
		case "generatedKeywordsStr":
			return CurrikiResource.staticSearchGeneratedKeywordsStr(siteRequest_, (String)o);
		case "generatedKeywords":
			return CurrikiResource.staticSearchGeneratedKeywords(siteRequest_, (String)o);
		case "language":
			return CurrikiResource.staticSearchLanguage(siteRequest_, (String)o);
		case "lastEditorId":
			return CurrikiResource.staticSearchLastEditorId(siteRequest_, (Long)o);
		case "lastEditDate":
			return CurrikiResource.staticSearchLastEditDate(siteRequest_, (ZonedDateTime)o);
		case "currikiLicense":
			return CurrikiResource.staticSearchCurrikiLicense(siteRequest_, (String)o);
		case "externalUrl":
			return CurrikiResource.staticSearchExternalUrl(siteRequest_, (String)o);
		case "resourceChecked":
			return CurrikiResource.staticSearchResourceChecked(siteRequest_, (String)o);
		case "content":
			return CurrikiResource.staticSearchContent(siteRequest_, (String)o);
		case "resourceCheckRequestNote":
			return CurrikiResource.staticSearchResourceCheckRequestNote(siteRequest_, (String)o);
		case "resourceCheckDate":
			return CurrikiResource.staticSearchResourceCheckDate(siteRequest_, (ZonedDateTime)o);
		case "resourceCheckId":
			return CurrikiResource.staticSearchResourceCheckId(siteRequest_, (Long)o);
		case "resourceCheckNote":
			return CurrikiResource.staticSearchResourceCheckNote(siteRequest_, (String)o);
		case "studentFacing":
			return CurrikiResource.staticSearchStudentFacing(siteRequest_, (String)o);
		case "source":
			return CurrikiResource.staticSearchSource(siteRequest_, (String)o);
		case "reviewStatus":
			return CurrikiResource.staticSearchReviewStatus(siteRequest_, (String)o);
		case "lastReviewDate":
			return CurrikiResource.staticSearchLastReviewDate(siteRequest_, (ZonedDateTime)o);
		case "reviewByID":
			return CurrikiResource.staticSearchReviewByID(siteRequest_, (Long)o);
		case "reviewRating":
			return CurrikiResource.staticSearchReviewRating(siteRequest_, (BigDecimal)o);
		case "technicalCompleteness":
			return CurrikiResource.staticSearchTechnicalCompleteness(siteRequest_, (Integer)o);
		case "contentAccuracy":
			return CurrikiResource.staticSearchContentAccuracy(siteRequest_, (Integer)o);
		case "pedagogy":
			return CurrikiResource.staticSearchPedagogy(siteRequest_, (Integer)o);
		case "ratingComment":
			return CurrikiResource.staticSearchRatingComment(siteRequest_, (String)o);
		case "standardsAlignment":
			return CurrikiResource.staticSearchStandardsAlignment(siteRequest_, (Integer)o);
		case "standardsAlignmentComment":
			return CurrikiResource.staticSearchStandardsAlignmentComment(siteRequest_, (String)o);
		case "subjectMatter":
			return CurrikiResource.staticSearchSubjectMatter(siteRequest_, (Integer)o);
		case "subjectMatterComment":
			return CurrikiResource.staticSearchSubjectMatterComment(siteRequest_, (String)o);
		case "supportsTeaching":
			return CurrikiResource.staticSearchSupportsTeaching(siteRequest_, (Integer)o);
		case "supportsTeachingComment":
			return CurrikiResource.staticSearchSupportsTeachingComment(siteRequest_, (String)o);
		case "assessmentsQuality":
			return CurrikiResource.staticSearchAssessmentsQuality(siteRequest_, (Integer)o);
		case "assessmentsQualityComment":
			return CurrikiResource.staticSearchAssessmentsQualityComment(siteRequest_, (String)o);
		case "interactivityQuality":
			return CurrikiResource.staticSearchInteractivityQuality(siteRequest_, (Integer)o);
		case "interactivityQualityComment":
			return CurrikiResource.staticSearchInteractivityQualityComment(siteRequest_, (String)o);
		case "instructionalQuality":
			return CurrikiResource.staticSearchInstructionalQuality(siteRequest_, (Integer)o);
		case "instructionalQualityComment":
			return CurrikiResource.staticSearchInstructionalQualityComment(siteRequest_, (String)o);
		case "deeperLearning":
			return CurrikiResource.staticSearchDeeperLearning(siteRequest_, (Integer)o);
		case "deeperLearningComment":
			return CurrikiResource.staticSearchDeeperLearningComment(siteRequest_, (String)o);
		case "partner":
			return CurrikiResource.staticSearchPartner(siteRequest_, (String)o);
		case "createDate":
			return CurrikiResource.staticSearchCreateDate(siteRequest_, (ZonedDateTime)o);
		case "type":
			return CurrikiResource.staticSearchType(siteRequest_, (String)o);
		case "featured":
			return CurrikiResource.staticSearchFeatured(siteRequest_, (String)o);
		case "page":
			return CurrikiResource.staticSearchPage(siteRequest_, (String)o);
		case "active":
			return CurrikiResource.staticSearchActive(siteRequest_, (String)o);
		case "Public":
			return CurrikiResource.staticSearchPublic(siteRequest_, (String)o);
		case "xwd_id":
			return CurrikiResource.staticSearchXwd_id(siteRequest_, (Integer)o);
		case "mediaType":
			return CurrikiResource.staticSearchMediaType(siteRequest_, (String)o);
		case "access":
			return CurrikiResource.staticSearchAccess(siteRequest_, (String)o);
		case "memberRating":
			return CurrikiResource.staticSearchMemberRating(siteRequest_, (BigDecimal)o);
		case "aligned":
			return CurrikiResource.staticSearchAligned(siteRequest_, (String)o);
		case "pageUrl":
			return CurrikiResource.staticSearchPageUrl(siteRequest_, (String)o);
		case "indexed":
			return CurrikiResource.staticSearchIndexed(siteRequest_, (String)o);
		case "lastIndexDate":
			return CurrikiResource.staticSearchLastIndexDate(siteRequest_, (ZonedDateTime)o);
		case "indexRequired":
			return CurrikiResource.staticSearchIndexRequired(siteRequest_, (String)o);
		case "indexRequiredDate":
			return CurrikiResource.staticSearchIndexRequiredDate(siteRequest_, (ZonedDateTime)o);
		case "rescrape":
			return CurrikiResource.staticSearchRescrape(siteRequest_, (String)o);
		case "goButton":
			return CurrikiResource.staticSearchGoButton(siteRequest_, (String)o);
		case "downloadButton":
			return CurrikiResource.staticSearchDownloadButton(siteRequest_, (String)o);
		case "topOfSearch":
			return CurrikiResource.staticSearchTopOfSearch(siteRequest_, (String)o);
		case "remove":
			return CurrikiResource.staticSearchRemove(siteRequest_, (String)o);
		case "spam":
			return CurrikiResource.staticSearchSpam(siteRequest_, (String)o);
		case "topOfSearchInt":
			return CurrikiResource.staticSearchTopOfSearchInt(siteRequest_, (Integer)o);
		case "partnerInt":
			return CurrikiResource.staticSearchPartnerInt(siteRequest_, (Integer)o);
		case "reviewResource":
			return CurrikiResource.staticSearchReviewResource(siteRequest_, (String)o);
		case "oldUrl":
			return CurrikiResource.staticSearchOldUrl(siteRequest_, (String)o);
		case "contentDisplayOk":
			return CurrikiResource.staticSearchContentDisplayOk(siteRequest_, (String)o);
		case "metadata":
			return CurrikiResource.staticSearchMetadata(siteRequest_, (String)o);
		case "approvalStatus":
			return CurrikiResource.staticSearchApprovalStatus(siteRequest_, (String)o);
		case "approvalStatusDate":
			return CurrikiResource.staticSearchApprovalStatusDate(siteRequest_, (ZonedDateTime)o);
		case "spamUser":
			return CurrikiResource.staticSearchSpamUser(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrCurrikiResource(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrCurrikiResource(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "resourceId":
			return CurrikiResource.staticSearchStrResourceId(siteRequest_, (String)o);
		case "licenseId":
			return CurrikiResource.staticSearchStrLicenseId(siteRequest_, (String)o);
		case "contributorId":
			return CurrikiResource.staticSearchStrContributorId(siteRequest_, (Long)o);
		case "contributionDate":
			return CurrikiResource.staticSearchStrContributionDate(siteRequest_, (Date)o);
		case "description":
			return CurrikiResource.staticSearchStrDescription(siteRequest_, (String)o);
		case "title":
			return CurrikiResource.staticSearchStrTitle(siteRequest_, (String)o);
		case "keywordsStr":
			return CurrikiResource.staticSearchStrKeywordsStr(siteRequest_, (String)o);
		case "keywords":
			return CurrikiResource.staticSearchStrKeywords(siteRequest_, (String)o);
		case "generatedKeywordsStr":
			return CurrikiResource.staticSearchStrGeneratedKeywordsStr(siteRequest_, (String)o);
		case "generatedKeywords":
			return CurrikiResource.staticSearchStrGeneratedKeywords(siteRequest_, (String)o);
		case "language":
			return CurrikiResource.staticSearchStrLanguage(siteRequest_, (String)o);
		case "lastEditorId":
			return CurrikiResource.staticSearchStrLastEditorId(siteRequest_, (Long)o);
		case "lastEditDate":
			return CurrikiResource.staticSearchStrLastEditDate(siteRequest_, (Date)o);
		case "currikiLicense":
			return CurrikiResource.staticSearchStrCurrikiLicense(siteRequest_, (String)o);
		case "externalUrl":
			return CurrikiResource.staticSearchStrExternalUrl(siteRequest_, (String)o);
		case "resourceChecked":
			return CurrikiResource.staticSearchStrResourceChecked(siteRequest_, (String)o);
		case "content":
			return CurrikiResource.staticSearchStrContent(siteRequest_, (String)o);
		case "resourceCheckRequestNote":
			return CurrikiResource.staticSearchStrResourceCheckRequestNote(siteRequest_, (String)o);
		case "resourceCheckDate":
			return CurrikiResource.staticSearchStrResourceCheckDate(siteRequest_, (Date)o);
		case "resourceCheckId":
			return CurrikiResource.staticSearchStrResourceCheckId(siteRequest_, (Long)o);
		case "resourceCheckNote":
			return CurrikiResource.staticSearchStrResourceCheckNote(siteRequest_, (String)o);
		case "studentFacing":
			return CurrikiResource.staticSearchStrStudentFacing(siteRequest_, (String)o);
		case "source":
			return CurrikiResource.staticSearchStrSource(siteRequest_, (String)o);
		case "reviewStatus":
			return CurrikiResource.staticSearchStrReviewStatus(siteRequest_, (String)o);
		case "lastReviewDate":
			return CurrikiResource.staticSearchStrLastReviewDate(siteRequest_, (Date)o);
		case "reviewByID":
			return CurrikiResource.staticSearchStrReviewByID(siteRequest_, (Long)o);
		case "reviewRating":
			return CurrikiResource.staticSearchStrReviewRating(siteRequest_, (Double)o);
		case "technicalCompleteness":
			return CurrikiResource.staticSearchStrTechnicalCompleteness(siteRequest_, (Integer)o);
		case "contentAccuracy":
			return CurrikiResource.staticSearchStrContentAccuracy(siteRequest_, (Integer)o);
		case "pedagogy":
			return CurrikiResource.staticSearchStrPedagogy(siteRequest_, (Integer)o);
		case "ratingComment":
			return CurrikiResource.staticSearchStrRatingComment(siteRequest_, (String)o);
		case "standardsAlignment":
			return CurrikiResource.staticSearchStrStandardsAlignment(siteRequest_, (Integer)o);
		case "standardsAlignmentComment":
			return CurrikiResource.staticSearchStrStandardsAlignmentComment(siteRequest_, (String)o);
		case "subjectMatter":
			return CurrikiResource.staticSearchStrSubjectMatter(siteRequest_, (Integer)o);
		case "subjectMatterComment":
			return CurrikiResource.staticSearchStrSubjectMatterComment(siteRequest_, (String)o);
		case "supportsTeaching":
			return CurrikiResource.staticSearchStrSupportsTeaching(siteRequest_, (Integer)o);
		case "supportsTeachingComment":
			return CurrikiResource.staticSearchStrSupportsTeachingComment(siteRequest_, (String)o);
		case "assessmentsQuality":
			return CurrikiResource.staticSearchStrAssessmentsQuality(siteRequest_, (Integer)o);
		case "assessmentsQualityComment":
			return CurrikiResource.staticSearchStrAssessmentsQualityComment(siteRequest_, (String)o);
		case "interactivityQuality":
			return CurrikiResource.staticSearchStrInteractivityQuality(siteRequest_, (Integer)o);
		case "interactivityQualityComment":
			return CurrikiResource.staticSearchStrInteractivityQualityComment(siteRequest_, (String)o);
		case "instructionalQuality":
			return CurrikiResource.staticSearchStrInstructionalQuality(siteRequest_, (Integer)o);
		case "instructionalQualityComment":
			return CurrikiResource.staticSearchStrInstructionalQualityComment(siteRequest_, (String)o);
		case "deeperLearning":
			return CurrikiResource.staticSearchStrDeeperLearning(siteRequest_, (Integer)o);
		case "deeperLearningComment":
			return CurrikiResource.staticSearchStrDeeperLearningComment(siteRequest_, (String)o);
		case "partner":
			return CurrikiResource.staticSearchStrPartner(siteRequest_, (String)o);
		case "createDate":
			return CurrikiResource.staticSearchStrCreateDate(siteRequest_, (Date)o);
		case "type":
			return CurrikiResource.staticSearchStrType(siteRequest_, (String)o);
		case "featured":
			return CurrikiResource.staticSearchStrFeatured(siteRequest_, (String)o);
		case "page":
			return CurrikiResource.staticSearchStrPage(siteRequest_, (String)o);
		case "active":
			return CurrikiResource.staticSearchStrActive(siteRequest_, (String)o);
		case "Public":
			return CurrikiResource.staticSearchStrPublic(siteRequest_, (String)o);
		case "xwd_id":
			return CurrikiResource.staticSearchStrXwd_id(siteRequest_, (Integer)o);
		case "mediaType":
			return CurrikiResource.staticSearchStrMediaType(siteRequest_, (String)o);
		case "access":
			return CurrikiResource.staticSearchStrAccess(siteRequest_, (String)o);
		case "memberRating":
			return CurrikiResource.staticSearchStrMemberRating(siteRequest_, (Double)o);
		case "aligned":
			return CurrikiResource.staticSearchStrAligned(siteRequest_, (String)o);
		case "pageUrl":
			return CurrikiResource.staticSearchStrPageUrl(siteRequest_, (String)o);
		case "indexed":
			return CurrikiResource.staticSearchStrIndexed(siteRequest_, (String)o);
		case "lastIndexDate":
			return CurrikiResource.staticSearchStrLastIndexDate(siteRequest_, (Date)o);
		case "indexRequired":
			return CurrikiResource.staticSearchStrIndexRequired(siteRequest_, (String)o);
		case "indexRequiredDate":
			return CurrikiResource.staticSearchStrIndexRequiredDate(siteRequest_, (Date)o);
		case "rescrape":
			return CurrikiResource.staticSearchStrRescrape(siteRequest_, (String)o);
		case "goButton":
			return CurrikiResource.staticSearchStrGoButton(siteRequest_, (String)o);
		case "downloadButton":
			return CurrikiResource.staticSearchStrDownloadButton(siteRequest_, (String)o);
		case "topOfSearch":
			return CurrikiResource.staticSearchStrTopOfSearch(siteRequest_, (String)o);
		case "remove":
			return CurrikiResource.staticSearchStrRemove(siteRequest_, (String)o);
		case "spam":
			return CurrikiResource.staticSearchStrSpam(siteRequest_, (String)o);
		case "topOfSearchInt":
			return CurrikiResource.staticSearchStrTopOfSearchInt(siteRequest_, (Integer)o);
		case "partnerInt":
			return CurrikiResource.staticSearchStrPartnerInt(siteRequest_, (Integer)o);
		case "reviewResource":
			return CurrikiResource.staticSearchStrReviewResource(siteRequest_, (String)o);
		case "oldUrl":
			return CurrikiResource.staticSearchStrOldUrl(siteRequest_, (String)o);
		case "contentDisplayOk":
			return CurrikiResource.staticSearchStrContentDisplayOk(siteRequest_, (String)o);
		case "metadata":
			return CurrikiResource.staticSearchStrMetadata(siteRequest_, (String)o);
		case "approvalStatus":
			return CurrikiResource.staticSearchStrApprovalStatus(siteRequest_, (String)o);
		case "approvalStatusDate":
			return CurrikiResource.staticSearchStrApprovalStatusDate(siteRequest_, (Date)o);
		case "spamUser":
			return CurrikiResource.staticSearchStrSpamUser(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqCurrikiResource(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqCurrikiResource(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "resourceId":
			return CurrikiResource.staticSearchFqResourceId(siteRequest_, o);
		case "licenseId":
			return CurrikiResource.staticSearchFqLicenseId(siteRequest_, o);
		case "contributorId":
			return CurrikiResource.staticSearchFqContributorId(siteRequest_, o);
		case "contributionDate":
			return CurrikiResource.staticSearchFqContributionDate(siteRequest_, o);
		case "description":
			return CurrikiResource.staticSearchFqDescription(siteRequest_, o);
		case "title":
			return CurrikiResource.staticSearchFqTitle(siteRequest_, o);
		case "keywordsStr":
			return CurrikiResource.staticSearchFqKeywordsStr(siteRequest_, o);
		case "keywords":
			return CurrikiResource.staticSearchFqKeywords(siteRequest_, o);
		case "generatedKeywordsStr":
			return CurrikiResource.staticSearchFqGeneratedKeywordsStr(siteRequest_, o);
		case "generatedKeywords":
			return CurrikiResource.staticSearchFqGeneratedKeywords(siteRequest_, o);
		case "language":
			return CurrikiResource.staticSearchFqLanguage(siteRequest_, o);
		case "lastEditorId":
			return CurrikiResource.staticSearchFqLastEditorId(siteRequest_, o);
		case "lastEditDate":
			return CurrikiResource.staticSearchFqLastEditDate(siteRequest_, o);
		case "currikiLicense":
			return CurrikiResource.staticSearchFqCurrikiLicense(siteRequest_, o);
		case "externalUrl":
			return CurrikiResource.staticSearchFqExternalUrl(siteRequest_, o);
		case "resourceChecked":
			return CurrikiResource.staticSearchFqResourceChecked(siteRequest_, o);
		case "content":
			return CurrikiResource.staticSearchFqContent(siteRequest_, o);
		case "resourceCheckRequestNote":
			return CurrikiResource.staticSearchFqResourceCheckRequestNote(siteRequest_, o);
		case "resourceCheckDate":
			return CurrikiResource.staticSearchFqResourceCheckDate(siteRequest_, o);
		case "resourceCheckId":
			return CurrikiResource.staticSearchFqResourceCheckId(siteRequest_, o);
		case "resourceCheckNote":
			return CurrikiResource.staticSearchFqResourceCheckNote(siteRequest_, o);
		case "studentFacing":
			return CurrikiResource.staticSearchFqStudentFacing(siteRequest_, o);
		case "source":
			return CurrikiResource.staticSearchFqSource(siteRequest_, o);
		case "reviewStatus":
			return CurrikiResource.staticSearchFqReviewStatus(siteRequest_, o);
		case "lastReviewDate":
			return CurrikiResource.staticSearchFqLastReviewDate(siteRequest_, o);
		case "reviewByID":
			return CurrikiResource.staticSearchFqReviewByID(siteRequest_, o);
		case "reviewRating":
			return CurrikiResource.staticSearchFqReviewRating(siteRequest_, o);
		case "technicalCompleteness":
			return CurrikiResource.staticSearchFqTechnicalCompleteness(siteRequest_, o);
		case "contentAccuracy":
			return CurrikiResource.staticSearchFqContentAccuracy(siteRequest_, o);
		case "pedagogy":
			return CurrikiResource.staticSearchFqPedagogy(siteRequest_, o);
		case "ratingComment":
			return CurrikiResource.staticSearchFqRatingComment(siteRequest_, o);
		case "standardsAlignment":
			return CurrikiResource.staticSearchFqStandardsAlignment(siteRequest_, o);
		case "standardsAlignmentComment":
			return CurrikiResource.staticSearchFqStandardsAlignmentComment(siteRequest_, o);
		case "subjectMatter":
			return CurrikiResource.staticSearchFqSubjectMatter(siteRequest_, o);
		case "subjectMatterComment":
			return CurrikiResource.staticSearchFqSubjectMatterComment(siteRequest_, o);
		case "supportsTeaching":
			return CurrikiResource.staticSearchFqSupportsTeaching(siteRequest_, o);
		case "supportsTeachingComment":
			return CurrikiResource.staticSearchFqSupportsTeachingComment(siteRequest_, o);
		case "assessmentsQuality":
			return CurrikiResource.staticSearchFqAssessmentsQuality(siteRequest_, o);
		case "assessmentsQualityComment":
			return CurrikiResource.staticSearchFqAssessmentsQualityComment(siteRequest_, o);
		case "interactivityQuality":
			return CurrikiResource.staticSearchFqInteractivityQuality(siteRequest_, o);
		case "interactivityQualityComment":
			return CurrikiResource.staticSearchFqInteractivityQualityComment(siteRequest_, o);
		case "instructionalQuality":
			return CurrikiResource.staticSearchFqInstructionalQuality(siteRequest_, o);
		case "instructionalQualityComment":
			return CurrikiResource.staticSearchFqInstructionalQualityComment(siteRequest_, o);
		case "deeperLearning":
			return CurrikiResource.staticSearchFqDeeperLearning(siteRequest_, o);
		case "deeperLearningComment":
			return CurrikiResource.staticSearchFqDeeperLearningComment(siteRequest_, o);
		case "partner":
			return CurrikiResource.staticSearchFqPartner(siteRequest_, o);
		case "createDate":
			return CurrikiResource.staticSearchFqCreateDate(siteRequest_, o);
		case "type":
			return CurrikiResource.staticSearchFqType(siteRequest_, o);
		case "featured":
			return CurrikiResource.staticSearchFqFeatured(siteRequest_, o);
		case "page":
			return CurrikiResource.staticSearchFqPage(siteRequest_, o);
		case "active":
			return CurrikiResource.staticSearchFqActive(siteRequest_, o);
		case "Public":
			return CurrikiResource.staticSearchFqPublic(siteRequest_, o);
		case "xwd_id":
			return CurrikiResource.staticSearchFqXwd_id(siteRequest_, o);
		case "mediaType":
			return CurrikiResource.staticSearchFqMediaType(siteRequest_, o);
		case "access":
			return CurrikiResource.staticSearchFqAccess(siteRequest_, o);
		case "memberRating":
			return CurrikiResource.staticSearchFqMemberRating(siteRequest_, o);
		case "aligned":
			return CurrikiResource.staticSearchFqAligned(siteRequest_, o);
		case "pageUrl":
			return CurrikiResource.staticSearchFqPageUrl(siteRequest_, o);
		case "indexed":
			return CurrikiResource.staticSearchFqIndexed(siteRequest_, o);
		case "lastIndexDate":
			return CurrikiResource.staticSearchFqLastIndexDate(siteRequest_, o);
		case "indexRequired":
			return CurrikiResource.staticSearchFqIndexRequired(siteRequest_, o);
		case "indexRequiredDate":
			return CurrikiResource.staticSearchFqIndexRequiredDate(siteRequest_, o);
		case "rescrape":
			return CurrikiResource.staticSearchFqRescrape(siteRequest_, o);
		case "goButton":
			return CurrikiResource.staticSearchFqGoButton(siteRequest_, o);
		case "downloadButton":
			return CurrikiResource.staticSearchFqDownloadButton(siteRequest_, o);
		case "topOfSearch":
			return CurrikiResource.staticSearchFqTopOfSearch(siteRequest_, o);
		case "remove":
			return CurrikiResource.staticSearchFqRemove(siteRequest_, o);
		case "spam":
			return CurrikiResource.staticSearchFqSpam(siteRequest_, o);
		case "topOfSearchInt":
			return CurrikiResource.staticSearchFqTopOfSearchInt(siteRequest_, o);
		case "partnerInt":
			return CurrikiResource.staticSearchFqPartnerInt(siteRequest_, o);
		case "reviewResource":
			return CurrikiResource.staticSearchFqReviewResource(siteRequest_, o);
		case "oldUrl":
			return CurrikiResource.staticSearchFqOldUrl(siteRequest_, o);
		case "contentDisplayOk":
			return CurrikiResource.staticSearchFqContentDisplayOk(siteRequest_, o);
		case "metadata":
			return CurrikiResource.staticSearchFqMetadata(siteRequest_, o);
		case "approvalStatus":
			return CurrikiResource.staticSearchFqApprovalStatus(siteRequest_, o);
		case "approvalStatusDate":
			return CurrikiResource.staticSearchFqApprovalStatusDate(siteRequest_, o);
		case "spamUser":
			return CurrikiResource.staticSearchFqSpamUser(siteRequest_, o);
			default:
				return BaseModel.staticSearchFqBaseModel(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// persist //
	/////////////

	@Override public boolean persistForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = persistCurrikiResource(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistCurrikiResource(String var, Object val) {
		switch(var.toLowerCase()) {
			case "resourceid":
				if(val instanceof String)
					setResourceId((String)val);
				saves.add("resourceId");
				return val;
			case "licenseid":
				if(val instanceof String)
					setLicenseId((String)val);
				saves.add("licenseId");
				return val;
			case "contributorid":
				if(val instanceof Long)
					setContributorId((Long)val);
				else if(val instanceof String)
					setContributorId((String)val);
				saves.add("contributorId");
				return val;
			case "contributiondate":
				if(val instanceof ZonedDateTime)
					setContributionDate((ZonedDateTime)val);
				else if(val instanceof String)
					setContributionDate((String)val);
				else if(val instanceof OffsetDateTime)
					setContributionDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				saves.add("contributionDate");
				return val;
			case "description":
				if(val instanceof String)
					setDescription((String)val);
				saves.add("description");
				return val;
			case "title":
				if(val instanceof String)
					setTitle((String)val);
				saves.add("title");
				return val;
			case "keywordsstr":
				if(val instanceof String)
					setKeywordsStr((String)val);
				saves.add("keywordsStr");
				return val;
			case "generatedkeywordsstr":
				if(val instanceof String)
					setGeneratedKeywordsStr((String)val);
				saves.add("generatedKeywordsStr");
				return val;
			case "language":
				if(val instanceof String)
					setLanguage((String)val);
				saves.add("language");
				return val;
			case "lasteditorid":
				if(val instanceof Long)
					setLastEditorId((Long)val);
				else if(val instanceof String)
					setLastEditorId((String)val);
				saves.add("lastEditorId");
				return val;
			case "lasteditdate":
				if(val instanceof ZonedDateTime)
					setLastEditDate((ZonedDateTime)val);
				else if(val instanceof String)
					setLastEditDate((String)val);
				else if(val instanceof OffsetDateTime)
					setLastEditDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				saves.add("lastEditDate");
				return val;
			case "currikilicense":
				if(val instanceof String)
					setCurrikiLicense((String)val);
				saves.add("currikiLicense");
				return val;
			case "externalurl":
				if(val instanceof String)
					setExternalUrl((String)val);
				saves.add("externalUrl");
				return val;
			case "resourcechecked":
				if(val instanceof String)
					setResourceChecked((String)val);
				saves.add("resourceChecked");
				return val;
			case "content":
				if(val instanceof String)
					setContent((String)val);
				saves.add("content");
				return val;
			case "resourcecheckrequestnote":
				if(val instanceof String)
					setResourceCheckRequestNote((String)val);
				saves.add("resourceCheckRequestNote");
				return val;
			case "resourcecheckdate":
				if(val instanceof ZonedDateTime)
					setResourceCheckDate((ZonedDateTime)val);
				else if(val instanceof String)
					setResourceCheckDate((String)val);
				else if(val instanceof OffsetDateTime)
					setResourceCheckDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				saves.add("resourceCheckDate");
				return val;
			case "resourcecheckid":
				if(val instanceof Long)
					setResourceCheckId((Long)val);
				else if(val instanceof String)
					setResourceCheckId((String)val);
				saves.add("resourceCheckId");
				return val;
			case "resourcechecknote":
				if(val instanceof String)
					setResourceCheckNote((String)val);
				saves.add("resourceCheckNote");
				return val;
			case "studentfacing":
				if(val instanceof String)
					setStudentFacing((String)val);
				saves.add("studentFacing");
				return val;
			case "source":
				if(val instanceof String)
					setSource((String)val);
				saves.add("source");
				return val;
			case "reviewstatus":
				if(val instanceof String)
					setReviewStatus((String)val);
				saves.add("reviewStatus");
				return val;
			case "lastreviewdate":
				if(val instanceof ZonedDateTime)
					setLastReviewDate((ZonedDateTime)val);
				else if(val instanceof String)
					setLastReviewDate((String)val);
				else if(val instanceof OffsetDateTime)
					setLastReviewDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				saves.add("lastReviewDate");
				return val;
			case "reviewbyid":
				if(val instanceof Long)
					setReviewByID((Long)val);
				else if(val instanceof String)
					setReviewByID((String)val);
				saves.add("reviewByID");
				return val;
			case "reviewrating":
				if(val instanceof String)
					setReviewRating((String)val);
				else if(val instanceof Number)
					setReviewRating(new BigDecimal(((Number)val).doubleValue()));
				saves.add("reviewRating");
				return val;
			case "technicalcompleteness":
				if(val instanceof Integer)
					setTechnicalCompleteness((Integer)val);
				else if(val instanceof String)
					setTechnicalCompleteness((String)val);
				saves.add("technicalCompleteness");
				return val;
			case "contentaccuracy":
				if(val instanceof Integer)
					setContentAccuracy((Integer)val);
				else if(val instanceof String)
					setContentAccuracy((String)val);
				saves.add("contentAccuracy");
				return val;
			case "pedagogy":
				if(val instanceof Integer)
					setPedagogy((Integer)val);
				else if(val instanceof String)
					setPedagogy((String)val);
				saves.add("pedagogy");
				return val;
			case "ratingcomment":
				if(val instanceof String)
					setRatingComment((String)val);
				saves.add("ratingComment");
				return val;
			case "standardsalignment":
				if(val instanceof Integer)
					setStandardsAlignment((Integer)val);
				else if(val instanceof String)
					setStandardsAlignment((String)val);
				saves.add("standardsAlignment");
				return val;
			case "standardsalignmentcomment":
				if(val instanceof String)
					setStandardsAlignmentComment((String)val);
				saves.add("standardsAlignmentComment");
				return val;
			case "subjectmatter":
				if(val instanceof Integer)
					setSubjectMatter((Integer)val);
				else if(val instanceof String)
					setSubjectMatter((String)val);
				saves.add("subjectMatter");
				return val;
			case "subjectmattercomment":
				if(val instanceof String)
					setSubjectMatterComment((String)val);
				saves.add("subjectMatterComment");
				return val;
			case "supportsteaching":
				if(val instanceof Integer)
					setSupportsTeaching((Integer)val);
				else if(val instanceof String)
					setSupportsTeaching((String)val);
				saves.add("supportsTeaching");
				return val;
			case "supportsteachingcomment":
				if(val instanceof String)
					setSupportsTeachingComment((String)val);
				saves.add("supportsTeachingComment");
				return val;
			case "assessmentsquality":
				if(val instanceof Integer)
					setAssessmentsQuality((Integer)val);
				else if(val instanceof String)
					setAssessmentsQuality((String)val);
				saves.add("assessmentsQuality");
				return val;
			case "assessmentsqualitycomment":
				if(val instanceof String)
					setAssessmentsQualityComment((String)val);
				saves.add("assessmentsQualityComment");
				return val;
			case "interactivityquality":
				if(val instanceof Integer)
					setInteractivityQuality((Integer)val);
				else if(val instanceof String)
					setInteractivityQuality((String)val);
				saves.add("interactivityQuality");
				return val;
			case "interactivityqualitycomment":
				if(val instanceof String)
					setInteractivityQualityComment((String)val);
				saves.add("interactivityQualityComment");
				return val;
			case "instructionalquality":
				if(val instanceof Integer)
					setInstructionalQuality((Integer)val);
				else if(val instanceof String)
					setInstructionalQuality((String)val);
				saves.add("instructionalQuality");
				return val;
			case "instructionalqualitycomment":
				if(val instanceof String)
					setInstructionalQualityComment((String)val);
				saves.add("instructionalQualityComment");
				return val;
			case "deeperlearning":
				if(val instanceof Integer)
					setDeeperLearning((Integer)val);
				else if(val instanceof String)
					setDeeperLearning((String)val);
				saves.add("deeperLearning");
				return val;
			case "deeperlearningcomment":
				if(val instanceof String)
					setDeeperLearningComment((String)val);
				saves.add("deeperLearningComment");
				return val;
			case "partner":
				if(val instanceof String)
					setPartner((String)val);
				saves.add("partner");
				return val;
			case "createdate":
				if(val instanceof ZonedDateTime)
					setCreateDate((ZonedDateTime)val);
				else if(val instanceof String)
					setCreateDate((String)val);
				else if(val instanceof OffsetDateTime)
					setCreateDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				saves.add("createDate");
				return val;
			case "type":
				if(val instanceof String)
					setType((String)val);
				saves.add("type");
				return val;
			case "featured":
				if(val instanceof String)
					setFeatured((String)val);
				saves.add("featured");
				return val;
			case "page":
				if(val instanceof String)
					setPage((String)val);
				saves.add("page");
				return val;
			case "active":
				if(val instanceof String)
					setActive((String)val);
				saves.add("active");
				return val;
			case "public":
				if(val instanceof String)
					setPublic((String)val);
				saves.add("Public");
				return val;
			case "xwd_id":
				if(val instanceof Integer)
					setXwd_id((Integer)val);
				else if(val instanceof String)
					setXwd_id((String)val);
				saves.add("xwd_id");
				return val;
			case "mediatype":
				if(val instanceof String)
					setMediaType((String)val);
				saves.add("mediaType");
				return val;
			case "access":
				if(val instanceof String)
					setAccess((String)val);
				saves.add("access");
				return val;
			case "memberrating":
				if(val instanceof String)
					setMemberRating((String)val);
				else if(val instanceof Number)
					setMemberRating(new BigDecimal(((Number)val).doubleValue()));
				saves.add("memberRating");
				return val;
			case "aligned":
				if(val instanceof String)
					setAligned((String)val);
				saves.add("aligned");
				return val;
			case "pageurl":
				if(val instanceof String)
					setPageUrl((String)val);
				saves.add("pageUrl");
				return val;
			case "indexed":
				if(val instanceof String)
					setIndexed((String)val);
				saves.add("indexed");
				return val;
			case "lastindexdate":
				if(val instanceof ZonedDateTime)
					setLastIndexDate((ZonedDateTime)val);
				else if(val instanceof String)
					setLastIndexDate((String)val);
				else if(val instanceof OffsetDateTime)
					setLastIndexDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				saves.add("lastIndexDate");
				return val;
			case "indexrequired":
				if(val instanceof String)
					setIndexRequired((String)val);
				saves.add("indexRequired");
				return val;
			case "indexrequireddate":
				if(val instanceof ZonedDateTime)
					setIndexRequiredDate((ZonedDateTime)val);
				else if(val instanceof String)
					setIndexRequiredDate((String)val);
				else if(val instanceof OffsetDateTime)
					setIndexRequiredDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				saves.add("indexRequiredDate");
				return val;
			case "rescrape":
				if(val instanceof String)
					setRescrape((String)val);
				saves.add("rescrape");
				return val;
			case "gobutton":
				if(val instanceof String)
					setGoButton((String)val);
				saves.add("goButton");
				return val;
			case "downloadbutton":
				if(val instanceof String)
					setDownloadButton((String)val);
				saves.add("downloadButton");
				return val;
			case "topofsearch":
				if(val instanceof String)
					setTopOfSearch((String)val);
				saves.add("topOfSearch");
				return val;
			case "remove":
				if(val instanceof String)
					setRemove((String)val);
				saves.add("remove");
				return val;
			case "spam":
				if(val instanceof String)
					setSpam((String)val);
				saves.add("spam");
				return val;
			case "topofsearchint":
				if(val instanceof Integer)
					setTopOfSearchInt((Integer)val);
				else if(val instanceof String)
					setTopOfSearchInt((String)val);
				saves.add("topOfSearchInt");
				return val;
			case "partnerint":
				if(val instanceof Integer)
					setPartnerInt((Integer)val);
				else if(val instanceof String)
					setPartnerInt((String)val);
				saves.add("partnerInt");
				return val;
			case "reviewresource":
				if(val instanceof String)
					setReviewResource((String)val);
				saves.add("reviewResource");
				return val;
			case "oldurl":
				if(val instanceof String)
					setOldUrl((String)val);
				saves.add("oldUrl");
				return val;
			case "contentdisplayok":
				if(val instanceof String)
					setContentDisplayOk((String)val);
				saves.add("contentDisplayOk");
				return val;
			case "metadata":
				if(val instanceof String)
					setMetadata((String)val);
				saves.add("metadata");
				return val;
			case "approvalstatus":
				if(val instanceof String)
					setApprovalStatus((String)val);
				saves.add("approvalStatus");
				return val;
			case "approvalstatusdate":
				if(val instanceof ZonedDateTime)
					setApprovalStatusDate((ZonedDateTime)val);
				else if(val instanceof String)
					setApprovalStatusDate((String)val);
				else if(val instanceof OffsetDateTime)
					setApprovalStatusDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				saves.add("approvalStatusDate");
				return val;
			case "spamuser":
				if(val instanceof String)
					setSpamUser((String)val);
				saves.add("spamUser");
				return val;
			default:
				return super.persistBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateCurrikiResource(doc);
	}
	public void populateCurrikiResource(SolrResponse.Doc doc) {
		CurrikiResource oCurrikiResource = (CurrikiResource)this;
		saves = doc.get("saves_docvalues_strings");
		if(saves != null) {

			if(saves.contains("content")) {
				String content = (String)doc.get("content_stored_string");
				if(content != null)
					oCurrikiResource.setContent(content);
			}

			if(saves.contains("ratingComment")) {
				String ratingComment = (String)doc.get("ratingComment_stored_string");
				if(ratingComment != null)
					oCurrikiResource.setRatingComment(ratingComment);
			}
		}

		super.populateBaseModel(doc);
	}

	public void indexCurrikiResource(JsonObject doc) {
		if(resourceId != null) {
			doc.put("resourceId_docvalues_string", resourceId);
		}
		if(licenseId != null) {
			doc.put("licenseId_docvalues_string", licenseId);
		}
		if(contributorId != null) {
			doc.put("contributorId_docvalues_long", contributorId);
		}
		if(contributionDate != null) {
			doc.put("contributionDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(contributionDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(description != null) {
			doc.put("description_docvalues_string", description);
		}
		if(title != null) {
			doc.put("title_docvalues_string", title);
		}
		if(keywords != null) {
			JsonArray l = new JsonArray();
			doc.put("keywords_docvalues_strings", l);
			for(String o : keywords) {
				l.add(o);
			}
		}
		if(generatedKeywords != null) {
			JsonArray l = new JsonArray();
			doc.put("generatedKeywords_docvalues_strings", l);
			for(String o : generatedKeywords) {
				l.add(o);
			}
		}
		if(language != null) {
			doc.put("language_docvalues_string", language);
		}
		if(lastEditorId != null) {
			doc.put("lastEditorId_docvalues_long", lastEditorId);
		}
		if(lastEditDate != null) {
			doc.put("lastEditDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(lastEditDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(currikiLicense != null) {
			doc.put("currikiLicense_docvalues_string", currikiLicense);
		}
		if(externalUrl != null) {
			doc.put("externalUrl_docvalues_string", externalUrl);
		}
		if(resourceChecked != null) {
			doc.put("resourceChecked_docvalues_string", resourceChecked);
		}
		if(content != null) {
			doc.put("content_stored_string", content);
		}
		if(resourceCheckDate != null) {
			doc.put("resourceCheckDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(resourceCheckDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(resourceCheckId != null) {
			doc.put("resourceCheckId_docvalues_long", resourceCheckId);
		}
		if(studentFacing != null) {
			doc.put("studentFacing_docvalues_string", studentFacing);
		}
		if(source != null) {
			doc.put("source_docvalues_string", source);
		}
		if(reviewStatus != null) {
			doc.put("reviewStatus_docvalues_string", reviewStatus);
		}
		if(lastReviewDate != null) {
			doc.put("lastReviewDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(lastReviewDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(reviewByID != null) {
			doc.put("reviewByID_docvalues_long", reviewByID);
		}
		if(reviewRating != null) {
			doc.put("reviewRating_docvalues_double", reviewRating.doubleValue());
		}
		if(technicalCompleteness != null) {
			doc.put("technicalCompleteness_docvalues_int", technicalCompleteness);
		}
		if(contentAccuracy != null) {
			doc.put("contentAccuracy_docvalues_int", contentAccuracy);
		}
		if(pedagogy != null) {
			doc.put("pedagogy_docvalues_int", pedagogy);
		}
		if(ratingComment != null) {
			doc.put("ratingComment_stored_string", ratingComment);
		}
		if(standardsAlignment != null) {
			doc.put("standardsAlignment_docvalues_int", standardsAlignment);
		}
		if(standardsAlignmentComment != null) {
			doc.put("standardsAlignmentComment_docvalues_string", standardsAlignmentComment);
		}
		if(subjectMatter != null) {
			doc.put("subjectMatter_docvalues_int", subjectMatter);
		}
		if(subjectMatterComment != null) {
			doc.put("subjectMatterComment_docvalues_string", subjectMatterComment);
		}
		if(supportsTeaching != null) {
			doc.put("supportsTeaching_docvalues_int", supportsTeaching);
		}
		if(supportsTeachingComment != null) {
			doc.put("supportsTeachingComment_docvalues_string", supportsTeachingComment);
		}
		if(assessmentsQuality != null) {
			doc.put("assessmentsQuality_docvalues_int", assessmentsQuality);
		}
		if(assessmentsQualityComment != null) {
			doc.put("assessmentsQualityComment_docvalues_string", assessmentsQualityComment);
		}
		if(interactivityQuality != null) {
			doc.put("interactivityQuality_docvalues_int", interactivityQuality);
		}
		if(interactivityQualityComment != null) {
			doc.put("interactivityQualityComment_docvalues_string", interactivityQualityComment);
		}
		if(instructionalQuality != null) {
			doc.put("instructionalQuality_docvalues_int", instructionalQuality);
		}
		if(instructionalQualityComment != null) {
			doc.put("instructionalQualityComment_docvalues_string", instructionalQualityComment);
		}
		if(deeperLearning != null) {
			doc.put("deeperLearning_docvalues_int", deeperLearning);
		}
		if(deeperLearningComment != null) {
			doc.put("deeperLearningComment_docvalues_string", deeperLearningComment);
		}
		if(partner != null) {
			doc.put("partner_docvalues_string", partner);
		}
		if(createDate != null) {
			doc.put("createDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(createDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(type != null) {
			doc.put("type_docvalues_string", type);
		}
		if(featured != null) {
			doc.put("featured_docvalues_string", featured);
		}
		if(page != null) {
			doc.put("page_docvalues_string", page);
		}
		if(active != null) {
			doc.put("active_docvalues_string", active);
		}
		if(Public != null) {
			doc.put("Public_docvalues_string", Public);
		}
		if(xwd_id != null) {
			doc.put("xwd_id_docvalues_int", xwd_id);
		}
		if(mediaType != null) {
			doc.put("mediaType_docvalues_string", mediaType);
		}
		if(access != null) {
			doc.put("access_docvalues_string", access);
		}
		if(memberRating != null) {
			doc.put("memberRating_docvalues_double", memberRating.doubleValue());
		}
		if(aligned != null) {
			doc.put("aligned_docvalues_string", aligned);
		}
		if(pageUrl != null) {
			doc.put("pageUrl_docvalues_string", pageUrl);
		}
		if(indexed != null) {
			doc.put("indexed_docvalues_string", indexed);
		}
		if(lastIndexDate != null) {
			doc.put("lastIndexDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(lastIndexDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(indexRequired != null) {
			doc.put("indexRequired_docvalues_string", indexRequired);
		}
		if(indexRequiredDate != null) {
			doc.put("indexRequiredDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(indexRequiredDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(rescrape != null) {
			doc.put("rescrape_docvalues_string", rescrape);
		}
		if(goButton != null) {
			doc.put("goButton_docvalues_string", goButton);
		}
		if(downloadButton != null) {
			doc.put("downloadButton_docvalues_string", downloadButton);
		}
		if(topOfSearch != null) {
			doc.put("topOfSearch_docvalues_string", topOfSearch);
		}
		if(remove != null) {
			doc.put("remove_docvalues_string", remove);
		}
		if(spam != null) {
			doc.put("spam_docvalues_string", spam);
		}
		if(topOfSearchInt != null) {
			doc.put("topOfSearchInt_docvalues_int", topOfSearchInt);
		}
		if(partnerInt != null) {
			doc.put("partnerInt_docvalues_int", partnerInt);
		}
		if(reviewResource != null) {
			doc.put("reviewResource_docvalues_string", reviewResource);
		}
		if(oldUrl != null) {
			doc.put("oldUrl_docvalues_string", oldUrl);
		}
		if(contentDisplayOk != null) {
			doc.put("contentDisplayOk_docvalues_string", contentDisplayOk);
		}
		if(metadata != null) {
			doc.put("metadata_docvalues_string", metadata);
		}
		if(approvalStatus != null) {
			doc.put("approvalStatus_docvalues_string", approvalStatus);
		}
		if(approvalStatusDate != null) {
			doc.put("approvalStatusDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(approvalStatusDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(spamUser != null) {
			doc.put("spamUser_docvalues_string", spamUser);
		}
		super.indexBaseModel(doc);

	}

	public static String varStoredCurrikiResource(String entityVar) {
		switch(entityVar) {
			case "resourceId":
				return "resourceId_docvalues_string";
			case "licenseId":
				return "licenseId_docvalues_string";
			case "contributorId":
				return "contributorId_docvalues_long";
			case "contributionDate":
				return "contributionDate_docvalues_date";
			case "description":
				return "description_docvalues_string";
			case "title":
				return "title_docvalues_string";
			case "keywords":
				return "keywords_docvalues_strings";
			case "generatedKeywords":
				return "generatedKeywords_docvalues_strings";
			case "language":
				return "language_docvalues_string";
			case "lastEditorId":
				return "lastEditorId_docvalues_long";
			case "lastEditDate":
				return "lastEditDate_docvalues_date";
			case "currikiLicense":
				return "currikiLicense_docvalues_string";
			case "externalUrl":
				return "externalUrl_docvalues_string";
			case "resourceChecked":
				return "resourceChecked_docvalues_string";
			case "content":
				return "content_stored_string";
			case "resourceCheckDate":
				return "resourceCheckDate_docvalues_date";
			case "resourceCheckId":
				return "resourceCheckId_docvalues_long";
			case "studentFacing":
				return "studentFacing_docvalues_string";
			case "source":
				return "source_docvalues_string";
			case "reviewStatus":
				return "reviewStatus_docvalues_string";
			case "lastReviewDate":
				return "lastReviewDate_docvalues_date";
			case "reviewByID":
				return "reviewByID_docvalues_long";
			case "reviewRating":
				return "reviewRating_docvalues_double";
			case "technicalCompleteness":
				return "technicalCompleteness_docvalues_int";
			case "contentAccuracy":
				return "contentAccuracy_docvalues_int";
			case "pedagogy":
				return "pedagogy_docvalues_int";
			case "ratingComment":
				return "ratingComment_stored_string";
			case "standardsAlignment":
				return "standardsAlignment_docvalues_int";
			case "standardsAlignmentComment":
				return "standardsAlignmentComment_docvalues_string";
			case "subjectMatter":
				return "subjectMatter_docvalues_int";
			case "subjectMatterComment":
				return "subjectMatterComment_docvalues_string";
			case "supportsTeaching":
				return "supportsTeaching_docvalues_int";
			case "supportsTeachingComment":
				return "supportsTeachingComment_docvalues_string";
			case "assessmentsQuality":
				return "assessmentsQuality_docvalues_int";
			case "assessmentsQualityComment":
				return "assessmentsQualityComment_docvalues_string";
			case "interactivityQuality":
				return "interactivityQuality_docvalues_int";
			case "interactivityQualityComment":
				return "interactivityQualityComment_docvalues_string";
			case "instructionalQuality":
				return "instructionalQuality_docvalues_int";
			case "instructionalQualityComment":
				return "instructionalQualityComment_docvalues_string";
			case "deeperLearning":
				return "deeperLearning_docvalues_int";
			case "deeperLearningComment":
				return "deeperLearningComment_docvalues_string";
			case "partner":
				return "partner_docvalues_string";
			case "createDate":
				return "createDate_docvalues_date";
			case "type":
				return "type_docvalues_string";
			case "featured":
				return "featured_docvalues_string";
			case "page":
				return "page_docvalues_string";
			case "active":
				return "active_docvalues_string";
			case "Public":
				return "Public_docvalues_string";
			case "xwd_id":
				return "xwd_id_docvalues_int";
			case "mediaType":
				return "mediaType_docvalues_string";
			case "access":
				return "access_docvalues_string";
			case "memberRating":
				return "memberRating_docvalues_double";
			case "aligned":
				return "aligned_docvalues_string";
			case "pageUrl":
				return "pageUrl_docvalues_string";
			case "indexed":
				return "indexed_docvalues_string";
			case "lastIndexDate":
				return "lastIndexDate_docvalues_date";
			case "indexRequired":
				return "indexRequired_docvalues_string";
			case "indexRequiredDate":
				return "indexRequiredDate_docvalues_date";
			case "rescrape":
				return "rescrape_docvalues_string";
			case "goButton":
				return "goButton_docvalues_string";
			case "downloadButton":
				return "downloadButton_docvalues_string";
			case "topOfSearch":
				return "topOfSearch_docvalues_string";
			case "remove":
				return "remove_docvalues_string";
			case "spam":
				return "spam_docvalues_string";
			case "topOfSearchInt":
				return "topOfSearchInt_docvalues_int";
			case "partnerInt":
				return "partnerInt_docvalues_int";
			case "reviewResource":
				return "reviewResource_docvalues_string";
			case "oldUrl":
				return "oldUrl_docvalues_string";
			case "contentDisplayOk":
				return "contentDisplayOk_docvalues_string";
			case "metadata":
				return "metadata_docvalues_string";
			case "approvalStatus":
				return "approvalStatus_docvalues_string";
			case "approvalStatusDate":
				return "approvalStatusDate_docvalues_date";
			case "spamUser":
				return "spamUser_docvalues_string";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedCurrikiResource(String entityVar) {
		switch(entityVar) {
			case "resourceId":
				return "resourceId_docvalues_string";
			case "licenseId":
				return "licenseId_docvalues_string";
			case "contributorId":
				return "contributorId_docvalues_long";
			case "contributionDate":
				return "contributionDate_docvalues_date";
			case "description":
				return "description_docvalues_string";
			case "title":
				return "title_docvalues_string";
			case "keywords":
				return "keywords_docvalues_strings";
			case "generatedKeywords":
				return "generatedKeywords_docvalues_strings";
			case "language":
				return "language_docvalues_string";
			case "lastEditorId":
				return "lastEditorId_docvalues_long";
			case "lastEditDate":
				return "lastEditDate_docvalues_date";
			case "currikiLicense":
				return "currikiLicense_docvalues_string";
			case "externalUrl":
				return "externalUrl_docvalues_string";
			case "resourceChecked":
				return "resourceChecked_docvalues_string";
			case "resourceCheckDate":
				return "resourceCheckDate_docvalues_date";
			case "resourceCheckId":
				return "resourceCheckId_docvalues_long";
			case "studentFacing":
				return "studentFacing_docvalues_string";
			case "source":
				return "source_docvalues_string";
			case "reviewStatus":
				return "reviewStatus_docvalues_string";
			case "lastReviewDate":
				return "lastReviewDate_docvalues_date";
			case "reviewByID":
				return "reviewByID_docvalues_long";
			case "reviewRating":
				return "reviewRating_docvalues_double";
			case "technicalCompleteness":
				return "technicalCompleteness_docvalues_int";
			case "contentAccuracy":
				return "contentAccuracy_docvalues_int";
			case "pedagogy":
				return "pedagogy_docvalues_int";
			case "standardsAlignment":
				return "standardsAlignment_docvalues_int";
			case "standardsAlignmentComment":
				return "standardsAlignmentComment_docvalues_string";
			case "subjectMatter":
				return "subjectMatter_docvalues_int";
			case "subjectMatterComment":
				return "subjectMatterComment_docvalues_string";
			case "supportsTeaching":
				return "supportsTeaching_docvalues_int";
			case "supportsTeachingComment":
				return "supportsTeachingComment_docvalues_string";
			case "assessmentsQuality":
				return "assessmentsQuality_docvalues_int";
			case "assessmentsQualityComment":
				return "assessmentsQualityComment_docvalues_string";
			case "interactivityQuality":
				return "interactivityQuality_docvalues_int";
			case "interactivityQualityComment":
				return "interactivityQualityComment_docvalues_string";
			case "instructionalQuality":
				return "instructionalQuality_docvalues_int";
			case "instructionalQualityComment":
				return "instructionalQualityComment_docvalues_string";
			case "deeperLearning":
				return "deeperLearning_docvalues_int";
			case "deeperLearningComment":
				return "deeperLearningComment_docvalues_string";
			case "partner":
				return "partner_docvalues_string";
			case "createDate":
				return "createDate_docvalues_date";
			case "type":
				return "type_docvalues_string";
			case "featured":
				return "featured_docvalues_string";
			case "page":
				return "page_docvalues_string";
			case "active":
				return "active_docvalues_string";
			case "Public":
				return "Public_docvalues_string";
			case "xwd_id":
				return "xwd_id_docvalues_int";
			case "mediaType":
				return "mediaType_docvalues_string";
			case "access":
				return "access_docvalues_string";
			case "memberRating":
				return "memberRating_docvalues_double";
			case "aligned":
				return "aligned_docvalues_string";
			case "pageUrl":
				return "pageUrl_docvalues_string";
			case "indexed":
				return "indexed_docvalues_string";
			case "lastIndexDate":
				return "lastIndexDate_docvalues_date";
			case "indexRequired":
				return "indexRequired_docvalues_string";
			case "indexRequiredDate":
				return "indexRequiredDate_docvalues_date";
			case "rescrape":
				return "rescrape_docvalues_string";
			case "goButton":
				return "goButton_docvalues_string";
			case "downloadButton":
				return "downloadButton_docvalues_string";
			case "topOfSearch":
				return "topOfSearch_docvalues_string";
			case "remove":
				return "remove_docvalues_string";
			case "spam":
				return "spam_docvalues_string";
			case "topOfSearchInt":
				return "topOfSearchInt_docvalues_int";
			case "partnerInt":
				return "partnerInt_docvalues_int";
			case "reviewResource":
				return "reviewResource_docvalues_string";
			case "oldUrl":
				return "oldUrl_docvalues_string";
			case "contentDisplayOk":
				return "contentDisplayOk_docvalues_string";
			case "metadata":
				return "metadata_docvalues_string";
			case "approvalStatus":
				return "approvalStatus_docvalues_string";
			case "approvalStatusDate":
				return "approvalStatusDate_docvalues_date";
			case "spamUser":
				return "spamUser_docvalues_string";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String varSearchCurrikiResource(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedCurrikiResource(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeCurrikiResource(doc);
	}
	public void storeCurrikiResource(SolrResponse.Doc doc) {
		CurrikiResource oCurrikiResource = (CurrikiResource)this;

		oCurrikiResource.setResourceId(Optional.ofNullable(doc.get("resourceId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setLicenseId(Optional.ofNullable(doc.get("licenseId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setContributorId(Optional.ofNullable(doc.get("contributorId_docvalues_long")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setContributionDate(Optional.ofNullable(doc.get("contributionDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setDescription(Optional.ofNullable(doc.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setTitle(Optional.ofNullable(doc.get("title_docvalues_string")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("keywords_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oCurrikiResource.addKeywords(v.toString());
		});
		Optional.ofNullable((List<?>)doc.get("generatedKeywords_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oCurrikiResource.addGeneratedKeywords(v.toString());
		});
		oCurrikiResource.setLanguage(Optional.ofNullable(doc.get("language_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setLastEditorId(Optional.ofNullable(doc.get("lastEditorId_docvalues_long")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setLastEditDate(Optional.ofNullable(doc.get("lastEditDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setCurrikiLicense(Optional.ofNullable(doc.get("currikiLicense_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setExternalUrl(Optional.ofNullable(doc.get("externalUrl_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setResourceChecked(Optional.ofNullable(doc.get("resourceChecked_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setContent(Optional.ofNullable(doc.get("content_stored_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setResourceCheckDate(Optional.ofNullable(doc.get("resourceCheckDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setResourceCheckId(Optional.ofNullable(doc.get("resourceCheckId_docvalues_long")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setStudentFacing(Optional.ofNullable(doc.get("studentFacing_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSource(Optional.ofNullable(doc.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setReviewStatus(Optional.ofNullable(doc.get("reviewStatus_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setLastReviewDate(Optional.ofNullable(doc.get("lastReviewDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setReviewByID(Optional.ofNullable(doc.get("reviewByID_docvalues_long")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setReviewRating(Optional.ofNullable(doc.get("reviewRating_docvalues_double")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setTechnicalCompleteness(Optional.ofNullable(doc.get("technicalCompleteness_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setContentAccuracy(Optional.ofNullable(doc.get("contentAccuracy_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setPedagogy(Optional.ofNullable(doc.get("pedagogy_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setRatingComment(Optional.ofNullable(doc.get("ratingComment_stored_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setStandardsAlignment(Optional.ofNullable(doc.get("standardsAlignment_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setStandardsAlignmentComment(Optional.ofNullable(doc.get("standardsAlignmentComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSubjectMatter(Optional.ofNullable(doc.get("subjectMatter_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSubjectMatterComment(Optional.ofNullable(doc.get("subjectMatterComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSupportsTeaching(Optional.ofNullable(doc.get("supportsTeaching_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSupportsTeachingComment(Optional.ofNullable(doc.get("supportsTeachingComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setAssessmentsQuality(Optional.ofNullable(doc.get("assessmentsQuality_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setAssessmentsQualityComment(Optional.ofNullable(doc.get("assessmentsQualityComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setInteractivityQuality(Optional.ofNullable(doc.get("interactivityQuality_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setInteractivityQualityComment(Optional.ofNullable(doc.get("interactivityQualityComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setInstructionalQuality(Optional.ofNullable(doc.get("instructionalQuality_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setInstructionalQualityComment(Optional.ofNullable(doc.get("instructionalQualityComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setDeeperLearning(Optional.ofNullable(doc.get("deeperLearning_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setDeeperLearningComment(Optional.ofNullable(doc.get("deeperLearningComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setPartner(Optional.ofNullable(doc.get("partner_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setCreateDate(Optional.ofNullable(doc.get("createDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setType(Optional.ofNullable(doc.get("type_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setFeatured(Optional.ofNullable(doc.get("featured_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setPage(Optional.ofNullable(doc.get("page_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setActive(Optional.ofNullable(doc.get("active_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setPublic(Optional.ofNullable(doc.get("Public_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setXwd_id(Optional.ofNullable(doc.get("xwd_id_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setMediaType(Optional.ofNullable(doc.get("mediaType_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setAccess(Optional.ofNullable(doc.get("access_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setMemberRating(Optional.ofNullable(doc.get("memberRating_docvalues_double")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setAligned(Optional.ofNullable(doc.get("aligned_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setPageUrl(Optional.ofNullable(doc.get("pageUrl_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setIndexed(Optional.ofNullable(doc.get("indexed_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setLastIndexDate(Optional.ofNullable(doc.get("lastIndexDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setIndexRequired(Optional.ofNullable(doc.get("indexRequired_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setIndexRequiredDate(Optional.ofNullable(doc.get("indexRequiredDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setRescrape(Optional.ofNullable(doc.get("rescrape_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setGoButton(Optional.ofNullable(doc.get("goButton_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setDownloadButton(Optional.ofNullable(doc.get("downloadButton_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setTopOfSearch(Optional.ofNullable(doc.get("topOfSearch_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setRemove(Optional.ofNullable(doc.get("remove_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSpam(Optional.ofNullable(doc.get("spam_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setTopOfSearchInt(Optional.ofNullable(doc.get("topOfSearchInt_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setPartnerInt(Optional.ofNullable(doc.get("partnerInt_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setReviewResource(Optional.ofNullable(doc.get("reviewResource_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setOldUrl(Optional.ofNullable(doc.get("oldUrl_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setContentDisplayOk(Optional.ofNullable(doc.get("contentDisplayOk_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setMetadata(Optional.ofNullable(doc.get("metadata_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setApprovalStatus(Optional.ofNullable(doc.get("approvalStatus_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setApprovalStatusDate(Optional.ofNullable(doc.get("approvalStatusDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSpamUser(Optional.ofNullable(doc.get("spamUser_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestCurrikiResource() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof CurrikiResource) {
			CurrikiResource original = (CurrikiResource)o;
			if(!Objects.equals(resourceId, original.getResourceId()))
				apiRequest.addVars("resourceId");
			if(!Objects.equals(licenseId, original.getLicenseId()))
				apiRequest.addVars("licenseId");
			if(!Objects.equals(contributorId, original.getContributorId()))
				apiRequest.addVars("contributorId");
			if(!Objects.equals(contributionDate, original.getContributionDate()))
				apiRequest.addVars("contributionDate");
			if(!Objects.equals(description, original.getDescription()))
				apiRequest.addVars("description");
			if(!Objects.equals(title, original.getTitle()))
				apiRequest.addVars("title");
			if(!Objects.equals(keywordsStr, original.getKeywordsStr()))
				apiRequest.addVars("keywordsStr");
			if(!Objects.equals(keywords, original.getKeywords()))
				apiRequest.addVars("keywords");
			if(!Objects.equals(generatedKeywordsStr, original.getGeneratedKeywordsStr()))
				apiRequest.addVars("generatedKeywordsStr");
			if(!Objects.equals(generatedKeywords, original.getGeneratedKeywords()))
				apiRequest.addVars("generatedKeywords");
			if(!Objects.equals(language, original.getLanguage()))
				apiRequest.addVars("language");
			if(!Objects.equals(lastEditorId, original.getLastEditorId()))
				apiRequest.addVars("lastEditorId");
			if(!Objects.equals(lastEditDate, original.getLastEditDate()))
				apiRequest.addVars("lastEditDate");
			if(!Objects.equals(currikiLicense, original.getCurrikiLicense()))
				apiRequest.addVars("currikiLicense");
			if(!Objects.equals(externalUrl, original.getExternalUrl()))
				apiRequest.addVars("externalUrl");
			if(!Objects.equals(resourceChecked, original.getResourceChecked()))
				apiRequest.addVars("resourceChecked");
			if(!Objects.equals(content, original.getContent()))
				apiRequest.addVars("content");
			if(!Objects.equals(resourceCheckRequestNote, original.getResourceCheckRequestNote()))
				apiRequest.addVars("resourceCheckRequestNote");
			if(!Objects.equals(resourceCheckDate, original.getResourceCheckDate()))
				apiRequest.addVars("resourceCheckDate");
			if(!Objects.equals(resourceCheckId, original.getResourceCheckId()))
				apiRequest.addVars("resourceCheckId");
			if(!Objects.equals(resourceCheckNote, original.getResourceCheckNote()))
				apiRequest.addVars("resourceCheckNote");
			if(!Objects.equals(studentFacing, original.getStudentFacing()))
				apiRequest.addVars("studentFacing");
			if(!Objects.equals(source, original.getSource()))
				apiRequest.addVars("source");
			if(!Objects.equals(reviewStatus, original.getReviewStatus()))
				apiRequest.addVars("reviewStatus");
			if(!Objects.equals(lastReviewDate, original.getLastReviewDate()))
				apiRequest.addVars("lastReviewDate");
			if(!Objects.equals(reviewByID, original.getReviewByID()))
				apiRequest.addVars("reviewByID");
			if(!Objects.equals(reviewRating, original.getReviewRating()))
				apiRequest.addVars("reviewRating");
			if(!Objects.equals(technicalCompleteness, original.getTechnicalCompleteness()))
				apiRequest.addVars("technicalCompleteness");
			if(!Objects.equals(contentAccuracy, original.getContentAccuracy()))
				apiRequest.addVars("contentAccuracy");
			if(!Objects.equals(pedagogy, original.getPedagogy()))
				apiRequest.addVars("pedagogy");
			if(!Objects.equals(ratingComment, original.getRatingComment()))
				apiRequest.addVars("ratingComment");
			if(!Objects.equals(standardsAlignment, original.getStandardsAlignment()))
				apiRequest.addVars("standardsAlignment");
			if(!Objects.equals(standardsAlignmentComment, original.getStandardsAlignmentComment()))
				apiRequest.addVars("standardsAlignmentComment");
			if(!Objects.equals(subjectMatter, original.getSubjectMatter()))
				apiRequest.addVars("subjectMatter");
			if(!Objects.equals(subjectMatterComment, original.getSubjectMatterComment()))
				apiRequest.addVars("subjectMatterComment");
			if(!Objects.equals(supportsTeaching, original.getSupportsTeaching()))
				apiRequest.addVars("supportsTeaching");
			if(!Objects.equals(supportsTeachingComment, original.getSupportsTeachingComment()))
				apiRequest.addVars("supportsTeachingComment");
			if(!Objects.equals(assessmentsQuality, original.getAssessmentsQuality()))
				apiRequest.addVars("assessmentsQuality");
			if(!Objects.equals(assessmentsQualityComment, original.getAssessmentsQualityComment()))
				apiRequest.addVars("assessmentsQualityComment");
			if(!Objects.equals(interactivityQuality, original.getInteractivityQuality()))
				apiRequest.addVars("interactivityQuality");
			if(!Objects.equals(interactivityQualityComment, original.getInteractivityQualityComment()))
				apiRequest.addVars("interactivityQualityComment");
			if(!Objects.equals(instructionalQuality, original.getInstructionalQuality()))
				apiRequest.addVars("instructionalQuality");
			if(!Objects.equals(instructionalQualityComment, original.getInstructionalQualityComment()))
				apiRequest.addVars("instructionalQualityComment");
			if(!Objects.equals(deeperLearning, original.getDeeperLearning()))
				apiRequest.addVars("deeperLearning");
			if(!Objects.equals(deeperLearningComment, original.getDeeperLearningComment()))
				apiRequest.addVars("deeperLearningComment");
			if(!Objects.equals(partner, original.getPartner()))
				apiRequest.addVars("partner");
			if(!Objects.equals(createDate, original.getCreateDate()))
				apiRequest.addVars("createDate");
			if(!Objects.equals(type, original.getType()))
				apiRequest.addVars("type");
			if(!Objects.equals(featured, original.getFeatured()))
				apiRequest.addVars("featured");
			if(!Objects.equals(page, original.getPage()))
				apiRequest.addVars("page");
			if(!Objects.equals(active, original.getActive()))
				apiRequest.addVars("active");
			if(!Objects.equals(Public, original.getPublic()))
				apiRequest.addVars("Public");
			if(!Objects.equals(xwd_id, original.getXwd_id()))
				apiRequest.addVars("xwd_id");
			if(!Objects.equals(mediaType, original.getMediaType()))
				apiRequest.addVars("mediaType");
			if(!Objects.equals(access, original.getAccess()))
				apiRequest.addVars("access");
			if(!Objects.equals(memberRating, original.getMemberRating()))
				apiRequest.addVars("memberRating");
			if(!Objects.equals(aligned, original.getAligned()))
				apiRequest.addVars("aligned");
			if(!Objects.equals(pageUrl, original.getPageUrl()))
				apiRequest.addVars("pageUrl");
			if(!Objects.equals(indexed, original.getIndexed()))
				apiRequest.addVars("indexed");
			if(!Objects.equals(lastIndexDate, original.getLastIndexDate()))
				apiRequest.addVars("lastIndexDate");
			if(!Objects.equals(indexRequired, original.getIndexRequired()))
				apiRequest.addVars("indexRequired");
			if(!Objects.equals(indexRequiredDate, original.getIndexRequiredDate()))
				apiRequest.addVars("indexRequiredDate");
			if(!Objects.equals(rescrape, original.getRescrape()))
				apiRequest.addVars("rescrape");
			if(!Objects.equals(goButton, original.getGoButton()))
				apiRequest.addVars("goButton");
			if(!Objects.equals(downloadButton, original.getDownloadButton()))
				apiRequest.addVars("downloadButton");
			if(!Objects.equals(topOfSearch, original.getTopOfSearch()))
				apiRequest.addVars("topOfSearch");
			if(!Objects.equals(remove, original.getRemove()))
				apiRequest.addVars("remove");
			if(!Objects.equals(spam, original.getSpam()))
				apiRequest.addVars("spam");
			if(!Objects.equals(topOfSearchInt, original.getTopOfSearchInt()))
				apiRequest.addVars("topOfSearchInt");
			if(!Objects.equals(partnerInt, original.getPartnerInt()))
				apiRequest.addVars("partnerInt");
			if(!Objects.equals(reviewResource, original.getReviewResource()))
				apiRequest.addVars("reviewResource");
			if(!Objects.equals(oldUrl, original.getOldUrl()))
				apiRequest.addVars("oldUrl");
			if(!Objects.equals(contentDisplayOk, original.getContentDisplayOk()))
				apiRequest.addVars("contentDisplayOk");
			if(!Objects.equals(metadata, original.getMetadata()))
				apiRequest.addVars("metadata");
			if(!Objects.equals(approvalStatus, original.getApprovalStatus()))
				apiRequest.addVars("approvalStatus");
			if(!Objects.equals(approvalStatusDate, original.getApprovalStatusDate()))
				apiRequest.addVars("approvalStatusDate");
			if(!Objects.equals(spamUser, original.getSpamUser()))
				apiRequest.addVars("spamUser");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(resourceId).map(v -> "resourceId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(licenseId).map(v -> "licenseId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(contributorId).map(v -> "contributorId: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(contributionDate).map(v -> "contributionDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(description).map(v -> "description: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(title).map(v -> "title: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(keywordsStr).map(v -> "keywordsStr: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(keywords).map(v -> "keywords: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(generatedKeywordsStr).map(v -> "generatedKeywordsStr: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(generatedKeywords).map(v -> "generatedKeywords: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(language).map(v -> "language: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(lastEditorId).map(v -> "lastEditorId: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(lastEditDate).map(v -> "lastEditDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(currikiLicense).map(v -> "currikiLicense: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(externalUrl).map(v -> "externalUrl: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(resourceChecked).map(v -> "resourceChecked: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(content).map(v -> "content: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(resourceCheckRequestNote).map(v -> "resourceCheckRequestNote: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(resourceCheckDate).map(v -> "resourceCheckDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(resourceCheckId).map(v -> "resourceCheckId: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(resourceCheckNote).map(v -> "resourceCheckNote: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(studentFacing).map(v -> "studentFacing: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(source).map(v -> "source: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(reviewStatus).map(v -> "reviewStatus: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(lastReviewDate).map(v -> "lastReviewDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(reviewByID).map(v -> "reviewByID: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(reviewRating).map(v -> "reviewRating: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(technicalCompleteness).map(v -> "technicalCompleteness: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(contentAccuracy).map(v -> "contentAccuracy: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(pedagogy).map(v -> "pedagogy: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(ratingComment).map(v -> "ratingComment: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(standardsAlignment).map(v -> "standardsAlignment: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(standardsAlignmentComment).map(v -> "standardsAlignmentComment: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(subjectMatter).map(v -> "subjectMatter: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(subjectMatterComment).map(v -> "subjectMatterComment: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(supportsTeaching).map(v -> "supportsTeaching: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(supportsTeachingComment).map(v -> "supportsTeachingComment: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(assessmentsQuality).map(v -> "assessmentsQuality: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(assessmentsQualityComment).map(v -> "assessmentsQualityComment: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(interactivityQuality).map(v -> "interactivityQuality: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(interactivityQualityComment).map(v -> "interactivityQualityComment: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(instructionalQuality).map(v -> "instructionalQuality: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(instructionalQualityComment).map(v -> "instructionalQualityComment: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(deeperLearning).map(v -> "deeperLearning: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(deeperLearningComment).map(v -> "deeperLearningComment: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(partner).map(v -> "partner: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(createDate).map(v -> "createDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(type).map(v -> "type: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(featured).map(v -> "featured: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(page).map(v -> "page: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(active).map(v -> "active: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(Public).map(v -> "Public: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(xwd_id).map(v -> "xwd_id: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(mediaType).map(v -> "mediaType: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(access).map(v -> "access: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(memberRating).map(v -> "memberRating: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(aligned).map(v -> "aligned: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(pageUrl).map(v -> "pageUrl: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(indexed).map(v -> "indexed: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(lastIndexDate).map(v -> "lastIndexDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(indexRequired).map(v -> "indexRequired: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(indexRequiredDate).map(v -> "indexRequiredDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(rescrape).map(v -> "rescrape: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(goButton).map(v -> "goButton: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(downloadButton).map(v -> "downloadButton: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(topOfSearch).map(v -> "topOfSearch: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(remove).map(v -> "remove: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(spam).map(v -> "spam: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(topOfSearchInt).map(v -> "topOfSearchInt: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(partnerInt).map(v -> "partnerInt: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(reviewResource).map(v -> "reviewResource: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(oldUrl).map(v -> "oldUrl: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(contentDisplayOk).map(v -> "contentDisplayOk: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(metadata).map(v -> "metadata: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(approvalStatus).map(v -> "approvalStatus: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(approvalStatusDate).map(v -> "approvalStatusDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(spamUser).map(v -> "spamUser: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "CurrikiResource";
	public static final String VAR_resourceId = "resourceId";
	public static final String VAR_licenseId = "licenseId";
	public static final String VAR_contributorId = "contributorId";
	public static final String VAR_contributionDate = "contributionDate";
	public static final String VAR_description = "description";
	public static final String VAR_title = "title";
	public static final String VAR_keywordsStr = "keywordsStr";
	public static final String VAR_keywords = "keywords";
	public static final String VAR_generatedKeywordsStr = "generatedKeywordsStr";
	public static final String VAR_generatedKeywords = "generatedKeywords";
	public static final String VAR_language = "language";
	public static final String VAR_lastEditorId = "lastEditorId";
	public static final String VAR_lastEditDate = "lastEditDate";
	public static final String VAR_currikiLicense = "currikiLicense";
	public static final String VAR_externalUrl = "externalUrl";
	public static final String VAR_resourceChecked = "resourceChecked";
	public static final String VAR_content = "content";
	public static final String VAR_resourceCheckRequestNote = "resourceCheckRequestNote";
	public static final String VAR_resourceCheckDate = "resourceCheckDate";
	public static final String VAR_resourceCheckId = "resourceCheckId";
	public static final String VAR_resourceCheckNote = "resourceCheckNote";
	public static final String VAR_studentFacing = "studentFacing";
	public static final String VAR_source = "source";
	public static final String VAR_reviewStatus = "reviewStatus";
	public static final String VAR_lastReviewDate = "lastReviewDate";
	public static final String VAR_reviewByID = "reviewByID";
	public static final String VAR_reviewRating = "reviewRating";
	public static final String VAR_technicalCompleteness = "technicalCompleteness";
	public static final String VAR_contentAccuracy = "contentAccuracy";
	public static final String VAR_pedagogy = "pedagogy";
	public static final String VAR_ratingComment = "ratingComment";
	public static final String VAR_standardsAlignment = "standardsAlignment";
	public static final String VAR_standardsAlignmentComment = "standardsAlignmentComment";
	public static final String VAR_subjectMatter = "subjectMatter";
	public static final String VAR_subjectMatterComment = "subjectMatterComment";
	public static final String VAR_supportsTeaching = "supportsTeaching";
	public static final String VAR_supportsTeachingComment = "supportsTeachingComment";
	public static final String VAR_assessmentsQuality = "assessmentsQuality";
	public static final String VAR_assessmentsQualityComment = "assessmentsQualityComment";
	public static final String VAR_interactivityQuality = "interactivityQuality";
	public static final String VAR_interactivityQualityComment = "interactivityQualityComment";
	public static final String VAR_instructionalQuality = "instructionalQuality";
	public static final String VAR_instructionalQualityComment = "instructionalQualityComment";
	public static final String VAR_deeperLearning = "deeperLearning";
	public static final String VAR_deeperLearningComment = "deeperLearningComment";
	public static final String VAR_partner = "partner";
	public static final String VAR_createDate = "createDate";
	public static final String VAR_type = "type";
	public static final String VAR_featured = "featured";
	public static final String VAR_page = "page";
	public static final String VAR_active = "active";
	public static final String VAR_Public = "Public";
	public static final String VAR_xwd_id = "xwd_id";
	public static final String VAR_mediaType = "mediaType";
	public static final String VAR_access = "access";
	public static final String VAR_memberRating = "memberRating";
	public static final String VAR_aligned = "aligned";
	public static final String VAR_pageUrl = "pageUrl";
	public static final String VAR_indexed = "indexed";
	public static final String VAR_lastIndexDate = "lastIndexDate";
	public static final String VAR_indexRequired = "indexRequired";
	public static final String VAR_indexRequiredDate = "indexRequiredDate";
	public static final String VAR_rescrape = "rescrape";
	public static final String VAR_goButton = "goButton";
	public static final String VAR_downloadButton = "downloadButton";
	public static final String VAR_topOfSearch = "topOfSearch";
	public static final String VAR_remove = "remove";
	public static final String VAR_spam = "spam";
	public static final String VAR_topOfSearchInt = "topOfSearchInt";
	public static final String VAR_partnerInt = "partnerInt";
	public static final String VAR_reviewResource = "reviewResource";
	public static final String VAR_oldUrl = "oldUrl";
	public static final String VAR_contentDisplayOk = "contentDisplayOk";
	public static final String VAR_metadata = "metadata";
	public static final String VAR_approvalStatus = "approvalStatus";
	public static final String VAR_approvalStatusDate = "approvalStatusDate";
	public static final String VAR_spamUser = "spamUser";

	public static List<String> varsQForClass() {
		return CurrikiResource.varsQCurrikiResource(new ArrayList<String>());
	}
	public static List<String> varsQCurrikiResource(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return CurrikiResource.varsFqCurrikiResource(new ArrayList<String>());
	}
	public static List<String> varsFqCurrikiResource(List<String> vars) {
		vars.add(VAR_resourceId);
		vars.add(VAR_licenseId);
		vars.add(VAR_contributorId);
		vars.add(VAR_contributionDate);
		vars.add(VAR_description);
		vars.add(VAR_title);
		vars.add(VAR_keywords);
		vars.add(VAR_generatedKeywords);
		vars.add(VAR_language);
		vars.add(VAR_lastEditorId);
		vars.add(VAR_lastEditDate);
		vars.add(VAR_currikiLicense);
		vars.add(VAR_externalUrl);
		vars.add(VAR_resourceChecked);
		vars.add(VAR_resourceCheckDate);
		vars.add(VAR_resourceCheckId);
		vars.add(VAR_studentFacing);
		vars.add(VAR_source);
		vars.add(VAR_reviewStatus);
		vars.add(VAR_lastReviewDate);
		vars.add(VAR_reviewByID);
		vars.add(VAR_reviewRating);
		vars.add(VAR_technicalCompleteness);
		vars.add(VAR_contentAccuracy);
		vars.add(VAR_pedagogy);
		vars.add(VAR_standardsAlignment);
		vars.add(VAR_standardsAlignmentComment);
		vars.add(VAR_subjectMatter);
		vars.add(VAR_subjectMatterComment);
		vars.add(VAR_supportsTeaching);
		vars.add(VAR_supportsTeachingComment);
		vars.add(VAR_assessmentsQuality);
		vars.add(VAR_assessmentsQualityComment);
		vars.add(VAR_interactivityQuality);
		vars.add(VAR_interactivityQualityComment);
		vars.add(VAR_instructionalQuality);
		vars.add(VAR_instructionalQualityComment);
		vars.add(VAR_deeperLearning);
		vars.add(VAR_deeperLearningComment);
		vars.add(VAR_partner);
		vars.add(VAR_createDate);
		vars.add(VAR_type);
		vars.add(VAR_featured);
		vars.add(VAR_page);
		vars.add(VAR_active);
		vars.add(VAR_Public);
		vars.add(VAR_xwd_id);
		vars.add(VAR_mediaType);
		vars.add(VAR_access);
		vars.add(VAR_memberRating);
		vars.add(VAR_aligned);
		vars.add(VAR_pageUrl);
		vars.add(VAR_indexed);
		vars.add(VAR_lastIndexDate);
		vars.add(VAR_indexRequired);
		vars.add(VAR_indexRequiredDate);
		vars.add(VAR_rescrape);
		vars.add(VAR_goButton);
		vars.add(VAR_downloadButton);
		vars.add(VAR_topOfSearch);
		vars.add(VAR_remove);
		vars.add(VAR_spam);
		vars.add(VAR_topOfSearchInt);
		vars.add(VAR_partnerInt);
		vars.add(VAR_reviewResource);
		vars.add(VAR_oldUrl);
		vars.add(VAR_contentDisplayOk);
		vars.add(VAR_metadata);
		vars.add(VAR_approvalStatus);
		vars.add(VAR_approvalStatusDate);
		vars.add(VAR_spamUser);
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return CurrikiResource.varsRangeCurrikiResource(new ArrayList<String>());
	}
	public static List<String> varsRangeCurrikiResource(List<String> vars) {
		vars.add(VAR_contributorId);
		vars.add(VAR_contributionDate);
		vars.add(VAR_lastEditorId);
		vars.add(VAR_lastEditDate);
		vars.add(VAR_resourceCheckDate);
		vars.add(VAR_resourceCheckId);
		vars.add(VAR_lastReviewDate);
		vars.add(VAR_reviewByID);
		vars.add(VAR_reviewRating);
		vars.add(VAR_technicalCompleteness);
		vars.add(VAR_contentAccuracy);
		vars.add(VAR_pedagogy);
		vars.add(VAR_standardsAlignment);
		vars.add(VAR_subjectMatter);
		vars.add(VAR_supportsTeaching);
		vars.add(VAR_assessmentsQuality);
		vars.add(VAR_interactivityQuality);
		vars.add(VAR_instructionalQuality);
		vars.add(VAR_deeperLearning);
		vars.add(VAR_createDate);
		vars.add(VAR_xwd_id);
		vars.add(VAR_memberRating);
		vars.add(VAR_lastIndexDate);
		vars.add(VAR_indexRequiredDate);
		vars.add(VAR_topOfSearchInt);
		vars.add(VAR_partnerInt);
		vars.add(VAR_approvalStatusDate);
		BaseModel.varsRangeBaseModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_resourceId = "resource ID";
	public static final String DISPLAY_NAME_licenseId = "license ID";
	public static final String DISPLAY_NAME_contributorId = "contributor ID";
	public static final String DISPLAY_NAME_contributionDate = "contribution Date";
	public static final String DISPLAY_NAME_description = "description";
	public static final String DISPLAY_NAME_title = "title";
	public static final String DISPLAY_NAME_keywordsStr = "Keywords String";
	public static final String DISPLAY_NAME_keywords = "Keywords List";
	public static final String DISPLAY_NAME_generatedKeywordsStr = "Generated Keywords String";
	public static final String DISPLAY_NAME_generatedKeywords = "Generated Keywords List";
	public static final String DISPLAY_NAME_language = "Language";
	public static final String DISPLAY_NAME_lastEditorId = "Last Editor ID";
	public static final String DISPLAY_NAME_lastEditDate = "Last Edit Date";
	public static final String DISPLAY_NAME_currikiLicense = "Curriki License";
	public static final String DISPLAY_NAME_externalUrl = "External URL";
	public static final String DISPLAY_NAME_resourceChecked = "Resource Checked";
	public static final String DISPLAY_NAME_content = "External URL";
	public static final String DISPLAY_NAME_resourceCheckRequestNote = "Resource Check Request Note";
	public static final String DISPLAY_NAME_resourceCheckDate = "Resource Check Date";
	public static final String DISPLAY_NAME_resourceCheckId = "Resource Check ID";
	public static final String DISPLAY_NAME_resourceCheckNote = "Resource Check Note";
	public static final String DISPLAY_NAME_studentFacing = "Student Facing";
	public static final String DISPLAY_NAME_source = "Source";
	public static final String DISPLAY_NAME_reviewStatus = "Review Status";
	public static final String DISPLAY_NAME_lastReviewDate = "Last Review Date";
	public static final String DISPLAY_NAME_reviewByID = "Review By ID";
	public static final String DISPLAY_NAME_reviewRating = "Review Rating";
	public static final String DISPLAY_NAME_technicalCompleteness = "Technical Completeness";
	public static final String DISPLAY_NAME_contentAccuracy = "Content Accuracy";
	public static final String DISPLAY_NAME_pedagogy = "Pedagogy";
	public static final String DISPLAY_NAME_ratingComment = "Rating Comment";
	public static final String DISPLAY_NAME_standardsAlignment = "Standards Alignment";
	public static final String DISPLAY_NAME_standardsAlignmentComment = "Standards Alignment Comment";
	public static final String DISPLAY_NAME_subjectMatter = "Subject Matter";
	public static final String DISPLAY_NAME_subjectMatterComment = "Subject Matter Comment";
	public static final String DISPLAY_NAME_supportsTeaching = "Supports Teaching";
	public static final String DISPLAY_NAME_supportsTeachingComment = "Supports Teaching Comment";
	public static final String DISPLAY_NAME_assessmentsQuality = "Assessments Quality";
	public static final String DISPLAY_NAME_assessmentsQualityComment = "Assessments Quality Comment";
	public static final String DISPLAY_NAME_interactivityQuality = "Interactivity Quality";
	public static final String DISPLAY_NAME_interactivityQualityComment = "Interactivity Quality Comment";
	public static final String DISPLAY_NAME_instructionalQuality = "Instructional Quality";
	public static final String DISPLAY_NAME_instructionalQualityComment = "Instructional Quality Comment";
	public static final String DISPLAY_NAME_deeperLearning = "Deeper Learning";
	public static final String DISPLAY_NAME_deeperLearningComment = "Deeper Learning Comment";
	public static final String DISPLAY_NAME_partner = "Partner";
	public static final String DISPLAY_NAME_createDate = "Create Date";
	public static final String DISPLAY_NAME_type = "Type";
	public static final String DISPLAY_NAME_featured = "Featured";
	public static final String DISPLAY_NAME_page = "Page";
	public static final String DISPLAY_NAME_active = "Active";
	public static final String DISPLAY_NAME_Public = "Public";
	public static final String DISPLAY_NAME_xwd_id = "xwd ID";
	public static final String DISPLAY_NAME_mediaType = "Media Type";
	public static final String DISPLAY_NAME_access = "Access";
	public static final String DISPLAY_NAME_memberRating = "Member Rating";
	public static final String DISPLAY_NAME_aligned = "Aligned";
	public static final String DISPLAY_NAME_pageUrl = "Page URL";
	public static final String DISPLAY_NAME_indexed = "Indexed";
	public static final String DISPLAY_NAME_lastIndexDate = "Last Index Date";
	public static final String DISPLAY_NAME_indexRequired = "Index Required";
	public static final String DISPLAY_NAME_indexRequiredDate = "IndexRequiredDate";
	public static final String DISPLAY_NAME_rescrape = "rescrape";
	public static final String DISPLAY_NAME_goButton = "Go Button";
	public static final String DISPLAY_NAME_downloadButton = "Download Button";
	public static final String DISPLAY_NAME_topOfSearch = "Top of Search";
	public static final String DISPLAY_NAME_remove = "Remove";
	public static final String DISPLAY_NAME_spam = "Spam";
	public static final String DISPLAY_NAME_topOfSearchInt = "Top of search int";
	public static final String DISPLAY_NAME_partnerInt = "Partner Int";
	public static final String DISPLAY_NAME_reviewResource = "Review Resource";
	public static final String DISPLAY_NAME_oldUrl = "Old URL";
	public static final String DISPLAY_NAME_contentDisplayOk = "Content Display OK";
	public static final String DISPLAY_NAME_metadata = "Metadata";
	public static final String DISPLAY_NAME_approvalStatus = "Approval Status";
	public static final String DISPLAY_NAME_approvalStatusDate = "Approval Status Date";
	public static final String DISPLAY_NAME_spamUser = "Spam User";

	public static String displayNameForClass(String var) {
		return CurrikiResource.displayNameCurrikiResource(var);
	}
	public static String displayNameCurrikiResource(String var) {
		switch(var) {
		case VAR_resourceId:
			return DISPLAY_NAME_resourceId;
		case VAR_licenseId:
			return DISPLAY_NAME_licenseId;
		case VAR_contributorId:
			return DISPLAY_NAME_contributorId;
		case VAR_contributionDate:
			return DISPLAY_NAME_contributionDate;
		case VAR_description:
			return DISPLAY_NAME_description;
		case VAR_title:
			return DISPLAY_NAME_title;
		case VAR_keywordsStr:
			return DISPLAY_NAME_keywordsStr;
		case VAR_keywords:
			return DISPLAY_NAME_keywords;
		case VAR_generatedKeywordsStr:
			return DISPLAY_NAME_generatedKeywordsStr;
		case VAR_generatedKeywords:
			return DISPLAY_NAME_generatedKeywords;
		case VAR_language:
			return DISPLAY_NAME_language;
		case VAR_lastEditorId:
			return DISPLAY_NAME_lastEditorId;
		case VAR_lastEditDate:
			return DISPLAY_NAME_lastEditDate;
		case VAR_currikiLicense:
			return DISPLAY_NAME_currikiLicense;
		case VAR_externalUrl:
			return DISPLAY_NAME_externalUrl;
		case VAR_resourceChecked:
			return DISPLAY_NAME_resourceChecked;
		case VAR_content:
			return DISPLAY_NAME_content;
		case VAR_resourceCheckRequestNote:
			return DISPLAY_NAME_resourceCheckRequestNote;
		case VAR_resourceCheckDate:
			return DISPLAY_NAME_resourceCheckDate;
		case VAR_resourceCheckId:
			return DISPLAY_NAME_resourceCheckId;
		case VAR_resourceCheckNote:
			return DISPLAY_NAME_resourceCheckNote;
		case VAR_studentFacing:
			return DISPLAY_NAME_studentFacing;
		case VAR_source:
			return DISPLAY_NAME_source;
		case VAR_reviewStatus:
			return DISPLAY_NAME_reviewStatus;
		case VAR_lastReviewDate:
			return DISPLAY_NAME_lastReviewDate;
		case VAR_reviewByID:
			return DISPLAY_NAME_reviewByID;
		case VAR_reviewRating:
			return DISPLAY_NAME_reviewRating;
		case VAR_technicalCompleteness:
			return DISPLAY_NAME_technicalCompleteness;
		case VAR_contentAccuracy:
			return DISPLAY_NAME_contentAccuracy;
		case VAR_pedagogy:
			return DISPLAY_NAME_pedagogy;
		case VAR_ratingComment:
			return DISPLAY_NAME_ratingComment;
		case VAR_standardsAlignment:
			return DISPLAY_NAME_standardsAlignment;
		case VAR_standardsAlignmentComment:
			return DISPLAY_NAME_standardsAlignmentComment;
		case VAR_subjectMatter:
			return DISPLAY_NAME_subjectMatter;
		case VAR_subjectMatterComment:
			return DISPLAY_NAME_subjectMatterComment;
		case VAR_supportsTeaching:
			return DISPLAY_NAME_supportsTeaching;
		case VAR_supportsTeachingComment:
			return DISPLAY_NAME_supportsTeachingComment;
		case VAR_assessmentsQuality:
			return DISPLAY_NAME_assessmentsQuality;
		case VAR_assessmentsQualityComment:
			return DISPLAY_NAME_assessmentsQualityComment;
		case VAR_interactivityQuality:
			return DISPLAY_NAME_interactivityQuality;
		case VAR_interactivityQualityComment:
			return DISPLAY_NAME_interactivityQualityComment;
		case VAR_instructionalQuality:
			return DISPLAY_NAME_instructionalQuality;
		case VAR_instructionalQualityComment:
			return DISPLAY_NAME_instructionalQualityComment;
		case VAR_deeperLearning:
			return DISPLAY_NAME_deeperLearning;
		case VAR_deeperLearningComment:
			return DISPLAY_NAME_deeperLearningComment;
		case VAR_partner:
			return DISPLAY_NAME_partner;
		case VAR_createDate:
			return DISPLAY_NAME_createDate;
		case VAR_type:
			return DISPLAY_NAME_type;
		case VAR_featured:
			return DISPLAY_NAME_featured;
		case VAR_page:
			return DISPLAY_NAME_page;
		case VAR_active:
			return DISPLAY_NAME_active;
		case VAR_Public:
			return DISPLAY_NAME_Public;
		case VAR_xwd_id:
			return DISPLAY_NAME_xwd_id;
		case VAR_mediaType:
			return DISPLAY_NAME_mediaType;
		case VAR_access:
			return DISPLAY_NAME_access;
		case VAR_memberRating:
			return DISPLAY_NAME_memberRating;
		case VAR_aligned:
			return DISPLAY_NAME_aligned;
		case VAR_pageUrl:
			return DISPLAY_NAME_pageUrl;
		case VAR_indexed:
			return DISPLAY_NAME_indexed;
		case VAR_lastIndexDate:
			return DISPLAY_NAME_lastIndexDate;
		case VAR_indexRequired:
			return DISPLAY_NAME_indexRequired;
		case VAR_indexRequiredDate:
			return DISPLAY_NAME_indexRequiredDate;
		case VAR_rescrape:
			return DISPLAY_NAME_rescrape;
		case VAR_goButton:
			return DISPLAY_NAME_goButton;
		case VAR_downloadButton:
			return DISPLAY_NAME_downloadButton;
		case VAR_topOfSearch:
			return DISPLAY_NAME_topOfSearch;
		case VAR_remove:
			return DISPLAY_NAME_remove;
		case VAR_spam:
			return DISPLAY_NAME_spam;
		case VAR_topOfSearchInt:
			return DISPLAY_NAME_topOfSearchInt;
		case VAR_partnerInt:
			return DISPLAY_NAME_partnerInt;
		case VAR_reviewResource:
			return DISPLAY_NAME_reviewResource;
		case VAR_oldUrl:
			return DISPLAY_NAME_oldUrl;
		case VAR_contentDisplayOk:
			return DISPLAY_NAME_contentDisplayOk;
		case VAR_metadata:
			return DISPLAY_NAME_metadata;
		case VAR_approvalStatus:
			return DISPLAY_NAME_approvalStatus;
		case VAR_approvalStatusDate:
			return DISPLAY_NAME_approvalStatusDate;
		case VAR_spamUser:
			return DISPLAY_NAME_spamUser;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionCurrikiResource(String var) {
		switch(var) {
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNameCurrikiResource(String var) {
		switch(var) {
		case VAR_resourceId:
			return "String";
		case VAR_licenseId:
			return "String";
		case VAR_contributorId:
			return "Long";
		case VAR_contributionDate:
			return "ZonedDateTime";
		case VAR_description:
			return "String";
		case VAR_title:
			return "String";
		case VAR_keywordsStr:
			return "String";
		case VAR_keywords:
			return "List";
		case VAR_generatedKeywordsStr:
			return "String";
		case VAR_generatedKeywords:
			return "List";
		case VAR_language:
			return "String";
		case VAR_lastEditorId:
			return "Long";
		case VAR_lastEditDate:
			return "ZonedDateTime";
		case VAR_currikiLicense:
			return "String";
		case VAR_externalUrl:
			return "String";
		case VAR_resourceChecked:
			return "String";
		case VAR_content:
			return "String";
		case VAR_resourceCheckRequestNote:
			return "String";
		case VAR_resourceCheckDate:
			return "ZonedDateTime";
		case VAR_resourceCheckId:
			return "Long";
		case VAR_resourceCheckNote:
			return "String";
		case VAR_studentFacing:
			return "String";
		case VAR_source:
			return "String";
		case VAR_reviewStatus:
			return "String";
		case VAR_lastReviewDate:
			return "ZonedDateTime";
		case VAR_reviewByID:
			return "Long";
		case VAR_reviewRating:
			return "BigDecimal";
		case VAR_technicalCompleteness:
			return "Integer";
		case VAR_contentAccuracy:
			return "Integer";
		case VAR_pedagogy:
			return "Integer";
		case VAR_ratingComment:
			return "String";
		case VAR_standardsAlignment:
			return "Integer";
		case VAR_standardsAlignmentComment:
			return "String";
		case VAR_subjectMatter:
			return "Integer";
		case VAR_subjectMatterComment:
			return "String";
		case VAR_supportsTeaching:
			return "Integer";
		case VAR_supportsTeachingComment:
			return "String";
		case VAR_assessmentsQuality:
			return "Integer";
		case VAR_assessmentsQualityComment:
			return "String";
		case VAR_interactivityQuality:
			return "Integer";
		case VAR_interactivityQualityComment:
			return "String";
		case VAR_instructionalQuality:
			return "Integer";
		case VAR_instructionalQualityComment:
			return "String";
		case VAR_deeperLearning:
			return "Integer";
		case VAR_deeperLearningComment:
			return "String";
		case VAR_partner:
			return "String";
		case VAR_createDate:
			return "ZonedDateTime";
		case VAR_type:
			return "String";
		case VAR_featured:
			return "String";
		case VAR_page:
			return "String";
		case VAR_active:
			return "String";
		case VAR_Public:
			return "String";
		case VAR_xwd_id:
			return "Integer";
		case VAR_mediaType:
			return "String";
		case VAR_access:
			return "String";
		case VAR_memberRating:
			return "BigDecimal";
		case VAR_aligned:
			return "String";
		case VAR_pageUrl:
			return "String";
		case VAR_indexed:
			return "String";
		case VAR_lastIndexDate:
			return "ZonedDateTime";
		case VAR_indexRequired:
			return "String";
		case VAR_indexRequiredDate:
			return "ZonedDateTime";
		case VAR_rescrape:
			return "String";
		case VAR_goButton:
			return "String";
		case VAR_downloadButton:
			return "String";
		case VAR_topOfSearch:
			return "String";
		case VAR_remove:
			return "String";
		case VAR_spam:
			return "String";
		case VAR_topOfSearchInt:
			return "Integer";
		case VAR_partnerInt:
			return "Integer";
		case VAR_reviewResource:
			return "String";
		case VAR_oldUrl:
			return "String";
		case VAR_contentDisplayOk:
			return "String";
		case VAR_metadata:
			return "String";
		case VAR_approvalStatus:
			return "String";
		case VAR_approvalStatusDate:
			return "ZonedDateTime";
		case VAR_spamUser:
			return "String";
			default:
				return BaseModel.classSimpleNameBaseModel(var);
		}
	}

	public static Integer htmlColumnCurrikiResource(String var) {
		switch(var) {
			default:
				return BaseModel.htmlColumnBaseModel(var);
		}
	}

	public static Integer htmlRowCurrikiResource(String var) {
		switch(var) {
		case VAR_resourceId:
			return 3;
		case VAR_licenseId:
			return 3;
		case VAR_contributorId:
			return 3;
		case VAR_contributionDate:
			return 4;
		case VAR_description:
			return 4;
		case VAR_title:
			return 4;
		case VAR_keywordsStr:
			return 5;
		case VAR_keywords:
			return 5;
		case VAR_generatedKeywordsStr:
			return 5;
		case VAR_generatedKeywords:
			return 6;
		case VAR_language:
			return 6;
		case VAR_lastEditorId:
			return 6;
		case VAR_lastEditDate:
			return 7;
		case VAR_currikiLicense:
			return 7;
		case VAR_externalUrl:
			return 7;
		case VAR_resourceChecked:
			return 8;
		case VAR_content:
			return 8;
		case VAR_resourceCheckRequestNote:
			return 8;
		case VAR_resourceCheckDate:
			return 9;
		case VAR_resourceCheckId:
			return 9;
		case VAR_resourceCheckNote:
			return 9;
		case VAR_studentFacing:
			return 10;
		case VAR_source:
			return 10;
		case VAR_reviewStatus:
			return 10;
		case VAR_lastReviewDate:
			return 11;
		case VAR_reviewByID:
			return 11;
		case VAR_reviewRating:
			return 11;
		case VAR_technicalCompleteness:
			return 12;
		case VAR_contentAccuracy:
			return 12;
		case VAR_pedagogy:
			return 12;
		case VAR_ratingComment:
			return 13;
		case VAR_standardsAlignment:
			return 13;
		case VAR_standardsAlignmentComment:
			return 13;
		case VAR_subjectMatter:
			return 14;
		case VAR_subjectMatterComment:
			return 14;
		case VAR_supportsTeaching:
			return 14;
		case VAR_supportsTeachingComment:
			return 15;
		case VAR_assessmentsQuality:
			return 15;
		case VAR_assessmentsQualityComment:
			return 15;
		case VAR_interactivityQuality:
			return 16;
		case VAR_interactivityQualityComment:
			return 16;
		case VAR_instructionalQuality:
			return 16;
		case VAR_instructionalQualityComment:
			return 17;
		case VAR_deeperLearning:
			return 17;
		case VAR_deeperLearningComment:
			return 17;
		case VAR_partner:
			return 18;
		case VAR_createDate:
			return 18;
		case VAR_type:
			return 18;
		case VAR_featured:
			return 19;
		case VAR_page:
			return 19;
		case VAR_active:
			return 19;
		case VAR_Public:
			return 20;
		case VAR_xwd_id:
			return 20;
		case VAR_mediaType:
			return 20;
		case VAR_access:
			return 21;
		case VAR_memberRating:
			return 21;
		case VAR_aligned:
			return 21;
		case VAR_pageUrl:
			return 22;
		case VAR_indexed:
			return 22;
		case VAR_lastIndexDate:
			return 22;
		case VAR_indexRequired:
			return 23;
		case VAR_indexRequiredDate:
			return 23;
		case VAR_rescrape:
			return 24;
		case VAR_goButton:
			return 25;
		case VAR_downloadButton:
			return 25;
		case VAR_topOfSearch:
			return 25;
		case VAR_remove:
			return 26;
		case VAR_spam:
			return 26;
		case VAR_topOfSearchInt:
			return 26;
		case VAR_partnerInt:
			return 27;
		case VAR_reviewResource:
			return 27;
		case VAR_oldUrl:
			return 27;
		case VAR_contentDisplayOk:
			return 28;
		case VAR_metadata:
			return 28;
		case VAR_approvalStatus:
			return 28;
		case VAR_approvalStatusDate:
			return 29;
		case VAR_spamUser:
			return 29;
			default:
				return BaseModel.htmlRowBaseModel(var);
		}
	}

	public static Integer htmlCellCurrikiResource(String var) {
		switch(var) {
		case VAR_resourceId:
			return 1;
		case VAR_licenseId:
			return 2;
		case VAR_contributorId:
			return 3;
		case VAR_contributionDate:
			return 1;
		case VAR_description:
			return 2;
		case VAR_title:
			return 3;
		case VAR_keywordsStr:
			return 1;
		case VAR_keywords:
			return 2;
		case VAR_generatedKeywordsStr:
			return 3;
		case VAR_generatedKeywords:
			return 1;
		case VAR_language:
			return 2;
		case VAR_lastEditorId:
			return 3;
		case VAR_lastEditDate:
			return 1;
		case VAR_currikiLicense:
			return 2;
		case VAR_externalUrl:
			return 3;
		case VAR_resourceChecked:
			return 1;
		case VAR_content:
			return 2;
		case VAR_resourceCheckRequestNote:
			return 3;
		case VAR_resourceCheckDate:
			return 1;
		case VAR_resourceCheckId:
			return 2;
		case VAR_resourceCheckNote:
			return 3;
		case VAR_studentFacing:
			return 1;
		case VAR_source:
			return 2;
		case VAR_reviewStatus:
			return 3;
		case VAR_lastReviewDate:
			return 1;
		case VAR_reviewByID:
			return 2;
		case VAR_reviewRating:
			return 3;
		case VAR_technicalCompleteness:
			return 1;
		case VAR_contentAccuracy:
			return 2;
		case VAR_pedagogy:
			return 3;
		case VAR_ratingComment:
			return 1;
		case VAR_standardsAlignment:
			return 2;
		case VAR_standardsAlignmentComment:
			return 3;
		case VAR_subjectMatter:
			return 1;
		case VAR_subjectMatterComment:
			return 2;
		case VAR_supportsTeaching:
			return 3;
		case VAR_supportsTeachingComment:
			return 1;
		case VAR_assessmentsQuality:
			return 2;
		case VAR_assessmentsQualityComment:
			return 3;
		case VAR_interactivityQuality:
			return 1;
		case VAR_interactivityQualityComment:
			return 2;
		case VAR_instructionalQuality:
			return 3;
		case VAR_instructionalQualityComment:
			return 1;
		case VAR_deeperLearning:
			return 2;
		case VAR_deeperLearningComment:
			return 3;
		case VAR_partner:
			return 1;
		case VAR_createDate:
			return 2;
		case VAR_type:
			return 3;
		case VAR_featured:
			return 1;
		case VAR_page:
			return 2;
		case VAR_active:
			return 3;
		case VAR_Public:
			return 1;
		case VAR_xwd_id:
			return 2;
		case VAR_mediaType:
			return 3;
		case VAR_access:
			return 1;
		case VAR_memberRating:
			return 2;
		case VAR_aligned:
			return 3;
		case VAR_pageUrl:
			return 1;
		case VAR_indexed:
			return 2;
		case VAR_lastIndexDate:
			return 3;
		case VAR_indexRequired:
			return 1;
		case VAR_indexRequiredDate:
			return 2;
		case VAR_rescrape:
			return 3;
		case VAR_goButton:
			return 1;
		case VAR_downloadButton:
			return 2;
		case VAR_topOfSearch:
			return 3;
		case VAR_remove:
			return 1;
		case VAR_spam:
			return 2;
		case VAR_topOfSearchInt:
			return 3;
		case VAR_partnerInt:
			return 1;
		case VAR_reviewResource:
			return 2;
		case VAR_oldUrl:
			return 3;
		case VAR_contentDisplayOk:
			return 1;
		case VAR_metadata:
			return 2;
		case VAR_approvalStatus:
			return 3;
		case VAR_approvalStatusDate:
			return 1;
		case VAR_spamUser:
			return 2;
			default:
				return BaseModel.htmlCellBaseModel(var);
		}
	}

	public static Integer lengthMinCurrikiResource(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxCurrikiResource(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxCurrikiResource(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minCurrikiResource(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
