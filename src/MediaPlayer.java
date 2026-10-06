import java.util.ArrayList;

class MediaPlayer {
    private ArrayList<Media> playlist;
    private int currentIndex;
    private int mediaCount;
    private int capacity;

    public MediaPlayer(int capacity) {
        this.playlist = new ArrayList<Media>(capacity);
        this.currentIndex = 0;
        this.mediaCount = 0;
        this.capacity = capacity;
    }
    public void addMedia(Media media) {
        // Ajouter si place disponible
        if(this.mediaCount < this.capacity){
            this.playlist.add(media);
            this.mediaCount++;
        }else{
            System.out.println("Maximum capacity reached");
        }
    }
    public void playAll() {
// Jouer tous les medias (polymorphisme !)
        for(Media m :playlist) m.play();
    }
    public void displayPlaylist() {
// Afficher tous les medias avec leurs infos
        for(Media m :playlist) m.displayInfo();
    }
    public double getTotalSize() {
// Calculer la taille totale de tous les medias
        double totalSize = 0;
        for(Media m : playlist) totalSize += m.getFileSize() ;
        return totalSize;
    }
    public Media[] getMediaByType(String type) {
// Retourner tous les medias d'un type donné
        ArrayList<Media> result = new ArrayList<Media>();
        for(Media m : playlist){
            if(m.getMediaType().equals(type)) result.add(m);
        }
        return result.toArray(new Media[0]);
    }
    public ArrayList<Media> getRecentMedia(int year) {
        ArrayList<Media> result = new ArrayList<Media>();
        for (Media m : playlist){
            if (m.getYear() > year) result.add(m);
        }
        return result;
    }

    public ArrayList<Media> getLargeMedia(double sizeLimit) {
        ArrayList<Media> result = new ArrayList<>();
        for (Media m : playlist) if (m.getFileSize() > sizeLimit) result.add(m);
        return result;
    }

    public double getTotalDuration() { // en heures
        double total = 0;
        for (Media m : playlist) total += m.getDuration();
        return total / 60;
    }
}