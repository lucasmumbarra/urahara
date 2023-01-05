package br.com.seireitei.api.urahara.model.permission;

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
@Table(name = "permission")
public class Permission extends BaseModel<Permission> {

  @Column(nullable = false)
  private String uuid;

  @Column(nullable = false)
  private String status;

  @Column(nullable = false)
  private String access_level;

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
