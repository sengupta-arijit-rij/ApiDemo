import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.Files.JsonPayLoad;


public class Basics {

	public static void main(String[] args) {
		
		String responseJson="";
		String key="";
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		responseJson=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(JsonPayLoad.AddLocation()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		String place_id= getResponseValue(responseJson,"place_id");
		String address=getResponseValue(responseJson,"address");
		
		
		responseJson=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(JsonPayLoad.UpdateLocation(place_id)).when().put("maps/api/place/update/json").then()
		.log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"))
		.extract().response().asString();
		
		System.out.println("Initial address= "+ address);
		
		responseJson=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_id)
		.when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response()
		.asString();
		System.out.println(getResponseValue(responseJson,"address"));
		

	}
	
	public static String getResponseValue(String responseJson, String key) {
		JsonPath jp= new JsonPath(responseJson);
		return jp.getString(key);
		
	}

}
