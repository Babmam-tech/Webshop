package se.iths.eitvydas.webshop.model;



public abstract class Discount {

    protected String description;

    public String getDescription(){
        return this.description;
    }

    public abstract double calculatePrice(double originalPrice);

    public Discount(String description){
        this.description = description;
    }

}
