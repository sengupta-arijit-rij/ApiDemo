package com.Util;

import io.restassured.path.json.JsonPath;

public class CommonUtilities {

	public String getResponseValue(String responseJson, String key) {
		JsonPath jp = new JsonPath(responseJson);
		return jp.getString(key);

	}

}
