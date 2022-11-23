package com.credicoop.utn.mappers;

import com.credicoop.utn.dto.CategoryDTO;
import com.credicoop.utn.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    private final ModelMapper categoryMapper;
    public CategoryMapper(){this.categoryMapper = new ModelMapper();}

    public List<CategoryDTO> ListConvertToDto(List<Category> listCategory){

        List<CategoryDTO> listCategoryDTO = new ArrayList<>();

        for (Category category : listCategory) {

            listCategoryDTO.add(categoryMapper.map(category, CategoryDTO.class));

        }

        return listCategoryDTO;

    }

    public CategoryDTO convertToDto(Category category) {
        return categoryMapper.map(category, CategoryDTO.class);
    }

    public Category convertToEntity(CategoryDTO categoryDTO) {
        return categoryMapper.map(categoryDTO, Category.class);
    }

}
