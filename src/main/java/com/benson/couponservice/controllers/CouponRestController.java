package com.benson.couponservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.benson.couponservice.model.Coupon;
import com.benson.couponservice.repository.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	@Autowired
	CouponRepo couponRepo;
	
	@RequestMapping(value = "/coupon", method = RequestMethod.POST )
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		couponRepo.save(coupon);
		return coupon;
	}

	@RequestMapping(value = "/coupons/{code}", method = RequestMethod.GET )
	public Coupon findCoupon(@PathVariable("code") String code) {
		
		return couponRepo.findByCode(code);
	}
	
}
