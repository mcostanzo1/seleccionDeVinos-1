package com.dp3.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public abstract class Product {
	
	@Id
	protected BigInteger productCode;
	protected String name;
	protected int quantityOnBox;
	protected int quantityOnStockBox;
	protected int quantityOnStockInd;
	protected String clasify;
	protected BigDecimal price;
	
	public String getClasify() {
		return clasify;
	}
	
	public BigInteger getProductCode() {
		return productCode;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantityOnBox() {
		return quantityOnBox;
	}

	public int getQuantityOnStockBox() {
		return quantityOnStockBox;
	}

	public int getQuantityOnStockInd() {
		return quantityOnStockInd;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
//	public void setQuantityOnStockBox(int quantityOnStockBox) {
//		this.quantityOnStockBox = quantityOnStockBox;
//	}
//	
//	public void setQuantityOnStockInd(int quantityOnStockInd) {
//		this.quantityOnStockInd = quantityOnStockInd;
//	}
//	
//	public void setPrice(BigDecimal price) {
//		this.price = price;
//	}

}
