package br.unicamp.ic.mc322.teste1;

import java.lang.Math;

public class Position {
	private int x;
	private int y;
	
	public Position(int theX, int theY) {
		x = theX;
		y = theY;
	}
	
	public double calculateDistance(Position p) {
		double sub1 = this.x - p.x;
		double sub2 = this.y - p.y;
		
		double sum = Math.pow(sub1, 2) + Math.pow(sub2, 2);
		double result = Math.sqrt(sum);
		
		return result;
	}
}
