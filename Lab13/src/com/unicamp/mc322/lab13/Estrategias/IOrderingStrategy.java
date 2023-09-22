package com.unicamp.mc322.lab13.Estrategias;

import com.unicamp.mc322.lab13.Pedidos.*;

public interface IOrderingStrategy {
	
	public double calcularPontosDePrioridade(IOrder elemento);
	
}
