package MaxEquity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Match;

public class InstanceTest {
	
	private Instance _instance;
	
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
	
	@Test
	public void timesRefereeSelectedForTeamTest() {
		initialize();
		assertTrue(_instance.getRefereeTimesSelectedForTeam("Arsenal", 0) == 2);
		assertTrue(_instance.getRefereeTimesSelectedForTeam("Manchester city", 1) == 1);
	}
	

}
