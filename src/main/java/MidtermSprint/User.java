package MidtermSprint;

class User {
    String name;
    TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public void addTask(String taskDescription) {
        taskList.addTask(taskDescription);
        System.out.println("Task added for " + name + ": " + taskDescription);
    }

    public void markAsCompleted(int index) {
        if (taskList.markAsComplete(index)) {
            System.out.println("Task " + index + " marked as completed for " + name);
        } else {
            System.out.println("Invalid task index for " + name);
        }
    }

    public void printTasks() {
        System.out.println("\nTasks for " + name + ":");
        taskList.printTasks();
    }
}

