package model;

import java.util.ArrayList;

public class Match {

	private String _teamA;
	private String _teamB;
	private Integer _referee;
	private transient ArrayList<MatchObserver> _observers = new ArrayList<>();

	public Match(String teamA, String teamB) {
		super();
		this._teamA = teamA;
		this._teamB = teamB;
	}

	public Integer getReferee() {
		return _referee;
	}

	public void setReferee(int referee) {
		this._referee = referee;
		notifyUpdateReferee();
	}

	public String getStringReferee() {
		if (_referee != null)
			return _referee.toString();
		else
			return " ";
	}

	public void setReferee(Integer referee) {
		this._referee = referee;
	}

	public String getTeamA() {
		return _teamA;
	}

	public String getTeamB() {
		return _teamB;
	}

	public void attach(MatchObserver observer) {
		if (_observers == null) {
			_observers = new ArrayList<MatchObserver>();
		}
		_observers.add(observer);
	}

	public void notifyUpdateReferee() {
		for (MatchObserver observer : _observers) {
			observer.updateReferee();
		}
	}

	@Override
	public String toString() {
		return "Match [teamA=" + _teamA + ", teamB=" + _teamB + "]";
	}
}
