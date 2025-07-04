package RideFareCalculator;

public class Booking {
    private String bookingId;
    private String vehicleType;
    private double baseFare; // base on vehicle type

    private double distance;
    private double durationMins;
    private double distanceRate; // base on vehicle type
    private double durationRate;
    private String fareType; // normal/night/peak/rain
    private Surcharge surcharge;

    public Booking(double baseFare, String bookingId, String vehicleType, double distance, double durationMins, double durationRate, double distanceRate, String fareType, Surcharge surcharge){
        this.bookingId = bookingId;
        this.vehicleType = vehicleType;
        this.distance = distance;
        this.durationMins = durationMins;
        this.durationRate = durationRate;
        this.fareType = fareType;
        this.baseFare = baseFare;
        this.distanceRate = distanceRate;
        this.surcharge = surcharge;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getFareType() {
        return this.fareType;
    }

    public Surcharge getSurcharge() { return surcharge; }

    public double getDistance() {
        return distance;
    }

    public double getDurationRate() {
        return durationRate;
    }

    public String getVehicleType(){
        return this.vehicleType;
    }

    public double getBaseFare(){
        return this.baseFare;
    }

    public double getDistanceCost(){
        return this.distanceRate + this.distance;
    }

    public double getDurationCost(){
        return this.durationRate * durationMins;
    }

    public double getTotalFare(){
        return this.baseFare + getDistanceCost() + getDurationCost() + getDistanceCost() + surcharge.computeSurchargeAmount(this.baseFare); // surchange
    }
}
