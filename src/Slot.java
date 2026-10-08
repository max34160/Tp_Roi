import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Slot {
    private Date startTime;
    private double duration;
    private String room;

    public Slot(String  startTime, double duration, String room) {
        if ( room == null || room.trim().isEmpty()) {
            throw new IllegalArgumentException("La room ne peut pas être null ou vide");
        }
        if (duration <= 0 ) {
            throw new IllegalArgumentException("La duree ne peut pas être plus petite ou egale a 0");
        }
        if (startTime == null || startTime.trim().isEmpty()) {
            throw new IllegalArgumentException("L'heure de début ne peut pas être null ou vide");
        }

        try {
            SimpleDateFormat format = new SimpleDateFormat("HH'h'mm");
            format.setLenient(false);
            this.startTime = format.parse(startTime);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Format d'heure invalide : " + startTime);
        }

        this.duration = duration;
        this.room = room;
    }

    public Date getEndTime(){
        return new Date(this.startTime.getTime() + (long) (this.duration * 60 * 1000));
    }
    public void display(){
        SimpleDateFormat format = new SimpleDateFormat("HH'h'mm");
        System.out.println("Salle" + this.room +" duree : " + this.duration + "  début : " + format.format(this.startTime)+ "  fin : " + format.format(getEndTime()));
    }

    public boolean hasTimeConflict(Slot other){
        if(!this.room.equals(other.room))  return false;
//        if(this.startTime.before(other.getEndTime()) && other.startTime.before(this.getEndTime())) return true;
//        return false;
        return this.startTime.before(other.getEndTime()) && other.startTime.before(this.getEndTime());
    }

    public double getDuration(){
        return this.duration;
    }

    public String getRoom(){
        return this.room ;
    }
}
