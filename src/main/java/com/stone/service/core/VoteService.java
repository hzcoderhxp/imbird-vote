package com.stone.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.service.core.base.BaseService;
import com.stone.service.core.domain.Vote;
import com.stone.service.core.repository.VoteMapper;

@Service
public class VoteService extends BaseService<Vote>{
	
	@Autowired
	private VoteMapper voteMapper;

}
