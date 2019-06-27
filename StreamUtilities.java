/**
 * Has methods that have specific functions that act upon streams
 * @author kshama girish
 *
 */
public class StreamUtilities {
	
	/* Prints out a given number of values for any stream.
	 * @param stream: stream of any type
	 * @param iterations: number of iterations
	 */
	public static void print(Stream<?> stream, int iterations) {
		for(int i = 0; i < iterations; i++) {
			System.out.println(stream.next());
		}
	}
	
	/*Returns the sum of the integers in a stream.
	 * @param stream: Integer Stream
	 * @param iterations: number of iterations
	 */
	public static int sum(Stream<Integer> stream, int iterations) {
		int result = 0;
		for(int i = 0; i < iterations; i++) {
			result += stream.next();
		}
		return result;
	}
	
	/*returns the product of the integers in a stream
	 * @param stream: Integer Stream
	 * @param iterations: number of iterations
	 */
	public static int product(Stream<Integer> stream, int iterations) {
		int result = 1;
		for(int i = 0; i < iterations; i++) {
			result *= stream.next();
		}
		return result;
	}
	
	/*returns the concatenated form of strings in a stream.
	 * @param stream: Integer Stream
	 * @param iterations: number of iterations
	 */
	public static String concatenate(Stream<String> stream, int iterations) {
		String result = "";
		for(int i = 0; i < iterations; i++) {
			result += stream.next();
		}
		return result;
	}
		

}
