package com.mockito.demo.MockitoPractice;

public class CalculatorClass {

	CalculatorService service;
	
	public CalculatorClass(CalculatorService service) {
		this.service = service;
	}

	
	public int perform(int i, int j){
		
		return service.add(i, j)*i;
	}
}
