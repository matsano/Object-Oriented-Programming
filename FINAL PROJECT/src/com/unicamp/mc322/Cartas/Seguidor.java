package com.unicamp.mc322.Cartas;

import com.unicamp.mc322.Cartas.Tracos.Traco;

public class Seguidor extends UnidadeEvocada {
	
	public Seguidor (String umNome, int custo, int valorPoder, int valorVida) {
		super(umNome, custo, valorPoder, valorVida);
	}
	
	public Seguidor (String umNome, int custo, int valorPoder, int valorVida, Traco umTraco) {
		super(umNome, custo, valorPoder, valorVida, umTraco);
	}
	
	public static boolean ehSeguidor(UnidadeEvocada carta) {
		return carta instanceof Seguidor;
	}
	
	public void imprimirInformacaoAdicional() {
		System.out.println("Tipo: SEGUIDOR");
		this.imprimirPoderVida();
		this.imprimirTracos();
		this.imprimirEfeitos();
	}
}
