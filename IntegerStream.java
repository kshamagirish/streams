/**
 * Class represents a stream of integers
 * @author Kshama Girish
 *
 */


public class IntegerStream implements Stream<Integer> {
	/**
	 * Constructor taking the initial value of the stream
	 * @param the integer initial value
	 */
		
	private int currentInt;
	
	//Constructor
	
	public IntegerStream(int value) {
		currentInt = value - 1;
	}
	
	/**
	 * Method incrementing the stream to the next sequential integer
	 * @return the next value in the stream
	 */
	
	public Integer next() {
		currentInt++;
		return currentInt;
	}

}
