package com.unicamp.mc322.lab05;

public class LembreteComum {
	
	private String compromisso;
	
	public LembreteComum(String descricao) {
		compromisso = descricao;
	}
	
	public boolean podeImprimir(int diaSemana, int dia, int mes, int ano) {
		return true;
	}
	
	public void imprimirLembrete() {
		System.out.println("Lembrete");
		System.out.println("Descricao: " + this.compromisso);
		System.out.println();
	}
}
