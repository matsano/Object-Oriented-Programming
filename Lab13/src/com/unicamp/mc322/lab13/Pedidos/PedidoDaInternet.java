package com.unicamp.mc322.lab13.Pedidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.unicamp.mc322.lab13.Pessoa;

public class PedidoDaInternet implements IOrder {
	
	private final int TAMANHO_CODIGO_ALEATORIO = 6;
	protected Pessoa cliente;
	protected int numeroTurnos;
	protected String codigo;
	
	public PedidoDaInternet(Pessoa pessoa) {
		cliente = pessoa;
		numeroTurnos = 0;
		codigo = "INTERNET: " + gerarCodigoAleatorio();
	}
	
	private String obterCaracteresPossiveis() {
		String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
		String letrasMaiusculas = letrasMinusculas.toUpperCase();
		return letrasMinusculas + letrasMaiusculas;
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
	
	private String gerarCodigoAleatorio() {
		StringBuilder codigo = new StringBuilder(this.TAMANHO_CODIGO_ALEATORIO);
		List<String> caracteresEmbaralhados = this.embaralharCaracteresPossiveis();
		for (int contador = 0; contador < this.TAMANHO_CODIGO_ALEATORIO; contador++) {
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
		System.out.println("Pedido da Internet");
		System.out.println("(" + this.codigo + ")");
		System.out.println("- Cliente: ");
		this.cliente.imprimirInformacaoCompleta();
		System.out.println();
	}

}
