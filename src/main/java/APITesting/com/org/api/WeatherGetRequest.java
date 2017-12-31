package APITesting.com.org.api;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequest {
	//Simple get request
	//Valid key, Status code:200
	//@Test
	public void Test_01(){
		Response response=when().
							get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=cce28d34b9d580297f128e294433ec24");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	// Invalid Key, Status code=401
	//@Test
	public void Test_02(){
		Response response=when().
							get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=cce28d34b9d580297f128e294433ec2");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 401);
	}


    //How to use parameters with res assured.
	//@Test
	public void Test_03(){
		Response response=given().
							param("q", "London").
							param("appid", "cce28d34b9d580297f128e294433ec24").
							when().
							get("http://api.openweathermap.org/data/2.5/weather");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		if(response.getStatusCode()==200)
			System.out.println("API is working fine");
		else
			System.out.println("API is having some issue"+ response.getStatusCode());
	}
		
		//@Test
		public void Test_04(){
								given().
								param("q", "London").
								param("appid", "cce28d34b9d580297f128e294433ec24").
								when().
								get("http://api.openweathermap.org/data/2.5/weather").
								then().
								assertThat().
								statusCode(200);
	
	}
		
		//@Test
		public void Test_05(){
			Response response=given().
								param("q", "London").
								param("appid", "cce28d34b9d580297f128e294433ec24").
								when().
								get("http://api.openweathermap.org/data/2.5/weather");
							
			System.out.println(response.asString());
		
	}
		
	//@Test
	public void Test_06(){
		Response response=given().
				param("id", "2172797").
				param("appid", "cce28d34b9d580297f128e294433ec24").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		
				Assert.assertEquals(response.getStatusCode(), 200);
				System.out.println(response.getStatusCode());	
				
				System.out.println(response.asString());
	}
	
	//@Test
	public void Test_07(){
		Response response=given().
				param("zip", "560068,in").
				param("appid", "cce28d34b9d580297f128e294433ec24").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		
				Assert.assertEquals(response.getStatusCode(), 200);
				System.out.println(response.getStatusCode());
				System.out.println(response.asString());
	}
		
	
	//@Test
	public void Test_08(){
		String WheaterReport=given().
				param("id", "2172797").
				param("appid", "cce28d34b9d580297f128e294433ec24").
				when().
				get("http://api.openweathermap.org/data/2.5/weather").
				then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");
				
				//Assert.assertEquals(response.getStatusCode(), 200);
				//System.out.println(response.getStatusCode());
				System.out.println(WheaterReport);
	}
		
	//@Test
		public void Test_09(){
			Response response=given().
					param("id", "2172797").
					param("appid", "cce28d34b9d580297f128e294433ec24").
					when().
					get("http://api.openweathermap.org/data/2.5/weather");
			
			String actualWeather=response.
								then().
								contentType(ContentType.JSON).
								extract().
								path("weather[0].description");
			// expected condition get it from DB or developer.
			String expectedWheatherReport="scattered clouds";
			
			if(actualWeather.equalsIgnoreCase(expectedWheatherReport))
				System.out.println("Test Case is passed");
			else
				System.out.println("Test Case is failed");
					
		}
		
		@Test
		public void Test_10() throws IOException{
			Response response=given().
					param("id", "2172797").
					param("appid", "cce28d34b9d580297f128e294433ec24").
					when().
					get("http://api.openweathermap.org/data/2.5/weather");
			String reportID=response.
					 		then().
					 		contentType(ContentType.JSON).
					 		extract().
					 		path("weather[0].description");
			
			String longitude=String.valueOf(response.
							  then().
							  contentType(ContentType.JSON).
							  extract().
							  path("coord.lon"));
			System.out.println("Longitude is "+longitude);
			String latitude=String.valueOf(response.
					  then().
					  contentType(ContentType.JSON).
					  extract().
					  path("coord.lat"));
			System.out.println("Latitude is"+latitude);
			
			System.out.println("Weather description by ID:"+ reportID);
			
			String reportbyCordinates=given().
					param("lat",latitude ).
					param("lon",longitude).
					param("appid", "cce28d34b9d580297f128e294433ec24").
					when().
					get("http://api.openweathermap.org/data/2.5/weather").
					then().
					contentType(ContentType.JSON).
					extract().
					path("weather[0].description");
			
			System.out.println("Report by coordianates:"+reportbyCordinates );
			Assert.assertEquals(reportID,reportbyCordinates);
			
			 FileWriter file = new FileWriter("C:\\Users\\Murali\\Desktop\\sample.json");
			    file.write(response.asString());
			    file.flush();
			    file.close();

			
		}
		}

