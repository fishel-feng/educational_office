package com.fx.service;

import com.fx.dao.CollegeMapper;
import com.fx.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public List<College> findAll() {
        return collegeMapper.findAll();
    }
}
