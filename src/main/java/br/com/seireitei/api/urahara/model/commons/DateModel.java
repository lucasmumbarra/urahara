package br.com.seireitei.api.urahara.model.commons;

import static br.com.seireitei.api.urahara.utils.DatePatterns.YYY_MM_DD_T_HH_MM_SS;
import static br.com.seireitei.api.urahara.utils.Dates.getFormattedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Embeddable
public class DateModel implements Serializable {
  
  private static final long serialVersionUID = 7191366391960359555L;

  public static final String CREATED_AT = "createdAt";
  public static final String UPDATED_AT = "updatedAt";
  public static final String DELETED_AT = "deletedAt";

  @Column(nullable = false, name = "created_at")
  private LocalDateTime createdAt;

  @Column(nullable = false, name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(nullable = true, name = "deleted_at")
  private LocalDateTime deletedAt;

  public DateModel() {
  }
  
  public DateModel(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }

  public DateModel(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String formattedCreatedAt() {
    return getFormattedDate(createdAt, YYY_MM_DD_T_HH_MM_SS);
  }

  public String formattedUpdatedAt() {
    return getFormattedDate(createdAt, YYY_MM_DD_T_HH_MM_SS);
  }
}
