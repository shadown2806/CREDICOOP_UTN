package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.entities.Customize;
import com.credicoop.utn.exceptions.product.ProductNotFoundException;
import com.credicoop.utn.repositories.CustomizeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomizeService {
    private final CustomizeRepository customizeRepository;

    public CustomizeService(CustomizeRepository CustomizeRepository) {
        this.customizeRepository = customizeRepository;
    }

    public void addCustomize(Customize customize) {
        customizeRepository.save(customize);
    }

    public void deleteCustomize(Long id) {

        if (!customizeRepository.existsById(id)) {

            throw new ProductNotFoundException(Constants.SELLER_NOT_FOUND + id);
        }
        customizeRepository.deleteById(id);
    }

    public Customize getCustomize(Long id) {

        Optional<Customize> customize = customizeRepository.findById(id);
        if (customize.isEmpty()) {

            throw new ProductNotFoundException(Constants.CUSTOMIZED_PRODUCT_NOT_FOUND + id);

        }
        return customize.get();
    }

    public List<Customize> getAllCustomize() {
        return customizeRepository.findAll();
    }

}
