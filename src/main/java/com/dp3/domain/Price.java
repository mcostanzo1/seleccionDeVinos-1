package com.dp3.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Price implements Serializable{

    @Id
    @ManyToOne
    private Product product;

    @Id
    private Date effectiveDate;

    @Column(nullable = false)
    private BigDecimal price;

    public Price(){

    }

    public Price(Product product, Date effectiveDate, BigDecimal price) {
        this.product = product;
        this.effectiveDate = effectiveDate;
        this.price = price;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
