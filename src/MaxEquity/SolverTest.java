package MaxEquity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Calendar;
import model.GameDay;
import model.Match;

public class SolverTest {

private Solver _solver;
private Instance _instance;
	
	@Before
	public void init() {
		ArrayList<String> teams = new ArrayList<>();
		ArrayList<Integer> referees = new ArrayList<>();
		teams.add("Arsenal");
		teams.add("Manchester City");
		teams.add("Manchester United");
		teams.add("Chelsea");
		referees.add(0);
		referees.add(1);
			
		Match matchA = new Match("Arsenal", "Manchester City");
		Match matchB = new Match("Arsenal", "Chelsea");
		Match matchC = new Match("Manchester United", "Chelsea");
		Match matchD = new Match("Manchester United", "Manchester City");
		
		ArrayList<Match> matchesDayOne = new ArrayList<>();
		ArrayList<Match> matchesDayTwo = new ArrayList<>();
		matchesDayOne.add(matchA);
		matchesDayOne.add(matchB);
		matchesDayTwo.add(matchC);
		matchesDayTwo.add(matchD);
		GameDay gameDay1 = new GameDay(matchesDayOne, 1);
		GameDay gameDay2 = new GameDay(matchesDayTwo, 2);
		
		ArrayList<GameDay> gameDays = new ArrayList<>();
		gameDays.add(gameDay1);
		gameDays.add(gameDay2);
		
		Calendar calendar = new Calendar();
		calendar.setMatchesDay(gameDays);	
		
		_instance = new Instance(teams, referees,calendar);
		
		_solver = new Solver(_instance);
		_solver.addRefereeToMatch(matchA, 0);
		_solver.addRefereeToMatch(matchB, 0);
		_solver.addRefereeToMatch(matchC, 1);
		_solver.addRefereeToMatch(matchD, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verifyRefereeNotExist() {
		_solver.verifyRefereeNumber(2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verifyTeamNotExist() {
		_solver.verifyTeamName("Real Madrid");
	}
	
	@Test
	public void chooseRefereeOneTest() {
		Match match = new Match("Manchester United", "Chelsea");
		int selectedReferee =_solver.chooseReferee(match, _instance.getReferees());
		assertTrue(selectedReferee == 0);		
	}
	@Test
	public void chooseRefereeTwoTest() {
		Match match = new Match("Manchester City", "Arsenal");
		int selectedReferee =_solver.chooseReferee(match, _instance.getReferees());
		assertTrue(selectedReferee == 1);		
	}
	
	@Test
	public void getRefereeTimesSelectedForATeamTest() {
		assertTrue(_solver.getRefereeTimesSelectedForATeam("Arsenal", 0) == 2);	
	}
	
	@Test
	public void getRefereeTimesSelectedForATeamTwoTest() {
		assertTrue(_solver.getRefereeTimesSelectedForATeam("Chelsea", 0) == 1);	
	}
	@Test
	public void addRefereeToMatchTest() {
		Match match = new Match("Manchester United", "Chelsea");
		_solver.addRefereeToMatch(match, 0);
		assertTrue(_solver.getRefereeTimesSelectedForATeam("Chelsea", 0) == 2);
	}
	
	
	
}
