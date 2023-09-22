package com.unicamp.mc322.lab10;

import com.unicamp.mc322.lab10.Usuario.*;
import java.util.ArrayList;

public class Pidao {
	
	private ArrayList<Restaurante> restaurantesCadastrados;
	private ArrayList<Usuario> usuariosCadastrados;
	
	public Pidao() {
		restaurantesCadastrados = new ArrayList<Restaurante>();
		usuariosCadastrados = new ArrayList<Usuario>();
	}
	
	public void cadastrarRestaurante(Restaurante restaurante) {
		this.restaurantesCadastrados.add(restaurante);
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		this.usuariosCadastrados.add(usuario);
	}
	
	public void concluirPedido(Pedido pedido) {
		pedido.fecharPedido();		
	}
	
	public void cancelarPedido(Pedido pedido) {
		pedido.apagarPedido();
	}
	
	public void atualizarPedido(Pedido pedido) {
		pedido.finalizarPreparo();
	}
	
	public void entregarPedido(Pedido pedido) {
		pedido.enviarPedidoParaCliente();
	}
	
	public void avaliarRestaurante(Pedido pedido, int estrelas) {
		pedido.avaliarRestaurante(estrelas);
	}
	
	public void avaliarRestaurante(Pedido pedido, int estrelas, String comentario) {
		pedido.avaliarRestaurante(estrelas, comentario);
	}
	
	public void avaliarEntregador(Pedido pedido, int estrelas) {
		pedido.avaliarEntregador(estrelas);
	}
	
	public void avaliarEntregador(Pedido pedido, int estrelas, String comentario) {
		pedido.avaliarEntregador(estrelas, comentario);
	}
	
	public void avaliarLanche(Pedido pedido, Lanche lanche, int estrelas) {
		pedido.avaliarLanche(lanche, estrelas);
	}
	
	public void avaliarLanche(Pedido pedido, Lanche lanche, int estrelas, String comentario) {
		pedido.avaliarLanche(lanche, estrelas, comentario);
	}
	
	private void imprimirOpcao(OpcaoDeImpressao opcao, Restaurante restaurante) {
		switch(opcao) {
		case PEDIDO:
			restaurante.imprimirPedidos();
			break;
		case CARDAPIO:
			restaurante.imprimirCardapio();
			break;
		case AVALIACAO:
			restaurante.imprimirAvaliacao();
			break;
		}
	}
	
	public void imprimir(OpcaoDeImpressao opcao) {
		if (this.restaurantesCadastrados != null) {
			for (int posicaoRestaurante = 0; posicaoRestaurante < this.restaurantesCadastrados.size(); posicaoRestaurante++) {
				imprimirOpcao(opcao, this.restaurantesCadastrados.get(posicaoRestaurante));
				System.out.println();
				System.out.println("------------------------------------------");
			}
		}
	}
}
