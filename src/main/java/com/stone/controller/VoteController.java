package com.stone.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vote")
public class VoteController {
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveVote(HttpServletRequest request){
        return "vote Welcome,You!!!";
    }

}
