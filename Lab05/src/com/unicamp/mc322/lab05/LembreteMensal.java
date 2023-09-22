package com.unicamp.mc322.lab05;

public class LembreteMensal extends LembreteComum {
	
	private int mesDoCompromisso;
	
	public LembreteMensal(String descricao, int mes) {
		super(descricao);
		mesDoCompromisso = mes;
	}
	
	public boolean podeImprimir(int diaSemana, int dia, int mes, int ano) {
		boolean podeImprimir = false;
		if (this.mesDoCompromisso+1 == mes) {
			podeImprimir = true;
		}
		return podeImprimir;
	}
}
