package com.credicoop.utn.mappers;

import com.credicoop.utn.dto.CustomizeAreaDTO;
import com.credicoop.utn.entities.CustomizeArea;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomizeAreaMapper {

<<<<<<< HEAD
    private final ModelMapper customizeAreaMapper;

    public CustomizeAreaMapper() {
        this.customizeAreaMapper = new ModelMapper();
    }


    public List<CustomizeAreaDTO> ListConvertToDto(List<CustomizeArea> customizeAreaList) {

        List<CustomizeAreaDTO> customizeAreaDTOS = new ArrayList<>();

        for (CustomizeArea customizeArea : customizeAreaList) {

            customizeAreaDTOS.add(customizeAreaMapper.map(customizeArea, CustomizeAreaDTO.class));

        }

        return customizeAreaDTOS;
=======
     private final ModelMapper customizeAreaMapper;


    public CustomizeAreaMapper(ModelMapper customizeMapper) {
        this.customizeAreaMapper = customizeMapper;
    }

    public List<CustomizeAreaDTO> ListConvertToDto(List<CustomizeArea> listCustomizeArea) {

        List<CustomizeAreaDTO> listCustomizeAreaDTO = new ArrayList<>();

        for (CustomizeArea customizeArea : listCustomizeArea) {

            listCustomizeAreaDTO.add(customizeAreaMapper.map(customizeArea, CustomizeAreaDTO.class));
        }

        return listCustomizeAreaDTO;
>>>>>>> 0206828f616645c2566379fb6b5b51e2730782c7
    }

    public CustomizeAreaDTO convertToDto(CustomizeArea customizeArea) {
        return customizeAreaMapper.map(customizeArea, CustomizeAreaDTO.class);
    }

    public CustomizeArea convertToEntity(CustomizeAreaDTO customizeAreaDTO) {
        return customizeAreaMapper.map(customizeAreaDTO, CustomizeArea.class);
    }

}
