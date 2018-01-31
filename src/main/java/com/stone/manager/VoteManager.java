package com.stone.manager;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.service.core.VoteService;
import com.stone.service.core.domain.Vote;
import com.stone.utils.DateUtil;

@Service
public class VoteManager {
	
	@Autowired
	private VoteService voteService;

	public List<Vote> getLatestedVotes(String date) {
		Date startTime = DateUtil.parse(date, DateUtil.FORMAT_DATETIME_YYYYMMDD);
		Date endTime = DateUtil.getTodayLastTime(startTime);
		return voteService.getLatestedVotes(startTime,endTime);
	}

}
