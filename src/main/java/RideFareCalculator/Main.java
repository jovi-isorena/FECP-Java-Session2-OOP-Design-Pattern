package RideFareCalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int idCounter;
    public static void main(String[] args) {
        ArrayList<Booking> bookings = new ArrayList<>();
        boolean isLooping = true;
        do{
            displayMenu();
            System.out.print("Enter choice: ");
            String selection = sc.nextLine();
            switch(selection){
                case "1":
                    bookRide(bookings);
                    break;
                case "2":
                    viewAll(bookings);
                    break;
                case "3":
                    calculateFare(bookings);
                    break;
                case "4":
                    viewReceipt(bookings);
                    break;
                case "5":
                    System.out.println("Thank you for using our app.");
                    isLooping = false;
                    break;
            }
        }while(isLooping);



    }
    public static void displayMenu(){
        System.out.println("=== Ride Booking System ===");
        System.out.println("1. Book a Ride");
        System.out.println("2. View All Booking");
        System.out.println("3. Calculate Fare");
        System.out.println("4. View Receipt");
        System.out.println("5. Exit");

    }
    public static void bookRide(ArrayList<Booking> bookings){
        System.out.print("Enter Ride Type (standard/premium): ");
        String rideType = sc.nextLine();
        System.out.print("Enter Fare Type (normal/night/peak/rain): ");
        String fareType = sc.nextLine();
        System.out.print("Enter Distance (km): ");
        double distance = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Duration (mins): ");
        double duration = Double.parseDouble(sc.nextLine());
        String newId = generateId();
        // use bookingFactory here
        Booking booking;
        try{
          booking = BookingFactory.createBooking(newId, rideType, distance, duration, fareType);
          bookings.add(booking);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            booking = null;

        }
        if(booking != null){
            System.out.println("Ride booked successfully!");
        }else{
            System.out.println("Booking failed.");
        }
    }
    public static void viewAll(ArrayList<Booking> bookings){
        System.out.println("--- Bookings ---");
        for(Booking booking : bookings){
            System.out.printf("Ref#: %s\n", booking.getBookingId());
            System.out.printf("Ride Type: %s\n", booking.getFareType());
            System.out.printf("Total Fare: %.2f\n\n", booking.getTotalFare());
        }
        System.out.println("Press Enter to continue.");
        sc.nextLine();
    }
    public static void calculateFare(ArrayList<Booking> bookings){
        System.out.print("Enter Ride Reference No.: ");
        String refNo = sc.nextLine();
        Booking booking = searchBooking(bookings, refNo);
        if(booking == null) {
            System.out.println("Booking not found. Press Enter to continue.");
            sc.nextLine();
        }else{
            System.out.printf("Fare Type: %s\n", booking.getFareType());
            System.out.printf("Base fare: %.2f\n", booking.getBaseFare() );
            System.out.printf("Distance cost: %.2f\n", booking.getDistanceCost());
            System.out.printf("Duration cost: %.2f\n", booking.getDurationCost());
            System.out.printf("Surcharge (%s): %.2f\n", booking.getSurcharge().getName(), booking.getSurcharge().computeSurchargeAmount(booking.getBaseFare()));
            System.out.printf("Total Fare: %.2f\n", booking.getTotalFare());
            System.out.println("\nPress Enter to continue.");
            sc.nextLine();
        }
    }

    public static void viewReceipt(ArrayList<Booking> bookings){
        System.out.print("Enter Ride Reference No.: ");
        String refNo = sc.nextLine();
        Booking booking = searchBooking(bookings, refNo);
        if(booking == null) {
            System.out.println("Booking not found. Press Enter to continue.");
//            sc.nextLine();
        }else{
            System.out.println("--- Receipt ---");
            System.out.printf("Ref #: %s\n", booking.getBookingId());
            System.out.printf("Ride Type: %s\n", booking.getVehicleType());
            System.out.printf("Distance: %s km\n", booking.getDistance());
            System.out.printf("Duration: %s mins\n", booking.getDurationRate());
            System.out.printf("Total Fare: %s\n", booking.getTotalFare());
            System.out.println("\nPress Enter to continue.");
//            sc.nextLine();
        }
        sc.nextLine();
    }
    public static Booking searchBooking(ArrayList<Booking> bookings, String id){
        return bookings.stream().filter(b -> b.getBookingId().equals(id) ).findFirst().orElse(null);
    }

    private static String generateId(){
        return String.format("%04d", ++idCounter);
    }
}
