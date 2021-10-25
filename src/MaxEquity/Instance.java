package MaxEquity;

import java.util.ArrayList;

import model.Match;

public class Instance {
	private ArrayList<String> _teams;
	private ArrayList<Integer> _referees;
	private int[][] teamsAndReferees;

	public Instance(ArrayList<String> teams, ArrayList<Integer> referees) {
		_teams = teams;
		_referees = referees;
		generateGraph();
	}

	private void generateGraph() {
		teamsAndReferees = new int[_teams.size()][_referees.size()];
	}

	// Retorna cantidad de veces que el referee recibido a arbitrado para el equipo
	// recibido.
	public int getRefereeTimesSelectedForATeam(String team, int referee) {
		verifyRefereeNumber(referee);
		verifyTeamName(team);
		int teamNumber = _teams.indexOf(team);
		return teamsAndReferees[teamNumber][referee];
	}

	// Aumenta en 1 la cantidad de veces que un referee arbitrara para el equipo
	// recibido
	public void selectReferee(String team, int referee) {
		verifyRefereeNumber(referee);
		verifyTeamName(team);
		int teamNumber = _teams.indexOf(team);
		int timesSelected = teamsAndReferees[teamNumber][referee];
		teamsAndReferees[teamNumber][referee] = timesSelected + 1;
	}
	
	public void selectReferee(Match match, int referee) {
		verifyRefereeNumber(referee);
		verifyTeamName(match.getTeamA());
		verifyTeamName(match.getTeamB());
		
		int teamAMatrixIndex = _teams.indexOf(match.getTeamA());
		int timesRefereeSelectedForTeamA = getRefereeTimesSelectedForATeam(match.getTeamA(),referee);
		teamsAndReferees[teamAMatrixIndex][referee] = timesRefereeSelectedForTeamA + 1;
		
		int teamBMatrixIndex = _teams.indexOf(match.getTeamB());
		int timesRefereeSelectedForTeamB = getRefereeTimesSelectedForATeam(match.getTeamB(),referee); 
		teamsAndReferees[teamBMatrixIndex][referee] = timesRefereeSelectedForTeamB + 1;
		
		match.setReferee(referee);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getReferees() {
		return (ArrayList<Integer>) _referees.clone();
	}

	private void verifyRefereeNumber(int referee) {
		if(!_referees.contains(referee)) throw new IllegalArgumentException("Referi : " + referee + " no existe");
	}

	private void verifyTeamName(String team) {
		if(!_teams.contains(team)) throw new IllegalArgumentException("Equipo : " + team + " no existe");
	}
	
	public void print() {
		for (int i = 0; i < teamsAndReferees.length; i++) {
		    for (int j = 0; j < teamsAndReferees[i].length; j++) {
		        System.out.print(teamsAndReferees[i][j] + " ");
		    }
		    System.out.println();
		}
	}

}
