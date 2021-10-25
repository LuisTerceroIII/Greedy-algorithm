package view;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CalendarView {

	private JTextArea _calendarData;
	private JScrollPane _scrollPanel;

	private ArrayList<String> matches;

	public CalendarView(ArrayList<String> matches) {
		this.matches = matches;
		_calendarData = new JTextArea();
		_calendarData.setLineWrap(true);
		_calendarData.setEditable(false);

		writteCalendar();
		this._scrollPanel = new JScrollPane(_calendarData);
		this._scrollPanel.setBounds(107, 92, 484, 373);
	}

	public JScrollPane getScrollPanel() {
		return _scrollPanel;
	}

	private void writteCalendar() {
		for (String match : matches) {
			if (_calendarData.getText() == null) {
				_calendarData.setText(match);
			} else {
				_calendarData.setText(_calendarData.getText() + match);
			}
		}
	}

	public void updateCalendar(ArrayList<String> updatedMatches) {
		matches = updatedMatches;
		cleanCalendar();
		writteCalendar();
	}

	private void cleanCalendar() {
		_calendarData.setText("");
	}

}
