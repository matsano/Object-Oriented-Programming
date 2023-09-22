package com.unicamp.mc322.lab09;

import java.util.ArrayList;

public class Lista {
	
	private ArrayList<Pessoa> pessoas;
	
	public Lista() {
		pessoas = new ArrayList();
	}
	
	public void adicionarNaPosicao(int posicao, Pessoa pessoaNaFila) {
		this.pessoas.add(posicao, pessoaNaFila);
	}
	
	public void adicionarInicio(Pessoa pessoaNaFila) {
		this.pessoas.add(0, pessoaNaFila);
	}
	
	public void adicionarFim(Pessoa pessoaNaFila) {
		this.pessoas.add(pessoaNaFila);
	}
	
	public void removerInicio() {
		this.pessoas.remove(0);
	}
	
	public void removerFim() {
		int ultimaPosicao = this.pessoas.size() - 1;
		this.pessoas.remove(ultimaPosicao);
	}
	
	public void remover(int posicao) {
		this.pessoas.remove(posicao);
	}
	
	public int obterTamanho() {
		return this.pessoas.size();
	}
	
	public void limpar() {
		this.pessoas.clear();;
	}	
	
	public void imprimir() {
		if (this.pessoas != null) {
			for (int posicaoPessoa = 0; posicaoPessoa < this.pessoas.size(); posicaoPessoa++) {
				System.out.println(this.pessoas.get(posicaoPessoa).getNome());
				
			}
		}
	}
	
	public ArrayList<Pessoa> obterLista(){
		return this.pessoas;
	}
}
