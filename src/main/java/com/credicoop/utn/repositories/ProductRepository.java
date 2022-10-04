package com.credicoop.utn.repositories;

import com.credicoop.utn.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
