package com.stone.service.core.domain;

import com.stone.service.core.base.BaseEntity;

import javax.persistence.*;

@Table(name="i_user")
public class User extends BaseEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nickName;
	private String osInfo;
	private String avatarUrl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getDescription() {
		return osInfo;
	}
	public void setDescription(String description) {
		this.osInfo = description;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	
}