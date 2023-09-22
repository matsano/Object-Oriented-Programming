package com.unicamp.mc322.Cartas;

public class Feitico extends Carta {
	
	public Feitico(String umNome, int custo) {
		super(umNome, custo);
	}
	
	public static boolean ehFeitico(Carta carta) {
		return carta instanceof Feitico;
	}
	
	public void imprimirInformacaoAdicional() {
		System.out.println("Tipo: FEITICO");
		this.imprimirEfeitos();
	}
}
