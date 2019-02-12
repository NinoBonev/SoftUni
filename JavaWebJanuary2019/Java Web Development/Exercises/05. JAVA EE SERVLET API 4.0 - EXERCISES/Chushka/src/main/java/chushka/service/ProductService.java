package chushka.service;

import chushka.domains.entities.Product;
import chushka.domains.models.service.ProductServiceModel;

import java.util.List;

/**
 * Created by Nino Bonev - 2.2.2019 г., 12:00
 */
public interface ProductService {

    void saveProduct(ProductServiceModel product);
    List<ProductServiceModel> getAllProducts();
    ProductServiceModel getProductModelById(String id);
}
