package com.Action;

import org.testng.annotations.Test;
import com.PayLoad.LibraryApiPayLoads;
import com.Util.CommonUtilities;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class LibraryApiCallExecutor {
	String base = "http://216.10.245.166/";
	String responseJson = "";
	String key = "";
	String id;
	String message;
	CommonUtilities cu = new CommonUtilities();
	String bookName="8 little piggies";
	String isbn="pigISBN";
	String aisle="24th Aisle";
	String author="Arijit";

	@Test(priority=1)
	public void addBook() {

		RestAssured.baseURI = base;
		System.out.println(LibraryApiPayLoads.addBook(bookName,isbn,aisle,author));
		responseJson = given().log().all().header("Content-Type", "application/json")
				.body(LibraryApiPayLoads.addBook()).when().post("/Library/Addbook.php").then()
				.assertThat().statusCode(200).extract().response().asString();
		id = cu.getResponseValue(responseJson, "ID");
		message = cu.getResponseValue(responseJson, "Msg");

	}
	
	

	@Test(priority=2)
	public void getBookByAuthorName() {

		RestAssured.baseURI = base;
		responseJson = given().queryParam("AuthorName", "John foe").when()
				.get("Library/GetBook.php").then().assertThat().statusCode(200)
				.extract().response().asString();
		//System.out.println(cu.getResponseValue(responseJson, "msg"));

	}

	@Test(priority=3)
	public void getBookByID() {

		RestAssured.baseURI = base;
		responseJson = given().log().all().queryParam("ID", "abcd")
				.when().get("Library/GetBook.php").then().assertThat().statusCode(200).extract().response()
				.asString();
		System.out.println(cu.getResponseValue(responseJson, "msg"));

	}

	@Test(priority=4)
	public void deleteBook() {

		RestAssured.baseURI = base;
		responseJson = given().log().all().queryParam("ID", id)
				.when().delete("/Library/DeleteBook.php").then().extract()
				.response().asString();
		//System.out.println(cu.getResponseValue(responseJson, "msg"));

	}

}
