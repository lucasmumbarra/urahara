package br.com.seireitei.api.urahara.interceptor;

import java.util.Enumeration;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.util.Strings;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LoggingService {
  
  private static Logger LOGGER = LoggerFactory.getLogger(LoggingService.class);

  public void logRequest(HttpServletRequest request, Object body) {

    String bodyText = null;

    try {
      ObjectMapper mapper = new ObjectMapper();
      bodyText = mapper.writeValueAsString(body);
    } catch (JsonProcessingException e) {
      bodyText = "No Body";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(String.format("\n\nREQUEST ---> %s %s HTTP/1.1\n\n", request.getMethod(), request.getRequestURL()));

    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String key = (String) headerNames.nextElement();
      String value = request.getHeader(key);
      sb.append(String.format("%s: %s", key, value));
    }

    sb.append(String.format("\n%s", Strings.isNotBlank(bodyText) ? bodyText : "NO Body"));
    sb.append(String.format("\n\n---> END REQUEST HTTP (%s-byte body)\n\n",
        Strings.isNotBlank(bodyText) && !Objects.isNull(bodyText) ? bodyText.length() : 0));

    LOGGER.info(sb.toString());
  }

  public void logResponse(HttpServletRequest request, HttpServletResponse response, Object body) {

    String bodyText = null;

    try {
      ObjectMapper mapper = new ObjectMapper();
      bodyText = mapper.writeValueAsString(body);
    } catch (JsonProcessingException e) {
      bodyText = "No Body";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(String.format("\n\nRESPONSE <--- HTTP/1.1 %s (%sms)\n\n", response.getStatus(), 0));

    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String key = (String) headerNames.nextElement();
      String value = request.getHeader(key);
      sb.append(String.format("%s: %s\n", key, value));
    }

    sb.append(String.format("\n%s", Strings.isNotBlank(bodyText) ? bodyText : "No Body"));
    sb.append(String.format("\n\n<--- END RESPONSE HTTP (%s-byte body)\n\n",
        Strings.isNotBlank(bodyText) ? bodyText.length() : 0));

    LOGGER.info(sb.toString());
  }
}
