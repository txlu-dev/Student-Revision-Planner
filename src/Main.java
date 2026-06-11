import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    	// Create scanner and task list
        Scanner scanner = new Scanner(System.in);
        ArrayList<RevisionTask> tasks = new ArrayList<>();

        int choice;

        do {
        	// Display menu
            System.out.println("\n=== Revision Planner ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            
            
            // Read user's choice
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
            
            	// Add a new task
                case 1:
                    System.out.print("Enter task: ");
                    String title = scanner.nextLine();

                    tasks.add(new RevisionTask(title));

                    System.out.println("Task added.");
                    break;
                    
                // Display all tasks
                case 2:
                    System.out.println("\nTasks:");
                    
                    //Check if tasks are empty
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks."); } 
                        
                    else {
                        for (int i = 0; i < tasks.size(); i++) {
                        	
                        	// Check if task is completed
                        	if (tasks.get(i).getComplete()) {
                        		System.out.println((i + 1) + ". "+"[X] "
                                        + tasks.get(i).getTitle());}
                        	else {
                        		System.out.println((i + 1) + ". "+"[ ] "
                                        + tasks.get(i).getTitle());}
                        }
                    }
                    
                   
                    break;
                    
                    
                    
                case 3:
                    System.out.println("\nTasks:");
                    
                    //Check if tasks are empty
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks."); } 
                        
                    else {
                        for (int i = 0; i < tasks.size(); i++) {
                        	
                        	// Check if task is completed
                        	if (tasks.get(i).getComplete()) {
                        		System.out.println((i + 1) + ". "+"[X] "
                                        + tasks.get(i).getTitle());}
                        	else {
                        		System.out.println((i + 1) + ". "+"[ ] "
                                        + tasks.get(i).getTitle());}
                        }
                    }
                    
                    System.out.print("Enter task number: ");
                    int taskNum = scanner.nextInt();
                    scanner.nextLine();
                    
                    tasks.get(taskNum - 1).markComplete();
                    
                   
                    break;                    
                   
                    
                // Exit
                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        scanner.close();
    }
}