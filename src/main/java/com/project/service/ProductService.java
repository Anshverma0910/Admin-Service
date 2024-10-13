package com.project.service;

import com.project.entity.Product;
import com.project.exception.product.ProductNotFoundException;
import com.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    public Product getById(int id)
    {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
        {
            throw new ProductNotFoundException();
        }
        return product.get();
    }

    public ResponseEntity<Object> updateById(Product product, int id)
    {
        Product newProduct = getById(id);
        newProduct.setProductName(product.getProductName());
        newProduct.setProductPrice(product.getProductPrice());
        newProduct.setCategoryId(product.getCategoryId());
        productRepository.save(newProduct);
        return new ResponseEntity<>("Product Added Successfully", HttpStatus.OK);
    }

    public Product addProject(Product product)
    {
        return productRepository.save(product);
    }

    public ResponseEntity<Object> deleteById(int id)
    {
        getById(id);
        productRepository.deleteById(id);
        return new ResponseEntity<>("Product deleted Successfully",HttpStatus.OK);
    }

    public String getPrice(int id){
        System.out.println("hello ansh verma.........");
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()) return null;
        System.out.println("hello brother............");
        return product.get().getProductPrice();
    }
}
