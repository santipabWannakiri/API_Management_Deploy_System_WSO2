package com.api.deploy.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.deploy.model.ApiModelH2;
import com.api.deploy.repository.APIRepository;
import com.api.deploy.service.APIService;

@Service("APIService")
public class APIServiceImp implements APIService {

	@Autowired
	private APIRepository apirepo;
	
	@Override
	public void Save(ApiModelH2 api) {
		api.setName(api.getName());
		api.setProvider(api.getProvider());
		api.setVersion(api.getVersion());
		api.setStatus(api.getStatus());
		api.setProductionEndpoint(api.getProductionEndpoint());
		api.setSandboxEndpoint(api.getSandboxEndpoint());
		apirepo.save(api);
	}

	@Override
	public Iterable<ApiModelH2> findAll() {
		Iterable<ApiModelH2> temp = apirepo.findAll(); 
		return temp;
	}
}
