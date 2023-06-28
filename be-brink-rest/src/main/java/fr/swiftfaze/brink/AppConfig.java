package fr.swiftfaze.brink;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

//    final JwtSecurityFilter jwtSecurityFilter;
//
//    public AppConfig(JwtSecurityFilter jwtSecurityFilter) {
//        this.jwtSecurityFilter = jwtSecurityFilter;
//    }

    @Bean
    public FilterRegistrationBean registrationFilterLocal() {
        final FilterRegistrationBean registration = new FilterRegistrationBean();

//        jwtSecurityFilter.addExcludeURL("/h2-console");
//        jwtSecurityFilter.addExcludeURL("/v2/api-docs");
        registration.setEnabled(true);
//        registration.setFilter(jwtSecurityFilter);

        return registration;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().anyRequest().permitAll();

        httpSecurity.cors();

        httpSecurity.headers().frameOptions().disable();

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
