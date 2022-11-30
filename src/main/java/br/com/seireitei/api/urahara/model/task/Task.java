package br.com.seireitei.api.urahara.model.task;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.*;

import org.apache.logging.log4j.util.Strings;
import org.hibernate.annotations.GenericGenerator;

import br.com.seireitei.api.urahara.model.customer.Customer;
import lombok.Data;


@Data
@Entity
@Table(name = "task")
public class Task {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  @Column(nullable = false, name = "ID")
  private Integer id;

  @Column(nullable = false, name = "uuid")
  private String uuid;

  @Column(nullable = false, length = 150)
  private String description;

  @ManyToOne
  @JoinColumn(name = "customer_id", referencedColumnName = "ID")
  private Customer customer;

  @Column(nullable = false)
  private BigDecimal value;

  @PrePersist
  public void prePersist() {
    if (Strings.isBlank(uuid)) {
      setUuid("TK-" + UUID.randomUUID().toString());
    }
  }

}
