package com.stone.service.core.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stone.service.core.domain.Vote;
import com.stone.utils.BaseMapper;

public interface VoteMapper  extends BaseMapper<Vote>{

	List<Vote> getLatestedVotes(@Param("rows") Integer rows);

}
