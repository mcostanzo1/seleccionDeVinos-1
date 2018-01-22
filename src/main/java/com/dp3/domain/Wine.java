package com.dp3.domain;

import com.dp3.dao.CellarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Entity
//@DiscriminatorValue("WINE")
public class Wine extends Product implements Comparable<Product> {

    @Autowired
    @Transient
    private CellarRepository cellarRepository;

    @ManyToOne
    private Cellar cellar;

	@Column
	private String variety;

	@Column
    private String description;

	public Wine() {

	}

	/*
    public Wine(@JsonProperty("name") String wineName,
                @JsonProperty("quantityPerBox") int quantityPerBox,
                @JsonProperty("variety") String variety,
                @JsonProperty("cellarId") Integer cellarId,
                @JsonProperty("price") BigDecimal price) {
	    new Wine(wineName, quantityPerBox, variety, cellarRepository.findOne(cellarId), price);

        super.name = wineName;
        super.quantityPerBox = quantityPerBox;
        this.variety = variety;
        this.cellar = cellarRepository.findOne(cellarId);
        super.prices = new ArrayList<>();
        prices.add(new Price(this, new Date(), price));

    }
        */


	public Wine(String wineName, int quantityPerBox, String variety, Cellar cellar, BigDecimal price) {
        super.name = wineName;
        super.quantityPerBox = quantityPerBox;
        super.quantityOnStock = 0;
        this.variety = variety;
        this.cellar = cellar;
        super.prices = new ArrayList<>();
        super.addPrice(new Date(), price);
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

    @Override
    public int compareTo(Product o) {
        return super.compareTo(o);
    }
}
