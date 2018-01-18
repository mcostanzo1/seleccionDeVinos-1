package com.dp3.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public abstract class Product {
	
	@Id
	protected BigInteger productId;
	protected BigInteger productCode;
	protected String name;
	protected int quantityOnStockBox;
	protected int quantityOnStockInd;
	protected String variety;
	protected String clasify;
	protected BigDecimal price;


	public BigInteger getProductId() {
		return productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public BigInteger getProductCode() {
		return productCode;
	}

	public void setProductCode(BigInteger productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantityOnStockBox() {
		return quantityOnStockBox;
	}

	public void setQuantityOnStockBox(int quantityOnStockBox) {
		this.quantityOnStockBox = quantityOnStockBox;
	}

	public int getQuantityOnStockInd() {
		return quantityOnStockInd;
	}

	public void setQuantityOnStockInd(int quantityOnStockInd) {
		this.quantityOnStockInd = quantityOnStockInd;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public String getClasify() {
		return clasify;
	}

	public void setClasify(String clasify) {
		this.clasify = clasify;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
