import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MovieScheduler {
    private HashMap<String, Slot> schedule;

    public MovieScheduler() {
        this.schedule = new HashMap<String, Slot>();
    }

    public void addMovie(String title, Slot slot) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre ne peut pas être null ou vide");
        }
        if (slot == null) {
            throw new IllegalArgumentException("Le créneau ne peut pas être null");
        }
        if (this.schedule.containsKey(title)) {
            throw new IllegalArgumentException("Le film existe déjà : " + title);
        }
        for (Map.Entry<String, Slot> entry : this.schedule.entrySet()) {
            if (slot.hasTimeConflict(entry.getValue())) {
                throw new IllegalArgumentException("Conflit horaire avec le film : " + entry.getKey());
            }
        }
        this.schedule.put(title, slot);
    }

    public boolean removeMovie(String title) {
        return this.schedule.remove(title) != null;
    }

    public Slot getMovieSlot(String title) {
        return this.schedule.get(title);
    }

    public void updateMovieSlot(String title, Slot newSlot) {
        if (!this.schedule.containsKey(title)) {
            throw new IllegalArgumentException("Film introuvable : " + title);
        }
        if (newSlot == null) {
            throw new IllegalArgumentException("Le créneau ne peut pas être null");
        }
        for (Map.Entry<String, Slot> entry : this.schedule.entrySet()) {
            if (!entry.getKey().equals(title) && newSlot.hasTimeConflict(entry.getValue())) {
                throw new IllegalArgumentException("Conflit horaire avec le film : " + entry.getKey());
            }
        }
        this.schedule.put(title, newSlot);
    }

    public void display() {
        if (schedule.isEmpty()) {
            System.out.println("Aucun film programmé.");
            return;
        }
        for (Map.Entry<String, Slot> entry : schedule.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            entry.getValue().display();
        }
    }

    public void showStats() {
        double totalDuration = 0;
        HashMap<String, Integer> moviesPerRoom = new HashMap<String, Integer>();

        for (Slot slot : this.schedule.values()) {
            totalDuration += slot.getDuration();
            moviesPerRoom.put(slot.getRoom(), moviesPerRoom.getOrDefault(slot.getRoom(), 0) + 1);
        }

        System.out.println("Nombre de films : " + this.schedule.size());
        System.out.println("Durée totale : " + totalDuration + " min");
        for (Map.Entry<String, Integer> entry : moviesPerRoom.entrySet()) {
            System.out.println("  Salle " + entry.getKey() + " : " + entry.getValue() + " film(s)");
        }

    }

    private void importMovie(String[] movieData) {
        String title = movieData[0];
        String startTime = movieData[1];
        double duration = Double.parseDouble(movieData[2]);
        String room = movieData[3];

        Slot slot = new Slot(startTime, duration, room);
        addMovie(title, slot);
    }

    public void importMovieSchedule(String[][] movies) {
        HashMap<String, Slot> backup = new HashMap<>(this.schedule);

        try {
            for (String[] movieData : movies) {
                importMovie(movieData);
            }
            System.out.println("Import réussi : " + movies.length + " film(s) ajouté(s)");

        } catch (IllegalArgumentException e) {
            this.schedule.clear();
            this.schedule.putAll(backup);
            System.out.println("Import annulé : " + e.getMessage());

        } catch (IndexOutOfBoundsException e) {
            schedule.clear();
            schedule.putAll(backup);
            System.out.println("Import annulé : données mal formatées");

        }
    }

    public boolean hasMovieConflicts() {
        ArrayList<Slot> slots = new ArrayList<>(schedule.values());

        for (int i = 0; i < slots.size(); i++) {
            for (int j = i + 1; j < slots.size(); j++) {
                if (slots.get(i).hasTimeConflict(slots.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
    public ArrayList<String> getMoviesByRoom(String room) {
        ArrayList<String> result = new ArrayList<>();

        for (Map.Entry<String, Slot> entry : schedule.entrySet()) {
            if (entry.getValue().getRoom().equals(room)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public boolean isRoomAvailable(String room, String startTime, double duration) {
        Slot candidate = new Slot(startTime, duration, room);

        for (Slot existing : schedule.values()) {
            if (candidate.hasTimeConflict(existing)) {
                return false;
            }
        }
        return true;
    }
}
