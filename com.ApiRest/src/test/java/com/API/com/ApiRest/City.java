package com.API.com.ApiRest;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class City extends Base{
	
	
	Response response;
	
	@Test
	public void getCity() throws IOException
	{
		String baseuri=readPropertiesFile("host");
		
		response=RestAssured.given()
				.baseUri(baseuri)
				.basePath("utilities/weather/city/Hyderabad")
				.get();
		
		System.out.println(response.asString());
	}

}
