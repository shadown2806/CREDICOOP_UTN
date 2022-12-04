package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;

import com.credicoop.utn.entities.CustomizeArea;
import com.credicoop.utn.exceptions.customizedArea.CustomizeAreaNotFoundException;
import com.credicoop.utn.entities.CustomizeArea;
import com.credicoop.utn.exceptions.product.ProductNotFoundException;
import com.credicoop.utn.repositories.CustomizeAreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomizeAreaService {

    private final CustomizeAreaRepository customizeAreaRepository;

    public CustomizeAreaService(CustomizeAreaRepository customizeAreaRepository){

        this.customizeAreaRepository = customizeAreaRepository;

    }

    public void addCustomizeArea(CustomizeArea customizeArea) {
        customizeAreaRepository.save(customizeArea);
    }

    public void deleteCustomizeArea(Long id) {

        if (!customizeAreaRepository.existsById(id)) {

            throw new CustomizeAreaNotFoundException(Constants.CUSTOMIZED_AREA_NOT_FOUND + id);

        }

        customizeAreaRepository.deleteById(id);

    }

    public CustomizeArea getCustomizeArea(Long id) {


        Optional<CustomizeArea> customizeArea = customizeAreaRepository.findById(id);
        if (customizeArea.isEmpty()) {

            throw new CustomizeAreaNotFoundException(Constants.CUSTOMIZED_AREA_NOT_FOUND + id);

        }

        return customizeArea.get();

    }

    public List<CustomizeArea> getAllCustomizeArea() {
        return customizeAreaRepository.findAll();
    }

}
