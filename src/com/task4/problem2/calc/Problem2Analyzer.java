package com.task4.problem2.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.task4.problem1.calc.Problem1Analyzer;
import com.task4.problem2.models.Item;
import com.task4.utils.HelpUtils;

public class Problem2Analyzer {

	private static Problem2Analyzer instance;

	private Problem2Analyzer() {
	}

	public static Problem2Analyzer getInstance() {

		if (instance == null) {

			instance = new Problem2Analyzer();
		}

		return instance;
	}

	public void analyze(List<Integer> inputArray) {
		
		int length = inputArray.size();
		
		List<List<Item>> listSequances = new ArrayList<>();
		
		for (int i = 0; i < length; i++){
			
			List<Item> helpList = new ArrayList<>();
			
			Item item = new Item();
			
			item.setIndex(i);
			item.setValue(inputArray.get(i));
			
			helpList.add(item);
			
			helpList = getList(inputArray, i, helpList);
			
			listSequances.add(helpList);
			
//			for (int j = helpList.size() - 1; j >= 1; j--){
			for (int j = 1; j <= helpList.size() - 1; j++){
				
				int index = helpList.get(j).getIndex();
				
				List<Item> newHelpList = new ArrayList<>();
				
				List<Item> help1List = listSequances.get(listSequances.size() - 1);
				
				newHelpList = HelpUtils.rewriteList(newHelpList, helpList, j);
				
				if (index == 0){
					
					index += 0;
				}
				
				newHelpList = getList(inputArray, index, newHelpList);
				
				listSequances.add(newHelpList);
			}
		}
		
		
		
		Collections.sort(listSequances, new Comparator<List<Item>>() {

			@Override
			public int compare(List<Item> list1,List<Item> list2) {
				// TODO Auto-generated method stub
				Integer l1 = list1.size();
				Integer l2 = list2.size();
				
				return (-1) * l1.compareTo(l2);
			}
		});
		
		int maxLength = listSequances.get(0).size();
		
		for (List<Item> list : listSequances) {

			if (list.size() == maxLength) {
				for (Item item : list) {

					System.out.print(item.getValue() + "\t");
				}

				System.out.println();
			}
		}
	
	}
	
	
	private List<Item> getList(List<Integer> mainList, int index, List<Item> helpList){
		
		
		
		int length = mainList.size();
		
		if (index == 1){
			length += 0;
		}

		while (index + 1 < length){
			
			if (
					 mainList.get(index + 1) > helpList.get(helpList.size() - 1).getValue() ){
				
				Item item = new Item();
				
				item.setIndex(index + 1);
				item.setValue(mainList.get(index + 1));
				
				helpList.add(item);
			}
			index++;
		}
		return helpList;
	}
}
