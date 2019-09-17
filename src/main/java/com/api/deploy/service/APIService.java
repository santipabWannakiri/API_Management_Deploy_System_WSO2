package com.api.deploy.service;

import com.api.deploy.model.ApiModelH2;

public interface APIService {
	public void Save(ApiModelH2 api);
	public Iterable<ApiModelH2> findAll();

}
