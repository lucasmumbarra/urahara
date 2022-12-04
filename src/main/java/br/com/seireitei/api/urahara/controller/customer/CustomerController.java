package br.com.seireitei.api.urahara.controller.customer;

import static org.springframework.http.HttpStatus.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.seireitei.api.urahara.model.customer.Customer;
import br.com.seireitei.api.urahara.repository.customer.CustomerRepository;

@RestController
@RequestMapping(path = "/api/v1/customer")
public class CustomerController {

  @Autowired
  private CustomerRepository repository;

  @PostMapping
  @ResponseStatus(CREATED)
  public Customer save(@RequestBody Customer customer) {
    return repository.save(customer);
  }

  @GetMapping(path = "{id}")
  public Customer findByCustomerId(@PathVariable Integer id) {
    return repository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
  }
}
