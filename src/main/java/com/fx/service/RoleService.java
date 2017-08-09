package com.fx.service;

import com.fx.entity.Role;

public interface RoleService {

    /**
     * 根据id查找角色
     *
     * @param id 角色id
     * @return 角色信息
     */
    Role findById(Integer id);
}
