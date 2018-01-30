package com.stone.service.core.repository;

import com.stone.service.core.domain.User;
import com.stone.utils.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserMapper extends BaseMapper<User> {

    User getByMobile(@Param("mobile") String mobile);
    Integer userCount(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("realNameAuth") Integer realNameAuth);
}