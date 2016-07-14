package com.task4.utils;

public class HelpUtils {
	
	public static String EMPTY_RESULT = "Result is empty";

	public static String trimString(String value){
		
		String space = "";
		
		for (int i = 10; i >= 2; i--){
			
			for (int j = 1; j <= i; j++){
				
				space += " ";
			}
			value = value.replace(space, " ");
			space = "";
		}
		
		return value;
	}
}
