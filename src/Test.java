public class Test {
    public static void main(String[] args) {
        // Exemple d'utilisation attendu
//        Item smartphone = new Item("iPhone", 800.0, 0.20);
//        System.out.println(smartphone.getTotalPrice()); // 960.0
//        smartphone.applyDiscount(10.0); // 10% de remise
//        System.out.println(smartphone.getTotalPrice()); // 864.0
        MediaPlayer player = new MediaPlayer(10);
        Movie avatar = new Movie("Avatar", "James Cameron", 2009, 162, "Sci-Fi", "James Cameron");
        Movie inception = new Movie("Inception", "Christopher Nolan", 2010, 148, "Thriller", "Christopher Nolan");
        Song bohemian = new Song("Bohemian Rhapsody", "Queen", 1975, 6, "A Night at the Opera");
        Song thriller = new Song("Thriller", "Michael Jackson", 1982, 5.5, "Thriller");
        Song imagine = new Song("Imagine", "John Lennon", 1971, 3, "Imagine");

        player.addMedia(avatar);
        player.addMedia(inception);
        player.addMedia(bohemian);
        player.addMedia(thriller);
        player.addMedia(imagine);

        player.displayPlaylist();
        player.playAll();
        System.out.println("Taille totale : " + player.getTotalSize() + " MB");
        System.out.println("Films : " + player.getMediaByType("Movie").length);
        System.out.println("Après 2000 : " + player.getRecentMedia(2000).size());
        System.out.println("> 100 MB : " + player.getLargeMedia(100).size());
        System.out.println("Durée totale : " + player.getTotalDuration() + " h");

        avatar.showCredits();
        bohemian.showLyrics();
    }
}