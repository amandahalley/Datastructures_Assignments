package Queues;

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
        System.out.println("Animal Shelter created with max capacity of: " + size);

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
            System.out.println("The Animal shelter is currently full.");
        } else {
            if (isEmpty()) {
                frontOfQueue = 0;
            }
            backOfQueue++;
            dog.setOrder(order++);
            arr[backOfQueue] = dog;
            nItems++;
            System.out.println("Dog: " + dog.getName() + " has been added to the Animal Shelter");
        }
    }

    //add a cat into the shelter
    public void enqueueCat(Cat cat) {
        if (isFull()) {
            System.out.println("The Animal shelter is currently full.");
        } else {
            if (isEmpty()) {
                frontOfQueue = 0;
            }
            backOfQueue++;
            cat.setOrder(order++);
            arr[backOfQueue] = cat;
            nItems++;
            System.out.println("Cat: " + cat.getName() + " has been added to the Animal Shelter!");
        }
    }

    //adopt oldest dog from shelter
    public Dog dequeueDog() {
        Dog result = null;
        if (isEmpty()) {
            System.out.println("The Animal Shelter is currently empty.");
        } else {
            for (int i = frontOfQueue; i <= backOfQueue; i++) {
                if (arr[i] instanceof Dog) {
                    result = (Dog) arr[i];
                    frontOfQueue++;

                    if (frontOfQueue > backOfQueue) {
                        frontOfQueue = backOfQueue = -1;
                    }
                    nItems--;
                    System.out.println("You've adopted dog: " + result.getName() + "!");
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
            System.out.println("The Animal Shelter is empty.");
        } else {
            for (int i = frontOfQueue; i <= backOfQueue; i++) {
                if (arr[i] instanceof Cat) {
                    result = (Cat) arr[i];
                    frontOfQueue++;
                    if (frontOfQueue > backOfQueue) {
                        frontOfQueue = backOfQueue = -1;
                    }
                    nItems--;
                    System.out.println("You've adopted cat:" + result.getName() + "!");
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
            System.out.println("The Animal Shelter is empty");
        } else {
            result = arr[frontOfQueue];
            frontOfQueue++;
            if (frontOfQueue > backOfQueue) {
                frontOfQueue = backOfQueue = -1;
            }
            nItems--;
            System.out.println("You've adopted: " + result.getName() + "!");
        }
        return result;
    }
}

