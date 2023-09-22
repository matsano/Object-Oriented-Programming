package com.unicamp.mc322.lab02;

public class Song {
	
	private String nome;
	private String genero;
	private String artista;
	private int duracao;
	
	public Song(String theName, String generoMusical, String theArtist, int time) {
		nome = theName;
		genero = generoMusical;
		artista = theArtist;
		duracao = time;
	}
	
	public void alterarNome(String name) {
		nome = name;
	}
	
	public void alterarGenero(String gen) {
		genero = gen;
	}
	
	public void alterarArtista(String art) {
		artista = art;
	}
	
	public void alterarDuracao(int tempo) {
		duracao = tempo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getArtista() {
		return artista;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
}