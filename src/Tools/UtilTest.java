package Tools;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {

	@Test
	public void testAverageOfTwoNumberNaturalNumberResult() {
		int num1 = 10;
		int num2 = 30;
		double average = (double) (num1+num2)/2;
		assertTrue(average == Util.averageOfTwoNumber(num1, num2));
	}
	@Test
	public void testAverageOfTwoNumberRationalNumberResult() {
		int num1 = 8;
		int num2 = 3;
		double average = (double) (num1+num2)/2;
		assertTrue(average == Util.averageOfTwoNumber(num1, num2));
	}
	@Test
	public void testAverageOfTwoNumberIsRationalNumberResult() {
		int num1 = 8;
		int num2 = 3;
		double average = (double) (num1+num2)/2;
		assertTrue(average == 5.5);
	}

}
