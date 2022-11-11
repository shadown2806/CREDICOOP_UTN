package com.credicoop.utn.services;


import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.entities.ProductBase;
import com.credicoop.utn.exceptions.product.ProductNotFoundException;
import com.credicoop.utn.repositories.ProductBaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductBaseService {

    private final ProductBaseRepository productBaseRepository;

    public ProductBaseService(ProductBaseRepository productBaseRepository){

        this.productBaseRepository = productBaseRepository;

    }


    public void addProductBase(ProductBase productBase) {
        productBaseRepository.save(productBase);
    }

    public void deleteProductBase(Long id) {

        if (!productBaseRepository.existsById(id)) {

            throw new ProductNotFoundException(Constants.PRODUCT_BASE_NOT_FOUND + id);

        }

        productBaseRepository.deleteById(id);

    }


    public ProductBase getProductBase(Long id) {

        Optional<ProductBase> product = productBaseRepository.findById(id);
        if (product.isEmpty()) {

            throw new ProductNotFoundException(Constants.PRODUCT_BASE_NOT_FOUND + id);

        }

        return product.get();

    }


    public List<ProductBase> getAllProductBase() {
        return productBaseRepository.findAll();
    }

}
