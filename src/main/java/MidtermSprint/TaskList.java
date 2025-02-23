package MidtermSprint;

public class TaskList {
    private class TaskEntry {
        Task task;
        TaskEntry next;

        public TaskEntry(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private TaskEntry firstTask;

    //adding a new task
    public void addTask(String description) {
        Task newTask = new Task(description);
        TaskEntry newTaskEntry = new TaskEntry(newTask);

        //sets head of list if empty
        if (firstTask == null) {
            firstTask = newTaskEntry;
            //starts from head and moves through list, adds new task at the end
        } else {
            TaskEntry current = firstTask;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTaskEntry;

        }
    }

    //marking task as complete
    public boolean markAsComplete(int index) {
        //check if list is emptpy
        if (firstTask == null) {
            System.out.println("You have no tasks available.");
            return false;
        }

        //set current task and counter
        TaskEntry current = firstTask;
        int count = 0;

        //loop through list to find task at given index and mark task complete
        while (current != null) {
            if (count == index) {
                current.task.markedComplete();
                return true;
            }
            //moves to next task in the list
            current = current.next;
            count++;
        }
        //error message if task isnt found
        System.out.println("Task not found.");
        return false;
    }

    //print all tasks
    public void printTasks() {
        //check if list is empty
        if (firstTask == null) {
            System.out.println("There are no tasks available.");
            return;
        }
        //set current task and counter
        TaskEntry current = firstTask;
        int index = 0;

        //loop through list printing each task + index
        while (current != null) {
            System.out.println(index + ". " + current.task);
            //move to next task in list and increment the index
            current = current.next;
            index++;
        }
    }
}
