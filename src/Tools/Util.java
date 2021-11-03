package Tools;

import java.util.ArrayList;

public class Util {
	
	public static ArrayList<Object> cloneArrayList(ArrayList<Object> array) {
		ArrayList<Object> ret = new ArrayList<>();
		for(Object elem : array) {
			ret.add(elem);
		}
		return ret;
	}

	public static double averageOfTwoNumber(int num1, int num2) {
		return (double)(num1+num2)/2;
	}
}
