package br.com.seireitei.api.urahara.web.error.exception;

public class Strings {
  
  public static String firstUpperCase(String key) {
    String upper = key.substring(0, 1).toUpperCase() + key.substring(1);
    return upper;
  }
}
