package com.azimao.heartbeat.user;

import com.azimao.heartbeat.common.entity.CommonIdDTO;
import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.mapper.UserMapper;
import com.azimao.heartbeat.user.pojo.User;
import com.azimao.heartbeat.user.pojo.UserQueryDTO;
import com.azimao.heartbeat.user.pojo.UserSaveDTO;
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

}
