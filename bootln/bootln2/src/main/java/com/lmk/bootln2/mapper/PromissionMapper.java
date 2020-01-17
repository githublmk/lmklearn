package com.lmk.bootln2.mapper;

import com.lmk.bootln2.config.MyMapper;
import com.lmk.bootln2.model.Promission;

import java.util.List;

public interface PromissionMapper extends MyMapper<Promission> {

    List<Promission> selectPromissionByRoleName(String name);

    List<Promission> selectPromissionByUserName(String username);
}
