package com.unicamp.mc322.Cartas.Tracos;

import com.unicamp.mc322.Cartas.UnidadeEvocada;

public abstract class Traco {
	
	protected UnidadeEvocada dona;
	protected UnidadeEvocada adversario;
	
	public abstract void aplicar();
	public abstract void imprimir();
	public abstract Traco clonar();
	
	public void determinarDona(UnidadeEvocada carta) {
		this.dona = carta;
	}
	
	public void atualizarAdversario(UnidadeEvocada cartaAdversaria) {
		this.adversario = cartaAdversaria;
	}
}