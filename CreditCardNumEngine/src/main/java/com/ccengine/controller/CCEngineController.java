package com.ccengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccengine.bean.CCNumberResponseBean;
import com.ccengine.service.CreditCardNumberGenerator;





@RestController
@RequestMapping(path="/CCEngine" )
@ComponentScan({"com.ccengine.bean","com.ccengine.service"})
@SpringBootApplication
public class CCEngineController  extends SpringBootServletInitializer{
	
	@Autowired
	CreditCardNumberGenerator ccgenerator;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CCEngineController.class, args);
	}
		
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CCEngineController.class);
	}

	@GetMapping
	@RequestMapping(value = "/visa/{no}")
	public CCNumberResponseBean getVisaCCNumbers(@PathVariable("no") int noOfCards)
	{
		return ccgenerator.generateCardNumber("VISA",noOfCards);
		
	}
	
	@GetMapping
	@RequestMapping(value = "/amex/{no}")
	public CCNumberResponseBean getAmexCCNumbers(@PathVariable("no") int noOfCards)
	{
		return ccgenerator.generateCardNumber("AMEX",noOfCards);
		
	}

	@GetMapping
	@RequestMapping(value = "/master/{no}")
	public CCNumberResponseBean getMastercardCCNumbers(@PathVariable("no") int noOfCards)
	{
		return ccgenerator.generateCardNumber("MASTERCARD",noOfCards);
		
	}
	
	@GetMapping
	@RequestMapping(value = "/discover/{no}")
	public CCNumberResponseBean getDiscoverCCNumbers(@PathVariable("no") int noOfCards)
	{
		return ccgenerator.generateCardNumber("DISCOVER",noOfCards);
		
	}

		

}
