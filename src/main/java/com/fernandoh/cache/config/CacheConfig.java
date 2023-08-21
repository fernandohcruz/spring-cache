package com.fernandoh.cache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager caffeineManager = new CaffeineCacheManager("anything");
        caffeineManager.setCaffeine(caffeineConfig());
        return caffeineManager;
    }
    
    Caffeine<Object, Object> caffeineConfig() {
        return Caffeine.newBuilder();
    }
}
