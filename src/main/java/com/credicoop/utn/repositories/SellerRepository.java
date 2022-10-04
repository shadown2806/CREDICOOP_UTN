package com.credicoop.utn.repositories;

import com.credicoop.utn.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
