package org.curriki.api.enus.vertx;  

/**
 * Keyword: classSimpleNameApiCounter
 * Map.hackathonMission: to create a new Java class to count the number of API requests are currently being made at the same time for fine tuning memory performance for bulk operations. 
 * Map.hackathonColumn: Develop Base Classes
 * Map.hackathonLabels: Java
 */
public class ApiCounter {

	public ApiCounter() {
		totalNum = 0L;
		queueNum = 0L;
	}

	private Long totalNum;

	public Long getTotalNum() {
		return totalNum;
	}

	public void incrementTotalNum(Long num) {
		this.totalNum+=num;
	}

	public void incrementTotalNum() {
		this.totalNum++;
	}

	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}

	private Long queueNum;

	public Long getQueueNum() {
		return queueNum;
	}

	public void incrementQueueNum(Long num) {
		this.queueNum+=num;
	}

	public void incrementQueueNum() {
		this.queueNum++;
	}

	public void decrementQueueNum() {
		this.queueNum--;
	}

	public void setQueueNum(Long countNum) {
		this.queueNum = countNum;
	}






	private Long totalNumOld;

	public Long getTotalNumOld() {
		return totalNumOld;
	}

	public void setTotalNumOld(Long totalNumOld) {
		this.totalNumOld = totalNumOld;
	}

	private Long queueNumOld;

	public Long getQueueNumOld() {
		return queueNumOld;
	}

	public void setQueueNumOld(Long countNumOld) {
		this.queueNumOld = countNumOld;
	}
}
