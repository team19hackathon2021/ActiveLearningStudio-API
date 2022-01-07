package org.curriki.api.enus.model.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.curriki.api.enus.base.BaseModel;
import java.util.Date;
import org.curriki.api.enus.request.api.ApiRequest;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import org.curriki.api.enus.request.SiteRequestEnUS;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.curriki.api.enus.wrap.Wrap;
import org.curriki.api.enus.java.ZonedDateTimeDeserializer;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.json.JsonObject;
import org.curriki.api.enus.java.ZonedDateTimeSerializer;
import java.lang.String;
import java.math.RoundingMode;
import org.slf4j.Logger;
import java.math.MathContext;
import io.vertx.core.Promise;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.util.Set;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.curriki.api.enus.config.ConfigKeys;
import io.vertx.core.Future;
import org.apache.solr.client.solrj.SolrClient;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.solr.client.solrj.util.ClientUtils;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.curriki.api.enus.java.LocalDateSerializer;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;

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
				keywordsStrInit();
				keywordsInit();
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
			case "keywordsStr":
				return oCurrikiResource.keywordsStr;
			case "keywords":
				return oCurrikiResource.keywords;
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
		case "keywordsStr":
			return CurrikiResource.staticSetKeywordsStr(siteRequest_, o);
		case "keywords":
			return CurrikiResource.staticSetKeywords(siteRequest_, o);
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
		case "keywordsStr":
			return CurrikiResource.staticSolrKeywordsStr(siteRequest_, (String)o);
		case "keywords":
			return CurrikiResource.staticSolrKeywords(siteRequest_, (String)o);
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
		case "keywordsStr":
			return CurrikiResource.staticSolrStrKeywordsStr(siteRequest_, (String)o);
		case "keywords":
			return CurrikiResource.staticSolrStrKeywords(siteRequest_, (String)o);
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
		case "keywordsStr":
			return CurrikiResource.staticSolrFqKeywordsStr(siteRequest_, o);
		case "keywords":
			return CurrikiResource.staticSolrFqKeywords(siteRequest_, o);
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
			case "keywordsstr":
				if(val instanceof String)
					setKeywordsStr((String)val);
				saves.add("keywordsStr");
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
		}

		super.populateBaseModel(solrDocument);
	}

	public void indexCurrikiResource(SolrInputDocument document) {
		if(resourceId != null) {
			document.addField("resourceId_docvalues_string", resourceId);
		}
		if(keywordsStr != null) {
			document.addField("keywordsStr_docvalues_string", keywordsStr);
		}
		if(keywords != null) {
			for(java.lang.String o : keywords) {
				document.addField("keywords_docvalues_strings", o);
			}
		}
		super.indexBaseModel(document);

	}

	public static String varIndexedCurrikiResource(String entityVar) {
		switch(entityVar) {
			case "resourceId":
				return "resourceId_docvalues_string";
			case "keywordsStr":
				return "keywordsStr_docvalues_string";
			case "keywords":
				return "keywords_docvalues_strings";
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
		oCurrikiResource.setKeywordsStr(Optional.ofNullable(solrDocument.get("keywordsStr_docvalues_string")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)solrDocument.get("keywords_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oCurrikiResource.addKeywords(v.toString());
		});

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
			if(!Objects.equals(keywordsStr, original.getKeywordsStr()))
				apiRequest.addVars("keywordsStr");
			if(!Objects.equals(keywords, original.getKeywords()))
				apiRequest.addVars("keywords");
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
		sb.append(Optional.ofNullable(keywordsStr).map(v -> "keywordsStr: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(keywords).map(v -> "keywords: " + v + "\n").orElse(""));
		return sb.toString();
	}

	public static final String VAR_resourceId = "resourceId";
	public static final String VAR_keywordsStr = "keywordsStr";
	public static final String VAR_keywords = "keywords";
}
