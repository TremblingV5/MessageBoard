package org.demo.message.infrastructure.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class LocalCacheUtil<T> {
    private Cache<String, T> cache;

    // 缓存初始容量
    private Integer initialCapacity = 10;
    // 缓存最大容量
    private Integer maximumSize = 1000;
    // 并发数
    private Integer concurrencyLevel = 10;
    // 写入后过期时间
    private Integer expireAfterWrite = 10;
    // 写入后过期时间单位
    private TimeUnit expireAfterWriteTimeUnit = TimeUnit.MINUTES;
    // 最后一次访问后过期时间
    private Integer expireAfterAccess = 10;
    // 最后一次访问后过期时间单位
    private TimeUnit expireAfterAccessTimeUnit = TimeUnit.MINUTES;

    @PostConstruct
    public void init() {
        this.cache = CacheBuilder.newBuilder()
                .initialCapacity(this.initialCapacity)
                .maximumSize(this.maximumSize)
                .concurrencyLevel(this.concurrencyLevel)
                .expireAfterWrite(this.expireAfterWrite, this.expireAfterWriteTimeUnit)
                .expireAfterAccess(this.expireAfterAccess, this.expireAfterAccessTimeUnit)
                .recordStats()
                .build();
    }

    public void put(String key, T value) {
        this.cache.put(key, value);
    }

    public T get(String key) {
        return this.cache.getIfPresent(key);
    }

    public void remove(String key) {
        this.cache.invalidate(key);
    }
}
