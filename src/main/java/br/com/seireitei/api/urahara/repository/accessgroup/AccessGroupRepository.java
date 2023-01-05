package br.com.seireitei.api.urahara.repository.accessgroup;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.seireitei.api.urahara.model.accessgroup.AccessGroup;


@Repository
public interface AccessGroupRepository extends CrudRepository<AccessGroup, Long> {

  List<AccessGroup> findAll();

  AccessGroup findByUuid(String uuid);
  
}
