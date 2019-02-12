package chushka.repository;

import chushka.domains.entities.Product;

import java.util.Optional;

/**
 * Created by Nino Bonev - 2.2.2019 г., 11:46
 */
public interface ProductRepository extends GenericRepository<Product, String> {

    Product findByName(String name);
}
