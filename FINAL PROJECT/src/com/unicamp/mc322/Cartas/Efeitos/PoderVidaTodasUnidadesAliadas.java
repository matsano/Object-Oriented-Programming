package com.unicamp.mc322.Cartas.Efeitos;

import java.util.ArrayList;
import com.unicamp.mc322.Cartas.UnidadeEvocada;

public class PoderVidaTodasUnidadesAliadas extends Efeito {
	
	private int poderAdicional;
	private int vidaAdicional;
	private ArrayList<UnidadeEvocada> unidadesAliadas;
	
	public PoderVidaTodasUnidadesAliadas(int poder, int vida) {
		super("+" + poder + "/+" + vida + " para todas unidades aliadas");
		tipo = TipoDeEfeito.PODER_VIDA_UNIDADES_ALIADAS;
		poderAdicional = poder;
		vidaAdicional = vida;
	}
	
	public PoderVidaTodasUnidadesAliadas clonar() {
		return new PoderVidaTodasUnidadesAliadas(this.poderAdicional, this.vidaAdicional);
	}
	
	public void ativar() {
		if ((this.unidadesAliadas.size() != 0) && (!this.ativado)) {
			for (int posicao = 0; posicao < this.unidadesAliadas.size(); posicao++) {
				this.unidadesAliadas.get(posicao).aumentarPoderVida(poderAdicional, vidaAdicional);
			}
			this.ativado = true;
		}
	}
	
	public void atualizarUnidadesAliadas(ArrayList<UnidadeEvocada> unidades) {
		this.unidadesAliadas = unidades;
	}
}