package com.project.serviceinterface;

import com.project.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductServiceInterface {

    public List<Product> getAll();

    public Product getById(int id);

    public ResponseEntity<Object> updateById(Product product, int id);

    public Product addProject(Product product);

    public ResponseEntity<Object> deleteById(int id);

    public String getPrice(int id);
}
