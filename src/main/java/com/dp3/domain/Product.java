package com.dp3.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer productId;

    @Column
    protected ProductType productType;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected int quantityPerBox;

    @Column(nullable = false)
    protected int quantityOnStock;

    /*@OneToMany
    protected List<ProductPrice> price;*/

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityPerBox() {
        return quantityPerBox;
    }

    public void setQuantityPerBox(int quantityPerBox) {
        this.quantityPerBox = quantityPerBox;
    }

    public int getQuantityOnStock() {
        return quantityOnStock;
    }

    public void setQuantityOnStock(int quantityOnStock) {
        this.quantityOnStock = quantityOnStock;
    }

}


