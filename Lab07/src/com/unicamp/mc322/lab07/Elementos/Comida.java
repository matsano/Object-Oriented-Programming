package com.unicamp.mc322.lab07.Elementos;

public abstract class Comida extends Elemento {
	
	protected String nome;
	protected double pontosSatisfacao;
	
	protected Comida(int aLinha, int aColuna, String oNome) {
		adicionarPosicao(new Posicao(aLinha,aColuna));
		nome = oNome;
	}
	
	protected String getNome() {
		return this.nome;
	}
	
	protected double getPontosSatisfacao() {
		return this.pontosSatisfacao;
	}
}
