import spock.lang.*;

class AnimationTest extends Specification{

	@Unroll
	def "test animation. init: #init. speed: #speed"(){
		expect:
		Animation.animate(speed, init) == result
		
		where:
		speed | init     | result
		2 	  | '...'    | ['...']
		1	  | 'R..'    | ['X..', '.X.', '..X', '...']
		1	  | '..L'    | ['..X', '.X.', 'X..', '...']
		1	  | 'R..L'   | ['X..X', '.XX.', '.XX.', 'X..X','....']
		2	  | '..R....' | ['..X....', '....X..', '......X','.......']
	}
}
