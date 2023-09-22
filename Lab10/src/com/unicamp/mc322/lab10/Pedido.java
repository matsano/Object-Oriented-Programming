package com.unicamp.mc322.lab10;

import com.unicamp.mc322.lab10.Usuario.*;
import java.util.ArrayList;

public class Pedido {
	
	private TipoDeEnvio modoDeEntrega;
	private Cliente cliente;
	private Restaurante restaurante;
	private SituacaoPedido situacaoPedido;
	private ArrayList<Lanche> lanchesEscolhidos;
	private Entregador entregadorResponsavel;
	private int avaliacaoRestaurante;
	private String comentarioParaRestaurante;
	private int avaliacaoEntregador;
	private String comentarioParaEntregador;
	private boolean primeiroPedido;
	private double valorTotal;
	
	public Pedido(Cliente consumidor, Restaurante vendedor, TipoDeEnvio formaDeEnvio) {
		cliente = consumidor;
		restaurante = vendedor;
		lanchesEscolhidos = new ArrayList<Lanche>();
		modoDeEntrega = formaDeEnvio;
		valorTotal = 0;
		situacaoPedido = situacaoPedido.NOVO;
	}
	
	public void adicionarLanche(Lanche lanche) {
		Lanche lancheDoCardapio = this.restaurante.obterLancheDoCardapio(lanche);
		Lanche novoLanche = lancheDoCardapio.clonar();
		this.lanchesEscolhidos.add(novoLanche);
	}
	
	public void removerLanche(Lanche lanche) {
		Lanche lancheRemovido = lanche.obterLancheDaLista(this.lanchesEscolhidos);
		this.lanchesEscolhidos.remove(lancheRemovido);
		
		this.lanchesEscolhidos.remove(lanche);
	}
	
	private double calcularDistancia() {
		double deltaX = this.cliente.getCoordenadaX() - this.restaurante.getCoordenadaX();
		double deltaY = this.cliente.getCoordenadaY() - this.restaurante.getCoordenadaY();
		double soma = Math.pow(deltaX, 2) + Math.pow(deltaY, 2);
		return Math.sqrt(soma);
	}
	
	private double calcularPrecoDeEntrega() {
		return 0.5 * calcularDistancia();
	}
	
	private double calcularValorLanches() {
		double valorTotalLanches = 0;
		if (this.lanchesEscolhidos != null) {
			for (int numeroLanche = 0; numeroLanche < this.lanchesEscolhidos.size(); numeroLanche++) {
				valorTotalLanches += this.lanchesEscolhidos.get(numeroLanche).getPrecoAtual();
			}
		}
		return valorTotalLanches;
	}
	
	private double calcularValorTotal() {
		if (this.modoDeEntrega == TipoDeEnvio.ENTREGA) {
			return calcularValorLanches() + calcularPrecoDeEntrega();
		} else {
			return calcularValorLanches();
		}
	}
	
	private double calcularValorDescontado() {
		if (this.cliente.ehPrimeiroPedido()) {
			this.primeiroPedido = true;
			return calcularValorTotal() * 0.8;
		} else {
			return calcularValorTotal();
		}
	}
	
	public void fecharPedido() {
		this.situacaoPedido = SituacaoPedido.EM_PREPARACAO;
		this.valorTotal = calcularValorDescontado();
		this.cliente.aumentarNumeroCompras();
		this.restaurante.fazerPedido(this);
	}
	
	private boolean podeCancelar() {
		boolean cancelamentoPermitido = false;
		if (this.situacaoPedido == SituacaoPedido.NOVO) {
			cancelamentoPermitido = true;
		} else if (this.situacaoPedido == SituacaoPedido.EM_PREPARACAO) {
			cancelamentoPermitido = true;
		}
		return cancelamentoPermitido;
	}
	
	public void apagarPedido() {
		if (podeCancelar()) {
			this.situacaoPedido = SituacaoPedido.NOVO;
			this.cliente.diminuirNumeroCompras();
			this.restaurante.cancelarPedido(this);
		}
	}
	
	public void finalizarPreparo() {
		if (this.situacaoPedido == SituacaoPedido.EM_PREPARACAO) {
			this.situacaoPedido = SituacaoPedido.PRONTO;
		}
	}
	
	private void retirarPedido() {
		this.situacaoPedido = SituacaoPedido.ENTREGUE;
	}
	
	private void entregarPedido() {
		Entregador entregador = this.restaurante.obterEntregadorDisponivel();
		if (entregador != null) {
			this.entregadorResponsavel = entregador;
			this.restaurante.alocarPedidoParaEntregador();
			this.situacaoPedido = SituacaoPedido.SAIU_PARA_ENTREGA;
			this.situacaoPedido = SituacaoPedido.ENTREGUE;
		}
	}
	
