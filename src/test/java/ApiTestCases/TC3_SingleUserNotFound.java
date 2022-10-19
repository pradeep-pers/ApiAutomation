package ApiTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC3_SingleUserNotFound  extends TestClass{
	
	@BeforeClass
	void GetUsers() throws InterruptedException
	{
		logger.info("TC3_SingleUserNotFound Test case to be executed");
		
		RestAssured.baseURI="https://reqres.in/";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/api/users/23");
		Thread.sleep(10);
	}
	@Test
	void CheckResponseBody()
	
	{
		logger.info("****Checking ResponseBody****");
		String responseBody=response.getBody().asString();
		logger.info("Response Body==>" +responseBody);
		//Assert.assertTrue(responseBody =={});
	}
	@Test
	void CheckStatusCode()
	{
		logger.info("***CheckingStatusCode*****");
		int statuscode=response.getStatusCode();
		logger.info("Status Code==>" +statuscode);
		Assert.assertEquals(statuscode, 404); 
	}

}
