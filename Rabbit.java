public class Rabbit extends Animal {
	private boolean canSeeBush = false;
	private int directionToBush;
	private int distanceFromBush = (Model.MAX_DIRECTION +1) ;
	private boolean canSeeFox =false;
	private boolean hasSeenFox;
	private int distanceFromFox = (Model.MAX_DIRECTION +1);
	private int directionOfFox;
	private int currentDirection;
	private boolean validBush;
	private boolean hasPickedBush;
	
    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }
    
    
    int decideMove() {

    	//look for closest bush
    	canSeeBush = false;
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            	if (look(i) == Model.BUSH) {
            		hasPickedBush = canSeeBush = true;
                    if(distance(i)<distanceFromBush) {  	
                    	currentDirection = directionToBush = i;
                distanceFromBush = distance(i);
            }
            	}
            
        }   
      //look for fox
        canSeeFox = false;
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
        if (look(i) == Model.FOX) {
            hasSeenFox = canSeeFox = true;
            distanceFromFox = distance(i);
            directionOfFox = i;
        }
       
		}
        

    	//move in direction of bush until reaching bush
        if (canSeeBush) {
            if (distanceFromBush > 0) {
            	distanceFromBush--;
                return directionToBush;
            
        	 // if at bush on NSEW, stay until fox is 2 spaces away, 
            }else if (distanceFromBush == 0 && distanceFromFox >1 && (directionToBush == 0 || 
            		directionToBush ==2 || directionToBush == 4 || directionToBush == 6)) {
            
           
            	return Model.STAY;
            
            }
      //if not NSEW, move
            	else 	if (distanceFromBush == 0 && distanceFromFox >1 && (directionToBush == 1 ||
            
            		directionToBush ==3 || directionToBush == 5 || directionToBush == 7)) {
            
        				directionToBush = Model.turn(directionToBush, -1);
                        return Model.turn(directionToBush, 2);
                		
        
                 
            } //circle bush in opposite direction of fox approach, if cant see fox stay, 
            else if (distanceFromBush == 0 && distanceFromFox == 1 && canSeeFox ) {
            		if (directionToBush == 0 && (directionOfFox == 1 || directionOfFox == 2)) {
            				directionToBush = Model.turn(directionToBush, 2);
            				return Model.turn(directionToBush, -3);
            			}else if (directionToBush == 0) {
            				directionToBush = Model.turn(directionToBush, -2);
        					return Model.turn(directionToBush, 3);
                		}else if (directionToBush == 1) {
                			directionToBush = Model.turn(directionToBush, -1);
                			return Model.turn(directionToBush, 2);
                		}
            		else if (directionToBush == 2 && (directionOfFox == 7 || directionOfFox == 0 || directionOfFox == 1)) {
        				directionToBush = Model.turn(directionToBush, -2);
    					return Model.turn(directionToBush, 3);
                		}
            		else if (directionToBush == 2) {
        				directionToBush = Model.turn(directionToBush, 2);
    					return Model.turn(directionToBush, -3);
                		}
            		else if (directionToBush == 4 && (directionOfFox == 1 || directionOfFox ==2 || directionOfFox == 3)) {
        				directionToBush = Model.turn(directionToBush, -2);
        				return Model.turn(directionToBush, 3);
            		}
            		else if (directionToBush == 4) {
        				directionToBush = Model.turn(directionToBush, 2);
    					return Model.turn(directionToBush, -3);
                		}else if (directionToBush == 5) {
            				directionToBush = Model.turn(directionToBush, -1);
                            return Model.turn(directionToBush, 2);
                    		}
                		else if (directionToBush == 6 && (directionOfFox == 4 || directionOfFox == 5)) {
            				directionToBush = Model.turn(directionToBush, -2);
        					return Model.turn(directionToBush, 3);
                    		}
                		else if (directionToBush == 6) {
            				directionToBush = Model.turn(directionToBush, 2);
        					return Model.turn(directionToBush, -3);
                    		}
                		else if (directionToBush == 7) {
            				directionToBush = Model.turn(directionToBush, -1);
                            return Model.turn(directionToBush, 2); 
                    		}
            } else if (distanceFromBush == 0 && distanceFromFox ==1 && hasSeenFox && !canSeeFox) {
            return Model.STAY;
            }
        
          
        
    	

    	
  
       
   
        }

      	//if no bush in sight, move random
        return Model.random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);
      
}}

          

