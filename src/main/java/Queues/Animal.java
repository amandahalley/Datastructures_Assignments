package Queues;

//animal abstract class represents an animal in the shelter
public abstract class Animal {
    private String name;
    private int order;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}

//dog and cat class extends animal inheriting the properties
class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }
}




