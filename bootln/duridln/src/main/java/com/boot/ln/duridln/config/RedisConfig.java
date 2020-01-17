//package com.boot.ln.duridln.config;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.lang.annotation.Target;
//import java.lang.reflect.Method;
//
//@Configuration
//public class RedisConfig extends CachingConfigurerSupport {
//
//
//    @Bean
//    @Override
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object o, Method method, Object... objects) {
//               StringBuffer sb = new StringBuffer();
//               sb.append(o.getClass().getName());
//               sb.append(method.getName());
//               for(Object obj:objects){
//                   sb.append(obj.toString());
//               }
//                return sb.toString();
//            }
//        };
//    }
//}
