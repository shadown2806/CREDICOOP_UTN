package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.CustomizeDTO;
import com.credicoop.utn.entities.Customize;
import com.credicoop.utn.mappers.CustomizeMapper;
import com.credicoop.utn.services.CustomizeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customize/")
public class CustomizeController {

    private final CustomizeService customizeService;
    private final CustomizeMapper customizeMapper;


    public CustomizeController(CustomizeService customizeService, CustomizeMapper customizeMapper) {
        this.customizeService = customizeService;
        this.customizeMapper = customizeMapper;
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Customize createCustomize(@RequestBody CustomizeDTO customizeDTO){
        customizeDTO.setCreatedAt(LocalDate.now());
        Customize customize = customizeMapper.convertToEntity(customizeDTO);
        customizeService.addCustomize(customize);
        return customize;
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomize(@PathVariable("id") Long id){
        customizeService.deleteCustomize(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomizeDTO getCustomize(@PathVariable("id") Long id){
        Customize customize = customizeService.getCustomize(id);
        return customizeMapper.convertToDto(customize);
    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomizeDTO> getAllCustomize(){
        List<Customize> customize = customizeService.getAllCustomize();
        return customizeMapper.ListConvertToDto(customize);
    }
}
