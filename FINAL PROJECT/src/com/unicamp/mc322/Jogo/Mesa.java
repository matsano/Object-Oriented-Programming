package com.unicamp.mc322.Jogo;

import com.unicamp.mc322.Jogadores.*;

public class Mesa {
	
	private Jogador jogador1;
	private Jogador jogador2;
	
	public Mesa(Jogador primeiroJogador, Jogador segundoJogador) {
		jogador1 = primeiroJogador;
		jogador2 = segundoJogador;
	}
	
	private void imprimirCartasJogador1() {
		this.jogador1.imprimirInformacoes();
		this.jogador1.imprimirCartasSelecionadas();
		this.jogador1.imprimirUnidadesEvocadas();
		this.imprimirEspacos(1);
		this.jogador1.imprimirCartasParaBatalha();
	}
	
	private void imprimirCartasJogador2() {
		this.jogador2.imprimirCartasParaBatalha();
		this.imprimirEspacos(1);
		this.jogador2.imprimirUnidadesEvocadas();
		this.imprimirEspacos(1);
		this.jogador2.imprimirCartasSelecionadas();
		this.jogador2.imprimirInformacoes();
	}
	
	private void imprimirEspacos(int quantidadeEspacos) {
		int quantidade = 0;
		while (quantidade < quantidadeEspacos) {
			System.out.println();
			quantidade ++;
		}
	}
	
	public void imprimir() {
		this.imprimirEspacos(6);
		this.imprimirCartasJogador1();
		this.imprimirEspacos(14);
		this.imprimirCartasJogador2();
		this.imprimirEspacos(3);
	}
}
