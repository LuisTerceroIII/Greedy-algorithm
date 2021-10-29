package model;


public class Match {

	private String _teamA;
	private String _teamB;
	private Integer _referee;

	public Match(String teamA, String teamB) {
		super();
		this._teamA = teamA;
		this._teamB = teamB;
		this._referee = null;
	}

	public Integer getReferee() {
		return _referee;
	}

	public void setReferee(int referee) {
		this._referee = referee;
	}

	public String getTeamA() {
		return _teamA;
	}

	public String getTeamB() {
		return _teamB;
	}

}
