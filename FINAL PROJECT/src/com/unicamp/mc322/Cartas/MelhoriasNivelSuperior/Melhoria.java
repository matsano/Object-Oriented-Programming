package com.unicamp.mc322.Cartas.MelhoriasNivelSuperior;

import com.unicamp.mc322.Cartas.Campeao;

public abstract class Melhoria {
	
	protected Campeao dono;
	
	protected Melhoria(Campeao campeao) {
		dono = campeao;
	}
	
	public abstract void aplicar();
}
