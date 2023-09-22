package com.unicamp.mc322.Jogo;

import java.util.Scanner;

public class Jogo {
	
	private Partida partida;
	private boolean fimDoJogo;
	
	public Jogo() {
		fimDoJogo = false;
	}
	
	private void imprimirOpcoesDeJogo() {
		System.out.println("Opcoes de Jogo:");
		System.out.println("	0 jogadores: Computador x Computador");
		System.out.println("	1 jogador: Humano x Computador");
		System.out.println("	2 jogadores: Humano x Humano");
		System.out.print("Quantos jogadores vão jogar? 0, 1 ou 2? ");
	}
	
	private int escolherOpcaoDeJogo() {
		Scanner input = new Scanner(System.in);
		this.imprimirOpcoesDeJogo();
		return input.nextInt();
	}
	
	private void prepararPartidaHumanoHumano() {
		Scanner input = new Scanner(System.in);
		System.out.print("Nome do primeiro jogador: ");
		String nomePrimeiroJogador = input.next();
		System.out.print("Nome do segundo jogador: ");
		String nomeSegundoJogador = input.next();
		this.partida = new Partida(nomePrimeiroJogador, nomeSegundoJogador);
	}
	
	private void prepararPartidaHumanoComputador() {
		Scanner input = new Scanner(System.in);
		System.out.print("Nome do jogador: ");
		String nomeJogador = input.next();
		this.partida = new Partida(nomeJogador);
	}
	
	private void prepararPartidaComputadorComputador() {
		this.partida = new Partida();
	}
	
	private void prepararPartida() {
		int opcaoEscolhida = escolherOpcaoDeJogo();
		if (opcaoEscolhida == 2) {
			this.prepararPartidaHumanoHumano();
		} else if (opcaoEscolhida == 1) {
			this.prepararPartidaHumanoComputador();
		} else {
			this.prepararPartidaComputadorComputador();
		}
	}
	
	public void comecar() {
		this.prepararPartida();
		System.out.println("Bom jogo!");
		this.partida.comecar();
		while(!fimDoJogo) {
			this.partida.comecarRodada();
			this.partida.realizarBatalha();
			this.partida.finalizarRodada();
			this.fimDoJogo = this.partida.verificarFinalDePartida();
		}
		
		System.out.println("Final de jogo. FIM!");
	}
	
}