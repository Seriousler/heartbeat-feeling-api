package com.azimao.heartbeat.user;

import com.azimao.heartbeat.common.entity.CommonIdDTO;
import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.user.pojo.User;
import com.azimao.heartbeat.user.pojo.UserQueryDTO;
import com.azimao.heartbeat.user.pojo.UserSaveDTO;

import java.util.List;

/**
 * @Author: 张隆
 * @Date: 2023/6/21 15:52
 * @Version: 1.0
 */
public interface UserService {

    Wrapper<List<User>> pageList(UserQueryDTO dto);

    Wrapper<User> detail(CommonIdDTO dto);

    Wrapper<Void> save(UserSaveDTO dto);

    Wrapper<Void> delete(CommonIdDTO dto);

}
