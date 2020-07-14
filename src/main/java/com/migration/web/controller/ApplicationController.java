package com.migration.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.migration.web.model.Apps;
import com.migration.web.model.PcftoOpenshiftRecords;
import com.migration.web.service.ApplicationService;

@RestController
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return applicationService.helloWorld();
	}
	
	@GetMapping("/apps")
	public String getAllApps() {
		return applicationService.getAllApps();
	}
	
	@GetMapping("/allApps")
	public List<Apps> getApps() {
		return applicationService.getApps();
	}
	
	@GetMapping("/apps/{guid}")
	public String getAppDetails(@PathVariable String guid) {
		return applicationService.getAppDetails(guid);
	}
	
	
	@GetMapping(value = "/pageSummary")
	public List<PcftoOpenshiftRecords> getSummaryPage() {
		return applicationService.getSummaryPage();
	}
}
