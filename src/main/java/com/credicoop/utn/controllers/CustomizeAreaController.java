package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.CustomizeAreaDTO;
import com.credicoop.utn.entities.CustomizeArea;
import com.credicoop.utn.mappers.CustomizeAreaMapper;
import com.credicoop.utn.services.CustomizeAreaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customizedArea/")
public class CustomizeAreaController {

    private final CustomizeAreaService customizeAreaService;
    private final CustomizeAreaMapper customizeAreaMapper;

    public CustomizeAreaController(CustomizeAreaService customizeAreaService, CustomizeAreaMapper customizeAreaMapper){

        this.customizeAreaService = customizeAreaService;
        this.customizeAreaMapper = customizeAreaMapper;

    }


    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomizeArea(@RequestBody CustomizeAreaDTO customizeAreaDTO){


        CustomizeArea customizeArea = customizeAreaMapper.convertToEntity(customizeAreaDTO);
        customizeAreaService.addCustomizeArea(customizeArea);

    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomizeArea(@PathVariable("id") Long id){

        customizeAreaService.deleteCustomizeArea(id);

    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomizeAreaDTO getCustomizeArea(@PathVariable("id") Long id){

        CustomizeArea customizeArea = customizeAreaService.getCustomizeArea(id);
        return customizeAreaMapper.convertToDto(customizeArea);

    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomizeAreaDTO> getAllCustomizeArea(){

        List<CustomizeArea> customizeAreaList = customizeAreaService.getAllCustomizeArea();
        return customizeAreaMapper.ListConvertToDto(customizeAreaList);
    }

}
