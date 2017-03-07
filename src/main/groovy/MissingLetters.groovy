class MissingLetters {
	static final String engChars = 'abcdefghijklmnopqrstuvwxyz'
	
	static final Closure isEngChar = {
		(char)it  >= 'a' && (char)it <= (char)'z' ||
		(char)it >= 'A' && (char)it <= (char)'Z'
	
		}
	
	static String getMissingLetters(String line = ""){
		final Set engSet = []
		
		if(!line) return engChars
		
		for(aChar in engChars){
			engSet << aChar
		}
		
		for(aChar in line.toString()){
			if(isEngChar(aChar) && engSet.contains(aChar.toLowerCase())){
				engSet=engSet.minus(aChar.toLowerCase());	
			}
		}

		engSet.toList().join()
	}
}
