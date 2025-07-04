package RideFareCalculator;

public class PeakHourSurcharge implements Surcharge{

    @Override
    public String getName(){
        return "Peak hours";
    }

    @Override
    public double computeSurchargeAmount(double baseFare){
        if(baseFare < 0) throw  new IllegalArgumentException("Value cannot be less than 0.");
        return (baseFare * 0.25);
    }

}
