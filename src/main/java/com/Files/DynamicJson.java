package com.Files;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	String response="";
	
	@Test
	public void addBook() {
		RestAssured.baseURI="http://216.10.245.166";
		response=given().header("Content-Type", "application/json").body(JsonPayLoad.addBook()).when()
		.post("/Library/Addbook.php").then().assertThat().statusCode(200)
		.extract().response().asString();
		
	}

}
