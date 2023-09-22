package com.unicamp.mc322.lab06;

public class Video extends Entretenimento {
	
	private int numeroPixels;
	private double quadrosPorSegundo;
	
	public Video(String theName, String theArtist, int time, int quantidadePixels, double fps) {
		super(theName, theArtist, time);
		numeroPixels = quantidadePixels;
		quadrosPorSegundo = fps;
		armazenamento = calcularArmazenamento();
	}
	
	public double calcularArmazenamento() {
		return 5*getDuracao()/60.0 + 0.000001*this.numeroPixels*this.quadrosPorSegundo*getDuracao()/60.0;
	}

}
