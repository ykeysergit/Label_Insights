import spock.lang.*;

class AnimationTest extends Specification{

	@Unroll
	def "test animation. init: #init. speed: #speed"(){
		expect:
		Animation.animate(speed, init) == result
		
		where:
		speed | init         		  | result
		1 	  | '...'        		  | ['...']
		1	  | 'R..'        		  | ['X..', '.X.', '..X', '...']
		1	  | '..L'        		  | ['..X', '.X.', 'X..', '...']
		1	  | 'R..L'       		  | ['X..X', '.XX.', '.XX.', 'X..X','....']
		2	  | '..R....'    		  | ['..X....', '....X..', '......X','.......']
		3	  | 'RR..LRL'     		  | ['XX..XXX', '.X.XX..','X.....X', '.......']
		10	  | 'RLRLRLRLRL' 		  | ['XXXXXXXXXX', '..........']
		1	  | 'LRRL.LR.LRR.R.LRRL.' | [ "XXXX.XX.XXX.X.XXXX.","..XXX..X..XX.X..XX.",".X.XX.X.X..XX.XX.XX","X.X.XX...X.XXXXX..X",
										  ".X..XXX...X..XX.X..", "X..X..XX.X.XX.XX.X.", "..X....XX..XX..XX.X", ".X.....XXXX..X..XX.",
										  "X.....X..XX...X..XX", ".....X..X.XX...X..X", "....X..X...XX...X..", "...X..X.....XX...X.", 
										  "..X..X.......XX...X", ".X..X.........XX...", "X..X...........XX..", "..X.............XX.", 
										  ".X...............XX", "X.................X", "..................." 
									    ]
	}
}