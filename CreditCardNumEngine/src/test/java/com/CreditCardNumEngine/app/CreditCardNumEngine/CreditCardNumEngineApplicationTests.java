package com.CreditCardNumEngine.app.CreditCardNumEngine;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ccengine.bean.CCNumberBean;
import com.ccengine.bean.CCNumberResponseBean;
import com.ccengine.service.CreditCardNumberGenerator;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebAppConfiguration
@SpringBootTest
public class CreditCardNumEngineApplicationTests {

	@MockBean
	private CreditCardNumberGenerator ccgenerator;
	 @Autowired
	    private MockMvc mockMvc;

	@Test
	public void getAmexCCNumbers() {
		
			CCNumberResponseBean mockresp=new CCNumberResponseBean(new CCNumberBean[] { new CCNumberBean("3789823002293328",LocalDate.now()),new CCNumberBean("3789823002293928",LocalDate.now())});
		
		Mockito.when(
				ccgenerator.generateCardNumber("amex", 10)).thenReturn(mockresp);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/amex/1").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			System.out.println(result.getResponse());
			
			String expected = "{creaditCard:[{ccNumber:,expiryDate:},{ccNumber:,expiryDate:}]}";
			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

	}

	@Test
	public void getVisaCCNumbers() {
		
			CCNumberResponseBean mockresp=new CCNumberResponseBean(new CCNumberBean[] { new CCNumberBean("4789823002293328",LocalDate.now())});
		
		Mockito.when(
				ccgenerator.generateCardNumber("visa", 10)).thenReturn(mockresp);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/visa/1").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			System.out.println(result.getResponse());
			
			String expected = "{creaditCard:[{ccNumber:,expiryDate:},{ccNumber:,expiryDate:}]}";
			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

	}

	@Test
	public void getmasterCCNumbers() {
		
			CCNumberResponseBean mockresp=new CCNumberResponseBean(new CCNumberBean[] { new CCNumberBean("5789823002293328",LocalDate.now())});
		
		Mockito.when(
				ccgenerator.generateCardNumber("master", 10)).thenReturn(mockresp);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/master/1").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			System.out.println(result.getResponse());
			
			String expected = "{creaditCard:[{ccNumber:,expiryDate:},{ccNumber:,expiryDate:}]}";
			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

	}
	@Test
	public void getDiscoverCCNumbers() {
		
			CCNumberResponseBean mockresp=new CCNumberResponseBean(new CCNumberBean[] { new CCNumberBean("6789823002293328",LocalDate.now())});
		
		Mockito.when(
				ccgenerator.generateCardNumber("discover", 10)).thenReturn(mockresp);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/discover/1").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			System.out.println(result.getResponse());
			
			String expected = "{creaditCard:[{ccNumber:,expiryDate:},{ccNumber:,expiryDate:}]}";
			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

	}

}
