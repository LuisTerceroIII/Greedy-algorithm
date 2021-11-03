package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.MainController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class View {

	private JFrame _frame;
	private CalendarView _calendar;
	private ArrayList<String> _calendarData;
	private MainController _controller;

	public View(ArrayList<String> calendarData, MainController controller) {
		super();
		this._calendarData = calendarData;
		_controller = controller;
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frame = new JFrame();
		_frame.setBounds(100, 100, 696, 572);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(null);
		_frame.setResizable(false);

		_calendar = new CalendarView(_calendarData);
		_frame.getContentPane().add(_calendar.getScrollPanel());

		JLabel title = new JLabel("Calendario Campeonato");
		title.setFont(new Font("Tahoma", Font.PLAIN, 28));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setBounds(107, 11, 488, 62);
		_frame.getContentPane().add(title);

		JButton asignarReferis = new JButton("Asignar Referis");
		asignarReferis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_controller.assignReferees();
			}
		});
		asignarReferis.setBounds(266, 476, 156, 23);
		_frame.getContentPane().add(asignarReferis);
	}

	public void updateCalendar(ArrayList<String> matches) {
		_calendar.updateCalendar(matches);

	}
}
