package com.migration.web.service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.cloudfoundry.client.lib.CloudCredentials;
import org.cloudfoundry.client.lib.CloudFoundryClient;
import org.cloudfoundry.client.lib.domain.CloudApplication;
import org.cloudfoundry.client.lib.domain.CloudSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migration.web.model.Apps;
import com.migration.web.model.PcftoOpenshiftRecords;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Value("${target}")
	private String target;

	@Value("${user}")
	private String user;
	
	@Value("${password}")
	private String password;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public String helloWorld() {
		return "Hello-World";
	}

	RestTemplate restTemplate = new RestTemplate();
	static HttpHeaders headers = new HttpHeaders();
	String accessToken = "eyJhbGciOiJSUzI1NiIsImprdSI6Imh0dHBzOi8vdWFhLnJ1bi5waXZvdGFsLmlvL3Rva2VuX2tleXMiLCJraWQiOiJzaGEyLTIwMTctMDEtMjAta2V5IiwidHlwIjoiSldUIn0.eyJqdGkiOiJkMjBlZmEzMzg0OGY0OWY3OGU4NDI3YzI1YTgwN2E3MiIsInN1YiI6IjhmYzk3NzU5LTcxNGMtNGI0Ny1iYzk0LWE5YmRmMDdhY2Q2MiIsInNjb3BlIjpbImNsb3VkX2NvbnRyb2xsZXIucmVhZCIsInBhc3N3b3JkLndyaXRlIiwiY2xvdWRfY29udHJvbGxlci53cml0ZSIsIm9wZW5pZCIsInVhYS51c2VyIl0sImNsaWVudF9pZCI6ImNmIiwiY2lkIjoiY2YiLCJhenAiOiJjZiIsImdyYW50X3R5cGUiOiJwYXNzd29yZCIsInVzZXJfaWQiOiI4ZmM5Nzc1OS03MTRjLTRiNDctYmM5NC1hOWJkZjA3YWNkNjIiLCJvcmlnaW4iOiJ1YWEiLCJ1c2VyX25hbWUiOiJwcmF0eXVzaGtzaW5naDE5ODhAZ21haWwuY29tIiwiZW1haWwiOiJwcmF0eXVzaGtzaW5naDE5ODhAZ21haWwuY29tIiwiYXV0aF90aW1lIjoxNTk0NjIwNjgwLCJyZXZfc2lnIjoiNjFlM2YyYmQiLCJpYXQiOjE1OTQ2MjA3MDAsImV4cCI6MTU5NDYyMTMwMCwiaXNzIjoiaHR0cHM6Ly91YWEucnVuLnBpdm90YWwuaW8vb2F1dGgvdG9rZW4iLCJ6aWQiOiJ1YWEiLCJhdWQiOlsiY2xvdWRfY29udHJvbGxlciIsInBhc3N3b3JkIiwiY2YiLCJ1YWEiLCJvcGVuaWQiXX0.WQeQWZUEi84UtoEwccag3aTzu1dlQabBA3-_uZC7ueAuLTRGHIKDLG5dZWdbvqMYjGoQR7t06V04g5UxykV5eqtxxDDIgyKWW6f7PjcJzUSJItxbloPM6hDROj_n3AAs0_BYkxOc9hKlIFx3IucWnMVpspAXv5ZuN_GcgxpnPVp_TkgJJVX5F4KGgDyPBgCbUzoJJvTvoEu6BJF9IUlqLdZVKrCEI__bHJKpKXVc8_HkpYV0p-v5P2w6DrJtdbfYYQFwlv0bdQwcNpxzfGug9QgE-GZODw8GPlgrWPIsBsPoh9rAJ-woYU0jAOrMOZP97r7LRuRsXjX8WUma6UqgJw";

	@Override
	public String getAllApps() {
		ObjectMapper objectMapper = new ObjectMapper();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + accessToken);

		// final String uri = "https://api.system.pcf.opus.local/v3/apps/";
		final String uri = "https://api.run.pivotal.io/v3/apps/";

		// HttpEntity entity = new HttpEntity(headers);
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		ResponseEntity<String> result1 = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		try {
			JsonNode root = objectMapper.readTree(result1.getBody());
			JsonNode resources = root.get("resources");
			String name = resources.get(0).get("name").toString();
			String guid = resources.get(0).get("guid").toString();
			String state = resources.get(0).get("state").toString();
			System.err.println(name + " " + guid + " " + state);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result1.getBody());
		return result1.getBody();
	}

	@Override
	public String getAppDetails(String guid) {

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + accessToken);
		final String uri = "http://api.system.pcf.opus.local/v3/apps/" + guid;
		// final String uri = "https://api.run.pivotal.io/v3/apps/" + guid;

		// HttpEntity entity = new HttpEntity(headers);
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		ResponseEntity<String> result1 = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		System.out.println(result1.getBody());
		return result1.getBody();
	}
	
	
	@Override
	public List<Apps> getApps() {
		List<Apps> appsList = new ArrayList<Apps>();
//		String target = "https://api.run.pivotal.io";
//		String user = "pratyushksingh1988@gmail.com";
//		String password = "Pratyush@1988";

//		String target = "https://api.system.pcf.opus.local";
//		String user = "rahul.ranjan06@infosys.com";
//		String password = "Infy@0987654321";
		
		

		CloudCredentials credentials = new CloudCredentials(user, password);
		CloudFoundryClient client = new CloudFoundryClient(credentials, getTargetURL(target));
		client.login();

		ArrayList<String> appList = new ArrayList<String>();
		ArrayList<String> spaceList = new ArrayList<String>();
		ArrayList<String> orgList = new ArrayList<String>();
		ArrayList<String> serviceList = new ArrayList<String>();

		for (CloudSpace space : client.getSpaces()) {
			spaceList.add(space.getName());
			orgList.add(space.getOrganization().getName());
		}

		for (CloudApplication app : client.getApplications()) {
			appList.add(app.getName());// , service.getLabel());
		}

		// System.out.println(client.getApplications().toString());

		for (CloudApplication application : client.getApplications()) {
			Apps apps = new Apps();
			apps.setName(application.getName());
			apps.setEnvs(application.getEnv());
			apps.setInstance(application.getInstances());
			apps.setQuota(application.getDiskQuota());
			apps.setRoutes(application.getUris());
			apps.setRunningInstance(application.getRunningInstances());
			apps.setServices(application.getServices());
			apps.setState(application.getState().toString());
			appsList.add(apps);
			System.out.println("App Name = " + application.getName());
			System.out.println("App Instance = " + application.getInstances());
			System.out.println("Disk Quota = " + application.getDiskQuota());
			System.out.println("app Running Instances are = " + application.getRunningInstances());
			System.out.println("App State is = " + application.getState());
			System.out.println("app Environment are = " + application.getEnv());
			System.out.println("Services are = " + application.getServices());
			System.out.println("app routes are = " + application.getUris());
			System.out.println("VCAP_Services="+System.getenv("VCAP_SERVICES"));
			System.out.println("\n");

		}

//		System.out.println("Orgs Name are:-" + orgList);
//		System.out.println("Spaces are:-" + spaceList);
//		System.out.println("Apps Name are:-" + appList);
//		System.out.println("Services are:-" + serviceList);
//		System.out.println();

		return appsList;
	}

	private static URL getTargetURL(String target) {
		try {
			return URI.create(target).toURL();
		} catch (MalformedURLException e) {
			throw new RuntimeException("The target URL is not valid: " + e.getMessage());
		}
	}

	@Override
	public List<PcftoOpenshiftRecords> getSummaryPage() {
		return mongoTemplate.findAll(PcftoOpenshiftRecords.class);
	}

}
