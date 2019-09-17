package com.api.deploy.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.api.deploy.controller.ParameterController;
import com.api.deploy.model.AuthenParameter;
import com.api.deploy.model.TokenResponse;

public class GetToken {
		private ParameterController param = new ParameterController();
		
	public String GetTokenSource(AuthenParameter Authenparam) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic "+Authenparam.getAuthorization_source());

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type","password");
		map.add("username",Authenparam.getUsername_source());
		map.add("password",Authenparam.getPassword_source());
		map.add("scope","apim:api_create apim:api_view");
		
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<TokenResponse> response = restTemplate.exchange(param.Gateway_Source+"/token",HttpMethod.POST,entity, TokenResponse.class);
		TokenResponse resTokenDEV = response.getBody();
		System.out.println("The token source is : "+resTokenDEV.getAccess_token());
		return  resTokenDEV.getAccess_token();
	}

	public String GetTokenTarget(AuthenParameter Authenparam) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic "+Authenparam.getAuthorization_target());

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type","password");
		map.add("username",Authenparam.getUsername_target());
		map.add("password",Authenparam.getPassword_target());
		map.add("scope","apim:api_create apim:api_view");
		
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<TokenResponse> response = restTemplate.exchange(param.Gateway_Target+"/token",HttpMethod.POST,entity, TokenResponse.class);
		TokenResponse resTokenPRD = response.getBody();
		System.out.println("The token target is : "+resTokenPRD.getAccess_token());
		return  resTokenPRD.getAccess_token();
	}
}
