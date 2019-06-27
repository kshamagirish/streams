/**Represents a pair of integer values
 * @author Kshama Girish
 */

public class IntegerPair {

	//the first value of pair
	
	private int num1;
	
	//the second value of the pair
	private int num2;
	
	/*
	 * creates an object that can represents a pair of integers
	 * @param value1 for the first value
	 * @param value2 for the second value
	 */
	
	public IntegerPair(int x, int y) {
		num1 = x;
		num2 =y;
	}
	
	/*Returns the first number
	* @return the first value
	*/
	
	public int getValue1() {
		return num1;
	}
	
	/*Returns the value of the second number
	 * @return the second value
	 * 	
	 */
	public int getValue2() {
		return num2;
	}
	
	/*Returns the pair as coordinate pairs. e.g: (3,4).
	 * @returns as pair
	 */
	public String toString() {
		return "(" + num1 + ", " + num2 + ")";
	}
}
