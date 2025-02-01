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
        private Node (T state) {
            this.state = state;
        }

    }
    private Node currentState;

    //Undo operation
    public T undo(){
        if (currentState == null || currentState.prev == null) {
            System.out.println("List does not exist");
            return null;
        }
        currentState = currentState.prev; //move to previous state
        return currentState.state;
    }

    //perform an operation
    public void  addState (T newState) {
        //implement me

    }

    //Redo Operation
    public T redo(){
        //implement me
    }


    //add to list
    public void addState(T newState) {

    }


    //test
    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();



    }
}