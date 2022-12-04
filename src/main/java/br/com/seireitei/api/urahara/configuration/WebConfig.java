package br.com.seireitei.api.urahara.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.seireitei.api.urahara.interceptor.LoggerIntecerptor;
import io.micrometer.core.instrument.MeterRegistry;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Value("${service.name}")
  private String serviceName;

  @Autowired
  private LoggerIntecerptor logIntecerptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(logIntecerptor);
  }

  @Bean
  MeterRegistryCustomizer<MeterRegistry> metricsCommontags() {
    return registry -> registry.config().commonTags("application", serviceName);
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
            .allowCredentials(false)
            .maxAge(3600);
      }
    };
  }
}
