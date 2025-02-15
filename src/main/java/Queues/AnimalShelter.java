package Queues;


import java.util.LinkedList;
import java.util.Queue;

//created queues for storing dogs and cats
public class AnimalShelter {
    private Animal[] arr;
    private int frontOfQueue;
    private int backOfQueue;
    private int nItems;
    private int order;

    public AnimalShelter(int size) {
        this.arr = new Animal[size];
        this.frontOfQueue = -1;
        this.backOfQueue = -1;
        this.nItems = 0;
        this.order = 0;
        System.out.println("Animal Shelter created with size of  " + size);

    }

    //isFUll
    public boolean isFull(){
        if (backOfQueue == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    //isEmpty
    public boolean isEmpty(){

        return (nItems == 0);
    }

    //enqueue a dog into the shelter
   public void enqueueDog(Dog dog) {
        if (isFull()) {
            System.out.println("Animal shelter is full.");
        } else if (isEmpty()) {
            frontOfQueue = 0;
            backOfQueue++;
            dog.setOrder(order++);
            arr[backOfQueue] = dog;
            System.out.println();
            System.out.println("Dog " + dog.getName() + " added to Animal Shelter");
        } else {
            backOfQueue++;
            nItems++;
            dog.setOrder(order++);
            arr[backOfQueue] = dog;
            System.out.println("Dog" + dog.getName() + " added to Animal Shelte");
        }
   }

    //enqueue a cat into the shelter
    public void enqueueCat(Cat cat) {
        if (isFull()) {
            System.out.println("Animal shelter is full.");
        } else if (isEmpty()) {
            frontOfQueue = 0;
            backOfQueue++;
            cat.setOrder(order++);
            arr[backOfQueue] = cat;
            System.out.println();
            System.out.println("Cat " + cat.getName() + " added to Animal Shelter");
        } else {
            backOfQueue++;
            nItems++;
            cat.setOrder(order++);
            arr[backOfQueue] = cat;
            System.out.println("Cat" + cat.getName() + " added to Animal Shelte");
        }
    }

}

