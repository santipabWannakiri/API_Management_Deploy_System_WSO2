package com.api.deploy.model;

public class AuthenParameter {
	// Source Parameter
	private String gateway_uri_source;
	private String portal_uri_source;
	private String authorization_source;
	private String username_source;
	private String password_source;

	// Target Parameter
	private String gateway_uri_target;
	private String portal_uri_target;
	private String authorization_target;
	private String username_target;
	private String password_target;

	public String getGateway_uri_source() {
		return gateway_uri_source;
	}

	public void setGateway_uri_source(String gateway_uri_source) {
		this.gateway_uri_source = gateway_uri_source;
	}

	public String getPortal_uri_source() {
		return portal_uri_source;
	}

	public void setPortal_uri_source(String portal_uri_source) {
		this.portal_uri_source = portal_uri_source;
	}

	public String getAuthorization_source() {
		return authorization_source;
	}

	public void setAuthorization_source(String authorization_source) {
		this.authorization_source = authorization_source;
	}

	public String getUsername_source() {
		return username_source;
	}

	public void setUsername_source(String username_source) {
		this.username_source = username_source;
	}

	public String getPassword_source() {
		return password_source;
	}

	public void setPassword_source(String password_source) {
		this.password_source = password_source;
	}

	public String getGateway_uri_target() {
		return gateway_uri_target;
	}

	public void setGateway_uri_target(String gateway_uri_target) {
		this.gateway_uri_target = gateway_uri_target;
	}

	public String getPortal_uri_target() {
		return portal_uri_target;
	}

	public void setPortal_uri_target(String portal_uri_target) {
		this.portal_uri_target = portal_uri_target;
	}

	public String getAuthorization_target() {
		return authorization_target;
	}

	public void setAuthorization_target(String authorization_target) {
		this.authorization_target = authorization_target;
	}

	public String getUsername_target() {
		return username_target;
	}

	public void setUsername_target(String username_target) {
		this.username_target = username_target;
	}

	public String getPassword_target() {
		return password_target;
	}

	public void setPassword_target(String password_target) {
		this.password_target = password_target;
	}

	@Override
	public String toString() {
		return "AuthenParameter [gateway_uri_source=" + gateway_uri_source + ", portal_uri_source=" + portal_uri_source
				+ ", authorization_source=" + authorization_source + ", username_source=" + username_source
				+ ", password_source=" + password_source + ", gateway_uri_target=" + gateway_uri_target
				+ ", portal_uri_target=" + portal_uri_target + ", authorization_target=" + authorization_target
				+ ", username_target=" + username_target + ", password_target=" + password_target + "]";
	}

}
