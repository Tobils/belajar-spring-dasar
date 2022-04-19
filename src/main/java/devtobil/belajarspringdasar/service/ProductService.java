package devtobil.belajarspringdasar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import devtobil.belajarspringdasar.repository.ProductRepository;
import lombok.Getter;

// @Scope("prototype")
// @Lazy
@Component
public class ProductService {

  @Getter
  private ProductRepository productRepository;

  /**
   * untuk menandakan DI ini sebagai default constructor
   * 
   * @param productRepository
   */
  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public ProductService(ProductRepository productRepository, String name) {
    this.productRepository = productRepository;
  }

  public ProductRepository getProductRepository() {
    return productRepository;
  }

}
