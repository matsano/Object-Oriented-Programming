package com.unicamp.mc322.lab07.Elementos;

import java.util.Random;

public class RaVenenosa extends Ra{
	
	public RaVenenosa (int aLinha, int aColuna, String oNome) {
		super(aLinha, aColuna, oNome);
	}
	
	public void calcularPontosObtidos(Comida comida) {
		this.pontosObtidos += 1.2 * comida.pontosSatisfacao;
	}
	
	private void moverPosicaoAleatoria() {
		atualizarPosicaoAnterior();
		Random numeroAleatorio = new Random();
		int numeroCasas = numeroAleatorio.nextInt(4) + 1;
		int direcao = numeroAleatorio.nextInt(4); /*direcao=0(w) / direcao=1(s) / direcao=2(d) / direcao=3(a)*/
		if (direcao == 0) {
			this.posicoes.get(0).diminuirLinha(numeroCasas);
		} else if (direcao == 1) {
			this.posicoes.get(0).aumentarLinha(numeroCasas);
		} else if (direcao == 2) {
			this.posicoes.get(0).aumentarColuna(numeroCasas);
		} else if (direcao == 3) {
			this.posicoes.get(0).diminuirColuna(numeroCasas);
		}
	}
	
	public void moverCima() {
		moverPosicaoAleatoria();
	}
	
	public void moverBaixo() {
		moverPosicaoAleatoria();
	}
	
	public void moverDireita() {
		moverPosicaoAleatoria();
	}
	
	public void moverEsquerda() {
		moverPosicaoAleatoria();
	}
	
}
