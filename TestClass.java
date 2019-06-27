import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestClass {
	
		
		//Integer Stream Test
	
		@Test
		public void testIntegerStream() {
			IntegerStream is = new IntegerStream(5);
			assertEquals(Integer.valueOf(5), is.next());
			assertEquals(Integer.valueOf(6), is.next());
			assertEquals(Integer.valueOf(7), is.next());
		}
		
		//StringStream Test
		
		@Test
		public void testStringStream() {
			StringStream s1 = new StringStream("abc");
			assertEquals("abc", s1.next());
			assertEquals("abd", s1.next());
			assertEquals("abe", s1.next());
			s1 = new StringStream("azz");
			assertEquals("azz", s1.next());
			assertEquals("baa", s1.next());
			s1 = new StringStream("zzz");
			assertEquals("zzz", s1.next());
			assertEquals("aaaa", s1.next());
		}
		
		//NotMultipleFilter Test
		
		@Test
		public void testNotMultipleFilter() {
			NotMultipleFilter f = new NotMultipleFilter(2, null);
			assertEquals(false, f.passFilter(2));
			assertEquals(false, f.passFilter(4));
			assertEquals(false, f.passFilter(6));
			f = new NotMultipleFilter(2, new NotMultipleFilter(3, null));
			assertEquals(false, f.passFilter(3));
			assertEquals(false, f.passFilter(6));
			assertEquals(true, f.passFilter(11));
		}
		
		//PalindromeFilter Test
		
		@Test
		public void testPalindromeFilter() {
			PalindromeFilter f = new PalindromeFilter(null);
			assertEquals(false, f.passFilter("ac"));
			assertEquals(false, f.passFilter("ad"));
			assertEquals(true, f.passFilter("aa"));
		}
		
		//NotMultipleStream Test
		
		@Test
		public void testNotMultipleStream() {
			NotMultipleStream s = new NotMultipleStream(2, 3);	
			assertEquals(Integer.valueOf(3), s.next());
			assertEquals(Integer.valueOf(5), s.next());
			assertEquals(Integer.valueOf(7), s.next());
		}
				
		//PalindromeStream Test
				
		@Test
		public void testPalindromeStream() {
			PalindromeStream s = new PalindromeStream("aa");
			assertEquals("aa", s.next());
			assertEquals("bb", s.next());
			assertEquals("cc", s.next());
			
		}
		
		//Prime Stream Test
		
		@Test
		public void testPrimeStream() {
			PrimeStream s = new PrimeStream();
			assertEquals(Integer.valueOf(2), s.next());
			assertEquals(Integer.valueOf(3), s.next());
			assertEquals(Integer.valueOf(5), s.next());
			assertEquals(Integer.valueOf(7), s.next());
			assertEquals(Integer.valueOf(11), s.next());
			assertEquals(Integer.valueOf(13), s.next());
		}
		
		//IntegerPair Test
		
		@Test
		public void testIntegerPair() {
			IntegerPair s = new IntegerPair(3, 4);
			assertEquals(Integer.valueOf(3), Integer.valueOf(s.getValue1()));
			assertEquals(Integer.valueOf(4), Integer.valueOf(s.getValue2()));
			assertEquals("(3, 4)", s.toString());
		}
		
		//TwinPrimeStream Test
		
		@Test
		public void testTwinPrimeStream() {
			TwinPrimeStream s = new TwinPrimeStream();
			assertEquals("(3, 5)", s.next().toString());
			assertEquals("(5, 7)", s.next().toString());
			assertEquals("(11, 13)", s.next().toString());
			
		}
		
		//MersennePrimeStream Test
		
		@Test
		public void testMersennePrimeStream() {
			MersennePrimeStream is = new MersennePrimeStream();
			assertEquals(Integer.valueOf(3), is.next());
			assertEquals(Integer.valueOf(7), is.next());
			assertEquals(Integer.valueOf(31), is.next());
		}
		
		//Test StreamUtilities class
		   
		  
		  //Test the sum method 
		  @Test
		  public void testSum(){
		    IntegerStream is1 = new IntegerStream(1);
		    assertEquals(0, StreamUtilities.sum(is1, 0));
		    IntegerStream is2 = new IntegerStream(1);
		    assertEquals(1, StreamUtilities.sum(is2, 1));
		    IntegerStream is3 = new IntegerStream(1);
		    assertEquals(15, StreamUtilities.sum(is3, 5));    
		  }
		  
		  //Test the product method
		  @Test
		  public void testProduct(){
		    IntegerStream is1 = new IntegerStream(1);
		    assertEquals(1, StreamUtilities.product(is1, 0));
		    IntegerStream is2 = new IntegerStream(1);
		    assertEquals(1, StreamUtilities.product(is2, 1));
		    IntegerStream is3 = new IntegerStream(1);
		    assertEquals(120, StreamUtilities.product(is3, 5));
		  }        
		                 
		  //Test the concatenate method
		  @Test
		  public void testConcatenate(){
		    StringStream ss1 = new StringStream("abc");
		    assertEquals("", StreamUtilities.concatenate(ss1, 0));
		    StringStream ss2 = new StringStream("abc");
		    assertEquals("abc", StreamUtilities.concatenate(ss2, 1));
		    StringStream ss3 = new StringStream("a");
		    assertEquals("abcdefghijklmnopqrstuvwxyz",StreamUtilities.concatenate(ss3, 26));
		  }
		}
}	
