package com.unicamp.mc322.Cartas.MelhoriasNivelSuperior;

import com.unicamp.mc322.Cartas.Campeao;

public class VidaAumentada extends Melhoria {
	
	private int vidaAdicional;
	
	public VidaAumentada(Campeao campeao, int vidaSomada) {
		super(campeao);
		vidaAdicional = vidaSomada;
	}
	
	public void aplicar() {
		this.dono.adicionarVida(vidaAdicional);
	}
}
