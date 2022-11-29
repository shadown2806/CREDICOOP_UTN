package com.credicoop.utn.mappers;

import com.credicoop.utn.dto.CustomizeAreaDTO;
import com.credicoop.utn.entities.CustomizeArea;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomizeAreaMapper {

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
    }

    public CustomizeAreaDTO convertToDto(CustomizeArea customizeArea) {
        return customizeAreaMapper.map(customizeArea, CustomizeAreaDTO.class);
    }

    public CustomizeArea convertToEntity(CustomizeAreaDTO customizeAreaDTO) {
        return customizeAreaMapper.map(customizeAreaDTO, CustomizeArea.class);
    }

}
