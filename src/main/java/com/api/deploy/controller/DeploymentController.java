package com.api.deploy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.api.deploy.model.ApiDetailResponse;
import com.api.deploy.service.GetDetailAPI;
import com.api.deploy.service.GetListAPI;
import com.api.deploy.service.PostDeployAPI;
import com.api.deploy.util.UtilFunction;

@Controller
public class DeploymentController {

	private ParameterController controller;
	private PostDeployAPI deploy;
	private GetDetailAPI api;
	private GetListAPI listAPIService;
	private UtilFunction util;
	
	public int offset = 0;
	
	@GetMapping("/api/deploy/{id}")
	public ModelAndView Deploy(@PathVariable String id) {
		ModelAndView modelAndView = new ModelAndView();
		api = new GetDetailAPI();
		deploy = new PostDeployAPI();

		String payload = api.GetDetailAPIs(controller.Token_Source, id);
		deploy.DeploymentAPI(controller.Token_Target, payload);
		modelAndView.setViewName("redirect:/deploymentview");
		return modelAndView;
	}
	
	@GetMapping("/deploymentview")
	public ModelAndView ListDeployments(ModelAndView modelAndView) {
		controller = new ParameterController();
		listAPIService = new GetListAPI();
		util = new UtilFunction();

		List<ApiDetailResponse> api_data_set = new ArrayList<>();
		api_data_set = util.CompareAPISetStatus(
				util.ConvertToList(listAPIService.GetListApiSource(controller.Token_Source, offset)),
				util.ConvertToList(listAPIService.GetListApiTarget(controller.Token_Target)));
		modelAndView.addObject("productList", api_data_set);
		modelAndView.addObject("source", controller.Portal_Source);
		modelAndView.addObject("target", controller.Portal_Target);
		modelAndView.setViewName("ListDeployment");
		return modelAndView;
	}
	
	@GetMapping("/setOffset/deploy")
	public String SetOffsetToZeroDeploy() {
		offset = 0;
		return "redirect:/deploymentview";
	}

	@GetMapping("/api/offset/deploy/{trigger}")
	public String TriggerDeploy(@PathVariable String trigger) {
//		System.out.print("Access to trigger!!");
		if (trigger.equalsIgnoreCase("plus")) {
			offset += 25;
		} else if (trigger.equalsIgnoreCase("minus"))
			offset -= 25;
		else
			offset = 0;
		return "redirect:/deploymentview";
	}
}
