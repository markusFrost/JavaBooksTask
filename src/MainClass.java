import java.util.Calendar;
import java.util.List;

import com.java.task.calc.BooksAnalyzer;
import com.java.task.calc.RentAnalyzer;
import com.java.task.files.FilesHelper;
import com.java.task.models.Rent;
import com.java.task.utils.FakeHelper;
import com.java.task.utils.FakeRentCreator;
import com.java.task.utils.HelpUtils;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		FakeRentCreator fakeRentCreator = new FakeRentCreator();
		
		fakeRentCreator.generate();
		
		List<Rent> listRent = FilesHelper.getInstance().getListRents();
		
		 RentAnalyzer.getInstance().analyze(listRent,
				fakeRentCreator.getDateFrom(), fakeRentCreator.getDaysCount());
		
		
		
		
		

		
	

	}

}
