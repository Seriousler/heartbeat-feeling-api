package com.azimao.heartbeat.user;

import com.azimao.heartbeat.common.entity.CommonIdDTO;
import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.user.pojo.interest.UserInterest;
import com.azimao.heartbeat.user.pojo.interest.UserInterestSaveDTO;
import com.azimao.heartbeat.user.pojo.user.User;
import com.azimao.heartbeat.user.pojo.user.UserQueryDTO;
import com.azimao.heartbeat.user.pojo.user.UserSaveDTO;

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

    Wrapper<List<UserInterest>> interestList();

    Wrapper<Void> interestSave(UserInterestSaveDTO dto);

}
