package cz.vutbr.feec.cisla;

import java.util.ArrayList;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class Dzbany implements Comparable<Dzbany>{
	//Deklarace promennych pro snadnejsi orientaci
	public final int LEFT = 0;
	public final int RIGHT = 1;
	public final int LEFT_MAX = 4;
	public final int RIGHT_MAX = 3; 
	public final int EMPTYPOT = 0;
	public final int FILLPOT = 1;
	public final int POURPOT = 2;
	
	public ArrayList<Dzbany> pohyby = new ArrayList<Dzbany>();
	
	private int leftPot = 0;
	private int rightPot = 0;
	
	//Gettery a settery
	public ArrayList<Dzbany> getPohyby() {
		return this.pohyby;
	}
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
			//Check jestli se muze provest
			if(this.leftPot == this.LEFT_MAX && this.rightPot == this.RIGHT_MAX)
				return;
			int tmpRightPot = this.rightPot;
			this.rightPot += this.leftPot;
			if(this.rightPot > RIGHT_MAX)
				this.rightPot = RIGHT_MAX;
			if(tmpRightPot == 0)
				this.leftPot -= this.leftPot;
			else
				this.leftPot = this.leftPot-(this.rightPot-this.leftPot);
			correctPots();
		}
		else if(from == RIGHT && to == LEFT) {
			//Check jestli se muze provest
			if(this.leftPot == this.LEFT_MAX && this.rightPot == this.RIGHT_MAX)
				return;
			int tmpLeftPot = this.leftPot;
			this.leftPot += this.rightPot;
			if(this.leftPot > LEFT_MAX)
				this.leftPot = LEFT_MAX;
			if(tmpLeftPot == 0)
				this.rightPot -= this.rightPot;
			else
				this.rightPot = this.rightPot-(this.leftPot-this.rightPot);
			correctPots();
		}
		else {
			System.out.println("Chyba, neplatna operace");
		}
	}
	
	public void correctPots() {
		if(this.leftPot < 0)
			this.leftPot = 0;
		if(this.leftPot > 4)
			this.leftPot = 4;
		if(this.rightPot < 0)
			this.rightPot = 0;
		if(this.rightPot > 3)
			this.rightPot = 3;
	}
	
	public Dzbany klonujAPohni(int kteryDzban, int akce) {
		Dzbany nove = new Dzbany();
		nove.leftPot = this.leftPot;
		nove.rightPot = this.rightPot;
		
		nove.pohyby.addAll(this.pohyby);
		Integer tmpPole[] = new Integer[2];
		tmpPole[0] = kteryDzban;
		tmpPole[1] = akce;
		nove.pohyby.add(this);
		
		if(akce == EMPTYPOT) {
			nove.emptyPot(kteryDzban);
		}
		else if(akce == FILLPOT) {
			nove.fillPot(kteryDzban);
		}
		else if(akce == POURPOT) {
			nove.pourPot(kteryDzban, ((kteryDzban+1)%2));
		}
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
	
	public String translatePot(int pot) {
		if(pot == LEFT)
			return "levy";
		else
			return "pravy";
	}
	
	public String translateAction(int action) {
		if(action == EMPTYPOT)
			return "vyprazdni dzban";
		else if(action == FILLPOT)
			return "napln dzban vodou";
		else
			return "prelij z jednoho dzbanu do druheho";
	}
}
