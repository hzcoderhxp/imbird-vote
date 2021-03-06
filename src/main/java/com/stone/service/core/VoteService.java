package com.stone.service.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.service.core.base.BaseService;
import com.stone.service.core.domain.Vote;
import com.stone.service.core.repository.VoteMapper;

@Service
public class VoteService extends BaseService<Vote>{
	
	@Autowired
	private VoteMapper voteMapper;

	public List<Vote> getLatestedVotes(Integer rows) {
		return voteMapper.getLatestedVotes(rows);
	}

	public List<Vote> searchVotes(String inputVal) {
		return voteMapper.searchVotes(inputVal);
	}

}
