package com.stone.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.service.core.base.BaseService;
import com.stone.service.core.domain.FeedBack;
import com.stone.service.core.repository.FeedBackMapper;

@Service
public class FeedBackService extends BaseService<FeedBack>{
	
	@Autowired
	private FeedBackMapper feedBackMapper;

}
