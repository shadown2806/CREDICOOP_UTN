package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.CustomizeAreaDTO;
import com.credicoop.utn.dto.ManagerDTO;
import com.credicoop.utn.dto.ProductBaseDTO;
import com.credicoop.utn.entities.Manager;
import com.credicoop.utn.mappers.ManagerMapper;
import com.credicoop.utn.services.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/manager/")
public class ManagerController {

    private final ManagerService managerService;
    private final ManagerMapper managerMapper;

    public ManagerController(ManagerService managerService, ManagerMapper managerMapper) {
        this.managerService = managerService;
        this.managerMapper = managerMapper;
    }

    @PostMapping(value = "{managerId}/add/customizeAreaByManager")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomizeAreaByManager(@RequestBody CustomizeAreaDTO customizeAreaDTO, @PathVariable String managerId){
        managerService.addCustomizeAreaByManager(customizeAreaDTO, managerId);
    }

    @PostMapping(value = "{managerId}/add/productBaseByManager")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProductBaseByManager(@RequestBody ProductBaseDTO productBaseDTO, @PathVariable String managerId){
        managerService.addProductBaseByManager(productBaseDTO, managerId);
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createManager(@RequestBody ManagerDTO managerDTO){
        Manager manager = managerMapper.convertToEntity(managerDTO);
        managerService.addManager(manager);
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteManager(@PathVariable("id") Long id){
        managerService.deleteManager(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ManagerDTO getManager(@PathVariable("id") Long id){
        Manager manager = managerService.getManager(id);
        return managerMapper.convertToDto(manager);
    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<ManagerDTO> getAllManager(){
        List<Manager> manager = managerService.getAllManager();
        return managerMapper.ListConvertToDto(manager);
    }
}
