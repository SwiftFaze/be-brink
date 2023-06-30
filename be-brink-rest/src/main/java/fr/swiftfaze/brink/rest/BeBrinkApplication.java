package fr.swiftfaze.brink.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BeBrinkApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BeBrinkApplication.class, args);

    }
}
