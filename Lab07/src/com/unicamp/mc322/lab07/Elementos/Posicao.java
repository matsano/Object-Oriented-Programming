package com.unicamp.mc322.lab07.Elementos;

public class Posicao {
	
	private int linha;
	private int coluna;
	
	public Posicao(int aLinha, int aColuna) {
		linha = aLinha;
		coluna = aColuna;
	}
	
	protected boolean saoAdjacentes(Posicao posicao) {
		boolean posicoesAdjacentes = false;
		if (Math.abs(this.linha - posicao.linha) <= 1) {
			if (Math.abs(this.coluna - posicao.coluna) <= 1) {
				posicoesAdjacentes = true;
			}
		}
		return posicoesAdjacentes;
	}
	
	protected int obterDistanciaManhattan(Posicao posicao) {
		return Math.abs(this.linha-posicao.linha) + Math.abs(this.coluna-posicao.coluna);		
	}
	
	protected void atualizarPosicao(Posicao posicao) {
		this.linha = posicao.linha;
		this.coluna = posicao.coluna;
	}
	
	protected void aumentarLinha(int valorSomado) {
		this.linha += valorSomado;
	}
	
	protected void diminuirLinha(int valorSubtraido) {
		this.linha -= valorSubtraido;
	}
	
	protected void aumentarColuna(int valorSomado) {
		this.coluna += valorSomado;
	}
	
	protected void diminuirColuna(int valorSubtraido) {
		this.coluna -= valorSubtraido;
	}
	
	public int getLinha() {
		return this.linha;
	}
	
	public int getColuna() {
		return this.coluna;
	}
}
