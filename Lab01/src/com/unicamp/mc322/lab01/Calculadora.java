package com.unicamp.mc322.lab01;

public class Calculadora {
	
	public double soma(double a, double b) {
		return a + b;
	}
	
	public double subtracao(double a, double b) {
		return a - b;
	}
	
	public double multiplicacao(double a, double b) {
		return a * b;
	}
	
	public double divisao(double a, double b) {
		return a / b;
	}
	
	public int fatorial(int a) {
		int resultado = 1;
		
		if (a != 0) {
			while (a != 1) {
				resultado = a * resultado;
				a = a - 1;
			}
		}
		return resultado;
	}
	
	public boolean primalidade(int a) {
		int i = 2;
		int variavel = 0;
		
		while (i < a) {
			if (a % i == 0) {
				variavel = variavel + 1;
			}
			i = i + 1;
		}
		
		if (variavel==0 && a!=1 && a!=0) {
			return true;
		} else {
			return false;
		}
	}

}