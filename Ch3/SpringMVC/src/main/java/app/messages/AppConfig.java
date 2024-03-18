package app.messages;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("app.messages")
public class AppConfig {
  // Bean 어노테이션을 이용해 AuditingFilter에 대한 FilterRegistrationBean을 생성한다
  @Bean
  public FilterRegistrationBean<AuditingFilter> auditingFilterFilterRegistrationBean() {
    FilterRegistrationBean<AuditingFilter> registration = new FilterRegistrationBean<>();

    AuditingFilter filter = new AuditingFilter();
    registration.setFilter(filter);
    registration.setOrder(Integer.MAX_VALUE);
    registration.setUrlPatterns(Arrays.asList("/messages/*"));

    return registration;
  }

}
