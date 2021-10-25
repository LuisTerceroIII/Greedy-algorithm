package model;

import java.util.ArrayList;

public class GameDay {
	
	private int dayNumber;
	private ArrayList<Match> matches;

	public GameDay(ArrayList<Match> matches, int dayNumber) {
		super();
		this.matches = matches;
		this.dayNumber = dayNumber;
	}

	public ArrayList<Match> getMatches() {
		return matches;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	@Override
	public String toString() {
		return "GameDay [dayNumber=" + dayNumber + ", matches=" + matches + "]";
	}
	
	
	
	
	
}
