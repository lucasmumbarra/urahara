package br.com.seireitei.api.urahara.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel<T extends BaseModel<T>> implements Serializable {
  
  private static final long serialVersionUID = 6476386411544285423L;

  public static final String ID = "id";
  public static final String DATE_MODEL = "dateModel";
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, name = "id")
  private Long id;

  @Embedded
  private DateModel dateModel;

  @Version
  @Column(nullable = false, name = "version")
  private Integer version;

  @PrePersist
  private void initializeDates() {
    LocalDateTime now = LocalDateTime.now(TimeZones.getUtc());
    dateModel = new DateModel(now, now, null);
  }

  @PreUpdate
  private void updateUpdateAt() {
    dateModel.setUpdatedAt(LocalDateTime.now(TimeZones.getUtc()));
  }
}
