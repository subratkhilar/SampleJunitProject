package net.atos.Codex_IOT.config;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author A666395 This class for run the SpringBootWebApplication
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = { "net.atos.Codex_IOT" })
@EntityScan("net.atos.Codex_IOT")
@EnableJpaRepositories("net.atos.Codex_IOT")
public class SpringBootWebApplication extends SpringBootServletInitializer {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(SpringBootWebApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {

		SpringApplication.run(SpringBootWebApplication.class, args);
	}
}
