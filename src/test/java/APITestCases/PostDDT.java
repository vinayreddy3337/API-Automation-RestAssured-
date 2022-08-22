package APITestCases;

import org.testng.annotations.Test;
import org.testng.Assert;


import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import Utils.ReadExcel;
import io.restassured.response.Response;
import  static io.restassured.RestAssured.*;

import java.io.IOException;

public class PostDDT {


		
		@Test(dataProvider="postddt")
		public  void testpostddt(String namevalue,String jobvalue) {
			JSONObject obj=new JSONObject();
			
			obj.put("name",namevalue);
			
			obj.put("job",jobvalue);

			Response res=given() 
					      .header("Content-Type","application/json")
					      .body(obj.toString())
			              .when()
			              .post("https://reqres.in/api/users")
			              .then().extract().response();
	
			System.out.println(res.asPrettyString());
		
			System.out.println(res.getStatusCode());

			Assert.assertEquals(res.getStatusCode(),201);
			
		
		
		
	}
	@DataProvider(name="postddt")
	
	String [][]getdata() throws IOException{
		String path="/Users/innovapathinc/Desktop/Sahas/Restassured/src/test/resources/PostDDT (2).xlsx";
		int rownum=ReadExcel.getRowCount(path, "Sheet1");
		int colcount=ReadExcel.getCellCount(path, "Sheet1", 1);
		String postddt[][]=new String[rownum][colcount]; //6,2
		//0 is for header..column is 0
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++ ) {
				postddt[i-1][j]=ReadExcel.getCellData(path, "Sheet1", i, j);//1  0
			}
		}
		return postddt;
	
	
	
}
}