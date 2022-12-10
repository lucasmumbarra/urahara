package br.com.seireitei.api.urahara.controller.customer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.seireitei.api.urahara.controller.basecontroller.BaseController;
import br.com.seireitei.api.urahara.request.customer.CustomerRequest;
import br.com.seireitei.api.urahara.response.basereturn.BaseReturn;
import br.com.seireitei.api.urahara.response.customer.CustomerResponse;
import br.com.seireitei.api.urahara.service.customer.CustomerService;

@Validated
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerCotnroller extends BaseController {
  
  @Autowired
  private CustomerService service;

  @PostMapping(produces = PRODUCES_JSON, consumes = CONSUMES_ALL)
  public BaseReturn<CustomerResponse> create(@Valid @RequestBody CustomerRequest request) {
    return service.create(request);
  }

}
