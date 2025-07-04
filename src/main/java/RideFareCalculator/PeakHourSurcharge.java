package RideFareCalculator;

public class PeakHourSurcharge implements Surcharge{

    @Override
    public String getName(){
        return "Peak hours";
    }

    @Override
    public double computeSurchargeAmount(double baseFare){
        return (baseFare * 0.25) + baseFare;
    }

}
