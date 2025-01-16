package com.freightwise.software.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@SpringBootApplication
public class GetTheWeatherApp {
  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(GetTheWeatherApp.class);
    app.setAdditionalProfiles("dev");
    app.run(args);
    log.info("App is running...");
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    //Security handled in its own class typically but for brevity's sake we'll do it here
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            /*
             * Only GET, HEAD, and POST methods are allowed by default, so in order to allow other
             * Request methods either manually add them or allow all with (*)
             */
            .allowedMethods("*");
      }
    };
  }
}
