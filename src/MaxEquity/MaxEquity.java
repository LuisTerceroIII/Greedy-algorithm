package MaxEquity;

import java.util.ArrayList;

import model.Calendar;
import model.Tournament;

public class MaxEquity {
	
	public static Calendar generateMaxEquityCalendar(Tournament tournament) {
		
		ArrayList<String> teams = tournament.getTeams();
		ArrayList<Integer> referees = zeroIndexReferees(tournament.getReferees());
		Calendar calendar = tournament.getCalendar();
		
		Instance instance = new Instance(teams, referees, calendar);
		Solver solver = new Solver(instance);
		
		return solver.resolve();
	}

	
	//Recordar que recibo una lista de arbitros enumarados del 1 a n, y para trabajar mas comodo los convierto en 0 a n-1.
	//Luego cuando se retorna el arbitro escogido sumo 1, y queda el numero original.
	public static ArrayList<Integer> zeroIndexReferees(ArrayList<Integer> referees) {
		ArrayList<Integer> ret = new ArrayList<>();
		for(int i = 0; i < referees.size() ; i++) {
			ret.add(i);
		}
		return ret;
	}

}
