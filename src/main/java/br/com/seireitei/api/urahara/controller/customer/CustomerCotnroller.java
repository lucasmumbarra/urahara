package br.com.seireitei.api.urahara.controller.customer;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping(produces = PRODUCES_JSON, consumes = CONSUMES_ALL)
  public BaseReturn<List<CustomerResponse>> findByAll() {
    return service.findByAll();
  }

  @GetMapping(path = "/{uuid}", produces = PRODUCES_JSON, consumes = CONSUMES_ALL)
  public BaseReturn<CustomerResponse> findByUuid(@PathVariable("uuid") String uuid) {
    return service.findByUuid(uuid);
  }

  @PostMapping(produces = PRODUCES_JSON, consumes = CONSUMES_ALL)
  public BaseReturn<CustomerResponse> create(@Valid @RequestBody CustomerRequest request) {
    return service.create(request);
  }

  @PutMapping(path = "/{uuid}", produces = PRODUCES_JSON, consumes = CONSUMES_ALL)
  public BaseReturn<CustomerResponse> updated(@Valid @RequestBody CustomerRequest request,
      @PathVariable("uuid") String uuid) {
    return service.update(uuid, request);
  }

  @DeleteMapping(path = "/{uuid}", produces = PRODUCES_JSON, consumes = CONSUMES_ALL)
  public void deleted(@PathVariable("uuid") String uuid) {
    service.deleteByUuid(uuid);
  }

}
