package com.lmk.bootln2.mapper;

import com.lmk.bootln2.config.MyMapper;
import com.lmk.bootln2.model.Role;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
 List<Role> selectRoleByName(String username);
}
