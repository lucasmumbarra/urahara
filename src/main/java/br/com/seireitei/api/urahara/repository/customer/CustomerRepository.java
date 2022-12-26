package br.com.seireitei.api.urahara.repository.customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.seireitei.api.urahara.model.customer.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findAll();

  Customer findByUuid(String uuid);
  
}
