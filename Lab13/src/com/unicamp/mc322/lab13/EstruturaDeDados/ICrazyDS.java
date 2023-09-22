package com.unicamp.mc322.lab13.EstruturaDeDados;

import com.unicamp.mc322.lab13.Pedidos.*;

public interface ICrazyDS {
	
	public void adicionarElemento(IOrder elemento);
	
	public void removerElemento(IOrder elemento);
	
	public IOrder obterElemento(int posicao) throws EstruturaDeDadosException;
	
	public IOrder obterElementoDeMaiorPrioridade() throws EstruturaDeDadosException;
	
	public void imprimirElementos() throws EstruturaDeDadosException;
	
}
