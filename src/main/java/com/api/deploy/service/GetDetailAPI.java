package com.api.deploy.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.api.deploy.controller.ParameterController;



public class GetDetailAPI {
	private ParameterController param = new ParameterController();
		
	public String GetDetailAPIs(String token,String apiID) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Authorization", "Bearer "+token);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		String GetDetailURL=param.Portal_Source+"/api/am/publisher/v0.14/apis/"+apiID;
		ResponseEntity<String> response = restTemplate.exchange(GetDetailURL,HttpMethod.GET,entity, String.class);
		String resDetailAPI = response.getBody();
		return resDetailAPI;
	}
}
