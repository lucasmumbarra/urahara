package br.com.seireitei.api.urahara.repository.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.seireitei.api.urahara.model.user.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  List<User> findAll();

  User findByUuid(String uuid);
  
}
