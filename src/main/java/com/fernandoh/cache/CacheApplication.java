package com.fernandoh.cache;

import com.fernandoh.cache.service.CacheService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(CacheService service) {
        return args -> {
            System.out.println("\n\n\n");
            System.out.println("Id 1: " + service.getAnyThing(1L));
            System.out.println("Id 2: " + service.getAnyThing(2L));
            System.out.println("Id 3: " + service.getAnyThing(3L));
            System.out.println("Id 1: " + service.getAnyThing(1L));
            System.out.println("Id 4: " + service.getAnyThing(4L));
			System.out.println("Id 3: " + service.getAnyThing(3L));
        };
    }
}
