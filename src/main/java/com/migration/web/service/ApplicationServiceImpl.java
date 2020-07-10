package com.migration.web.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Override
	public String helloWorld() {
		return "Hello-World";
	}
	
	RestTemplate restTemplate = new RestTemplate();
	static HttpHeaders headers = new HttpHeaders();
	String accessToken = "eyJhbGciOiJSUzI1NiIsImprdSI6Imh0dHBzOi8vdWFhLnJ1bi5waXZvdGFsLmlvL3Rva2VuX2tleXMiLCJraWQiOiJzaGEyLTIwMTctMDEtMjAta2V5IiwidHlwIjoiSldUIn0.eyJqdGkiOiI0NWIzNThkMTE1YWE0YThhOTc1MzU2ODM4MjAyNGY3OSIsInN1YiI6IjhmYzk3NzU5LTcxNGMtNGI0Ny1iYzk0LWE5YmRmMDdhY2Q2MiIsInNjb3BlIjpbImNsb3VkX2NvbnRyb2xsZXIucmVhZCIsInBhc3N3b3JkLndyaXRlIiwiY2xvdWRfY29udHJvbGxlci53cml0ZSIsIm9wZW5pZCIsInVhYS51c2VyIl0sImNsaWVudF9pZCI6ImNmIiwiY2lkIjoiY2YiLCJhenAiOiJjZiIsImdyYW50X3R5cGUiOiJwYXNzd29yZCIsInVzZXJfaWQiOiI4ZmM5Nzc1OS03MTRjLTRiNDctYmM5NC1hOWJkZjA3YWNkNjIiLCJvcmlnaW4iOiJ1YWEiLCJ1c2VyX25hbWUiOiJwcmF0eXVzaGtzaW5naDE5ODhAZ21haWwuY29tIiwiZW1haWwiOiJwcmF0eXVzaGtzaW5naDE5ODhAZ21haWwuY29tIiwiYXV0aF90aW1lIjoxNTk0NDAyOTc3LCJyZXZfc2lnIjoiNjFlM2YyYmQiLCJpYXQiOjE1OTQ0MDY4ODEsImV4cCI6MTU5NDQwNzQ4MSwiaXNzIjoiaHR0cHM6Ly91YWEucnVuLnBpdm90YWwuaW8vb2F1dGgvdG9rZW4iLCJ6aWQiOiJ1YWEiLCJhdWQiOlsiY2xvdWRfY29udHJvbGxlciIsInBhc3N3b3JkIiwiY2YiLCJ1YWEiLCJvcGVuaWQiXX0.LbR8ZUfglwj6Z6nt5-tAxsfsOFbPRpkB2eZFpC8mTAntuv91EYTnare95xtEC6vaG7nqti8QkPEoe0y8s7TkF1Qa2-gvDbdoe5O22VkiQc-Kby7eX_-gbF8M1fF8pPOWyVM_IiU2KI0MBeD7r2XcLZD978Nz5lWKInnVyirJDyjySQb4277-Simv_g2aq5Sz_bVXqC1dTitOmz6a9UpLhko37sTk7JPTiILkQE5V5S4-9TdQtfe-EZR005NQ8ebyPwdIv1yTKsaUFjvH7wyErWY1Cni-dA-Q5aQeU2cANxhKb5rQb-MERkXhcPn32akFwP7f8Z_FoTiUHAQADTxo9A";

		
	@Override
	public String getAllApps() {
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+accessToken);

		final String uri = "http://api.system.pcf.opus.local/v3/apps/";
		//final String uri = "https://api.run.pivotal.io/v3/apps/";
		
		//HttpEntity entity = new HttpEntity(headers);
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		ResponseEntity<String> result1 = restTemplate.exchange(uri, HttpMethod.GET,entity,String.class);
		System.out.println(result1.getBody());
	    return result1.getBody();
	}

	@Override
	public String getAppDetails(String guid) {
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+accessToken);
		final String uri = "http://api.system.pcf.opus.local/v3/apps/" + guid;
		//final String uri = "https://api.run.pivotal.io/v3/apps/" + guid;
		
		//HttpEntity entity = new HttpEntity(headers);
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		ResponseEntity<String> result1 = restTemplate.exchange(uri, HttpMethod.GET,entity,String.class);
		System.out.println(result1.getBody());
		return result1.getBody();
	}
	
}
