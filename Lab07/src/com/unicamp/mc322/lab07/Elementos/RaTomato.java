package com.unicamp.mc322.lab07.Elementos;

import java.util.Random;

public class RaTomato extends Ra {
	
	public RaTomato (int aLinha, int aColuna, String oNome) {
		super(aLinha, aColuna, oNome);
	}
	
	public void calcularPontosObtidos(Comida comida) {
		this.pontosObtidos += 1.1 * comida.pontosSatisfacao;
	}
	
	public void moverCima() {
		atualizarPosicaoAnterior();
		Random numeroAleatorio = new Random();
		int numeroCasasCima = numeroAleatorio.nextInt(2) + 2;
		this.posicoes.get(0).diminuirLinha(numeroCasasCima);
	}
	
	public void moverBaixo() {
		atualizarPosicaoAnterior();
		Random numeroAleatorio = new Random();
		int numeroCasasBaixo = (int)Math.pow(2, numeroAleatorio.nextInt(3));		
		this.posicoes.get(0).aumentarLinha(numeroCasasBaixo);
	}
	
	public void moverDireita() {
		atualizarPosicaoAnterior();
		Random numeroAleatorio = new Random();
		int numeroCasasDireitaEsquerda = numeroAleatorio.nextInt(3) + 1;
		this.posicoes.get(0).aumentarColuna(numeroCasasDireitaEsquerda);
	}
	
	public void moverEsquerda() {
		atualizarPosicaoAnterior();
		Random numeroAleatorio = new Random();
		int numeroCasasDireitaEsquerda = numeroAleatorio.nextInt(3) + 1;
		this.posicoes.get(0).diminuirColuna(numeroCasasDireitaEsquerda);
	}
}
