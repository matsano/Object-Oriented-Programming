package com.unicamp.mc322.Cartas.MelhoriasNivelSuperior;

import com.unicamp.mc322.Cartas.Campeao;
import com.unicamp.mc322.Cartas.Efeitos.*;

public class NovoEfeito extends Melhoria {
	
private Efeito novoEfeito;
	
	public NovoEfeito(Campeao campeao, Efeito efeito) {
		super(campeao);
		Efeito umEfeito = efeito.clonar();
		umEfeito.determinarDona(campeao);
		novoEfeito = umEfeito;
	}
	
	public void aplicar() {
		this.dono.adicionarEfeito(novoEfeito);
	}
}
