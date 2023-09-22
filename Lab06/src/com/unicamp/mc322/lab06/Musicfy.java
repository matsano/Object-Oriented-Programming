package com.unicamp.mc322.lab06;

public class Musicfy {

    public static void main(String[] args) {

        User user1 = new User("Marcos Paulo", "777.777.777-77", "21/03/2012", "Masculino", 0);
        User user2 = new User("Cookiezi", "111.111.11-11", "27/10/1987", "Feminino", 1);
        User user3 = new User("Leonardo Santos", "445.567.72-43", "06/01/1998", "Masculino", 0);

        Song song1 = new Song("Seven Nation Army", "The White Stripes", 120);
        Song song2 = new Song("Crazy Train", "Ozzy Osbourne", 180);
        Song song3 = new Song("Feels", "Calvin Harris", 68);
        Song song4 = new Song("Roar", "Katy Perry", 219);
        Song song5 = new Song("Happy", "The White Stripes", 180);
        Song song6 = new Song("New Year", "Pisadinha", 59);
        
        Video video1 = new Video("AULA 01 mc322", "Leonardo", 90, 100000, 100);
        Album album1 = new Album("Musicas boas");
        Album album2 = new Album("Musicas tranquilas");
        Podcast podcast1 = new Podcast("Flow", "Marcelo", 3600, 5);
        Podcast podcast2 = new Podcast("Papo curto", "Matheus", 45, 3);
        
        
        album1.adicionarMusica(song2);
        album1.adicionarMusica(song3);
        album1.adicionarMusica(song4);
        
        album2.adicionarMusica(song1);
        album2.adicionarMusica(song5);
        
        
        Playlist playlist1 = new Playlist("Para estudar", 200);
        Playlist playlist2 = new Playlist("Para relaxar", 500);
        Playlist playlist3 = new Playlist("Curta metragem", 500);
        
        user1.addPlaylist(playlist1);
        
        playlist1.adicionarEntretenimento(song1);
        playlist1.adicionarEntretenimento(video1);
        playlist1.adicionarEntretenimento(album1);
        playlist1.removerEntretenimento(video1);
        
        user1.addPlaylist(playlist2);
        playlist2.adicionarEntretenimento(song2);
        playlist2.adicionarEntretenimento(podcast1);
        
        user1.transferirPlaylist(playlist2, user2);
        playlist2.adicionarEntretenimento(podcast1);
        playlist2.adicionarEntretenimento(song1);
        playlist2.adicionarEntretenimento(song3);
        playlist2.adicionarEntretenimento(song4);
        
        user2.transferirPlaylist(playlist2, user3);
        user3.alterarAssinatura();
        user2.transferirPlaylist(playlist2, user3);
        
        user1.addPlaylist(playlist3);
        playlist3.adicionarEntretenimento(podcast2);
        playlist3.adicionarEntretenimento(song6);
        playlist3.adicionarEntretenimento(song1);
        
        System.out.println("Item de maior duracao na playlist 1 = "+ playlist1.obterItemMaiorDuracao());
        System.out.println("Item de menor duracao na playlist 1 = "+ playlist1.obterItemMenorDuracao());
        System.out.println("Duracao media playlist 1 = "+ playlist1.obterDuracaoMedia());
        System.out.println("Duracao total playlist 1 = "+ playlist1.obterDuracaoTotal());
        System.out.println();
        System.out.println("Item de maior duracao na playlist 2 = "+ playlist2.obterItemMaiorDuracao());
        System.out.println("Item de menor duracao na playlist 2 = "+ playlist2.obterItemMenorDuracao());
        System.out.println("Duracao media playlist 2 = "+ playlist2.obterDuracaoMedia());
        System.out.println("Duracao total playlist 2 = "+ playlist2.obterDuracaoTotal());
        
        playlist2.play(false);
        System.out.println("Entretenimento atual playlist 2: " + playlist2.getEntretenimentoAtual());
        playlist2.play(true);
        System.out.println("Entretenimento atual playlist 2: " + playlist2.getEntretenimentoAtual());
        
        user3.alterarAssinatura();
        
    }
}