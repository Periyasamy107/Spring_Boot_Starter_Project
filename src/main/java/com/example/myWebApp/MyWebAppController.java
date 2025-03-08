package com.example.myWebApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class MyWebAppController {

	@GetMapping(value = "/get")
	public String getValue() {
		return "Hello World";
	}

	@GetMapping(value = "/getValue/{input}")
	public String getInputValue(@PathVariable String input) {
		return input + " Nisha";
	}

	@GetMapping(value = "/getPrime/{number}")
	public String getNumber(@PathVariable int number) {

		boolean flag = true;

		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				flag = false;
			}
		}

		if (flag) {
			return number + " is a prime number";
		} else {
			return number + " is not a prime number";
		}
	}

	@GetMapping(value = "/printing/{number}")
	public int[] print10to1(@PathVariable int number) {
		int[] res = new int[number];
		int temp = number;
		for (int i = 0; i < number; i++) {
			res[i] = temp;
			temp--;
		}
		return res;
	}

	@GetMapping(value = "/print/{n1}/{n2}")
	public int [] simple(@PathVariable int n1, @PathVariable int n2) {

		int [] res = new int[n2+1];

		for (int i = n1; i <= n2; i++) {
			boolean flag = true;
			for(int j=2; j<i; j++) {
				if(i%j == 0) {
					flag = false;
				}
			if(flag==false) {
				res[i] = i;
				}
			}
		}
		return res;
	}

	
	
//	@GetMapping(value = "/pattern/{number}")
//	public List<Integer> patternPrint(@PathVariable Integer number) {
//		List<Integer>x=new ArrayList<>();
//		for (int i = 1; i <=number; i++) {
//			for (Integer j = 1; j <= i; j++) {
//				 x.get(i)=j;
//			}
//		}
//		return x;
//	}
	
	
	@GetMapping(value="/getAccess")
	public String getAccess(@RequestParam String username, @RequestParam String password) {
		if(username.equals("Nisha") && password.equals("nisha123")) {
			return "Access login";
		} else {
			return "Access denied";
		}
	}
	
	@GetMapping(value = "/getShirt")
	public String getShirt(@RequestBody Shirt s) {
		return s.getBrand();
	}
	
	

}
