package com.unicamp.mc322.lab02;

import java.util.Random;

public class Playlist {
	
	private String nome;
	private String genero;
	private Song[] musicas;
	private int musicaAtual;
	private int numSongs;
	Random random = new Random();
	
	public Playlist(String theName, String gen) {
		nome = theName;
		genero = gen;
		musicas = new Song[10];
		musicaAtual = 0;
		numSongs = 0;
	}
	
	public void terAssinatura(User usuario) {
		if (usuario.getAssinatura() == 1) {
			this.musicas = new Song[100];
		}
	}
	
	public void ordenarPlaylist() {
		Song aux = new Song("nada", "nada", "nada", 0);
		for (int i = 0; i < musicas.length; i++) {
			for (int j = 0; j < musicas.length-1; j++) {
				if (musicas[j] != null && musicas[j+1] != null) {
					if (musicas[j+1].getNome().compareTo(musicas[j].getNome()) < 0) {
						aux = musicas[j];
						musicas[j] = musicas[j+1];
						musicas[j+1] = aux;
					}
				}
			}
		}
		
	}
	
	public void addSong(Song musica) {
		int posicao = 0;
		boolean val = false;
		while ((posicao < musicas.length) && (val == false)) {
			if (musicas[posicao] == null) {
				musicas[posicao] = musica;
				val = true;
			} else {
				posicao++;
			}
		}
		if (posicao == musicas.length) {
			System.out.println("Essa playlist já possui a quantidade máxima de musicas.");
		} else {
			ordenarPlaylist();
		}
		this.numSongs++;
	}
	
	public void removeSong(Song musica) {
		Song[] vetor = new Song[musicas.length];
		int posicao = 0;
		int posicaoVetor = 0;
		while (posicao < musicas.length) {
			if (musicas[posicao] != musica) {
				vetor[posicaoVetor] = musicas[posicao];
				posicao ++;
				posicaoVetor++;
			} else {
				posicao++;
			}
		}
		musicas = vetor;
		this.numSongs--;
	}
	
	public String getMenorDuracao() {
		int menorMusica = 0;
		int menorTempo = 100000;
		int posicao = 0;
		while ((posicao < musicas.length) && (musicas[posicao] != null)) {
			if (musicas[posicao].getDuracao() < menorTempo) {
				menorTempo = musicas[posicao].getDuracao();
				menorMusica = posicao;
				posicao++;
			} else {
				posicao++;
			}
		}
		return musicas[menorMusica].getNome();
	}
	
	public String getMaiorDuracao() {
		int maiorMusica = 0;
		int maiorTempo = 0;
		int posicao = 0;
		while ((posicao < musicas.length) && (musicas[posicao] != null)) {
			if (musicas[posicao].getDuracao() > maiorTempo) {
				maiorTempo = musicas[posicao].getDuracao();
				maiorMusica = posicao;
				posicao++;
			} else {
				posicao++;
			}
		}
		return musicas[maiorMusica].getNome();
	}
	
	public double getDuracaoMedia() {
		double tempoTotal = 0;
		double media = 0;
		int posicao = 0;
		while ((posicao < musicas.length) && (musicas[posicao] != null)) {
			tempoTotal += musicas[posicao].getDuracao();
			posicao++;
		}
		media = tempoTotal / posicao;
		return media;
	}
	
	public int getDuracaoTotal() {
		int tempoTotal = 0;
		int posicao = 0;
		while ((posicao < musicas.length) && (musicas[posicao] != null)) {
			tempoTotal += musicas[posicao].getDuracao();
			posicao++;
		}
		return tempoTotal;
	}
	
	public String getArtistaFamoso() {
		String artistas[] = new String[musicas.length];
		int frequencias[] = new int[musicas.length];
		boolean contador = false;
		int maior = 0;
		
		for (int i = 0; i < musicas.length; i++) {
			if (musicas[i] != null) {
				for (int j = 0; j < artistas.length; j++) {
					if (musicas[i].getArtista() == artistas[j]) {
						frequencias[j] += 1;
						contador = true;
					}
				}
				if (contador == false) {
					int val = 0;
					while (artistas[val] != null) {
						val++;
					}
					artistas[val] = musicas[i].getArtista();
				}
			}
		}
		for (int i = 0; i < frequencias.length; i++) {
			if (frequencias[i] > maior) {
				maior = i;
			}
		}
		return artistas[maior];
	}
	
	public void play(boolean shuffle) {
		boolean val = false;
		int posicao = 0;
		if (shuffle == false) {
			while ((val == false) && (posicao < musicas.length)) {
				if (musicas[posicao].getNome() != musicas[musicaAtual].getNome()) {
					val = true;
				} else {
					posicao++;
				}
			}
			if (musicas[posicao] == null) {
				posicao = 0;
				this.musicaAtual = posicao;
				musicas[musicaAtual] = musicas[posicao];
				System.out.println("Musica atual: " + musicas[musicaAtual].getNome());
			} else {
				posicao++;
				this.musicaAtual = posicao;
				musicas[musicaAtual] = musicas[posicao];
				System.out.println("Musica atual: " + musicas[musicaAtual].getNome());
			}
		} else {
			while (val == false) {
				posicao = random.nextInt(musicas.length-1);
				if ((musicas[posicao] != null) && (musicas[posicao] != musicas[musicaAtual])) {
					val = true;
				}
			}
			musicaAtual = posicao;
			musicas[musicaAtual] = musicas[posicao];
			System.out.println("Musica atual: " +musicas[musicaAtual].getNome());
		}
	}
	
	public void alterarPlaylist(int ass) {
		if (ass == 1) {
			Song[] vetor = new Song[100];
			
			for (int i = 0; i < 10; i++) {
				vetor[i] = musicas[i];
			}
			this.musicas = vetor;
		} else {
			this.musicas = new Song[10];
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getNumSongs() {
		return this.numSongs;
	}
	
	public Song[] getMusicas() {
		return this.musicas;
	}
}