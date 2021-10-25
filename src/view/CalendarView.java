package view;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CalendarView {
	
	private JTextArea calendarData;
	private JScrollPane scrollPanel;
	
	private ArrayList<String> matches; 
	
	
	
	public CalendarView(ArrayList<String> matches) {
		this.matches = matches;
		calendarData = new JTextArea();
		calendarData.setLineWrap(true);
		calendarData.setEditable(false);
		
		writteCalendar();
		this.scrollPanel = new JScrollPane(calendarData);
		this.scrollPanel.setBounds(107, 92, 484, 373);
	}



	public JScrollPane getScrollPanel() {
		return scrollPanel;
	}
	
	private void writteCalendar() {
		for (String match : matches) {
			if(calendarData.getText() == null) {
				calendarData.setText(match);
			} else {
				calendarData.setText(calendarData.getText() + match);
			}
		}
	}



	public void updateCalendar(ArrayList<String> updatedMatches) {
		matches = updatedMatches;
		cleanCalendar();
		writteCalendar();
	}
	
	private void cleanCalendar() {
		calendarData.setText("");
	}
	
	
	




}
