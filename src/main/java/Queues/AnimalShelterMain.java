package Queues;

import java.util.Scanner;

public class AnimalShelterMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalShelter shelter = new AnimalShelter(10);

        //for testing
        Dog dog1 = new Dog("Dog1");
        Dog dog2 = new Dog("Dog2");
        Cat cat1 = new Cat("Cat1");
        Cat cat2 = new Cat("Cat2");

        shelter.enqueueDog(dog1);
        shelter.enqueueDog(dog2);
        shelter.enqueueCat(cat1);
        shelter.enqueueCat(cat2);

        int choice;
        do {
            //create menu
            System.out.println("\nAnimal Shelter Menu:");
            System.out.println("1. Add a Dog to Shelter");
            System.out.println("2. Add a Cat to Shelter");
            System.out.println("3. Adopt a Dog");
            System.out.println("4. Adopt a Cat");
            System.out.println("5. Adopt Any Animal");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");


            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    boolean addDogs = true;
                    while (addDogs) {
                        System.out.print("Enter the dogs name: ");
                        String dogName = scanner.nextLine();
                        shelter.enqueueDog(new Dog(dogName));

                        System.out.print("Do you want to add another dog? (y/n): ");
                        String addAnother = scanner.nextLine();
                        if (!addAnother.equalsIgnoreCase("y")) {
                            addDogs = false;
                        }
                    }
                    break;
                case 2:
                    boolean addCats = true;
                    while (addCats) {
                        System.out.print("Enter the cats name: ");
                        String catName = scanner.nextLine();
                        shelter.enqueueCat(new Cat(catName));

                        System.out.print("Do you want to add another cat? (y/n): ");
                        String addAnother = scanner.nextLine();
                        if (!addAnother.equalsIgnoreCase("y")) {
                            addCats = false;
                        }
                    }
                case 3:
                    shelter.dequeueDog();
                    System.out.println("Press Enter to return to menu.");
                    scanner.nextLine();
                    break;
                case 4:
                    shelter.dequeueCat();
                    System.out.println("Press Enter to return to menu.");
                    scanner.nextLine();
                    break;
                case 5:
                    shelter.dequeueAny();
                    System.out.println("Press Enter to return to menu.");
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Exiting the Animal Shelter system.");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
