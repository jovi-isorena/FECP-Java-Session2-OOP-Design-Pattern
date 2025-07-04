package RideFareCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {

    @Test
    public void testBookingGetters() {
        Surcharge surcharge = new NormalSurcharge();
        Booking booking = new Booking(
                10,
                "B101",
                "standard",
                7.0,
                20.0,
                2.0,
                5.0,
                "normal",
                surcharge
        );


        assertEquals("B101", booking.getBookingId());
        assertEquals("normal", booking.getFareType());
        assertEquals("Normal", booking.getSurcharge().getName());
    }


    @Test
    public void testDistanceCostCalculation() {
        Surcharge surcharge = new NormalSurcharge();
        Booking booking = new Booking(10, "B102", "standard", 8.0, 20.0, 2.0, 5.0, "normal", surcharge);


        // distanceCost = distanceRate + distance = 5 + 8 = 13
        assertEquals(13.0, booking.getDistanceCost(), 0.01);
    }


    @Test
    public void testDurationCostCalculation() {
        Surcharge surcharge = new NormalSurcharge();
        Booking booking = new Booking(10, "B103", "standard", 8.0, 15.0, 2.0, 5.0, "normal", surcharge);


        // durationCost = durationRate * durationMins = 2 * 15 = 30
        assertEquals(30.0, booking.getDurationCost(), 0.01);
    }


    @Test
    public void testTotalFareCalculation() {
        Surcharge surcharge = new NormalSurcharge();
        Booking booking = new Booking(10, "B104", "standard", 6.0, 10.0, 2.0, 4.0, "normal", surcharge);


        // totalFare = baseFare + distanceCost + durationCost + distanceCost + 100
        // distanceCost = 4 + 6 = 10
        // durationCost = 2 * 10 = 20
        // totalFare = 10 + 10 + 20 + 10 + 100 = 150
        assertEquals(150.0, booking.getTotalFare(), 0.01);
    }


    @Test
    public void testDifferentSurchargeTypesAssignedCorrectly() {
        Booking rainBooking = new Booking(10, "B105", "standard", 5, 10, 2, 4, "rain", new RainSurcharge());
        Booking peakBooking = new Booking(10, "B106", "standard", 5, 10, 2, 4, "peak", new PeakHourSurcharge());
        Booking nightBooking = new Booking(10, "B107", "standard", 5, 10, 2, 4, "night", new NightSurcharge());


        assertEquals("Rain", rainBooking.getSurcharge().getName());
        assertEquals("Peak hours", peakBooking.getSurcharge().getName());
        assertEquals("Night", nightBooking.getSurcharge().getName());
    }
}
