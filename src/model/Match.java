package model;

import java.util.ArrayList;

public class Match {
	
	private String teamA;
	private String teamB;
	private  Integer referee;
	private transient ArrayList<MatchObserver> _observers = new ArrayList<>();
	
	public Match(String teamA, String teamB) {
		super();
		this.teamA = teamA;
		this.teamB = teamB;
	}

	public Integer getReferee() {
		return referee;
	}
	
	public void setReferee(int referee) {
		this.referee = referee;
		notifyUpdateReferee();
	}
	
	public String getStringReferee() {
		if(referee != null) return referee.toString();
		else return " ";
	}

	public void setReferee(Integer referee) {
		this.referee = referee;
	}

	public String getTeamA() {
		return teamA;
	}

	public String getTeamB() {
		return teamB;
	}

	public void attach(MatchObserver observer) {
		if(_observers == null) {
			_observers = new ArrayList<MatchObserver>();
		}
		_observers.add(observer);
	}
	
	public void notifyUpdateReferee() {
		for(MatchObserver observer : _observers) {
			observer.updateReferee();
		}	
	}

	@Override
	public String toString() {
		return "Match [teamA=" + teamA + ", teamB=" + teamB + "]";
	}
}
