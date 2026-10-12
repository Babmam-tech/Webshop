package se.iths.eitvydas.webshop.model;

public class HalfPriceDiscount extends Discount {

    @Override
    public double calculatePrice(double originalPrice){
        return originalPrice * 0.5;
    }

    public HalfPriceDiscount(){super("50% rabatt");}
}
