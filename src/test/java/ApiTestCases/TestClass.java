package ApiTestCases;

import java.util.logging.Logger;


import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestClass {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger=Logger.getLogger("API-Automation");
		PropertyConfigurator.configure("Log4J.properties");
		
		
	

}
}
