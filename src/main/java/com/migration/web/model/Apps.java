package com.migration.web.model;

import java.util.List;

public class Apps {

	private String name;
	private String state;
	private List<String> buildpacks;
	private List<String> routes;
	
	
		
	public Apps() {
		super();
	}


	public Apps(String name, String state, List<String> buildpacks, List<String> routes) {
		super();
		this.name = name;
		this.state = state;
		this.buildpacks = buildpacks;
		this.routes = routes;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<String> getBuildpacks() {
		return buildpacks;
	}
	public void setBuildpacks(List<String> buildpacks) {
		this.buildpacks = buildpacks;
	}
	public List<String> getRoutes() {
		return routes;
	}
	public void setRoutes(List<String> routes) {
		this.routes = routes;
	}
	
}
