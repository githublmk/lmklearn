package com.boot.ln.duridln;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.boot.ln.duridln.mapper"})
@EnableAspectJAutoProxy

public class DuridlnApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuridlnApplication.class, args);
    }

}
