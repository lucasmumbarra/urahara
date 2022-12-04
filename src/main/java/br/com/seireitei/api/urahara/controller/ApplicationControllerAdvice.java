package br.com.seireitei.api.urahara.controller;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.seireitei.api.urahara.exception.ApiErrors;

@RestControllerAdvice
@ControllerAdvice
public class ApplicationControllerAdvice {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(BAD_REQUEST)
  public ApiErrors handleValidationErrors(MethodArgumentNotValidException ex) {
    BindingResult bindingResult = ex.getBindingResult();
    List<String> messages = bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage())
        .collect(Collectors.toList());
    return new ApiErrors(messages);
  }
}
