package com.azimao.heartbeat.interest;

import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.interest.pojo.Interest;
import com.azimao.heartbeat.mapper.InterestMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 11:22
 * @Version: 1.0
 */
@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private InterestMapper interestMapper;

    @Override
    public Wrapper<List<Interest>> list() {
        QueryWrapper<Interest> queryWrapper = new QueryWrapper<>();
        List<Interest> interestList = interestMapper.selectList(queryWrapper);
        return Wrapper.list(interestList);
    }

}
