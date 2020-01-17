package com.boot.ln.duridln.mapper;

import com.boot.ln.duridln.mode.Test;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
//@CacheConfig(cacheNames = "ttee")
public interface TestDao {


//   @Cacheable(key = "#p0.id",condition = "#p0!=null")
   void add(Test test);

   List<Test> query(Test test) ;

//   @Cacheable(key="#p0")
   Test queryTestById(String id);
}
