package com.credicoop.utn.mappers;


import com.credicoop.utn.dto.ProductBaseDTO;
import com.credicoop.utn.entities.ProductBase;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductBaseMapper {

    private final ModelMapper productBaseMapper;

    public ProductBaseMapper() {
        this.productBaseMapper = new ModelMapper();
    }


    public List<ProductBaseDTO> ListConvertToDto(List<ProductBase> listProductBase) {

        List<ProductBaseDTO> listProductBaseDTO = new ArrayList<>();

        for (ProductBase productBase : listProductBase) {

            listProductBaseDTO.add(productBaseMapper.map(productBase, ProductBaseDTO.class));

        }

        return listProductBaseDTO;
    }

    public ProductBaseDTO convertToDto(ProductBase productBase) {
        return productBaseMapper.map(productBase, ProductBaseDTO.class);
    }

    public ProductBase convertToEntity(ProductBaseDTO productBaseDTO) {
        return productBaseMapper.map(productBaseDTO, ProductBase.class);
    }

}
