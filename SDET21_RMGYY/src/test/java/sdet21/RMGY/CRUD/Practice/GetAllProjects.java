package sdet21.RMGY.CRUD.Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {
	
	@Test
	public void getAllProjects()
	{
		//Send the request
		Response res = RestAssured.get("http://localhost:8084/projects");
		
		//print the response
		System.out.println(res.prettyPeek());
		System.out.println(res.prettyPrint());
		System.out.println(res.getStatusCode());
	}

}
