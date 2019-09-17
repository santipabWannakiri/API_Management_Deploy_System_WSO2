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
import com.api.deploy.model.ApiModelResponseH2;

public class GetDetailEndpoint {

	public List<ApiModelResponseH2> GetDetailandSave(String token, String portalURL, List<String> setID) {
			
		List<ApiModelResponseH2> setDetail = new ArrayList<ApiModelResponseH2>();
		
		for (int i = 0; i < setID.size(); i++) {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers.add("Authorization", "Bearer " + token);
			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);

			String URL = portalURL + "/api/am/publisher/v0.14/apis/" + setID.get(i);
			ResponseEntity<ApiModelResponseH2> response = restTemplate.exchange(URL, HttpMethod.GET, entity,ApiModelResponseH2.class);
			ApiModelResponseH2 detail = response.getBody();
			setDetail.add(detail);
			}
		return setDetail;
	}
}