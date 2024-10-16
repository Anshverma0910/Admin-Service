package com.project.service;

import com.project.entity.Category;
import com.project.exception.category.CategoryNotFoundException;
import com.project.repository.CategoryRepository;
import com.project.serviceinterface.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CategoryServiceInterface {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll()
    {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category)
    {
        return categoryRepository.save(category);
    }

    @Override
    public Category getById(int id)
    {
        Optional<Category> getCategory = categoryRepository.findById(id);
        if(getCategory.isEmpty()){
            throw new CategoryNotFoundException();
        }
        return getCategory.get();
    }

    @Override
    public ResponseEntity<Object> updateById(int id, Category category)
    {
        Category newcategory = getById(id);
        newcategory.setCategoryName(category.getCategoryName());
        newcategory.setCategoryDscription(category.getCategoryDscription());
        newcategory.setRestaurantId(category.getRestaurantId());
        newcategory.setProducts(category.getProducts());
        categoryRepository.save(newcategory);
        return new ResponseEntity<>("Category added Successfully...", HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Object> deleteById(int id)
    {
        getById(id);
        categoryRepository.deleteById(id);
        return new ResponseEntity<>("Category deleted Successfully...",HttpStatus.OK);
    }
}
