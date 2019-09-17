package com.api.deploy.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.api.deploy.model.ApiListResponse;
import com.api.deploy.controller.ParameterController;

public class GetListAPI {
	private ParameterController param = new ParameterController();
	private GetPagination pagin = new GetPagination();
	
	public ApiListResponse GetListApiSource(String token,int offset) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Bearer "+token);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		System.out.println("The Souce token is : "+token);
		
		ResponseEntity<ApiListResponse> response = restTemplate.exchange(param.Portal_Source+"/api/am/publisher/v0.14/apis?offset="+offset,HttpMethod.GET,entity, ApiListResponse.class);
		ApiListResponse list = response.getBody();
		return list;
	}
	
	public ApiListResponse GetListApiTarget(String token) {
		RestTemplate restTemplate = new RestTemplate();
		String numberOfAPI = pagin.Pagination(token,param.Portal_Target);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Bearer "+token);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<ApiListResponse> response = restTemplate.exchange(param.Portal_Target+"/api/am/publisher/v0.14/apis?limit="+numberOfAPI,HttpMethod.GET,entity, ApiListResponse.class);
		ApiListResponse list = response.getBody();
		return list;	
	}
}
