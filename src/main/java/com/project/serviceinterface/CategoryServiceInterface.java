package com.project.serviceinterface;

import com.project.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryServiceInterface {

    public List<Category> getAll();

    public Category addCategory(Category category);

    public Category getById(int id);

    public ResponseEntity<Object> updateById(int id, Category category);

    public ResponseEntity<Object> deleteById(int id);
}
