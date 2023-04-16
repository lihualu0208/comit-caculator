package com.comit.caculator.controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
	@GetMapping("/")
    public String init() {
    	System.out.println("show caculator:this is get method for no parameter");
    	return "caculator";
    }	
	@PostMapping("/calculator")
	public ModelAndView show(@RequestParam BigDecimal num1,
			           @RequestParam BigDecimal num2,
			           @RequestParam String operation) {
		
		System.out.println("show parameter:"+num1+"-"+num2+"-"+operation);
		BigDecimal result=BigDecimal.ZERO;
		switch (operation) {
		case "+" ->result=num1.add(num2);
		case "-" ->result=num1.subtract(num2);
		case "*" ->result=num1.multiply(num2);
		case "/" ->result=num1.divide(num2,MathContext.DECIMAL128);
		case "%" ->result=num1.remainder(num2);
		
		default ->throw new RuntimeException("invalid operation");
		}
		System.out.println("the result is:"+result);
		
		Map<String,String> model = new HashMap<>();
		model.put("num1", num1.toString());
		model.put("num2", num2.toString());
		model.put("operation", operation);
		model.put("res", result.toString());
		
	   return new ModelAndView("caculator",model);
		//return new ModelAndView("caculator","res",result);
	}

}
