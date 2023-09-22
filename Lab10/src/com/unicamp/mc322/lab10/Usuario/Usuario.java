package com.unicamp.mc322.lab10.Usuario;

public abstract class Usuario {
	
	protected String nome;
	protected String cpf;
	
	protected Usuario(String oNome, String documento) {
		nome = oNome;
		cpf = documento;
	}
	
}