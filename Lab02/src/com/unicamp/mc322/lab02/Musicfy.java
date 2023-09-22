package com.unicamp.mc322.lab02;

public class Musicfy {

    public static void main(String[] args) {

        User user1 = new User("Marcos Paulo", "777.777.777-77", "21/03/2012", "Masculino", 0);
        User user2 = new User("Cookiezi", "111.111.11-11", "27/10/1987", "Feminino", 1);
        User user3 = new User("Leonardo Santos", "445.567.72-43", "06/01/1998", "Masculino", 0);

        Song song1 = new Song("Seven Nation Army", "Rock", "The White Stripes", 120);
        Song song2 = new Song("Crazy Train", "Rock", "Ozzy Osbourne", 180);
        Song song3 = new Song("Feels", "Pop", "Calvin Harris", 68);
        Song song4 = new Song("Roar", "Pop", "Katy Perry", 219);
        Song song5 = new Song("Anima", "Hardcore", "Xi", 89);
        Song song6 = new Song("Freedom Dive", "Hardcore", "Xi", 147);
        Song song7 = new Song("Teo", "Hardcore", "Omoi", 65);
        Song song8 = new Song("Sleepwalking", "Metalcore", "Bring Me The Horizon", 141);

        Playlist rockPlaylist = new Playlist("Awesome Rock Songs", "Rock");
        rockPlaylist.addSong(song1);
        rockPlaylist.addSong(song2);
        rockPlaylist.addSong(song8);

        Playlist osuPlaylist = new Playlist("Osu Memories", "hardcore");
        osuPlaylist.addSong(song5);
        osuPlaylist.addSong(song6);
        osuPlaylist.addSong(song7);
        osuPlaylist.removeSong(song5);

        Playlist metalcorePlaylist = new Playlist("Best of Metalcore", "Metalcore");
        metalcorePlaylist.addSong(song8);
        metalcorePlaylist.addSong(song3);
        
        Playlist popPlaylist = new Playlist("Top Pop Musics", "Pop");
        popPlaylist.addSong(song3);
        popPlaylist.addSong(song4);
        
        Playlist toRelaxPlaylist = new Playlist("Time to Sleep", "Hardcore");
        toRelaxPlaylist.addSong(song7);
        toRelaxPlaylist.addSong(song5);
        toRelaxPlaylist.addSong(song6);
        

        user1.addPlaylist(rockPlaylist);
        user1.addPlaylist(osuPlaylist);
        user1.addPlaylist(metalcorePlaylist);
        user1.removePlaylist(osuPlaylist);
        user1.alterarAssinatura();
        user1.addPlaylist(popPlaylist);
        user1.addPlaylist(toRelaxPlaylist);
        
        user2.addPlaylist(osuPlaylist);
        user2.transferirPlaylist(osuPlaylist, user3);
        
        user3.addPlaylist(popPlaylist);
        user3.addPlaylist(rockPlaylist);

        user1.showInformation();
        System.out.println("");
        user1.showPlaylists();
        System.out.println("");
        System.out.println("");
        
        user2.showInformation();
        System.out.println("");
        user2.showPlaylists();
        System.out.println("");
        System.out.println("");
        
        user3.showInformation();
        System.out.println("");
        user3.showPlaylists();
        System.out.println("");
        System.out.println("");

        rockPlaylist.play(false);
        rockPlaylist.play(false);
        osuPlaylist.play(true);
    }
}