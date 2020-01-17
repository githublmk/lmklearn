package com.lmk.bootln2.serivce;

import com.lmk.bootln2.mapper.UserMapper;
import com.lmk.bootln2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseServiceImpl<User> {
    @Autowired
    private UserMapper userMapper;

}
