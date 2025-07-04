package RideFareCalculator;

public class RainSurcharge implements Surcharge{

    @Override
    public String getName(){
        return "Rain";
    }

    @Override
    public double computeSurchargeAmount(double baseFare){
        return (baseFare * 0.20) + baseFare;
    }

}
