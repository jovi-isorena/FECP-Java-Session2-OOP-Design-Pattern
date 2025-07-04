package RideFareCalculator;

public class NormalSurcharge implements Surcharge{
    @Override
    public String getName(){
        return "Normal";
    }
    @Override
    public double computeSurchargeAmount(double baseFare){
        if(baseFare < 0) throw  new IllegalArgumentException("Value cannot be less than 0.");
        return (baseFare * 0.1);
    }
}
