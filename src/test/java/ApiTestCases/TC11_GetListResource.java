package ApiTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC11_GetListResource  extends TestClass{
	
	@BeforeClass
	void GetLISTofUsers() throws InterruptedException
	{
		logger.info("TC11_GetList<Resource> Test case to be executed");
		
		RestAssured.baseURI="https://reqres.in/";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/api/unknown");
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
		  
		  int ID=JsonPathEvalutor.get("data[1].id");
		  logger.info("UserID==>" +ID);
		  Assert.assertEquals(ID, 2); 
		  
		  
		  String Name=JsonPathEvalutor.get("data[1].name");
		  logger.info("Name is:==>" +Name);
		  Assert.assertEquals(Name, "fuchsia rose"); 
		  
		  int Year=JsonPathEvalutor.get("data[1].year");
		  logger.info("The Year is==>" +Year);
		  Assert.assertEquals(Year, 2001); 
		  
		  String value=JsonPathEvalutor.get("data[1].pantone_value");
		  logger.info("pantone_value is:==>" +value);
		  Assert.assertEquals(value, "17-2031"); 
		  
		 
		  			 
		}
	  }
	  


