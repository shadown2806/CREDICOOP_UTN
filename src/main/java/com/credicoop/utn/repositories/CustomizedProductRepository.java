package com.credicoop.utn.repositories;

import com.credicoop.utn.entities.CustomizedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomizedProductRepository extends JpaRepository<CustomizedProduct, Long> {
}
