package net.aht.internship.demo;

import com.github.slugify.Slugify;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MovieBookingWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieBookingWebsiteApplication.class, args);
    }

    @Bean
    public Slugify slugify() {
        return new Slugify();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/**").allowedOrigins("https://localhost:8080");
            }
        };
    }

}
