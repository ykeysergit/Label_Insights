class Chamber{
	static String OCCUPIED='X', EMPTY='.'

	def particles = [] as LinkedList
	int dim=0
	
	// [{particle1: position1, particle2: position2, ...}, ...]
	def positionHistory=[] as LinkedList
	
	static StringBuilder createEmptyChamber(final int dim){
		StringBuilder builder = new StringBuilder()
		
		for(iter in 0..(dim-1)){
			builder.append(EMPTY)
		}
		
		return builder
	}
	
	static String populateLocations(final def particleSnapshots, final int dim){
		final StringBuilder emptyChamber = new StringBuilder(createEmptyChamber(dim))
		
		particleSnapshots.each { key, value ->
			if(value >=0 && value < dim){ 
				emptyChamber.putAt(value..value, OCCUPIED)
			}
		}
		
		emptyChamber.toString()	
	}
	
	def addNewSnapshot(){
		positionHistory << ([] as HashMap)
	}
	
	String[] summarizeMovement(){
		final def summary=[] as LinkedList
		
		positionHistory.each { particleSnapshots -> 			
			summary << populateLocations(particleSnapshots, dim)
		}
		
		summary
	}
}