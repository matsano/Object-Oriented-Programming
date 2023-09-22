package com.unicamp.mc322.Cartas.Efeitos;

import com.unicamp.mc322.Cartas.*;

public abstract class Efeito {
	
	protected String nome;
	protected boolean ativado;
	protected Carta dona;
	protected TipoDeEfeito tipo;
	
	protected Efeito(String umNome) {
		nome = umNome;
		ativado = false;
	}
	
	public abstract void ativar();
	public abstract Efeito clonar();
	
	public boolean foiAtivado() {
		return ativado;
	}
	
	public void determinarDona(Carta carta) {
		this.dona = carta;
	}
	
	public void imprimir() {
		System.out.println("	--> " + nome);
	}
	
	public TipoDeEfeito getTipo() {
		return this.tipo;
	}
}