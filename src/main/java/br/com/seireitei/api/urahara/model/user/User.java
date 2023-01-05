package br.com.seireitei.api.urahara.model.user;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.apache.logging.log4j.util.Strings;

import br.com.seireitei.api.urahara.model.commons.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends BaseModel<User> {

  @Column(nullable = false)
  private String uuid;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String document;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String status;

  @ManyToOne
  @JoinColumn(table = "customer", referencedColumnName = "id")
  private String customer_id;

  @ManyToOne
  @JoinColumn(table = "access_group", referencedColumnName = "id")
  private String access_group_id;

  @PrePersist
  public void PrePersist() {
    if (Strings.isBlank(uuid)) {
      uuid = "CST-" + UUID.randomUUID().toString();
    }
  }

}
