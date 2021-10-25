package controller;

import MaxEquity.MaxEquity;
import data.ReadJsonData;
import model.Calendar;
import model.Tournament;
import view.Screen;

public class MainController {

	private Screen _view;
	private Tournament _tournament;
	private Calendar _calendar;

	public MainController(String tournamentFile) {
		_tournament = fetchTournamentData(tournamentFile);
		_calendar = _tournament.getCalendar();
		_view = new Screen(_calendar.matchesInString(), this);

	}

	public Tournament fetchTournamentData(String filename) {
		return ReadJsonData.readTournament(filename);
	}

	public void launchApp() {
		_view.start();
	}

	public void assignReferees() {
		Calendar calendar = MaxEquity.getMaxEquityCalendar(_tournament);
		_view.updateCalendar(calendar.matchesInString());
	}

}
