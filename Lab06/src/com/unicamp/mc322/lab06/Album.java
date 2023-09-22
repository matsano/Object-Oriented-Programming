package com.unicamp.mc322.lab06;

import java.util.ArrayList;

public class Album extends Entretenimento{
	
	private ArrayList<Song> musicas;
	
	public Album(String theName) {
		super(theName);
		musicas = new ArrayList();
		autor = "nenhum";
		duracao = 0;
		armazenamento = calcularArmazenamento();
	}
	
	public double calcularArmazenamento() {
		double espaçoOcupado = 0;
		for (int posicaoMusica = 0; posicaoMusica < this.musicas.size(); posicaoMusica++){
			espaçoOcupado += this.musicas.get(posicaoMusica).getArmazenamento();
			posicaoMusica += 1;
		}
		return espaçoOcupado;
	}
	
	public void adicionarMusica(Song musica) {
		this.musicas.add(musica);
		this.armazenamento += musica.getArmazenamento();
		duracao += musica.getDuracao();
		obterAutor();
	}
	
	public void removerMusica(Song musica) {
		this.musicas.remove(musica);
		this.armazenamento -= musica.getArmazenamento();
		duracao -= musica.getDuracao();
		obterAutor();
	}
	
	private boolean temVariosAtores() {
		boolean diferentesAtores = false;
		int posicaoMusica = 0;
		String atorBase = this.musicas.get(0).getAutor();
		
		while((diferentesAtores == false) && (posicaoMusica < this.musicas.size())) {
			if (atorBase != this.musicas.get(posicaoMusica).getAutor()) {
				diferentesAtores = true;
			} else {
				posicaoMusica += 1;
			}
		}
		return diferentesAtores;
	}
	
	public void obterAutor() {
		if (temVariosAtores() == true) {
			this.autor = "Varios Autores";
		} else {
			this.autor = this.musicas.get(0).getAutor();
		}
	}
}
