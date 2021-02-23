package com.example.demo.config

import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.*

@Configuration
@AutoConfigureAfter(RedisAutoConfiguration::class)
@EnableCaching
class RedisConfig {

    @Bean
    fun redisTemplate(factory:LettuceConnectionFactory):RedisTemplate<String,Any>{
        val template = RedisTemplate<String,Any>()
        template.keySerializer = StringRedisSerializer()
        template.valueSerializer = GenericJackson2JsonRedisSerializer()
        template.setConnectionFactory(factory)
        return template
    }

    @Bean
    fun cacheManager(factory: RedisConnectionFactory):CacheManager{
        val configuration = RedisCacheConfiguration.defaultCacheConfig()
            .serializeKeysWith(
                RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer())
            ).serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(GenericJackson2JsonRedisSerializer())
            )
        return RedisCacheManager.builder(factory).cacheDefaults(configuration).build()
    }
}