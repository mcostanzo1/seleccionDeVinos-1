package com.dp3.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity()
public class Cellar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cellarId;
	private String cellarName;
	private String location;
	@Column(length = 4000)
	private String description;
	private Date createdAt = new Date();

	public Cellar() {
	}

	public Cellar(@JsonProperty("cellarName") String cellarName,
				  @JsonProperty("location") String location,
				  @JsonProperty("description") String description) {
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

    public Integer getCellarId() {
        return cellarId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}