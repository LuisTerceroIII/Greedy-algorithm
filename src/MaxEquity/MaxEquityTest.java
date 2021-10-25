package MaxEquity;

import java.util.ArrayList;

import org.junit.Test;

import data.ReadJsonData;
import model.Calendar;

public class MaxEquityTest {

	@Test
	public void GenericTest() {
		Calendar calendar = ReadJsonData.readTournament("calendar.json").getCalendar();
		ArrayList<String> teams = new ArrayList<>();
		teams.add("Boca");
		teams.add("River");
		teams.add("Racing");
		teams.add("Independiente");

		ArrayList<Integer> referees = new ArrayList<Integer>();
		referees.add(0);
		referees.add(1);
		// referees.add(2);

		MaxEquity.getMaxEquityCalendar(calendar, teams, referees);
	}

}
