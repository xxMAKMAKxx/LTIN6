package cz.vutbr.feec.cisla;

import java.util.HashSet;
import java.util.LinkedList;

public class Spustitelna {
	public static void main(String args[]) {
		final int LEFT = 0;
		final int RIGHT = 1;
		final int LEFT_MAX = 4;
		final int RIGHT_MAX = 3; 
		final int EMPTYPOT = 0;
		final int FILLPOT = 1;
		final int POURPOT = 2;
		Dzbany dzbanUvod = new Dzbany();
		
		HashSet<Dzbany> closed = new HashSet<Dzbany>();
        LinkedList<Dzbany> open = new LinkedList<Dzbany>();
        
        //Pridani uvodniho dzbanu (0,0)
        open.add(dzbanUvod);
        
        //TESTING START
        /*
        dzbanUvod.fillPot(RIGHT);
        dzbanUvod.pourPot(RIGHT, LEFT);
        dzbanUvod.fillPot(RIGHT);
        dzbanUvod.printPots();
        dzbanUvod.pourPot(RIGHT, LEFT);
        dzbanUvod.printPots();
        dzbanUvod.emptyPot(LEFT);
        
        dzbanUvod.printPots();
        */
        //TESTING END
        
        
        while(!open.isEmpty()) {
        	Dzbany tmp = open.pop(); 
        	//Je tmp resenim?
        	if((tmp.getLeft() == 0 && tmp.getRight() == 2) || (tmp.getRight() == 0 && tmp.getLeft() == 2)) {
        		System.out.println("Mam reseni!");
        		tmp.printPots();
        		System.exit(0);
        	}
        	else {
        		//DEBUG START
        		System.out.println("Closed fronta pro dzban: ("+tmp.getLeft()+","+tmp.getRight()+")");
				for(Dzbany entry:closed ) {
		            entry.printPots();
		        }
				//DEBUG END
        		//i je pro leva/prava a j je pro akce
        		for(int i = 0; i < 2; i++) {
        			for(int j = 0; j < 3; j++){
        				if(j == 2) {
        					Dzbany tmpAdd = tmp.klonujAPohni(i, j);
	        				if(!closed.contains(tmpAdd)) {
	        					System.out.println("Pridavam dzban do open:");
	        					tmpAdd.printPots();
	        					open.addLast(tmpAdd);
	        				}
        				}
        				else {
	        				Dzbany tmpAdd = tmp.klonujAPohni(i, j);
	        				if(!closed.contains(tmpAdd)) {
	        					System.out.println("Pridavam dzban do open:");
	        					tmpAdd.printPots();
	        					open.addLast(tmpAdd);
	        					closed.add(tmpAdd);
	        				}
        				}
        					
        			}
        		}
        	}
        	System.out.println("Open fronta pro dzban: ("+tmp.getLeft()+","+tmp.getRight()+")");
			for(Dzbany entry:open) {
	            entry.printPots();
	        }
        }
        System.out.println("Reseni neexistuje!");
        
				
		
	}
}
