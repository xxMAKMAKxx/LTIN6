package cz.vutbr.feec.cisla;

import java.util.HashSet;
import java.util.LinkedList;

public class Spustitelna {
	public static void main(String args[]) {
		final int HLEADNA_HODNOTA = 2;
		Dzbany dzbanUvod = new Dzbany();
		
		HashSet<Dzbany> closed = new HashSet<Dzbany>();
        LinkedList<Dzbany> open = new LinkedList<Dzbany>();
        
        //Pridani uvodniho dzbanu (0,0)
        open.add(dzbanUvod);
        
        while(!open.isEmpty()) {
        	Dzbany tmp = open.pop(); 
        	//Je tmp resenim? pokud ano vypis dzban a historii
        	if((tmp.getLeft() == 0 && tmp.getRight() == HLEADNA_HODNOTA) || (tmp.getRight() == 0 && tmp.getLeft() == HLEADNA_HODNOTA)) {
        		System.out.println("Mam reseni!");
        		tmp.printPots();
        		System.out.println("Historie je: ");
        		int tmpCounter = 1;
        		for(Dzbany entry: tmp.getPohyby()) {
		            System.out.println("Krok "+tmpCounter+": "+"("+entry.getLeft()+","+entry.getRight()+")");
		            tmpCounter++;
		        }
        		System.out.println("Krok "+tmpCounter+": "+"("+tmp.getLeft()+","+tmp.getRight()+")");
        		System.exit(0);
        	}
        	else {
        		//i je pro leva/prava a j je pro akce
        		for(int i = 0; i < 2; i++) {
        			for(int j = 0; j < 3; j++){
        				Dzbany tmpAdd = tmp.klonujAPohni(i, j);
        				if(!closed.contains(tmpAdd)) {
        					open.addLast(tmpAdd);
        					closed.add(tmpAdd);
        				}
        					
        			}
        		}
        	}
        }
        System.out.println("Reseni neexistuje!");
	}
}
