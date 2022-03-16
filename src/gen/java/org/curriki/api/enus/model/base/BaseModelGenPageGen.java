package org.curriki.api.enus.model.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import java.util.HashMap;
import org.curriki.api.enus.request.SiteRequestEnUS;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.vertx.api.ApiRequest;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.String;
import org.curriki.api.enus.model.base.BaseModel;
import java.math.RoundingMode;
import org.slf4j.Logger;
import org.curriki.api.enus.page.PageLayout;
import java.math.MathContext;
import io.vertx.core.Promise;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.curriki.api.enus.config.ConfigKeys;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.vertx.core.Future;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import java.util.Objects;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.vertx.search.list.SearchList;
import io.vertx.core.json.JsonArray;
import org.computate.search.wrap.Wrap;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.base.BaseModelGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class BaseModelGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOG = LoggerFactory.getLogger(BaseModelGenPage.class);

	//////////////////////////
	// searchListBaseModel_ //
	//////////////////////////

	/**	 The entity searchListBaseModel_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<BaseModel> searchListBaseModel_;

	/**	<br> The entity searchListBaseModel_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.base.BaseModelGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchListBaseModel_">Find the entity searchListBaseModel_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListBaseModel_(Wrap<SearchList<BaseModel>> w);

	public SearchList<BaseModel> getSearchListBaseModel_() {
		return searchListBaseModel_;
	}

	public void setSearchListBaseModel_(SearchList<BaseModel> searchListBaseModel_) {
		this.searchListBaseModel_ = searchListBaseModel_;
	}
	public static SearchList<BaseModel> staticSetSearchListBaseModel_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected BaseModelGenPage searchListBaseModel_Init() {
		Wrap<SearchList<BaseModel>> searchListBaseModel_Wrap = new Wrap<SearchList<BaseModel>>().var("searchListBaseModel_");
		if(searchListBaseModel_ == null) {
			_searchListBaseModel_(searchListBaseModel_Wrap);
			setSearchListBaseModel_(searchListBaseModel_Wrap.o);
		}
		return (BaseModelGenPage)this;
	}

	///////////////////
	// listBaseModel //
	///////////////////

	/**	 The entity listBaseModel
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listBaseModel = new JsonArray();

	/**	<br> The entity listBaseModel
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.base.BaseModelGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listBaseModel">Find the entity listBaseModel in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listBaseModel(JsonArray l);

	public JsonArray getListBaseModel() {
		return listBaseModel;
	}

	public void setListBaseModel(JsonArray listBaseModel) {
		this.listBaseModel = listBaseModel;
	}
	public static JsonArray staticSetListBaseModel(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected BaseModelGenPage listBaseModelInit() {
		_listBaseModel(listBaseModel);
		return (BaseModelGenPage)this;
	}

	////////////////////
	// baseModelCount //
	////////////////////

	/**	 The entity baseModelCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer baseModelCount;

	/**	<br> The entity baseModelCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.base.BaseModelGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:baseModelCount">Find the entity baseModelCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _baseModelCount(Wrap<Integer> w);

	public Integer getBaseModelCount() {
		return baseModelCount;
	}

	public void setBaseModelCount(Integer baseModelCount) {
		this.baseModelCount = baseModelCount;
	}
	@JsonIgnore
	public void setBaseModelCount(String o) {
		this.baseModelCount = BaseModelGenPage.staticSetBaseModelCount(siteRequest_, o);
	}
	public static Integer staticSetBaseModelCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected BaseModelGenPage baseModelCountInit() {
		Wrap<Integer> baseModelCountWrap = new Wrap<Integer>().var("baseModelCount");
		if(baseModelCount == null) {
			_baseModelCount(baseModelCountWrap);
			setBaseModelCount(baseModelCountWrap.o);
		}
		return (BaseModelGenPage)this;
	}

	public static Integer staticSearchBaseModelCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrBaseModelCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqBaseModelCount(SiteRequestEnUS siteRequest_, String o) {
		return BaseModelGenPage.staticSearchStrBaseModelCount(siteRequest_, BaseModelGenPage.staticSearchBaseModelCount(siteRequest_, BaseModelGenPage.staticSetBaseModelCount(siteRequest_, o)));
	}

	////////////////
	// baseModel_ //
	////////////////

	/**	 The entity baseModel_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected BaseModel baseModel_;

	/**	<br> The entity baseModel_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.curriki.api.enus.model.base.BaseModelGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:baseModel_">Find the entity baseModel_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _baseModel_(Wrap<BaseModel> w);

	public BaseModel getBaseModel_() {
		return baseModel_;
	}

	public void setBaseModel_(BaseModel baseModel_) {
		this.baseModel_ = baseModel_;
	}
	public static BaseModel staticSetBaseModel_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected BaseModelGenPage baseModel_Init() {
		Wrap<BaseModel> baseModel_Wrap = new Wrap<BaseModel>().var("baseModel_");
		if(baseModel_ == null) {
			_baseModel_(baseModel_Wrap);
			setBaseModel_(baseModel_Wrap.o);
		}
		return (BaseModelGenPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepBaseModelGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepBaseModelGenPage();
	}

	public Future<Void> promiseDeepBaseModelGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseBaseModelGenPage(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepPageLayout(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseBaseModelGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListBaseModel_Init();
				listBaseModelInit();
				baseModelCountInit();
				baseModel_Init();
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
		return promiseDeepBaseModelGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestBaseModelGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestBaseModelGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainBaseModelGenPage(v);
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
	public Object obtainBaseModelGenPage(String var) {
		BaseModelGenPage oBaseModelGenPage = (BaseModelGenPage)this;
		switch(var) {
			case "searchListBaseModel_":
				return oBaseModelGenPage.searchListBaseModel_;
			case "listBaseModel":
				return oBaseModelGenPage.listBaseModel;
			case "baseModelCount":
				return oBaseModelGenPage.baseModelCount;
			case "baseModel_":
				return oBaseModelGenPage.baseModel_;
			default:
				return super.obtainPageLayout(var);
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
				o = relateBaseModelGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateBaseModelGenPage(String var, Object val) {
		BaseModelGenPage oBaseModelGenPage = (BaseModelGenPage)this;
		switch(var) {
			default:
				return super.relatePageLayout(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetBaseModelGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetBaseModelGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "baseModelCount":
			return BaseModelGenPage.staticSetBaseModelCount(siteRequest_, o);
			default:
				return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchBaseModelGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchBaseModelGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "baseModelCount":
			return BaseModelGenPage.staticSearchBaseModelCount(siteRequest_, (Integer)o);
			default:
				return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrBaseModelGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrBaseModelGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "baseModelCount":
			return BaseModelGenPage.staticSearchStrBaseModelCount(siteRequest_, (Integer)o);
			default:
				return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqBaseModelGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqBaseModelGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "baseModelCount":
			return BaseModelGenPage.staticSearchFqBaseModelCount(siteRequest_, o);
			default:
				return PageLayout.staticSearchFqPageLayout(entityVar,  siteRequest_, o);
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

	public static final String VAR_searchListBaseModel_ = "searchListBaseModel_";
	public static final String VAR_listBaseModel = "listBaseModel";
	public static final String VAR_baseModelCount = "baseModelCount";
	public static final String VAR_baseModel_ = "baseModel_";

	public static final String DISPLAY_NAME_searchListBaseModel_ = "";
	public static final String DISPLAY_NAME_listBaseModel = "";
	public static final String DISPLAY_NAME_baseModelCount = "";
	public static final String DISPLAY_NAME_baseModel_ = "";

	public static String displayNameForClass(String var) {
		return BaseModelGenPage.displayNameBaseModelGenPage(var);
	}
	public static String displayNameBaseModelGenPage(String var) {
		switch(var) {
		case VAR_searchListBaseModel_:
			return DISPLAY_NAME_searchListBaseModel_;
		case VAR_listBaseModel:
			return DISPLAY_NAME_listBaseModel;
		case VAR_baseModelCount:
			return DISPLAY_NAME_baseModelCount;
		case VAR_baseModel_:
			return DISPLAY_NAME_baseModel_;
		default:
			return PageLayout.displayNamePageLayout(var);
		}
	}
}
