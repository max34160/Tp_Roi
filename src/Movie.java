public class Movie extends Media {
    protected String genre;
    protected String director;
    protected String producer;

    public Movie(String title,String director  , int year ,double duration, String genre, String producer) {
        super(title,year ,duration);
        this.genre = genre;
        this.director = director ;
        this.producer = producer;

    }
    public void showCredits() {
        System.out.println("Producer : " +this.director);
        System.out.println("Director : " + this.producer);
    }

    @Override
    public void play() {
        System.out.println("Playing movie: " +this.title);
    }

    @Override
    public void pause() {
        System.out.println("Movie paused");
    }

    @Override
    public String getMediaType() {
        return "Movie";
    }

    @Override
    public double getFileSize() {
        return this.duration * 10;
    }
}
