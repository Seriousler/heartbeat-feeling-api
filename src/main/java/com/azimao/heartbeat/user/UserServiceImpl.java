package com.azimao.heartbeat.user;

import com.azimao.heartbeat.common.entity.CommonIdDTO;
import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.mapper.UserInterestMapper;
import com.azimao.heartbeat.mapper.UserMapper;
import com.azimao.heartbeat.user.pojo.interest.UserInterest;
import com.azimao.heartbeat.user.pojo.interest.UserInterestSaveDTO;
import com.azimao.heartbeat.user.pojo.user.User;
import com.azimao.heartbeat.user.pojo.user.UserQueryDTO;
import com.azimao.heartbeat.user.pojo.user.UserSaveDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 张隆
 * @Date: 2023/6/21 15:52
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInterestMapper userInterestMapper;

    @Override
    public Wrapper<List<User>> pageList(UserQueryDTO dto) {
        PageMethod.startPage(dto.getPageNum(), dto.getPageSize());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> userList = userMapper.selectList(queryWrapper);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return Wrapper.page(userList, pageInfo.getTotal());
    }

    @Override
    public Wrapper<User> detail(CommonIdDTO dto) {
        User user = userMapper.selectById(dto.getId());
        return Wrapper.result(user);
    }

    @Override
    public Wrapper<Void> save(UserSaveDTO dto) {
        if (dto.getUserCode() != null) {
            userMapper.updateById(dto);
        } else {
            userMapper.insert(dto);
        }
        return Wrapper.success();
    }

    @Override
    public Wrapper<Void> delete(CommonIdDTO dto) {
        userMapper.deleteById(dto.getId());
        return Wrapper.success();
    }

    @Override
    public Wrapper<List<UserInterest>> interestList() {
        QueryWrapper<UserInterest> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", null);
        List<UserInterest> userInterestList = userInterestMapper.selectList(queryWrapper);
        return Wrapper.list(userInterestList);
    }

    @Override
    public Wrapper<Void> interestSave(UserInterestSaveDTO dto) {
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
