package com.unicamp.mc322.Cartas.Tracos;

import com.unicamp.mc322.Cartas.Seguidor;

public class Furia extends Traco {
	
	private int poderAdicional;
	private int vidaAdicional;
	
	public Furia (int pontosPoder, int pontosVida) {
		poderAdicional = pontosPoder;
		vidaAdicional = pontosVida;
	}
	
	public Traco clonar() {
		return new Furia(this.poderAdicional, this.vidaAdicional);
	}
	
	public void aplicar() {
		if (Seguidor.ehSeguidor(this.adversario)) {
			if (adversario.estaDestruida()) {
				this.dona.aumentarPoderVida(this.poderAdicional, this.vidaAdicional);
			}
		}
	}
	
	public void imprimir() {
		System.out.println("Furia");
	}
}
