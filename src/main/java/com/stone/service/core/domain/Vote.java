package com.stone.service.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stone.service.core.base.BaseEntity;

@Table(name = "i_vote")
public class Vote extends BaseEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer optionId;
	private String title;
	private String description;
	private Date startTime;
	private Date endTime;
	private Integer isOpen;
	// 是否多选
	private Integer isOption;
	private Integer options;
	private Integer isAnonymous;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}

	public Integer getIsOption() {
		return isOption;
	}

	public void setIsOption(Integer isOption) {
		this.isOption = isOption;
	}

	public Integer getOptions() {
		return options;
	}

	public void setOptions(Integer options) {
		this.options = options;
	}

	public Integer getIsAnonymous() {
		return isAnonymous;
	}

	public void setIsAnonymous(Integer isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

}
