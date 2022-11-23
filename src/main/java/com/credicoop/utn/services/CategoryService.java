package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.entities.Category;
import com.credicoop.utn.entities.ProductBase;
import com.credicoop.utn.exceptions.category.CategoryNotFoundException;
import com.credicoop.utn.exceptions.product.ProductNotFoundException;
import com.credicoop.utn.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository){

        this.categoryRepository = categoryRepository;

    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {

        if (!categoryRepository.existsById(id)) {

            throw new CategoryNotFoundException(Constants.CATEGORY_NOT_FOUND + id);

        }

        categoryRepository.deleteById(id);

    }


    public Category getCategory(Long id) {

        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {

            throw new CategoryNotFoundException(Constants.CATEGORY_NOT_FOUND + id);

        }

        return category.get();

    }


    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }



}
