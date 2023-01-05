package br.com.seireitei.api.urahara.model.accessgroup;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.apache.logging.log4j.util.Strings;

import br.com.seireitei.api.urahara.model.commons.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "access_group")
public class AccessGroup extends BaseModel<AccessGroup> {

  @Column(nullable = false)
  private String uuid;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String status;

  @Column(nullable = false)
  private String description;

  @PrePersist
  public void PrePersist() {
    if (Strings.isBlank(uuid)) {
      uuid = "CST-" + UUID.randomUUID().toString();
    }
  }

}
