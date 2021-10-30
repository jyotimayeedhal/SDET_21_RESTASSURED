package sdet21.RMGY.CRUD.Practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet21.GenericUtils.JavaUtility;
import sdet21.POJO.Class.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOJO {
	
	@Test
	public void createProjerctUsingPOJO()
	{
		JavaUtility jLib = new JavaUtility();
		baseURI = "http://localhost";
		port = 8084;
		
		//read data thru pojo class
		ProjectLibrary pLib = new ProjectLibrary("Harish", "SkillRary "+jLib.getRandomNumber(), "Completed", 20);
		
		//request Specification
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		//request
		.when()
		.post("/addProject")
		
		//validation
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
