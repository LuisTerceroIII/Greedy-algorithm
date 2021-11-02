package MaxEquity;

import java.util.ArrayList;

import model.Calendar;
import model.Tournament;

public class MaxEquity {

	private static Instance _promblemInstance;

	public static Calendar generateMaxEquityCalendar(Tournament tournament) {
		
		_promblemInstance = new Instance(tournament.getTeams(), zeroIndexReferees(tournament.getReferees()));
		Solver solver = new Solver(_promblemInstance, tournament.getCalendar());
		return solver.resolve();
	}
	//Recordar que recibo una lista de arbitros enumarados del 1 a n, y para trabajar mas comodo los convierto en 0 a n-1.
	//Luego cuando se retorna el arbitro correcto sumo 1, y queda el numero original.
	public static ArrayList<Integer> zeroIndexReferees(ArrayList<Integer> referees) {
		ArrayList<Integer> ret = new ArrayList<>();
		for(int i = 0; i < referees.size() ; i++) {
			ret.add(i);
		}
		return ret;
	}

}
