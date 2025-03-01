package MidtermSprint;

import java.util.Scanner;

public class Main {
    private static User[] users = new User[5]; //size of users allowed
    private static int userCount = 0; // number of users

    //add a new user
    public static void addUser(String name) {
        if (userCount >= users.length) {
            System.out.println("User limit reached.");
            return;
        }
        users[userCount++] = new User(name);
        System.out.println("User " + name + " added.");
    }

    //find user by name
    public static User getUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].name.equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nTo-Do List Manager");
            System.out.println("1. Add User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: //add user
                    System.out.print("Enter username: ");
                    String userName = scanner.nextLine();
                    addUser(userName);
                    break;

                case 2: //add task
                    System.out.print("Enter username: ");
                    String userForTask = scanner.nextLine();
                    User user = getUser(userForTask);
                    if (user == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    user.addTask(taskDescription);
                    break;

                case 3: //mark task as completed
                    System.out.print("Enter username: ");
                    String userForCompletion = scanner.nextLine();
                    User userToComplete = getUser(userForCompletion);
                    if (userToComplete == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    System.out.print("Enter task index to mark as complete: ");
                    int taskIndex = scanner.nextInt();
                    userToComplete.markAsCompleted(taskIndex);
                    break;

                case 4: //view tasks
                    System.out.print("Enter username: ");
                    String userForView = scanner.nextLine();
                    User userToView = getUser(userForView);
                    if (userToView == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    userToView.printTasks();
                    break;

                case 5: //exit program
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

