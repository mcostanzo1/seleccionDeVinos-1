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
	protected int quantityOnBox;
	protected int quantityOnStockInd;
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

    public int getQuantityOnBox() {
        return quantityOnBox;
    }

    public void setQuantityOnBox(int quantityOnBox) {
        this.quantityOnBox = quantityOnBox;
    }

    public int getQuantityOnStockInd() {
		return quantityOnStockInd;
	}

	public void setQuantityOnStockInd(int quantityOnStockInd) {
		this.quantityOnStockInd = quantityOnStockInd;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
