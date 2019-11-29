package com.time.instant;

import java.time.Duration;
import java.time.Instant;

public class InstantDemo1 {
	public static void main(String[] args) {
		Instant instant = Instant.now();  
	    instant = instant.minus(Duration.ofDays(125));  
	    System.out.println(instant);   
	}

}
