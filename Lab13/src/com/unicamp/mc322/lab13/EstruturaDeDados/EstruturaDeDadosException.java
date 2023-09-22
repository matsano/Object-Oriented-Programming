package com.unicamp.mc322.lab13.EstruturaDeDados;

public class EstruturaDeDadosException extends Exception {
	
	public EstruturaDeDadosException() {
		super();
	}
	
	public EstruturaDeDadosException(String mensagem) {
		super(mensagem);
	}
	
	public EstruturaDeDadosException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	public EstruturaDeDadosException(Throwable causa) {
		super(causa);
	}
	
}
