package cz.vutbr.feec.cisla;

import java.security.KeyStore.Entry;
import java.util.HashSet;
import java.util.LinkedList;

public class Spustitelna {
	public static void main(String args[]) {
		final int LEFT = 0;
		final int RIGHT = 1;
		final int EMPYPOT = 0;
		final int POURPOT = 1;
		Dzbany dzbanUvod = new Dzbany();
		
		HashSet<Dzbany> closed = new HashSet<Dzbany>();
        LinkedList<Dzbany> open = new LinkedList<Dzbany>();
        
        //Pridani uvodniho dzbanu (0,0)
        open.add(dzbanUvod);
        
        while(!open.isEmpty()) {
        	Dzbany tmp = open.pop(); 
        	//Je tmp resenim?
        	if((tmp.getLeft() == 0 && tmp.getRight() == 2) || (tmp.getRight() == 0 && tmp.getLeft() == 2)) {
        		System.out.println("Mam reseni!");
        		tmp.printPots();
        		System.exit(0);
        	}
        	else {
        		closed.add(tmp);
        		//i je pro leva/prava a j je pro akce
        		for(int i = 0; i < 2; i++) {
        			for(int j = 0; j < 3; j++){
        				if(j == 2) {
        					//TODO pro prelivani dzbanu
        				}
        				else {
	        				Dzbany tmpAdd = tmp.klonujAPohni(i, j);
	        				if(!closed.contains(tmpAdd)) {
	        					System.out.println("Closed fronta pro dzban: ("+tmp.getLeft()+","+tmp.getRight()+")");
	        					for(Dzbany entry:closed ) {
	        			            entry.printPots();
	        			        }
	        					System.out.println("Pridavam dzban do open:");
	        					tmpAdd.printPots();
	        					open.addLast(tmpAdd);
	        				}
        				}
        					
        			}
        		}
        	}
        }
        System.out.println("Reseni neexistuje!");
        
				
		
	}
}
