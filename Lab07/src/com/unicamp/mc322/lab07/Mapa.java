package com.unicamp.mc322.lab07;

import java.util.ArrayList;
import com.unicamp.mc322.lab07.Elementos.*;

public class Mapa {
	
	private Comida[][] comidas;
	private Obstaculo[][] obstaculos;
	private Ra ra;
	private int altura;
	private int largura;
	
	public Mapa(int aAltura, int aLargura) {
		comidas = new Comida[aAltura][aLargura];
		obstaculos = new Obstaculo[aAltura][aLargura];
		ra = null;
		altura = aAltura;
		largura = aLargura;
	}
	
	public void adicionarObstaculo(Obstaculo obstaculo) {
		if (obstaculo.respeitaRestricao()) {
			ArrayList<Posicao> posicoesDoObstaculo = obstaculo.getPosicoes();
			posicoesDoObstaculo.forEach(posicao -> this.obstaculos[posicao.getLinha()][posicao.getColuna()] = obstaculo);
		}
	}
	
	public void adicionarComida(Comida comida) {
		ArrayList<Posicao> posicoesDaComida = comida.getPosicoes();
		posicoesDaComida.forEach(posicao -> this.comidas[posicao.getLinha()][posicao.getColuna()] = comida);
	}
	
	public void adicionarRa(Ra jogador) {
		this.ra = jogador;
	}
	
	private boolean pegouComida(int linhaDaRa, int colunaDaRa) {
		if (this.comidas[linhaDaRa][colunaDaRa] != null) {
			return true;
		} else {
			return false;
		}
	}
	
	private void removerComida(Comida comida) {
		ArrayList<Posicao> posicoesDaComida = comida.getPosicoes();
		posicoesDaComida.forEach(posicao -> this.comidas[posicao.getLinha()][posicao.getColuna()] = null);
	}
	
	private void verificarSePegouComida(int linhaDaRa, int colunaDaRa) {
		if (pegouComida(linhaDaRa, colunaDaRa)) {
			Comida comidaConsumida = this.comidas[linhaDaRa][colunaDaRa];
			this.ra.calcularPontosObtidos(comidaConsumida);
			this.ra.adicionarComidaIngerida(comidaConsumida);
			removerComida(comidaConsumida);
		}
	}
	
	private boolean bateuEmObstaculo(int linhaDaRa, int colunaDaRa) {
		if (this.obstaculos[linhaDaRa][colunaDaRa] != null) {
			return true;
		} else {
			return false;
		}
	}
	
	private void removerObstaculo(Obstaculo obstaculo) {
		ArrayList<Posicao> posicoesDoObstaculo = obstaculo.getPosicoes();
		posicoesDoObstaculo.forEach(posicao -> this.obstaculos[posicao.getLinha()][posicao.getColuna()] = null);
	}
	
	private void verificarSeBateuEmObstaculo(int linhaDaRa, int colunaDaRa) {
		if (bateuEmObstaculo(linhaDaRa, colunaDaRa)) {
			Obstaculo obstaculoBatido = this.obstaculos[linhaDaRa][colunaDaRa];
			this.ra.morreu();
			removerObstaculo(obstaculoBatido);
		}
	}
	
	public void atualizarMapa() {
		int linhaDaRa = this.ra.getPosicoes().get(0).getLinha();
		int colunaDaRa = this.ra.getPosicoes().get(0).getColuna();
		verificarSePegouComida(linhaDaRa, colunaDaRa);
		verificarSeBateuEmObstaculo(linhaDaRa, colunaDaRa);
	}
	
	public boolean saiuDoMapa() {
		boolean foraDoMapa = false;
		int linhaDoElemento = this.ra.getPosicoes().get(0).getLinha();
		int colunaDoElemento = this.ra.getPosicoes().get(0).getColuna();
		if ((linhaDoElemento < 0) || (linhaDoElemento >= this.altura)) {
			foraDoMapa = true;
		} else if ((colunaDoElemento < 0) || (colunaDoElemento >= this.largura)) {
			foraDoMapa = true;
		}
		return foraDoMapa;
	}
	
	public void imprimirMapa() {
		for (int linha = 0; linha < this.altura; linha++) {
			for (int coluna = 0; coluna < this.largura; coluna++) {
				if (this.comidas[linha][coluna] != null) {
					System.out.print(this.comidas[linha][coluna].getIcone());
				} else if (this.obstaculos[linha][coluna] != null) {
					System.out.print(this.obstaculos[linha][coluna].getIcone());
				} else if (this.ra.ehPosicaoDaRa(linha, coluna)) {
					System.out.print(this.ra.getIcone());
				} else {
					System.out.print("--");
				}
				System.out.print("  ");
			}
			System.out.println();
		}
	}

}
