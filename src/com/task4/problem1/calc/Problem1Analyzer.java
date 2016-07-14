package com.task4.problem1.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.task4.utils.HelpUtils;

public class Problem1Analyzer {

	private static Problem1Analyzer instance;

	private Problem1Analyzer() {
	}

	public static Problem1Analyzer getInstance() {

		if (instance == null) {

			instance = new Problem1Analyzer();
		}

		return instance;
	}

	public void analyze(String input) {

		int length = input.length();

		if (length < 3) {

			System.out.println(HelpUtils.EMPTY_RESULT);
		} else if (length == 3) {

			String s1 = input.substring(0, 1);
			String s3 = input.substring(2, 1);

			if (s1.equalsIgnoreCase(s3)) {

				System.out.println(input);
			} else {

				System.out.println(HelpUtils.EMPTY_RESULT);
			}
		} else {
			
			List<String> list = new ArrayList<>();

			boolean fl = false;
			
			int index = 1;
			
			int LeftStep = 1;
			int RightStep = 1;

			while (index < length - 1) {
				
				LeftStep = 0;
				RightStep = 0;
				
				String s1 = input.substring(index - LeftStep, index - LeftStep + 1);
				String s3 = input.substring(index + RightStep, index + RightStep + 1);
				
				do{
					LeftStep++;
					RightStep++;
					
					if((index - LeftStep >= 0) && (index + RightStep < length)){
						
						fl = true;
						
						s1 = input.substring(index - LeftStep, index - LeftStep + 1);
						s3 = input.substring(index + RightStep, index + RightStep + 1);
						
						if (s1.equals(" ")){
							
							LeftStep++;
							s1 = input.substring(index - LeftStep, index - LeftStep + 1);
						}
						
						if (s3.equals(" ")){
							
							RightStep++;
							s3 = input.substring(index + RightStep, index + RightStep + 1);
						}
						
					}
					else{
						
						fl = false;
					}
					
					
				}
				while (s1.equalsIgnoreCase(s3) && fl);
		
					LeftStep--;
					RightStep--;
					
					String value = input.substring(index - LeftStep, index + RightStep + 1);
					
					if (value.length() > 2){
						
						list.add(value);
					}

				index++;
			}
			
			outputResult(list);
		}
		
		
	}
	
	public void outputResult(List<String> list){
		
		if (list.size() == 0){
			
			System.out.println(HelpUtils.EMPTY_RESULT);
		}
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				Integer l1 = s1.length();
				Integer l2 = s2.length();
				
				return (-1) * l1.compareTo(l2);
			}
		});
		
		int maxLenght = list.get(0).length();
		
		System.out.println("__________________________________\nPossible answers:");
		for (String str : list){
			
			if (str.length() == maxLenght){
				
				System.out.println(str);
			}
		}
	}

}
