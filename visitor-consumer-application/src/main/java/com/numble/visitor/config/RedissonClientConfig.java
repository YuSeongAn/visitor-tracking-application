package com.numble.visitor.config;

import com.numble.visitor.properties.RedisProperties;
import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RedissonClientConfig {
    private final RedisProperties redisProperties;

    @Bean
    public RedissonClient redissonClient() {
        final Config config = new Config();

        config.useSingleServer()
                .setAddress(redisProperties.getAddress());

        return Redisson.create(config);
    }
}
