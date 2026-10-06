public class Task {
    private String title;
    private String description;
    private Priority priority;

    public Task(String title, String description, Priority priority) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre ne peut pas être null ou vide");
        }
        if (description == null) {
            throw new IllegalArgumentException("La description ne peut pas être null");
        }
        if (priority == null) {
            throw new IllegalArgumentException("La priorité ne peut pas être null");
        }

        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void display() {
        System.out.println("[" + this.priority + "] " + this.title + " : " + this.description);
    }

    public String getTitle(){
        return this.title;
    }
    public Priority getPriority(){
        return this.priority;
    }
}
