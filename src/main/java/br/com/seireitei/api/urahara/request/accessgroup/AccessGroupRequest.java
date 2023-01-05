package br.com.seireitei.api.urahara.request.accessgroup;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessGroupRequest {

  @NotBlank
  @Length(max = 100)
  private String name;

  @NotBlank
  @Length(max = 100)
  private String status;

  @NotBlank
  @Length(max = 100)
  private String description;

}
