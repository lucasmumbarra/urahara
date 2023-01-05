package br.com.seireitei.api.urahara.response.permission;

import br.com.seireitei.api.urahara.response.accessgroup.AccessGroupResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionResponse {

  private String uuid;

  private String status;

  private String access_level;

  private AccessGroupResponse access_group;

}
