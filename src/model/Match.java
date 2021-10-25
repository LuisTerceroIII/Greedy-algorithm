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

	public String getStringReferee() {
		if (_referee != null)
			return _referee.toString();
		else
			return " ";
	}

	public String getTeamA() {
		return _teamA;
	}

	public String getTeamB() {
		return _teamB;
	}

	@Override
	public String toString() {
		return "Match [teamA=" + _teamA + ", teamB=" + _teamB + "]";
	}
}
