package ApiTestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC6_PostRegisterUnsuccessfull  extends  TestClass{
	RequestSpecification httpRequest;
	Response response;
	
	
	@BeforeClass
	void RegisterUnsucessfull() throws InterruptedException
	{
		logger.info("TC6_PostRequest-RegisterUnsucessfull Test case to be executed");
		
		RestAssured.baseURI="https://reqres.in/";
		httpRequest=RestAssured.given();
		
		// Prepare the payload
		
		JSONObject requestparam=new JSONObject();
		requestparam.put("email", "sydney@fife");
		
		
		//Add a header Stating the Request body is JSON
		
		httpRequest.header("Content-Type", "application/json");
		
		//Add the JSON to body of the Request
		
		httpRequest.body(requestparam.toJSONString());
		response=httpRequest.request(Method.POST,"api/register");
		Thread.sleep(10);
	}
	@Test
	void CheckResponseBody()
	
	{
		logger.info("****Checking ResponseBody****");
		String responseBody=response.getBody().asString();
		logger.info("Response Body==>" +responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	@Test
	void CheckStatusCode()
	{
		logger.info("***CheckingStatusCode*****");
		int statuscode=response.getStatusCode();
		logger.info("Status Code==>" +statuscode);
		Assert.assertEquals(statuscode, 400); 
	}
	@Test
	void CheckResponseTime()
	{
		logger.info("***CheckResponseTime*****");
		long resptime=response.getTime();
		logger.info("Response Time==>" +resptime);
		
	}
	@Test
	void CheckContentType()
	{

		logger.info("***Check- Content-Type*****");
		String ContentType=response.header("Content-Type");
		logger.info("Content Type==>" +ContentType);
		Assert.assertEquals(ContentType, "application/json; charset=utf-8");
	}
   
	
	  @Test
	     void ChecStatusLine()
	     {
	        logger.info("***CheckStatusLine*****");
	 		String statusline=response.statusLine();
	 		logger.info("Status Line==>" +statusline); 
	 		Assert.assertEquals(statusline, "HTTP/1.1 400 Bad Request");
	 		
	     }
	  
	
	  
	  @Test
	     void CheckServerDetails()
	     {
	    	logger.info("***ServerDetails*****");
	 		String ServerDetails=response.header("Server");
	 		logger.info("Server Details==>" +ServerDetails); 
	 		Assert.assertEquals(ServerDetails, "cloudflare"); 
	     }
       
	  @Test
	  void verifyJsonBodyData()
	  {
		  JsonPath JsonPathEvalutor=response.jsonPath();
			
		  logger.info("** Verify the Data in Json Response*****");
		
		  
		  String error=JsonPathEvalutor.get("error");
		  logger.info("Error on the Response==>" +error);
		  Assert.assertEquals(error, "Missing password");
	 
	  }
	  

}



