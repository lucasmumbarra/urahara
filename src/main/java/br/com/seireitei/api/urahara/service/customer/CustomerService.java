package br.com.seireitei.api.urahara.service.customer;

import java.util.List;

import br.com.seireitei.api.urahara.request.customer.CustomerRequest;
import br.com.seireitei.api.urahara.response.basereturn.BaseReturn;
import br.com.seireitei.api.urahara.response.customer.CustomerResponse;

public interface CustomerService {

  BaseReturn<CustomerResponse> findByUuid(String uuid);

  BaseReturn<List<CustomerResponse>> findByAll();
  
  BaseReturn<CustomerResponse> create(CustomerRequest request);

  BaseReturn<CustomerResponse> update(String uuid, CustomerRequest request);

  void deleteByUuid(String uuid);
}
