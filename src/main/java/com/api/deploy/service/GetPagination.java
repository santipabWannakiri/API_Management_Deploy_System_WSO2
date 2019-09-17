package com.api.deploy.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.api.deploy.model.PaginationResponse;

public class GetPagination {

	public String Pagination(String token,String portalURL) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Bearer " + token);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		ResponseEntity<PaginationResponse> response = restTemplate.exchange(portalURL + "/api/am/publisher/v0.14/apis", HttpMethod.GET, entity, PaginationResponse.class);
		return response.getBody().getPagination().getTotal();
	}
}
