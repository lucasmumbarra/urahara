package br.com.seireitei.api.urahara.repository.permission;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.seireitei.api.urahara.model.permission.Permission;


@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long> {

  List<Permission> findAll();

  Permission findByUuid(String uuid);
  
}
