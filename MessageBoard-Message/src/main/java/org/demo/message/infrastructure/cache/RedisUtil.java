package org.demo.message.infrastructure.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil<T> {
    private RedisTemplate<String, T> redisTemplate;

    @Autowired
    public RedisUtil(RedisTemplate<String, T> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(final String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(final String key, T value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public void set(final String key, List<T> value) {
        redisTemplate.opsForList().rightPushAll(key, value);
    }

    public T get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public List<T> getList(final String key) {
        return redisTemplate.opsForList().range(key, 0 , -1);
    }

    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    public void del(final String key) {
        redisTemplate.delete(key);
    }
}
