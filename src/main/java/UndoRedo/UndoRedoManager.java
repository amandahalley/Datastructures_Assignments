package UndoRedo;

/**
 * Implememt an application that support undo/redo functionality. Use a linked list to maintain a sequence of states.\
 * Each state change is stored as a node in the list, allowoing for easy navigation
 * 1<>2<>3<>4<>5
 */

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;

        private Node(T state) {
            this.state = state;
        }

    }

    private Node currentState;
    private int size;

    //Undo operation
    public T undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("Nothing to undo");
            return null;
        }
        currentState = currentState.prev; //move to previous state
        return currentState.state;
    }

    //perform an operation
    public void addState(T newState) {
        //remove all states if current isnt last
        if (currentState != null && currentState.next != null) {
            currentState.next = null;
        }
        Node newNode = new Node(newState);
        //first state if list is empty
        if (currentState == null) {
            currentState = newNode;
        } else {
            currentState.next = newNode; //add new state after current
            newNode.prev = currentState;
            currentState = newNode; //set new state as current
        }
        size++;
    }

    //Redo operation
    public T redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("Nothing to redo.");
            return null;
        }
        currentState = currentState.next; // Move to next state
        return currentState.state;
    }

    //test
    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        System.out.println("\nAdding...");
        manager.addState("1");
        manager.addState("2");
        manager.addState("3");
        manager.addState("4");
        manager.addState("5");

        //print current state after additions
        System.out.println("Current State: " + manager.currentState.state);

        // Undo testing
        System.out.println("\nPerforming undo operation:");
        System.out.println("*Undo* Current State: " + manager.undo()); //4
        System.out.println("*Undo* Current State: " + manager.undo()); //3
        System.out.println("*Undo* Current State: " + manager.undo()); //2
        System.out.println("*Undo* Current State: " + manager.undo()); //1
        System.out.println("*Undo* " + manager.undo()); //list does not exist

        //redo testing
        System.out.println("\nPerforming redo operation:");
        System.out.println("*Redo* Current State: " + manager.redo()); //2
        System.out.println("*Redo* Current State: " + manager.redo()); //3
        System.out.println("*Redo* Current State: " + manager.redo()); //4
        System.out.println("*Redo* Current State: " + manager.redo()); //5
        System.out.println("*Redo* " + manager.redo()); //nothing to redo

        //undo redo undo
        System.out.println("\nPerforming undo, redo, undo:");
        System.out.println("*Undo* Current State: " + manager.undo()); //4
        System.out.println("*Redo* Current State: " + manager.redo()); //5
        System.out.println("*Undo* Current State: " + manager.undo()); //4

    }
}




