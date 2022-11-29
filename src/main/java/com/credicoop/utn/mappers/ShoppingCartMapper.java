package com.credicoop.utn.mappers;

import com.credicoop.utn.dto.ShopDTO;
import com.credicoop.utn.dto.ShoppingCartDTO;
import com.credicoop.utn.entities.Shop;
import com.credicoop.utn.entities.ShoppingCart;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartMapper {
    private final ModelMapper shoppingCartMapper;


    public ShoppingCartMapper(ModelMapper shoppingCartMapper) {
        this.shoppingCartMapper = shoppingCartMapper;
    }

    public List<ShoppingCartDTO> ListConvertToDto(List<ShoppingCart> listShoppingCart) {

        List<ShoppingCartDTO> listShoppingCartDTO = new ArrayList<>();

        for (ShoppingCart shoppingCart : listShoppingCart) {

            listShoppingCartDTO.add(shoppingCartMapper.map(shoppingCart, ShoppingCartDTO.class));
        }
        return listShoppingCartDTO;
    }

    public ShoppingCartDTO convertToDto(ShoppingCart shoppingCart) {
        ShoppingCartDTO shoppingCartDTO = shoppingCartMapper.map(shoppingCart, ShoppingCartDTO.class);
        return shoppingCartDTO;
    }

    public ShoppingCart convertToEntity(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = shoppingCartMapper.map(shoppingCartDTO, ShoppingCart.class);
        return shoppingCart;
    }

}
