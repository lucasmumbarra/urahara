package br.com.seireitei.api.urahara.response.user;

import br.com.seireitei.api.urahara.response.accessgroup.AccessGroupResponse;
import br.com.seireitei.api.urahara.response.customer.CustomerResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

  private String uuid;

  private String name;

  private String document;

  private String email;

  private String password;

  private String status;

  private CustomerResponse customer;

  private AccessGroupResponse access_group;

}
