package com.dp3.domain;


import com.dp3.printable.Printable;
import com.lowagie.text.Document;
import org.hibernate.annotations.Cascade;
import org.hibernate.collection.internal.PersistentMap;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
public class PriceList implements Printable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;

    @Column(nullable = false)
    private BaseOfPriceList base;

    @OneToOne
    private PriceList basePriceList;

    @Column(nullable = false)
    private BigDecimal discountPercentage;

    @ElementCollection
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Map<Product, BigDecimal> productPrice = new TreeMap<>();

    public PriceList() {
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BaseOfPriceList getBase() {
        return base;
    }

    public PriceList getBasePriceList() {
        return basePriceList;
    }

    public void setBasePriceList(PriceList basePriceList) {
        this.basePriceList = basePriceList;
    }

    public void setBase(BaseOfPriceList base) {
        this.base = base;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Map<Product, BigDecimal> getProductPrice() {
        return productPrice;
    }

    public void addProductToPriceList(Product product, BigDecimal price) {
        this.productPrice.put(product, price);
    }

    @Override
    public Document getDocument(Document doc) {
        return doc;
    }

    @Override
    public String getPdfName() {
        return this.description;
    }
}