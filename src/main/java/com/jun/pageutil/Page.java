package com.jun.pageutil;

public class Page {
	//总页数
	private Long totalPageSum;
	//第几页
	private Integer pageIndex;
	//总记录数
	private Long totalRecordSum;
	
	public Long getTotalPageSum() {
		return totalPageSum;
	}
	public void setTotalPageSum(Long totalPageSum) {
		this.totalPageSum = totalPageSum;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Long getTotalRecordSum() {
		return totalRecordSum;
	}
	public void setTotalRecordSum(Long totalRecordSum) {
		this.totalRecordSum = totalRecordSum;
	}
	
}
