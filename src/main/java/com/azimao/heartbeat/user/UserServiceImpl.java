package com.azimao.heartbeat.user;

import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.mapper.UserInterestMapper;
import com.azimao.heartbeat.mapper.UserMapper;
import com.azimao.heartbeat.user.pojo.interest.UserInterest;
import com.azimao.heartbeat.user.pojo.interest.UserInterestSaveDTO;
import com.azimao.heartbeat.user.pojo.user.User;
import com.azimao.heartbeat.user.pojo.user.UserQueryDTO;
import com.azimao.heartbeat.user.pojo.user.UserSaveDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
    public Wrapper<User> detail(UserQueryDTO dto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", dto.getOpenid());
        User user = userMapper.selectOne(queryWrapper);
        return Wrapper.result(user);
    }

    @Override
    public Wrapper<Void> save(UserSaveDTO dto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", dto.getOpenid());
        User user = userMapper.selectOne(queryWrapper);
        if (user != null) {
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("openid", dto.getOpenid());
            userMapper.update(null, updateWrapper);
        } else {
            userMapper.insert(dto);
        }
        return Wrapper.success();
    }

    @Override
    public Wrapper<Void> delete(UserQueryDTO dto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", dto.getOpenid());
        userMapper.delete(queryWrapper);
        return Wrapper.success();
    }

    @Override
    public Wrapper<List<UserInterest>> interestList(UserQueryDTO dto) {
        QueryWrapper<UserInterest> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", dto.getOpenid());
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
