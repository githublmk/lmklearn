package com.boot.ln.duridln.service;


import com.boot.ln.duridln.mode.SysLog;
import com.boot.ln.duridln.mapper.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    @Autowired
    private LogDao logDao;


    public void addLog(SysLog log){
        logDao.addLog(log);
    }
}
