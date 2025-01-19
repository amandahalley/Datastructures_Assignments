package Arrays;

import java.util.Arrays;

//Calculate the avarage temperature, and give how many days are above the avarage temperature
//  1. Take an input from the user (eg. 5)
//  2. Prompt the user to enter all the 5 numbers (temperature values)
//  3. Calculate the avarage temperature
//  4. Given the avarage temperature, how many of the numbers in the line 2 are above the avarage temperature?


public class QuestionOne {
    int[] temperatures = null;

    // initialize array
    public QuestionOne(int numDays) {
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
                System.out.println("Temperature for: " + (day + 1) + " has been recorded.");
            } else {
                //notify user if temperature is already recorded
               System.out.println("Temperature for: " + (day + 1) + " already exists." );
            }
            // error message for invalid date
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid date.");
        }
    }


}