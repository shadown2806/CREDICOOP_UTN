package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.ProductBaseDTO;
import com.credicoop.utn.entities.ProductBase;
import com.credicoop.utn.mappers.ProductBaseMapper;
import com.credicoop.utn.services.ProductBaseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/productsBase/")
public class ProductBaseController {

    private final ProductBaseService productBaseService;
    private final ProductBaseMapper productBaseMapper;

    public ProductBaseController(ProductBaseService productBaseService, ProductBaseMapper productBaseMapper){
        this.productBaseService = productBaseService;
        this.productBaseMapper = productBaseMapper;
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProductBase(@RequestBody ProductBaseDTO productBaseDTO){
        ProductBase productBase = productBaseMapper.convertToEntity(productBaseDTO);
        productBaseService.addProductBase(productBase);
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductBase(@PathVariable("id") Long id){
        productBaseService.deleteProductBase(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductBaseDTO getProductBase(@PathVariable("id") Long id){
        ProductBase productBase = productBaseService.getProductBase(id);
        return productBaseMapper.convertToDto(productBase);
    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductBaseDTO> getAllProductBase(){
        List<ProductBase> productBase = productBaseService.getAllProductBase();
        return productBaseMapper.ListConvertToDto(productBase);
    }
}
