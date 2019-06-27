/** represents a stream of int value that are prime numbers
 * @author kshama girish
 */
public class PrimeStream implements Stream<Integer>{
	
	//Instance Variables

	private int currentPrime = 2;
	private boolean initialReturned = false;
	NotMultipleFilter topFilter;
	IntegerStream s = new IntegerStream(currentPrime+1);
	
	//Constructor
	/** creates a stream that returns only prime numbers
	 */
	
	public PrimeStream() {
		
	}
	
	//Iteration method
	
	public Integer next() {
		//Checks if the first prime has been returned.
		if(!initialReturned) {
			initialReturned = true;
			topFilter = new NotMultipleFilter(currentPrime, null);
			return currentPrime;
		} else {
			
			int value = s.next();
			/*
			 * Searches for a value which passes all filters
			 * iterates through an integer stream. 
			 * if the integer fails to pass all the filters, a filter of itself is added on top
			 */
			while(!topFilter.passFilter(value)) {
				topFilter = new NotMultipleFilter(value, topFilter);
				value = s.next();
			}
			topFilter = new NotMultipleFilter(value, topFilter);
			return value;
		}
	}
}
