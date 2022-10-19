package ApiTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC2_GetSingleUser  extends TestClass{
	
	@BeforeClass
	void GetUsers() throws InterruptedException
	{
		logger.info("TC2_GetSingleUser Test case to be executed");
		
		RestAssured.baseURI="https://reqres.in/";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/api/users/2");
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
		Assert.assertEquals(statuscode, 200); 
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
	     void CheckTransferEncoding()
	     {
	    	 logger.info("***CheckTransferEncoding*****");
	 		String TransEncoding=response.header("Transfer-Encoding");
	 		logger.info("Transfer Encoding is==>" +TransEncoding);
	 		Assert.assertEquals(TransEncoding, "chunked");
	     }
	  @Test
	     void ChecStatusLine()
	     {
	        logger.info("***CheckStatusLine*****");
	 		String statusline=response.statusLine();
	 		logger.info("Status Line==>" +statusline); 
	 		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	 		
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
		  
		  int ID=JsonPathEvalutor.get("data.id");
		  logger.info("UserID==>" +ID);
		  Assert.assertEquals(ID, 2); 
		  
		  
		  String email=JsonPathEvalutor.get("data.email");
		  logger.info("Email==>" +email);
		  Assert.assertEquals(email, "janet.weaver@reqres.in"); 
		  
		  String fname=JsonPathEvalutor.get("data.first_name");
		  logger.info("FirstName==>" +fname);
		  Assert.assertEquals(fname, "Janet"); 
		  
		  String lname=JsonPathEvalutor.get("data.last_name");
		  logger.info("LastName==>" +lname);
		  Assert.assertEquals(lname, "Weaver"); 
		  
		  String avtr=JsonPathEvalutor.get("data.avatar");
		  logger.info("AVATAR==>" +avtr);
		  Assert.assertEquals(avtr, "https://reqres.in/img/faces/2-image.jpg"); 
		  			 
		}
	  }
	  
	  



