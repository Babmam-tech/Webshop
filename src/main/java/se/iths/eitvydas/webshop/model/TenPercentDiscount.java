package se.iths.eitvydas.webshop.model;

public class TenPercentDiscount extends Discount {

    @Override
    public double calculatePrice(double originalPrice){
        return originalPrice * 0.9;
    }

    public TenPercentDiscount(){super("10% rabatt");}

}
