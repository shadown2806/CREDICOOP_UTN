package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.ProductDTO;
import com.credicoop.utn.entities.Product;
import com.credicoop.utn.mappers.ProductMapper;
import com.credicoop.utn.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products/")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper){

        this.productService = productService;
        this.productMapper = productMapper;

    }


    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO productDTO){

        productDTO.setCreatedAt(LocalDate.now());

        Product product = productMapper.convertToEntity(productDTO);
        productService.addProduct(product);

    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProduct(@PathVariable("id") Long id){

        Product product = productService.getProduct(id);
        return productMapper.convertToDto(product);

    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getAllProduct(){

        List<Product> product = productService.getAllProduct();
        return productMapper.ListConvertToDto(product);
    }


}
