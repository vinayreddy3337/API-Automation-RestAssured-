package APITestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static io.restassured.RestAssured.*;




import io.restassured.response.Response;

public class GetRequest  {

	@Test
	public void getrequest() {
		
		Response res=given().header("Accept","application/json")
				.when()
				
				.get("https://reqres.in/api/users?page=2")
				.then().extract().response();
		
		System.out.println(res.asPrettyString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
		
		
		AssertJUnit.assertEquals(res.statusCode(),200);
		//Assert.assertEquals(res.getContentType(), "application/json");

		
	}
	
    @Test
	public void GetTest() {
		
    	Response res=given().header("Accept","application/json")
    			.when()
    			.get("https://reqres.in/api/users/2")
    			.then().extract().response();
    	System.out.println(res.asPrettyString());
    	System.out.println(res.getStatusCode());
    	System.out.println(res.getContentType());
    	System.out.println(res.getStatusLine());
    	
    	AssertJUnit.assertEquals(res.getStatusCode(), 200);
    	//Assert.assertEquals(res.getContentType(), "application/json");
    			
	}
}
