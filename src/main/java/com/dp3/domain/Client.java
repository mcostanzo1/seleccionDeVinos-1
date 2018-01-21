package com.dp3.domain;

import com.dp3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity()
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer clientId;
    private String name;
    private String phone;
    private String address;
    private String email;
    @ManyToOne
    private User clientOwner;

    @Autowired @Transient
    private ClientService clientService;


    public Client() {
    }
    public Client(String email,
                  String name,
                  String phone,
                  String address, User user) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        if (user==null) {
            user = clientService.getContextUser();
        }
        this.clientOwner = user;
    }
/*
    public Client(@JsonProperty("email")String email,
                  @JsonProperty("name") String name,
                  @JsonProperty("phone")String phone,
                  @JsonProperty("address") String address, User user) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.clientOwner = clientService.getContextUser();
    }

    @JsonCreator
    public Client(@JsonProperty("email")String email,
                  @JsonProperty("name") String name,
                  @JsonProperty("phone")String phone,
                  @JsonProperty("address") String address) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.clientOwner = clientService.getContextUser();

    }
    */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getClientOwner() {
        return clientOwner;
    }

    public void setClientOwner(User clientOwner) {
        this.clientOwner = clientOwner;
    }

    public Integer getClientId() {
        return clientId;
    }
}
