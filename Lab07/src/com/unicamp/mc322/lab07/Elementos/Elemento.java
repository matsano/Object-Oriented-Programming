package com.unicamp.mc322.lab07.Elementos;

import java.util.ArrayList;

public abstract class Elemento {
	
	protected String icone;
	protected ArrayList<Posicao> posicoes = new ArrayList();
	
	protected void adicionarPosicao(Posicao posicao) {
		this.posicoes.add(posicao);
	}
	
	public String getIcone() {
		return this.icone;
	}
	
	public ArrayList<Posicao> getPosicoes() {
		return this.posicoes;
	}
}
