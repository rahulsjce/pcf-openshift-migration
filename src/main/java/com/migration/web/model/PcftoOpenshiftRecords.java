package com.migration.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pcftoopenshiftrecords")
public class PcftoOpenshiftRecords {

	@Id
	private String id;
    private String application_name;
    private String remidiation_status;
    private String application_type;
	
    public PcftoOpenshiftRecords(String id, String application_name, String remidiation_status,
			String application_type) {
		super();
		this.id = id;
		this.application_name = application_name;
		this.remidiation_status = remidiation_status;
		this.application_type = application_type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplication_name() {
		return application_name;
	}

	public void setApplication_name(String application_name) {
		this.application_name = application_name;
	}

	public String getRemidiation_status() {
		return remidiation_status;
	}

	public void setRemidiation_status(String remidiation_status) {
		this.remidiation_status = remidiation_status;
	}

	public String getApplication_type() {
		return application_type;
	}

	public void setApplication_type(String application_type) {
		this.application_type = application_type;
	}

	@Override
	public String toString() {
		return "PcftoOpenshiftRecords [id=" + id + ", application_name=" + application_name + ", remidiation_status="
				+ remidiation_status + ", application_type=" + application_type + "]";
	}
    
    
	

    
}
