package com.unicamp.mc322.Cartas.MelhoriasNivelSuperior;

import com.unicamp.mc322.Cartas.Campeao;
import com.unicamp.mc322.Cartas.Tracos.Traco;

public class NovoTraco extends Melhoria {
	
	private Traco novoTraco;
	
	public NovoTraco(Campeao campeao, Traco traco) {
		super(campeao);
		Traco umTraco = traco.clonar();
		novoTraco = umTraco;
	}
	
	public void aplicar() {
		this.dono.adicionarTraco(novoTraco);
	}
	
}
