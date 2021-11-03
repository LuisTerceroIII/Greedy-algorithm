package controller;

import java.util.ArrayList;

import MaxEquity.MaxEquity;
import Tools.TransformData;
import data.ReadJsonData;
import model.Calendar;
import model.Tournament;
import view.View;

public class MainController {

	private View _view;
	private Tournament _tournament;

	public MainController(String tournamentFile) {
		_tournament = fetchTournamentData(tournamentFile);
		Calendar calendar = _tournament.getCalendar();
		ArrayList<String> calendarInString = TransformData.calendarToString(calendar);
		_view = new View(calendarInString, this);
	}

	private Tournament fetchTournamentData(String filename) {
		return ReadJsonData.readTournament(filename);
	}

	public void launchApp() {
		_view.start();
	}

	public void assignReferees() {
		Calendar calendar = MaxEquity.generateMaxEquityCalendar(_tournament);
		updateCalendar(calendar);
	}

	private void updateCalendar(Calendar calendar) {
		_view.updateCalendar(TransformData.calendarToString(calendar));
	}
	

}
