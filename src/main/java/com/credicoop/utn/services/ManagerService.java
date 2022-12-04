package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.dto.CustomizeAreaDTO;
import com.credicoop.utn.dto.ManagerDTO;
import com.credicoop.utn.dto.ProductBaseDTO;
import com.credicoop.utn.entities.Manager;

import com.credicoop.utn.exceptions.manager.ManagerNotFoundException;
import com.credicoop.utn.repositories.ManagerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public void addManager(Manager manager) {
        managerRepository.save(manager);
    }

    public void deleteManager(Long id) {

        if (!managerRepository.existsById(id)) {

            throw new ManagerNotFoundException(Constants.MANAGER_NOT_FOUND + id);
        }
        managerRepository.deleteById(id);
    }

    public void addCustomizeAreaByManager(CustomizeAreaDTO customizeAreaDTO, String managerId){

        ResponseEntity<ManagerDTO> consultCusomizeArea = new RestTemplate().getForEntity ("http://localhost:8080/api/v1/manager/" + managerId, ManagerDTO.class);

        if(!consultCusomizeArea.getStatusCode().isError()){

            //enviar datos de este controller al otro.
            new RestTemplate().postForLocation("http://localhost:8080/api/v1/customizeArea/add", customizeAreaDTO);

        }

    }

    public void addProductBaseByManager(ProductBaseDTO productBaseDTO, String managerId){


        productBaseDTO.setManagerId(Long.parseLong(managerId));

        ResponseEntity<ManagerDTO> consultManager = new RestTemplate().getForEntity ("http://localhost:8080/api/v1/manager/" + managerId, ManagerDTO.class);
        ResponseEntity<CustomizeAreaDTO> consultCustomizeArea = new RestTemplate().getForEntity ("http://localhost:8080/api/v1/customizeArea/" + productBaseDTO.getCustomizeAreaId(), CustomizeAreaDTO.class);




        if(!consultManager.getStatusCode().isError() && !consultCustomizeArea.getStatusCode().isError()){

            //enviar datos de este controller al otro.
            new RestTemplate().postForLocation("http://localhost:8080/api/v1/productsBase/add", productBaseDTO);

        }

    }

    public Manager getManager(Long id) {

        Optional<Manager> manager = managerRepository.findById(id);
        if (manager.isEmpty()) {

            throw new ManagerNotFoundException(Constants.MANAGER_NOT_FOUND + id);
        }
        return manager.get();
    }

    public List<Manager> getAllManager() {
        return managerRepository.findAll();
    }

}
