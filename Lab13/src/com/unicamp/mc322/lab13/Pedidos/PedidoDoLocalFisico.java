package com.unicamp.mc322.lab13.Pedidos;

import java.util.Random;

import com.unicamp.mc322.lab13.Pessoa;

public class PedidoDoLocalFisico implements IOrder {
	
	private final int TAMANHO_CODIGO = 5;
	protected Pessoa cliente;
	protected int numeroTurnos;
	protected String codigo;
	
	public PedidoDoLocalFisico(Pessoa pessoa) {
		cliente = pessoa;
		numeroTurnos = 0;
		codigo = gerarCodigo();
	}
	
	private String gerarCodigo() {
		Random aleatorio = new Random();
		String codigo = "PRESENCIAL: ";
		int tamanhoCodigo = 0;
		while (tamanhoCodigo < this.TAMANHO_CODIGO) {
			codigo += aleatorio.nextInt(100);
			tamanhoCodigo ++;
		}
		return codigo;
		
	}
	
	@Override
	public void aumentarNumeroTurnos() {
		this.numeroTurnos ++;
	}
	
	@Override
	public int obterNumeroTurnos() {
		return this.numeroTurnos;
	}
	
	@Override
	public String obterCodigo() {
		return this.codigo;
	}
	
	@Override
	public Pessoa obterCliente() {
		return this.cliente;
	}
	
	@Override
	public void imprimirInformacaoReduziaDoCliente() {
		this.cliente.imprimirInformacaoReduzida();
	}
	
	@Override
	public void imprimirInformacaoCompletaDoCliente() {
		this.cliente.imprimirInformacaoCompleta();
	}
	
	@Override
	public void imprimir() {
		System.out.println("Pedido no local");
		System.out.println("(" + this.codigo + ")");
		System.out.println("- Cliente: ");
		this.cliente.imprimirInformacaoReduzida();
		System.out.println();
	}
	
}
