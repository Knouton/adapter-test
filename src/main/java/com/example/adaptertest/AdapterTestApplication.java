package com.example.adaptertest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.fasterxml.jackson.databind.JsonDeserializer;

@SpringBootApplication()
@EnableJpaRepositories()
public class AdapterTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdapterTestApplication.class, args);
	}

}
