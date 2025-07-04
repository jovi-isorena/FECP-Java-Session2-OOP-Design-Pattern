package RideFareCalculator;

public class NormalSurcharge implements Surcharge{

    @Override
    public String getName(){
        return "Normal";
    }

    @Override
    public double computeSurchargeAmount(double baseFare){
        return (baseFare * 0.1) + baseFare;
    }
}
