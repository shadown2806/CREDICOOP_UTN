package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.CustomizedProductDTO;
import com.credicoop.utn.dto.SellerDTO;
import com.credicoop.utn.dto.ShopDTO;
import com.credicoop.utn.entities.Seller;
import com.credicoop.utn.mappers.SellerMapper;
import com.credicoop.utn.services.SellerService;
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
@RequestMapping(path = "api/v1/seller/")
public class SellerController {

    private final SellerService sellerService;
    private final SellerMapper sellerMapper;

    public SellerController(SellerService sellerService, SellerMapper sellerMapper){
        this.sellerService = sellerService;
        this.sellerMapper = sellerMapper;
    }

    @PostMapping(value ="{sellerId}/shop/{shopId}/add/customizedProductBySeller")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomizedProductBySeller(@RequestBody CustomizedProductDTO customizedProductDTO, @PathVariable String sellerId, @PathVariable String shopId){
        sellerService.addCustomizedProductBySeller(customizedProductDTO, sellerId, shopId);
    }

    @PostMapping(value = "{sellerId}/add/shopBySeller")
    @ResponseStatus(HttpStatus.CREATED)
    public void addShopBySeller(@RequestBody ShopDTO shopDTO, @PathVariable String sellerId){
        sellerService.addShopBySeller(shopDTO, sellerId);
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSeller(@RequestBody SellerDTO sellerDTO){
        Seller seller = sellerMapper.convertToEntity(sellerDTO);
        sellerService.addSeller(seller);
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSeller(@PathVariable("id") Long id){
        sellerService.deleteSeller(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public SellerDTO getSeller(@PathVariable("id") Long id){
        Seller seller = sellerService.getSeller(id);
        return sellerMapper.convertToDto(seller);
    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<SellerDTO> getAllSeller(){
        List<Seller> seller = sellerService.getAllSeller();
        return sellerMapper.ListConvertToDto(seller);
    }
}
