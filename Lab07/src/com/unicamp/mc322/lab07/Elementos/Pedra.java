package com.unicamp.mc322.lab07.Elementos;

public class Pedra extends Obstaculo {
	
	public Pedra (int aLinha, int aColuna) {
		super(aLinha, aColuna);
		icone = "<>";
	}
	
	public boolean respeitaRestricao() {
		return true;
	}
	
}
