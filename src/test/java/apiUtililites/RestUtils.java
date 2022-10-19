package apiUtililites;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String Name()
	{
		String genereratedString =RandomStringUtils.randomAlphabetic(3);
		return ("ApiRest" +genereratedString);
		
	}
	public static String Job()
	{
		String genereratedString =RandomStringUtils.randomAlphabetic(2);
		return ("ApiRestLeader" +genereratedString);
		
	}

}
