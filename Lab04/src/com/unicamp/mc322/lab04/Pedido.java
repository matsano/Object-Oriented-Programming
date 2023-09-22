package com.unicamp.mc322.lab04;

import java.util.ArrayList;

public class Pedido {
	
	private User usuario;
	private ArrayList<Lanche> lanchesEscolhidos;
	private SituacaoPedido situacaoPedido;
	private double valorTotal;
	
	public Pedido (User user) {
		usuario = user;
		lanchesEscolhidos = new ArrayList();
		situacaoPedido = situacaoPedido.NOVO;
		valorTotal = 0;
	}
	
	public void addItem (Lanche lanche) {
		this.lanchesEscolhidos.add(lanche);
	}
	
	public void atualizarSituacao() {
		if (this.situacaoPedido == SituacaoPedido.EM_PREPARACAO) {
			this.situacaoPedido = SituacaoPedido.SAIU_PARA_ENTREGA;
		} else if (this.situacaoPedido == SituacaoPedido.SAIU_PARA_ENTREGA) {
			this.situacaoPedido = SituacaoPedido.ENTREGUE;
		}
	}
	
	public boolean podeCancelar() {
		if (this.situacaoPedido == SituacaoPedido.EM_PREPARACAO) {
			return true;
		} else if (this.situacaoPedido == SituacaoPedido.NOVO){
			return true;
		} else {
			return false;
		}
	}
	
	public void fecharPedido() {
		this.situacaoPedido = SituacaoPedido.EM_PREPARACAO; /*Pedido feito*/
		calcularValorTotal();
		this.usuario.aumentarNumeroCompras();
	}
	
	public void deletarPedido() {
			this.situacaoPedido = SituacaoPedido.NOVO; /*Pedido cancelado*/
			this.usuario.diminuirNumeroCompras();
	}
	
	private double obterValorDescontado(double valor) {
		double valorDescontado = 0;
		if (this.usuario.ehPrimeiroPedido()) {
			valorDescontado = valor * 0.8;
		} else if (this.usuario.fezDezPedidos()) {
			valorDescontado = valor - 60;
			if (valorDescontado < 0) {
				valorDescontado = 0;
			}
		} else if (valor > 100) {
			valorDescontado = valor * 0.9;
		} else {
			valorDescontado = valor;
		}
		return valorDescontado;
	}
	
	private void calcularValorTotal() {
		double total = 0;
		if (this.situacaoPedido != SituacaoPedido.NOVO) {
			for (int numeroLanche = 0; numeroLanche < this.lanchesEscolhidos.size(); numeroLanche++) {
				total  = total + this.lanchesEscolhidos.get(numeroLanche).getPreco();
			}
			total = obterValorDescontado(total);
		} else {
			total = 0;
		}
		this.valorTotal = total;
	}
	
	private void imprimirLanches() {
		for (int numeroLanche = 0; numeroLanche < this.lanchesEscolhidos.size(); numeroLanche++) {
			System.out.println("- " + this.lanchesEscolhidos.get(numeroLanche).getIdentificador());
		}
	}
	
	public void imprimirPedido() {
		this.usuario.imprimirUsuario();
		imprimirLanches();
		System.out.printf("Valor Total: R$ %.1f %n", this.valorTotal);
	}
}
