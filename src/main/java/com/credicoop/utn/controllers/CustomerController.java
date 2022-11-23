package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.CustomerDTO;
import com.credicoop.utn.entities.Customer;
import com.credicoop.utn.mappers.CustomerMapper;
import com.credicoop.utn.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer/")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper){

        this.customerService = customerService;
        this.customerMapper = customerMapper;

    }


    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CustomerDTO customerDTO){

        customerDTO.setCreatedAt(LocalDate.now());

        Customer customer = customerMapper.convertToEntity(customerDTO);
        customerService.addCustomer(customer);

    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id") Long id){

        customerService.deleteCustomer(id);

    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomer(@PathVariable("id") Long id){

        Customer customer = customerService.getCustomer(id);
        return customerMapper.convertToDto(customer);

    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getAllCustomer(){

        List<Customer> customerList = customerService.getAllCustomer();
        return customerMapper.ListConvertToDto(customerList);
    }


}
