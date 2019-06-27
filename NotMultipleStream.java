/*Represents a stream of integers that are not multiples of the base value
 * @author Kshama Girish
 */
public class NotMultipleStream implements Stream<Integer>{
	
	//Instance Variables
	
	IntegerStream stream;
	NotMultipleFilter filter;
	
	/*Creates a stream of integers that are not multiples of the base value
	 * @param baseValue the divisor to be used in the filter
	 * @param initialValue
	 */
	
	public NotMultipleStream(int baseValue, int initialValue) {
		stream = new IntegerStream(initialValue);
		filter = new NotMultipleFilter(baseValue, null);
	}
	
	/*Returns the next int value that is not a multiple of the base value
	 * @return next value that is not the the multiple of the base value
	 */
	public Integer next() {
		
		int value = stream.next();
		
		//Checks every value until one that passes the filter is found.
		while(!filter.passFilter(value)) {
			value = stream.next();
		}
		return value;
	}
}
