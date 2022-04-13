package org.curriki.api.enus.page;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.wrap.Wrap;
import org.curriki.api.enus.config.ConfigKeys;
import org.curriki.api.enus.request.SiteRequestEnUS;

import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.service.ServiceRequest;


/**
 * Keyword: classSimpleNamePageLayout
 * Description: Defines variables to be used when rendering Handlebars template pages
 **/
public class PageLayout extends PageLayoutGen<Object> {

	/**
	 * Ignore: true
	 * Description: The current request object
	**/
	protected void _siteRequest_(Wrap<SiteRequestEnUS> w) {
	}

	/**
	 * Description: The current request vars
	 */
	protected void _requestVars(Wrap<Map<String, String>> w) {
		w.o(siteRequest_.getRequestVars());
	}

	/**
	 * Ignore: true
	 * Description: the site configuration
	 */
	protected void _config(Wrap<JsonObject> w) {
		w.o(siteRequest_.getConfig());
	}

	/**
	 * Description: The current Vert.x service request
	 */
	protected void _serviceRequest(Wrap<ServiceRequest> w) {
		w.o(siteRequest_.getServiceRequest());
	}

	protected void _staticBaseUrl(Wrap<String> w) {
		w.o(siteRequest_.getConfig().getString(ConfigKeys.STATIC_BASE_URL));
	}

	protected void _STATIC_BASE_URL(Wrap<String> w) {
		w.o(siteRequest_.getConfig().getString(ConfigKeys.STATIC_BASE_URL));
	}

	protected void _SITE_BASE_URL(Wrap<String> w) {
		w.o(siteRequest_.getConfig().getString(ConfigKeys.SITE_BASE_URL));
	}

	protected void _SITE_AUTH_URL(Wrap<String> w) {
		w.o(siteRequest_.getConfig().getString(ConfigKeys.AUTH_URL));
	}

	protected void _SITE_AUTH_REALM(Wrap<String> w) {
		w.o(siteRequest_.getConfig().getString(ConfigKeys.AUTH_REALM));
	}

	protected void _FONTAWESOME_KIT(Wrap<String> w) {
		w.o(siteRequest_.getConfig().getString(ConfigKeys.FONTAWESOME_KIT));
	}

	/**
	 * Description: The current request URI
	 */
	protected void _pageUri(Wrap<String> w) {
		w.o(Optional.ofNullable(serviceRequest).map(r -> r.getExtra()).map(e -> e.getString("uri")).orElse(null));
	}

	/**
	 * Description: The current request HTTP method
	 */
	protected void _pageMethod(Wrap<String> w) {
		w.o(Optional.ofNullable(serviceRequest).map(r -> r.getExtra()).map(e -> e.getString("method")).orElse(null));
	}

	/**
	 * Description: The current request parameters
	 */
	protected void _params(Wrap<JsonObject> w) {
		w.o(Optional.ofNullable(serviceRequest).map(r -> r.getParams()).orElse(new JsonObject()));
	}

	/**
	 * Description: The current user's primary key
	 */
	protected void _userKey(Wrap<Long> w) {
		w.o(siteRequest_.getUserKey());
	}

	/**
	 * Description: The current user's full name
	 */
	protected void _userFullName(Wrap<String> w) {
		w.o(siteRequest_.getUserFullName());
	}

	/**
	 * Description: The current user's username
	 */
	protected void _userName(Wrap<String> w) {
		w.o(siteRequest_.getUserFullName());
	}

	/**
	 * Description: The current user's email
	 */
	protected void _userEmail(Wrap<String> w) {
		w.o(siteRequest_.getUserEmail());
	}

	/**
	 * Description: The logout URL
	 */
	protected void _logoutUrl(Wrap<String> w) {
		JsonObject config = siteRequest_.getConfig();
		try {
			w.o(config.getString(ConfigKeys.AUTH_URL) + "/realms/" + config.getString(ConfigKeys.AUTH_REALM) + "/protocol/openid-connect/logout?redirect_uri=" + URLEncoder.encode(config.getString(ConfigKeys.SITE_BASE_URL) + "/logout", "UTF-8"));
		} catch (UnsupportedEncodingException ex) {
			ExceptionUtils.rethrow(ex);
		}
	}

	/**
	 * Description: A helper field for the long number 0
	 */
	protected void _long0(Wrap<Long> w) {
		w.o(0L);
	}

	/**
	 * Description: A helper field for the long number 1
	 */
	protected void _long1(Wrap<Long> w) {
		w.o(1L);
	}

	/**
	 * Description: A helper field for the integer number 0
	 */
	protected void _int0(Wrap<Integer> w) {
		w.o(0);
	}

	/**
	 * Description: A helper field for the integer number 1
	 */
	protected void _int1(Wrap<Integer> w) {
		w.o(1);
	}

	/**
	 * Ignore: true
	 * Description: A method that can be overridden at the start of the request that makes this main template be initialized with a Vert.x promise for reactive initialization
	**/
	protected void _promiseBefore(Promise<Void> promise) {
		promise.complete();
	}

	/**
	 * Description: The simple name of this Java class
	 */
	protected void _classSimpleName(Wrap<String> w) {
	}

	/**
	 * Description: The page title to override
	 */
	protected void _pageTitle(Wrap<String> w) {
	}

	/**
	 * Description: The user's roles
	 */
	protected void _roles(List<String> l) {
		if(siteRequest_ != null) {
			l.addAll(Stream.concat(siteRequest_.getUserResourceRoles().stream(), siteRequest_.getUserResourceRoles().stream()).collect(Collectors.toList()));
		}
	}

	/**
	 * Description: The required roles to access this page
	 */
	protected void _rolesRequired(List<String> l) {
		l.addAll(siteRequest_.getConfig().getJsonArray(ConfigKeys.AUTH_ROLES_ADMIN).stream().map(o -> o.toString()).collect(Collectors.toList()));
	}

	/**
	 * Description: The admin roles required to access this page
	 */
	protected void _authRolesAdmin(List<String> l) {
		l.addAll(siteRequest_.getConfig().getJsonArray(ConfigKeys.AUTH_ROLES_ADMIN).stream().map(o -> o.toString()).collect(Collectors.toList()));
	}

	/**
	 * Description: The pagination data about this request
	 */
	protected void _pagination(JsonObject pagination) {
	}

	protected void _varsQ(JsonObject vars) {
	}

	protected void _varsFq(JsonObject vars) {
	}

	protected void _varsRange(JsonObject vars) {
	}

	/**
	 * Description: The query data about this request
	 */
	protected void _query(JsonObject query) {
	}

	/**
	 * Ignore: true
	 * Description: A method that can be overridden at the end of the request that makes this main template be initialized with a Vert.x promise for reactive initialization
	**/
	protected void _promiseAfter(Promise<Void> promise) {
		promise.complete();
	}

	/**
	 * Description: The image URI for this page
	 */
	protected void _pageImageUri(Wrap<String> w) {
	}

	/**
	 * Description: The icon group for this page
	 */
	protected void _contextIconGroup(Wrap<String> w) {
	}

	/**
	 * Description: The icon name for this page
	 */
	protected void _contextIconName(Wrap<String> w) {
	}

	/**
	 * Description: The icon CSS classes for this page
	 */
	protected void _contextIconCssClasses(Wrap<String> w) {
		if(contextIconGroup != null && contextIconName != null) {
			w.o(String.format("fa-%s fa-%s ", contextIconGroup, contextIconName));
		}
	}

	/**
	 * Description: An optional description field for the page
	 */
	protected void _pageDescription(Wrap<String> w) {
	}
}
