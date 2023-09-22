package com.unicamp.mc322.Cartas.Tracos;

public class AtaqueDuplo extends Traco {
	
	public Traco clonar() {
		return new AtaqueDuplo();
	}
	
	public void aplicar() {
		this.dona.atacarDuasVezes(this.adversario);
	}
	
	public void imprimir() {
		System.out.println("Ataque Duplo");
	}
}
