package se.iths.eitvydas.webshop;

import se.iths.eitvydas.webshop.model.Discount;
import se.iths.eitvydas.webshop.model.HalfPriceDiscount;
import se.iths.eitvydas.webshop.model.Product;
import se.iths.eitvydas.webshop.model.TenPercentDiscount;

import java.util.List;

public class WebShopManager {

    private ProductStorage productStorage;

    private OutInputHandler outInputHandler;

    public WebShopManager(ProductStorage productStorage, OutInputHandler outInputHandler) {
        this.productStorage = productStorage;
        this.outInputHandler = outInputHandler;
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
        String code = outInputHandler.prompt("Ange rabattkod: ");
        Discount discount = null;
        if (code.equals("halfprice")){
            discount = new HalfPriceDiscount();
        } else {
            discount = new TenPercentDiscount();
        }

        boolean running = true;
        while (running) {
            String choice = outInputHandler.menu();

            if (choice.equals("1")){
                String articleNumber = outInputHandler.prompt("Mata in artikenummer: ");
                String title = outInputHandler.prompt("Mata in titel: ");
                double price = Double.parseDouble(outInputHandler.prompt("Mata in pris: "));
                String description = outInputHandler.prompt("Mata in beskrivning: ");
                Product product = new Product(articleNumber, title, price, description);
                saveProductToStorage(product);
            } else if (choice.equals("2")) {
                List<Product> products = getProductsFromStorage();
                for (Product product : products) {
                    outInputHandler.info(product.getArticleNumber() + " " + product.getTitle() + " " + product.getPrice() + " " + product.getDescription());
                    outInputHandler.info("Rabatterat pris: " + discount.calculatePrice(product.getPrice()));
                }
            } else if (choice.equals("3")) {
                String articleNumber = outInputHandler.prompt("Mata in artikenummer: ");
                Product product = getProductFromStorage(articleNumber);
                if (product == null) {
                    outInputHandler.info("not found");
                } else {
                    outInputHandler.info(product.getArticleNumber() + " " + product.getTitle() + " " + product.getPrice() + " " + product.getDescription());
                }
            } else if (choice.equals("4")) {
                running = false;
            } else {
                outInputHandler.info("Ogiltigt val");
            }
        }

    }
}
