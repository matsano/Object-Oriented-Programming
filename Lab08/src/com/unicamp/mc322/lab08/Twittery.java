package com.unicamp.mc322.lab08;

import java.util.ArrayList;

public class Twittery {
	
	private ArrayList<Usuario> usuarios;
	
	public Twittery() {
		usuarios = new ArrayList();
	}
	
	private boolean naoHaEsseEmail(Usuario usuario) {
		boolean semEsseEmailNoSistema = true;
		if (this.usuarios != null) {
			for (int numeroUsuario = 0; numeroUsuario < this.usuarios.size(); numeroUsuario++) {
				if (this.usuarios.get(numeroUsuario).getEmail() == usuario.getEmail()) {
					semEsseEmailNoSistema = false;
				}
			}
		}
		return semEsseEmailNoSistema;
	}
	
	private boolean naoHaEsseApelido(Usuario usuario) {
		boolean semEsseApelidoNoSistema = true;
		if (this.usuarios != null) {
			for (int numeroUsuario = 0; numeroUsuario < this.usuarios.size(); numeroUsuario++) {
				if (this.usuarios.get(numeroUsuario).getApelido() == usuario.getApelido()) {
					semEsseApelidoNoSistema = false;
				}
			}
		}
		return semEsseApelidoNoSistema;
	}
	
	public void cadastrarUsuario(Usuario novoUsuario) {
		if (novoUsuario.ehMaiorde18()) {
			if (naoHaEsseEmail(novoUsuario)) {
				if (naoHaEsseApelido(novoUsuario)) {
					this.usuarios.add(novoUsuario);
				}
			}
		}
	}
	
}
