package com.dp3.domain;

import com.dp3.dao.PriceId;
import org.hibernate.annotations.Cascade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "PRODUCT_TYPE")
public abstract class Product implements Comparable<Product> {

    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer productId;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected int quantityPerBox;

    @Column(nullable = false)
    protected int quantityOnStock;

    @OneToMany
    @Cascade(value= org.hibernate.annotations.CascadeType.ALL)
    protected List<Price> prices = new ArrayList<>();

    @Version
    private int version;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityPerBox() {
        return quantityPerBox;
    }

    public void setQuantityPerBox(int quantityPerBox) {
        this.quantityPerBox = quantityPerBox;
    }

    public int getQuantityOnStock() {
        return quantityOnStock;
    }

    public void setQuantityOnStock(int quantityOnStock) {
        this.quantityOnStock = quantityOnStock;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void addPrice(Date dateFrom, BigDecimal price) {
        PriceId priceId = new PriceId(this, dateFrom);
        prices.add(new Price(priceId, price));
    }

    @Override
    public int compareTo(Product o) {
        LOGGER.info("compareTo de Product !!! ");
        return this.productId.compareTo(o.productId);
    }

    @Override
    public boolean equals(Object obj) {
        Product prod = (Product) obj;
        return this.productId == prod.productId;
    }
}


