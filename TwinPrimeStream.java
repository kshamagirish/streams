/** a stream that returns integer pairs that represent twin primes 
 * @author kshama girish 
 */
public class TwinPrimeStream implements Stream<IntegerPair>{
	
	//Instance Variables
	
	PrimeStream stream1 = new PrimeStream();
	PrimeStream stream2 = new PrimeStream();
	
	//Constructor
	/**
	 * creates a stream that returns sequential twin primes
	 */
	
	
	public TwinPrimeStream() {
		stream2.next();
	}

	
	//Iteration Method
	public IntegerPair next() {
		
		int prime1 = stream1.next();
		int prime2 = stream2.next();
		int difference = prime2 - prime1;
		
		//While the primes are not 2 apart, it iterates through the prime streams
		while(difference != 2) {
			prime1 = stream1.next();
			prime2 = stream2.next();
			difference = prime2 - prime1;
		}
		return new IntegerPair(prime1, prime2);
	}

}
