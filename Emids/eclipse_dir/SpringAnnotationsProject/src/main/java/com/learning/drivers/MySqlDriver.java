package com.learning.drivers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:mysql.properties")
public class MySqlDriver implements DataBaseDrivers {

	@Value("${databaseName}")
	private String databaseName;
	@Value("${disableStatementPooling}")
	private String disableStatementPooling;

	@Override
	public String getInfo() {
		return "[ Driver: mySql" + ", databaseName: " + databaseName + ", disableStatementPooling: "
				+ disableStatementPooling + " ]";
	}
}
