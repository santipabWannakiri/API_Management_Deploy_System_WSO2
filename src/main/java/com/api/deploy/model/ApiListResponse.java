package com.api.deploy.model;

import java.util.List;

public class ApiListResponse {

	private List<ApiListSubResponse> list;

	public List<ApiListSubResponse> getList() {
		return list;
	}

	public void setList(List<ApiListSubResponse> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ResponseRootAPI [list=" + list + "]";
	}

}
