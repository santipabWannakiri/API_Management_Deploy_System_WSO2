package com.api.deploy.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.api.deploy.controller.ParameterController;

public class PostDeployAPI {
	private ParameterController param = new ParameterController();
	
	public String DeploymentAPI(String token,String payload) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Authorization", "Bearer "+token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(payload, headers);
		
		try {
		ResponseEntity<String> response = restTemplate.exchange(param.Portal_Target+"/api/am/publisher/v0.14/apis",HttpMethod.POST,entity, String.class);
		String resDetailAPI = response.getBody();
		System.out.println("Deployed : "+resDetailAPI);
		return resDetailAPI;
		}catch(HttpClientErrorException e){
			byte[] tempBody = e.getResponseBodyAsByteArray();
			String status = new String(tempBody);
			System.out.println(status);
			throw e;
		}
	}
}
