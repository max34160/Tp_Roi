import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager(){  this.tasks = new ArrayList<Task>(); }

    public void addTask(Task task) {
        if(task == null){
            throw new IllegalArgumentException("La tâche ne peut pas être null");
        }else {
            this.tasks.add(task);
        }
    }

    public boolean removeTask(String title){
        for(Task t : this.tasks){
            if(t.getTitle().equalsIgnoreCase(title)){
                this.tasks.remove(t);
                return true;
            }
        }
        return false;
    }

    public void displayTasks(){
        if (this.tasks.isEmpty()) {
            System.out.println("Aucune tâche.");
        }else{
            for(Task t : this.tasks){
                t.display();
            }
        }
    }
    public ArrayList<Task> findByTitle(String title){
        ArrayList<Task> result = new ArrayList<Task>();
        for(Task t : this.tasks) {
            if(t.getTitle().equalsIgnoreCase(title)) result.add(t);
        }
        return result;
    }

    public ArrayList<Task> findByPriority(Priority priority){
        ArrayList<Task> result = new ArrayList<Task>();
        for(Task t : this.tasks) {
            if(t.getPriority() == priority) result.add(t);
        }
        return result;
    }

    public void showStats() {
        System.out.println("Nombre de tâches : " + tasks.size());
        for (Priority p : Priority.values()) {
            int count = findByPriority(p).size();
            System.out.println("  " + p + " : " + count);
        }
    }

    public boolean importTask(String[] taskData) {
        try {
            String title = taskData[0];
            String description = taskData[1];
            Priority priority = Priority.fromString(taskData[2]);

            Task task = new Task(title, description, priority);
            addTask(task);

            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Tâche non importée : " + e.getMessage());
            return false;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Tâche non importée : Data mal formatée");
            return false;
        }
    }
}
