package com.unicamp.mc322.lab06;

import java.util.ArrayList;

public class User {
	
	public static final double ARMAZENAMENTO_MIN = 200.0;
	private String nome;
	private String cpf;
	private String nascimento;
	private String genero;
	private int assinatura;
	private double armazenamentoOcupado;
	private double armazenamentoTotal;
	private ArrayList<Playlist> playlists;
	
	public User(String theName, String CPF, String data, String gen, int ass) {
		nome = theName;
		cpf = CPF;
		nascimento = data;
		genero = gen;
		assinatura = ass;
		playlists = new ArrayList();
		armazenamentoTotal = ARMAZENAMENTO_MIN + 700*assinatura;
		armazenamentoOcupado = 0;
	}
	
	public void addPlaylist(Playlist playlist) {
		double armazenamentoRestante = this.armazenamentoTotal - this.armazenamentoOcupado;
		if (armazenamentoRestante >= playlist.getTamanhoOcupado()) {
			this.playlists.add(playlist);
			this.armazenamentoOcupado += playlist.getTamanhoOcupado();
			playlist.setDono(this);
		}
	}
	
	public void removePlaylist(Playlist playlist) {
		this.playlists.remove(playlist);
		this.armazenamentoOcupado -= playlist.getTamanhoOcupado();
	}
	
	public void transferirPlaylist(Playlist lista, User destinatario) {
		destinatario.addPlaylist(lista);
	}
	
	public void alterarAssinatura() {
		if (assinatura == 0) {
			this.assinatura = 1;
			this.armazenamentoTotal = 900;
		} else {
			this.assinatura = 0;
			if (this.armazenamentoOcupado > ARMAZENAMENTO_MIN) {
				this.playlists.clear();
				this.armazenamentoTotal = 200;
				this.armazenamentoOcupado = 0;
			}
		}
	}
	
	public boolean temEspaco(Entretenimento e) {
		boolean espacoDisponivel = false;
		double espacoOcupado = this.armazenamentoOcupado + e.getArmazenamento();
		if (espacoOcupado <= this.armazenamentoTotal) {
			espacoDisponivel = true;
		}
		return espacoDisponivel;
	}
	
	public void aumentarArmazenamentoOcupado(double armazenamentoAdicional) {
		this.armazenamentoOcupado += armazenamentoAdicional;
	}
	
	public void diminuirArmazenamentoOcupado(double armazenamentoAdicional) {
		this.armazenamentoOcupado -= armazenamentoAdicional;
	}	
}