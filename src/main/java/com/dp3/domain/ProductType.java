package com.dp3.domain;

public enum ProductType {
    WINE("WINE");

    private String type;

    ProductType(String type) {
        this.type = type;
    }

    public String type(){
        return this.type;
    }
}
