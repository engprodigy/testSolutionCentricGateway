package com.crossover.techtrial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
		
		@PropertySource("classpath:auth0.properties")
})
public class CrossSolarApplication {

  public static void main(String[] args) {
    SpringApplication.run(CrossSolarApplication.class, args);
  }

}
