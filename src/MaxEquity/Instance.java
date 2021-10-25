package MaxEquity;

import java.util.ArrayList;

import model.Match;

class Instance {
	private ArrayList<String> _teams;
	private ArrayList<Integer> _referees;
	private int[][] _teamsAndReferees;

	public Instance(ArrayList<String> teams, ArrayList<Integer> referees) {
		_teams = teams;
		_referees = referees;
		generateTeamsAndRefereesMatrix();
	}

	private void generateTeamsAndRefereesMatrix() {
		_teamsAndReferees = new int[_teams.size()][_referees.size()];
	}

	// Retorna cantidad de veces que el referee recibido a arbitrado para el equipo
	// recibido.
	public int getRefereeTimesSelectedForTeam(String team, int referee) {
		verifyRefereeNumber(referee);
		verifyTeamName(team);
		int teamNumber = _teams.indexOf(team);
		return _teamsAndReferees[teamNumber][referee];
	}

	// Aumenta en 1 la cantidad de veces que un referee arbitrara para el equipo
	// recibido
	public void selectReferee(Match match, int referee) {
		verifyRefereeNumber(referee);
		verifyTeamName(match.getTeamA());
		verifyTeamName(match.getTeamB());

		int teamAMatrixIndex = _teams.indexOf(match.getTeamA());
		int timesRefereeSelectedForTeamA = getRefereeTimesSelectedForTeam(match.getTeamA(), referee);
		_teamsAndReferees[teamAMatrixIndex][referee] = timesRefereeSelectedForTeamA + 1;

		int teamBMatrixIndex = _teams.indexOf(match.getTeamB());
		int timesRefereeSelectedForTeamB = getRefereeTimesSelectedForTeam(match.getTeamB(), referee);
		_teamsAndReferees[teamBMatrixIndex][referee] = timesRefereeSelectedForTeamB + 1;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getReferees() {
		return (ArrayList<Integer>) _referees.clone();
	}

	private void verifyRefereeNumber(int referee) {
		if (!_referees.contains(referee))
			throw new IllegalArgumentException("Referi : " + referee + " no existe");
	}

	private void verifyTeamName(String team) {
		if (!_teams.contains(team))
			throw new IllegalArgumentException("Equipo : " + team + " no existe");
	}

	public void print() {
		for (int i = 0; i < _teamsAndReferees.length; i++) {
			for (int j = 0; j < _teamsAndReferees[i].length; j++) {
				System.out.print(_teamsAndReferees[i][j] + " ");
			}
			System.out.println();
		}
	}

}
