package br.com.seireitei.api.urahara.model.customer;

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
@Table(name = "customer")
public class Customer extends BaseModel<Customer> {

  @Column(nullable = false)
  private String uuid;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String telephone;

  @Column(nullable = false)
  private String status;

  @Column(nullable = false)
  private String hostname;

  @PrePersist
  public void PrePersist() {
    if (Strings.isBlank(uuid)) {
      uuid = "CST-" + UUID.randomUUID().toString();
    }
  }

}
