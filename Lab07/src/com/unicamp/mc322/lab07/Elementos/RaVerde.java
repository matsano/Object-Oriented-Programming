package com.unicamp.mc322.lab07.Elementos;

public class RaVerde extends Ra {
	
	public RaVerde (int aLinha, int aColuna, String oNome) {
		super(aLinha, aColuna, oNome);
	}
	
	public void calcularPontosObtidos(Comida comida) {
		this.pontosObtidos += comida.pontosSatisfacao;
	}
	
	public void moverCima() {
		atualizarPosicaoAnterior();
		this.posicoes.get(0).diminuirLinha(1);
	}
	
	public void moverBaixo() {
		atualizarPosicaoAnterior();
		this.posicoes.get(0).aumentarLinha(1);
	}
	
	public void moverDireita() {
		atualizarPosicaoAnterior();
		this.posicoes.get(0).aumentarColuna(1);
	}
	
	public void moverEsquerda() {
		atualizarPosicaoAnterior();
		this.posicoes.get(0).diminuirColuna(1);
	}
}
