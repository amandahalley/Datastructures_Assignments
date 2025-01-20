package Arrays;

//Calculate the avarage temperature, and give how many days are above the avarage temperature
//  1. Take an input from the user (eg. 5)
//  2. Prompt the user to enter all the 5 numbers (temperature values)
//  3. Calculate the avarage temperature
//  4. Given the avarage temperature, how many of the numbers in the line 2 are above the avarage temperature?


import java.util.Scanner;

public class TemperatureAverage {
    int[] temperatures;

    // initialize array
    public TemperatureAverage(int numDays) {
        temperatures = new int[numDays];
        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = Integer.MIN_VALUE;
        }
    }

    //insert temperatures into array
    public void addTemperatures(int day, int temperature) {
        //Check is day is initialized, records if not
        try {
            if (temperatures[day] == Integer.MIN_VALUE) {
                temperatures[day] = temperature;
                System.out.println("Temperature for day " + (day + 1) + " has been recorded.");
            } else {
                //notify user if temperature is already recorded
               System.out.println("Temperature for day " + (day + 1) + " already exists." );
            }
            // error message for invalid date
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid date.");
        }
    }


    // display all temperatures recorded
    public void allTemperatures() {
        System.out.println();
        System.out.println("Temperatures recorded: ");
        for (int i = 0; i < temperatures.length; i++)  {
            if (temperatures[i] == Integer.MIN_VALUE) {
                System.out.println("Day " + (i + 1) + " Not Recorded.");
            } else {
                System.out.println("Day " + (i + 1) + ": " + temperatures[i] );
            }
        }
        System.out.println();
    }

    // calculate average temperature
    public double calcAvg() {
        int sum = 0;
        int count = 0;
        for (int temperature : temperatures) {
            if (temperature != Integer.MIN_VALUE) {
                sum += temperature;
                count++;
            }
        }
        return count > 0 ? (double) sum / count : 0;
    }

    // calculate days above average temperature
    public int daysAboveAvg(double average) {
        int count = 0;
        for (int temperature : temperatures) {
            if (temperature != Integer.MIN_VALUE && temperature > average) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ask user for the number of days
        System.out.print("Enter the number of days you are recording: ");
        int numberOfDays = scanner.nextInt();

        //creating object for 5 days
        TemperatureAverage temperatureAverage = new TemperatureAverage(numberOfDays);


        // Step 3: Prompt the user to enter temperatures
        System.out.println("Please enter the temperatures for " + numberOfDays + " days:");
        for (int i = 0; i < numberOfDays; i++) {
            System.out.print("Day " + (i +1) + ": ");
            int temp = scanner.nextInt();
            temperatureAverage.addTemperatures(i, temp); // Record the temperature
        }

        //all temperatures
        temperatureAverage.allTemperatures();

        //average temperature
        double average = temperatureAverage.calcAvg();
        System.out.println("The average temperature is: " + average);

        //count days above average
        int aboveAvg = temperatureAverage.daysAboveAvg(average);
        System.out.println("Number of days above average:  " + aboveAvg );
    }


}