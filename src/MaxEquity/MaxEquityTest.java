package MaxEquity;

import static org.junit.Assert.assertTrue;

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
		
		Calendar newCalendar = MaxEquity.getMaxEquityCalendar(tournament);
		
		for(GameDay gameDay : newCalendar.getMatchesDay()) {
			for(Match match : gameDay.getMatches()) {
				assertTrue(match.getReferee() != null);
			}
		}
	}

}
