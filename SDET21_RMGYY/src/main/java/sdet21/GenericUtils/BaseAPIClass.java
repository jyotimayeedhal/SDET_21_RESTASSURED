package sdet21.GenericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass {
	
	public DatabaseUtilitity dLib = new DatabaseUtilitity();
	public RestAssuredUtilities rLib = new RestAssuredUtilities();
	public JavaUtility jLib = new JavaUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
       dLib.connectToDB();
       baseURI = "http://localhost";
       port = 8084;
      
	}
	
	@AfterSuite
	public void asConfig() throws Throwable {
		dLib.closeDB();
	}

}
