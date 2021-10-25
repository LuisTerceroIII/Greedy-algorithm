package MaxEquity;

import model.Calendar;

public class Solution {
	
	private static Instance _problemInstace;
	private static Calendar _calendar;	
	
	public Solution(Instance problemInstace, Calendar calendar) {
		_problemInstace = problemInstace;
		_calendar = calendar;
	}

	public  Calendar generateNewCalendar() {
		_problemInstace.print();
		return new Calendar();
	}

}
