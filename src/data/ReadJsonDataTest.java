package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Calendar;
import model.GameDay;
import model.Match;
import model.Tournament;

public class ReadJsonDataTest {
	
	private Tournament readTorunamentFile() {
		return ReadJsonData.readTournament("tournament.json");
	}

	@Test
	public void tournamentNotNullTest() {
		Tournament tournament = readTorunamentFile(); 
		assertTrue(tournament != null);
	}
	
	@Test
	public void tournamentCalendarNotNullTest() {
		Tournament tournament = readTorunamentFile();
		Calendar calendar = tournament.getCalendar();
		assertTrue(calendar != null);
	}
	
	@Test
	public void tournamentRefereesNotNullTest() {
		Tournament tournament = readTorunamentFile();
		ArrayList<Integer> referees = tournament.getReferees();
		assertTrue(referees != null);
	}
	
	@Test
	public void tournamentTeamsNotNullTest() {
		Tournament tournament = readTorunamentFile();
		ArrayList<String> teams = tournament.getTeams();
		assertTrue(teams != null);
	}
	
	@Test
	public void tournamentRefereesComplete() {
		Tournament tournament = readTorunamentFile();
		ArrayList<Integer> referees = tournament.getReferees();
		assertTrue(referees.size() == 3);
	}
	
	@Test
	public void tournamentTeamsComplete() {
		Tournament tournament = readTorunamentFile();
		ArrayList<String> teams = tournament.getTeams();
		assertTrue(teams.size() == 6);
	}
	
	@Test
	public void tournametMatchDaysComplete() {
		Tournament tournament = readTorunamentFile();
		ArrayList<GameDay> gameDays = tournament.getCalendar().getMatchesDay();
		assertTrue(gameDays.size() == 10);	
	}
	
	@Test
	public void tournamentMatchesComplete() {
		int matches = 0;
		Tournament tournament = readTorunamentFile();
		ArrayList<GameDay> gameDays = tournament.getCalendar().getMatchesDay();
		
		for(GameDay gameDay : gameDays) {
			for(@SuppressWarnings("unused") Match match : gameDay.getMatches()) {
				matches++;
			}
		}
		assertTrue(matches == 30);
	}

}
	