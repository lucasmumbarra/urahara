package br.com.seireitei.api.urahara.service.impl.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seireitei.api.urahara.converter.customer.CustomerCreateConverter;
import br.com.seireitei.api.urahara.converter.customer.CustomerResponseConverter;
import br.com.seireitei.api.urahara.model.customer.Customer;
import br.com.seireitei.api.urahara.repository.customer.CustomerRepository;
import br.com.seireitei.api.urahara.request.customer.CustomerRequest;
import br.com.seireitei.api.urahara.response.basereturn.BaseReturn;
import br.com.seireitei.api.urahara.response.customer.CustomerResponse;
import br.com.seireitei.api.urahara.service.customer.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
  
  @Autowired
  private CustomerRepository repository;
  @Autowired
  private CustomerCreateConverter customerCreateConverter;
  @Autowired
  private CustomerResponseConverter customerResponseConverter;

  @Override
  public BaseReturn<CustomerResponse> create(CustomerRequest request) {
    
    Customer model = this.customerCreateConverter.apply(request);
    model = repository.save(model);

    CustomerResponse data = this.customerResponseConverter.apply(model);

    BaseReturn<CustomerResponse> response = new BaseReturn<>(data);

    return response;

  }

}
