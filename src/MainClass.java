import com.java.task.calc.BooksAnalyzer;
import com.java.task.utils.FakeHelper;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FakeHelper fakeHelper = new FakeHelper();
		
		BooksAnalyzer.getInstance().analyze(fakeHelper.getListBooks(),
				fakeHelper.getReader(),
				fakeHelper.getDaysCount());
		
	

	}

}
