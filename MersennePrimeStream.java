/*Represents a stream of Mersenne prime numbers
 * @author Kshama Girish
 */

public class MersennePrimeStream implements Stream<Integer>{
	
	//Instance Variables
	
	PrimeStream stream = new PrimeStream();

	//Constructor
	
	public MersennePrimeStream() {
		
	}
	
	//iteration Method
	
	public Integer next() {
		
		boolean primeFound = false;
		int value = 0;
		
		//Checks every value until a mersenne prime is found
		while(!primeFound) {
			value = stream.next();
			int checkValue = value+1;
			int power = 0;
			
			//Checks every possible power until it can't be a mersenne prime.
			for(int i = 0;; i++) {
				power = (int) Math.pow(2, i);
				
				//Case: Cant be a Mersenne Prime
				if(power > checkValue) {
					break;
					
				//Case: Mersenne Prime Found
				} else if(power == checkValue) {
					primeFound = true;
				}
				
			}
		}
		return value;
	}
}
