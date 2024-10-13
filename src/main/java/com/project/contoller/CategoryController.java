package com.project.contoller;

import com.project.entity.Category;
import com.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/admin/category/add")
    public ResponseEntity<Object> add(@RequestBody Category category)
    {
        categoryService.addCategory(category);
        return new ResponseEntity<>("Category Added Successfully", HttpStatus.ACCEPTED);
    }

    @PostMapping("/admin/category/update/{id}")
    public ResponseEntity<Object> updateById(@RequestBody Category category,
                                             @PathVariable("id") int id)
    {
        return categoryService.updateById(id,category);
    }

    @DeleteMapping("/admin/category/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") int id)
    {
        return categoryService.deleteById(id);
    }

    @GetMapping("/category/view")
    public List<Category> view() {
        return categoryService.getAll();
    }

    @GetMapping("/category/{id}")
    public Category getById(@PathVariable("id") int id) {
        return categoryService.getById(id);
    }
}
