package RideFareCalculator;

public class BookingFactory {

    public static Booking createBooking(String bookingId, String vehicleType, double distance, double durationMins, String fareType) {
        double baseFare;
        double distanceRate;
        double durationRate;
        Surcharge surcharge = new NormalSurcharge();

        switch (vehicleType.toLowerCase()) {
            case "standard":
                baseFare = 10;
                distanceRate = 5;
                durationRate = 2;
                break;
            case "premium":
                baseFare = 20;
                distanceRate = 8;
                durationRate = 3.5;
                break;
            default:
                throw new IllegalArgumentException("Invalid vehicle type: " + vehicleType);
        }

        Booking booking = new Booking(baseFare, bookingId, vehicleType, distance, durationMins, durationRate, distanceRate, fareType, surcharge);

        return booking;
    }
}
