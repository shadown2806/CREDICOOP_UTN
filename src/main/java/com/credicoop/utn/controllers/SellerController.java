package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.SellerDTO;
import com.credicoop.utn.entities.Seller;
import com.credicoop.utn.mappers.SellerMapper;
import com.credicoop.utn.services.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/seller/")
public class SellerController {


    private final SellerService sellerService;
    private final SellerMapper sellerMapper;

    public SellerController(SellerService sellerService, SellerMapper sellerMapper){

        this.sellerService = sellerService;
        this.sellerMapper = sellerMapper;

    }


    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody SellerDTO sellerDTO){

        sellerDTO.setCreatedAt(LocalDate.now());

        Seller seller = sellerMapper.convertToEntity(sellerDTO);
        sellerService.addSeller(seller);

    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public SellerDTO getProduct(@PathVariable("id") Long id){

        Seller seller = sellerService.getSeller(id);
        return sellerMapper.convertToDto(seller);

    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<SellerDTO> getAllProduct(){

        List<Seller> seller = sellerService.getAllSeller();
        return sellerMapper.ListConvertToDto(seller);
    }


}