package br.com.seireitei.api.urahara.converter.accessgroup;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.seireitei.api.urahara.model.accessgroup.AccessGroup;
import br.com.seireitei.api.urahara.request.accessgroup.AccessGroupRequest;

@Component
public class AccessGroupCreateConverter implements Function<AccessGroupRequest, AccessGroup> {
  
  @Override
  public AccessGroup apply(AccessGroupRequest request) {
    
    AccessGroup model = new AccessGroup();
    model.setName(request.getName());
    model.setStatus(request.getStatus());
    model.setDescription(request.getDescription());

    return model;
  }

}
