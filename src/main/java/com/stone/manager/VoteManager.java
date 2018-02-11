package com.stone.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.service.core.VoteService;
import com.stone.service.core.domain.Vote;

@Service
public class VoteManager {
	
	public static final int weight = 5;
	
	@Autowired
	private VoteService voteService;

	public List<Vote> getLatestedVotes(Integer row) {
		Integer inputRow = row == null ? 0 : row;
		Integer rows = weight * inputRow;
		return voteService.getLatestedVotes(rows);
	}
	
	public List<Vote> searchVotes(String inputVal){
		
		return voteService.searchVotes(inputVal);
	}

}
