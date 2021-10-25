package MaxEquity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Calendar;
import model.GameDay;
import model.Match;

public class SolverTest {

private Instance _instance;
private Calendar _calendar;
	
	private void initialize() {
		ArrayList<String> teams = new ArrayList<>();
		ArrayList<Integer> referees = new ArrayList<>();
		
		teams.add("Arsenal");
		teams.add("Manchester city");
		teams.add("Manchester United");
		teams.add("Chelsea");
		
		referees.add(0);
		referees.add(1);
	
		_instance = new Instance(teams, referees);
		
		Match matchA = new Match("Arsenal", "Manchester city");
		Match matchB = new Match("Arsenal", "Chelsea");
		_instance.selectReferee(matchA, 0);
		_instance.selectReferee(matchB, 0);
		
		Match matchC = new Match("Manchester United", "Chelsea");
		Match matchD = new Match("Manchester United", "Manchester city");
		
		_instance.selectReferee(matchC, 1);
		_instance.selectReferee(matchD, 1);
		
		ArrayList<Match> matchesDayOne = new ArrayList<>();
		matchesDayOne.add(matchA);
		matchesDayOne.add(matchB);
	
		GameDay gameDay1 = new GameDay(matchesDayOne, 1);
	
		ArrayList<Match> matchesDayTwo = new ArrayList<>();
		matchesDayTwo.add(matchC);
		matchesDayTwo.add(matchD);
		
		GameDay gameDay2 = new GameDay(matchesDayTwo, 2);
		
		ArrayList<GameDay> gameDays = new ArrayList<>();
		
		gameDays.add(gameDay1);
		gameDays.add(gameDay2);
		
		_calendar = new Calendar();
		_calendar.setMatchesDay(gameDays);		
	}
	
	@Test
	public void selectRefereeTest() {
		initialize();
		Match match = new Match("Manchester United", "Chelsea");
		Solver.initialize(_instance, _calendar);
		int selectedReferee = Solver.chooseReferee(match, _instance.getReferees());
		
		assertTrue(selectedReferee == 0);
		
	}

}
