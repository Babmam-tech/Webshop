package se.iths.eitvydas.webshop;

import se.iths.eitvydas.webshop.model.Discount;
import se.iths.eitvydas.webshop.model.HalfPriceDiscount;
import se.iths.eitvydas.webshop.model.Product;
import se.iths.eitvydas.webshop.model.TenPercentDiscount;

import java.util.List;

public class WebShopManager {

    private ProductStorage productStorage;

    public WebShopManager(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public void saveProductToStorage(Product product) {
        productStorage.saveProduct(product);
    }

    public List<Product> getProductsFromStorage() {
        return productStorage.getProducts();
    }

    public Product getProductFromStorage(String articleNumber){
        return productStorage.getProduct(articleNumber);
    }

    public void startWebshop() {
        String code = IO.readln("Ange rabattkod: ");
        Discount discount = null;
        if (code.equals("halfprice")){
            discount = new HalfPriceDiscount();
        } else {
            discount = new TenPercentDiscount();
        }

        boolean running = true;
        while (running) {
            IO.println("1. Lägg till produkt");
            IO.println("2. Lista alla produkter");
            IO.println("3. Visa information om en produkt");
            IO.println("4. Avsluta");

            String choice = IO.readln("Välj: ");

            if (choice.equals("1")){
                String articleNumber = IO.readln("Mata in artikenummer: ");
                String title = IO.readln("Mata in titel: ");
                double price = Double.parseDouble(IO.readln("Mata in pris: "));
                String description = IO.readln("Mata in beskrivning: ");
                Product product = new Product(articleNumber, title, price, description);
                saveProductToStorage(product);
            } else if (choice.equals("2")) {
                List<Product> products = getProductsFromStorage();
                for (Product product : products) {
                    IO.println(product.getArticleNumber() + " " + product.getTitle() + " " + product.getPrice() + " " + product.getDescription());
                    IO.println("Rabatterat pris: " + discount.calculatePrice(product.getPrice()));
                }
            } else if (choice.equals("3")) {
                String articleNumber = IO.readln("Mata in artikenummer: ");
                Product product = getProductFromStorage(articleNumber);
                if (product == null) {
                    IO.println("not found");
                } else {
                    IO.println(product.getArticleNumber() + " " + product.getTitle() + " " + product.getPrice() + " " + product.getDescription());
                }
            } else if (choice.equals("4")) {
                running = false;
            } else {
                IO.println("Ogiltigt val");
            }
        }

    }
}
