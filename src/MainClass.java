import com.task4.problem1.calc.Problem1Analyzer;
import com.task4.utils.FakeCreator;
import com.task4.utils.HelpUtils;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FakeCreator fakeCreator = new FakeCreator();
		
		String input = HelpUtils.trimString(fakeCreator.getProblem1String());
		
		System.out.println("Enter the string" + "\n" + input);
		
		Problem1Analyzer.getInstance().analyze(input);
		
		
	}

}
