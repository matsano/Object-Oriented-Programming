package com.unicamp.mc322.lab13.Pedidos;

import java.util.*;

import com.unicamp.mc322.lab13.Pessoa;

public abstract class Pedido implements IOrder {
	
	private final int TAMANHO_CODIGO = 5;
	protected Pessoa cliente;
	protected int numeroTurnos;
	protected String codigo;
	
	public Pedido (Pessoa pessoa) {
		cliente = pessoa;
		numeroTurnos = 0;
		codigo = gerarCodigo();
	}
	
	private String obterCaracteresPossiveis() {
		String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
		String letrasMaiusculas = letrasMinusculas.toUpperCase();
		String numeros = "0123456789";
		return letrasMinusculas + letrasMaiusculas + numeros;
	}
	
	private ArrayList<String> embaralharCaracteresPossiveis(){
		String[] caracteresPossiveis = this.obterCaracteresPossiveis().split("");
		ArrayList<String> caracteres = new ArrayList<String>();
		for (String caractere : caracteresPossiveis) {
			caracteres.add(caractere);
		}
		Collections.shuffle(caracteres);
		return caracteres;
	}
	
	private String gerarCodigo() {
		StringBuilder codigo = new StringBuilder(this.TAMANHO_CODIGO);
		List<String> caracteresEmbaralhados = this.embaralharCaracteresPossiveis();
		for (int contador = 0; contador < this.TAMANHO_CODIGO; contador++) {
			codigo.append(caracteresEmbaralhados.get(contador));
		}
		return codigo.toString();
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
		System.out.println("Pedido - " + this.codigo);
		System.out.println("- Cliente: ");
		this.cliente.imprimirInformacaoCompleta();
		System.out.println();
	}
}
