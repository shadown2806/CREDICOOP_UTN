package com.credicoop.utn.mappers;


import com.credicoop.utn.dto.ProductDTO;
import com.credicoop.utn.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    private final ModelMapper productMapper;

    public ProductMapper(){this.productMapper = new ModelMapper();}


    public List<ProductDTO> ListConvertToDto(List<Product> listProduct){

        List<ProductDTO> listProductDTO = new ArrayList<>();

        for(Product product:listProduct){

            listProductDTO.add(productMapper.map(product,ProductDTO.class));

        }

        return listProductDTO;
    }

    public ProductDTO convertToDto(Product product){
        ProductDTO productDTO = productMapper.map(product,ProductDTO.class);
        return productDTO;
    }

    public Product convertToEntity(ProductDTO productDTO){
        Product product = productMapper.map(productDTO,Product.class);
        return product;
    }

}
