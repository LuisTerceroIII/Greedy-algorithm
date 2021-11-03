package MaxEquity;

import java.util.ArrayList;

import model.Calendar;
import model.GameDay;
import model.Match;

public class Solver {
	private  Instance _problemInstance;
	private  Calendar _calendar;
	
	public Solver(Instance problemInstance, Calendar calendar) {
		this._problemInstance = problemInstance;
		this._calendar = calendar;
	}
	

	
	 ArrayList<Integer> refereesCopy() {
		ArrayList<Integer> ret = new ArrayList<>();
		for(Integer referee : _problemInstance.getReferees()) {
			ret.add(referee);
		}
		return ret;
	}
	//Se testea indirectamente en MaxEquityTest.
	public  Calendar resolve() {
		Calendar ret = new Calendar();
		ArrayList<GameDay> matchesDays = _calendar.getMatchesDay();
		int choosedReferee = 0;

		for (GameDay gameDay : matchesDays) {
			ArrayList<Integer> refereesCopy = refereesCopy();
			
			for (Match match : gameDay.getMatches()) {
				choosedReferee = chooseReferee(match,refereesCopy);
				_problemInstance.selectReferee(match, choosedReferee);
				match.setReferee(choosedReferee + 1); //se suma uno para compesar convertir la lista de referees con index 0.
				refereesCopy.remove(Integer.valueOf(choosedReferee));
				
			}
		}
		
		ret.setMatchesDay(matchesDays);
		return ret;
	}

	/*
	 * El criterio para elegir un r�feri es: Para cada encuentro (Match) se elige al
	 * r�feri con menor promedi� de elecci�n entre los dos equipos y que se encuentre disponible,
	 * es decir que no se halla elegido ya para otro partido en el mismo dia.
	 *  Ejemplo: 
	 *  Referis = {0,1,2} 
	 *  -El R�feri �0� a arbitrado 2 veces al equipo �A�, y 3 veces al
	 * equipo �B�, es decir el promedio de equidad es (2+3) /2 = 2,5 
	 * -El R�feri �1� a arbitrado 1 veces al equipo �A�, y 2 veces al equipo �B�, es decir el
	 * promedio de equidad es (1+2) /2 = 1,5 
	 * -El R�feri �2� a arbitrado 4 veces al equipo �A�, y 3 veces al equipo �B�,
	 *  es decir el promedio de equidad es (4+3)/2 = 3,5
	 *  
	 * Esto significa que el r�feri elegido para este encuentro ser� el r�feri �1�,
	 * ya que ofrece un promedio de equidad mayor hasta ahora.
	 */
	 int chooseReferee(Match match, ArrayList<Integer> referees) {

		int refereeSelected = -1;
		double lowerAverage = 100;
		
		for (Integer referee : referees) {

			int timesSelectedForTeamA = _problemInstance.getRefereeTimesSelectedForATeam(match.getTeamA(), referee);
			int timesSelectedForTeamB = _problemInstance.getRefereeTimesSelectedForATeam(match.getTeamB(), referee);
			double equityAverage = (double) (timesSelectedForTeamA + timesSelectedForTeamB) / 2;

			if (equityAverage < lowerAverage) {
				refereeSelected = referee;
				lowerAverage = equityAverage;
			}	
		}
		
		if(refereeSelected == -1) {
			return referees.get(0);
		}

		return refereeSelected;
	}
	
	 void initialize(Instance problemInstace, Calendar calendar) {
		_problemInstance = problemInstace;
		_calendar = calendar;	
	}
}
