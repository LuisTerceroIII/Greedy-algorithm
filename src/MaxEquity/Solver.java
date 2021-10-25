package MaxEquity;

import java.util.ArrayList;

import model.Calendar;
import model.GameDay;
import model.Match;

public class Solver {
	private static Instance _problemInstance;
	private static Calendar _calendar;

	public static void resolve(Instance problemInstance, Calendar calendar) {
		// La idea es ir recorriendo el calendario,
		// y asignar un arbitro para cada encuentro maximizando la equidad.
		initialize(problemInstance, calendar);

		ArrayList<GameDay> matchesDays = _calendar.getMatchesDay();
		int choosedReferee = 0;

		for (GameDay gameDay : matchesDays) {
			for (Match match : gameDay.getMatches()) {
				choosedReferee = Solver.chooseReferee(match);
				_problemInstance.selectReferee(match, choosedReferee);
				match.setReferee(choosedReferee);
			}
		}
	}

	private static void initialize(Instance problemInstace, Calendar calendar) {
		_problemInstance = problemInstace;
		_calendar = calendar;
	}

	/*
	 * El criterio para elegir un réferi es: Para cada encuentro (Match) se elige al
	 * réferi con menor promedió de elección entre los dos equipos. Ejemplo: Referis
	 * = {0,1,2} -El Réferi “0” a arbitrado 2 veces al equipo “A”, y 3 veces al
	 * equipo “B”, es decir el promedio de equidad es (2+3) /2 = 2,5 -El Réferi “1”
	 * a arbitrado 1 veces al equipo “A”, y 2 veces al equipo “B”, es decir el
	 * promedio de equidad es (1+2) /2 = 1,5 -El Réferi “2” a arbitrado 4 veces al
	 * equipo “A”, y 3 veces al equipo “B”, es decir el promedio de equidad es (4+3)
	 * /2 = 3,5
	 * 
	 * Esto significa que el réferi elegido para este encuentro será el réferi “1”,
	 * ya que ofrece un promedio de equidad mayor hasta ahora.
	 */
	private static int chooseReferee(Match match) {

		int refereeSelected = 0;
		double lowerAverage = 100;
		ArrayList<Integer> referees = _problemInstance.getReferees();

		for (Integer referee : referees) {

			int timesSelectedForTeamA = _problemInstance.getRefereeTimesSelectedForTeam(match.getTeamA(), referee);
			int timesSelectedForTeamB = _problemInstance.getRefereeTimesSelectedForTeam(match.getTeamB(), referee);
			double equityAverage = (double) (timesSelectedForTeamA + timesSelectedForTeamB) / 2;

			if (equityAverage < lowerAverage) {
				refereeSelected = referee;
				lowerAverage = equityAverage;
			}
		}

		return refereeSelected;
	}

}
