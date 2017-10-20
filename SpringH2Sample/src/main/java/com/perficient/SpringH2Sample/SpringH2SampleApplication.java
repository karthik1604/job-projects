package com.perficient.SpringH2Sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringH2SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringH2SampleApplication.class, args);
	}
}
