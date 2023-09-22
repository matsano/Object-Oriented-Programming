package com.unicamp.mc322.lab07.Elementos;

public class PredadorAnimal extends Obstaculo {
	
	public PredadorAnimal (int aLinha, int aColuna) {
		super(aLinha, aColuna);
		icone = "$$";
	}
	
	public PredadorAnimal (int linha1, int coluna1, int linha2, int coluna2) {
		this(linha1, coluna1);
		adicionarPosicao(new Posicao(linha2, coluna2));
	}
	
	public boolean respeitaRestricao() {
		boolean respeitaRestricao = false;
		if (posicoes.size() == 1) {
			respeitaRestricao = true;
		} else {
			if (posicoes.get(0).saoAdjacentes(posicoes.get(1)) == true) {
				respeitaRestricao = true;
			}
		}
		return respeitaRestricao;
	}
}
