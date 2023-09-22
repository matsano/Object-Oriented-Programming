package com.unicamp.mc322.lab10;

import com.unicamp.mc322.lab10.Usuario.*;
import java.util.ArrayList;

public class Restaurante {
	
	private String nome;
	private String cnpj;
	private double coordenadaX;
	private double coordenadaY;
	private ArrayList<Entregador> entregadores;
	private ArrayList<Lanche> opcoesDeLanches;
	private ArrayList<Pedido> pedidos;
	private double quantidadeAvaliacoes;
	private double somaEstrelas;
	
	public Restaurante(String oNome, String documento, double x, double y) {
		nome = oNome;
		cnpj = documento;
		coordenadaX = x;
		coordenadaY = y;
		entregadores = new ArrayList<Entregador>();
		opcoesDeLanches = new ArrayList<Lanche>();
		pedidos = new ArrayList<Pedido>();
	}
	
	public void adicionarAoCardapio(Lanche lanche) {
		Lanche novoLanche = lanche.clonar();
		this.opcoesDeLanches.add(novoLanche);
	}
	
	public void removerDoCardapio(Lanche lanche) {
		Lanche lancheRemovido = lanche.obterLancheDaLista(opcoesDeLanches);
		this.opcoesDeLanches.remove(lancheRemovido);
	}
	
	public void contratarEntregador(Entregador contratado) {
		this.entregadores.add(contratado);
	}
	
	public Lanche obterLancheDoCardapio(Lanche lanche) {
		return lanche.obterLancheDaLista(this.opcoesDeLanches);
	}
	
	public Entregador obterEntregadorDisponivel() {
		Entregador entregadorDisponivel = null;
		if (this.entregadores != null) {
			int posicaoEntregador = 0;
			while((entregadorDisponivel == null) && (posicaoEntregador < this.entregadores.size())) {
				if (this.entregadores.get(posicaoEntregador).estaDisponivel()) {
					entregadorDisponivel = this.entregadores.get(posicaoEntregador);
				} else {
					posicaoEntregador ++;
				}
			}
		}
		return entregadorDisponivel;
	}
	
	public void alocarPedidoParaEntregador() {
		Entregador entregadorDisponivel = obterEntregadorDisponivel();
		entregadorDisponivel.chamarEntregador();
	}
	
	public void aplicarDesconto(Lanche lanche, double desconto, TipoDesconto tipoDesconto) {
		Lanche lancheComDesconto = lanche.obterLancheDaLista(opcoesDeLanches);
		if (lancheComDesconto != null) {
			lancheComDesconto.aplicarDesconto(desconto, tipoDesconto);
		}
	}
	
	public void removerDesconto(Lanche lanche) {
		Lanche lancheSemDesconto = lanche.obterLancheDaLista(opcoesDeLanches);
		if (lancheSemDesconto != null) {
			lancheSemDesconto.removerDesconto();
		}
	}
	
	public void fazerPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	public void cancelarPedido(Pedido pedido) {
		this.pedidos.remove(pedido);
	}
	
	public void atualizarAvaliacao(int estrelas) {
		this.quantidadeAvaliacoes += 1;
		this.somaEstrelas += estrelas;
	}
	
	public void atualizarAvaliacaoDoLancheNoCardapio(Lanche lanche, int estrelas) {
		Lanche lancheDoCardapio = lanche.obterLancheDaLista(opcoesDeLanches);
		lancheDoCardapio.atualizarAvaliacao(estrelas);
	}
	
	private void calcularMediaDeAvaliacoes() {
		if (this.quantidadeAvaliacoes == 0) {
			System.out.println(" (Media: SEM AVALIACAO)");
		} else {
			double media = this.somaEstrelas / this.quantidadeAvaliacoes;
			System.out.printf(" (Media: %.1f estrelas)%n", media);
		}
	}
	
	public void imprimirPedidos() {
		System.out.print(this.nome + " - Pedidos: ");
		System.out.println(this.pedidos.size() + " pedidos");
		if (this.pedidos != null) {
			for (int numeroPedido = 0; numeroPedido < this.pedidos.size(); numeroPedido++) {
				System.out.println("Pedido " + (numeroPedido+1) + ":");
				this.pedidos.get(numeroPedido).imprimirPedido();
				System.out.println();
			}
		}
	}
	
	public void imprimirCardapio() {
		System.out.println("CARDAPIO - " + this.nome);
		if (this.opcoesDeLanches != null) {
			for (int numeroLanche = 0; numeroLanche < this.opcoesDeLanches.size(); numeroLanche++) {
				this.opcoesDeLanches.get(numeroLanche).imprimirLanche();
			}
		}
	}
	
	private void imprimirAvaliacaoMediaLanches() {
		for (int posicaoLanche = 0; posicaoLanche < this.opcoesDeLanches.size(); posicaoLanche++) {
			this.opcoesDeLanches.get(posicaoLanche).imprimirAvaliacaoMedia();
		}
	}
	
	private void imprimirAvaliacaoMediaEntregadores() {
		for (int posicaoEntregador = 0; posicaoEntregador < this.entregadores.size(); posicaoEntregador++) {
			this.entregadores.get(posicaoEntregador).imprimirAvaliacaoMedia();
		}
	}
	
	private void imprimirAvaliacaoDosPedidos() {
		if (this.pedidos.size() != 0) {
			System.out.println("Pedidos:");
			for (int numeroPedido = 0; numeroPedido < this.pedidos.size(); numeroPedido++) {
				System.out.println("	Pedido " + (numeroPedido+1) + ":");
				this.pedidos.get(numeroPedido).imprimirAvaliacao();
				System.out.println();
			}
		}
	}
	
	public void imprimirAvaliacao() {
		System.out.println("AVALIACOES");
		System.out.print(this.nome);
		calcularMediaDeAvaliacoes();
		imprimirAvaliacaoMediaLanches();
		imprimirAvaliacaoMediaEntregadores();
		imprimirAvaliacaoDosPedidos();
	}
	
	public double getCoordenadaX() {
		return this.coordenadaX;
	}
	
	public double getCoordenadaY() {
		return this.coordenadaY;
	}
}
