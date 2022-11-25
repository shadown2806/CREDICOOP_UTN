package com.credicoop.utn.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity(name = "Customer")
@Table(name = "customer")
public class Customer extends UserEntity {

    @OneToMany(mappedBy = "order")
    private List<Order> orderList;

}
