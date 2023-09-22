package com.unicamp.mc322.lab09;

public class Fila {
	
	protected Lista filaDePessoas;
	
	public Fila() {
		filaDePessoas = new Lista();
	}
	
	public void adicionar(Pessoa pessoa) {
		filaDePessoas.adicionarFim(pessoa);
	}
	
	public void remover() {
		filaDePessoas.removerInicio();
	}
	
	public int obterTamanho() {
		return filaDePessoas.obterTamanho();
	}
	
	public void limpar() {
		filaDePessoas.limpar();
	}
	
	public void imprimir() {
		filaDePessoas.imprimir();
	}
}