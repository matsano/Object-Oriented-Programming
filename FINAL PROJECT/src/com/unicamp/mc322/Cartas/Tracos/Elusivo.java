package com.unicamp.mc322.Cartas.Tracos;

public class Elusivo extends Traco {
	
	public static boolean ehElusivo(Traco traco) {
		return traco instanceof Elusivo;
	}
	
	public Traco clonar() {
		return new Elusivo();
	}
	
	public void aplicar() {
		this.dona.defenderComElusivo(this.adversario);
	}
	
	public void imprimir() {
		System.out.println("Elusivo");
	}
}
