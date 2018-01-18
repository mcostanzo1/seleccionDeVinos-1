package com.dp3.domain;


import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "cellars")
public class Cellar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String cellarId;
	private String cellarName;
	private String location;
	private String description;

	public Cellar() {
	}

	public Cellar(@JsonProperty("id") String id,
				  @JsonProperty("cellarName") String cellarName,
				  @JsonProperty("location") String location,
				  @JsonProperty("description") String description) {
		this.cellarId = id;
		this.cellarName = cellarName;
		this.location = location;
		this.description = description;
	}

	public void setCellarName(String cellarName) {
		this.cellarName = cellarName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCellarName() {
		return cellarName;
	}

	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}

    public String getCellarId() {
        return cellarId;
    }

    public void setCellarId(String cellarId) {
        this.cellarId = cellarId;
    }
}