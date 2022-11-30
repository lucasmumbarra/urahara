package br.com.seireitei.api.urahara.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seireitei.api.urahara.model.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  
}
