package model;

import java.util.ArrayList;

public class Calendar {

	private ArrayList<GameDay> _matchesDays;

	public Calendar() {
		super();

	}

	public Calendar(ArrayList<GameDay> _matchesDay) {
		super();
		this._matchesDays = _matchesDay;
	}

	@SuppressWarnings("unchecked")
	public Calendar clone() {
		return new Calendar((ArrayList<GameDay>) _matchesDays.clone());
	}

	
	public void setMatchesDay(ArrayList<GameDay> _matchesDay) {
		this._matchesDays = _matchesDay;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<GameDay> getMatchesDay() {
		return (ArrayList<GameDay>) _matchesDays.clone();
	}


}
