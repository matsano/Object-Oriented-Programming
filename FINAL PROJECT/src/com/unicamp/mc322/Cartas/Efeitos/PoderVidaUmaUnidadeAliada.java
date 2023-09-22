package com.unicamp.mc322.Cartas.Efeitos;

import java.util.ArrayList;
import java.util.Random;

import com.unicamp.mc322.Cartas.UnidadeEvocada;

public class PoderVidaUmaUnidadeAliada extends Efeito {
	
	private int poderAdicional;
	private int vidaAdicional;
	private ArrayList<UnidadeEvocada> unidadesAliadas;
	
	public PoderVidaUmaUnidadeAliada(int poder, int vida) {
		super("+" + poder + "/+" + vida + " para uma unidade aliada");
		tipo = TipoDeEfeito.PODER_VIDA_UMA_ALIADA;
		poderAdicional = poder;
		vidaAdicional = vida;
	}
	
	public PoderVidaUmaUnidadeAliada clonar() {
		return new PoderVidaUmaUnidadeAliada(this.poderAdicional, this.vidaAdicional);
	}
	
	public void ativar() {
		if ((this.unidadesAliadas.size() != 0) && (!this.ativado)) {
			Random aleatorio = new Random();
			int posicaoAleatoria = aleatorio.nextInt(this.unidadesAliadas.size());
			this.unidadesAliadas.get(posicaoAleatoria).aumentarPoderVida(poderAdicional, vidaAdicional);
			this.ativado = true;
		}
	}
	
	public void atualizarUnidadesAliadas(ArrayList<UnidadeEvocada> unidades) {
		this.unidadesAliadas = unidades;
	}
}
