package br.com.seireitei.api.urahara;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UraharaApplication {
	// private static final Logger LOGGER = LoggerFactory.getLogger(UraharaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UraharaApplication.class, args);
		// ConfigurableApplicationContext ctx = SpringApplication.run(UraharaApplication.class, args);
		// String profile = Arrays.toString(ctx.getEnvironment().getActiveProfiles());
		// LOGGER.info("Using profile={} timeZone={}", profile, TimeZone.getDefault());
	}

}
