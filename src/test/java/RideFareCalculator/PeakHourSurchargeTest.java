package RideFareCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeakHourSurchargeTest {
    private PeakHourSurcharge peakHourSurcharge;

    @BeforeEach
    void setup() {

        peakHourSurcharge = new PeakHourSurcharge();
    }

    @Test
    void returnsCorrectFareCalculation() {
        double actual = peakHourSurcharge.computeSurchargeAmount(50.0);
        assertEquals(62.5, actual);
    }

    @Test
    void checkCorrectSurchargeType() {
        String actual = peakHourSurcharge.getName();
        assertEquals("Peak hours", actual);
    }

    @Test
    void shouldThrowExceptionWhenInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> peakHourSurcharge.computeSurchargeAmount(-69));
    }

}