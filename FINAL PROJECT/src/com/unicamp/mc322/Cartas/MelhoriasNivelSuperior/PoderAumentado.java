package com.unicamp.mc322.Cartas.MelhoriasNivelSuperior;

import com.unicamp.mc322.Cartas.Campeao;

public class PoderAumentado extends Melhoria {
	
	private int poderAdicional;
	
	public PoderAumentado(Campeao campeao, int poderSomado) {
		super(campeao);
		poderAdicional = poderSomado;
	}
	
	public void aplicar() {
		this.dono.adicionarPoder(poderAdicional);
	}
	
}
