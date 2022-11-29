package com.credicoop.utn.mappers;

import com.credicoop.utn.dto.ManagerDTO;
import com.credicoop.utn.entities.Manager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManagerMapper {

    private final ModelMapper managerMapper;

    public ManagerMapper(ModelMapper managerMapper) {
        this.managerMapper = managerMapper;
    }

    public List<ManagerDTO> ListConvertToDto(List<Manager> listManager) {

        List<ManagerDTO> listManagerDTO = new ArrayList<>();

        for (Manager manager : listManager) {

            listManagerDTO.add(managerMapper.map(manager, ManagerDTO.class));
        }

        return listManagerDTO;
    }

    public ManagerDTO convertToDto(Manager manager) {
        ManagerDTO managerDTO = managerMapper.map(manager, ManagerDTO.class);
        return managerDTO;
    }

    public Manager convertToEntity(ManagerDTO managerDTO) {
        Manager manager = managerMapper.map(managerDTO, Manager.class);
        return manager;
    }

}
