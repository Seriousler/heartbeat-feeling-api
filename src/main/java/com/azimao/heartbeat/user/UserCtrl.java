package com.azimao.heartbeat.user;

import com.azimao.heartbeat.common.entity.CommonIdDTO;
import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.user.pojo.interest.UserInterest;
import com.azimao.heartbeat.user.pojo.interest.UserInterestSaveDTO;
import com.azimao.heartbeat.user.pojo.user.User;
import com.azimao.heartbeat.user.pojo.user.UserQueryDTO;
import com.azimao.heartbeat.user.pojo.user.UserSaveDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 张隆
 * @Date: 2023/6/21 15:28
 * @Version: 1.0
 */
@Tag(name = "user", description = "用户")
@RestController
@RequestMapping("/user")
public class UserCtrl {

    @Autowired
    private UserService userService;

    @PostMapping("/pageList")
    public Wrapper<List<User>> pageList(@RequestBody UserQueryDTO dto) {
        return userService.pageList(dto);
    }

    @PostMapping("/detail")
    public Wrapper<User> detail(@RequestBody CommonIdDTO dto) {
        return userService.detail(dto);
    }

    @PostMapping("/save")
    public Wrapper<Void> save(@RequestBody UserSaveDTO dto) {
        return userService.save(dto);
    }

    @PostMapping("/delete")
    public Wrapper<Void> delete(@RequestBody CommonIdDTO dto) {
        return userService.delete(dto);
    }

    @PostMapping("/interest/list")
    public Wrapper<List<UserInterest>> interestList() {
        return userService.interestList();
    }

    @PostMapping("/interest/save")
    public Wrapper<Void> interestSave(@RequestBody UserInterestSaveDTO dto) {
        return userService.interestSave(dto);
    }

}
