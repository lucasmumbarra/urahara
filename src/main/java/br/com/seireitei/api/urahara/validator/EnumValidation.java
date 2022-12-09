package br.com.seireitei.api.urahara.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EnumValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValidation {
  
  String message() default "Invalid Enum value";

  Class<? extends Enum<?>> enumClazz();

  boolean required() default false;

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
