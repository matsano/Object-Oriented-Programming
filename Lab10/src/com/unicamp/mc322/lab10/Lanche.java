package com.unicamp.mc322.lab10;

import java.util.ArrayList;

public class Lanche {
	
	private String nome;
	private double precoAtual;
	private double precoSemDesconto;
	private String identificador;
	private int avaliacao;
	private String comentario;
	private double quantidadeAvaliacoes;
	private double somaEstrelas;
	
	public Lanche(String sigla, String oNome, double valor) {
		nome = oNome;
		precoAtual = valor;
		precoSemDesconto = valor;
		identificador = sigla;
	}
	
	public Lanche clonar() {
		return new Lanche(this.identificador, this.nome, this.precoAtual);
	}
	//o metodo clonar() eh utilizado para diferenciar os lanches de cada restaurante.
	//Portanto, o spaghetti do restaurante 1 é uma instancia diferente do spaghetti do restaurante 2.
	
	public void aplicarDesconto(double desconto, TipoDesconto tipoDesconto) {
		switch (tipoDesconto) {
		case PORCENTAGEM:
			this.precoAtual = this.precoAtual * (1 - (desconto/100));
			break;
		case FIXO:
			this.precoAtual = this.precoAtual - desconto;
			break;
		}
	}
	
	public void removerDesconto() {
		this.precoAtual = this.precoSemDesconto;
	}
	
	public Lanche obterLancheDaLista(ArrayList<Lanche> lanches) {
		Lanche lanche = null;
		if (lanches != null) {
			for (int posicaoLanche = 0; posicaoLanche < lanches.size(); posicaoLanche++) {
				lanche = lanches.get(posicaoLanche);
				if (this.identificador == lanche.identificador) {
					return lanche;
				}
			}
		}
		return lanche;
	}
	
	public void atualizarAvaliacao(int estrelas) {
		this.quantidadeAvaliacoes ++;
		this.somaEstrelas += estrelas;
	}
	
	public void avaliar(int estrelas, String umComentario) {
		this.avaliacao = estrelas;
		this.comentario = umComentario;
	}
	
	private void calcularMediaDeAvaliacoes() {
		if (this.quantidadeAvaliacoes == 0) {
			System.out.println(" (Media: SEM AVALIACAO)");
		} else {
			double media =  this.somaEstrelas / this.quantidadeAvaliacoes;
			System.out.printf(" (Media: %.1f estrelas)%n", media);
		}
	}
	
	private void imprimirPreco() {
		System.out.printf(" R$ %.1f" , this.precoAtual);
		if (this.precoAtual != this.precoSemDesconto) {
			System.out.printf("	(LANCHE COM DESCONTO! PRECO INICIAL: R$ %.1f)" , this.precoSemDesconto);
		}
	}
	
	public void imprimirLanche() {
		System.out.print("	[ " + this.identificador + " ] " + this.nome);
		imprimirPreco();
		System.out.println();
	}
	
	public void imprimirAvaliacaoMedia() {
		System.out.print("+ " + this.nome);
		calcularMediaDeAvaliacoes();
	}
	
	public void imprimirAvaliacao() {
		System.out.print("	+ " + this.nome + ": ");
		System.out.println(this.avaliacao + " estrelas");
		if (this.comentario != null) {
			System.out.println("	(COMENTARIO: " + this.comentario + ")");
		}
	}
	
	public double getPrecoAtual() {
		return this.precoAtual;
	}
}
