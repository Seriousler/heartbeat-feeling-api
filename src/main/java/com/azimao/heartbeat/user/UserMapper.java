package com.azimao.heartbeat.user;

import com.azimao.heartbeat.user.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 张隆
 * @Date: 2023/6/21 16:33
 * @Version: 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
