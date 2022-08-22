package APITestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.json.JSONObject;

import io.restassured.response.Response;
import static  io.restassured.RestAssured.*;

public class PutRequest {

	@Test
	public void puttest() {
		
		JSONObject obj=new JSONObject();
		obj.put("id", "102");
		obj.put("name", "vinay");
		obj.put("job", "SDET");
		
		Response res=given().header("Accept","application/json")
				.body(obj.toString())
				.when()
				.put("https://reqres.in/api/users/2")
				.then().extract().response();
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.asPrettyString());
		System.out.println(res.asString());
		System.out.println(res.getBody());
		
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
		
		
		
	}
}
	
	