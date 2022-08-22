package APITestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.json.JSONObject;


import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PostRequest {

	@Test
	public void posttest() {
		JSONObject obj=new JSONObject();
		obj.put("id", "101");
		obj.put("name", "Vinay");
		obj.put("job", "QA");
		
		Response res= given().header("Accept","application/json")
				.body(obj.toString())
				.when()
				.post("https://reqres.in/api/users")
				.then().extract().response();
		
		System.out.println(res.asPrettyString());
		System.out.println(res.getStatusCode());
		//System.out.println(res.getContentType());
		System.out.println(res.getStatusLine());
		AssertJUnit.assertEquals(res.getStatusCode(), 201);
		
	}
	
	@Test
	public void postreqtest() {
		JSONObject obj=new JSONObject();
		obj.put("id", "102");
		obj.put("name","yugandhar");
		obj.put("job", "ewjnfhjueyu"
				+ ""
				+ "QA");
		
		given().header("Accept","application/json")
			
				.body(obj.toString())
				.when()
			
				.post("https://reqres.in/api/users")
				
				.then().log().all();
			
		
	/*	System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody());
		System.out.println(res.getHeader("content-length"));
		
		System.out.println(res.asString());
		Assert.assertEquals(res.getStatusCode(), 201);
		*/
	}
}
