package br.com.seireitei.api.urahara.model.customer;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.*;

import org.apache.logging.log4j.util.Strings;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  @Column(nullable = false, name = "ID")
  private Integer id;

  @Column(nullable = false, name ="uuid")
  private String uuid;

  @Column(nullable = false, length = 150)
  private String name;

  @Column(nullable = false, length = 14)
  private String document;

  @Column(name = "date_registered")
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dateRegistered;

  @PrePersist
  public void prePersist() {
    if (Strings.isBlank(uuid)) {
      setUuid("CT-" + UUID.randomUUID().toString());
    }
    setDateRegistered(LocalDate.now());
  }

}
