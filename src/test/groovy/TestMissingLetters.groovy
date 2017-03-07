import spock.lang.*;

class TestMissingLetters extends Specification {
	
	@Unroll
	def "missing letters. Input: #input. Output: #output"(){
		expect:
		MissingLetters.getMissingLetters(input) == output
		
		where:
		input 	 					     | output
		null  	 						 | "abcdefghijklmnopqrstuvwxyz"
		"1"	  	 						 | "abcdefghijklmnopqrstuvwxyz"
		"\u20AC" 						 | "abcdefghijklmnopqrstuvwxyz"
		""	  	 						 | "abcdefghijklmnopqrstuvwxyz"
		"a"	  	 						 | "bcdefghijklmnopqrstuvwxyz"
		"ab"	  	 					 			| "cdefghijklmnopqrstuvwxyz"
		"abcdefghijklmnopqrstuvwxy"	  	 			| "z"
		"abcdefghijklmnopqrstuvwxyz"	 			| ''
		"ABcdefghijklmnopqrstuvwxyz"	 			| ''
		'A quick brown fox jumps over the lazy dog' | ''	
	}
}
