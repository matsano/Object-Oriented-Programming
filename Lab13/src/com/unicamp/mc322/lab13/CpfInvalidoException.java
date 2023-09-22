package com.unicamp.mc322.lab13;

public class CpfInvalidoException extends Exception {
	
	public CpfInvalidoException() {
		super();
	}
	
	public CpfInvalidoException(String mensagem) {
		super(mensagem);
	}
	
	public CpfInvalidoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	public CpfInvalidoException(Throwable causa) {
		super(causa);
	}
}