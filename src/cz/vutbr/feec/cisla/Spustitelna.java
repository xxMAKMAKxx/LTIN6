package cz.vutbr.feec.cisla;

import java.util.HashSet;
import java.util.LinkedList;

public class Spustitelna {
	public static void main(String args[]) {
		final int LEFT = 0;
		final int RIGHT = 1;
		Dzbany dzbanUvod = new Dzbany();
		dzbanUvod.setLeft(2);
		
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
        }
        System.out.println("Reseni neexistuje!");
				
		
	}
}
