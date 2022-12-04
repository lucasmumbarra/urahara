package br.com.seireitei.api.urahara.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAsync
@ComponentScan({ "br.com.seireitei.api.urahara" })
@EnableJpaRepositories({ "br.com.seireitei.api.urahara" })
@EnableTransactionManagement
public class UraharaConfiguration {
}
