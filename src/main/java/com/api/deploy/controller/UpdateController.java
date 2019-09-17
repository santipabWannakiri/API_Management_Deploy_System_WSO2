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
import com.api.deploy.service.PutUpdateAPI;
import com.api.deploy.util.UtilFunction;

@Controller
public class UpdateController {
	private ParameterController controller;
	private GetListAPI listAPIService;
	private UtilFunction util;
	private PutUpdateAPI update;
	private GetDetailAPI api;
	
	public int offset = 0;
	
	
	@GetMapping("/api/update/{srcId}/{name}/{tarId}")
	public ModelAndView Deploy(@PathVariable String srcId,@PathVariable String name,@PathVariable String tarId) {
		ModelAndView modelAndView = new ModelAndView();
		api = new GetDetailAPI();
		update = new PutUpdateAPI();

		System.out.println("Check srcID "+srcId);
		System.out.println("Check name "+name);
		System.out.println("Check tarID "+tarId);
		String payload = api.GetDetailAPIs(controller.Token_Source, srcId);
		update.UpdateAPI(controller.Token_Target, payload, tarId);
		modelAndView.setViewName("redirect:/updateView");
		return modelAndView;
	}

	@GetMapping("/updateView")
	public ModelAndView ListUpdate(ModelAndView modelAndView) {
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
		modelAndView.setViewName("ListUpdate");
		return modelAndView;
	}
	
	@GetMapping("/setOffset/update")
	public String SetOffsetToZeroUpate() {
		offset = 0;
		return "redirect:/updateView";
	}

	@GetMapping("/api/offset/update/{trigger}")
	public String TriggerUpdate(@PathVariable String trigger) {
		if (trigger.equalsIgnoreCase("plus")) {
			offset += 25;
		} else if (trigger.equalsIgnoreCase("minus"))
			offset -= 25;
		else
			offset = 0;
		return "redirect:/updateView";
	}
}
