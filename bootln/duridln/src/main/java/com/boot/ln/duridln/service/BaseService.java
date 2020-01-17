package com.boot.ln.duridln.service;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public abstract  class BaseService<T>  {

    @Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper(){
        return mapper;
    }

    public List<T> selectAll(){
      return   mapper.selectAll();
    }

    public int save(T entity){
      return   mapper.insert(entity);
    }
}
