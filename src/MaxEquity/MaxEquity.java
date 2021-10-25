package MaxEquity;

import java.util.ArrayList;

import model.Calendar;

public class MaxEquity {

	private static Instance _promblemInstance;

	public static void getMaxEquityCalendar(Calendar calendar, ArrayList<String> teams, ArrayList<Integer> referees) {
		_promblemInstance = new Instance(teams, referees);
		Solver.resolve(_promblemInstance, calendar);
	}

}
