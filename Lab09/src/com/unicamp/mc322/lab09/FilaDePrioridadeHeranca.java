package com.unicamp.mc322.lab09;

public class FilaDePrioridadeHeranca extends Fila {
	
	public void adicionar(Pessoa pessoa) {
		super.adicionar(pessoa);
	}
	
	private int obterPosicaoUltimoPrioritario() {
		int posicaoDoUltimoPrioritario = -1;
		if (filaDePessoas != null) {
			for (int posicao = 0; posicao < super.obterTamanho(); posicao++) {
				if (filaDePessoas.obterLista().get(posicao).getPrioridade() == true) {
					posicaoDoUltimoPrioritario = posicao;
				}
			}
		}
		return posicaoDoUltimoPrioritario;
	}
	
	public void adicionarPrioritario(Pessoa pessoa) {
		filaDePessoas.adicionarNaPosicao(obterPosicaoUltimoPrioritario()+1, pessoa);
	}
	
	public void remover() {
		super.remover();
	}
	
	public int obterTamanho() {
		return super.obterTamanho();
	}
	
	private int obterQuantidadeDePrioritarios() {
		int quantidadePrioritarios = 0;
		boolean prioridade = true;
		if (filaDePessoas.obterTamanho() != 0) {
			while (prioridade && (quantidadePrioritarios < filaDePessoas.obterTamanho())) {
				if (filaDePessoas.obterLista().get(quantidadePrioritarios).getPrioridade() == true) {
					quantidadePrioritarios += 1; 
				} else {
					prioridade = false;
				}
			}
		}
		return quantidadePrioritarios;
	}
	
	public void imprimir() {
		System.out.println("Heranca");
		System.out.println("------------------");
		System.out.println("Prioritarios: " + obterQuantidadeDePrioritarios() + " primeiros");
		super.imprimir();
	}
}