package br.com.seireitei.api.urahara.converter.accessgroup;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.seireitei.api.urahara.model.accessgroup.AccessGroup;
import br.com.seireitei.api.urahara.response.accessgroup.AccessGroupResponse;

@Component
public class AccessGroupResponseConverter implements Function<AccessGroup, AccessGroupResponse> {
  
  @Override
  public AccessGroupResponse apply(AccessGroup model) {
    
    AccessGroupResponse response = new AccessGroupResponse();
    response.setUuid(model.getUuid());
    response.setName(model.getName());
    response.setStatus(model.getStatus());
    response.setDescription(model.getDescription());

    return response;
  }

}
