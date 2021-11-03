package MaxEquity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Match;

public class InstanceTest {
	
	private Instance _instance;
	

	@Test(expected = IllegalArgumentException.class)
	public void verifyCorrectRefereeTest() {
		initialize();
		_instance.verifyRefereeNumber(2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verifyCorrectTeamTest() {
		initialize();
		_instance.verifyTeamName("Racing");
	}
	
	@Test
	public void timesRefereeSelectedForATeamTest() {
		initialize();
		assertTrue(_instance.getRefereeTimesSelectedForATeam("Arsenal", 0) == 2);
		assertTrue(_instance.getRefereeTimesSelectedForATeam("Manchester city", 1) == 1);
	}
	
	@Test
	public void selectRefereeTest() {
		initialize();
		int timesRefereeOneForArsenal = _instance.getRefereeTimesSelectedForATeam("Arsenal", 1);
		int timesRefereeOneForChelsea = _instance.getRefereeTimesSelectedForATeam("Chelsea", 1);
		Match newMatch = new Match("Arsenal","Chelsea");
		_instance.selectReferee(newMatch, 1);
		
		assertTrue(timesRefereeOneForArsenal + 1 == _instance.getRefereeTimesSelectedForATeam("Arsenal", 1));
		assertTrue(timesRefereeOneForChelsea + 1 == _instance.getRefereeTimesSelectedForATeam("Chelsea", 1));
	}
	
	@Test
	public void generateRefereeTeamsMatrixTest() {
		initialize();
		assertTrue(_instance.getTeamsAndReferees().length == _instance.getTeams().size());
		assertTrue(_instance.getTeamsAndReferees()[0].length == _instance.getReferees().size());
	}
	
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
	}
	
}
