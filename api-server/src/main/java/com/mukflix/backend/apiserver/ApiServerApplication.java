package com.mukflix.backend.apiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Map;

@EnableSwagger2
@SpringBootApplication
public class ApiServerApplication {

	private static String PROPETIES =
			"spring.config.location=" +
					"classpath:/application-core.properties" +
					", classpath:/rdb.properties";

	public static void main(String[] args) {
		new SpringApplicationBuilder(ApiServerApplication.class)
				.run(args);
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
