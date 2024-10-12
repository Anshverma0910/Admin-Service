package com.project.exception.restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestaurantNotFoundController {
    @ExceptionHandler(value = RestaurantNotFoundException.class)
    public ResponseEntity<Object> exception(RestaurantNotFoundException exception) {
        return new ResponseEntity<>("Sorry! Restaurant not found", HttpStatus.NOT_FOUND);
    }
}
