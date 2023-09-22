package com.unicamp.mc322.lab11;

import java.util.ArrayList;

public class Pidao {
	
	private String nomeRestaurante;
	private String Cnpj;
	private double coordenadaX;
	private double coordenadaY;
	private ArrayList<Lanche> opcoesLanches;
	private ArrayList<Pedido> pedidos;
	private int quantidadePedidos;
	
	public Pidao (String nome, String documento, int coordX, int coordY) {
		nomeRestaurante = nome;
		Cnpj = documento;
		coordenadaX = coordX;
		coordenadaY = coordY;
		opcoesLanches = new ArrayList();
		pedidos = new ArrayList();
		quantidadePedidos = 0;
	}
	
	public User cadastrarUsuario(String nome, String docUser, int x, int y) {
		return new User(nome, docUser, x, y);
	}
	
	public void adicionarAoCardapio(Lanche lanche) {
		this.opcoesLanches.add(lanche);
	}
	
	public void removerDoCardapio (Lanche lanche) {
		this.opcoesLanches.remove(lanche);
	}
	
	public void aplicarDesconto(String sigla, double desconto, TipoDesconto tipoDesconto) {
		int posicao = 0;
		while (this.opcoesLanches.get(posicao).getIdentificador() != sigla) {
			posicao ++;
		}
		this.opcoesLanches.get(posicao).obterDesconto(desconto, tipoDesconto);
	}
	
	public void removerDesconto(String sigla) {
		int posicao = 0;
		while (this.opcoesLanches.get(posicao).getIdentificador() != sigla) {
			posicao ++;
		}
		this.opcoesLanches.get(posicao).retirarDesconto();
	}
	
	public void fazerPedido(Pedido pedido) {		
		this.pedidos.add(pedido);
		this.quantidadePedidos ++;
		pedido.fecharPedido();
	}
	
	public void cancelarPedido(Pedido pedido) {
		boolean poderCancelar = pedido.podeCancelar();
		if (poderCancelar) {
			this.pedidos.remove(pedido);
			this.quantidadePedidos --;
			pedido.deletarPedido();
		}
	}
	
	public void imprimirCardapio() {		
		System.out.println("Restaurante " + this.nomeRestaurante);
		System.out.println("(CNPJ: " + this.Cnpj + ")");
		System.out.println();
		System.out.println("Cardapio de hoje:");
		for (int numeroLanche = 0; numeroLanche < this.opcoesLanches.size(); numeroLanche++) {
			this.opcoesLanches.get(numeroLanche).imprimirLanche();
			if (this.opcoesLanches.get(numeroLanche).ehPrecoSemDesconto() == true) {
				System.out.println();
			} else {
				System.out.println(" (PROMOCAO! Preco normal: R$ " + this.opcoesLanches.get(numeroLanche).getPrecoSemDesconto() + ")");
			}
		}
		System.out.println();		
	}
	
	public void imprimirResumoPedidos() {
		System.out.println("Existem " + this.quantidadePedidos + " pedidos:");
		for (int numeroPedido = 0; numeroPedido < this.pedidos.size(); numeroPedido++) {
			System.out.println("============================================");
			this.pedidos.get(numeroPedido).imprimirPedido();
			if (numeroPedido == this.quantidadePedidos - 1) {
				System.out.println("============================================");
			}
		}
	}

}
