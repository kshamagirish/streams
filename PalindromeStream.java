/*represents a stream of strings in lexigraphical order
 * @author Kshama Girish
 */
public class PalindromeStream implements Stream<String>{
	
	//Instance Variables

	StringStream stream;
	PalindromeFilter filter;
	
	//Constructor
	/*creates an object that gives a stream of palindrome
	 * @param initialValue the initial string that the stream begins from
	 */
	
	public PalindromeStream(String s) {
		stream = new StringStream(s);
		filter = new PalindromeFilter(null);
	}
	
	//Iteration method
	/**returns the next palindrome
	 * @return the next string in lexicographical order
	 */
	
	public String next() {
		
		String value = stream.next();
		//Iterates the stream until a value is found which passes the filter.
		while(!filter.passFilter(value)) {
			value = stream.next();
		}
		return value;
	}
}
