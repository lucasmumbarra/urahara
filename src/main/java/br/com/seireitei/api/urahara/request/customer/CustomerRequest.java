package br.com.seireitei.api.urahara.request.customer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {

  @NotBlank
  @Length(max = 100)
  private String name;

  @Email
  @NotBlank
  @Length(max = 100)
  private String email;

  @NotBlank
  @Length(max = 100)
  private String telephone;

  @NotBlank
  @Length(max = 100)
  private String status;

  @NotBlank
  @Length(max = 100)
  private String hostname;

}
