package br.com.seireitei.api.urahara.converter.customer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.seireitei.api.urahara.model.customer.Customer;
import br.com.seireitei.api.urahara.request.customer.CustomerRequest;

@Component
public class CustomerCreateConverter implements Function<CustomerRequest, Customer> {
  
  @Override
  public Customer apply(CustomerRequest request) {
    
    Customer model = new Customer();
    model.setName(request.getName());
    model.setEmail(request.getEmail());
    model.setTelephone(request.getTelephone());
    model.setStatus(request.getStatus());
    model.setHostname(request.getHostname());

    return model;
  }

}
