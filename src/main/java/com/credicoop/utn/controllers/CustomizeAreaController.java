package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.CustomizeAreaDTO;
import com.credicoop.utn.entities.CustomizeArea;
import com.credicoop.utn.mappers.CustomizeAreaMapper;
import com.credicoop.utn.services.CustomizeAreaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customizedArea/")
=======
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customizeArea/")
>>>>>>> 0206828f616645c2566379fb6b5b51e2730782c7
public class CustomizeAreaController {

    private final CustomizeAreaService customizeAreaService;
    private final CustomizeAreaMapper customizeAreaMapper;

<<<<<<< HEAD
    public CustomizeAreaController(CustomizeAreaService customizeAreaService, CustomizeAreaMapper customizeAreaMapper){

        this.customizeAreaService = customizeAreaService;
        this.customizeAreaMapper = customizeAreaMapper;

    }


    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomizeArea(@RequestBody CustomizeAreaDTO customizeAreaDTO){


        CustomizeArea customizeArea = customizeAreaMapper.convertToEntity(customizeAreaDTO);
        customizeAreaService.addCustomizeArea(customizeArea);

=======
    public CustomizeAreaController(CustomizeAreaService customizeAreaService, CustomizeAreaMapper customizeAreaMapper) {
        this.customizeAreaService = customizeAreaService;
        this.customizeAreaMapper = customizeAreaMapper;
    }

}

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomize(@RequestBody CustomizeAreaDTO customizeAreaDTO){

        customizeAreaDTO.setCreatedAt(LocalDate.now());

        CustomizeArea customizeArea = customizeAreaMapper.convertToEntity(customizeAreaDTO);
        customizeAreaService.addCustomizeArea(customizeArea);
>>>>>>> 0206828f616645c2566379fb6b5b51e2730782c7
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomizeArea(@PathVariable("id") Long id){

        customizeAreaService.deleteCustomizeArea(id);
<<<<<<< HEAD

=======
>>>>>>> 0206828f616645c2566379fb6b5b51e2730782c7
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomizeAreaDTO getCustomizeArea(@PathVariable("id") Long id){

        CustomizeArea customizeArea = customizeAreaService.getCustomizeArea(id);
        return customizeAreaMapper.convertToDto(customizeArea);
<<<<<<< HEAD

=======
>>>>>>> 0206828f616645c2566379fb6b5b51e2730782c7
    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomizeAreaDTO> getAllCustomizeArea(){

<<<<<<< HEAD
        List<CustomizeArea> customizeAreaList = customizeAreaService.getAllCustomizeArea();
        return customizeAreaMapper.ListConvertToDto(customizeAreaList);
=======
        List<CustomizeArea> customizeArea = customizeAreaService.getAllCustomizeArea();
        return customizeAreaMapper.ListConvertToDto(customizeArea);
>>>>>>> 0206828f616645c2566379fb6b5b51e2730782c7
    }

}
