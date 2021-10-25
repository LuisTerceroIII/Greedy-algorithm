package MaxEquity;

import java.util.ArrayList;

import model.Calendar;

public class MaxEquity {
	
	private static Instance _promblemInstace;
	private static Solution _solution;
	
	public static Calendar getMaxEquityCalendar(Calendar calendar, ArrayList<String> teams, ArrayList<Integer> referees) {
		_promblemInstace = new Instance(teams, referees);
		_solution = Solver.resolve(_promblemInstace,calendar);
		System.out.println(calendar.matchesInString());
		return _solution.generateNewCalendar();
	}
	
}
