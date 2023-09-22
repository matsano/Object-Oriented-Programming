package com.unicamp.mc322.lab07.Elementos;

public class Armadilha extends Obstaculo{
	
	public Armadilha (int aLinha, int aColuna) {
		super(aLinha,aColuna);
		icone = "{}";
	}
	
	public Armadilha (int linha1, int coluna1, int linha2, int coluna2) {
		this(linha1, coluna1);
		adicionarPosicao(new Posicao(linha2, coluna2));
	}
	
	public Armadilha (int linha1, int coluna1, int linha2, int coluna2, int linha3, int coluna3) {
		this(linha1, coluna1, linha2, coluna2);
		adicionarPosicao(new Posicao (linha3, coluna3));
	}
	
	private boolean possuiMesmaDistanciaManhattan() {
		boolean mesmaDistancia = false;
		if (posicoes.get(0).obterDistanciaManhattan(posicoes.get(1)) == posicoes.get(0).obterDistanciaManhattan(posicoes.get(2))) {
			if (posicoes.get(0).obterDistanciaManhattan(posicoes.get(1)) == posicoes.get(1).obterDistanciaManhattan(posicoes.get(2))) {
				mesmaDistancia = true;
			}
		}
		return mesmaDistancia;
	}
	
	private boolean possuiDistanciaMenorIgualDois() {
		boolean menorIgualDois = false;
		if (posicoes.get(0).obterDistanciaManhattan(posicoes.get(1)) <= 3) {
			if (posicoes.size() == 2) {
				menorIgualDois = true;
			} else {
				if (possuiMesmaDistanciaManhattan() == true) {
					menorIgualDois = true;
				}
			}
		}
		return menorIgualDois;
	}
	
	public boolean respeitaRestricao() {
		boolean respeitaRestricao = false;
		if (posicoes.size() == 1) {
			respeitaRestricao = true;
		} else {
			if (possuiDistanciaMenorIgualDois() == true) {
				respeitaRestricao = true;
			}
		}
		return respeitaRestricao;
	}
}
