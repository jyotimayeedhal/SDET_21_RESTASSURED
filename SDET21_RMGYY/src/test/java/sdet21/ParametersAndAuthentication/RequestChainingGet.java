package sdet21.ParametersAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet21.GenericUtils.JavaUtility;
import sdet21.POJO.Class.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class RequestChainingGet {
	
	@Test
	public void requestChainingForGet()
	{
		JavaUtility jLib = new JavaUtility(); 
		baseURI = "http://localhost";
		port = 8084;
		
		//this is first request to create a project
		ProjectLibrary pLib = new ProjectLibrary("Nithya", "Ameex "+jLib.getRandomNumber(), "Completed", 50);
		
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pLib)
		.when()
		.post("/addProject");
		
		//capture the project id using json path
		String myProjID = res.jsonPath().get("projectId");
		System.out.println(myProjID);
		
		res.then().log().all();
	
		//this is second request to read the same project created in 1st request
		given()
		.pathParam("projID", myProjID)
		
		.when()
		.get("/projects/{projID}")
		
		.then().assertThat().statusCode(200).log().all();
	}

}
