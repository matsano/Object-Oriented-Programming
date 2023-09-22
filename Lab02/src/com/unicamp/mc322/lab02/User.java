package com.unicamp.mc322.lab02;

public class User {
	
	private String nome;
	private String cpf;
	private String nascimento;
	private String genero;
	private int assinatura;
	private int numPlaylist;
	private Playlist[] playlists;
	
	public User(String theName, String CPF, String data, String gen, int ass) {
		nome = theName;
		cpf = CPF;
		nascimento = data;
		genero = gen;
		assinatura = ass;
		playlists = new Playlist[3];
		numPlaylist = 0;
	}
	
	public void addPlaylist(Playlist playlist) {
		int posicao = 0;
		boolean val = false;
		while ((posicao < playlists.length) && (val == false)) {
			if (playlists[posicao] == null) {
				playlists[posicao] = playlist;
				this.numPlaylist ++;
				val = true;
			} else {
				posicao++;
			}
		}
		if (posicao == playlists.length) {
			System.out.println("Esse usuario ja possui a quantidade maxima de playlists.");
		}
	}
	
	public void removePlaylist(Playlist playlist) {
		Playlist[] vetor = new Playlist[playlists.length];
		int posicao = 0;
		int posicaoVetor = 0;
		while (posicao < playlists.length) {
			if (playlists[posicao] != playlist) {
				vetor[posicaoVetor] = playlists[posicao];
				posicao ++;
				posicaoVetor++;
			} else {
				posicao++;
			}
		}
		playlists = vetor;
		this.numPlaylist--;
	}
	
	public void transferirPlaylist(Playlist lista, User destinatario) {
		destinatario.addPlaylist(lista);
	}
	
	public void alterarAssinatura() {
		if (assinatura == 0) {
			Playlist[] vetor = new Playlist[10];
			this.assinatura = 1;
			
			for (int i = 0; i < 3; i++) {
				vetor[i] = playlists[i];
			}
			this.playlists = vetor;
			
			for (int i = 0; i < 10; i++) {
				if (this.playlists[i] != null) {
					this.playlists[i].alterarPlaylist(1);
				}
			}
			
		} else {
			this.playlists = new Playlist[3];
			this.assinatura = 0;
			
			for (int i = 0; i < 3; i++) {
				playlists[i].alterarPlaylist(0);
			}
		}
	}
	
	public void showInformation() {
		System.out.println("Nome: " + this.nome);
		System.out.println("CPF: " + this.cpf);
		System.out.println("Nascimento: " + this.nascimento);
		System.out.println("Genero: " + this.genero);
		if (this.assinatura == 0) {
			System.out.println("Assinante: NAO");
		} else {
			System.out.println("Assinante: SIM");
		}
	}
	
	public void showPlaylists() {
		int posicao = 0;
		int num = 0;
		System.out.println("User: " + this.nome);
		System.out.println("Number of Playlist: " + this.numPlaylist);
		while (posicao < this.numPlaylist) {
			if (playlists[posicao] != null) {
				num = posicao + 1;
				System.out.println("Playlist " + num + ": " + playlists[posicao].getNome());
				System.out.println("	Number of Songs: " + playlists[posicao].getNumSongs());
				System.out.println("	Songs:");
				
				for (int i = 0; i < playlists[posicao].getMusicas().length; i++) {
					if (playlists[posicao].getMusicas()[i] != null) {
						System.out.println("	- " + playlists[posicao].getMusicas()[i].getNome() + " - "+ playlists[posicao].getMusicas()[i].getArtista() + ";");
						
					}
				}
				System.out.println("	Musica de menor duracao: " + playlists[posicao].getMenorDuracao());
				System.out.println("	Musica de maior duracao: " + playlists[posicao].getMaiorDuracao());
				System.out.printf("	Tempo medio das musicas: %.1f segundos \n", playlists[posicao].getDuracaoMedia());
				System.out.println("	Tempo total da playlist: " + playlists[posicao].getDuracaoTotal() + " segundos");
				System.out.println("	Artista mais tocado na playlist: " + playlists[posicao].getArtistaFamoso());
			}
			posicao++;
		}
	}
	
	public int getAssinatura() {
		return assinatura;
	}
	
	
}