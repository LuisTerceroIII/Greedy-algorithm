package controller;

import java.util.ArrayList;

import MaxEquity.MaxEquity;
import data.ReadJsonData;
import model.Calendar;
import model.GameDay;
import model.Match;
import model.MatchObserver;
import model.Tournament;
import view.Screen;

public class MainController implements MatchObserver {

	private Screen _view;
	private Tournament _tournament;
	private Calendar _calendar;
	private ArrayList<String> _teams;
	private ArrayList<Integer> _referees;

	public MainController() {
		_tournament = fetchTournamentData();
		_calendar = _tournament.getCalendar();
		_teams = _tournament.getTeams();
		_referees = _tournament.getReferees();
		_view = new Screen(_calendar.matchesInString(), this);
		attachMatchObservers();
	}

	public Tournament fetchTournamentData() {
		return ReadJsonData.readTournament("tournament.json");
	}

	public void launchApp() {
		_view.start();
	}

	public void assignReferees() {
		MaxEquity.getMaxEquityCalendar(_calendar, _teams, _referees);
	}

	private void attachMatchObservers() {
		for (GameDay gameDay : _calendar.getMatchesDay()) {
			for (Match match : gameDay.getMatches()) {
				match.attach(this);
			}
		}
	}

	@Override
	public void updateReferee() {
		_view.updateCalendar(_calendar.matchesInString());

	}

}
