package se.iths.eitvydas.webshop;

import se.iths.eitvydas.webshop.model.Product;

import java.util.List;

public interface ProductStorage {

  void saveProduct(Product product);
  List<Product> getProducts();
  Product getProduct(String articleNumber);

}
