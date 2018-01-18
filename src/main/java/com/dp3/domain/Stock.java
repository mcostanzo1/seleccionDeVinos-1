package com.dp3.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Document(collection = "stock")
public class Stock {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected String stockId;
    protected Product product;
    protected String quantityOnStockBox;
    protected BigDecimal price;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

	public Stock() {

	}

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getQuantityOnStockBox() {
		return quantityOnStockBox;
	}

	public void setQuantityOnStockBox(String quantityOnStockBox) {
		this.quantityOnStockBox = quantityOnStockBox;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
