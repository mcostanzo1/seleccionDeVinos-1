package com.dp3.domain;

import javax.persistence.*;

@Entity
public class Wine extends Product {

    @ManyToOne
    private Cellar cellar;

	@Column
	private String variety;

	@Column
    private String description;

	public Wine() {

	}

	public Wine(String wineName, int quantityPerBox, String variety, Cellar cellar) {
        super.name = wineName;
        super.quantityPerBox = quantityPerBox;
        super.quantityOnStock = 0;
        this.variety = variety;
        this.cellar = cellar;
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
