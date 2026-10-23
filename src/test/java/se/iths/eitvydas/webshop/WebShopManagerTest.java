package se.iths.eitvydas.webshop;

import org.junit.jupiter.api.Test;
import se.iths.eitvydas.webshop.model.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WebShopManagerTest {

    @Test
    void saveTwoProductsGivesListOfTwo() {
        ProductListStorage storage = new ProductListStorage();
        WebShopManager manager = new WebShopManager(storage, new ConsoleOutInputHandler());

        Product p1 = new Product("A1", "Bok", 100.0, "En bok");
        Product p2 = new Product("A2", "Penna", 20.0, "En penna");
        manager.saveProductToStorage(p1);
        manager.saveProductToStorage(p2);

        List<Product> products = manager.getProductsFromStorage();
        assertEquals(2, products.size());
    }

    @Test
    void getSavedProductByArticleNumber() {
        ProductListStorage storage = new ProductListStorage();
        WebShopManager manager = new WebShopManager(storage, new ConsoleOutInputHandler());

        Product product = new Product("A1", "Bok", 100.0, "En bok");
        manager.saveProductToStorage(product);

        Product found = manager.getProductFromStorage("A1");
        assertEquals("A1", found.getArticleNumber());
    }

    @Test
    void missingProductReturnsNull() {
        ProductListStorage storage = new ProductListStorage();
        WebShopManager manager = new WebShopManager(storage, new ConsoleOutInputHandler());

        Product found = manager.getProductFromStorage("FINNS_INTE");
        assertNull(found);
    }
}