package com.api.deploy.model;

public class PaginationSubResponse {
	
	private String total;
	private String offset;
	private String limit;
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getOffset() {
		return offset;
	}
	public void setOffset(String offset) {
		this.offset = offset;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	@Override
	public String toString() {
		return "ResponsePagination [total=" + total + ", offset=" + offset + ", limit=" + limit + "]";
	}
	
}
