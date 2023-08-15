package com.fernandoh.cache.service;

import com.fernandoh.cache.model.AnyOne;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService {

    Map<Long, AnyOne> map = new HashMap<>() {
        {
            put(1L, new AnyOne(1L, "Fernando"));
            put(2L, new AnyOne(2L, "Gon"));
            put(3L, new AnyOne(3L, "Luke"));
            put(4L, new AnyOne(4L, "Leia"));
        }
    };

    @Cacheable(value = "anything", key = "#id")
    public AnyOne getAnyThing(Long id) {
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
