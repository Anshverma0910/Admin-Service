package com.project.exception.discountcoupon;

import com.project.exception.product.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CouponNotFoundController {
    @ExceptionHandler(value = CouponNotFoundException.class)
    public ResponseEntity<Object> exception(CouponNotFoundException exception) {
        return new ResponseEntity<>("Sorry! Invalid Coupon", HttpStatus.NOT_FOUND);
    }
}
