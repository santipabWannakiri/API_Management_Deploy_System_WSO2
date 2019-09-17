package com.api.deploy.model;

public class PaginationResponse {

	private PaginationSubResponse pagination;

	public PaginationSubResponse getPagination() {
		return pagination;
	}

	public void setPagination(PaginationSubResponse pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "ResponsePagination [pagination=" + pagination + "]";
	}

}
