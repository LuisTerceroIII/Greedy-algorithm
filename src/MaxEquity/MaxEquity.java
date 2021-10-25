package MaxEquity;

import model.Calendar;
import model.Tournament;

public class MaxEquity {

	private static Instance _promblemInstance;

	public static Calendar getMaxEquityCalendar(Tournament tournament) {
		_promblemInstance = new Instance(tournament.getTeams(), tournament.getReferees());
		return Solver.resolve(_promblemInstance, tournament.getCalendar());
	}

}
