package RideFareCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RainSurchargeTest {
    private RainSurcharge rainSurcharge;

    @BeforeEach
    void setup() {

        rainSurcharge = new RainSurcharge();
    }

    @Test
    void returnsCorrectFareCalculation() {
        double actual = rainSurcharge.computeSurchargeAmount(50.0);
        assertEquals(10.0, actual);
    }

    @Test
    void checkCorrectSurchargeType() {
        String actual = rainSurcharge.getName();
        assertEquals("Rain", actual);
    }

    @Test
    void shouldThrowExceptionWhenInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> rainSurcharge.computeSurchargeAmount(-69));
    }
}