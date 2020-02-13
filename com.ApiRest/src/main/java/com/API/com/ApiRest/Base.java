package com.API.com.ApiRest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
	
	public String readPropertiesFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(new File("/Users/568650/Documents/Selenium/com.ApiRest/src/main/java/resource/config.properties"));
		
		Properties prop=new Properties();
		
		prop.load(fis);
		
		String value=prop.getProperty(key);
		
		return value;
	}
	
	
	
	
	

}
