package cz.vutbr.feec.cisla;

public class Spustitelna {
	public static void main(String args[]) {
		final int LEFT = 0;
		final int RIGHT = 1;
		Dzbany dzbany = new Dzbany();
		dzbany.fillPot(RIGHT);
		dzbany.pourPot(RIGHT, LEFT);
		dzbany.fillPot(RIGHT);
		dzbany.pourPot(RIGHT, LEFT);
		dzbany.printPots();
		
	}
}
