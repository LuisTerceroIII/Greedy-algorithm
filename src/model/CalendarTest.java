package model;

import static org.junit.Assert.*;

import org.junit.Test;

import data.ReadJsonData;

public class CalendarTest {
	
	private Calendar obtainCalendar() {
		return ReadJsonData.readTournament("tournament.json").getCalendar();
	}

	@Test
	public void cloneTest() {
		Calendar calendar = obtainCalendar();
		Calendar cloneCalendar = calendar.clone();
		assertTrue(calendar != cloneCalendar);
	}


}
