package com.unicamp.mc322.lab13.Estrategias;

import com.unicamp.mc322.lab13.Pedidos.IOrder;

public class PriorityScore implements IOrderingStrategy {
	
	public double calcularPontosDePrioridade(IOrder elemento) {
		double calculoComIdade = elemento.obterCliente().getIdade() / 100.0;
		double calculoComQuantidadeTurnos = (7.0/100.0) * elemento.obterNumeroTurnos();
		return (calculoComIdade + calculoComQuantidadeTurnos);
	}
	
}
