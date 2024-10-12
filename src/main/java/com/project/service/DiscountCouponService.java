package com.project.service;

import com.project.entity.DiscountCoupon;
import com.project.exception.discountcoupon.CouponNotFoundException;
import com.project.repository.DiscountCouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountCouponService {

    @Autowired
    private DiscountCouponRepository discountCouponRepository;

    public List<DiscountCoupon> getAll()
    {
        return discountCouponRepository.findAll();
    }

    public ResponseEntity<Object> addDiscount(DiscountCoupon discountCoupon)
    {
        discountCouponRepository.save(discountCoupon);
        return new ResponseEntity<>("Discount added Successfully", HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteById(String id)
    {
        getById(id);
        discountCouponRepository.deleteById(id);
        return new ResponseEntity<>("Coupon deleted Successfully...",HttpStatus.OK);
    }

    public ResponseEntity<Object> updateById(String id, DiscountCoupon discountCoupon)
    {
        DiscountCoupon newDiscountCoupon = getById(id);
        newDiscountCoupon.setCouponCondition(discountCoupon.getCouponCondition());
        newDiscountCoupon.setCouponPercentage(discountCoupon.getCouponPercentage());
        discountCouponRepository.save(newDiscountCoupon);
        return new ResponseEntity<>("Coupon updated Successfully...",HttpStatus.OK);
    }

    public DiscountCoupon getById(String id)
    {
        Optional<DiscountCoupon> discountCoupon = discountCouponRepository.findById(id);
        if(discountCoupon.isEmpty())
        {
            throw new CouponNotFoundException();
        }
        return discountCoupon.get();
    }

}
