package com.api.deploy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ApiModelH2")
public class ApiModelH2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer num;
	@Column(length = 100000)
	private String name;
	private String version;
	private String provider;
	private String status;
	@Column(length = 100000)
	private String productionEndpoint;
	@Column(length = 100000)
	private String sandboxEndpoint;
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
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
	public String getProductionEndpoint() {
		return productionEndpoint;
	}
	public void setProductionEndpoint(String productionEndpoint) {
		this.productionEndpoint = productionEndpoint;
	}
	public String getSandboxEndpoint() {
		return sandboxEndpoint;
	}
	public void setSandboxEndpoint(String sandboxEndpoint) {
		this.sandboxEndpoint = sandboxEndpoint;
	}
	@Override
	public String toString() {
		return "ApiModelH2 [num=" + num + ", name=" + name + ", version=" + version + ", provider=" + provider
				+ ", status=" + status + ", productionEndpoint=" + productionEndpoint + ", sandboxEndpoint="
				+ sandboxEndpoint + "]";
	}
}
