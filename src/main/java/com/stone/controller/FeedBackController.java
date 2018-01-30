package com.stone.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stone.manager.FeedBackManager;

@RestController
@RequestMapping(value = "/feedback")
public class FeedBackController {
	
	@Autowired
	private FeedBackManager feedBackManager;
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
    public Object saveVote(HttpServletRequest request){
        return feedBackManager.getOneFeedBack();
    }

}
