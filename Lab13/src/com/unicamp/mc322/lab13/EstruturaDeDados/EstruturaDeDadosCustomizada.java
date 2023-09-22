package com.unicamp.mc322.lab13.EstruturaDeDados;

import com.unicamp.mc322.lab13.Pedidos.IOrder;
import com.unicamp.mc322.lab13.Estrategias.IOrderingStrategy;
import java.util.ArrayList;

public class EstruturaDeDadosCustomizada implements ICrazyDS {
	
	private IOrderingStrategy estrategiaEscolhida;
	private ArrayList<IOrder> elementos;
	
	public EstruturaDeDadosCustomizada(IOrderingStrategy estrategia) {
		estrategiaEscolhida = estrategia;
		elementos = new ArrayList<IOrder>();
	}
	
	private int obterPosicaoDoNovoElemento(IOrder novoElemento) {
		int posicaoElemento = 0;
		boolean posicaoEncontrada = false;
		double prioridadeNovoElemento = this.estrategiaEscolhida.calcularPontosDePrioridade(novoElemento);
		while ((posicaoElemento < this.elementos.size()) && !posicaoEncontrada) {
			if (prioridadeNovoElemento > this.estrategiaEscolhida.calcularPontosDePrioridade(this.elementos.get(posicaoElemento))) {
				posicaoEncontrada = true;
			}
			posicaoElemento += 1;
		}
		return posicaoElemento;
	}
	
	public void adicionarElemento(IOrder elemento) {
		int posicaoElemento = this.obterPosicaoDoNovoElemento(elemento);
		this.elementos.add(posicaoElemento, elemento);
	}
	
	private void aumentarTurnosDosElementos() {
		int posicaoElemento = 0;
		while (posicaoElemento < this.elementos.size()) {
			this.elementos.get(posicaoElemento).aumentarNumeroTurnos();
			posicaoElemento += 1;
		}
	}
	
	public IOrder obterElemento(int posicao) throws EstruturaDeDadosException {
		if (this.elementos.size() > 0) {
			if (posicao < this.elementos.size()) {
				return this.elementos.get(posicao);
			}
			else {
				throw new EstruturaDeDadosException("Nao ha esse elemento na posicao " + posicao + " na estrutura de dados.");
			}
		}
		throw new EstruturaDeDadosException("Nao ha elementos na estrutura de dados.");
	}
	
	public void removerElemento(IOrder elemento) {
		try {
			if (elemento == this.obterElementoDeMaiorPrioridade()) {
				this.aumentarTurnosDosElementos();
			}
			this.elementos.remove(elemento);
		} catch (EstruturaDeDadosException e) {
			e.printStackTrace();
		}
	}
	
	public IOrder obterElementoDeMaiorPrioridade() throws EstruturaDeDadosException {
		return this.obterElemento(0);
	}
	
	public void imprimirElementos() throws EstruturaDeDadosException {
		int posicaoElemento = 0;
		while (posicaoElemento < this.elementos.size()) {
			this.obterElemento(posicaoElemento).imprimir();
			posicaoElemento += 1;
		}
	}
	
}
