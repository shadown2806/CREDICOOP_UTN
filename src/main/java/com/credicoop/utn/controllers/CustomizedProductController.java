package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.CategoryDTO;
import com.credicoop.utn.dto.CustomizeAreaDTO;
import com.credicoop.utn.dto.CustomizedProductDTO;
import com.credicoop.utn.dto.ProductBaseDTO;
import com.credicoop.utn.entities.*;
import com.credicoop.utn.mappers.*;
import com.credicoop.utn.services.CustomizedProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customizedProducts/")
public class CustomizedProductController {

    private final CustomizedProductService customizedProductService;
    private final CustomizedProductMapper customizedProductMapper;
    private final ProductBaseMapper productBaseMapper;


    public CustomizedProductController(CustomizedProductService customizedProductService, CustomizedProductMapper customizedProductMapper, ProductBaseMapper productBaseMapper
    ,CategoryMapper categoryMapper){
        this.customizedProductService = customizedProductService;
        this.customizedProductMapper = customizedProductMapper;
        this.productBaseMapper = productBaseMapper;
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomizedProduct(@RequestBody CustomizedProductDTO customizedProductDTO){

        CustomizedProduct customizedProduct = customizedProductMapper.convertToEntity(customizedProductDTO);

        ResponseEntity<ProductBaseDTO> productBaseDTO = new RestTemplate().getForEntity ("http://localhost:8080/api/v1/productsBase/" + customizedProductDTO.getProductBaseId() ,
                ProductBaseDTO.class);
        ProductBaseDTO  p =  productBaseDTO.getBody();
        ProductBase productBase = productBaseMapper.convertToEntity(p);
        customizedProduct.setProductBaseId(productBase);
        customizedProduct.setCustomizedAreaId(customizedProductDTO.getCustomizeAreaId());

        customizedProductService.addCustomizeProduct(customizedProduct, customizedProductDTO.getCustomized());
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomizeProduct(@PathVariable("id") Long id){
        customizedProductService.deleteCustomizeProduct(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomizedProductDTO getCustomizeProduct(@PathVariable("id") Long id){
        CustomizedProduct customizedProduct = customizedProductService.getCustomizeProduct(id);
        return customizedProductMapper.convertToDto(customizedProduct);
    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomizedProductDTO> getAllCustomizeProduct(){
        List<CustomizedProduct> customizedProduct = customizedProductService.getAllCustomizeProduct();
        return customizedProductMapper.ListConvertToDto(customizedProduct);
    }
}
