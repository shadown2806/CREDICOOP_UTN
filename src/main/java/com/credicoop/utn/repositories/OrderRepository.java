package com.credicoop.utn.repositories;

import com.credicoop.utn.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
