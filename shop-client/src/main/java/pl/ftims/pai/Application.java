package pl.ftims.pai;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Alebazi on 2018-01-14.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "pl.ftims.pai")
public class Application extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
        return app.sources(Application.class);
    }
}
