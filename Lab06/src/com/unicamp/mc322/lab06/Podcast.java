package com.unicamp.mc322.lab06;

public class Podcast extends Entretenimento {
	
	private int numeroEpisodios;
	
	public Podcast(String theName, String theArtist, int time, int quantidadeEpisodios) {
		super(theName, theArtist, time);
		numeroEpisodios = quantidadeEpisodios;
		armazenamento = calcularArmazenamento();
	}
	
	public double calcularArmazenamento() {
		return this.numeroEpisodios*getDuracao()/60.0;
	}
}
