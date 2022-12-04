package com.credicoop.utn.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Seller")
@Table(name = "seller")
public class Seller extends UserEntity {

    @OneToMany(mappedBy = "seller")
    private List<Shop> shopList;

    @ManyToMany
    private List<PaymentMethod> paymentMethod;




    public Seller(){

        this.shopList = new ArrayList<>();
        this.paymentMethod = new ArrayList<>();

    }

}
