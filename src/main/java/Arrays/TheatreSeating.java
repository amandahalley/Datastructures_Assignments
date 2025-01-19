package Arrays;

//Simulate a movie theater that helps users to book and reserve seats.

//1. reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
//2. cancel seats
//3. retrieve initial seating charting

public class TheatreSeating {
    int [][] arr = null;

    //initialize movie theatre seating with given num of rows/cols
    public TheatreSeating(int rows, int cols) {
        //initialize 2d array
        arr = new int[rows][cols];

        //loop through each row, and then each column
        for (int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[0].length; col++){
                arr[row][col] = Integer.MIN_VALUE;
            }
        }
    }

}