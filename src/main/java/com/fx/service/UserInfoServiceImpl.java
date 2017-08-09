package com.fx.service;

import com.fx.dao.UserInfoMapper;
import com.fx.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findByName(String username) {
        return userInfoMapper.findByName(username);
    }

    @Transactional
    @Override
    public void save(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    @Transactional
    @Override
    public void removeByName(String username) {
        Integer targetId=userInfoMapper.findByName(username).getUserId();
        userInfoMapper.deleteByPrimaryKey(targetId);
    }

    @Transactional
    @Override
    public void updateByName(String username, UserInfo userInfo) {
        userInfoMapper.updateByName(username,userInfo);
    }
}
