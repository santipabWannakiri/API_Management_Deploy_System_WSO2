package com.api.deploy.util;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ConvertJsonObject {

	public String Production(String strjson){
		try {
			if (strjson.equalsIgnoreCase("null")) {
				return "null";
			} else {
				JSONTokener json = new JSONTokener(strjson);
				JSONObject object = new JSONObject(json);
				return object.getJSONObject("production_endpoints").getString("url");
			}
		} catch (JSONException e) {
			return "null";
		}
	}

	public String Sandbox(String strjson) {
		if (strjson.equalsIgnoreCase("null")) {
			return "null";
		} else {
			try {
				JSONTokener json = new JSONTokener(strjson);
				JSONObject object = new JSONObject(json);
				return object.getJSONObject("sandbox_endpoints").getString("url");
			} catch (JSONException e) {
				return "null";
			}
		}
	}
}
