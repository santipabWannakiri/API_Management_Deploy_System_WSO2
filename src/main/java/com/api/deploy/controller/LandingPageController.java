package com.api.deploy.controller;

import java.security.KeyManagementException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.api.deploy.model.AuthenParameter;
import com.api.deploy.util.SSLUtil;

@Controller
public class LandingPageController {
	
	@GetMapping("/home")
	public String IndexHtml() throws KeyManagementException, Exception {
		SSLUtil.turnOffSslChecking();
		return "LandingPage";
	}
	
	@GetMapping("/deploymentForm")
	public String DeploymentInfo(@ModelAttribute("AuthParam") AuthenParameter AuthParam)  {
		return "DeploymentInfo";
	}
	
	@GetMapping("/updateForm")
	public String UpdateInfo(@ModelAttribute("AuthParam") AuthenParameter AuthParam)  {
		return "UpdateInfo";
	}
	
	@GetMapping("/endpointForm")
	public String EndpointInfo(@ModelAttribute("AuthParam") AuthenParameter AuthParam)  {
		return "EndpointInfo";
	}
}
