package com.dp3.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

@Entity()
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @ManyToOne
    private Client client;

    @OneToOne
    private PriceList priceList;

    @OneToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<OrderDetail> details = new ArrayList<>();
    private OrderStatus status;
    private Date created = new Date();
    private Date lastUpdated = new Date();

    @OneToOne
    private User owner;

    public Order() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
