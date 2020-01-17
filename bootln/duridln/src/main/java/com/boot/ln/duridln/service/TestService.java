package com.boot.ln.duridln.service;

import com.boot.ln.duridln.mapper.TestDao;
import com.boot.ln.duridln.mode.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
   private TestDao testDao;
    public  void add(Test test){
        testDao.add(test);
    }

    public List<Test> query(Test test){
        return testDao.query(test);
    }

    public Test queryTestById(String id){
        return testDao.queryTestById(id);
    }
}
