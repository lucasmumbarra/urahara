package br.com.seireitei.api.urahara.converter.accessgroup;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.seireitei.api.urahara.model.accessgroup.AccessGroup;
import br.com.seireitei.api.urahara.response.accessgroup.AccessGroupResponse;

@Component
public class ListAccessGroupResponseConverter implements Function<List<AccessGroup>, List<AccessGroupResponse>> {

  @Autowired
  private AccessGroupResponseConverter converter;

  @Override
  public List<AccessGroupResponse> apply(List<AccessGroup> models) {

    List<AccessGroupResponse> responses = models.stream().map(m -> this.converter.apply(m)).collect(toList());

    return responses;
  }

}
