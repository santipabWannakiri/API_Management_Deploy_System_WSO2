package com.api.deploy.model;

public class ApiDetailResponse {
	private String id;
	private String name;
	private String description;
	private String status;
	private String targetApiID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTargetApiID() {
		return targetApiID;
	}

	public void setTargetApiID(String targetApiID) {
		this.targetApiID = targetApiID;
	}

	@Override
	public String toString() {
		return "ApiDetailResponse [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", targetApiID=" + targetApiID + "]";
	}

}
