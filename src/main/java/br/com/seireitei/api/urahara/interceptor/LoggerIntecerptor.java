package br.com.seireitei.api.urahara.interceptor;

import static javax.servlet.DispatcherType.REQUEST;
import static org.springframework.http.HttpMethod.GET;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggerIntecerptor implements HandlerInterceptor {

  @Autowired
  private LoggingService loggingService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

    if (REQUEST.name().equals(request.getDispatcherType().name()) && request.getMethod().equals(GET.name())) {
      loggingService.logRequest(request, null);
    }

    return true;
  }

  @Override
  public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
      @Nullable ModelAndView modelAndView) throws Exception {
  }

  @Override
  public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
      @Nullable Exception e) throws Exception {
  }
}
