package com.credicoop.utn.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;

    @ManyToMany(mappedBy = "shopList", cascade = CascadeType.ALL)
    private List<CustomizedProduct> customizedProductList;

    @ManyToOne(targetEntity = Seller.class)
    @JoinColumn(name = "seller_id",referencedColumnName = "id")
    private Seller seller;



}
