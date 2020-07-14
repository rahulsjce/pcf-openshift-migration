package com.migration.web.service;

import java.util.List;

import com.migration.web.model.Apps;
import com.migration.web.model.PcftoOpenshiftRecords;

public interface ApplicationService {

	String helloWorld();

	String getAllApps();

	List<Apps> getApps();
	
	String getAppDetails(String guid);

	List<PcftoOpenshiftRecords> getSummaryPage();

}
