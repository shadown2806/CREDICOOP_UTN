package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.entities.Manager;
import com.credicoop.utn.exceptions.manager.ManagerNotFoundException;
import com.credicoop.utn.repositories.ManagerRepository;
import org.springframework.stereotype.Service;

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

    public Manager getManager(Long id) {

        Optional<Manager> manager = managerRepository.findById(id);
        if (!manager.isPresent()) {

            throw new ManagerNotFoundException(Constants.MANAGER_NOT_FOUND + id);
        }
        return manager.get();
    }

    public List<Manager> getAllManager() {
        return managerRepository.findAll();
    }

}
