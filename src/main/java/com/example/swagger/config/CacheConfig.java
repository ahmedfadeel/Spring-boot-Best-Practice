package com.example.swagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
public class CacheConfig {
    @Value ( "${redis.host:localhost}" )
    private String redisHost;
    @Value ( "${redis.port:6379}" )
    private int redisPort;


    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);

        return new LettuceConnectionFactory(configuration);
    }

    /**
     *  @Bean
     *     public RedisTemplate<String, Object> redisTemplate(){
     *         RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
     *         redisTemplate.setConnectionFactory(jedisConnectionFactory());
     *         redisTemplate.setKeySerializer(new StringRedisSerializer());
     *         redisTemplate.setHashKeySerializer(new StringRedisSerializer());
     *         redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
     *         redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
     *         redisTemplate.setEnableTransactionSupport(true);
     *         redisTemplate.afterPropertiesSet();
     *
     *         return redisTemplate;
     *     }
     * @return
     */

    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheConfiguration cacheConfig = myDefaultCacheConfig( Duration.ofMinutes(10)).disableCachingNullValues();

        return RedisCacheManager.builder(redisConnectionFactory())
                .cacheDefaults(cacheConfig)
                .withCacheConfiguration("products", myDefaultCacheConfig(Duration.ofMinutes(5)))
                .build();
    }

    private RedisCacheConfiguration myDefaultCacheConfig(Duration duration) {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(duration)
                .serializeValuesWith
              ( RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer ()));
    }
    /*
    *
	@Bean
	public RedisTemplate<String, Serializable> redisCacheTemplate(LettuceConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory factory) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
		RedisCacheConfiguration redisCacheConfiguration = config
				.serializeKeysWith(
						RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(RedisSerializationContext.SerializationPair
						.fromSerializer(new GenericJackson2JsonRedisSerializer()));
		RedisCacheManager redisCacheManager = RedisCacheManager.builder(factory).cacheDefaults(redisCacheConfiguration)
				.build();
		return redisCacheManager;
	}*/

}

