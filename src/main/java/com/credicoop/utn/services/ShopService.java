package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.dto.CustomizedProductDTO;
import com.credicoop.utn.dto.ShopDTO;
import com.credicoop.utn.entities.Shop;
import com.credicoop.utn.exceptions.shop.ShopNotFoundException;
import com.credicoop.utn.repositories.ShopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService (ShopRepository shopRepository){
        this.shopRepository = shopRepository;
    }

    public void addShop(Shop shop) {
        shopRepository.save(shop);
    }

    public void addCustomizedProductByShop(CustomizedProductDTO customizedProductDTO, String shopId){

        ResponseEntity<ShopDTO> consultShop = new RestTemplate().getForEntity ("http://localhost:8080/api/v1/shop/" + shopId, ShopDTO.class);

        if(!consultShop.getStatusCode().isError()){


            new RestTemplate().postForLocation("http://localhost:8080/api/v1/customizedProducts/add", customizedProductDTO);

        }

    }

    public void deleteShop(Long id) {

        if (!shopRepository.existsById(id)) {

            throw new ShopNotFoundException(Constants.SHOP_NOT_FOUND + id);
        }
        shopRepository.deleteById(id);
    }

    public Shop getShop(Long id) {

        Optional<Shop> shop = shopRepository.findById(id);
        if (!shop.isPresent()) {

            throw new ShopNotFoundException(Constants.SHOP_NOT_FOUND + id);
        }
        return shop.get();
    }

    public List<Shop> getAllShop() {
        return shopRepository.findAll();
    }
}
