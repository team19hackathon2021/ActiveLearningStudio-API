package org.curriki.api.enus.model.resource;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import org.computate.search.wrap.Wrap;
import org.curriki.api.enus.model.base.BaseModel;

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
	 * Persist: true
	 * DisplayName: resource ID
	 * HtmlRow: 3
	 * HtmlCell: 1
	 */
	protected void _resourceId(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: license ID
	 * HtmlRow: 3
	 * HtmlCell: 2
	 */
	protected void _licenseId(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: contributor ID
	 * HtmlRow: 3
	 * HtmlCell: 3
	 */
	protected void _contributorId(Wrap<Long> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: contribution Date
	 * HtmlRow: 4
	 * HtmlCell: 1
	 */
	protected void _contributionDate(Wrap<ZonedDateTime> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: description
	 * HtmlRow: 4
	 * HtmlCell: 2
	 */
	protected void _description(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: title
	 * HtmlRow: 4
	 * HtmlCell: 3
	 */
	protected void _title(Wrap<String> w) {
		
	}
 
	/**
	 * {@inheritDoc}
	 * Persist: true
	 * DisplayName: Keywords String
	 * HtmlRow: 5
	 * HtmlCell: 1
	 */
	protected void _keywordsStr(Wrap<String> w) {
		
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * DisplayName: Keywords List
	 * HtmlRow: 5
	 * HtmlCell: 2
	 */
	protected void _keywords(List<String> l) {
		if(keywordsStr != null)
			l.addAll(Arrays.asList(keywordsStr.split(" ")));
	}
	
	/**
	 * {@inheritDoc}
	 * Persist: true
	 * DisplayName: Generated Keywords String
	 * HtmlRow: 5
	 * HtmlCell: 3
	 */
	protected void _generatedKeywordsStr(Wrap<String> w) {
		
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * DisplayName: Generated Keywords List
	 * HtmlRow: 6
	 * HtmlCell: 1
	 */
	protected void _generatedKeywords(List<String> l) {
		if(generatedKeywordsStr != null)
			l.addAll(Arrays.asList(generatedKeywordsStr.split(" ")));
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Language
	 * HtmlRow: 6
	 * HtmlCell: 2
	 */
	protected void _language(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Last Editor ID
	 * HtmlRow: 6
	 * HtmlCell: 3
	 */
	protected void _lastEditorId(Wrap<Long> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Last Edit Date
	 * HtmlRow: 7
	 * HtmlCell: 1
	 */
	protected void _lastEditDate(Wrap<ZonedDateTime> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Curriki License
	 * HtmlRow: 7
	 * HtmlCell: 2
	 */
	protected void _currikiLicense(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: External URL
	 * HtmlRow: 7
	 * HtmlCell: 3
	 */
	protected void _externalUrl(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Resource Checked
	 * HtmlRow: 8
	 * HtmlCell: 1
	 */
	protected void _resourceChecked(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * Stored: true
	 * Persist: true
	 * DisplayName: External URL
	 * HtmlRow: 8
	 * HtmlCell: 2
	 */
	protected void _content(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * Persist: true
	 * DisplayName: Resource Check Request Note
	 * HtmlRow: 8
	 * HtmlCell: 3
	 */
	protected void _resourceCheckRequestNote(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Resource Check Date
	 * HtmlRow: 9
	 * HtmlCell: 1
	 */
	protected void _resourceCheckDate(Wrap<ZonedDateTime> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Resource Check ID
	 * HtmlRow: 9
	 * HtmlCell: 2
	 */
	protected void _resourceCheckId(Wrap<Long> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * Persist: true
	 * DisplayName: Resource Check Note
	 * HtmlRow: 9
	 * HtmlCell: 3
	 */
	protected void _resourceCheckNote(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Student Facing
	 * HtmlRow: 10
	 * HtmlCell: 1
	 */
	protected void _studentFacing(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Source
	 * HtmlRow: 10
	 * HtmlCell: 2
	 */
	protected void _source(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Review Status
	 * HtmlRow: 10
	 * HtmlCell: 3
	 */
	protected void _reviewStatus(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Last Review Date
	 * HtmlRow: 11
	 * HtmlCell: 1
	 */
	protected void _lastReviewDate(Wrap<ZonedDateTime> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Review By ID
	 * HtmlRow: 11
	 * HtmlCell: 2
	 */
	protected void _reviewByID(Wrap<Long> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Review Rating
	 * HtmlRow: 11
	 * HtmlCell: 3
	 */
	protected void _reviewRating(Wrap<BigDecimal> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Technical Completeness
	 * HtmlRow: 12
	 * HtmlCell: 1
	 */
	protected void _technicalCompleteness(Wrap<Integer> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Content Accuracy
	 * HtmlRow: 12
	 * HtmlCell: 2
	 */
	protected void _contentAccuracy(Wrap<Integer> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Pedagogy
	 * HtmlRow: 12
	 * HtmlCell: 3
	 */
	protected void _pedagogy(Wrap<Integer> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * Stored: true
	 * Persist: true
	 * DisplayName: Rating Comment
	 * HtmlRow: 13
	 * HtmlCell: 1
	 */
	protected void _ratingComment(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Standards Alignment
	 * HtmlRow: 13
	 * HtmlCell: 2
	 */
	protected void _standardsAlignment(Wrap<Integer> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Standards Alignment Comment
	 * HtmlRow: 13
	 * HtmlCell: 3
	 */
	protected void _standardsAlignmentComment(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Subject Matter
	 * HtmlRow: 14
	 * HtmlCell: 1
	 */
	protected void _subjectMatter(Wrap<Integer> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Subject Matter Comment
	 * HtmlRow: 14
	 * HtmlCell: 2
	 */
	protected void _subjectMatterComment(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Supports Teaching
	 * HtmlRow: 14
	 * HtmlCell: 3
	 */
	protected void _supportsTeaching(Wrap<Integer> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Supports Teaching Comment
	 * HtmlRow: 15
	 * HtmlCell: 1
	 */
	protected void _supportsTeachingComment(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Assessments Quality
	 * HtmlRow: 15
	 * HtmlCell: 2
	 */
	protected void _assessmentsQuality(Wrap<Integer> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Assessments Quality Comment
	 * HtmlRow: 15
	 * HtmlCell: 3
	 */
	protected void _assessmentsQualityComment(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Interactivity Quality
	 * HtmlRow: 16
	 * HtmlCell: 1
	 */
	protected void _interactivityQuality(Wrap<Integer> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Interactivity Quality Comment
	 * HtmlRow: 16
	 * HtmlCell: 2
	 */
	protected void _interactivityQualityComment(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Instructional Quality
	 * HtmlRow: 16
	 * HtmlCell: 3
	 */
	protected void _instructionalQuality(Wrap<Integer> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Instructional Quality Comment
	 * HtmlRow: 17
	 * HtmlCell: 1
	 */
	protected void _instructionalQualityComment(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Deeper Learning
	 * HtmlRow: 17
	 * HtmlCell: 2
	 */
	protected void _deeperLearning(Wrap<Integer> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Deeper Learning Comment
	 * HtmlRow: 17
	 * HtmlCell: 3
	 */
	protected void _deeperLearningComment(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Partner
	 * HtmlRow: 18
	 * HtmlCell: 1
	 */
	protected void _partner(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Create Date
	 * HtmlRow: 18
	 * HtmlCell: 2
	 */
	protected void _createDate(Wrap<ZonedDateTime> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Type
	 * HtmlRow: 18
	 * HtmlCell: 3
	 */
	protected void _type(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Featured
	 * HtmlRow: 19
	 * HtmlCell: 1
	 */
	protected void _featured(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Page
	 * HtmlRow: 19
	 * HtmlCell: 2
	 */
	protected void _page(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Active
	 * HtmlRow: 19
	 * HtmlCell: 3
	 */
	protected void _active(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Public
	 * HtmlRow: 20
	 * HtmlCell: 1
	 */
	protected void _Public(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: xwd ID
	 * HtmlRow: 20
	 * HtmlCell: 2
	 */
	protected void _xwd_id(Wrap<Integer> w) {
		
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Media Type
	 * HtmlRow: 20
	 * HtmlCell: 3
	 */
	protected void _mediaType(Wrap<String> w) {
		
	}
	 
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Access
	 * HtmlRow: 21
	 * HtmlCell: 1
	 */
	protected void _access(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Member Rating
	 * HtmlRow: 21
	 * HtmlCell: 2
	 */
	protected void _memberRating(Wrap<BigDecimal> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Aligned
	 * HtmlRow: 21
	 * HtmlCell: 3
	 */
	protected void _aligned(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Page URL
	 * HtmlRow: 22
	 * HtmlCell: 1
	 */
	protected void _pageUrl(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Indexed
	 * HtmlRow: 22
	 * HtmlCell: 2
	 */
	protected void _indexed(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Last Index Date
	 * HtmlRow: 22
	 * HtmlCell: 3
	 */
	protected void _lastIndexDate(Wrap<ZonedDateTime> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Index Required
	 * HtmlRow: 23
	 * HtmlCell: 1
	 */
	protected void _indexRequired(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: IndexRequiredDate
	 * HtmlRow: 23
	 * HtmlCell: 2
	 */
	protected void _indexRequiredDate(Wrap<ZonedDateTime> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: rescrape
	 * HtmlRow: 24
	 * HtmlCell: 3
	 */
	protected void _rescrape(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Go Button
	 * HtmlRow: 25
	 * HtmlCell: 1
	 */
	protected void _goButton(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Download Button
	 * HtmlRow: 25
	 * HtmlCell: 2
	 */
	protected void _downloadButton(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Top of Search
	 * HtmlRow: 25
	 * HtmlCell: 3
	 */
	protected void _topOfSearch(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Remove
	 * HtmlRow: 26
	 * HtmlCell: 1
	 */
	protected void _remove(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Spam
	 * HtmlRow: 26
	 * HtmlCell: 2
	 */
	protected void _spam(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Top of search int
	 * HtmlRow: 26
	 * HtmlCell: 3
	 */
	protected void _topOfSearchInt(Wrap<Integer> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Partner Int
	 * HtmlRow: 27
	 * HtmlCell: 1
	 */
	protected void _partnerInt(Wrap<Integer> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Review Resource
	 * HtmlRow: 27
	 * HtmlCell: 2
	 */
	protected void _reviewResource(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Old URL
	 * HtmlRow: 27
	 * HtmlCell: 3
	 */
	protected void _oldUrl(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Content Display OK
	 * HtmlRow: 28
	 * HtmlCell: 1
	 */
	protected void _contentDisplayOk(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Metadata
	 * HtmlRow: 28
	 * HtmlCell: 2
	 */
	protected void _metadata(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Approval Status
	 * HtmlRow: 28
	 * HtmlCell: 3
	 */
	protected void _approvalStatus(Wrap<String> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Approval Status Date
	 * HtmlRow: 29
	 * HtmlCell: 1
	 */
	protected void _approvalStatusDate(Wrap<ZonedDateTime> w) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Spam User
	 * HtmlRow: 29
	 * HtmlCell: 2
	 */
	protected void _spamUser(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: URL
	 * HtmlRow: 30
	 * HtmlCell: 1
	 */
	protected void _url(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Display Sequence Number
	 * HtmlRow: 30
	 * HtmlCell: 2
	 */
	protected void _displaySeqNo(Wrap<Integer> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: File ID
	 * HtmlRow: 30
	 * HtmlCell: 3
	 */
	protected void _fileId(Wrap<Integer> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Filename
	 * HtmlRow: 31
	 * HtmlCell: 1
	 */
	protected void _fileName(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Upload Date
	 * HtmlRow: 31
	 * HtmlCell: 2
	 */
	protected void _uploadDate(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Sequence
	 * HtmlRow: 31
	 * HtmlCell: 3
	 */
	protected void _sequence(Wrap<Integer> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Unique Name
	 * HtmlRow: 32
	 * HtmlCell: 1
	 */
	protected void _uniqueName(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Ext
	 * HtmlRow: 32
	 * HtmlCell: 2
	 */
	protected void _ext(Wrap<String> w) {
	}
	
//	/**
//	 * {@inheritDoc}
//	 * DocValues: true
//	 * Persist: true
//	 * DisplayName: Active
//	 * HtmlRow: 32
//	 * HtmlCell: 3
//	 */
//	protected void _active(Wrap<String> w) {
//	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Tempactive
	 * HtmlRow: 33
	 * HtmlCell: 1
	 */
	protected void _tempactive(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: S3 Path
	 * HtmlRow: 33
	 * HtmlCell: 2
	 */
	protected void _s3path(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: SDF Status
	 * HtmlRow: 33
	 * HtmlCell: 3
	 */
	protected void _sdfStatus(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Transcoded
	 * HtmlRow: 34
	 * HtmlCell: 1
	 */
	protected void _transcoded(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Lodestar
	 * HtmlRow: 34
	 * HtmlCell: 2
	 */
	protected void _lodestar(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Archive
	 * HtmlRow: 34
	 * HtmlCell: 3
	 */
	protected void _archive(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Identifier
	 * HtmlRow: 35
	 * HtmlCell: 1
	 */
	protected void _identifier(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Display Name
	 * HtmlRow: 35
	 * HtmlCell: 2
	 */
	protected void _displayName(Wrap<String> w) {
	}
	
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Subject Area
	 * HtmlRow: 35
	 * HtmlCell: 3
	 */
	protected void _subjectArea(Wrap<String> w) {
	}
	
//	/**
//	 * {@inheritDoc}
//	 * DocValues: true
//	 * Persist: true
//	 * DisplayName: Display Name
//	 * HtmlRow: 30
//	 * HtmlCell: 3
//	 */
//	protected void _displayName(Wrap<Integer> w) {
//	}
	
//	/**
//	 * {@inheritDoc}
//	 * DocValues: true
//	 * Persist: true
//	 * DisplayName: Display Name
//	 * HtmlRow: 30
//	 * HtmlCell: 3
//	 */
//	protected void _displayName(Wrap<Integer> w) {
//	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: Name
	 * HtmlRow: 36
	 * HtmlCell: 1
	 */
	protected void _name(Wrap<String> w) {
	}

//	+ " rl.url, rl.displayseqno, rf.fileid, rf.filename, rf.uploaddate, rf.sequence, rf.uniquename,"
//	+ " rf.ext, rf.active, rf.tempactive, rf.s3path, rf.SDFstatus, rf.transcoded, rf.lodestar,"
//	+ " rf.archive, edu.identifier, edu.displayname, sub.subjectarea, sub.displayname, inst.displayname, inst.name"
	
	@Override
	public String toString() {
		return String.format("%s: %s", title, description);
	}

}
