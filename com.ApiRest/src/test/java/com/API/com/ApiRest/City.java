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
	
		@Test
	public void getTemp() throws IOException
	{
		String baseuri=readPropertiesFile("host");
		response=RestAssured.given()
				.baseUri(baseuri)
				.basePath("utilities/weather/city/Hyderabad")
				.get();
		
		JsonPath js=response.jsonPath();
		
		String wind=js.getString("WindSpeed");
		
		System.out.println("The wind speed is :"+wind);
	}
	
	@Test
	public void getHeaders() throws IOException
	{
		String baseuri=readPropertiesFile("host");
		
		response=RestAssured.given()
				.baseUri(baseuri)
				.basePath("utilities/weather/city/Hyderabad")
				.get();
		
		Headers allheaders=response.headers();
		
		for (io.restassured.http.Header header : allheaders)
		{
			
			 System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
			
		}

	}
	
	@Test
	public void queryparam() throws IOException
	{
		String baseuri=readPropertiesFile("host1");
		
		response=RestAssured.given()
				.baseUri(baseuri)
				.queryParam("q","London,UK")
				.queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
				.basePath("/weather")
				.get();
		
		String Sbody=response.getBody().prettyPrint();
		
		System.out.println(Sbody);
				
				
	}

}
