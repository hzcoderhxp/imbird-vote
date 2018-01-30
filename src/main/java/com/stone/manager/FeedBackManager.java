package com.stone.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.service.core.FeedBackService;
import com.stone.service.core.domain.FeedBack;

@Service
public class FeedBackManager {

	@Autowired
	private FeedBackService feedBackService;
	
	public FeedBack getOneFeedBack(){
		return feedBackService.getByPrimaryKey(1);
	}
	
}
