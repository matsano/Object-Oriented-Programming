package com.unicamp.mc322.lab07.Elementos;

public class Grilo extends Comida {
	
	private final int PONTO_SATISFACAO_GRILO = 20;
	
	public Grilo (int aLinha, int aColuna, String oNome) {
		super(aLinha, aColuna, oNome);
		pontosSatisfacao = PONTO_SATISFACAO_GRILO;
		icone = "gr";
	}
	
	
}
