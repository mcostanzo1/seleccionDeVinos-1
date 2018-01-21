package com.dp3.web.wrapper;

import com.dp3.domain.Wine;

import java.math.BigDecimal;

public class WineWrapper {
    Wine wine;
    Integer cellarId;
    BigDecimal price;

    public Wine getWine() {
        return wine;
    }

    public Integer getCellarId() {
        return cellarId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    public void setCellarId(Integer cellarId) {
        this.cellarId = cellarId;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
