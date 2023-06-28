package com.azimao.heartbeat.lovestandard;

import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.lovestandard.pojo.LoveStandard;
import com.azimao.heartbeat.mapper.LoveStandardMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 14:13
 * @Version: 1.0
 */
@Service
public class LoveStandardServiceImpl implements LoveStandardService {

    @Autowired
    private LoveStandardMapper loveStandardMapper;

    @Override
    public Wrapper<List<LoveStandard>> list() {
        QueryWrapper<LoveStandard> queryWrapper = new QueryWrapper<>();
        List<LoveStandard> loveStandardList = loveStandardMapper.selectList(queryWrapper);
        return Wrapper.list(loveStandardList);
    }

}
