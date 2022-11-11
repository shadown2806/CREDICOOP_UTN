package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.CustomizedProductDTO;
import com.credicoop.utn.entities.CustomizedProduct;
import com.credicoop.utn.mappers.CustomizedProductMapper;
import com.credicoop.utn.services.CustomizedProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customizedProducts/")
public class CustomizedProductController {

    private final CustomizedProductService customizedProductService;
    private final CustomizedProductMapper customizedProductMapper;

    public CustomizedProductController(CustomizedProductService customizedProductService, CustomizedProductMapper customizedProductMapper){

        this.customizedProductService = customizedProductService;
        this.customizedProductMapper = customizedProductMapper;

    }


    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomizedProduct(@RequestBody CustomizedProductDTO customizedProductDTO){

        customizedProductDTO.setCreatedAt(LocalDate.now());

        CustomizedProduct customizedProduct = customizedProductMapper.convertToEntity(customizedProductDTO);
        customizedProductService.addCustomizeProduct(customizedProduct);

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
