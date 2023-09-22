package com.unicamp.mc322.lab07.Elementos;

public abstract class Obstaculo extends Elemento {
	
	public Obstaculo(int aLinha, int aColuna) {
		adicionarPosicao(new Posicao(aLinha,aColuna));
	}
	
	public abstract boolean respeitaRestricao();
}
