package com.lmk.bootln2.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

public class ShiroListener implements SessionListener {
   private AtomicInteger sessionCount =  new AtomicInteger(0);
    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
    }

    @Override
    public void onStop(Session session) {
        sessionCount.incrementAndGet();
    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.incrementAndGet();
    }
}
