package com.lmk.bootln2.config;


import com.lmk.bootln2.jwt.JWTFilter;
import com.lmk.bootln2.listener.ShiroListener;
import com.lmk.bootln2.model.Promission;
import com.lmk.bootln2.serivce.PromissionService;
import com.lmk.bootln2.shiro.JWTRealm;
import com.lmk.bootln2.shiro.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.*;

@Configuration
public class ShiroConfig {



    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean =new ShiroFilterFactoryBean();
        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("/home");
        factoryBean.setUnauthorizedUrl("/403");
        factoryBean.setSecurityManager(securityManager);

        HashMap<String, Filter> filterHashMap = new HashMap<>();
        filterHashMap.put("jwt",new JWTFilter());
        factoryBean.setFilters(filterHashMap);
        LinkedHashMap<String,String> map = new LinkedHashMap<>();

        map.put("/tologin","anon");
        map.put("/","anon");
        map.put("/css/**","anon");
        map.put("/js/**","anon");
        map.put("/img/**","anon");
        map.put("/font/**","anon");
        map.put("/druid/**","anon");
        map.put("/logout","logout");
        map.put("/**","authc");

        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(j);
        securityManager.setCacheManager(redisCacheManager());
//        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }

    @Bean
    public JWTRealm jwtRealm(){
        return new JWTRealm();
    }

    //开启注解配置
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public RedisManager redisManager(){
        return new RedisManager();
    }

    @Bean
    public RedisCacheManager redisCacheManager(){
        RedisCacheManager cacheManager = new RedisCacheManager();
        cacheManager.setRedisManager(redisManager());
        return cacheManager;
    }


//    sessiondao

//    @Bean
//    public RedisSessionDAO sessionDAO(){
//        RedisSessionDAO sessionDAO = new RedisSessionDAO();
//        sessionDAO.setRedisManager(redisManager());
//        return sessionDAO;
//    }
//
//    @Bean
//    public SessionManager sessionManager(){
//        DefaultWebSessionManager webSessionManager = new DefaultWebSessionManager();
//        Collection<SessionListener> collection =new ArrayList<SessionListener>();
//       ((ArrayList<SessionListener>) collection).add(new ShiroListener());
//        webSessionManager.setSessionListeners(collection);
//        webSessionManager.setSessionDAO(sessionDAO());
//        return webSessionManager;
//    }
}
