package br.com.seireitei.api.urahara.service.impl.customer;

import static java.util.Objects.*;
import static org.springframework.http.HttpStatus.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seireitei.api.urahara.converter.customer.CustomerCreateConverter;
import br.com.seireitei.api.urahara.converter.customer.CustomerResponseConverter;
import br.com.seireitei.api.urahara.converter.customer.CustomerUpdateConverter;
import br.com.seireitei.api.urahara.converter.customer.ListCustomerResponseConverter;
import br.com.seireitei.api.urahara.model.customer.Customer;
import br.com.seireitei.api.urahara.repository.customer.CustomerRepository;
import br.com.seireitei.api.urahara.request.customer.CustomerRequest;
import br.com.seireitei.api.urahara.response.basereturn.BaseReturn;
import br.com.seireitei.api.urahara.response.customer.CustomerResponse;
import br.com.seireitei.api.urahara.service.customer.CustomerService;
import br.com.seireitei.api.urahara.web.error.exception.BaseException;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository repository;
  @Autowired
  private CustomerCreateConverter customerCreateConverter;
  @Autowired
  private CustomerUpdateConverter customerUpdateConverter;
  @Autowired
  private CustomerResponseConverter customerResponseConverter;
  @Autowired
  private ListCustomerResponseConverter listCustomerResponseConverter;

  @Override
  public BaseReturn<CustomerResponse> findByUuid(String uuid) {

    Customer model = repository.findByUuid(uuid);

    if (isNull(model)) {
      throw new BaseException(NOT_FOUND, "Customer not found");
    }

    CustomerResponse data = customerResponseConverter.apply(model);

    BaseReturn<CustomerResponse> response = new BaseReturn<>(data);

    return response;
  }

  public BaseReturn<List<CustomerResponse>> findByAll() {

    List<Customer> models = repository.findAll();

    List<CustomerResponse> data = listCustomerResponseConverter.apply(models);

    BaseReturn<List<CustomerResponse>> response = new BaseReturn<>(data);

    return response;
  }

  @Override
  public BaseReturn<CustomerResponse> create(CustomerRequest request) {

    Customer model = this.customerCreateConverter.apply(request);
    model = repository.save(model);

    CustomerResponse data = this.customerResponseConverter.apply(model);

    BaseReturn<CustomerResponse> response = new BaseReturn<>(data);

    return response;

  }

  @Override
  public BaseReturn<CustomerResponse> update(String uuid, CustomerRequest request) {

    Customer model = repository.findByUuid(uuid);

    if (isNull(model)) {
      throw new BaseException(NOT_FOUND, "Customer not found");
    }

    model = this.customerUpdateConverter.apply(request, model);
    model = repository.save(model);

    CustomerResponse data = this.customerResponseConverter.apply(model);

    BaseReturn<CustomerResponse> response = new BaseReturn<>(data);

    return response;

  }

  @Override
  public void deleteByUuid(String uuid) {
    Customer model = repository.findByUuid(uuid);

    if (isNull(model)) {
      throw new BaseException(NOT_FOUND, "Customer not found");
    }

    repository.deleteById(model.getId());
  }

}
