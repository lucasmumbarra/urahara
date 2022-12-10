package br.com.seireitei.api.urahara.web.error.exception;

import java.util.Locale;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.seireitei.api.urahara.response.basereturn.BaseReturn;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

  @ExceptionHandler(ConstraintViolationException.class)
  protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exception,
      WebRequest request) {

    LOGGER.error("stage=init method=ExceptionHandlerAdvice.handleConstraintViolation", exception);

    BaseReturn<Object> response = BaseReturn.builder()
        .success(false)
        .description(exception.getMessage()).build();

    LOGGER.error("stage=end method=ExceptionHandlerAdvice.handleConstraintViolation response={}", response, exception);

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler
  public ResponseEntity<Object> handle(HttpMessageConversionException e) {
    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    LOGGER.error("stage=init method=ExceptionHandlerAdvice.handleMethodArgumentNotValid", exception);

    FieldError error = (FieldError) exception.getBindingResult().getAllErrors().get(0);

    BaseReturn<Object> response = BaseReturn.builder()
        .success(false)
        .field(error.getField())
        .rejectValue(error.getRejectedValue())
        .error(HttpStatus.BAD_REQUEST.name())
        .errorCode(HttpStatus.BAD_REQUEST.value())
        .errorMessage(error.getDefaultMessage())
        .description(String.format("%s %s", Strings.firstUpperCase(error.getField()), error.getDefaultMessage()))
        .build();

    LOGGER.error("stage=end method=ExceptionHandlerAdvice.handleMethodArgumentNotValid response={}", response,
        exception);

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  protected ResponseEntity<Object> handleException(BaseException exception, WebRequest request, Locale locale) {

    LOGGER.error("stage=init method=ExceptionHandlerAdvice.handleException", exception);

    BaseReturn<Object> response = BaseReturn.builder()
        .success(false)
        .description(exception.getMessage()).build();

    LOGGER.error("stage=end method=ExceptionHandlerAdvice.handleException response={}", response, exception);

    return new ResponseEntity<>(response, exception.getStatus());

  }

}
