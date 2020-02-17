package com.algorithm.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewTest1 {

	static List<Map<String, Object>> personalizeCoupons(List<Map<String, Object>> coupons,
			List<String> preferredCategories) {
		List<Map<String, Object>> filterredCoupons = new ArrayList<>();
		filterredCoupons = coupons.stream().filter(c->preferredCategories.contains(c.get("category"))).sorted((m1,m2)->Float.compare((float)m2.get("couponAmount")/((float)m2.get("itemPrice")-(float)m2.get("couponAmount")), (float)m1.get("couponAmount")/((float)m1.get("itemPrice")-(float)m1.get("couponAmount")))).limit(10).collect(Collectors.toList());
		filterredCoupons.forEach(map -> map.entrySet().removeIf(entry -> entry.getKey().equals("code")));
		return filterredCoupons;
	}
	
	static List<Map<String, Object>> validateCards(String[] bannedPrefixes, String[] cardsToValidate) {

		List<Map<String, Object>> list = new ArrayList<>();
		for(String s : cardsToValidate) {
			Map<String, Object> map = new HashMap<>();
			map.put("card", s);
			int sum = 0;
			for(int i=0; i<s.length()-1; i++) {
				sum += Character.getNumericValue(s.charAt(i))*2;
			}
			if(sum%10!=Character.getNumericValue(s.charAt(s.length()-1))) {
				map.put("isValid", false);
			} else {
				map.put("isValid", true);
			}
			if(Stream.of(bannedPrefixes).anyMatch(s::startsWith)) {
				map.put("isAllowed", false);
			} else {
				map.put("isAllowed", true);
			}
			list.add(map);
		}
		
		return list;
		
    }
	
	public static void main(String[] args) {
		int sum = 0;
		String s = "6724843711060148";
		for(int i=0; i<s.length()-1; i++) {
			System.out.println(Character.getNumericValue(s.charAt(i)));
			sum += Character.getNumericValue(s.charAt(i))*2;
		}
		System.out.println(sum%10);
		if(sum%10!=Character.getNumericValue(s.charAt(s.length()-1))) {
			System.out.println(false);
		} else {
			System.out.println(true);
		}
	}

}
