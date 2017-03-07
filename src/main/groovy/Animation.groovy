class Animation {
	static String[] animate(int speed, String init){
		Chamber chamber=new Chamber(dim: init.length())
		chamber.positionHistory << ([] as HashMap)
		
		for(int i=0;i<init.length();i++){
			def newParticle=null
			
			if(init.charAt(i) == (char)Particle.LEFT){
				newParticle = new Particle(direction: Particle.LEFT, speed: speed, chamber: chamber, position: i)
			}
			else if(init.charAt(i) == (char)Particle.RIGHT){
				newParticle = new Particle(direction: Particle.RIGHT, speed: speed, chamber: chamber, position: i)
			}
			
			if(newParticle){
				chamber.particles << newParticle
				chamber.positionHistory.first[(newParticle)]=i
			}
		}	
		
		// Base case: no particles
		if(!chamber.particles){
			return [init]
		}	
		
		boolean anyInChamber=true
		
		while(anyInChamber){
			chamber.addNewSnapshot()
			
			anyInChamber=false
			
			chamber.particles.each { particle ->
				particle.move()	
				boolean isInChamber = particle.isInChamber()
				anyInChamber |= isInChamber
				chamber.positionHistory.last[(particle)] = particle.position
			}
		}
		
		chamber.summarizeMovement()
	}
}
