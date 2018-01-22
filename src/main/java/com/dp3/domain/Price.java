package com.dp3.domain;

import com.dp3.dao.PriceId;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Price implements Serializable{

    @EmbeddedId
    private PriceId priceId;

    @Column(nullable = false)
    private BigDecimal price;

    public Price(){

    }

    public Price(PriceId priceId, BigDecimal price) {
        this.priceId = priceId;
        this.price = price;
    }

    public PriceId getPriceId() {
        return priceId;
    }

    public void setPriceId(PriceId priceId) {
        this.priceId = priceId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
