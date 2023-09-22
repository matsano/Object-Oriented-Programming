package com.unicamp.mc322.lab13.Estrategias;

import com.unicamp.mc322.lab13.Pedidos.IOrder;

public class PrioridadeMediaAritmeticaPonderada implements IOrderingStrategy {
	
	private final double PESO_IDADE = 3.0;
	private final double PESO_QUANTIDADE_TURNOS = 2.0;
	
	public double calcularPontosDePrioridade(IOrder elemento) {
		double calculoComIdade = this.PESO_IDADE * elemento.obterCliente().getIdade();
		double calculoComQuantidadeTurnos = this.PESO_QUANTIDADE_TURNOS * elemento.obterNumeroTurnos();
		double pontosDePrioridade = (calculoComIdade + calculoComQuantidadeTurnos) / (this.PESO_IDADE + this.PESO_QUANTIDADE_TURNOS);
		return pontosDePrioridade;
	}
}

/*Nesta estrategia, calcula-se a pontuacao de prioridade do pedido por meio
de uma media ponderada da idade do dono do pedido e da quantidade de turnos
que o pedido esperou na fila. O peso da idade é 3 e o peso da quantidade de
é igual a 2;
*/