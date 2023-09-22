package com.unicamp.mc322.lab07.Elementos;

public class Vagalume extends Comida {
	
	private final int PONTO_SATISFACAO_VAGALUME = 15;
	
	public Vagalume(int aLinha, int aColuna, String oNome) {
		super(aLinha, aColuna, oNome);
		icone = "va";
		pontosSatisfacao = PONTO_SATISFACAO_VAGALUME;
	}
	
}
