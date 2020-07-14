package com.migration.web.model;

import java.util.List;

public class Apps {

	private String name;
	private int instance;
	private int quota;
	private int runningInstance;
	private String state;
	private List<String> envs;
	private List<String> routes;
	private List<String> services;

	public Apps() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInstance() {
		return instance;
	}

	public void setInstance(int instance) {
		this.instance = instance;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public int getRunningInstance() {
		return runningInstance;
	}

	public void setRunningInstance(int runningInstance) {
		this.runningInstance = runningInstance;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<String> getEnvs() {
		return envs;
	}

	public void setEnvs(List<String> envs) {
		this.envs = envs;
	}

	public List<String> getRoutes() {
		return routes;
	}

	public void setRoutes(List<String> routes) {
		this.routes = routes;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}

}
