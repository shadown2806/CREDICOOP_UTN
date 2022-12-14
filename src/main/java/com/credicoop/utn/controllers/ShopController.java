package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.CustomizedProductDTO;
import com.credicoop.utn.dto.ShopDTO;
import com.credicoop.utn.entities.Shop;
import com.credicoop.utn.mappers.ShopMapper;
import com.credicoop.utn.services.ShopService;
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
@RequestMapping(path = "api/v1/shop/")
public class ShopController {

    private final ShopService shopService;
    private final ShopMapper shopMapper;

    public ShopController(ShopService shopService, ShopMapper shopMapper) {
        this.shopService = shopService;
        this.shopMapper = shopMapper;
    }

    @PostMapping(value = "{shopId}/add/customizedProductByShop")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomizedProductsByShop(@PathVariable String shopId, @RequestBody CustomizedProductDTO customizedProductDTO){
        shopService.addCustomizedProductByShop(customizedProductDTO, shopId);
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createShop(@RequestBody ShopDTO shopDTO){
        Shop shop = shopMapper.convertToEntity(shopDTO);
        shopService.addShop(shop);
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteShop(@PathVariable("id") Long id){
        shopService.deleteShop(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShopDTO getShop(@PathVariable("id") Long id){
        Shop shop = shopService.getShop(id);
        return shopMapper.convertToDto(shop);
    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<ShopDTO> getAllShop(){
        List<Shop> shop = shopService.getAllShop();
        return shopMapper.ListConvertToDto(shop);
    }
}
