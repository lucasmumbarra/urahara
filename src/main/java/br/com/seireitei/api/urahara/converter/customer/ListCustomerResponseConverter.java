package br.com.seireitei.api.urahara.converter.customer;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.seireitei.api.urahara.model.customer.Customer;
import br.com.seireitei.api.urahara.response.customer.CustomerResponse;

@Component
public class ListCustomerResponseConverter implements Function<List<Customer>, List<CustomerResponse>> {

  @Autowired
  private CustomerResponseConverter converter;

  @Override
  public List<CustomerResponse> apply(List<Customer> models) {

    List<CustomerResponse> responses = models.stream().map(m -> this.converter.apply(m)).collect(toList());

    return responses;
  }

}
