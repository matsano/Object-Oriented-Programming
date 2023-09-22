package com.unicamp.mc322.lab01;

import java.util.Scanner;

public class Principal {
	
	public static void main (String[] args) {
		
		Scanner input = new Scanner (System.in);
		System.out.println("Digite a operacao que deseja:");
		int numero = input.nextInt();
		Calculadora cal = new Calculadora();
		int variavel;
		
		while (numero >= 1 && numero <=6) {
			if (numero == 1) {
				double n1 = input.nextDouble();
				double n2 = input.nextDouble();
				System.out.println(cal.soma(n1, n2));
			} else if (numero == 2) {
				double n1 = input.nextDouble();
				double n2 = input.nextDouble();
				System.out.println(cal.subtracao(n1, n2));
			} else if (numero == 3) {
				double n1 = input.nextDouble();
				double n2 = input.nextDouble();
				System.out.println(cal.multiplicacao(n1, n2));
			} else if (numero == 4) {
				double n1 = input.nextDouble();
				double n2 = input.nextDouble();
				System.out.println(cal.divisao(n1, n2));
			} else if (numero == 5) {
				int n1 = input.nextInt();
				System.out.println(cal.fatorial(n1));
			} else if (numero == 6) {
				int n1 = input.nextInt();
				if (cal.primalidade(n1) == true) {
					System.out.println("Primo");
				} else {
					System.out.println("Nao primo");
				}
			}
			
			System.out.println("Deseja executar outra operacao? Digite 1 para SIM. Digite 2 para NAO");
			variavel = input.nextInt();
			if (variavel == 1) {
				System.out.println("Digite a operacao que deseja:");
				numero = input.nextInt();
			} else {
				numero = 7;
			}
		}
		
		
	}
}
