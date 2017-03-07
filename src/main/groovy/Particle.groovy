class Particle{
	static String LEFT='L', RIGHT='R';
	String direction=''
	int speed=0
	Chamber chamber;
	int position=-1;
	
	def move(){
		if(direction == Particle.LEFT){
			moveLeft()
		}
		else if(direction == Particle.RIGHT){
			moveRight()
		}
	}
	
	String toString(){
		[hashCode: hashCode(), speed: speed, position: position, direction: direction].toString()
	}
	
	boolean isInChamber(){
		position >=0 && position < chamber.dim
	}
	
	boolean moveLeft(){
		if(position >= 0){
			position -= speed
			return true
		}
		
		return false
	}
	
	boolean moveRight(){
		if(position < chamber.dim){
			position += speed
			return true
		}
		
		return false
	}
}