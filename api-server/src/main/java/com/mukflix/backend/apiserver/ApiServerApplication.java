package com.mukflix.backend.apiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Map;

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
}
