package com.mockito.demo.MockitoPractice;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculatorClassTest {

	CalculatorClass c = null;
	CalculatorService service = Mockito.mock(CalculatorService.class);
	
	@Before
	public void setUp(){
		c = new CalculatorClass(service);
	}
	@Test
	public void test() {
		
		Mockito.when(service.add(2, 3)).thenReturn(5);
		assertEquals(10, c.perform(2, 3));
		Mockito.verify(service).add(2, 3);
	}

}
