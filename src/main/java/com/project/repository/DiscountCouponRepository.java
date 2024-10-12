package com.project.repository;

import com.project.entity.DiscountCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountCouponRepository extends JpaRepository<DiscountCoupon,String> {
}
