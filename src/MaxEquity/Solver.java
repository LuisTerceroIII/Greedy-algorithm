package MaxEquity;

import java.util.ArrayList;

import model.Calendar;
import model.GameDay;
import model.Match;

public class Solver {
	private static Instance _problemInstace;
	private static Calendar _calendar;	

	public static Solution resolve(Instance problemInstace, Calendar calendar) {
		//La idea creo es ir recorriendo el calendario, asignar un arbitro en la instancia y retornar una solution nueva.
		initialize(problemInstace,calendar);
		
		
		ArrayList<GameDay> matchesDays = _calendar.getMatchesDay();
		int refereeSelected = 0;
		
		for(GameDay gameDay : matchesDays) {
			for(Match match : gameDay.getMatches()) {
				refereeSelected = Solver.chooseReferee(match);
				_problemInstace.selectReferee(match, refereeSelected);
				
			}
		}
	
		return new Solution(_problemInstace, _calendar);
	}

	private static void initialize(Instance problemInstace, Calendar calendar) {
		_problemInstace = problemInstace;
		_calendar = calendar;
	}

	private static int chooseReferee(Match match) {
		int refereeSelected = 0;
		double lowerAverage = 100;
		ArrayList<Integer> referees = _problemInstace.getReferees();
		for(Integer referee : referees) {
			int timesSelectedForTeamA = _problemInstace.getRefereeTimesSelectedForATeam(match.getTeamA(),referee);
			int timesSelectedForTeamB = _problemInstace.getRefereeTimesSelectedForATeam(match.getTeamB(),referee);
			double equityAverage = (double) (timesSelectedForTeamA + timesSelectedForTeamB) / 2;
			
			if(equityAverage < lowerAverage) {
				refereeSelected = referee;
				lowerAverage = equityAverage;
			}
		}
		
		return refereeSelected;
	}

}
