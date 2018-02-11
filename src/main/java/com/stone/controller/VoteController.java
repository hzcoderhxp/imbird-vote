package com.stone.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stone.manager.VoteManager;
import com.stone.service.core.domain.Vote;

@RestController
@RequestMapping(value = "/vote")
public class VoteController {
	
	@Autowired
	private VoteManager voteManager;
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveVote(HttpServletRequest request){
        return "vote Welcome,You!!!";
    }
	
	@RequestMapping(value = "/latest/{row}",method = RequestMethod.GET)
	public List<Vote> getLatestedVotes(@PathVariable Integer row) {
		return voteManager.getLatestedVotes(row);
	}
	
	@RequestMapping(value = "/search/{inputVal}",method = RequestMethod.GET)
	public List<Vote> searchVotes(@PathVariable String inputVal){
		return voteManager.searchVotes(inputVal);
	}

}
