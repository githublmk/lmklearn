package com.lmk.bootln2.serivce;

import com.lmk.bootln2.mapper.RoleMapper;
import com.lmk.bootln2.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends BaseServiceImpl<Role> {
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> selectRoleByName(String username){
        return roleMapper.selectRoleByName(username);
    }
}
