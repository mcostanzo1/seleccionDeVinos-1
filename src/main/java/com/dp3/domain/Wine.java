package com.dp3.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(collection = "wines")
public class Wine extends Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String wineId;
	private String variety;
	private String cellarId;

	public Wine() {

	}

	public Wine(String wineName, int quantityOnBox, String variety, String cellarId) {
	    super.name = wineName;
	    super.quantityOnBox = quantityOnBox;
		this.variety = variety;
		this.cellarId = cellarId;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

    public String getCellarId() {
        return cellarId;
    }

    public void setCellarId(String cellarId) {
        this.cellarId = cellarId;
    }
}
