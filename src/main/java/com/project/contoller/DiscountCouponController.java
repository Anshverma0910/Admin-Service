package com.project.contoller;

import com.project.entity.DiscountCoupon;

import com.project.service.DiscountCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountCouponController {

    @Autowired
    private DiscountCouponService discountCouponService;

    @GetMapping("coupon/view")
    public List<DiscountCoupon> view() {
        return discountCouponService.getAll();
    }

    @GetMapping("coupon/{id}")
    public DiscountCoupon getById(@PathVariable("id") String id) {
        return discountCouponService.getById(id);
    }

    @GetMapping("/access/coupon/condition/{id}")
    public int getCouponById(@PathVariable("id") String id) {
        return discountCouponService.getCouponById(id);
    }

    @GetMapping("/access/coupon/discount/{id}")
    public int getPercent(@PathVariable("id") String id) {
        return discountCouponService.getPercent(id);
    }

    @PostMapping("/admin/coupon/update/{id}")
    public ResponseEntity<Object> updateById(@RequestBody DiscountCoupon discountCoupon,
                                             @PathVariable("id") String id)
    {
        return discountCouponService.updateById(id,discountCoupon);
    }

    @DeleteMapping("/admin/coupon/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") String id)
    {
        return discountCouponService.deleteById(id);
    }

    @PostMapping("/admin/coupon/add")
    public ResponseEntity<Object> addCoupon(@RequestBody DiscountCoupon discountCoupon)
    {
        return discountCouponService.addDiscount(discountCoupon);
    }
}
