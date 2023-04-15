package com.comit.caculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculatorController {
	@GetMapping("/")
    public String init() {
    	System.out.println("show caculator:this is get method for no parameter");
    	return "caculator";
    }	

}
