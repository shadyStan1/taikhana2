package com.learning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.learning.config.AppConfig;
import com.learning.drivers.DataBaseDrivers;
import com.learning.drivers.MySqlDriver;
import com.learning.drivers.OracleDriver;
import com.learning.service.UserDBService;

public class Main {
public static void main(String[] args) {

		AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		DataBaseDrivers oracle = appContext.getBean("oracleDriver", OracleDriver.class);

		DataBaseDrivers mysql = appContext.getBean("mysqlDriver", MySqlDriver.class);

		System.out.println("Oracle driver info:");
		System.out.println(oracle.getInfo());

		System.out.println("MySQL driver info:");
		System.out.println(mysql.getInfo());

		System.out.println("UserService Information");
		UserDBService userService = appContext.getBean(UserDBService.class);
		System.out.println(userService.getDriverInfo());

		appContext.close();
	}
}
	
