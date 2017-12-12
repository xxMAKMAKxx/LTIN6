package cz.vutbr.feec.cisla;

import java.util.HashSet;

public class Spustitelna {
	public static void main(String args[]) {
		final int LEFT = 0;
		final int RIGHT = 1;
		Dzbany d1 = new Dzbany();
		Dzbany d2 = new Dzbany();
		d2.fillPot(LEFT);
		
		HashSet<Dzbany> set = new HashSet<Dzbany>();
		set.add(d1);
		set.add(d2);
		
		
		System.out.println("Pocet prvku v mnozine je: "+set.size() + "\n"+ set);
	}
}
