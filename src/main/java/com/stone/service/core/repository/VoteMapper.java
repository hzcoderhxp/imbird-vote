package com.stone.service.core.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stone.service.core.domain.Vote;
import com.stone.utils.BaseMapper;

public interface VoteMapper  extends BaseMapper<Vote>{

	List<Vote> getLatestedVotes(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

}
