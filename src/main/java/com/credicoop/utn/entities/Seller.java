package com.credicoop.utn.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Seller")
@Table(name = "seller")
public class Seller extends UserEntity {

    @OneToMany(mappedBy = "shop")
    private List<Shop> shopList;

    public Seller(){

        this.shopList = new ArrayList<>();

    }

}
