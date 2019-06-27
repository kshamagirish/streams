/*Represents a filter that check the input to see if the input string is a palindrome
 * @author Kshama Girish
 */
public class PalindromeFilter implements Filter<String> {
	
	/*Creates a filter that checks if the input string is a palindrome
	 * @param f the upstream filter
	 */
	
	private Filter<String> upstreamFilter;
	
	//Constructor
	
	public PalindromeFilter(Filter<String> f) {
		upstreamFilter = f;
	}
	
	
	/*returns true if the input String is a palindrome
	 * returns false if it is not a palindrome
	 * @param the input String to be checked 
	 * @return if the input String is palindrome
	 */
	
	public boolean passFilter(String str) {
		
		//Checks if this is the root filter.
		if(upstreamFilter == null) {
			//If it is a palindrome, it returns true.
			if(str.equals(new StringBuilder(str).reverse().toString())) {
				return true;
			} else {
				return false;
			}
		}
		//Checks if it is a palindrome AND if it passes the upstream filter.
		if(str.equals(new StringBuilder(str).reverse().toString()) && upstreamFilter.passFilter(str)) {
			return true;
		} else {
			return false;
		}
	}
}
