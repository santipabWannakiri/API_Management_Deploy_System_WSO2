package com.api.deploy.model;

public class ApiModelResponseH2 {
	private String name;
	private String version;
	private String provider; 
	private String status;
	private String endpointConfig;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEndpointConfig() {
		return endpointConfig;
	}
	public void setEndpointConfig(String endpointConfig) {
		this.endpointConfig = endpointConfig;
	}
	@Override
	public String toString() {
		return "ResponsePrepare_H2 [name=" + name + ", version=" + version + ", provider=" + provider + ", status="
				+ status + ", endpointConfig=" + endpointConfig + "]";
	}
	
	
	
}
