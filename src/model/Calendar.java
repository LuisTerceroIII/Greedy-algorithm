package model;

import java.util.ArrayList;

public class Calendar {

	private ArrayList<GameDay> _matchesDay;

	public Calendar() {
		super();

	}

	public Calendar(ArrayList<GameDay> _matchesDay) {
		super();
		this._matchesDay = _matchesDay;
	}

	@SuppressWarnings("unchecked")
	public Calendar clone() {
		return new Calendar((ArrayList<GameDay>) _matchesDay.clone());
	}

	public ArrayList<String> matchesInString() {
		ArrayList<String> ret = new ArrayList<>();
		StringBuilder stringMatch = new StringBuilder();

		for (GameDay gameDay : _matchesDay) {
			stringMatch.append("*********************************************************\n").append("   Fecha ")
					.append(gameDay.getDayNumber()).append("\n\n");

			for (Match match : gameDay.getMatches()) {
				
				String referee = match.getReferee() != null ? match.getReferee().toString() : " ";
				
				stringMatch.append("   Equipos : ")
						.append(match.getTeamA()).append(" vs ").append(match.getTeamB())
						.append("\n").append("   Arbitro : ").append(referee).append("\n")
						.append("\n");
			}

			ret.add(stringMatch.toString());
			stringMatch.setLength(0); // To clean the string builder.
		}
		return ret;

	}
	
	public void setMatchesDay(ArrayList<GameDay> _matchesDay) {
		this._matchesDay = _matchesDay;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<GameDay> getMatchesDay() {
		return (ArrayList<GameDay>) _matchesDay.clone();
	}


}
