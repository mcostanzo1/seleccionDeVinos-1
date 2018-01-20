package com.dp3.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Entity
//@DiscriminatorValue("WINE")
public class Wine extends Product {

    @ManyToOne
    private Cellar cellar;

	@Column
	private String variety;

	@Column
    private String description;

	public Wine() {

	}

	public Wine(String wineName, int quantityPerBox, String variety, Cellar cellar, BigDecimal price) {
        super.name = wineName;
        super.quantityPerBox = quantityPerBox;
        super.quantityOnStock = 0;
        this.variety = variety;
        this.cellar = cellar;
        super.prices = new ArrayList<Price>();
        prices.add(new Price(this, new Date(), price));
    }

    public Cellar getCellar() {
        return cellar;
    }

    public void setCellar(Cellar cellar) {
        this.cellar = cellar;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
