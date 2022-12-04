package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.CategoryDTO;
import com.credicoop.utn.entities.Category;
import com.credicoop.utn.mappers.CategoryMapper;
import com.credicoop.utn.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/category/")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper){
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody CategoryDTO categoryDTO){
        Category category = categoryMapper.convertToEntity(categoryDTO);
        categoryService.addCategory(category);

    }

    @DeleteMapping(value = "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategory(@PathVariable("id") Long id){
        Category category = categoryService.getCategory(id);
        return categoryMapper.convertToDto(category);
    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getAllCategory(){
        List<Category> categoryList = categoryService.getAllCategory();
        return categoryMapper.ListConvertToDto(categoryList);
    }
}
