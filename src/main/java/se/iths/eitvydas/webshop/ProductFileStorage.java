package se.iths.eitvydas.webshop;


import se.iths.eitvydas.webshop.model.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductFileStorage implements ProductStorage{

    private Path file = Path.of("products.txt");

    @Override
    public void saveProduct(Product product) {
    String line = product.toFileLine();
        try {
            Files.writeString(file, line + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            IO.println("Kunde inte spara produkten: " + e.getMessage());
        }
    }

    @Override
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<Product>();

        if (!Files.exists(file)){
            return products;
        }
        try {
            List<String> lines = Files.readAllLines(file);
            for (String line : lines){products.add(Product.fromFileLine(line));
            }
        } catch (IOException e){
            IO.println("Kunde inte läsa produkten: " + e.getMessage());
        }


        return products;
    }

    @Override
    public Product getProduct(String articleNumber) {
        List<Product> products = getProducts();

        for (Product product : products) {
            if (product.getArticleNumber().equals(articleNumber)) {
                return product;
            }
        }
        return null;
    }
}
