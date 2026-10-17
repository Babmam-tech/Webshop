package se.iths.eitvydas.webshop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TenPercentDiscountTest {

    @Test void calculatePriceGivesTenPercentOff(){
        double price = 100.0;
        TenPercentDiscount discount = new TenPercentDiscount();
        double discountedPrice = discount.calculatePrice(price);

        assertEquals(90.0, discountedPrice);

    }

}