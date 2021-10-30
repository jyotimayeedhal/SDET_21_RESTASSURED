package sdet21.RMGY.CRUD.Practice;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingHashMap {
	
	@Test
	public void createProjectUsingHashMap()
	{
		HashMap map = new HashMap();
		map.put("createdBy", "Pragathi");
		map.put("projectName", "Chrome");
		map.put("status","Completed");
		map.put("teamSize", 20);
		
		//request specification
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
		//actual request
		.when()
		.post("http://localhost:8084/addProject")
		
		//validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}

}
