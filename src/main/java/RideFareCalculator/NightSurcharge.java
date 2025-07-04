package RideFareCalculator;

public class NightSurcharge implements Surcharge{

    @Override
    public String getName(){
        return "Night";
    }

    @Override
    public double computeSurchargeAmount(double baseFare){
        return (baseFare * 0.15) + baseFare;
    }
}
