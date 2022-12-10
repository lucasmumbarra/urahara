package br.com.seireitei.api.urahara.response.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {

  private String uuid;

  private String name;

  private String email;

  private String telephone;

  private String status;

  private String hostname;

}
