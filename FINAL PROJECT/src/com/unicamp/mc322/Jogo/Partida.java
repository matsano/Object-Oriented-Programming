package com.unicamp.mc322.Jogo;

import com.unicamp.mc322.Jogadores.*;

public class Partida {
	
	private Jogador jogador1;
	private Jogador jogador2;
	private int numeroDaRodada;
	private Batalha batalha;
	private Mesa mesa;
	
	public Partida() {
		jogador1 = new Artificial();
		jogador2 = new Artificial();
		jogador1.determinarAdversario(jogador2);
		jogador2.determinarAdversario(jogador1);
		mesa = new Mesa(this.jogador1, this.jogador2);
		batalha = new Batalha(this.mesa);
		numeroDaRodada = 0;
	}
	
	public Partida(String nomeJogador1) {
		jogador1 = new Humano(nomeJogador1);
		jogador2 = new Artificial();
		jogador1.determinarAdversario(jogador2);
		jogador2.determinarAdversario(jogador1);
		mesa = new Mesa(this.jogador1, this.jogador2);
		batalha = new Batalha(this.mesa);
		numeroDaRodada = 0;
	}
	
	public Partida(String nomeJogador1, String nomeJogador2) {
		jogador1 = new Humano(nomeJogador1);
		jogador2 = new Humano(nomeJogador2);
		jogador1.determinarAdversario(jogador2);
		jogador2.determinarAdversario(jogador1);
		mesa = new Mesa(this.jogador1, this.jogador2);
		batalha = new Batalha(this.mesa);
		numeroDaRodada = 0;
	}
	
	public void comecar() {
		this.jogador1.obterDeck();
		this.jogador2.obterDeck();
		this.jogador1.obterCartasDoDeck();
		this.jogador2.obterCartasDoDeck();
		this.jogador1.substituirCartasSelecionadas();
		this.jogador2.substituirCartasSelecionadas();
		
	}
	
	public void comecarRodada() {
		this.jogador1.obterCartaDoTopoDoDeck();
		this.jogador2.obterCartaDoTopoDoDeck();
		this.numeroDaRodada += 1;
		this.jogador1.receberPontosMana(this.numeroDaRodada);
		this.jogador2.receberPontosMana(this.numeroDaRodada);
		this.mesa.imprimir();
	}
	
	public void realizarBatalha() {
		if (this.numeroDaRodada % 2 != 0) {
			this.batalha.determinarAtacante(this.jogador1);
			this.batalha.determinarDefensor(this.jogador2);
		} else {
			this.batalha.determinarAtacante(this.jogador2);
			this.batalha.determinarDefensor(this.jogador1);
		}
		this.batalha.executar();
	}
	
	public void finalizarRodada() {
		this.jogador1.limitarPontosMana();
		this.jogador2.limitarPontosMana();
		this.jogador1.atualizarPoderCartas();
		this.jogador2.atualizarPoderCartas();
	}
	
	public boolean verificarFinalDePartida() {
		if ((this.jogador1.estaMorto()) || (this.jogador2.estaMorto())) {
			return true;
		} else {
			return false;
		}
	}
	
}
