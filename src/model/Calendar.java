package model;

import java.io.FileWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Calendar {

	private ArrayList<GameDay> _matchesDay;

	public Calendar() {
		super();

	}

	public Calendar(ArrayList<GameDay> _matchesDay) {
		super();
		this._matchesDay = _matchesDay;
	}

	@SuppressWarnings("unchecked")
	public Calendar clone() {
		return new Calendar((ArrayList<GameDay>) _matchesDay.clone());
	}

	public ArrayList<String> matchesInString() {
		ArrayList<String> ret = new ArrayList<>();
		StringBuilder stringMatch = new StringBuilder();

		for (GameDay gameDay : _matchesDay) {
			stringMatch.append("---------------------------------------------------------------\n").append("   Fecha ")
					.append(gameDay.getDayNumber()).append("\n\n");

			for (Match match : gameDay.getMatches()) {
				stringMatch.append("   Equipos : ").append(match.getTeamA()).append(" vs ").append(match.getTeamB())
						.append("\n").append("   Arbitro : ").append(match.getStringReferee()).append("\n")
						.append("\n");
			}

			ret.add(stringMatch.toString());
			stringMatch.setLength(0); // To clean the string builder.
		}
		return ret;

	}

	public void jsonGenerator(String fileName) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);
		try {
			FileWriter writter = new FileWriter(fileName);
			writter.write(json);
			writter.close();
		} catch (Exception e) {
			System.out.println("FALLO CONVERTIR LA CLASEEE");
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<GameDay> getMatchesDay() {
		return (ArrayList<GameDay>) _matchesDay.clone();
	}

	@Override
	public String toString() {
		return "Calendar [_matchesDay=" + _matchesDay + "]";
	}

}
