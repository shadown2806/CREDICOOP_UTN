package com.credicoop.utn.repositories;

import com.credicoop.utn.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
