package com.credicoop.utn.mappers;

import com.credicoop.utn.dto.SellerDTO;
import com.credicoop.utn.entities.Seller;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellerMapper {

    private final ModelMapper sellerMapper;

    public SellerMapper() {
        this.sellerMapper = new ModelMapper();
    }




    public List<SellerDTO> ListConvertToDto(List<Seller> listSeller) {

        List<SellerDTO> listSellerDTO = new ArrayList<>();

        for (Seller seller : listSeller) {

            listSellerDTO.add(sellerMapper.map(seller, SellerDTO.class));

        }

        return listSellerDTO;
    }

    public SellerDTO convertToDto(Seller seller) {
        SellerDTO sellerDTO = sellerMapper.map(seller, SellerDTO.class);
        return sellerDTO;
    }

    public Seller convertToEntity(SellerDTO sellerDTO) {
        Seller seller = sellerMapper.map(sellerDTO, Seller.class);
        return seller;
    }

}
