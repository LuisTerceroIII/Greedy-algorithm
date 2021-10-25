package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	
	@Test
	public void stringCalendarTest() {
		Calendar calendar = obtainCalendar();
		ArrayList<String> calendarString = calendar.matchesInString();
		assertTrue(calendar.getMatchesDay().size() == calendarString.size());
	}
	
	

}
