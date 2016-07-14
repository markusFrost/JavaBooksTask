import java.util.List;

import com.task4.problem1.calc.Problem1Analyzer;
import com.task4.problem2.calc.Problem2Analyzer;
import com.task4.utils.FakeCreator;
import com.task4.utils.HelpUtils;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Problem 1");
		FakeCreator fakeCreator = new FakeCreator();
		
		String input = HelpUtils.trimString(fakeCreator.getProblem1String());
		
		System.out.println("Enter the string" + "\n" + input);
		
		Problem1Analyzer.getInstance().analyze(input);
		
		//-----------------------
		
		int[] inputArray = fakeCreator.getInputArray();
		
		System.out.println("\n\nProblem 2");
		System.out.println("Enter array:");
		
		for (Integer i : inputArray){
			System.out.print( i + "\t");
		}
		
		System.out.println("\n________________________________________________________________\nOutput Result:\n");
				
		Problem2Analyzer.getInstance().analyze(inputArray);
		
		
	}

}
