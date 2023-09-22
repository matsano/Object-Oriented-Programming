package com.unicamp.mc322.lab06;

public class Song extends Entretenimento {
	
	public Song(String theName, String theArtist, int time) {
		super(theName, theArtist, time);
		armazenamento = calcularArmazenamento();
	}
	
	public double calcularArmazenamento() {
		return 5*getDuracao()/60.0;
	}
}