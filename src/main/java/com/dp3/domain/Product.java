package com.dp3.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public abstract class Product {
	
	@Id
	protected String productCode;
	protected String name;
	protected int quantityOnBox;
	protected String clasify;
	
	public String getClasify() {
		return clasify;
	}
	
	public String getProductCode() {
		return productCode;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantityOnBox() {
		return quantityOnBox;
	}
}
