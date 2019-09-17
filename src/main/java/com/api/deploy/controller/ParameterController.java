package com.api.deploy.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.api.deploy.model.AuthenParameter;
import com.api.deploy.service.GetToken;

@Controller
public class ParameterController {
	public static String Gateway_Source;
	public static String Portal_Source;
	public static String Token_Source;
	
	public static String Gateway_Target;
	public static String Portal_Target;
	public static String Token_Target;
	
	private GetToken tokenService;
	private DeploymentController deployInfo;
	private UpdateController updateInfo;
	
	@PostMapping("/saveDeploy")
	public String GetAuthenParameterDeployment(@Valid @ModelAttribute("AuthParam") AuthenParameter AuthParam) {
		tokenService = new GetToken();
		deployInfo = new DeploymentController();
		deployInfo.offset=0;
//		----Set Parameter Source----
		Gateway_Source=AuthParam.getGateway_uri_source();
		Portal_Source=AuthParam.getPortal_uri_source();
		Token_Source=tokenService.GetTokenSource(AuthParam);
//		----Set Parameter Target----
		Gateway_Target=AuthParam.getGateway_uri_target();
		Portal_Target=AuthParam.getPortal_uri_target();
		Token_Target=tokenService.GetTokenTarget(AuthParam);
		return "redirect:/setOffset/deploy";
	}
	
	@PostMapping("/saveUpdate")
	public String GetAuthenParameterUpdate(@Valid @ModelAttribute("AuthParam") AuthenParameter AuthParam) {
		tokenService = new GetToken();
		updateInfo = new UpdateController();
		updateInfo.offset=0;
//		----Set Parameter Source----
		Gateway_Source=AuthParam.getGateway_uri_source();
		Portal_Source=AuthParam.getPortal_uri_source();
		Token_Source=tokenService.GetTokenSource(AuthParam);
//		----Set Parameter Target----
		Gateway_Target=AuthParam.getGateway_uri_target();
		Portal_Target=AuthParam.getPortal_uri_target();
		Token_Target=tokenService.GetTokenTarget(AuthParam);
		return "redirect:/setOffset/update";
	}
	
	@PostMapping("/saveEndpoint")
	public String GetAuthenParameterEndpoint(@Valid @ModelAttribute("AuthParam") AuthenParameter AuthParam) {
		tokenService = new GetToken();
//		----Set Parameter Source----
		Gateway_Source=AuthParam.getGateway_uri_source();
		Portal_Source=AuthParam.getPortal_uri_source();
		Token_Source=tokenService.GetTokenSource(AuthParam);
		return "redirect:/endpointLogic";
	}
	
}


