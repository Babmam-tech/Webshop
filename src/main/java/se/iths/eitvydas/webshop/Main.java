package se.iths.eitvydas.webshop;

public class Main {
    public static void main(String[] args) {
        ProductFileStorage storage = new ProductFileStorage();
        WebShopManager manager = new WebShopManager(storage);
        manager.startWebshop();
    }
}
