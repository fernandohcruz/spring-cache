package com.fernandoh.cache.service;

import com.fernandoh.cache.model.Anyone;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService {

    Map<Long, Anyone> map = new HashMap<>() {
        {
            put(1L, new Anyone(1L, "Fernando"));
            put(2L, new Anyone(2L, "Gon"));
            put(3L, new Anyone(3L, "Luke"));
            put(4L, new Anyone(4L, "Leia"));
        }
    };

    @Cacheable(value = "anything", key = "#id")
    public Anyone getAnyThing(Long id) {
        System.out.println("Searching anyone...");
        simulateLatency();
        return map.get(id);
    }

    private void simulateLatency() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
