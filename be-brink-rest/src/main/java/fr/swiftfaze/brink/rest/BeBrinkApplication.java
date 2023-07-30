package fr.swiftfaze.brink.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {
        "fr.swiftfaze.brink.business.service",
        "fr.swiftfaze.brink",
        "fr.swiftfaze.brink.rest",
        "fr.swiftfaze.brink.dao",
        "fr.swiftfaze.brink.commons"
} )
public class BeBrinkApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BeBrinkApplication.class, args);

    }
}
