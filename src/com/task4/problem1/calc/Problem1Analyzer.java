package com.task4.problem1.calc;

import java.util.ArrayList;
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

			int index = 1;
			int j = 1;

			while (index < length - 1) {
				while ((index - j >= 0) && (index + j < length) && input.substring(index - j, index - j + 1)
						.equalsIgnoreCase(input.substring(index + j, index + j + 1))) {
					
					j++;
					//System.out.println(j);
				}
				
				if(j > 1){
					j--;
					String value = input.substring(index - j, index + j + 1);
					System.out.println(value);
				}
				
				j = 1;
				index++;
			}

		}
	}

}
