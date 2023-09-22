package com.unicamp.mc322.lab13.Pedidos;

import com.unicamp.mc322.lab13.Pessoa;

public interface IOrder {
	
	public void aumentarNumeroTurnos();
	
	public int obterNumeroTurnos();
	
	public String obterCodigo();
	
	public void imprimirInformacaoReduziaDoCliente();
	
	public void imprimirInformacaoCompletaDoCliente();
	
	public Pessoa obterCliente();
	
	public void imprimir();
}
