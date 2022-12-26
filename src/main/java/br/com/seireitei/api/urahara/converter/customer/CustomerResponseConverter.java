package br.com.seireitei.api.urahara.converter.customer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.seireitei.api.urahara.model.customer.Customer;
import br.com.seireitei.api.urahara.response.customer.CustomerResponse;

@Component
public class CustomerResponseConverter implements Function<Customer, CustomerResponse> {
  
  @Override
  public CustomerResponse apply(Customer model) {
    
    CustomerResponse response = new CustomerResponse();
    response.setUuid(model.getUuid());
    response.setName(model.getName());
    response.setEmail(model.getEmail());
    response.setTelephone(model.getTelephone());
    response.setStatus(model.getStatus());
    response.setHostname(model.getHostname());

    return response;
  }

}
