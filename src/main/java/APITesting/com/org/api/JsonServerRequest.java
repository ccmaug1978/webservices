package APITesting.com.org.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import APITesting.com.org.classes.Posts;
import APITesting.com.org.classes.info;
import APITesting.com.org.classesAdvanced._Post;
import APITesting.com.org.classesAdvanced._info;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

public class JsonServerRequest {
	//GET    /posts
	//@Test
	public void test_01(){
		Response response=given().
						then().
						get("http://localhost:3000/posts");
		System.out.println(response.asString());
	}

	//POST   /posts
	//@Test
	public void test_02(){
		Response response=given().
						  body("{\"id\":\"3\","
						  		+ "\"title\":\"dummy1\","
						  		+ "\"author\":\"Murali\"}").
						  when().
						  contentType(ContentType.JSON).
						  post("http://localhost:3000/posts");
		
		System.out.println(response.asString());
						  
	}
	//POST   /posts
		//@Test
		public void test_03(){
			Posts posts=new Posts();
			posts.setId("4");
			posts.setTitle("dummy4");
			posts.setAuthor("Murali");
			Response response=given().
							  when().
							  contentType(ContentType.JSON).
							  body(posts).
							  post("http://localhost:3000/posts");
			
			System.out.println(response.asString());
							  
		}
		//GET    /posts/1
			//@Test
				public void test_04(){
					
					Response response=given().
									  when().
									  contentType(ContentType.JSON).
									  get("http://localhost:3000/posts/3");
					
					System.out.println(response.asString());
									  
				}
			
			//PUT    /posts/1 // update the existing record.
			//@Test
			public void test_05(){
				Posts posts=new Posts();
				posts.setId("4");
				posts.setTitle("Updated Title Name");
				posts.setAuthor("Updated Author Name");
				Response response=given().
								  when().
								  contentType(ContentType.JSON).
								  body(posts).
								  put("http://localhost:3000/posts/4");
				
				System.out.println(response.asString());
								  
			}
			//PATCH - Only send data which need to be updated.
			//PATCH  /posts/1
			//@Test
			public void test_06(){
				//Posts posts=new Posts();
				//posts.setAuthor("Murali Chennaveerappa");
				Response response=given().
								  when().
								  contentType(ContentType.JSON).
								  body("{\"title\":\"dummy4.1\"}").
								  patch("http://localhost:3000/posts/4");
				
				System.out.println(response.asString());
								  
			}
			//Delete - DELETE /posts/1
		//	@Test
			public void test_07(){
				Response response=given().
								  when().
								  delete("http://localhost:3000/posts/4");
				
				System.out.println(response.getStatusCode()+ response.asString());
								  
			}
			
			//Delete - DELETE /posts/1
			//@Test
			public void test_08(){
				info infomation=new info();
				infomation.setEmail("lion.king@gmail.com");
				infomation.setPhone("1234512345");
				infomation.setAddrees("Malleshwaram");
				APITesting.com.org.classes._Posts posts=new APITesting.com.org.classes._Posts();
				posts.setId("2");
				posts.setAuthor("Harshi");
				posts.setTitle("defualt Author Harshi");
				posts.setInfo(infomation);
				
				Response response=given().
								  when().
								  contentType(ContentType.JSON).
								  body(posts).
								  post("http://localhost:3000/posts");
				
				System.out.println(response.getStatusCode()+"\n"+response.asString());
			  
		
			}
			
			//@Test
			public void test_09(){
				_info infomation1=new _info();
				infomation1.setEmail("lion.king@gmail.com1");
				infomation1.setPhone("12345123451");
				infomation1.setAddrees("Malleshwaram1");
				_info infomation2=new _info();
				infomation2.setEmail("lion.king@gmail.com2");
				infomation2.setPhone("12345123452");
				infomation2.setAddrees("Malleshwaram2");
				_Post posts=new _Post();
				posts.setId("5");
				posts.setAuthor("Harshi_KUSHI");
				posts.setTitle("defualt Author HK");
				posts.setInfo(new _info[]{infomation1,infomation2});
				
				Response response=given().
								  when().
								  contentType(ContentType.JSON).
								  body(posts).
								  post("http://localhost:3000/posts");
				
				System.out.println(response.getStatusCode()+"\n"+response.asString());
			  
		
			}
			
			//Time taken for the webservice to process
			@Test
			public void test_10(){
				
				Response response=given().
								  when().
								  get("http://localhost:3000/posts");
				//Time returned in milliseconds.
				Long time=response.then().
						extract().
						time();
				
				System.out.println(time);
				
				// you can use as below for assertion. 
				 		given().
						  when().
						  get("http://localhost:3000/posts").
						  then().
						  and().
						  time(lessThan(800L));
				
				
			
			}
}
