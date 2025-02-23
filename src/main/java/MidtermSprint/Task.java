package MidtermSprint;

public class Task {
    String description;
    Boolean isCompleted;

    //constructor - task set to not complete
    public Task(String description){
        this.description = description;
        this.isCompleted = false;
    }

    //for marking task as complete
    public void markedComplete() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return description + " - " + (isCompleted ? " Completed" : "Incomplete");
    }
}

