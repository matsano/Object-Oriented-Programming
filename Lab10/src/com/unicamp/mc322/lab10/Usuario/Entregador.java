package com.unicamp.mc322.lab10.Usuario;

public class Entregador extends Usuario {
	
	private boolean disponivel;
	private double quantidadeAvaliacoes;
	private double somaEstrelas;
	
	public Entregador(String oNome, String documento) {
		super(oNome, documento);
		disponivel = true;
	}
	
	public boolean estaDisponivel() {
		return this.disponivel;
	}
	
	public void chamarEntregador() {
		this.disponivel = false;
	}
	
	public void atualizarAvaliacao(int estrelas) {
		this.quantidadeAvaliacoes ++;
		this.somaEstrelas += estrelas;
	}
	
	private void calcularMediaDeAvaliacoes() {
		if (this.quantidadeAvaliacoes == 0) {
			System.out.println(" (Media: SEM AVALIACAO)");
		} else {
			double media = this.somaEstrelas / this.quantidadeAvaliacoes;
			System.out.printf(" (Media: %.1f estrelas)%n", media);
		}
	}
	
	public void imprimirAvaliacaoMedia() {
		System.out.print("Entregador " + this.nome);
		calcularMediaDeAvaliacoes();
	}
	
	public void imprimirEntregador() {
		System.out.print("	-> Entregador " + this.nome + ": ");
	}

}