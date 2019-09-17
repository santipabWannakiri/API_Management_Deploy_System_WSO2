package com.api.deploy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.api.deploy.model.ApiListResponse;

public class GetListIDEndpoint {
	 private GetPagination pageing ;
	
	public List<String> List_id_api(String token,String portalURL){
		RestTemplate restTemplate = new RestTemplate();
		pageing = new GetPagination();
		List<String> set_id_api = new ArrayList<String>();
		String numberOfAPI = pageing.Pagination(token, portalURL);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Bearer "+token);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		String URL= portalURL+"/api/am/publisher/v0.14/apis/?limit="+numberOfAPI;
		ResponseEntity<ApiListResponse> response = restTemplate.exchange(URL,HttpMethod.GET,entity, ApiListResponse.class);
		ApiListResponse dataSet = response.getBody();
		
		for(int i=0; i<dataSet.getList().size(); i++) {
			set_id_api.add(dataSet.getList().get(i).getId());
		}
		return set_id_api;
	}
}
