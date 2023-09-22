package com.unicamp.mc322.lab07;

import com.unicamp.mc322.lab07.Elementos.*;
import java.util.Scanner;

public class FrogyGame {
	
	public void rodarJogo() {
		
		Scanner teclado = new Scanner(System.in);
		boolean rodar = true;
		boolean fimDoJogo = false;
		
		Pedra pedra1 = new Pedra(2, 7);
		Pedra pedra2 = new Pedra(3, 2);
		Pedra pedra3 = new Pedra(7, 1);
		Pedra pedra4 = new Pedra(8, 4);
		Pedra pedra5 = new Pedra(8, 8);
		PredadorAnimal predador1 = new PredadorAnimal(4,4,5,5);
		Armadilha armadilha1 = new Armadilha(0,0,0,1);
		
		Vagalume vagalume1 = new Vagalume(1,3, "Vagalume 1");
		Grilo grilo1 = new Grilo(4,7, "Grilo 1");
		
		RaVerde ra1 = new RaVerde(8, 7, "Jogador 1");
		
		Mapa lagoa = new Mapa(10, 10);
		
		lagoa.adicionarObstaculo(pedra1);
		lagoa.adicionarObstaculo(pedra2);
		lagoa.adicionarObstaculo(pedra3);
		lagoa.adicionarObstaculo(pedra4);
		lagoa.adicionarObstaculo(pedra5);
		lagoa.adicionarObstaculo(predador1);
		lagoa.adicionarObstaculo(armadilha1);
		lagoa.adicionarComida(vagalume1);
		lagoa.adicionarComida(grilo1);
		lagoa.adicionarRa(ra1);
		
		while (rodar) {
			if (fimDoJogo == true) {
				rodar = false;
				System.out.println("Game Over!");
				ra1.imprimirResultados();
			} else {
				lagoa.imprimirMapa();
				System.out.print("Coloque o comando: ");
				String comando = teclado.nextLine();
				if (comando.compareTo("w") == 0) {
					ra1.moverCima();
				} else if (comando.compareTo("a") == 0) {
					ra1.moverEsquerda();
				} else if (comando.compareTo("s") == 0) {
					ra1.moverBaixo();
				} else if (comando.compareTo("d") == 0) {
					ra1.moverDireita();
				}
				if (lagoa.saiuDoMapa()) {
					System.out.print("Ra saiu do mapa!");
					fimDoJogo = true;
				} else {
					lagoa.atualizarMapa();
					if (!ra1.estaVivo()) {
						fimDoJogo = true;
						lagoa.imprimirMapa();
					} else {
					}
				}
			}
			System.out.println();
		}
	}
}
