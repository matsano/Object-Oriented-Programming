package com.unicamp.mc322.Cartas;

import com.unicamp.mc322.Cartas.Tracos.*;
import java.util.ArrayList;

public abstract class UnidadeEvocada extends Carta {
	
	protected int poder;
	protected int poderNaBatalha;
	protected int poderInicial;
	protected int vida;
	protected int vidaInicial;
	protected ArrayList<Traco> tracos;
	
	protected UnidadeEvocada (String umNome, int custo, int valorPoder, int valorVida) {
		super(umNome, custo);
		poder = valorPoder;
		poderInicial = valorPoder;
		poderNaBatalha = valorPoder;
		vida = valorVida;
		vidaInicial = valorVida;
		tracos = new ArrayList<Traco>();
	}
	
	protected UnidadeEvocada (String umNome, int custo, int valorPoder, int valorVida, Traco umTraco) {
		this(umNome, custo, valorPoder, valorVida);
		Traco traco = umTraco.clonar();
		traco.determinarDona(this);
		this.tracos.add(traco);
	}
	
	public static boolean ehUnidadeEvocada(Carta carta) {
		return carta instanceof UnidadeEvocada;
	}
	
	public void atacarDuasVezes(UnidadeEvocada adversario) {
		this.poderNaBatalha = 2 * this.poder;
	}
	
	public void defenderComElusivo(UnidadeEvocada adversario) {
		if (adversario.tracos != null) {
			for (int posicaoTraco = 0; posicaoTraco < this.tracos.size(); posicaoTraco++) {
				if (Elusivo.ehElusivo(adversario.tracos.get(posicaoTraco))) {
					adversario.poderNaBatalha = 0;
				}
			}
		}
	}
	
	public boolean estaDestruida() {
		if (this.vida <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void aumentarPoderVida(int pontosPoder, int pontosVida) {
		this.poder += pontosPoder;
		this.vida += pontosVida;
	}
	
	public void curarInteiramente() {
		this.vida = this.vidaInicial;
	}
	
	public void zerarPoderNaBatalha() {
		this.poderNaBatalha = 0;
	}
	
	public void dobrarVidaPoder() {
		this.poder = 2 * this.poder;
		this.vida = 2 * this.vida;
	}
	
	public void atacar(UnidadeEvocada cartaAdversaria) {
		cartaAdversaria.vida -= this.poderNaBatalha;
		this.poderNaBatalha = this.poder;
	}
	
	public void atualizarPoder() {
		this.poderNaBatalha = this.poder;
	}
	
	public void aplicarTracos (UnidadeEvocada cartaAdversaria) {
		int posicaoTraco = 0;
		while (posicaoTraco < this.tracos.size()) {
			this.tracos.get(posicaoTraco).atualizarAdversario(cartaAdversaria);
			this.tracos.get(posicaoTraco).aplicar();
			posicaoTraco += 1;
		}
	}
	
	protected void imprimirTracos() {
		System.out.print("Tracos: ");
		System.out.println(this.tracos.size());
		if (this.tracos != null) {
			for (int posicaoTraco = 0; posicaoTraco < this.tracos.size(); posicaoTraco++) {
				System.out.print("	-> ");
				this.tracos.get(posicaoTraco).imprimir();
			}
		}
	}
	
	protected void imprimirPoderVida() {
		System.out.println("Poder: " + this.poder);
		System.out.println("Vida: " + this.vida);
	}
	
	public int getPoderNaBatalha() {
		return this.poderNaBatalha;
	}
	
}
