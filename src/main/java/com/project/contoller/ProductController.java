package com.project.contoller;

import com.project.entity.Category;
import com.project.entity.Product;
import com.project.entity.Restaurant;
import com.project.service.CategoryService;
import com.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/product/view")
    public List<Product> view()
    {
        return productService.getAll();
    }

    @GetMapping("product/{id}")
    public Product getById(@PathVariable("id") int id)
    {
        return productService.getById(id);
    }

    @PostMapping("/admin/product/add")
    public ResponseEntity<Object> add(@RequestBody Product product)
    {
        productService.addProject(product);
        return new ResponseEntity<>("Product Added Successfully", HttpStatus.ACCEPTED);
    }

    @PostMapping("/admin/product/update/{id}")
    public ResponseEntity<Object> updateById(@RequestBody Product product,
                                             @PathVariable("id") int id)
    {
        return productService.updateById(product,id);
    }

    @GetMapping("/product/price/{id}")
    public String getPrice(@PathVariable("id") int id)
    {
        return productService.getPrice(id);
    }

    @DeleteMapping("/admin/product/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") int id)
    {
        return productService.deleteById(id);
    }
}
