public class Song extends Media {
    protected String album;
    protected String artist;

    public Song(String title, String artist,int year   ,double duration,String album ) {
        super(title,year ,duration);
        this.album = album;
        this.artist = artist ;

    }
    public void showLyrics() {
        System.out.println("Displaying lyrics for " +this.title);
    }

    @Override
    public void play() {
        System.out.println("Playing song: " +this.title);
    }

    @Override
    public void pause() {
        System.out.println("Song paused");
    }

    @Override
    public String getMediaType() {
        return "Song";
    }

    @Override
    public double getFileSize() {
        return this.duration * 4;
    }
}
