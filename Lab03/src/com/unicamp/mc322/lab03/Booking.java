package com.unicamp.mc322.lab03;

public class Booking {
	
	public void criarReserva(User usuario, Hotel hotel, int numQuarto, int numDias) {
		Room[] rooms = new Room[hotel.getQuantidadeQuartos()];
		rooms = hotel.getQuartos();
		double novoSaldo = 0;
		double precoReserva = 0;
		precoReserva = hotel.obterPreco(numQuarto)*numDias;
		if (hotel.obterNumDisponiveis() != 0) {
			if (rooms[numQuarto].getOcupacao() == 0) {
				if (numQuarto < 10) {
					rooms[numQuarto].setVip(1);
				} else {
					rooms[numQuarto].setVip(0);
				}
				if (precoReserva <= usuario.getSaldoAtual()) {
					if (rooms[numQuarto].getFumante() == usuario.getFumante()) {
						rooms[numQuarto].setOcupacao(1);
						rooms[numQuarto].setUsuario(usuario);
						novoSaldo = usuario.getSaldoAtual() - precoReserva;
						usuario.setSaldoAtual(novoSaldo);
						System.out.println(usuario.getNome() + ": Reserva efetuada com sucesso.");
					} else if (usuario.getFumante() == 1) {
						System.out.println(usuario.getNome() + ": Esse quarto eh para nao fumante.");
					} else {
						System.out.println(usuario.getNome() + ": Esse quarto eh para fumante.");
					}
				} else {
					System.out.println(usuario.getNome() + ": O usuario tem saldo insuficiente.");
				}
			} else {
				System.out.println(usuario.getNome() + ": Quarto ocupado. Escolha outro.");
			}
		} else {
			System.out.println(usuario.getNome() + ": Hotel esta lotado.");
		}
	}
	
	public void cancelarReserva(User usuario, Hotel hotel, int numQuarto, int numDias) {
		Room[] rooms = new Room[hotel.getQuantidadeQuartos()];
		rooms = hotel.getQuartos();
		double novoSaldo = 0;
		if (numQuarto < 10) {
			rooms[numQuarto].setVip(1);
		} else {
			rooms[numQuarto].setVip(0);
		}
		if (rooms[numQuarto].getUsuario() == usuario) {
			rooms[numQuarto].setOcupacao(0);
			novoSaldo = usuario.getSaldoAtual() + 0.7*hotel.obterPreco(numQuarto)*numDias;
			usuario.setSaldoAtual(novoSaldo);
			System.out.println(usuario.getNome() + ": Cancelamento efetuado com sucesso.");
		} else {
			System.out.println(usuario.getNome() + ": Nao possui reserva nesse quarto.");
		}
		
	}
	
	public static void main(String[] args) {
		
		Booking booking = new Booking();
		
		Hotel hotel1 = new Hotel("Praia Tropical", "Rua Tajuba, 201 - Florianopolis, SC", "3225-8997", 100, 900, 100);
		Hotel hotel2 = new Hotel("Campo Florestal", "Rua Monteiro, 456 - Goiania, GO", "3654-8974", 50, 2000, 100);
		
		User usuario1 = new User("Roberci Silva", "784245698-21", "12/04/1996", "Masculino", 10000, 0);
		User usuario2 = new User("Marcela Domingues", "269784061-45", "22/07/1998", "Feminino", 200000, 1);
		User usuario3 = new User("Manuela Santos", "293029329-32", "13/04/2003", "Feminino", 40000, 0);
		
		Room quarto1 = new Room(0, 0, 0, 0, null);
		hotel1.adicionarQuarto(quarto1);
		Room quarto2 = new Room(0, 0, 1, 0, null);
		hotel1.adicionarQuarto(quarto2);
		Room quarto3 = new Room(0, 0, 0, 1, null);
		hotel1.adicionarQuarto(quarto3);
		Room quarto4 = new Room(0, 0, 1, 1, null);
		hotel1.adicionarQuarto(quarto4);
		Room quarto5 = new Room(1, 0, 0, 0, null);
		hotel1.adicionarQuarto(quarto5);
		Room quarto6 = new Room(1, 0, 1, 0, null);
		hotel1.adicionarQuarto(quarto6);
		Room quarto7 = new Room(1, 0, 0, 1, null);
		hotel1.adicionarQuarto(quarto7);
		Room quarto8 = new Room(1, 0, 1, 1, null);
		hotel1.adicionarQuarto(quarto8);
		
		
		Room quarto9 = new Room(1, 0, 1, 1, null);
		hotel2.adicionarQuarto(quarto9);
		Room quarto10 = new Room(1, 0, 0, 1, null);
		hotel2.adicionarQuarto(quarto10);
		Room quarto11 = new Room(1, 0, 1, 0, null);
		hotel2.adicionarQuarto(quarto11);
		Room quarto12 = new Room(1, 0, 0, 0, null);
		hotel2.adicionarQuarto(quarto12);
		Room quarto13 = new Room(0, 0, 1, 1, null);
		hotel2.adicionarQuarto(quarto13);
		Room quarto14 = new Room(0, 0, 0, 1, null);
		hotel2.adicionarQuarto(quarto14);
		Room quarto15 = new Room(0, 0, 1, 0, null);
		hotel2.adicionarQuarto(quarto15);
		Room quarto16 = new Room(0, 0, 0, 0, null);
		hotel2.adicionarQuarto(quarto16);
		
		usuario1.obterInformacoes();
		System.out.println();
		usuario2.obterInformacoes();
		System.out.println();		
		
		booking.criarReserva(usuario1, hotel1, 10, 4);
		System.out.println("Saldo atual do " + usuario1.getNome() + ": " + usuario1.getSaldoAtual());
		booking.criarReserva(usuario2, hotel2, 0, 4);
		System.out.println();
		booking.criarReserva(usuario2, hotel1, 10, 5);
		booking.criarReserva(usuario2, hotel2, 1, 10);
		hotel2.obterServicos(2);
		booking.criarReserva(usuario2, hotel2, 2, 10);
		booking.criarReserva(usuario2, hotel2, 12, 500);
		System.out.println();
		booking.criarReserva(usuario1, hotel1, 0, 1);
		hotel1.obterDisponivel();
		booking.criarReserva(usuario2, hotel1, 1, 1);
		booking.criarReserva(usuario1, hotel1, 2, 1);
		booking.criarReserva(usuario2, hotel1, 3, 1);
		hotel1.obterDisponivel();
		booking.criarReserva(usuario1, hotel1, 10, 1);
		booking.criarReserva(usuario2, hotel1, 11, 1);
		System.out.println();
		System.out.println("Saldo atual do " + usuario1.getNome() + ": " + usuario1.getSaldoAtual());
		booking.cancelarReserva(usuario1, hotel2, 0, 2);
		booking.cancelarReserva(usuario1, hotel1, 10, 4);
		System.out.println("Saldo atual do " + usuario1.getNome() + ": " + usuario1.getSaldoAtual());
		booking.criarReserva(usuario3, hotel1, 10, 2);
		hotel1.obterDisponivel();
		booking.criarReserva(usuario3, hotel1, 12, 2);
		booking.criarReserva(usuario2, hotel1, 13, 2);
		hotel1.obterDisponivel();
		booking.criarReserva(usuario1, hotel1, 12, 6);
	}

}