/** represents a sequence in string in lexigraphical order
 * @author kshama girish
 *
 */
public class StringStream implements Stream<String> {

	//Instance Variables
	
	private String currentString;
	private boolean initialReturned = false;
	
	/** creates a new string
	 * @param  the string to be inputed
	 */
	
	public StringStream(String value) {
		
		char[] c = value.toCharArray();
		for(int i = 0; i < c.length; i++) {
			if(Character.isLowerCase(c[i])) {
				
			} else {
				value = "a";
			}
		}
		
		currentString = value;
	}
	
	//Incrementation 
	
	/*Returns the next String method 
	 *@return the next string method in the lexigraphical order
	 */
	public String next() {
		
		//If the first value has not been returned yet.
		if(!initialReturned) {
			initialReturned = true;
			return currentString;
		} else {
			//Main Incrementation Algorithm.
			
			//Case: String of length 1.
			if(currentString.length() == 1) {
				
				//Case: character is z.
				if(currentString.charAt(0) == 'z') {
					currentString = "aa";
					return currentString;
					
				//Case: character is not z.
				} else {
					
					char c = currentString.charAt(0);
					c =  (char) (((int) c) + 1);
					currentString = currentString.substring(0,currentString.length() - 1);
					currentString += c;
					return currentString;
				}
				
			//Case: String has length greater than 1.	
			} else {
				
				//Case: Multiple Z's at the end of string.
				if(currentString.charAt(currentString.length() - 1) == 'z' && currentString.charAt(currentString.length() - 2) == 'z') {
					
					StringBuilder sb = new StringBuilder(currentString);
					sb.reverse();
					
					int counter = 0;
					for(int i = 0; i < sb.length(); i++) {
						if(sb.charAt(i) == 'z') {
							counter++;
						}
					}
					
					sb.reverse();
					sb.delete(sb.length()-counter, sb.length());
					
					if(sb.length() == 0) {
						for(int j = counter+1; j != 0; j--) {
							sb.append('a');
						}
						currentString = sb.toString();
						return currentString;
					} else {
						char c = sb.charAt(sb.length()-1);
						c =  (char) (((int) c) + 1);
						sb.deleteCharAt(sb.length()-1);
						sb.append(c);
						
						for(int j = counter; j != 0; j--) {
							sb.append('a');
						}	
						currentString = sb.toString();
						return currentString;
					}
					
				//Case: only 1 z at the end.
				} else if(currentString.charAt(currentString.length() - 1) == 'z') {
					StringBuilder sb = new StringBuilder();
					for(int i = 0; i < currentString.length() - 1; i++) {
						sb.append(currentString.charAt(i));
					}
					char secondToLast = sb.charAt(sb.length() - 1);
					sb.deleteCharAt(sb.length() - 1);
					sb.append((char) ((int) secondToLast + 1));
					sb.append('a');
					currentString = sb.toString();
					return currentString;
				//Case: character at end is not z.
				} else {
					char c = currentString.charAt(currentString.length() - 1);
					c =  (char) (((int) c) + 1);
					currentString = currentString.substring(0,currentString.length() - 1);
					currentString += c;
					return currentString;
				}
			}
		}
	}

}

