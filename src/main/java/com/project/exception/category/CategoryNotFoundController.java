package com.project.exception.category;

import com.project.exception.restaurant.RestaurantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryNotFoundController {
    @ExceptionHandler(value = CategoryNotFoundException.class)
    public ResponseEntity<Object> exception(CategoryNotFoundException exception) {
        return new ResponseEntity<>("Sorry! Category not found", HttpStatus.NOT_FOUND);
    }
}
