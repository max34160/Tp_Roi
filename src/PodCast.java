public class PodCast extends Media {
    private String host;
    private int episodeNumber;

    public PodCast(String title, String host, int year, double duration, int episodeNumber) {
        super(title, year, duration);
        this.host = host;
        this.episodeNumber = episodeNumber;
    }
    public void subscribe() { System.out.println("Abonné au podcast de " + this.host); }

    @Override
    public void play() { System.out.println("Playing podcast: " + this.title + " #" + this.episodeNumber); }

    @Override
    public void pause() { System.out.println("Podcast paused"); }

    @Override
    public String getMediaType() { return "Podcast"; }

    @Override
    public double getFileSize() { return this.duration * 1; }


}