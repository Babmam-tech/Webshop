package se.iths.eitvydas.webshop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HalfPriceDiscountTest {

    @Test void calculatePriceGivesHalfPrice(){
        double price = 100.0;
        HalfPriceDiscount discount = new HalfPriceDiscount();
        double discountedPrice = discount.calculatePrice(price);

        assertEquals(50.0, discountedPrice);
    }

}