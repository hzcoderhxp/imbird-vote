package com.stone.service.core;

import com.stone.service.core.base.BaseService;
import com.stone.service.core.domain.User;
import com.stone.service.core.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService extends BaseService<User> {
    @Autowired
	private UserMapper userMapper;

    public User getByMobile(String mobile) {
        User user=new User();
        return this.get(user);
    }

    public User getRealNameUserByIdno(String idNo) {
        User user=new User();
        return this.get(user);
    }

    public Integer userCount(Date startTime, Date endTime, Integer realNameAuth) {
        return userMapper.userCount(startTime, endTime, realNameAuth);
    }


}