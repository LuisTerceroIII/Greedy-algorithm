package MaxEquity;

import java.util.ArrayList;

import model.Calendar;
import model.Tournament;

public class MaxEquity {

	private static Instance _promblemInstance;

	public static Calendar generateMaxEquityCalendar(Tournament tournament) {
		
		_promblemInstance = new Instance(tournament.getTeams(), zeroIndexReferees(tournament.getReferees()));
		return Solver.resolve(_promblemInstance, tournament.getCalendar());
	}
	
	public static ArrayList<Integer> zeroIndexReferees(ArrayList<Integer> referees) {
		ArrayList<Integer> ret = new ArrayList<>();
		for(int i = 0; i < referees.size() ; i++) {
			ret.add(i);
		}
		return ret;
	}

}
