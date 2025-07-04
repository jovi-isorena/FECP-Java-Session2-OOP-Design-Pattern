package RideFareCalculator;

public class BookingFactory {

    public static Booking createBooking(String bookingId, String vehicleType, double distance, double durationMins, String fareType) {
        if (bookingId == null || bookingId.trim().isEmpty()) {
            throw new IllegalArgumentException("Booking ID cannot be null or empty");
        }
        if (vehicleType == null || vehicleType.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle type cannot be null or empty");
        }
        if (fareType == null || fareType.trim().isEmpty()) {
            throw new IllegalArgumentException("Fare type cannot be null or empty");
        }
        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }
        if (durationMins < 0) {
            throw new IllegalArgumentException("Duration cannot be negative");
        }

        Surcharge surcharge = switch (fareType.toLowerCase()) {
            case "rain" -> new RainSurcharge();
            case "peak" -> new PeakHourSurcharge();
            case "night" -> new NightSurcharge();
            case "normal" -> new NormalSurcharge();
            default -> throw new IllegalArgumentException("Invalid fare type: " + fareType);
        };

        // Rates based on vehicle type
        double baseFare;
        double distanceRate;
        double durationRate;

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
        return new Booking(baseFare, bookingId, vehicleType, distance, durationMins, durationRate, distanceRate, fareType, surcharge);
    }
}