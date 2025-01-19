package Arrays;

//Simulate a movie theater that helps users to book and reserve seats.

//1. reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
//2. cancel seats
//3. retrieve initial seating charting

import java.lang.reflect.Array;

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

    //reserve seats
    public void seatReserve(int row, int col) {
        try {
            if (arr[row][col] == Integer.MIN_VALUE) {
                arr[row][col] = 1; //this reserves the seat
                System.out.println("Seat row " + row + " column " + col + " has been successfully reserved.");
            } else {
                System.out.println("Seat row " + row + " column " + col + " is unavailable.");
                availableSeat(); //suggests seat for seat that is unavailable
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat.");
        }
    }

    // suggesting an available seat
    public void availableSeat() {
        //loop through each row/col, checking if a seat is available
        for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[0].length; col++){
                if (arr[row][col] == Integer.MIN_VALUE) {
                    System.out.println("Suggested seat: row " + row + " column " + col);
                    return;
                }
            }
        }
        System.out.println("There are currently no seats available");
    }

    //cancel seats
    public void cancelSeat(int row, int col){
        try {
            if (arr[row][col] == 1) {
                arr[row][col] = Integer.MIN_VALUE; //seat now available
                System.out.println("Seat row " + row + " column " + col + " successfully cancelled.");
            } else {
                System.out.println("Seat row " + row + " column " + col + " not reserved.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat.");
        }
    }

    //retrieve seating chart
    public void seatingChart() {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++){
                if (arr[row][col] == Integer.MIN_VALUE) {
                    System.out.println("Row " + row + " Column " + col + " - Available");
                } else {
                    System.out.println("Row " + row + " Column " + col + " - Reserved");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TheatreSeating theatreSeating = new TheatreSeating(5, 5);

        //display seating chart
        System.out.println("Seating Chart: ");
        theatreSeating.seatingChart();

        //reserve seats
        theatreSeating.seatReserve(1,4);
        theatreSeating.seatReserve(2,2);
        theatreSeating.seatReserve(2,3);
        theatreSeating.seatReserve(0,2);
        theatreSeating.seatReserve(2,5);

        //display seating char after reservations
        System.out.println("\nReserved Seating Chart:");
        theatreSeating.seatingChart();

        //reserving an already reserved seat
        System.out.println("Already Reserved: ");
        theatreSeating.seatReserve(2,2);
        System.out.println();

        //cancelling a seat
        System.out.println("Seat Cancellation:");
        theatreSeating.cancelSeat(1,4);
        System.out.println();

        //updated seat chart
        System.out.println("\nUpdated Seating Chart (cancellation)");
        theatreSeating.seatingChart();


    }
}