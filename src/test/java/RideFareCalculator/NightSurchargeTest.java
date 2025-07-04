package RideFareCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NightSurchargeTest {

    private NightSurcharge nightSurcharge;

    @BeforeEach
    void setup(){
        nightSurcharge = new NightSurcharge();
    }

    @Test
    void returnsCorrectFareCalculation(){
        double actual = nightSurcharge.computeSurchargeAmount(50);
        assertEquals(57.50, actual);
    }

}