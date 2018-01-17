package com.dp3.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public abstract class Product {
	
	@Id
<<<<<<< HEAD
	protected BigInteger productId;
=======
	protected BigInteger productCode;
>>>>>>> c885f0c2656b8ce59f835f24e12ac74303215185
	protected String name;
	protected int quantityOnBox;
	protected int quantityOnStockBox;
	protected int quantityOnStockInd;
<<<<<<< HEAD
	protected String variety;
=======
	protected String clasify;
>>>>>>> c885f0c2656b8ce59f835f24e12ac74303215185
	protected BigDecimal price;
	
	public String getVariety() {
		return variety;
	}
	
<<<<<<< HEAD
	public BigInteger getProductId() {
		return productId;
=======
	public BigInteger getProductCode() {
		return productCode;
>>>>>>> c885f0c2656b8ce59f835f24e12ac74303215185
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
