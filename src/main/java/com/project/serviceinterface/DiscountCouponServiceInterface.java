package com.project.serviceinterface;

import com.project.entity.DiscountCoupon;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DiscountCouponServiceInterface {

    public List<DiscountCoupon> getAll();

    public ResponseEntity<Object> addDiscount(DiscountCoupon discountCoupon);

    public ResponseEntity<Object> deleteById(String id);

    public ResponseEntity<Object> updateById(String id, DiscountCoupon discountCoupon);

    public DiscountCoupon getById(String id);

    public int getCouponById(String couponName);

    public int getPercent(String couponName);
}
