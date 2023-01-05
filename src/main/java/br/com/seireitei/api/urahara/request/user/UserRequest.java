package br.com.seireitei.api.urahara.request.user;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

  @NotBlank
  @Length(max = 100)
  private String name;

  @NotBlank
  @Length(max = 100)
  private String document;

  @NotBlank
  @Length(max = 100)
  private String email;

  @NotBlank
  @Length(max = 100)
  private String password;

  @NotBlank
  @Length(max = 100)
  private String status;

  @NotBlank
  @Length(max = 100)
  private String customer_uuid;

  @NotBlank
  @Length(max = 100)
  private String access_group_uuid;

}
