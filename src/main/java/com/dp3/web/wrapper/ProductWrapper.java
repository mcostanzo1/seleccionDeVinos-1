package com.dp3.web.wrapper;

import com.dp3.domain.Product;

public class ProductWrapper {

    private Product product;
    private Integer boxQuantity;
    private Integer unitQuantity;

    public ProductWrapper() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getBoxQuantity() {
        return boxQuantity;
    }

    public void setBoxQuantity(Integer boxQuantity) {
        this.boxQuantity = boxQuantity;
    }

    public Integer getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(Integer unitQuantity) {
        this.unitQuantity = unitQuantity;
    }
}
