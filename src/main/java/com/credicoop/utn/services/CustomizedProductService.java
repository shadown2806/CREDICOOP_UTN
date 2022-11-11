package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.entities.CustomizedProduct;
import com.credicoop.utn.exceptions.product.ProductNotFoundException;
import com.credicoop.utn.repositories.CustomizedProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomizedProductService {

    private final CustomizedProductRepository customizedProductRepository;

    public CustomizedProductService(CustomizedProductRepository customizedProductRepository) {
        this.customizedProductRepository = customizedProductRepository;
    }


    public void addCustomizeProduct(CustomizedProduct customizedProduct) {
        customizedProductRepository.save(customizedProduct);
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
