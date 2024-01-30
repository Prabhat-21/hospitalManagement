package com.example.hospital.di;

import com.example.hospital.error.CustomizedResponseEntityExceptionHandler;
import com.example.hospital.filter.JwtRequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ CustomizedResponseEntityExceptionHandler.class })
public class ConfigurationModule {
    @Bean
    public FilterRegistrationBean<JwtRequestFilter> heartbeatRequestFilter(final JwtRequestFilter jwtRequestFilter) {
        FilterRegistrationBean<JwtRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtRequestFilter);
        String[] urlPatterns = new String[5];
        urlPatterns[0] = "/api/patients/*";
        urlPatterns[1] = "/api/doctors/*";
        urlPatterns[2] = "/api/admissions/*";
        urlPatterns[3] = "/api/hospitals/*";
        urlPatterns[4] = "/api/rooms/*";
        registrationBean.addUrlPatterns(urlPatterns);
        return registrationBean;
    }
}
