/*Represents a filter that is able to keep values that are not a multiple of the inputted diviro value
 * @author Kshama Girish
 */
public class NotMultipleFilter implements Filter<Integer>{
	
	//Instance Variables, stores the base value of the filter
	
	private int baseValue;
	private Filter<Integer> upstreamFilter;

	/*Creates a filter that returns value that is not a multiple of the base value
	 * @param baseValue is the divisor for the filter
	 * @param f is the upstream filters of this filter
	 */
	
	public NotMultipleFilter(int base, Filter<Integer> f) {
		baseValue = base;
		upstreamFilter = f;
		
	}
	
	/* returns true if the value is not divisible by the base value
	 * @param the value to be tested in the filter
	 * @return whether the value is not a multiple of the divisor
	 */
	
	public boolean passFilter(Integer value) {
		
		//Checks if this is the root filter.
		if(upstreamFilter == null) {
			
			//If the value is not divisible by the base value, then it returns true.
			if(!(value % baseValue == 0)) {
				return true;
			} else {
				return false;
			}
		}
		
		//Checks for divisibility and if it passes the upstream filter as well.
		if(!(value % baseValue == 0) && upstreamFilter.passFilter(value)) {
			return true;
		} else {
			return false;
		}
	
	}

}
