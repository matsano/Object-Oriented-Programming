package com.unicamp.mc322.lab09;

public class FilaDePrioridadeComposicao {
	
	private Fila prioritario = new Fila();
	private Fila comum = new Fila();
	
	public void adicionar(Pessoa pessoa) {
		comum.adicionar(pessoa);
	}
	
	public void adicionarPrioritario(Pessoa pessoa) {
		prioritario.adicionar(pessoa);
	}
	
	public void remover() {
		if (prioritario.obterTamanho() != 0) {
			prioritario.remover();
		} else {
			comum.remover();
		}
	}
	
	public int obterTamanho() {
		return prioritario.obterTamanho() + comum.obterTamanho();
	}
	
	public void imprimir() {
		System.out.println("Composicao");
		System.out.println("------------------");
		System.out.println("Prioritarios: " + prioritario.obterTamanho());
		prioritario.imprimir();
		System.out.println("Comum: " + comum.obterTamanho());
		comum.imprimir();
		System.out.println();
	}
}