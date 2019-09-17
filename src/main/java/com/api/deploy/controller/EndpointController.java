package com.api.deploy.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.api.deploy.model.ApiModelH2;
import com.api.deploy.model.ApiModelResponseH2;
import com.api.deploy.service.APIService;
import com.api.deploy.service.GetDetailEndpoint;
import com.api.deploy.service.GetListIDEndpoint;
import com.api.deploy.util.ConvertJsonObject;
import com.api.deploy.util.H2jdbcTruncate;
import com.api.deploy.util.UtilFunction;

@Controller
public class EndpointController {
	private ParameterController controller;
	private GetListIDEndpoint endpoint;
	private GetDetailEndpoint h2;
	private ConvertJsonObject json;
	private UtilFunction util;
	private H2jdbcTruncate jdbc;
	@Autowired
	private APIService saveh2;

	@GetMapping("/endpointLogic")
	public String Endpoint( ){
		controller = new ParameterController();
		endpoint = new GetListIDEndpoint();
		h2 = new GetDetailEndpoint();
		json = new ConvertJsonObject();
		util = new UtilFunction();
		jdbc = new H2jdbcTruncate();
		jdbc.TruncateTable();
		List<String> Set_ID_API = new ArrayList<String>();
		List<ApiModelResponseH2> Set_Detail = new ArrayList<ApiModelResponseH2>();
		Set_ID_API = endpoint.List_id_api(controller.Token_Source, controller.Portal_Source);
		Set_Detail = h2.GetDetailandSave(controller.Token_Source, controller.Portal_Source, Set_ID_API);

		for (int i = 0; i < Set_Detail.size(); i++) {
			ApiModelH2 temp = new ApiModelH2();

			temp.setName(util.IsNullandReplaceString(Set_Detail.get(i).getName()));
			temp.setVersion(util.IsNullandReplaceString(Set_Detail.get(i).getVersion()));
			temp.setStatus(util.IsNullandReplaceString(Set_Detail.get(i).getStatus()));
			temp.setProvider(util.IsNullandReplaceString(Set_Detail.get(i).getProvider()));
			
			String tempProduction = json.Production(util.IsNullandReplaceString(Set_Detail.get(i).getEndpointConfig()).replace("/", "|")
					.replace("https:", "https.").replace("http:", "http."));
			String tempSandbox = json.Sandbox(util.IsNullandReplaceString(Set_Detail.get(i).getEndpointConfig()).replace("/", "|")
					.replace("https:", "https.").replace("http:", "http."));
			temp.setProductionEndpoint(tempProduction.replace("|", "/").replace("https.", "https:").replace("http.", "http:"));
			temp.setSandboxEndpoint(tempSandbox.replace("|", "/").replace("https.", "https:").replace("http.", "http:"));
			saveh2.Save(temp);
		}
		return "redirect:/endpoint";
	}
	
	@GetMapping("/endpoint")
	public ModelAndView DataEX(ModelAndView modelAndView) {
		modelAndView.addObject("productList", saveh2.findAll());
		modelAndView.setViewName("ListEnpoint");
		return modelAndView;	
	}
}
