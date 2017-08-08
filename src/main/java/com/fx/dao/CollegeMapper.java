package com.fx.dao;

import com.fx.entity.College;

public interface CollegeMapper {
    int deleteByPrimaryKey(Integer collegeId);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer collegeId);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
}