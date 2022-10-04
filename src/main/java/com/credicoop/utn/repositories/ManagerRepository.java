package com.credicoop.utn.repositories;

import com.credicoop.utn.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
