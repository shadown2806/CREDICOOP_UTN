package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.entities.Shop;
import com.credicoop.utn.exceptions.shop.ShopNotFoundException;
import com.credicoop.utn.repositories.ShopRepository;
import org.springframework.stereotype.Service;

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
