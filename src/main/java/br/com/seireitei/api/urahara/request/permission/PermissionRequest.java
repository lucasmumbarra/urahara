package br.com.seireitei.api.urahara.request.permission;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionRequest {

  @NotBlank
  @Length(max = 100)
  private String status;

  @NotBlank
  @Length(max = 100)
  private String access_level;

  @NotBlank
  @Length(max = 100)
  private String access_group_uuid;

}
