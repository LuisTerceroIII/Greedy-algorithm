package model;

import java.util.ArrayList;

public class Tournament {

	private ArrayList<Integer> _referees;
	private ArrayList<String> _teams;
	private Calendar _calendar;

	public Tournament(Calendar _calendar, ArrayList<Integer> referees, ArrayList<String> teams) {
		super();
		this._calendar = _calendar;
		this._referees = referees;
		this._teams = teams;
	}

	public Calendar getCalendar() {
		return _calendar;
	}

	public ArrayList<Integer> getReferees() {
		return _referees;
	}

	public ArrayList<String> getTeams() {
		return _teams;
	}


}
