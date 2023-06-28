package com.azimao.heartbeat.interest;

import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.interest.pojo.Interest;
import com.azimao.heartbeat.interest.pojo.UserInterest;
import com.azimao.heartbeat.interest.pojo.UserInterestSaveDTO;
import com.azimao.heartbeat.mapper.InterestMapper;
import com.azimao.heartbeat.mapper.UserInterestMapper;
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
    @Autowired
    private UserInterestMapper userInterestMapper;

    @Override
    public Wrapper<List<Interest>> list() {
        QueryWrapper<Interest> queryWrapper = new QueryWrapper<>();
        List<Interest> interestList = interestMapper.selectList(queryWrapper);
        return Wrapper.list(interestList);
    }

    @Override
    public Wrapper<List<UserInterest>> userList() {
        QueryWrapper<UserInterest> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", null);
        List<UserInterest> userInterestList = userInterestMapper.selectList(queryWrapper);
        return Wrapper.list(userInterestList);
    }

    @Override
    public Wrapper<Void> userSave(UserInterestSaveDTO dto) {
        QueryWrapper<UserInterest> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", dto.getOpenid());
        userInterestMapper.delete(queryWrapper);
        if (!dto.getInterestList().isEmpty()) {
            dto.getInterestList().forEach(interest -> {
                UserInterest ui = new UserInterest();
                ui.setOpenid(dto.getOpenid());
                ui.setInterest(interest);
                userInterestMapper.insert(ui);
            });
        }
        return Wrapper.success();
    }

}
