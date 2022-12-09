package br.com.seireitei.api.urahara.response.basereturn;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class BaseReturn<T> implements Serializable {
  
  private static final long serialVersionUID = -3313325525077947576L;

  public BaseReturn() {
    this.success = true;
    this.errorMessage = null;
    this.description = null;
    this.rejectValue = null;
    this.field = null;
    this.error = null;
    this.data = null;
  }

  public BaseReturn(T data) {
    this.success = true;
    this.errorMessage = null;
    this.description = null;
    this.rejectValue = null;
    this.field = null;
    this.errorCode = null;
    this.error = null;
    this.data = data;
  }

  @JsonProperty("success")
  private Boolean success;

  @JsonProperty("errorCode")
  private Integer errorCode;

  @JsonProperty("error")
  private String error;

  @JsonProperty("field")
  private String field;

  @JsonProperty("rejectValue")
  private Object rejectValue;

  @JsonProperty("errorMessage")
  private String errorMessage;

  @JsonProperty("description")
  private String description;

  @JsonProperty("data")
  private T data;
}
