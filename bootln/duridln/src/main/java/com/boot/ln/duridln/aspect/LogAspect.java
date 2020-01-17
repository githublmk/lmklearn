package com.boot.ln.duridln.aspect;

import com.boot.ln.duridln.mode.SysLog;
import com.boot.ln.duridln.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.xml.ws.spi.http.HttpContext;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogService logService;
    @Pointcut("@annotation(com.boot.ln.duridln.aspect.Log)")
    public void ponitcut(){}

    @Around("ponitcut()")
    public Object around(ProceedingJoinPoint point){
        Object result = null;
        long begintime = System.currentTimeMillis();
        try{
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - begintime;
        saveLog(point,time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        Log logAnnotation = method.getAnnotation(Log.class);
        if(logAnnotation != null){
            sysLog.setOperation(logAnnotation.value());
        }

        String classname = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethods(classname+"."+methodName+"()");
        Object[] args = point.getArgs();
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramsNames = u.getParameterNames(method);
        if(args !=null&& paramsNames!=null){
            String params = "";
            for (int i =0;i<args.length;i++){
                params+=" "+ paramsNames[i]+": "+args[i];
            }
            sysLog.setParams(params);
        }
        sysLog.setIp("127.0.0.1");
        sysLog.setUsername("lmk");
        sysLog.setCreatedate(new Date());
        sysLog.setTime( new Integer((int) time));
        logService.addLog(sysLog);
    }
}
