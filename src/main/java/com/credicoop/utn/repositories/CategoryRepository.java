package com.credicoop.utn.repositories;

import com.credicoop.utn.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
