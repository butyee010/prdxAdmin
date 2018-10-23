package com.prdx.admin.commons.utils;

import java.io.Serializable;


public class JsonUtility implements Serializable{
	

	/*private static final long serialVersionUID = -3081386751734102711L;

	public static <T> T jsonToObject(String jsonFormat,Class<T> classOfJson){
		T object = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			object = mapper.readValue(jsonFormat, classOfJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}
	
	public static String objectToJson(Object object) {
		String jsonFormat = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			jsonFormat = mapper.writeValueAsString(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonFormat;
	}
	
	public static String objectToPrettyJson(Object object) {
		String jsonFormat = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			jsonFormat = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonFormat;
	}*/
	

}
