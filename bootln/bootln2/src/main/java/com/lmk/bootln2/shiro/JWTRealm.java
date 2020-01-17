package com.lmk.bootln2.shiro;

import com.lmk.bootln2.jwt.JWTToken;
import com.lmk.bootln2.jwt.JWTUtil;
import com.lmk.bootln2.mapper.UserMapper;
import com.lmk.bootln2.model.Promission;
import com.lmk.bootln2.model.Role;
import com.lmk.bootln2.model.User;
import com.lmk.bootln2.serivce.PromissionService;
import com.lmk.bootln2.serivce.RoleService;
import com.lmk.bootln2.serivce.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;

@Service
public class JWTRealm extends AuthorizingRealm {
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private PromissionService promissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String token = principalCollection.toString();
        String username = JWTUtil.getUsername(token);
        List<Role> roles = roleService.selectRoleByName(username);
        List<Promission> promissionList = promissionService.selectPromissionByUsername(username);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        HashSet<String> roleHashSet = new HashSet<>();
        for(Role r:roles){
            roleHashSet.add(r.getName());
        }

        info.setRoles(roleHashSet);
        HashSet<String> proSet = new HashSet<>();
        for(Promission p:promissionList){
            proSet.add(p.getName());
        }
        info.setStringPermissions(proSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String token = (String) authenticationToken.getCredentials();
        String username = JWTUtil.getUsername(token);
        if(username==null){
            throw new AuthenticationException("token invalidd");
        }
        Example example =new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);


        List<User> users = userService.selectByExample(example);
        User user= users.size()>0?users.get(0):null;
        if(user==null){
            throw new UnknownAccountException("account do not exist");
        }
        if(!JWTUtil.verify(token,username,user.getPassword())){
            throw new AuthenticationException("Username or password error");
        }
        return new SimpleAuthenticationInfo(token,token,getName());
    }
}
