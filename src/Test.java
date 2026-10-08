public class Test {
    public static void main(String[] args) {

//        Priority p1 = Priority.HIGH;
//        Priority p2 = Priority.LOW;
//
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p1.name());
//
//        for (Priority p : Priority.values()) {
//            System.out.println(p);
//        }
//
//        Priority p3 = Priority.fromString("moyenne");
//        System.out.println(p3);
//
//        System.out.println(p1 == Priority.HIGH);
//
//        Priority p = Priority.URGENT;
//        Priority p = "HIGH";
//        Priority p = Priority.fromString("banane");
//
//        Task t1 = new Task("Réviser Java", "Chapitre sur les enum", Priority.HIGH);
//        t1.display();

//        Task t2 = new Task("", "Description", Priority.LOW);
//        try { // Code qui peut échouer
//            Task task = new Task("", "Description", Priority.HIGH); // Titre vide !
//        } catch (IllegalArgumentException e) {
//            System.out.println("Erreur : " + e.getMessage()); // Code exécuté si une erreur survient
//        }
//        TaskManager manager = new TaskManager();
//
//        manager.importTask(new String[]{"Réviser", "Les enum", "Haute"});
//        manager.importTask(new String[]{"", "Desc", "Haute"});
//        manager.importTask(new String[]{"Courses", "Pain", "INVALID"});
//        manager.importTask(new String[]{"Incomplet"});
//
//        manager.displayTasks();
//        TaskManager taskManager = new TaskManager();
//
//        System.out.println("=== Test données valides ===");
//        taskManager.importTasks(TaskTestData.getValidTasks());
//
//        System.out.println("=== Test données problématiques ===");
//        taskManager.importTasks(TaskTestData.getProblematicTasks());
//
//        System.out.println("=== Test grande liste ===");
//        taskManager.importTasks(TaskTestData.getLargeTaskSet());
//
//        taskManager.showStats();
//        MovieScheduler scheduler = new MovieScheduler();
//        scheduler.addMovie("Inception", new Slot("14h00", 148, "A"));
//        scheduler.addMovie("Matrix", new Slot("17h00", 136, "A"));
//        scheduler.addMovie("Alien", new Slot("14h30", 117, "B"));
//
//        scheduler.display();
//        scheduler.showStats();
//
//        try {
//            scheduler.addMovie("Avatar", new Slot("15h00", 120, "A"));
//        } catch (IllegalArgumentException e) {
//            System.out.println("Refusé : " + e.getMessage());
//        }
        MovieScheduler scheduler = new MovieScheduler();

//        System.out.println("=== Valide ===");
//        scheduler.importMovieSchedule(MovieSlotTestData.getValidMovieSchedule());
//        scheduler.display();

//        System.out.println("=== Problématique ===");
//        scheduler.importMovieSchedule(MovieSlotTestData.getProblematicMovieSchedule());
//        scheduler.display();

//        System.out.println("=== Données avec doublons ===");
//        scheduler.importMovieSchedule(MovieSlotTestData.getDuplicateMovieSchedule());
//        scheduler.display();

//        System.out.println("=== Données avec conflits de salles/horaires ===");
//        scheduler.importMovieSchedule(MovieSlotTestData.getConflictingSchedule());
//        scheduler.display();

//        System.out.println("=== Données avec valeurs invalides ===");
//        scheduler.importMovieSchedule(MovieSlotTestData.getInvalidMovieSchedule());
//        scheduler.display();

        scheduler.addMovie("Inception", new Slot("14h00", 148, "A"));   // 14h00 -> 16h28
        scheduler.addMovie("Alien", new Slot("14h30", 117, "B"));

        System.out.println(scheduler.hasMovieConflicts());
        System.out.println(scheduler.getMoviesByRoom("A"));
        System.out.println(scheduler.getMoviesByRoom("C"));
        System.out.println(scheduler.isRoomAvailable("A", "15h00", 60));
        System.out.println(scheduler.isRoomAvailable("A", "16h30", 60));
        System.out.println(scheduler.isRoomAvailable("C", "15h00", 60));



    }
}
