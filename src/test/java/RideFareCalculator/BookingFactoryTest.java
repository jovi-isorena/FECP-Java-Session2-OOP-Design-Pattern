package RideFareCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookingFactoryTest {


    @Test
    public void testValidStandardBooking() {
        Booking booking = BookingFactory.createBooking("B001", "standard", 10.0, 20.0, "normal");
        assertNotNull(booking);
        assertEquals("B001", booking.getBookingId());
    }

    // Invalid vehicle type
    @Test
    public void testInvalidVehicleTypeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.createBooking("B002", "helicopter", 10.0, 10.0, "normal");
        });
    }

    // Invalid fare type
    @Test
    public void testInvalidFareTypeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.createBooking("B003", "standard", 10.0, 10.0, "snow");
        });
    }

    // Null booking ID
    @Test
    public void testNullBookingIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.createBooking(null, "standard", 5.0, 5.0, "normal");
        });
    }

    // Empty booking ID
    @Test
    public void testEmptyBookingIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.createBooking("   ", "standard", 5.0, 5.0, "normal");
        });
    }

    // Negative distance
    @Test
    public void testNegativeDistanceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.createBooking("B004", "standard", -5.0, 5.0, "normal");
        });
    }

    // Negative duration
    @Test
    public void testNegativeDurationThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.createBooking("B005", "standard", 5.0, -1.0, "normal");
        });
    }

    // Null fare type
    @Test
    public void testNullFareTypeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.createBooking("B006", "standard", 5.0, 5.0, null);
        });
    }

    // Empty fare type
    @Test
    public void testEmptyFareTypeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.createBooking("B007", "standard", 5.0, 5.0, "   ");
        });
    }

    // Null vehicle type
    @Test
    public void testNullVehicleTypeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.createBooking("B008", null, 5.0, 5.0, "normal");
        });
    }

    // Empty vehicle type
    @Test
    public void testEmptyVehicleTypeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.createBooking("B009", "   ", 5.0, 5.0, "normal");
        });
    }
}
