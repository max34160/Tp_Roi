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
//        //Priority p = Priority.URGENT;
//        //Priority p = "HIGH";
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
        TaskManager manager = new TaskManager();

        manager.importTask(new String[]{"Réviser", "Les enum", "Haute"});
        manager.importTask(new String[]{"", "Desc", "Haute"});
        manager.importTask(new String[]{"Courses", "Pain", "INVALID"});
        manager.importTask(new String[]{"Incomplet"});

        manager.displayTasks();

    }
}
