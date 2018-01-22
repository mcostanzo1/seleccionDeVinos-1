package com.dp3.web.wrapper;

import com.dp3.domain.PriceList;

import java.math.BigDecimal;

public class PriceListWrapper {

    PriceList priceList;
    Integer baseListId;
    BigDecimal discount;

    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public Integer getBaseListId() {
        return baseListId;
    }

    public void setBaseListId(Integer baseListId) {
        this.baseListId = baseListId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
