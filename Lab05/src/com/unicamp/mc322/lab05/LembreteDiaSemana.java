package com.unicamp.mc322.lab05;

public class LembreteDiaSemana extends LembreteComum {
	
	private int diaDoCompromisso;
	
	public LembreteDiaSemana(String descricao, int dia) {
		super(descricao);
		diaDoCompromisso = dia;
	}
	
	public boolean podeImprimir(int diaSemana, int dia, int mes, int ano) {
		boolean podeImprimir = false;
		if (this.diaDoCompromisso == diaSemana) {
			podeImprimir = true;
		}
		return podeImprimir;
	}
}