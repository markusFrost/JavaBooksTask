package com.task4.utils;

import java.util.ArrayList;
import java.util.List;

import com.task4.problem2.models.Item;

public class HelpUtils {
	
	public static String EMPTY_RESULT = "Result is empty";
	
	public static List<Item> rewriteList(List<Item> newList, List<Item> oldList, int startIndex){
		
		for (int i = 0; i < startIndex; i++){
			
			newList.add(oldList.get(i));
		}
		
		return newList;
	}
	
	public static List<Integer> convertItemArray(List<Item> listItem){
		
		List<Integer> listInteger = new ArrayList<>();
		
		for (Item item : listItem){
			
			listInteger.add(item.getValue());
		}
		
		return listInteger;
	}

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
