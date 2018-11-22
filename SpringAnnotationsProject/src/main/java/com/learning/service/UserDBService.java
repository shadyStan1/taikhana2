package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learning.drivers.DataBaseDrivers;

@Service
public class UserDBService {

	@Autowired
	@Qualifier("mysqlDriver")
    private DataBaseDrivers dataBaseDriver;
	
    public String getDriverInfo(){
        return dataBaseDriver.getInfo();
    }	
}
