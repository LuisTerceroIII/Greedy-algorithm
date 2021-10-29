package model;

import java.util.ArrayList;

public class GameDay {

	private int _dayNumber;
	private ArrayList<Match> _matches;

	public GameDay(ArrayList<Match> matches, int dayNumber) {
		super();
		this._matches = matches;
		this._dayNumber = dayNumber;
	}

	public ArrayList<Match> getMatches() {
		return _matches;
	}

	public int getDayNumber() {
		return _dayNumber;
	}

}
