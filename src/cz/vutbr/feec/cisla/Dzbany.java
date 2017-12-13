package cz.vutbr.feec.cisla;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class Dzbany implements Comparable<Dzbany>{
	public final int LEFT = 0;
	public final int RIGHT = 1;
	public final int LEFT_MAX = 4;
	public final int RIGHT_MAX = 3; 
	public final int EMPTYPOT = 0;
	public final int FILLPOT = 1;
	public final int POURPOT = 2;
	
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
			this.leftPot = this.leftPot-(this.rightPot-this.leftPot);
			if(this.leftPot < 0)
				this.leftPot = 0;
			if(this.leftPot > 4)
				this.leftPot = 4;
		}
		else if(from == RIGHT && to == LEFT) {
			this.leftPot += this.rightPot;
			if(this.leftPot > LEFT_MAX)
				this.leftPot = LEFT_MAX;
			this.rightPot = this.rightPot-(this.leftPot-this.rightPot);
			if(this.rightPot < 0)
				this.rightPot = 0;
			if(this.rightPot > 3)
				this.rightPot = 3;
		}
		else {
			System.out.println("Chyba, neplatna operace");
		}
	}
	
	public Dzbany klonujAPohni(int kteryDzban, int akce) {
		Dzbany nove = new Dzbany();
		nove.leftPot = this.leftPot;
		nove.rightPot = this.rightPot;
		
		if(akce == EMPTYPOT) {
			nove.emptyPot(kteryDzban);
		}
		else if(akce == FILLPOT) {
			nove.fillPot(kteryDzban);
		}
		else if(akce == POURPOT) {
			nove.pourPot(kteryDzban, ((kteryDzban+1)%2));
		}
		//TODO pridej historii "tahu"
		//nove.pohyby.addAll(this.pohyby);
		//nove.pohyby.add(smer);
		//TODO potencionalne check kroku/tahu
		return nove;
	}
	
	public void printPots() {
		System.out.println("("+this.leftPot+","+this.rightPot+")");
	}
	
	@Override
	public boolean equals(Object obj) {
		Dzbany dzban = (Dzbany) obj;
		return compareTo(dzban) == 1;
	}
	@Override
	public int compareTo(Dzbany dzban) {
		if(this.leftPot == dzban.leftPot && this.rightPot == dzban.rightPot)
			return 1;
		else
			return 0;
	}
	
	@Override
	public int hashCode() {
		HashCodeBuilder h = new HashCodeBuilder();
		h.append(leftPot);
		h.append(rightPot);
		return h.toHashCode();
	}
}
