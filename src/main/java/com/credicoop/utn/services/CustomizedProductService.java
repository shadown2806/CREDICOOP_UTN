package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.dto.*;
import com.credicoop.utn.entities.Category;
import com.credicoop.utn.entities.Customize;
import com.credicoop.utn.entities.CustomizedProduct;
import com.credicoop.utn.exceptions.product.ProductNotFoundException;
import com.credicoop.utn.mappers.CategoryMapper;
import com.credicoop.utn.mappers.CustomizeMapper;
import com.credicoop.utn.repositories.CustomizeRepository;
import com.credicoop.utn.repositories.CustomizedProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomizedProductService {

    private final CustomizedProductRepository customizedProductRepository;
    private final CategoryMapper categoryMapper;
    private final CustomizeRepository customizeRepository;
    private final CustomizeMapper customizeMapper;

    public CustomizedProductService(CustomizedProductRepository customizedProductRepository, CategoryMapper categoryMapper,
                                    CustomizeRepository customizeRepository, CustomizeMapper customizeMapper) {
        this.customizedProductRepository = customizedProductRepository;
        this.categoryMapper = categoryMapper;
        this.customizeRepository = customizeRepository;
        this.customizeMapper = customizeMapper;
    }


    public void addCustomizeProduct(CustomizedProduct customizedProduct, CustomizeDTO customizeDTO) {


        if(customizedProduct.getCategoryId().getId() != null){

            ResponseEntity<CategoryDTO> categoryDTO = new RestTemplate().getForEntity ("http://localhost:8080/api/v1/category/" + customizedProduct.getCategoryId().getId(),
                    CategoryDTO.class);
            CategoryDTO  c =  categoryDTO.getBody();
            Category category = categoryMapper.convertToEntity(c);
            customizedProduct.setCategoryId(category);

        }else{
            new RestTemplate().postForLocation("http://localhost:8080/api/v1/category/add", customizedProduct.getCategoryId());
            customizedProduct.setCategoryId(customizedProduct.getCategoryId());
        }

        ResponseEntity<CustomizeAreaDTO> customizedAreaId = new RestTemplate().getForEntity ("http://localhost:8080/api/v1/customizeArea/" + customizedProduct.getCustomizedAreaId(),
                CustomizeAreaDTO.class);

        customizeDTO.setCustomizedAreaId(customizedAreaId.getBody().getId());


        Long custId = customizeRepository.findCustomizeByTypePrice(customizeDTO.getCustomizeType(), customizeDTO.getCustomizePrice(), customizeDTO.getPhrase());

        if(custId == null){

            new RestTemplate().postForLocation("http://localhost:8080/api/v1/customize/add", customizeDTO);

            custId = customizeRepository.findCustomizeByTypePrice(customizeDTO.getCustomizeType(), customizeDTO.getCustomizePrice(), customizeDTO.getPhrase());
            customizedProduct.setCustomizedId(custId);

        }else{

            customizedProduct.setCustomizedId(custId);

        }



        ResponseEntity<CustomizeAreaDTO> consultCustomizeArea = new RestTemplate().getForEntity ("http://localhost:8080/api/v1/customizeArea/" + customizedProduct.getCustomizedAreaId(), CustomizeAreaDTO.class);
        ResponseEntity<ProductBaseDTO> consultProductBase = new RestTemplate().getForEntity ("http://localhost:8080/api/v1/productsBase/" + customizedProduct.getProductBaseId().getProductCode(), ProductBaseDTO.class);

        if(!consultCustomizeArea.getStatusCode().isError() && !consultProductBase.getStatusCode().isError()){

            customizedProductRepository.save(customizedProduct);

        }
    }

    public void deleteCustomizeProduct(Long id) {

        if (!customizedProductRepository.existsById(id)) {

            throw new ProductNotFoundException(Constants.CUSTOMIZED_PRODUCT_NOT_FOUND + id);

        }

        customizedProductRepository.deleteById(id);

    }


    public CustomizedProduct getCustomizeProduct(Long id) {

        Optional<CustomizedProduct> product = customizedProductRepository.findById(id);
        if (product.isEmpty()) {

            throw new ProductNotFoundException(Constants.CUSTOMIZED_PRODUCT_NOT_FOUND + id);

        }

        return product.get();

    }


    public List<CustomizedProduct> getAllCustomizeProduct() {
        return customizedProductRepository.findAll();
    }

}
