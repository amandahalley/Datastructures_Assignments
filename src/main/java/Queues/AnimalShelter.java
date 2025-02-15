package Queues;

import java.util.LinkedList;
import java.util.Queue;

//created queues for storing dogs and cats
public class AnimalShelter {
    private Queue<Cat> cats;
    private Queue<Dog> dogs;

    //linked list queues for dogs/cats
    public AnimalShelter() {
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
    }
}
