package MaxEquity;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import data.ReadJsonData;
import model.Calendar;
import model.GameDay;
import model.Match;
import model.Tournament;

public class MaxEquityTest {

	//Solver se testea indirectamente
	@Test
	public void AssingRefereesTest() {
		
		Tournament tournament = ReadJsonData.readTournament("tournament.json");
		Calendar calendar = tournament.getCalendar();
	
		for(GameDay gameDay : calendar.getMatchesDay()) {
			for(Match match : gameDay.getMatches()) {
				assertTrue(match.getReferee() == null);
			}
		}
		
		Calendar newCalendar = MaxEquity.generateMaxEquityCalendar(tournament);
		
		for(GameDay gameDay : newCalendar.getMatchesDay()) {
			for(Match match : gameDay.getMatches()) {
				assertTrue(match.getReferee() != null);
			}
		}
	}

	@Test
	public void convertRefereesZeroIndex() {
		Tournament tournament = ReadJsonData.readTournament("tournament.json");
		ArrayList<Integer> referees = tournament.getReferees();
		ArrayList<Integer> zeroIndexReferee = MaxEquity.zeroIndexReferees(referees);
		for (int i = 0; i < zeroIndexReferee.size(); i++) {
			assertTrue(zeroIndexReferee.get(i)+1 == referees.get(i));
		}
	}
}
