package com.fx.service;

import com.fx.entity.UserInfo;

public interface UserInfoService {

    /**
     * 查找用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    UserInfo findByName(String username);

    /**
     * 保存用户信息
     *
     * @param userInfo 用户信息
     */
    void save(UserInfo userInfo);

    /**
     * 删除用户信息
     *
     * @param username 用户名
     */
    void removeByName(String username);

    /**
     * 修改用户信息
     *
     * @param username 用户名
     * @param userInfo 用户信息
     */
    void updateByName(String username, UserInfo userInfo);
}
