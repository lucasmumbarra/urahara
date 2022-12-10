package br.com.seireitei.api.urahara.web.error.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<EnumValidation, String> {

  public List<String> values = new ArrayList<>();

  public boolean required;

  @SuppressWarnings("rawtypes")
  @Override
  public void initialize(EnumValidation constraintAnnotation) {
    Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClazz();
    Enum[] enumValues = enumClass.getEnumConstants();
    for (Enum val : enumValues) {
      values.add(val.name());
    }
    required = constraintAnnotation.required();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (required) {
      return !Objects.isNull(value) && values.contains(value.toUpperCase());
    }

    return Objects.isNull(value) || values.contains(value.toUpperCase());
  }
  
}
