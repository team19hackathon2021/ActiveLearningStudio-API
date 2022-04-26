package org.curriki.api.enus.model.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.curriki.api.enus.base.BaseModel;
import org.curriki.api.enus.request.api.ApiRequest;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import org.curriki.api.enus.model.resource.CurrikiResource;
import org.curriki.api.enus.request.SiteRequestEnUS;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.curriki.api.enus.wrap.Wrap;
import org.curriki.api.enus.java.ZonedDateTimeDeserializer;
import org.apache.commons.collections.CollectionUtils;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.curriki.api.enus.java.ZonedDateTimeSerializer;
import java.lang.String;
import java.math.RoundingMode;
import org.curriki.api.enus.search.SearchList;
import org.slf4j.Logger;
import java.math.MathContext;
import io.vertx.core.Promise;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.curriki.api.enus.config.ConfigKeys;
import io.vertx.core.Future;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.curriki.api.enus.base.BaseModelPage;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.curriki.api.enus.java.LocalDateSerializer;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResourceGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class CurrikiResourceGenPageGen<DEV> extends BaseModelPage {
	protected static final Logger LOG = LoggerFactory.getLogger(CurrikiResourceGenPage.class);

	////////////////////////////////
	// searchListCurrikiResource_ //
	////////////////////////////////

	/**	 The entity searchListCurrikiResource_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<CurrikiResource> searchListCurrikiResource_;

	/**	<br/> The entity searchListCurrikiResource_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResourceGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchListCurrikiResource_">Find the entity searchListCurrikiResource_ in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListCurrikiResource_(Wrap<SearchList<CurrikiResource>> w);

	public SearchList<CurrikiResource> getSearchListCurrikiResource_() {
		return searchListCurrikiResource_;
	}

	public void setSearchListCurrikiResource_(SearchList<CurrikiResource> searchListCurrikiResource_) {
		this.searchListCurrikiResource_ = searchListCurrikiResource_;
	}
	public static SearchList<CurrikiResource> staticSetSearchListCurrikiResource_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected CurrikiResourceGenPage searchListCurrikiResource_Init() {
		Wrap<SearchList<CurrikiResource>> searchListCurrikiResource_Wrap = new Wrap<SearchList<CurrikiResource>>().var("searchListCurrikiResource_");
		if(searchListCurrikiResource_ == null) {
			_searchListCurrikiResource_(searchListCurrikiResource_Wrap);
			setSearchListCurrikiResource_(searchListCurrikiResource_Wrap.o);
		}
		return (CurrikiResourceGenPage)this;
	}

	/////////////////////////
	// listCurrikiResource //
	/////////////////////////

	/**	 The entity listCurrikiResource
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut JsonArray(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listCurrikiResource = new JsonArray();

	/**	<br/> The entity listCurrikiResource
	 *  It is constructed before being initialized with the constructor by default JsonArray(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResourceGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listCurrikiResource">Find the entity listCurrikiResource in Solr</a>
	 * <br/>
	 * @param listCurrikiResource is the entity already constructed. 
	 **/
	protected abstract void _listCurrikiResource(JsonArray l);

	public JsonArray getListCurrikiResource() {
		return listCurrikiResource;
	}

	public void setListCurrikiResource(JsonArray listCurrikiResource) {
		this.listCurrikiResource = listCurrikiResource;
	}
	public static JsonArray staticSetListCurrikiResource(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected CurrikiResourceGenPage listCurrikiResourceInit() {
		_listCurrikiResource(listCurrikiResource);
		return (CurrikiResourceGenPage)this;
	}

	//////////////////////////
	// currikiResourceCount //
	//////////////////////////

	/**	 The entity currikiResourceCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer currikiResourceCount;

	/**	<br/> The entity currikiResourceCount
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResourceGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:currikiResourceCount">Find the entity currikiResourceCount in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _currikiResourceCount(Wrap<Integer> w);

	public Integer getCurrikiResourceCount() {
		return currikiResourceCount;
	}

	public void setCurrikiResourceCount(Integer currikiResourceCount) {
		this.currikiResourceCount = currikiResourceCount;
	}
	@JsonIgnore
	public void setCurrikiResourceCount(String o) {
		this.currikiResourceCount = CurrikiResourceGenPage.staticSetCurrikiResourceCount(siteRequest_, o);
	}
	public static Integer staticSetCurrikiResourceCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CurrikiResourceGenPage currikiResourceCountInit() {
		Wrap<Integer> currikiResourceCountWrap = new Wrap<Integer>().var("currikiResourceCount");
		if(currikiResourceCount == null) {
			_currikiResourceCount(currikiResourceCountWrap);
			setCurrikiResourceCount(currikiResourceCountWrap.o);
		}
		return (CurrikiResourceGenPage)this;
	}

	public static Integer staticSolrCurrikiResourceCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrCurrikiResourceCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqCurrikiResourceCount(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResourceGenPage.staticSolrStrCurrikiResourceCount(siteRequest_, CurrikiResourceGenPage.staticSolrCurrikiResourceCount(siteRequest_, CurrikiResourceGenPage.staticSetCurrikiResourceCount(siteRequest_, o)));
	}

	//////////////////////
	// currikiResource_ //
	//////////////////////

	/**	 The entity currikiResource_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected CurrikiResource currikiResource_;

	/**	<br/> The entity currikiResource_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResourceGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:currikiResource_">Find the entity currikiResource_ in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _currikiResource_(Wrap<CurrikiResource> w);

	public CurrikiResource getCurrikiResource_() {
		return currikiResource_;
	}

	public void setCurrikiResource_(CurrikiResource currikiResource_) {
		this.currikiResource_ = currikiResource_;
	}
	public static CurrikiResource staticSetCurrikiResource_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected CurrikiResourceGenPage currikiResource_Init() {
		Wrap<CurrikiResource> currikiResource_Wrap = new Wrap<CurrikiResource>().var("currikiResource_");
		if(currikiResource_ == null) {
			_currikiResource_(currikiResource_Wrap);
			setCurrikiResource_(currikiResource_Wrap.o);
		}
		return (CurrikiResourceGenPage)this;
	}

	////////
	// pk //
	////////

	/**	 The entity pk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long pk;

	/**	<br/> The entity pk
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.resource.CurrikiResourceGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pk(Wrap<Long> w);

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}
	@JsonIgnore
	public void setPk(String o) {
		this.pk = CurrikiResourceGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected CurrikiResourceGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			setPk(pkWrap.o);
		}
		return (CurrikiResourceGenPage)this;
	}

	public static Long staticSolrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPk(SiteRequestEnUS siteRequest_, String o) {
		return CurrikiResourceGenPage.staticSolrStrPk(siteRequest_, CurrikiResourceGenPage.staticSolrPk(siteRequest_, CurrikiResourceGenPage.staticSetPk(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepCurrikiResourceGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepCurrikiResourceGenPage();
	}

	public Future<Void> promiseDeepCurrikiResourceGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseCurrikiResourceGenPage(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepBaseModelPage(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseCurrikiResourceGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListCurrikiResource_Init();
				listCurrikiResourceInit();
				currikiResourceCountInit();
				currikiResource_Init();
				pkInit();
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
		return promiseDeepCurrikiResourceGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestCurrikiResourceGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModelPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestCurrikiResourceGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainCurrikiResourceGenPage(v);
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
	public Object obtainCurrikiResourceGenPage(String var) {
		CurrikiResourceGenPage oCurrikiResourceGenPage = (CurrikiResourceGenPage)this;
		switch(var) {
			case "searchListCurrikiResource_":
				return oCurrikiResourceGenPage.searchListCurrikiResource_;
			case "listCurrikiResource":
				return oCurrikiResourceGenPage.listCurrikiResource;
			case "currikiResourceCount":
				return oCurrikiResourceGenPage.currikiResourceCount;
			case "currikiResource_":
				return oCurrikiResourceGenPage.currikiResource_;
			case "pk":
				return oCurrikiResourceGenPage.pk;
			default:
				return super.obtainBaseModelPage(var);
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
				o = relateCurrikiResourceGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateCurrikiResourceGenPage(String var, Object val) {
		CurrikiResourceGenPage oCurrikiResourceGenPage = (CurrikiResourceGenPage)this;
		switch(var) {
			default:
				return super.relateBaseModelPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetCurrikiResourceGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetCurrikiResourceGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "currikiResourceCount":
			return CurrikiResourceGenPage.staticSetCurrikiResourceCount(siteRequest_, o);
		case "pk":
			return CurrikiResourceGenPage.staticSetPk(siteRequest_, o);
			default:
				return BaseModelPage.staticSetBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrCurrikiResourceGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrCurrikiResourceGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "currikiResourceCount":
			return CurrikiResourceGenPage.staticSolrCurrikiResourceCount(siteRequest_, (Integer)o);
		case "pk":
			return CurrikiResourceGenPage.staticSolrPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSolrBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrCurrikiResourceGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrCurrikiResourceGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "currikiResourceCount":
			return CurrikiResourceGenPage.staticSolrStrCurrikiResourceCount(siteRequest_, (Integer)o);
		case "pk":
			return CurrikiResourceGenPage.staticSolrStrPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSolrStrBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqCurrikiResourceGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqCurrikiResourceGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "currikiResourceCount":
			return CurrikiResourceGenPage.staticSolrFqCurrikiResourceCount(siteRequest_, o);
		case "pk":
			return CurrikiResourceGenPage.staticSolrFqPk(siteRequest_, o);
			default:
				return BaseModelPage.staticSolrFqBaseModelPage(entityVar,  siteRequest_, o);
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
					o = defineCurrikiResourceGenPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineCurrikiResourceGenPage(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineBaseModelPage(var, val);
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestCurrikiResourceGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof CurrikiResourceGenPage) {
			CurrikiResourceGenPage original = (CurrikiResourceGenPage)o;
			super.apiRequestBaseModelPage();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		return sb.toString();
	}

	public static final String VAR_searchListCurrikiResource_ = "searchListCurrikiResource_";
	public static final String VAR_listCurrikiResource = "listCurrikiResource";
	public static final String VAR_currikiResourceCount = "currikiResourceCount";
	public static final String VAR_currikiResource_ = "currikiResource_";
	public static final String VAR_pk = "pk";
}
