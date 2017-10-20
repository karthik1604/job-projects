package com.perficient.SpringH2Sample;

import com.perficient.SpringH2Sample.IService.ISubscriberService;
import com.perficient.SpringH2Sample.repository.SubscriberRepository;
import com.perficient.SpringH2Sample.serviceImpl.DummySubscriberServiceDB;
import com.perficient.SpringH2Sample.serviceImpl.SubscriberServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.AbstractRedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
@EnableAutoConfiguration
public class AppConfig {

    @Value("${dbIndicator}")
    String dbIndicator;


    @Bean
    @Qualifier("ActualDB")
    public ISubscriberService actualDb(SubscriberRepository subscriberRepository){
        return new SubscriberServiceDB(subscriberRepository);
    }

    @Bean
    @Qualifier("DummyDB")
    public ISubscriberService dummyDB(){

        return new DummySubscriberServiceDB();
    }

   @Bean
   public ISubscriberService iSubscriberService(@Qualifier("ActualDB")ISubscriberService actualDb,
                                                @Qualifier("DummyDB")ISubscriberService dummyDB){
       if("Y".equals(dbIndicator)){
           return actualDb;
       }else{
           return dummyDB;
       }
   }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();

        // Defaults
        redisConnectionFactory.setHostName("127.0.0.1");
        redisConnectionFactory.setPort(6379);
        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(300);
        return cacheManager;
    }





}
