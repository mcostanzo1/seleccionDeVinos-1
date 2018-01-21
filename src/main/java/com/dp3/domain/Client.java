package com.dp3.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;

@Entity()
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String clientId;
    private String name;
    private String phone;
    private String address;
    private String email;
    @ManyToOne
    private User clientOwner;


    public Client() {
    }

    public Client(@JsonProperty("email")String email,
                  @JsonProperty("name") String name,
                  @JsonProperty("phone")String phone,
                  @JsonProperty("address") String address) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user!=null){
            this.clientOwner = user;
        }
    }

    public String getClientId() {
        return clientId;
    }

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
}
