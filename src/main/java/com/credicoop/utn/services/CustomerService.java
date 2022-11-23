package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.entities.Customer;
import com.credicoop.utn.exceptions.customer.CustomerNotFoundException;
import com.credicoop.utn.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){

        this.customerRepository = customerRepository;

    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {

        if (!customerRepository.existsById(id)) {

            throw new CustomerNotFoundException(Constants.CUSTOMER_NOT_FOUND + id);

        }

        customerRepository.deleteById(id);

    }


    public Customer getCustomer(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {

            throw new CustomerNotFoundException(Constants.CUSTOMER_NOT_FOUND + id);

        }

        return customer.get();

    }


    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }


}
