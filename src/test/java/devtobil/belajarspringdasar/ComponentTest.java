package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.data.MultiFoo;
import devtobil.belajarspringdasar.repository.CategoryRepository;
import devtobil.belajarspringdasar.repository.CustomerRepository;
import devtobil.belajarspringdasar.repository.ProductRepository;
import devtobil.belajarspringdasar.service.CategoryService;
import devtobil.belajarspringdasar.service.CustomerService;
import devtobil.belajarspringdasar.service.ProductService;

public class ComponentTest {
  private static ConfigurableApplicationContext context;

  @BeforeEach
  public void setUp() {
    context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
  }

  @Test
  public void testService() {
    ProductService productService1 = context.getBean(ProductService.class);
    ProductService productService2 = context.getBean("productService", ProductService.class);

    Assertions.assertSame(productService1, productService2);
  }

  /**
   * unit test untuk dependency injection dengan constructorom
   */
  @Test
  public void testConstructorDependencyInjection() {
    ProductService productService = context.getBean(ProductService.class);
    ProductRepository productRepository = context.getBean(ProductRepository.class);

    Assertions.assertSame(productRepository, productService.getProductRepository());
  }

  @Test
  public void testSetterDependencyInjection() {
    CategoryService categoryService = context.getBean(CategoryService.class);
    CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);

    Assertions.assertSame(categoryRepository, categoryService.getCategoryRepository());
  }

  @Test
  public void testFieldDependencyInjection() {
    CustomerService customerService = context.getBean(CustomerService.class);
    CustomerRepository normalCustomerRepository = context.getBean("normalCustomerRepository", CustomerRepository.class);
    CustomerRepository premiumCustomerRepository = context.getBean("premiumCustomerRepository",
        CustomerRepository.class);

    Assertions.assertSame(normalCustomerRepository, customerService.getNormalCustomerRepository());
    Assertions.assertSame(premiumCustomerRepository, customerService.getPremiumCustomerRepository());
  }

  @Test
  public void testObjectProvider() {
    MultiFoo multiFoo = context.getBean(MultiFoo.class);
    Assertions.assertEquals(3, multiFoo.getFoos().size());
  }
}
