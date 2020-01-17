package com.boot.ln.duridln.config;

import com.boot.ln.duridln.mapper.TestMapperDao;
import com.boot.ln.duridln.mode.Test;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private TestMapperDao testMapperDao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String name = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        System.out.println(name+"---"+password);
        Test test= new Test();
        test.setName(name);
        Test test1 = testMapperDao.selectOne(test);
        if(test1==null){
            throw new UnknownAccountException("用户名或密码错误!");
        }

        if(!test1.getNote().equals(password)){
            throw new IncorrectCredentialsException("用户名或密码错误");
        }
        SimpleAuthenticationInfo info =new SimpleAuthenticationInfo(test1,test1.getNote(),getName());
        return info;
    }
}
