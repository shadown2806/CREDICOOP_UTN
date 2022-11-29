package com.credicoop.utn.mappers;

import com.credicoop.utn.dto.ShopDTO;
import com.credicoop.utn.entities.Shop;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopMapper {

    private final ModelMapper shopMapper;

    public ShopMapper(ModelMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    public List<ShopDTO> ListConvertToDto(List<Shop> listShop) {

        List<ShopDTO> listShopDTO = new ArrayList<>();

        for (Shop shop : listShop) {

            listShopDTO.add(shopMapper.map(shop, ShopDTO.class));
        }
        return listShopDTO;
    }

    public ShopDTO convertToDto(Shop shop) {
        ShopDTO shopDTO = shopMapper.map(shop, ShopDTO.class);
        return shopDTO;
    }

    public Shop convertToEntity(ShopDTO shopDTO) {
        Shop shop = shopMapper.map(shopDTO, Shop.class);
        return shop;
    }

}
