package com.credicoop.utn.repositories;

import com.credicoop.utn.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
