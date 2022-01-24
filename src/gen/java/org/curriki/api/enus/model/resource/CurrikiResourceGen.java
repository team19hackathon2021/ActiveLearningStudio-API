package org.curriki.api.enus.model.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import org.curriki.api.enus.base.BaseModel;
import java.util.Date;
import java.time.ZonedDateTime;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import java.math.BigDecimal;
import java.lang.Long;
import java.util.Locale;
import java.util.Map;
import io.vertx.core.json.JsonObject;
import java.time.ZoneOffset;
import java.math.RoundingMode;
import java.math.MathContext;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import io.vertx.core.Future;
import java.time.ZoneId;
import java.util.Objects;
import java.util.List;
import java.time.OffsetDateTime;
import org.apache.solr.client.solrj.SolrQuery;
import java.util.Optional;
import org.apache.solr.client.solrj.util.ClientUtils;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.curriki.api.enus.request.api.ApiRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import org.curriki.api.enus.request.SiteRequestEnUS;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.curriki.api.enus.wrap.Wrap;
import org.curriki.api.enus.java.ZonedDateTimeDeserializer;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.curriki.api.enus.java.ZonedDateTimeSerializer;
import java.lang.String;
import org.slf4j.Logger;
import io.vertx.core.Promise;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.curriki.api.enus.config.ConfigKeys;
import org.apache.solr.client.solrj.SolrClient;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.math.NumberUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.curriki.api.enus.java.LocalDateSerializer;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
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

	/**	<br/> The entity resourceId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:resourceId">Find the entity resourceId in Solr</a>
	 * <br/>
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

	public static String staticSolrResourceId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrResourceId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqResourceId(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrResourceId(siteRequest_, CurrikiResource.staticSolrResourceId(siteRequest_, CurrikiResource.staticSetResourceId(siteRequest_, o)));
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

	/**	<br/> The entity licenseId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:licenseId">Find the entity licenseId in Solr</a>
	 * <br/>
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

	public static String staticSolrLicenseId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrLicenseId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqLicenseId(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrLicenseId(siteRequest_, CurrikiResource.staticSolrLicenseId(siteRequest_, CurrikiResource.staticSetLicenseId(siteRequest_, o)));
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

	/**	<br/> The entity contributorId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contributorId">Find the entity contributorId in Solr</a>
	 * <br/>
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

	public static Long staticSolrContributorId(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrContributorId(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContributorId(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrContributorId(siteRequest_, CurrikiResource.staticSolrContributorId(siteRequest_, CurrikiResource.staticSetContributorId(siteRequest_, o)));
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
	@JsonDeserialize(using = ZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime contributionDate;

	/**	<br/> The entity contributionDate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contributionDate">Find the entity contributionDate in Solr</a>
	 * <br/>
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

	public static Date staticSolrContributionDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSolrStrContributionDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSolrFqContributionDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrContributionDate(siteRequest_, CurrikiResource.staticSolrContributionDate(siteRequest_, CurrikiResource.staticSetContributionDate(siteRequest_, o)));
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

	/**	<br/> The entity description
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:description">Find the entity description in Solr</a>
	 * <br/>
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

	public static String staticSolrDescription(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrDescription(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDescription(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrDescription(siteRequest_, CurrikiResource.staticSolrDescription(siteRequest_, CurrikiResource.staticSetDescription(siteRequest_, o)));
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

	/**	<br/> The entity title
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:title">Find the entity title in Solr</a>
	 * <br/>
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

	public static String staticSolrTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrTitle(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqTitle(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrTitle(siteRequest_, CurrikiResource.staticSolrTitle(siteRequest_, CurrikiResource.staticSetTitle(siteRequest_, o)));
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

	/**	<br/> The entity keywordsStr
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:keywordsStr">Find the entity keywordsStr in Solr</a>
	 * <br/>
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

	public static String staticSolrKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrKeywordsStr(siteRequest_, CurrikiResource.staticSolrKeywordsStr(siteRequest_, CurrikiResource.staticSetKeywordsStr(siteRequest_, o)));
	}

	public String sqlKeywordsStr() {
		return keywordsStr;
	}

	//////////////
	// keywords //
	//////////////

	/**	 The entity keywords
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> keywords = new ArrayList<String>();

	/**	<br/> The entity keywords
	 *  It is constructed before being initialized with the constructor by default List<String>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:keywords">Find the entity keywords in Solr</a>
	 * <br/>
	 * @param keywords is the entity already constructed. 
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

	public static String staticSolrKeywords(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrKeywords(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqKeywords(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrKeywords(siteRequest_, CurrikiResource.staticSolrKeywords(siteRequest_, CurrikiResource.staticSetKeywords(siteRequest_, o)));
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

	/**	<br/> The entity generatedKeywordsStr
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:generatedKeywordsStr">Find the entity generatedKeywordsStr in Solr</a>
	 * <br/>
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

	public static String staticSolrGeneratedKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrGeneratedKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqGeneratedKeywordsStr(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrGeneratedKeywordsStr(siteRequest_, CurrikiResource.staticSolrGeneratedKeywordsStr(siteRequest_, CurrikiResource.staticSetGeneratedKeywordsStr(siteRequest_, o)));
	}

	public String sqlGeneratedKeywordsStr() {
		return generatedKeywordsStr;
	}

	///////////////////////
	// generatedKeywords //
	///////////////////////

	/**	 The entity generatedKeywords
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> generatedKeywords = new ArrayList<String>();

	/**	<br/> The entity generatedKeywords
	 *  It is constructed before being initialized with the constructor by default List<String>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:generatedKeywords">Find the entity generatedKeywords in Solr</a>
	 * <br/>
	 * @param generatedKeywords is the entity already constructed. 
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

	public static String staticSolrGeneratedKeywords(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrGeneratedKeywords(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqGeneratedKeywords(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrGeneratedKeywords(siteRequest_, CurrikiResource.staticSolrGeneratedKeywords(siteRequest_, CurrikiResource.staticSetGeneratedKeywords(siteRequest_, o)));
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

	/**	<br/> The entity language
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:language">Find the entity language in Solr</a>
	 * <br/>
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

	public static String staticSolrLanguage(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrLanguage(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqLanguage(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrLanguage(siteRequest_, CurrikiResource.staticSolrLanguage(siteRequest_, CurrikiResource.staticSetLanguage(siteRequest_, o)));
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

	/**	<br/> The entity lastEditorId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:lastEditorId">Find the entity lastEditorId in Solr</a>
	 * <br/>
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

	public static Long staticSolrLastEditorId(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrLastEditorId(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqLastEditorId(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrLastEditorId(siteRequest_, CurrikiResource.staticSolrLastEditorId(siteRequest_, CurrikiResource.staticSetLastEditorId(siteRequest_, o)));
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
	@JsonDeserialize(using = ZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime lastEditDate;

	/**	<br/> The entity lastEditDate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:lastEditDate">Find the entity lastEditDate in Solr</a>
	 * <br/>
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

	public static Date staticSolrLastEditDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSolrStrLastEditDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSolrFqLastEditDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrLastEditDate(siteRequest_, CurrikiResource.staticSolrLastEditDate(siteRequest_, CurrikiResource.staticSetLastEditDate(siteRequest_, o)));
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

	/**	<br/> The entity currikiLicense
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:currikiLicense">Find the entity currikiLicense in Solr</a>
	 * <br/>
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

	public static String staticSolrCurrikiLicense(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrCurrikiLicense(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqCurrikiLicense(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrCurrikiLicense(siteRequest_, CurrikiResource.staticSolrCurrikiLicense(siteRequest_, CurrikiResource.staticSetCurrikiLicense(siteRequest_, o)));
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

	/**	<br/> The entity externalUrl
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:externalUrl">Find the entity externalUrl in Solr</a>
	 * <br/>
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

	public static String staticSolrExternalUrl(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrExternalUrl(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqExternalUrl(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrExternalUrl(siteRequest_, CurrikiResource.staticSolrExternalUrl(siteRequest_, CurrikiResource.staticSetExternalUrl(siteRequest_, o)));
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

	/**	<br/> The entity resourceChecked
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:resourceChecked">Find the entity resourceChecked in Solr</a>
	 * <br/>
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

	public static String staticSolrResourceChecked(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrResourceChecked(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqResourceChecked(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrResourceChecked(siteRequest_, CurrikiResource.staticSolrResourceChecked(siteRequest_, CurrikiResource.staticSetResourceChecked(siteRequest_, o)));
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

	/**	<br/> The entity content
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:content">Find the entity content in Solr</a>
	 * <br/>
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

	public static String staticSolrContent(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrContent(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContent(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrContent(siteRequest_, CurrikiResource.staticSolrContent(siteRequest_, CurrikiResource.staticSetContent(siteRequest_, o)));
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

	/**	<br/> The entity resourceCheckRequestNote
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:resourceCheckRequestNote">Find the entity resourceCheckRequestNote in Solr</a>
	 * <br/>
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

	public static String staticSolrResourceCheckRequestNote(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrResourceCheckRequestNote(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqResourceCheckRequestNote(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrResourceCheckRequestNote(siteRequest_, CurrikiResource.staticSolrResourceCheckRequestNote(siteRequest_, CurrikiResource.staticSetResourceCheckRequestNote(siteRequest_, o)));
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
	@JsonDeserialize(using = ZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime resourceCheckDate;

	/**	<br/> The entity resourceCheckDate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:resourceCheckDate">Find the entity resourceCheckDate in Solr</a>
	 * <br/>
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

	public static Date staticSolrResourceCheckDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSolrStrResourceCheckDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSolrFqResourceCheckDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrResourceCheckDate(siteRequest_, CurrikiResource.staticSolrResourceCheckDate(siteRequest_, CurrikiResource.staticSetResourceCheckDate(siteRequest_, o)));
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

	/**	<br/> The entity resourceCheckId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:resourceCheckId">Find the entity resourceCheckId in Solr</a>
	 * <br/>
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

	public static Long staticSolrResourceCheckId(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrResourceCheckId(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqResourceCheckId(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrResourceCheckId(siteRequest_, CurrikiResource.staticSolrResourceCheckId(siteRequest_, CurrikiResource.staticSetResourceCheckId(siteRequest_, o)));
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

	/**	<br/> The entity resourceCheckNote
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:resourceCheckNote">Find the entity resourceCheckNote in Solr</a>
	 * <br/>
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

	public static String staticSolrResourceCheckNote(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrResourceCheckNote(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqResourceCheckNote(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrResourceCheckNote(siteRequest_, CurrikiResource.staticSolrResourceCheckNote(siteRequest_, CurrikiResource.staticSetResourceCheckNote(siteRequest_, o)));
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

	/**	<br/> The entity studentFacing
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:studentFacing">Find the entity studentFacing in Solr</a>
	 * <br/>
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

	public static String staticSolrStudentFacing(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrStudentFacing(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqStudentFacing(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrStudentFacing(siteRequest_, CurrikiResource.staticSolrStudentFacing(siteRequest_, CurrikiResource.staticSetStudentFacing(siteRequest_, o)));
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

	/**	<br/> The entity source
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:source">Find the entity source in Solr</a>
	 * <br/>
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

	public static String staticSolrSource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrSource(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSource(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrSource(siteRequest_, CurrikiResource.staticSolrSource(siteRequest_, CurrikiResource.staticSetSource(siteRequest_, o)));
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

	/**	<br/> The entity reviewStatus
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reviewStatus">Find the entity reviewStatus in Solr</a>
	 * <br/>
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

	public static String staticSolrReviewStatus(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrReviewStatus(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqReviewStatus(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrReviewStatus(siteRequest_, CurrikiResource.staticSolrReviewStatus(siteRequest_, CurrikiResource.staticSetReviewStatus(siteRequest_, o)));
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
	@JsonDeserialize(using = ZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime lastReviewDate;

	/**	<br/> The entity lastReviewDate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:lastReviewDate">Find the entity lastReviewDate in Solr</a>
	 * <br/>
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

	public static Date staticSolrLastReviewDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSolrStrLastReviewDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSolrFqLastReviewDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrLastReviewDate(siteRequest_, CurrikiResource.staticSolrLastReviewDate(siteRequest_, CurrikiResource.staticSetLastReviewDate(siteRequest_, o)));
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

	/**	<br/> The entity reviewByID
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reviewByID">Find the entity reviewByID in Solr</a>
	 * <br/>
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

	public static Long staticSolrReviewByID(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrReviewByID(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqReviewByID(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrReviewByID(siteRequest_, CurrikiResource.staticSolrReviewByID(siteRequest_, CurrikiResource.staticSetReviewByID(siteRequest_, o)));
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

	/**	<br/> The entity reviewRating
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reviewRating">Find the entity reviewRating in Solr</a>
	 * <br/>
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

	public static Double staticSolrReviewRating(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSolrStrReviewRating(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqReviewRating(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrReviewRating(siteRequest_, CurrikiResource.staticSolrReviewRating(siteRequest_, CurrikiResource.staticSetReviewRating(siteRequest_, o)));
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

	/**	<br/> The entity technicalCompleteness
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:technicalCompleteness">Find the entity technicalCompleteness in Solr</a>
	 * <br/>
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

	public static Integer staticSolrTechnicalCompleteness(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrTechnicalCompleteness(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqTechnicalCompleteness(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrTechnicalCompleteness(siteRequest_, CurrikiResource.staticSolrTechnicalCompleteness(siteRequest_, CurrikiResource.staticSetTechnicalCompleteness(siteRequest_, o)));
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

	/**	<br/> The entity contentAccuracy
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contentAccuracy">Find the entity contentAccuracy in Solr</a>
	 * <br/>
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

	public static Integer staticSolrContentAccuracy(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrContentAccuracy(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContentAccuracy(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrContentAccuracy(siteRequest_, CurrikiResource.staticSolrContentAccuracy(siteRequest_, CurrikiResource.staticSetContentAccuracy(siteRequest_, o)));
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

	/**	<br/> The entity pedagogy
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pedagogy">Find the entity pedagogy in Solr</a>
	 * <br/>
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

	public static Integer staticSolrPedagogy(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrPedagogy(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPedagogy(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrPedagogy(siteRequest_, CurrikiResource.staticSolrPedagogy(siteRequest_, CurrikiResource.staticSetPedagogy(siteRequest_, o)));
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

	/**	<br/> The entity ratingComment
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:ratingComment">Find the entity ratingComment in Solr</a>
	 * <br/>
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

	public static String staticSolrRatingComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrRatingComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqRatingComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrRatingComment(siteRequest_, CurrikiResource.staticSolrRatingComment(siteRequest_, CurrikiResource.staticSetRatingComment(siteRequest_, o)));
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

	/**	<br/> The entity standardsAlignment
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:standardsAlignment">Find the entity standardsAlignment in Solr</a>
	 * <br/>
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

	public static Integer staticSolrStandardsAlignment(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrStandardsAlignment(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqStandardsAlignment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrStandardsAlignment(siteRequest_, CurrikiResource.staticSolrStandardsAlignment(siteRequest_, CurrikiResource.staticSetStandardsAlignment(siteRequest_, o)));
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

	/**	<br/> The entity standardsAlignmentComment
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:standardsAlignmentComment">Find the entity standardsAlignmentComment in Solr</a>
	 * <br/>
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

	public static String staticSolrStandardsAlignmentComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrStandardsAlignmentComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqStandardsAlignmentComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrStandardsAlignmentComment(siteRequest_, CurrikiResource.staticSolrStandardsAlignmentComment(siteRequest_, CurrikiResource.staticSetStandardsAlignmentComment(siteRequest_, o)));
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

	/**	<br/> The entity subjectMatter
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:subjectMatter">Find the entity subjectMatter in Solr</a>
	 * <br/>
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

	public static Integer staticSolrSubjectMatter(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrSubjectMatter(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSubjectMatter(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrSubjectMatter(siteRequest_, CurrikiResource.staticSolrSubjectMatter(siteRequest_, CurrikiResource.staticSetSubjectMatter(siteRequest_, o)));
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

	/**	<br/> The entity subjectMatterComment
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:subjectMatterComment">Find the entity subjectMatterComment in Solr</a>
	 * <br/>
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

	public static String staticSolrSubjectMatterComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrSubjectMatterComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSubjectMatterComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrSubjectMatterComment(siteRequest_, CurrikiResource.staticSolrSubjectMatterComment(siteRequest_, CurrikiResource.staticSetSubjectMatterComment(siteRequest_, o)));
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

	/**	<br/> The entity supportsTeaching
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:supportsTeaching">Find the entity supportsTeaching in Solr</a>
	 * <br/>
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

	public static Integer staticSolrSupportsTeaching(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrSupportsTeaching(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSupportsTeaching(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrSupportsTeaching(siteRequest_, CurrikiResource.staticSolrSupportsTeaching(siteRequest_, CurrikiResource.staticSetSupportsTeaching(siteRequest_, o)));
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

	/**	<br/> The entity supportsTeachingComment
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:supportsTeachingComment">Find the entity supportsTeachingComment in Solr</a>
	 * <br/>
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

	public static String staticSolrSupportsTeachingComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrSupportsTeachingComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSupportsTeachingComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrSupportsTeachingComment(siteRequest_, CurrikiResource.staticSolrSupportsTeachingComment(siteRequest_, CurrikiResource.staticSetSupportsTeachingComment(siteRequest_, o)));
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

	/**	<br/> The entity assessmentsQuality
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:assessmentsQuality">Find the entity assessmentsQuality in Solr</a>
	 * <br/>
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

	public static Integer staticSolrAssessmentsQuality(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrAssessmentsQuality(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqAssessmentsQuality(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrAssessmentsQuality(siteRequest_, CurrikiResource.staticSolrAssessmentsQuality(siteRequest_, CurrikiResource.staticSetAssessmentsQuality(siteRequest_, o)));
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

	/**	<br/> The entity assessmentsQualityComment
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:assessmentsQualityComment">Find the entity assessmentsQualityComment in Solr</a>
	 * <br/>
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

	public static String staticSolrAssessmentsQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrAssessmentsQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqAssessmentsQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrAssessmentsQualityComment(siteRequest_, CurrikiResource.staticSolrAssessmentsQualityComment(siteRequest_, CurrikiResource.staticSetAssessmentsQualityComment(siteRequest_, o)));
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

	/**	<br/> The entity interactivityQuality
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:interactivityQuality">Find the entity interactivityQuality in Solr</a>
	 * <br/>
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

	public static Integer staticSolrInteractivityQuality(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrInteractivityQuality(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqInteractivityQuality(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrInteractivityQuality(siteRequest_, CurrikiResource.staticSolrInteractivityQuality(siteRequest_, CurrikiResource.staticSetInteractivityQuality(siteRequest_, o)));
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

	/**	<br/> The entity interactivityQualityComment
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:interactivityQualityComment">Find the entity interactivityQualityComment in Solr</a>
	 * <br/>
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

	public static String staticSolrInteractivityQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrInteractivityQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqInteractivityQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrInteractivityQualityComment(siteRequest_, CurrikiResource.staticSolrInteractivityQualityComment(siteRequest_, CurrikiResource.staticSetInteractivityQualityComment(siteRequest_, o)));
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

	/**	<br/> The entity instructionalQuality
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:instructionalQuality">Find the entity instructionalQuality in Solr</a>
	 * <br/>
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

	public static Integer staticSolrInstructionalQuality(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrInstructionalQuality(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqInstructionalQuality(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrInstructionalQuality(siteRequest_, CurrikiResource.staticSolrInstructionalQuality(siteRequest_, CurrikiResource.staticSetInstructionalQuality(siteRequest_, o)));
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

	/**	<br/> The entity instructionalQualityComment
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:instructionalQualityComment">Find the entity instructionalQualityComment in Solr</a>
	 * <br/>
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

	public static String staticSolrInstructionalQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrInstructionalQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqInstructionalQualityComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrInstructionalQualityComment(siteRequest_, CurrikiResource.staticSolrInstructionalQualityComment(siteRequest_, CurrikiResource.staticSetInstructionalQualityComment(siteRequest_, o)));
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

	/**	<br/> The entity deeperLearning
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:deeperLearning">Find the entity deeperLearning in Solr</a>
	 * <br/>
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

	public static Integer staticSolrDeeperLearning(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrDeeperLearning(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDeeperLearning(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrDeeperLearning(siteRequest_, CurrikiResource.staticSolrDeeperLearning(siteRequest_, CurrikiResource.staticSetDeeperLearning(siteRequest_, o)));
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

	/**	<br/> The entity deeperLearningComment
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:deeperLearningComment">Find the entity deeperLearningComment in Solr</a>
	 * <br/>
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

	public static String staticSolrDeeperLearningComment(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrDeeperLearningComment(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDeeperLearningComment(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrDeeperLearningComment(siteRequest_, CurrikiResource.staticSolrDeeperLearningComment(siteRequest_, CurrikiResource.staticSetDeeperLearningComment(siteRequest_, o)));
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

	/**	<br/> The entity partner
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:partner">Find the entity partner in Solr</a>
	 * <br/>
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

	public static String staticSolrPartner(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPartner(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPartner(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrPartner(siteRequest_, CurrikiResource.staticSolrPartner(siteRequest_, CurrikiResource.staticSetPartner(siteRequest_, o)));
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
	@JsonDeserialize(using = ZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime createDate;

	/**	<br/> The entity createDate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:createDate">Find the entity createDate in Solr</a>
	 * <br/>
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

	public static Date staticSolrCreateDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSolrStrCreateDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSolrFqCreateDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrCreateDate(siteRequest_, CurrikiResource.staticSolrCreateDate(siteRequest_, CurrikiResource.staticSetCreateDate(siteRequest_, o)));
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

	/**	<br/> The entity type
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:type">Find the entity type in Solr</a>
	 * <br/>
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

	public static String staticSolrType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrType(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqType(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrType(siteRequest_, CurrikiResource.staticSolrType(siteRequest_, CurrikiResource.staticSetType(siteRequest_, o)));
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

	/**	<br/> The entity featured
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:featured">Find the entity featured in Solr</a>
	 * <br/>
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

	public static String staticSolrFeatured(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrFeatured(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqFeatured(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrFeatured(siteRequest_, CurrikiResource.staticSolrFeatured(siteRequest_, CurrikiResource.staticSetFeatured(siteRequest_, o)));
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

	/**	<br/> The entity page
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:page">Find the entity page in Solr</a>
	 * <br/>
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

	public static String staticSolrPage(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPage(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPage(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrPage(siteRequest_, CurrikiResource.staticSolrPage(siteRequest_, CurrikiResource.staticSetPage(siteRequest_, o)));
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

	/**	<br/> The entity active
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:active">Find the entity active in Solr</a>
	 * <br/>
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

	public static String staticSolrActive(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrActive(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqActive(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrActive(siteRequest_, CurrikiResource.staticSolrActive(siteRequest_, CurrikiResource.staticSetActive(siteRequest_, o)));
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

	/**	<br/> The entity Public
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:Public">Find the entity Public in Solr</a>
	 * <br/>
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

	public static String staticSolrPublic(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPublic(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPublic(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrPublic(siteRequest_, CurrikiResource.staticSolrPublic(siteRequest_, CurrikiResource.staticSetPublic(siteRequest_, o)));
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

	/**	<br/> The entity xwd_id
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:xwd_id">Find the entity xwd_id in Solr</a>
	 * <br/>
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

	public static Integer staticSolrXwd_id(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrXwd_id(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqXwd_id(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrXwd_id(siteRequest_, CurrikiResource.staticSolrXwd_id(siteRequest_, CurrikiResource.staticSetXwd_id(siteRequest_, o)));
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

	/**	<br/> The entity mediaType
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:mediaType">Find the entity mediaType in Solr</a>
	 * <br/>
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

	public static String staticSolrMediaType(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrMediaType(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqMediaType(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrMediaType(siteRequest_, CurrikiResource.staticSolrMediaType(siteRequest_, CurrikiResource.staticSetMediaType(siteRequest_, o)));
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

	/**	<br/> The entity access
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:access">Find the entity access in Solr</a>
	 * <br/>
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

	public static String staticSolrAccess(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrAccess(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqAccess(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrAccess(siteRequest_, CurrikiResource.staticSolrAccess(siteRequest_, CurrikiResource.staticSetAccess(siteRequest_, o)));
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

	/**	<br/> The entity memberRating
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:memberRating">Find the entity memberRating in Solr</a>
	 * <br/>
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

	public static Double staticSolrMemberRating(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSolrStrMemberRating(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqMemberRating(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrMemberRating(siteRequest_, CurrikiResource.staticSolrMemberRating(siteRequest_, CurrikiResource.staticSetMemberRating(siteRequest_, o)));
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

	/**	<br/> The entity aligned
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:aligned">Find the entity aligned in Solr</a>
	 * <br/>
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

	public static String staticSolrAligned(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrAligned(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqAligned(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrAligned(siteRequest_, CurrikiResource.staticSolrAligned(siteRequest_, CurrikiResource.staticSetAligned(siteRequest_, o)));
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

	/**	<br/> The entity pageUrl
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUrl">Find the entity pageUrl in Solr</a>
	 * <br/>
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

	public static String staticSolrPageUrl(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageUrl(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageUrl(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrPageUrl(siteRequest_, CurrikiResource.staticSolrPageUrl(siteRequest_, CurrikiResource.staticSetPageUrl(siteRequest_, o)));
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

	/**	<br/> The entity indexed
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:indexed">Find the entity indexed in Solr</a>
	 * <br/>
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

	public static String staticSolrIndexed(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrIndexed(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqIndexed(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrIndexed(siteRequest_, CurrikiResource.staticSolrIndexed(siteRequest_, CurrikiResource.staticSetIndexed(siteRequest_, o)));
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
	@JsonDeserialize(using = ZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime lastIndexDate;

	/**	<br/> The entity lastIndexDate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:lastIndexDate">Find the entity lastIndexDate in Solr</a>
	 * <br/>
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

	public static Date staticSolrLastIndexDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSolrStrLastIndexDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSolrFqLastIndexDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrLastIndexDate(siteRequest_, CurrikiResource.staticSolrLastIndexDate(siteRequest_, CurrikiResource.staticSetLastIndexDate(siteRequest_, o)));
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

	/**	<br/> The entity indexRequired
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:indexRequired">Find the entity indexRequired in Solr</a>
	 * <br/>
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

	public static String staticSolrIndexRequired(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrIndexRequired(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqIndexRequired(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrIndexRequired(siteRequest_, CurrikiResource.staticSolrIndexRequired(siteRequest_, CurrikiResource.staticSetIndexRequired(siteRequest_, o)));
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
	@JsonDeserialize(using = ZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime indexRequiredDate;

	/**	<br/> The entity indexRequiredDate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:indexRequiredDate">Find the entity indexRequiredDate in Solr</a>
	 * <br/>
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

	public static Date staticSolrIndexRequiredDate(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSolrStrIndexRequiredDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSolrFqIndexRequiredDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrIndexRequiredDate(siteRequest_, CurrikiResource.staticSolrIndexRequiredDate(siteRequest_, CurrikiResource.staticSetIndexRequiredDate(siteRequest_, o)));
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

	/**	<br/> The entity rescrape
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:rescrape">Find the entity rescrape in Solr</a>
	 * <br/>
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

	public static String staticSolrRescrape(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrRescrape(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqRescrape(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrRescrape(siteRequest_, CurrikiResource.staticSolrRescrape(siteRequest_, CurrikiResource.staticSetRescrape(siteRequest_, o)));
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

	/**	<br/> The entity goButton
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:goButton">Find the entity goButton in Solr</a>
	 * <br/>
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

	public static String staticSolrGoButton(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrGoButton(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqGoButton(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrGoButton(siteRequest_, CurrikiResource.staticSolrGoButton(siteRequest_, CurrikiResource.staticSetGoButton(siteRequest_, o)));
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

	/**	<br/> The entity downloadButton
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:downloadButton">Find the entity downloadButton in Solr</a>
	 * <br/>
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

	public static String staticSolrDownloadButton(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrDownloadButton(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDownloadButton(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrDownloadButton(siteRequest_, CurrikiResource.staticSolrDownloadButton(siteRequest_, CurrikiResource.staticSetDownloadButton(siteRequest_, o)));
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

	/**	<br/> The entity topOfSearch
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:topOfSearch">Find the entity topOfSearch in Solr</a>
	 * <br/>
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

	public static String staticSolrTopOfSearch(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrTopOfSearch(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqTopOfSearch(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrTopOfSearch(siteRequest_, CurrikiResource.staticSolrTopOfSearch(siteRequest_, CurrikiResource.staticSetTopOfSearch(siteRequest_, o)));
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

	/**	<br/> The entity remove
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:remove">Find the entity remove in Solr</a>
	 * <br/>
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

	public static String staticSolrRemove(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrRemove(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqRemove(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrRemove(siteRequest_, CurrikiResource.staticSolrRemove(siteRequest_, CurrikiResource.staticSetRemove(siteRequest_, o)));
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

	/**	<br/> The entity spam
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:spam">Find the entity spam in Solr</a>
	 * <br/>
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

	public static String staticSolrSpam(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrSpam(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSpam(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrSpam(siteRequest_, CurrikiResource.staticSolrSpam(siteRequest_, CurrikiResource.staticSetSpam(siteRequest_, o)));
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

	/**	<br/> The entity topOfSearchInt
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:topOfSearchInt">Find the entity topOfSearchInt in Solr</a>
	 * <br/>
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

	public static Integer staticSolrTopOfSearchInt(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrTopOfSearchInt(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqTopOfSearchInt(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrTopOfSearchInt(siteRequest_, CurrikiResource.staticSolrTopOfSearchInt(siteRequest_, CurrikiResource.staticSetTopOfSearchInt(siteRequest_, o)));
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

	/**	<br/> The entity partnerInt
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:partnerInt">Find the entity partnerInt in Solr</a>
	 * <br/>
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

	public static Integer staticSolrPartnerInt(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrPartnerInt(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPartnerInt(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrPartnerInt(siteRequest_, CurrikiResource.staticSolrPartnerInt(siteRequest_, CurrikiResource.staticSetPartnerInt(siteRequest_, o)));
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

	/**	<br/> The entity reviewResource
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reviewResource">Find the entity reviewResource in Solr</a>
	 * <br/>
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

	public static String staticSolrReviewResource(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrReviewResource(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqReviewResource(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrReviewResource(siteRequest_, CurrikiResource.staticSolrReviewResource(siteRequest_, CurrikiResource.staticSetReviewResource(siteRequest_, o)));
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

	/**	<br/> The entity oldUrl
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:oldUrl">Find the entity oldUrl in Solr</a>
	 * <br/>
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

	public static String staticSolrOldUrl(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrOldUrl(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqOldUrl(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrOldUrl(siteRequest_, CurrikiResource.staticSolrOldUrl(siteRequest_, CurrikiResource.staticSetOldUrl(siteRequest_, o)));
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

	/**	<br/> The entity contentDisplayOk
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contentDisplayOk">Find the entity contentDisplayOk in Solr</a>
	 * <br/>
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

	public static String staticSolrContentDisplayOk(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrContentDisplayOk(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContentDisplayOk(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrContentDisplayOk(siteRequest_, CurrikiResource.staticSolrContentDisplayOk(siteRequest_, CurrikiResource.staticSetContentDisplayOk(siteRequest_, o)));
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

	/**	<br/> The entity metadata
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:metadata">Find the entity metadata in Solr</a>
	 * <br/>
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

	public static String staticSolrMetadata(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrMetadata(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqMetadata(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrMetadata(siteRequest_, CurrikiResource.staticSolrMetadata(siteRequest_, CurrikiResource.staticSetMetadata(siteRequest_, o)));
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

	/**	<br/> The entity approvalStatus
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:approvalStatus">Find the entity approvalStatus in Solr</a>
	 * <br/>
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

	public static String staticSolrApprovalStatus(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrApprovalStatus(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqApprovalStatus(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrApprovalStatus(siteRequest_, CurrikiResource.staticSolrApprovalStatus(siteRequest_, CurrikiResource.staticSetApprovalStatus(siteRequest_, o)));
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
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected LocalDateTime approvalStatusDate;

	/**	<br/> The entity approvalStatusDate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:approvalStatusDate">Find the entity approvalStatusDate in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _approvalStatusDate(Wrap<LocalDateTime> w);

	public LocalDateTime getApprovalStatusDate() {
		return approvalStatusDate;
	}

	public void setApprovalStatusDate(LocalDateTime approvalStatusDate) {
		this.approvalStatusDate = approvalStatusDate;
	}
	@JsonIgnore
	public void setApprovalStatusDate(Instant o) {
		this.approvalStatusDate = o == null ? null : LocalDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setApprovalStatusDate(String o) {
		this.approvalStatusDate = CurrikiResource.staticSetApprovalStatusDate(siteRequest_, o);
	}
	public static LocalDateTime staticSetApprovalStatusDate(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : LocalDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setApprovalStatusDate(Date o) {
		this.approvalStatusDate = o == null ? null : LocalDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected CurrikiResource approvalStatusDateInit() {
		Wrap<LocalDateTime> approvalStatusDateWrap = new Wrap<LocalDateTime>().var("approvalStatusDate");
		if(approvalStatusDate == null) {
			_approvalStatusDate(approvalStatusDateWrap);
			setApprovalStatusDate(approvalStatusDateWrap.o);
		}
		return (CurrikiResource)this;
	}

	public static Date staticSolrApprovalStatusDate(SiteRequestEnUS siteRequest_, LocalDateTime o) {
		return o == null ? null : Date.from(o.atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z")).toInstant());
	}

	public static String staticSolrStrApprovalStatusDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSolrFqApprovalStatusDate(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrApprovalStatusDate(siteRequest_, CurrikiResource.staticSolrApprovalStatusDate(siteRequest_, CurrikiResource.staticSetApprovalStatusDate(siteRequest_, o)));
	}

	public LocalDateTime sqlApprovalStatusDate() {
		return approvalStatusDate;
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

	/**	<br/> The entity spamUser
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResource&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:spamUser">Find the entity spamUser in Solr</a>
	 * <br/>
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

	public static String staticSolrSpamUser(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrSpamUser(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSpamUser(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResource.staticSolrStrSpamUser(siteRequest_, CurrikiResource.staticSolrSpamUser(siteRequest_, CurrikiResource.staticSetSpamUser(siteRequest_, o)));
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
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrCurrikiResource(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrCurrikiResource(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "resourceId":
			return CurrikiResource.staticSolrResourceId(siteRequest_, (String)o);
		case "licenseId":
			return CurrikiResource.staticSolrLicenseId(siteRequest_, (String)o);
		case "contributorId":
			return CurrikiResource.staticSolrContributorId(siteRequest_, (Long)o);
		case "contributionDate":
			return CurrikiResource.staticSolrContributionDate(siteRequest_, (ZonedDateTime)o);
		case "description":
			return CurrikiResource.staticSolrDescription(siteRequest_, (String)o);
		case "title":
			return CurrikiResource.staticSolrTitle(siteRequest_, (String)o);
		case "keywordsStr":
			return CurrikiResource.staticSolrKeywordsStr(siteRequest_, (String)o);
		case "keywords":
			return CurrikiResource.staticSolrKeywords(siteRequest_, (String)o);
		case "generatedKeywordsStr":
			return CurrikiResource.staticSolrGeneratedKeywordsStr(siteRequest_, (String)o);
		case "generatedKeywords":
			return CurrikiResource.staticSolrGeneratedKeywords(siteRequest_, (String)o);
		case "language":
			return CurrikiResource.staticSolrLanguage(siteRequest_, (String)o);
		case "lastEditorId":
			return CurrikiResource.staticSolrLastEditorId(siteRequest_, (Long)o);
		case "lastEditDate":
			return CurrikiResource.staticSolrLastEditDate(siteRequest_, (ZonedDateTime)o);
		case "currikiLicense":
			return CurrikiResource.staticSolrCurrikiLicense(siteRequest_, (String)o);
		case "externalUrl":
			return CurrikiResource.staticSolrExternalUrl(siteRequest_, (String)o);
		case "resourceChecked":
			return CurrikiResource.staticSolrResourceChecked(siteRequest_, (String)o);
		case "content":
			return CurrikiResource.staticSolrContent(siteRequest_, (String)o);
		case "resourceCheckRequestNote":
			return CurrikiResource.staticSolrResourceCheckRequestNote(siteRequest_, (String)o);
		case "resourceCheckDate":
			return CurrikiResource.staticSolrResourceCheckDate(siteRequest_, (ZonedDateTime)o);
		case "resourceCheckId":
			return CurrikiResource.staticSolrResourceCheckId(siteRequest_, (Long)o);
		case "resourceCheckNote":
			return CurrikiResource.staticSolrResourceCheckNote(siteRequest_, (String)o);
		case "studentFacing":
			return CurrikiResource.staticSolrStudentFacing(siteRequest_, (String)o);
		case "source":
			return CurrikiResource.staticSolrSource(siteRequest_, (String)o);
		case "reviewStatus":
			return CurrikiResource.staticSolrReviewStatus(siteRequest_, (String)o);
		case "lastReviewDate":
			return CurrikiResource.staticSolrLastReviewDate(siteRequest_, (ZonedDateTime)o);
		case "reviewByID":
			return CurrikiResource.staticSolrReviewByID(siteRequest_, (Long)o);
		case "reviewRating":
			return CurrikiResource.staticSolrReviewRating(siteRequest_, (BigDecimal)o);
		case "technicalCompleteness":
			return CurrikiResource.staticSolrTechnicalCompleteness(siteRequest_, (Integer)o);
		case "contentAccuracy":
			return CurrikiResource.staticSolrContentAccuracy(siteRequest_, (Integer)o);
		case "pedagogy":
			return CurrikiResource.staticSolrPedagogy(siteRequest_, (Integer)o);
		case "ratingComment":
			return CurrikiResource.staticSolrRatingComment(siteRequest_, (String)o);
		case "standardsAlignment":
			return CurrikiResource.staticSolrStandardsAlignment(siteRequest_, (Integer)o);
		case "standardsAlignmentComment":
			return CurrikiResource.staticSolrStandardsAlignmentComment(siteRequest_, (String)o);
		case "subjectMatter":
			return CurrikiResource.staticSolrSubjectMatter(siteRequest_, (Integer)o);
		case "subjectMatterComment":
			return CurrikiResource.staticSolrSubjectMatterComment(siteRequest_, (String)o);
		case "supportsTeaching":
			return CurrikiResource.staticSolrSupportsTeaching(siteRequest_, (Integer)o);
		case "supportsTeachingComment":
			return CurrikiResource.staticSolrSupportsTeachingComment(siteRequest_, (String)o);
		case "assessmentsQuality":
			return CurrikiResource.staticSolrAssessmentsQuality(siteRequest_, (Integer)o);
		case "assessmentsQualityComment":
			return CurrikiResource.staticSolrAssessmentsQualityComment(siteRequest_, (String)o);
		case "interactivityQuality":
			return CurrikiResource.staticSolrInteractivityQuality(siteRequest_, (Integer)o);
		case "interactivityQualityComment":
			return CurrikiResource.staticSolrInteractivityQualityComment(siteRequest_, (String)o);
		case "instructionalQuality":
			return CurrikiResource.staticSolrInstructionalQuality(siteRequest_, (Integer)o);
		case "instructionalQualityComment":
			return CurrikiResource.staticSolrInstructionalQualityComment(siteRequest_, (String)o);
		case "deeperLearning":
			return CurrikiResource.staticSolrDeeperLearning(siteRequest_, (Integer)o);
		case "deeperLearningComment":
			return CurrikiResource.staticSolrDeeperLearningComment(siteRequest_, (String)o);
		case "partner":
			return CurrikiResource.staticSolrPartner(siteRequest_, (String)o);
		case "createDate":
			return CurrikiResource.staticSolrCreateDate(siteRequest_, (ZonedDateTime)o);
		case "type":
			return CurrikiResource.staticSolrType(siteRequest_, (String)o);
		case "featured":
			return CurrikiResource.staticSolrFeatured(siteRequest_, (String)o);
		case "page":
			return CurrikiResource.staticSolrPage(siteRequest_, (String)o);
		case "active":
			return CurrikiResource.staticSolrActive(siteRequest_, (String)o);
		case "Public":
			return CurrikiResource.staticSolrPublic(siteRequest_, (String)o);
		case "xwd_id":
			return CurrikiResource.staticSolrXwd_id(siteRequest_, (Integer)o);
		case "mediaType":
			return CurrikiResource.staticSolrMediaType(siteRequest_, (String)o);
		case "access":
			return CurrikiResource.staticSolrAccess(siteRequest_, (String)o);
		case "memberRating":
			return CurrikiResource.staticSolrMemberRating(siteRequest_, (BigDecimal)o);
		case "aligned":
			return CurrikiResource.staticSolrAligned(siteRequest_, (String)o);
		case "pageUrl":
			return CurrikiResource.staticSolrPageUrl(siteRequest_, (String)o);
		case "indexed":
			return CurrikiResource.staticSolrIndexed(siteRequest_, (String)o);
		case "lastIndexDate":
			return CurrikiResource.staticSolrLastIndexDate(siteRequest_, (ZonedDateTime)o);
		case "indexRequired":
			return CurrikiResource.staticSolrIndexRequired(siteRequest_, (String)o);
		case "indexRequiredDate":
			return CurrikiResource.staticSolrIndexRequiredDate(siteRequest_, (ZonedDateTime)o);
		case "rescrape":
			return CurrikiResource.staticSolrRescrape(siteRequest_, (String)o);
		case "goButton":
			return CurrikiResource.staticSolrGoButton(siteRequest_, (String)o);
		case "downloadButton":
			return CurrikiResource.staticSolrDownloadButton(siteRequest_, (String)o);
		case "topOfSearch":
			return CurrikiResource.staticSolrTopOfSearch(siteRequest_, (String)o);
		case "remove":
			return CurrikiResource.staticSolrRemove(siteRequest_, (String)o);
		case "spam":
			return CurrikiResource.staticSolrSpam(siteRequest_, (String)o);
		case "topOfSearchInt":
			return CurrikiResource.staticSolrTopOfSearchInt(siteRequest_, (Integer)o);
		case "partnerInt":
			return CurrikiResource.staticSolrPartnerInt(siteRequest_, (Integer)o);
		case "reviewResource":
			return CurrikiResource.staticSolrReviewResource(siteRequest_, (String)o);
		case "oldUrl":
			return CurrikiResource.staticSolrOldUrl(siteRequest_, (String)o);
		case "contentDisplayOk":
			return CurrikiResource.staticSolrContentDisplayOk(siteRequest_, (String)o);
		case "metadata":
			return CurrikiResource.staticSolrMetadata(siteRequest_, (String)o);
		case "approvalStatus":
			return CurrikiResource.staticSolrApprovalStatus(siteRequest_, (String)o);
		case "approvalStatusDate":
			return CurrikiResource.staticSolrApprovalStatusDate(siteRequest_, (LocalDateTime)o);
		case "spamUser":
			return CurrikiResource.staticSolrSpamUser(siteRequest_, (String)o);
			default:
				return BaseModel.staticSolrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrCurrikiResource(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrCurrikiResource(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "resourceId":
			return CurrikiResource.staticSolrStrResourceId(siteRequest_, (String)o);
		case "licenseId":
			return CurrikiResource.staticSolrStrLicenseId(siteRequest_, (String)o);
		case "contributorId":
			return CurrikiResource.staticSolrStrContributorId(siteRequest_, (Long)o);
		case "contributionDate":
			return CurrikiResource.staticSolrStrContributionDate(siteRequest_, (Date)o);
		case "description":
			return CurrikiResource.staticSolrStrDescription(siteRequest_, (String)o);
		case "title":
			return CurrikiResource.staticSolrStrTitle(siteRequest_, (String)o);
		case "keywordsStr":
			return CurrikiResource.staticSolrStrKeywordsStr(siteRequest_, (String)o);
		case "keywords":
			return CurrikiResource.staticSolrStrKeywords(siteRequest_, (String)o);
		case "generatedKeywordsStr":
			return CurrikiResource.staticSolrStrGeneratedKeywordsStr(siteRequest_, (String)o);
		case "generatedKeywords":
			return CurrikiResource.staticSolrStrGeneratedKeywords(siteRequest_, (String)o);
		case "language":
			return CurrikiResource.staticSolrStrLanguage(siteRequest_, (String)o);
		case "lastEditorId":
			return CurrikiResource.staticSolrStrLastEditorId(siteRequest_, (Long)o);
		case "lastEditDate":
			return CurrikiResource.staticSolrStrLastEditDate(siteRequest_, (Date)o);
		case "currikiLicense":
			return CurrikiResource.staticSolrStrCurrikiLicense(siteRequest_, (String)o);
		case "externalUrl":
			return CurrikiResource.staticSolrStrExternalUrl(siteRequest_, (String)o);
		case "resourceChecked":
			return CurrikiResource.staticSolrStrResourceChecked(siteRequest_, (String)o);
		case "content":
			return CurrikiResource.staticSolrStrContent(siteRequest_, (String)o);
		case "resourceCheckRequestNote":
			return CurrikiResource.staticSolrStrResourceCheckRequestNote(siteRequest_, (String)o);
		case "resourceCheckDate":
			return CurrikiResource.staticSolrStrResourceCheckDate(siteRequest_, (Date)o);
		case "resourceCheckId":
			return CurrikiResource.staticSolrStrResourceCheckId(siteRequest_, (Long)o);
		case "resourceCheckNote":
			return CurrikiResource.staticSolrStrResourceCheckNote(siteRequest_, (String)o);
		case "studentFacing":
			return CurrikiResource.staticSolrStrStudentFacing(siteRequest_, (String)o);
		case "source":
			return CurrikiResource.staticSolrStrSource(siteRequest_, (String)o);
		case "reviewStatus":
			return CurrikiResource.staticSolrStrReviewStatus(siteRequest_, (String)o);
		case "lastReviewDate":
			return CurrikiResource.staticSolrStrLastReviewDate(siteRequest_, (Date)o);
		case "reviewByID":
			return CurrikiResource.staticSolrStrReviewByID(siteRequest_, (Long)o);
		case "reviewRating":
			return CurrikiResource.staticSolrStrReviewRating(siteRequest_, (Double)o);
		case "technicalCompleteness":
			return CurrikiResource.staticSolrStrTechnicalCompleteness(siteRequest_, (Integer)o);
		case "contentAccuracy":
			return CurrikiResource.staticSolrStrContentAccuracy(siteRequest_, (Integer)o);
		case "pedagogy":
			return CurrikiResource.staticSolrStrPedagogy(siteRequest_, (Integer)o);
		case "ratingComment":
			return CurrikiResource.staticSolrStrRatingComment(siteRequest_, (String)o);
		case "standardsAlignment":
			return CurrikiResource.staticSolrStrStandardsAlignment(siteRequest_, (Integer)o);
		case "standardsAlignmentComment":
			return CurrikiResource.staticSolrStrStandardsAlignmentComment(siteRequest_, (String)o);
		case "subjectMatter":
			return CurrikiResource.staticSolrStrSubjectMatter(siteRequest_, (Integer)o);
		case "subjectMatterComment":
			return CurrikiResource.staticSolrStrSubjectMatterComment(siteRequest_, (String)o);
		case "supportsTeaching":
			return CurrikiResource.staticSolrStrSupportsTeaching(siteRequest_, (Integer)o);
		case "supportsTeachingComment":
			return CurrikiResource.staticSolrStrSupportsTeachingComment(siteRequest_, (String)o);
		case "assessmentsQuality":
			return CurrikiResource.staticSolrStrAssessmentsQuality(siteRequest_, (Integer)o);
		case "assessmentsQualityComment":
			return CurrikiResource.staticSolrStrAssessmentsQualityComment(siteRequest_, (String)o);
		case "interactivityQuality":
			return CurrikiResource.staticSolrStrInteractivityQuality(siteRequest_, (Integer)o);
		case "interactivityQualityComment":
			return CurrikiResource.staticSolrStrInteractivityQualityComment(siteRequest_, (String)o);
		case "instructionalQuality":
			return CurrikiResource.staticSolrStrInstructionalQuality(siteRequest_, (Integer)o);
		case "instructionalQualityComment":
			return CurrikiResource.staticSolrStrInstructionalQualityComment(siteRequest_, (String)o);
		case "deeperLearning":
			return CurrikiResource.staticSolrStrDeeperLearning(siteRequest_, (Integer)o);
		case "deeperLearningComment":
			return CurrikiResource.staticSolrStrDeeperLearningComment(siteRequest_, (String)o);
		case "partner":
			return CurrikiResource.staticSolrStrPartner(siteRequest_, (String)o);
		case "createDate":
			return CurrikiResource.staticSolrStrCreateDate(siteRequest_, (Date)o);
		case "type":
			return CurrikiResource.staticSolrStrType(siteRequest_, (String)o);
		case "featured":
			return CurrikiResource.staticSolrStrFeatured(siteRequest_, (String)o);
		case "page":
			return CurrikiResource.staticSolrStrPage(siteRequest_, (String)o);
		case "active":
			return CurrikiResource.staticSolrStrActive(siteRequest_, (String)o);
		case "Public":
			return CurrikiResource.staticSolrStrPublic(siteRequest_, (String)o);
		case "xwd_id":
			return CurrikiResource.staticSolrStrXwd_id(siteRequest_, (Integer)o);
		case "mediaType":
			return CurrikiResource.staticSolrStrMediaType(siteRequest_, (String)o);
		case "access":
			return CurrikiResource.staticSolrStrAccess(siteRequest_, (String)o);
		case "memberRating":
			return CurrikiResource.staticSolrStrMemberRating(siteRequest_, (Double)o);
		case "aligned":
			return CurrikiResource.staticSolrStrAligned(siteRequest_, (String)o);
		case "pageUrl":
			return CurrikiResource.staticSolrStrPageUrl(siteRequest_, (String)o);
		case "indexed":
			return CurrikiResource.staticSolrStrIndexed(siteRequest_, (String)o);
		case "lastIndexDate":
			return CurrikiResource.staticSolrStrLastIndexDate(siteRequest_, (Date)o);
		case "indexRequired":
			return CurrikiResource.staticSolrStrIndexRequired(siteRequest_, (String)o);
		case "indexRequiredDate":
			return CurrikiResource.staticSolrStrIndexRequiredDate(siteRequest_, (Date)o);
		case "rescrape":
			return CurrikiResource.staticSolrStrRescrape(siteRequest_, (String)o);
		case "goButton":
			return CurrikiResource.staticSolrStrGoButton(siteRequest_, (String)o);
		case "downloadButton":
			return CurrikiResource.staticSolrStrDownloadButton(siteRequest_, (String)o);
		case "topOfSearch":
			return CurrikiResource.staticSolrStrTopOfSearch(siteRequest_, (String)o);
		case "remove":
			return CurrikiResource.staticSolrStrRemove(siteRequest_, (String)o);
		case "spam":
			return CurrikiResource.staticSolrStrSpam(siteRequest_, (String)o);
		case "topOfSearchInt":
			return CurrikiResource.staticSolrStrTopOfSearchInt(siteRequest_, (Integer)o);
		case "partnerInt":
			return CurrikiResource.staticSolrStrPartnerInt(siteRequest_, (Integer)o);
		case "reviewResource":
			return CurrikiResource.staticSolrStrReviewResource(siteRequest_, (String)o);
		case "oldUrl":
			return CurrikiResource.staticSolrStrOldUrl(siteRequest_, (String)o);
		case "contentDisplayOk":
			return CurrikiResource.staticSolrStrContentDisplayOk(siteRequest_, (String)o);
		case "metadata":
			return CurrikiResource.staticSolrStrMetadata(siteRequest_, (String)o);
		case "approvalStatus":
			return CurrikiResource.staticSolrStrApprovalStatus(siteRequest_, (String)o);
		case "approvalStatusDate":
			return CurrikiResource.staticSolrStrApprovalStatusDate(siteRequest_, (Date)o);
		case "spamUser":
			return CurrikiResource.staticSolrStrSpamUser(siteRequest_, (String)o);
			default:
				return BaseModel.staticSolrStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqCurrikiResource(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqCurrikiResource(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "resourceId":
			return CurrikiResource.staticSolrFqResourceId(siteRequest_, o);
		case "licenseId":
			return CurrikiResource.staticSolrFqLicenseId(siteRequest_, o);
		case "contributorId":
			return CurrikiResource.staticSolrFqContributorId(siteRequest_, o);
		case "contributionDate":
			return CurrikiResource.staticSolrFqContributionDate(siteRequest_, o);
		case "description":
			return CurrikiResource.staticSolrFqDescription(siteRequest_, o);
		case "title":
			return CurrikiResource.staticSolrFqTitle(siteRequest_, o);
		case "keywordsStr":
			return CurrikiResource.staticSolrFqKeywordsStr(siteRequest_, o);
		case "keywords":
			return CurrikiResource.staticSolrFqKeywords(siteRequest_, o);
		case "generatedKeywordsStr":
			return CurrikiResource.staticSolrFqGeneratedKeywordsStr(siteRequest_, o);
		case "generatedKeywords":
			return CurrikiResource.staticSolrFqGeneratedKeywords(siteRequest_, o);
		case "language":
			return CurrikiResource.staticSolrFqLanguage(siteRequest_, o);
		case "lastEditorId":
			return CurrikiResource.staticSolrFqLastEditorId(siteRequest_, o);
		case "lastEditDate":
			return CurrikiResource.staticSolrFqLastEditDate(siteRequest_, o);
		case "currikiLicense":
			return CurrikiResource.staticSolrFqCurrikiLicense(siteRequest_, o);
		case "externalUrl":
			return CurrikiResource.staticSolrFqExternalUrl(siteRequest_, o);
		case "resourceChecked":
			return CurrikiResource.staticSolrFqResourceChecked(siteRequest_, o);
		case "content":
			return CurrikiResource.staticSolrFqContent(siteRequest_, o);
		case "resourceCheckRequestNote":
			return CurrikiResource.staticSolrFqResourceCheckRequestNote(siteRequest_, o);
		case "resourceCheckDate":
			return CurrikiResource.staticSolrFqResourceCheckDate(siteRequest_, o);
		case "resourceCheckId":
			return CurrikiResource.staticSolrFqResourceCheckId(siteRequest_, o);
		case "resourceCheckNote":
			return CurrikiResource.staticSolrFqResourceCheckNote(siteRequest_, o);
		case "studentFacing":
			return CurrikiResource.staticSolrFqStudentFacing(siteRequest_, o);
		case "source":
			return CurrikiResource.staticSolrFqSource(siteRequest_, o);
		case "reviewStatus":
			return CurrikiResource.staticSolrFqReviewStatus(siteRequest_, o);
		case "lastReviewDate":
			return CurrikiResource.staticSolrFqLastReviewDate(siteRequest_, o);
		case "reviewByID":
			return CurrikiResource.staticSolrFqReviewByID(siteRequest_, o);
		case "reviewRating":
			return CurrikiResource.staticSolrFqReviewRating(siteRequest_, o);
		case "technicalCompleteness":
			return CurrikiResource.staticSolrFqTechnicalCompleteness(siteRequest_, o);
		case "contentAccuracy":
			return CurrikiResource.staticSolrFqContentAccuracy(siteRequest_, o);
		case "pedagogy":
			return CurrikiResource.staticSolrFqPedagogy(siteRequest_, o);
		case "ratingComment":
			return CurrikiResource.staticSolrFqRatingComment(siteRequest_, o);
		case "standardsAlignment":
			return CurrikiResource.staticSolrFqStandardsAlignment(siteRequest_, o);
		case "standardsAlignmentComment":
			return CurrikiResource.staticSolrFqStandardsAlignmentComment(siteRequest_, o);
		case "subjectMatter":
			return CurrikiResource.staticSolrFqSubjectMatter(siteRequest_, o);
		case "subjectMatterComment":
			return CurrikiResource.staticSolrFqSubjectMatterComment(siteRequest_, o);
		case "supportsTeaching":
			return CurrikiResource.staticSolrFqSupportsTeaching(siteRequest_, o);
		case "supportsTeachingComment":
			return CurrikiResource.staticSolrFqSupportsTeachingComment(siteRequest_, o);
		case "assessmentsQuality":
			return CurrikiResource.staticSolrFqAssessmentsQuality(siteRequest_, o);
		case "assessmentsQualityComment":
			return CurrikiResource.staticSolrFqAssessmentsQualityComment(siteRequest_, o);
		case "interactivityQuality":
			return CurrikiResource.staticSolrFqInteractivityQuality(siteRequest_, o);
		case "interactivityQualityComment":
			return CurrikiResource.staticSolrFqInteractivityQualityComment(siteRequest_, o);
		case "instructionalQuality":
			return CurrikiResource.staticSolrFqInstructionalQuality(siteRequest_, o);
		case "instructionalQualityComment":
			return CurrikiResource.staticSolrFqInstructionalQualityComment(siteRequest_, o);
		case "deeperLearning":
			return CurrikiResource.staticSolrFqDeeperLearning(siteRequest_, o);
		case "deeperLearningComment":
			return CurrikiResource.staticSolrFqDeeperLearningComment(siteRequest_, o);
		case "partner":
			return CurrikiResource.staticSolrFqPartner(siteRequest_, o);
		case "createDate":
			return CurrikiResource.staticSolrFqCreateDate(siteRequest_, o);
		case "type":
			return CurrikiResource.staticSolrFqType(siteRequest_, o);
		case "featured":
			return CurrikiResource.staticSolrFqFeatured(siteRequest_, o);
		case "page":
			return CurrikiResource.staticSolrFqPage(siteRequest_, o);
		case "active":
			return CurrikiResource.staticSolrFqActive(siteRequest_, o);
		case "Public":
			return CurrikiResource.staticSolrFqPublic(siteRequest_, o);
		case "xwd_id":
			return CurrikiResource.staticSolrFqXwd_id(siteRequest_, o);
		case "mediaType":
			return CurrikiResource.staticSolrFqMediaType(siteRequest_, o);
		case "access":
			return CurrikiResource.staticSolrFqAccess(siteRequest_, o);
		case "memberRating":
			return CurrikiResource.staticSolrFqMemberRating(siteRequest_, o);
		case "aligned":
			return CurrikiResource.staticSolrFqAligned(siteRequest_, o);
		case "pageUrl":
			return CurrikiResource.staticSolrFqPageUrl(siteRequest_, o);
		case "indexed":
			return CurrikiResource.staticSolrFqIndexed(siteRequest_, o);
		case "lastIndexDate":
			return CurrikiResource.staticSolrFqLastIndexDate(siteRequest_, o);
		case "indexRequired":
			return CurrikiResource.staticSolrFqIndexRequired(siteRequest_, o);
		case "indexRequiredDate":
			return CurrikiResource.staticSolrFqIndexRequiredDate(siteRequest_, o);
		case "rescrape":
			return CurrikiResource.staticSolrFqRescrape(siteRequest_, o);
		case "goButton":
			return CurrikiResource.staticSolrFqGoButton(siteRequest_, o);
		case "downloadButton":
			return CurrikiResource.staticSolrFqDownloadButton(siteRequest_, o);
		case "topOfSearch":
			return CurrikiResource.staticSolrFqTopOfSearch(siteRequest_, o);
		case "remove":
			return CurrikiResource.staticSolrFqRemove(siteRequest_, o);
		case "spam":
			return CurrikiResource.staticSolrFqSpam(siteRequest_, o);
		case "topOfSearchInt":
			return CurrikiResource.staticSolrFqTopOfSearchInt(siteRequest_, o);
		case "partnerInt":
			return CurrikiResource.staticSolrFqPartnerInt(siteRequest_, o);
		case "reviewResource":
			return CurrikiResource.staticSolrFqReviewResource(siteRequest_, o);
		case "oldUrl":
			return CurrikiResource.staticSolrFqOldUrl(siteRequest_, o);
		case "contentDisplayOk":
			return CurrikiResource.staticSolrFqContentDisplayOk(siteRequest_, o);
		case "metadata":
			return CurrikiResource.staticSolrFqMetadata(siteRequest_, o);
		case "approvalStatus":
			return CurrikiResource.staticSolrFqApprovalStatus(siteRequest_, o);
		case "approvalStatusDate":
			return CurrikiResource.staticSolrFqApprovalStatusDate(siteRequest_, o);
		case "spamUser":
			return CurrikiResource.staticSolrFqSpamUser(siteRequest_, o);
			default:
				return BaseModel.staticSolrFqBaseModel(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// define //
	/////////////

	@Override public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineCurrikiResource(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineCurrikiResource(String var, Object val) {
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
				saves.add("contributorId");
				return val;
			case "contributiondate":
				if(val instanceof ZonedDateTime)
					setContributionDate((ZonedDateTime)val);
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
				saves.add("lastEditorId");
				return val;
			case "lasteditdate":
				if(val instanceof ZonedDateTime)
					setLastEditDate((ZonedDateTime)val);
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
				else if(val instanceof OffsetDateTime)
					setResourceCheckDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				saves.add("resourceCheckDate");
				return val;
			case "resourcecheckid":
				if(val instanceof Long)
					setResourceCheckId((Long)val);
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
				else if(val instanceof OffsetDateTime)
					setLastReviewDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				saves.add("lastReviewDate");
				return val;
			case "reviewbyid":
				if(val instanceof Long)
					setReviewByID((Long)val);
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
				saves.add("technicalCompleteness");
				return val;
			case "contentaccuracy":
				if(val instanceof Integer)
					setContentAccuracy((Integer)val);
				saves.add("contentAccuracy");
				return val;
			case "pedagogy":
				if(val instanceof Integer)
					setPedagogy((Integer)val);
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
				saves.add("topOfSearchInt");
				return val;
			case "partnerint":
				if(val instanceof Integer)
					setPartnerInt((Integer)val);
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
				if(val instanceof LocalDateTime)
					setApprovalStatusDate((LocalDateTime)val);
				saves.add("approvalStatusDate");
				return val;
			case "spamuser":
				if(val instanceof String)
					setSpamUser((String)val);
				saves.add("spamUser");
				return val;
			default:
				return super.defineBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateCurrikiResource(solrDocument);
	}
	public void populateCurrikiResource(SolrDocument solrDocument) {
		CurrikiResource oCurrikiResource = (CurrikiResource)this;
		saves = (List<String>)solrDocument.get("saves_docvalues_strings");
		if(saves != null) {

			if(saves.contains("content")) {
				String content = (String)solrDocument.get("content_stored_string");
				if(content != null)
					oCurrikiResource.setContent(content);
			}

			if(saves.contains("ratingComment")) {
				String ratingComment = (String)solrDocument.get("ratingComment_stored_string");
				if(ratingComment != null)
					oCurrikiResource.setRatingComment(ratingComment);
			}
		}

		super.populateBaseModel(solrDocument);
	}

	public void indexCurrikiResource(SolrInputDocument document) {
		if(resourceId != null) {
			document.addField("resourceId_docvalues_string", resourceId);
		}
		if(licenseId != null) {
			document.addField("licenseId_docvalues_string", licenseId);
		}
		if(contributorId != null) {
			document.addField("contributorId_docvalues_long", contributorId);
		}
		if(contributionDate != null) {
			document.addField("contributionDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(contributionDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(description != null) {
			document.addField("description_docvalues_string", description);
		}
		if(title != null) {
			document.addField("title_docvalues_string", title);
		}
		if(keywords != null) {
			for(java.lang.String o : keywords) {
				document.addField("keywords_docvalues_strings", o);
			}
		}
		if(generatedKeywords != null) {
			for(java.lang.String o : generatedKeywords) {
				document.addField("generatedKeywords_docvalues_strings", o);
			}
		}
		if(language != null) {
			document.addField("language_docvalues_string", language);
		}
		if(lastEditorId != null) {
			document.addField("lastEditorId_docvalues_long", lastEditorId);
		}
		if(lastEditDate != null) {
			document.addField("lastEditDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(lastEditDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(currikiLicense != null) {
			document.addField("currikiLicense_docvalues_string", currikiLicense);
		}
		if(externalUrl != null) {
			document.addField("externalUrl_docvalues_string", externalUrl);
		}
		if(resourceChecked != null) {
			document.addField("resourceChecked_docvalues_string", resourceChecked);
		}
		if(content != null) {
			document.addField("content_stored_string", content);
		}
		if(resourceCheckDate != null) {
			document.addField("resourceCheckDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(resourceCheckDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(resourceCheckId != null) {
			document.addField("resourceCheckId_docvalues_long", resourceCheckId);
		}
		if(studentFacing != null) {
			document.addField("studentFacing_docvalues_string", studentFacing);
		}
		if(source != null) {
			document.addField("source_docvalues_string", source);
		}
		if(reviewStatus != null) {
			document.addField("reviewStatus_docvalues_string", reviewStatus);
		}
		if(lastReviewDate != null) {
			document.addField("lastReviewDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(lastReviewDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(reviewByID != null) {
			document.addField("reviewByID_docvalues_long", reviewByID);
		}
		if(reviewRating != null) {
			document.addField("reviewRating_docvalues_double", reviewRating.doubleValue());
		}
		if(technicalCompleteness != null) {
			document.addField("technicalCompleteness_docvalues_int", technicalCompleteness);
		}
		if(contentAccuracy != null) {
			document.addField("contentAccuracy_docvalues_int", contentAccuracy);
		}
		if(pedagogy != null) {
			document.addField("pedagogy_docvalues_int", pedagogy);
		}
		if(ratingComment != null) {
			document.addField("ratingComment_stored_string", ratingComment);
		}
		if(standardsAlignment != null) {
			document.addField("standardsAlignment_docvalues_int", standardsAlignment);
		}
		if(standardsAlignmentComment != null) {
			document.addField("standardsAlignmentComment_docvalues_string", standardsAlignmentComment);
		}
		if(subjectMatter != null) {
			document.addField("subjectMatter_docvalues_int", subjectMatter);
		}
		if(subjectMatterComment != null) {
			document.addField("subjectMatterComment_docvalues_string", subjectMatterComment);
		}
		if(supportsTeaching != null) {
			document.addField("supportsTeaching_docvalues_int", supportsTeaching);
		}
		if(supportsTeachingComment != null) {
			document.addField("supportsTeachingComment_docvalues_string", supportsTeachingComment);
		}
		if(assessmentsQuality != null) {
			document.addField("assessmentsQuality_docvalues_int", assessmentsQuality);
		}
		if(assessmentsQualityComment != null) {
			document.addField("assessmentsQualityComment_docvalues_string", assessmentsQualityComment);
		}
		if(interactivityQuality != null) {
			document.addField("interactivityQuality_docvalues_int", interactivityQuality);
		}
		if(interactivityQualityComment != null) {
			document.addField("interactivityQualityComment_docvalues_string", interactivityQualityComment);
		}
		if(instructionalQuality != null) {
			document.addField("instructionalQuality_docvalues_int", instructionalQuality);
		}
		if(instructionalQualityComment != null) {
			document.addField("instructionalQualityComment_docvalues_string", instructionalQualityComment);
		}
		if(deeperLearning != null) {
			document.addField("deeperLearning_docvalues_int", deeperLearning);
		}
		if(deeperLearningComment != null) {
			document.addField("deeperLearningComment_docvalues_string", deeperLearningComment);
		}
		if(partner != null) {
			document.addField("partner_docvalues_string", partner);
		}
		if(createDate != null) {
			document.addField("createDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(createDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(type != null) {
			document.addField("type_docvalues_string", type);
		}
		if(featured != null) {
			document.addField("featured_docvalues_string", featured);
		}
		if(page != null) {
			document.addField("page_docvalues_string", page);
		}
		if(active != null) {
			document.addField("active_docvalues_string", active);
		}
		if(Public != null) {
			document.addField("Public_docvalues_string", Public);
		}
		if(xwd_id != null) {
			document.addField("xwd_id_docvalues_int", xwd_id);
		}
		if(mediaType != null) {
			document.addField("mediaType_docvalues_string", mediaType);
		}
		if(access != null) {
			document.addField("access_docvalues_string", access);
		}
		if(memberRating != null) {
			document.addField("memberRating_docvalues_double", memberRating.doubleValue());
		}
		if(aligned != null) {
			document.addField("aligned_docvalues_string", aligned);
		}
		if(pageUrl != null) {
			document.addField("pageUrl_docvalues_string", pageUrl);
		}
		if(indexed != null) {
			document.addField("indexed_docvalues_string", indexed);
		}
		if(lastIndexDate != null) {
			document.addField("lastIndexDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(lastIndexDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(indexRequired != null) {
			document.addField("indexRequired_docvalues_string", indexRequired);
		}
		if(indexRequiredDate != null) {
			document.addField("indexRequiredDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(indexRequiredDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(rescrape != null) {
			document.addField("rescrape_docvalues_string", rescrape);
		}
		if(goButton != null) {
			document.addField("goButton_docvalues_string", goButton);
		}
		if(downloadButton != null) {
			document.addField("downloadButton_docvalues_string", downloadButton);
		}
		if(topOfSearch != null) {
			document.addField("topOfSearch_docvalues_string", topOfSearch);
		}
		if(remove != null) {
			document.addField("remove_docvalues_string", remove);
		}
		if(spam != null) {
			document.addField("spam_docvalues_string", spam);
		}
		if(topOfSearchInt != null) {
			document.addField("topOfSearchInt_docvalues_int", topOfSearchInt);
		}
		if(partnerInt != null) {
			document.addField("partnerInt_docvalues_int", partnerInt);
		}
		if(reviewResource != null) {
			document.addField("reviewResource_docvalues_string", reviewResource);
		}
		if(oldUrl != null) {
			document.addField("oldUrl_docvalues_string", oldUrl);
		}
		if(contentDisplayOk != null) {
			document.addField("contentDisplayOk_docvalues_string", contentDisplayOk);
		}
		if(metadata != null) {
			document.addField("metadata_docvalues_string", metadata);
		}
		if(approvalStatus != null) {
			document.addField("approvalStatus_docvalues_string", approvalStatus);
		}
		if(approvalStatusDate != null) {
			document.addField("approvalStatusDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(approvalStatusDate.atOffset(ZoneOffset.UTC)));
		}
		if(spamUser != null) {
			document.addField("spamUser_docvalues_string", spamUser);
		}
		super.indexBaseModel(document);

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

	@Override public void storeForClass(SolrDocument solrDocument) {
		storeCurrikiResource(solrDocument);
	}
	public void storeCurrikiResource(SolrDocument solrDocument) {
		CurrikiResource oCurrikiResource = (CurrikiResource)this;

		oCurrikiResource.setResourceId(Optional.ofNullable(solrDocument.get("resourceId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setLicenseId(Optional.ofNullable(solrDocument.get("licenseId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setContributorId(Optional.ofNullable(solrDocument.get("contributorId_docvalues_long")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setContributionDate(Optional.ofNullable(solrDocument.get("contributionDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setDescription(Optional.ofNullable(solrDocument.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setTitle(Optional.ofNullable(solrDocument.get("title_docvalues_string")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)solrDocument.get("keywords_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oCurrikiResource.addKeywords(v.toString());
		});
		Optional.ofNullable((List<?>)solrDocument.get("generatedKeywords_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oCurrikiResource.addGeneratedKeywords(v.toString());
		});
		oCurrikiResource.setLanguage(Optional.ofNullable(solrDocument.get("language_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setLastEditorId(Optional.ofNullable(solrDocument.get("lastEditorId_docvalues_long")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setLastEditDate(Optional.ofNullable(solrDocument.get("lastEditDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setCurrikiLicense(Optional.ofNullable(solrDocument.get("currikiLicense_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setExternalUrl(Optional.ofNullable(solrDocument.get("externalUrl_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setResourceChecked(Optional.ofNullable(solrDocument.get("resourceChecked_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setContent(Optional.ofNullable(solrDocument.get("content_stored_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setResourceCheckDate(Optional.ofNullable(solrDocument.get("resourceCheckDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setResourceCheckId(Optional.ofNullable(solrDocument.get("resourceCheckId_docvalues_long")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setStudentFacing(Optional.ofNullable(solrDocument.get("studentFacing_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSource(Optional.ofNullable(solrDocument.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setReviewStatus(Optional.ofNullable(solrDocument.get("reviewStatus_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setLastReviewDate(Optional.ofNullable(solrDocument.get("lastReviewDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setReviewByID(Optional.ofNullable(solrDocument.get("reviewByID_docvalues_long")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setReviewRating(Optional.ofNullable(solrDocument.get("reviewRating_docvalues_double")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setTechnicalCompleteness(Optional.ofNullable(solrDocument.get("technicalCompleteness_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setContentAccuracy(Optional.ofNullable(solrDocument.get("contentAccuracy_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setPedagogy(Optional.ofNullable(solrDocument.get("pedagogy_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setRatingComment(Optional.ofNullable(solrDocument.get("ratingComment_stored_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setStandardsAlignment(Optional.ofNullable(solrDocument.get("standardsAlignment_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setStandardsAlignmentComment(Optional.ofNullable(solrDocument.get("standardsAlignmentComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSubjectMatter(Optional.ofNullable(solrDocument.get("subjectMatter_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSubjectMatterComment(Optional.ofNullable(solrDocument.get("subjectMatterComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSupportsTeaching(Optional.ofNullable(solrDocument.get("supportsTeaching_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSupportsTeachingComment(Optional.ofNullable(solrDocument.get("supportsTeachingComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setAssessmentsQuality(Optional.ofNullable(solrDocument.get("assessmentsQuality_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setAssessmentsQualityComment(Optional.ofNullable(solrDocument.get("assessmentsQualityComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setInteractivityQuality(Optional.ofNullable(solrDocument.get("interactivityQuality_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setInteractivityQualityComment(Optional.ofNullable(solrDocument.get("interactivityQualityComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setInstructionalQuality(Optional.ofNullable(solrDocument.get("instructionalQuality_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setInstructionalQualityComment(Optional.ofNullable(solrDocument.get("instructionalQualityComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setDeeperLearning(Optional.ofNullable(solrDocument.get("deeperLearning_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setDeeperLearningComment(Optional.ofNullable(solrDocument.get("deeperLearningComment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setPartner(Optional.ofNullable(solrDocument.get("partner_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setCreateDate(Optional.ofNullable(solrDocument.get("createDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setType(Optional.ofNullable(solrDocument.get("type_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setFeatured(Optional.ofNullable(solrDocument.get("featured_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setPage(Optional.ofNullable(solrDocument.get("page_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setActive(Optional.ofNullable(solrDocument.get("active_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setPublic(Optional.ofNullable(solrDocument.get("Public_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setXwd_id(Optional.ofNullable(solrDocument.get("xwd_id_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setMediaType(Optional.ofNullable(solrDocument.get("mediaType_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setAccess(Optional.ofNullable(solrDocument.get("access_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setMemberRating(Optional.ofNullable(solrDocument.get("memberRating_docvalues_double")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setAligned(Optional.ofNullable(solrDocument.get("aligned_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setPageUrl(Optional.ofNullable(solrDocument.get("pageUrl_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setIndexed(Optional.ofNullable(solrDocument.get("indexed_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setLastIndexDate(Optional.ofNullable(solrDocument.get("lastIndexDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setIndexRequired(Optional.ofNullable(solrDocument.get("indexRequired_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setIndexRequiredDate(Optional.ofNullable(solrDocument.get("indexRequiredDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setRescrape(Optional.ofNullable(solrDocument.get("rescrape_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setGoButton(Optional.ofNullable(solrDocument.get("goButton_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setDownloadButton(Optional.ofNullable(solrDocument.get("downloadButton_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setTopOfSearch(Optional.ofNullable(solrDocument.get("topOfSearch_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setRemove(Optional.ofNullable(solrDocument.get("remove_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSpam(Optional.ofNullable(solrDocument.get("spam_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setTopOfSearchInt(Optional.ofNullable(solrDocument.get("topOfSearchInt_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setPartnerInt(Optional.ofNullable(solrDocument.get("partnerInt_docvalues_int")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setReviewResource(Optional.ofNullable(solrDocument.get("reviewResource_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setOldUrl(Optional.ofNullable(solrDocument.get("oldUrl_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setContentDisplayOk(Optional.ofNullable(solrDocument.get("contentDisplayOk_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setMetadata(Optional.ofNullable(solrDocument.get("metadata_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setApprovalStatus(Optional.ofNullable(solrDocument.get("approvalStatus_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setApprovalStatusDate(Optional.ofNullable(solrDocument.get("approvalStatusDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oCurrikiResource.setSpamUser(Optional.ofNullable(solrDocument.get("spamUser_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(solrDocument);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestCurrikiResource() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
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
}
