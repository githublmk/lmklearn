package com.lmk.bootln2.serivce;

import com.lmk.bootln2.mapper.PromissionMapper;
import com.lmk.bootln2.model.Promission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromissionService extends BaseServiceImpl<Promission>{

    @Autowired
    private PromissionMapper promissionMapper;


    public List<Promission> selectPromissionByRolename(String rolename){
        return promissionMapper.selectPromissionByRoleName(rolename);
    }

    public List<Promission> selectPromissionByUsername(String username) {
        return promissionMapper.selectPromissionByUserName(username);
    }
}
