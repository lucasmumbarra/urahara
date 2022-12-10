package br.com.seireitei.api.urahara.service.customer;

import br.com.seireitei.api.urahara.request.customer.CustomerRequest;
import br.com.seireitei.api.urahara.response.basereturn.BaseReturn;
import br.com.seireitei.api.urahara.response.customer.CustomerResponse;

public interface CustomerService {
  
  BaseReturn<CustomerResponse> create(CustomerRequest request);

}
