package com.example.demo.config

import com.example.demo.entity.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
@EnableCaching
class RedisConfig {
    @Value("\${spring.redis.host:127.0.0.1}")
    lateinit var host: String

    @Value("\${spring.redis.port:6379}")
    lateinit var port: String

    @Bean
    fun redisConnectionFactory() = LettuceConnectionFactory(RedisStandaloneConfiguration(host, port.toInt()))

    @Bean
    fun redisTemplate(factory: LettuceConnectionFactory) = RedisTemplate<String, User>().apply {
        keySerializer = StringRedisSerializer()
        valueSerializer = GenericJackson2JsonRedisSerializer()
        setConnectionFactory(factory)
    }

    @Bean
    fun cacheManager(factory: RedisConnectionFactory) = RedisCacheManager.builder(factory).cacheDefaults(
        RedisCacheConfiguration.defaultCacheConfig().serializeKeysWith(
            RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer())
        ).serializeValuesWith(
            RedisSerializationContext.SerializationPair.fromSerializer(GenericJackson2JsonRedisSerializer())
        )
    ).build()
}