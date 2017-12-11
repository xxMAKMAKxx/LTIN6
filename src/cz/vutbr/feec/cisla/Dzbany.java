package cz.vutbr.feec.cisla;

public class Dzbany {
	public final int LEFT = 0;
	public final int RIGHT = 1;
	public final int LEFT_MAX = 4;
	public final int RIGHT_MAX = 3; 
	
	private int leftPot = 0;
	private int rightPot = 0;
	
	public int getLeft() {
		return leftPot;
	}
	public void setLeft(int left) {
		this.leftPot = left;
	}
	public int getRight() {
		return rightPot;
	}
	public void setRight(int right) {
		this.rightPot = right;
	}
	
	public void fillPot(int whichOne) {
		if(whichOne == LEFT) {
			leftPot = LEFT_MAX;
		}
		else if(whichOne == RIGHT) {
			rightPot = RIGHT_MAX;
		}
	}
	public void emptyPot(int whichOne) {
		if(whichOne == LEFT) {
			leftPot = 0;
		}
		else if(whichOne == RIGHT) {
			rightPot = 0;
		}
	}
	public void pourPot (int from, int to) {
		if(from == LEFT && to == RIGHT) {
			this.rightPot += this.leftPot;
			if(this.rightPot > RIGHT_MAX)
				this.rightPot = RIGHT_MAX;
			this.leftPot = 0;
		}
		else if(from == RIGHT && to == LEFT) {
			this.leftPot += this.rightPot;
			if(this.leftPot > LEFT_MAX)
				this.leftPot = LEFT_MAX;
			this.rightPot = 0;
		}
		else {
			System.out.println("Chyba, neplatna operace");
		}
	}
	
	public void printPots() {
		System.out.println("("+this.leftPot+","+this.rightPot+")");
	}
}
