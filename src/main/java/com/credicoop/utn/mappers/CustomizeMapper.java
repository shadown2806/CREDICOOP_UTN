package com.credicoop.utn.mappers;

import com.credicoop.utn.dto.CustomizeDTO;
import com.credicoop.utn.entities.Customize;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomizeMapper {

    private final ModelMapper customizeMapper;

    public CustomizeMapper(ModelMapper customizeMapper) {
        this.customizeMapper = customizeMapper;
    }

    public List<CustomizeDTO> ListConvertToDto(List<Customize> listCustomize) {

        List<CustomizeDTO> listCustomizeDTO = new ArrayList<>();

        for (Customize customize : listCustomize) {

            listCustomizeDTO.add(customizeMapper.map(customize, CustomizeDTO.class));

        }

        return listCustomizeDTO;
    }

    public CustomizeDTO convertToDto(Customize customize) {
        return customizeMapper.map(customize, CustomizeDTO.class);
    }

    public Customize convertToEntity(CustomizeDTO customizeDTO) {
        return customizeMapper.map(customizeDTO, Customize.class);
    }

}
