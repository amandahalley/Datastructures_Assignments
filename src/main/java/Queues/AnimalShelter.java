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

    //add a dog into the shelter
    public void enqueueDog(Dog dog) {
        if (isFull()) {
            System.out.println("Animal shelter is full.");
        } else {
            if (isEmpty()) {
                frontOfQueue = 0;
            }
            backOfQueue++;
            dog.setOrder(order++);
            arr[backOfQueue] = dog;
            nItems++;
            System.out.println("Dog " + dog.getName() + " added to Animal Shelter");
        }
    }

    //add a cat into the shelter
    public void enqueueCat(Cat cat) {
        if (isFull()) {
            System.out.println("Animal shelter is full.");
        } else {
            if (isEmpty()) {
                frontOfQueue = 0;
            }
            backOfQueue++;
            cat.setOrder(order++);
            arr[backOfQueue] = cat;
            nItems++;
            System.out.println("Cat " + cat.getName() + " added to Animal Shelter");
        }
    }

    //adopt oldest dog from shelter
    public Dog dequeueDog() {
        Dog result = null;
        if (isEmpty()) {
            System.out.println("The shelter is empty.");
        } else {
            for (int i = frontOfQueue; i <= backOfQueue; i++) {
                if (arr[i] instanceof Dog) {
                    result = (Dog) arr[i];
                    frontOfQueue++;

                    if (frontOfQueue > backOfQueue) {
                        frontOfQueue = backOfQueue = -1;
                    }
                    nItems--;
                    System.out.println("dog" + result.getName() + "is adopted!");
                    break;
                }
            }
        }
        return result;
    }

    //adopt oldest cat from shelter
    public Cat dequeueCat() {
        Cat result = null;
        if (isEmpty()) {
            System.out.println("The shelter is empty.");
        } else {
            for (int i = frontOfQueue; i <= backOfQueue; i++) {
                if (arr[i] instanceof Cat) {
                    result = (Cat) arr[i];
                    frontOfQueue++;
                    if (frontOfQueue > backOfQueue) {
                        frontOfQueue = backOfQueue = -1;
                    }
                    nItems--;
                    System.out.println("cat" + result.getName() + "is adopted!");
                    break;
                }
            }
        }
        return result;
    }

    //adopt any animal from shelter (oldest)
    public Animal dequeueAny() {
        Animal result = null;
        if(isEmpty()) {
            System.out.println("The shelter is empty");
        } else {
            result = arr[frontOfQueue];
            frontOfQueue++;
            if (frontOfQueue > backOfQueue) {
                frontOfQueue = backOfQueue = -1;
            }
            nItems--;
            System.out.println(result.getName() + "is adopted!");
        }
        return result;
    }
}