	public void enviarPedidoParaCliente() {
		if (this.situacaoPedido == SituacaoPedido.PRONTO) {
			if (this.modoDeEntrega == TipoDeEnvio.RETIRADA) {
				retirarPedido();
			} else {
				entregarPedido();
			}
		}
	}
	
	private boolean podeAvaliar() {
		if (this.situacaoPedido == SituacaoPedido.ENTREGUE) {
			return true;
		} else {
			return false;
		}
	}
	
	private void salvarAvaliacaoDoRestaurante(int estrelas, String comentario) {
		if (podeAvaliar()) {
			this.avaliacaoRestaurante = estrelas;
			this.comentarioParaRestaurante = comentario;
			this.restaurante.atualizarAvaliacao(estrelas);
		}
	}
	
	public void avaliarRestaurante(int estrelas) {
		salvarAvaliacaoDoRestaurante(estrelas, null);
	}
	
	public void avaliarRestaurante(int estrelas, String comentario) {
		salvarAvaliacaoDoRestaurante(estrelas, comentario);
	}
	
	private void salvarAvaliacaoDoEntregador(int estrelas, String comentario) {
		if (podeAvaliar() && (this.entregadorResponsavel != null)) {
			this.avaliacaoEntregador = estrelas;
			this.comentarioParaEntregador = comentario;
			this.entregadorResponsavel.atualizarAvaliacao(estrelas);
		}
	}
	
	public void avaliarEntregador(int estrelas) {
		salvarAvaliacaoDoEntregador(estrelas, null);
	}
	
	public void avaliarEntregador(int estrelas, String comentario) {
		salvarAvaliacaoDoEntregador(estrelas, comentario);
	}
	
	private void salvarAvaliacaoDoLanche(Lanche lanche, int estrelas, String comentario) {
		if (podeAvaliar()) {
			Lanche lancheDoPedido = lanche.obterLancheDaLista(lanchesEscolhidos);
			if (lancheDoPedido != null) {
				lancheDoPedido.avaliar(estrelas, comentario);
				this.restaurante.atualizarAvaliacaoDoLancheNoCardapio(lanche, estrelas);
			}
		}
	}
	
	public void avaliarLanche(Lanche lanche, int estrelas) {
		salvarAvaliacaoDoLanche(lanche, estrelas, null);
	}
	
	public void avaliarLanche(Lanche lanche, int estrelas, String comentario) {
		salvarAvaliacaoDoLanche(lanche, estrelas, comentario);
	}

	private void imprimirDescontoPrimeiraCompra() {
		if (this.primeiroPedido) {
			System.out.println("(PRIMEIRA COMPRA COM 20% DE DESCONTO)");
		}
	}
	
	private void imprimirFrete() {
		if (this.modoDeEntrega == TipoDeEnvio.ENTREGA) {
			System.out.printf("FRETE: R$ %.1f %n", calcularPrecoDeEntrega());
		}
	}
	
	private void imprimirLanches() {
		if (this.lanchesEscolhidos != null) {
			for (int posicaoLanche = 0; posicaoLanche < this.lanchesEscolhidos.size(); posicaoLanche++) {
				this.lanchesEscolhidos.get(posicaoLanche).imprimirLanche();
			}
		}
	}
	
	public void imprimirPedido() {
		this.cliente.imprimirCliente();
		System.out.println("- " + this.lanchesEscolhidos.size() + " lanches:");
		imprimirLanches();
		imprimirFrete();
		System.out.printf("Valor total: R$ %.1f %n" , this.valorTotal);
		imprimirDescontoPrimeiraCompra();
	}
	
	private void imprimirAvaliacaoRestaurante() {
		System.out.println("	-> Restaurante: " + this.avaliacaoRestaurante);
		if (this.comentarioParaRestaurante != null) {
			System.out.println("	(COMENTARIO: " + this.comentarioParaRestaurante + ")");
		}
	}
	
	private void imprimirAvaliacaoEntregador() {
		if (this.entregadorResponsavel != null) {
			this.entregadorResponsavel.imprimirEntregador();
			System.out.println(this.avaliacaoEntregador + " estrelas");
			if (this.comentarioParaEntregador != null) {
				System.out.println("	(COMENTARIO: " + this.comentarioParaEntregador + ")");
			}
		}
	}
	
	private void imprimirAvaliacaoLanches() {
		if (this.lanchesEscolhidos != null) {
			for (int posicaoLanche = 0; posicaoLanche < this.lanchesEscolhidos.size(); posicaoLanche++) {
				this.lanchesEscolhidos.get(posicaoLanche).imprimirAvaliacao();
			}
		}
	}
	
	public void imprimirAvaliacao() {
		imprimirAvaliacaoRestaurante();
		imprimirAvaliacaoEntregador();
		System.out.println("	-> Lanches:");
		imprimirAvaliacaoLanches();
	}
}
