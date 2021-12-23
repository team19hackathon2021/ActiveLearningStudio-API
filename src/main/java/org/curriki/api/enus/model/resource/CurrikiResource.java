package org.curriki.api.enus.model.resource;

import java.util.Arrays;
import java.util.List;

import org.curriki.api.enus.base.BaseModel;
import org.curriki.api.enus.wrap.Wrap;

/**   
 * Model: true
 * Api: true
 * Page: true
 * SuperPage.enUS: BaseModelPage
 * Indexed: true
 * Map.Integer.sqlSort: 2
 * 
 * ApiTag.enUS: Resource
 * ApiUri.enUS: /api/resource
 * 
 * ApiMethod.enUS: Search
 * ApiMethod: PATCH
 * ApiMethod: POST
 * ApiMethod: PUTImport
 * 
 * ApiMethod.enUS: SearchPage
 * PageSearchPage.enUS: CurrikiResourcePage
 * PageSuperSearchPage.enUS: BaseModelPage
 * ApiUriSearchPage.enUS: /resource
 * 
 * Role.enUS: SiteAdmin
 * Saves: true
 * 
 * AName.enUS: a resource
 * Color: blue
 * IconGroup: regular
 * IconName: file
 * 
 * 
 */ 
public class CurrikiResource extends CurrikiResourceGen <BaseModel> {
 
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * DisplayName: resource ID
	 * HtmlRow: 3
	 * HtmlCell: 1
	 */
	protected void _resourceId(Wrap<String> w) {
		
	}
 
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * DisplayName: Keywords
	 * HtmlRow: 3
	 * HtmlCell: 2
	 */
	protected void _keywordsStr(Wrap<String> w) {
		
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * DisplayName: resource ID
	 * HtmlRow: 3
	 * HtmlCell: 2
	 */
	protected void _keywords(List<String> l) {
		l.addAll(Arrays.asList(keywordsStr.split(" ")));
	}
	
	
	
}
