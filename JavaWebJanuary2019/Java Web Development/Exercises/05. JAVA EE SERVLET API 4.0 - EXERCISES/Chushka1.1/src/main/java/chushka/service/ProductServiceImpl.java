package chushka.service;

import chushka.domains.entities.Product;
import chushka.domains.entities.Type;
import chushka.domains.models.service.ProductServiceModel;
import chushka.repository.ProductRepository;
import chushka.util.ModelMapper;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 2.2.2019 г., 12:02
 */
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public void saveProduct(ProductServiceModel productServiceModel) {
        Product product = this.modelMapper.map(productServiceModel, Product.class);

        this.productRepository.save(product);
    }

    @Override
    public List<ProductServiceModel> getAllProducts() {
        return this.productRepository.findAll()
                .stream()
                .map(product -> this.modelMapper.map(product, ProductServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductServiceModel getProductModelById(String name) {
        return this.modelMapper.map(this.productRepository.findById(name),ProductServiceModel.class);
    }

    @Override
    public ProductServiceModel getProductByName(String name) {
        return this.modelMapper.map(this.productRepository.findByName(name),ProductServiceModel.class);
    }
}
