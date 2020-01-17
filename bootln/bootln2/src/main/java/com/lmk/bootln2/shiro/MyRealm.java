package com.lmk.bootln2.shiro;

import com.lmk.bootln2.mapper.RoleMapper;
import com.lmk.bootln2.mapper.UserMapper;
import com.lmk.bootln2.model.Promission;
import com.lmk.bootln2.model.Role;
import com.lmk.bootln2.model.User;
import com.lmk.bootln2.serivce.PromissionService;
import com.lmk.bootln2.serivce.RoleService;
import com.lmk.bootln2.serivce.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PromissionService promissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        List<Role> roles = roleService.selectRoleByName(user.getUsername());
       List<Promission> promissions =  promissionService.selectPromissionByUsername(user.getUsername());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        HashSet<String> rolesSet = new HashSet<>();
        for(Role r:roles){
            rolesSet.add(r.getName());
        }
        info.setRoles(rolesSet);
        HashSet<String> proSet = new HashSet<>();
        for(Promission p:promissions){
            proSet.add(p.getName());
        }
        info.setStringPermissions(proSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {


     String username = (String) authenticationToken.getPrincipal();
     Example example = new Example(User.class);
     example.createCriteria().andEqualTo("username",username);
        List<User> users = userService.selectByExample(example);
        User user = users.size()>0?users.get(0):null;
        if(user==null){
            throw new UnknownAccountException("用户名不存在");
        }
        if(user!=null&&user.getStatus().equals("0")){
            throw new LockedAccountException("您的账户已经被锁定，请联系管理员");
        }
        AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        return info;
    }
}
