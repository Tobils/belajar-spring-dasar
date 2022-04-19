package devtobil.belajarspringdasar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import devtobil.belajarspringdasar.repository.CustomerRepository;
import lombok.Getter;
import lombok.Setter;

@Component
public class CustomerService {

  @Getter
  @Autowired
  @Qualifier("normalCustomerRepository")
  private CustomerRepository normalCustomerRepository;

  @Getter
  @Autowired
  @Qualifier("premiumCustomerRepository")
  private CustomerRepository premiumCustomerRepository;

}
