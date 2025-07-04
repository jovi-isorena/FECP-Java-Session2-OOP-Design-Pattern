package RideFareCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions .*;

class NormalSurchargeTest {
    private NormalSurcharge normalSurcharge;

    @BeforeEach
    void setup() {

        normalSurcharge = new NormalSurcharge();
    }

    @Test
    void returnsCorrectFareCalculation() {
        double actual = normalSurcharge.computeSurchargeAmount(50.0);
        assertEquals(5.0, actual);
    }

    @Test
    void checkCorrectSurchargeType() {
        String actual = normalSurcharge.getName();
        assertEquals("Normal", actual);
    }

    @Test
    void shouldThrowExceptionWhenInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> normalSurcharge.computeSurchargeAmount(-69));
    }
}