package com.dp3.dao;

import com.dp3.domain.Product;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class PriceId implements Serializable{

    @ManyToOne
    private Product product;

    @Column
    private Date effectiveDate;

    public PriceId() {
    }

    public PriceId(Product product, Date effectiveDate) {
        this.product = product;
        this.effectiveDate = effectiveDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
