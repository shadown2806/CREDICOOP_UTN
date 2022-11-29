package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
<<<<<<< HEAD

import com.credicoop.utn.entities.CustomizeArea;
import com.credicoop.utn.exceptions.customizedArea.CustomizeAreaNotFoundException;
=======
import com.credicoop.utn.entities.CustomizeArea;
import com.credicoop.utn.exceptions.product.ProductNotFoundException;
>>>>>>> 0206828f616645c2566379fb6b5b51e2730782c7
import com.credicoop.utn.repositories.CustomizeAreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomizeAreaService {

    private final CustomizeAreaRepository customizeAreaRepository;

<<<<<<< HEAD
    public CustomizeAreaService(CustomizeAreaRepository customizeAreaRepository){

        this.customizeAreaRepository = customizeAreaRepository;

=======
    public CustomizeAreaService (CustomizeAreaRepository customizeAreaRepository) {
        this.customizeAreaRepository = customizeAreaRepository;
>>>>>>> 0206828f616645c2566379fb6b5b51e2730782c7
    }

    public void addCustomizeArea(CustomizeArea customizeArea) {
        customizeAreaRepository.save(customizeArea);
    }

<<<<<<< HEAD
    public void deleteCustomizeArea(Long id) {

        if (!customizeAreaRepository.existsById(id)) {

            throw new CustomizeAreaNotFoundException(Constants.CUSTOMIZED_AREA_NOT_FOUND + id);

        }

        customizeAreaRepository.deleteById(id);

    }


=======
    public void deleteCustomizeArea(Long id){

        if (!customizeAreaRepository.existsById(id)){

            throw new ProductNotFoundException(Constants.CUSTOMIZED_AREA_NOT_FOUND + id);
        }
        customizeAreaRepository.deleteById(id);
    }

>>>>>>> 0206828f616645c2566379fb6b5b51e2730782c7
    public CustomizeArea getCustomizeArea(Long id) {

        Optional<CustomizeArea> customizeArea = customizeAreaRepository.findById(id);
        if (customizeArea.isEmpty()) {

<<<<<<< HEAD
            throw new CustomizeAreaNotFoundException(Constants.CUSTOMIZED_AREA_NOT_FOUND + id);

        }

        return customizeArea.get();

    }


=======
            throw new ProductNotFoundException(Constants.CUSTOMIZED_AREA_NOT_FOUND + id);

        }
        return customizeArea.get();
    }

>>>>>>> 0206828f616645c2566379fb6b5b51e2730782c7
    public List<CustomizeArea> getAllCustomizeArea() {
        return customizeAreaRepository.findAll();
    }

<<<<<<< HEAD

=======
>>>>>>> 0206828f616645c2566379fb6b5b51e2730782c7
}
