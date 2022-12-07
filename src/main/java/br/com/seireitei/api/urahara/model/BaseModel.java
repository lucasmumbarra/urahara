package br.com.seireitei.api.urahara.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel<T extends BaseModel<T>> implements Serializable {
  
  private static final long serialVersionUID = 6476386411544285423L;

  public static final String ID = "id";
  public static final String DATE_MODEL = "dateModel";
  
}
