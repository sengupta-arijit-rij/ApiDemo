package com.PayLoad;

public class LibraryApiPayLoads {

	public static String addBook(String nameVar, String isbnVar, String aisleVar, String authorVar) {
		String addBook = "{\r\n" + "\"name\":\""+nameVar+"\"\",\r\n" + "\"isbn\":\""+isbnVar+"\"\",\r\n"
				+ "\"aisle\":\""+aisleVar+"\"\",\r\n" + "\"author\":\""+authorVar+"\"\"\r\n" + "}";
		return addBook;
	}

	public static String addBook() {
		String addBook = "{\r\n" + "\"name\":\"Learn API Automation with Java\",\r\n" + "\"isbn\":\"abcd\",\r\n"
				+ "\"aisle\":\"A002\",\r\n" + "\"author\":\"Arijit Sengupta\"\r\n" + "}";
		return addBook;

	}

	public static String getBookByAuthor() {
		String getBookByAuthor = "";
		return getBookByAuthor;
	}

	public static String getBookByID() {
		String getBookByID = "";
		return getBookByID;
	}

	public static String deleteBook() {
		String deleteBook = "";
		return deleteBook;
	}

}
