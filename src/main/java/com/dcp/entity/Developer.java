package com.dcp.entity;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="developer")
public class Developer{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int devId;
	@Column (name=" dname")
	private String developerName;
	@Column (name="email")
	private String email;
	@Column (name=" skillLevel")
	private String skillLevel;
	@Column (name="memberSince")
	private LocalDate memberSince;
	@Column (name="totalFeeds")
	private Integer totalFeeds;
	@Column (name="reputation")
	private Integer reputation;

	private boolean isVerified;
	@Column (name="blocked")
	private boolean isBlocked;
	
	
	@OneToOne
	private User users;
	
    
	public Developer() {}


	public Developer(int devId, String developerName, String email, String skillLevel, LocalDate memberSince,
			Integer totalFeeds, Integer reputation, boolean isVerified, boolean isBlocked, User users) {
		super();
		this.devId = devId;
		this.developerName = developerName;
		this.email = email;
		this.skillLevel = skillLevel;
		this.memberSince = memberSince;
		this.totalFeeds = totalFeeds;
		this.reputation = reputation;
		this.isVerified = isVerified;
		this.isBlocked = isBlocked;
		this.users = users;
	}


	public int getDevId() {
		return devId;
	}


	public void setDevId(int devId) {
		this.devId = devId;
	}


	public String getDeveloperName() {
		return developerName;
	}


	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSkillLevel() {
		return skillLevel;
	}


	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}


	public LocalDate getMemberSince() {
		return memberSince;
	}


	public void setMemberSince(LocalDate memberSince) {
		this.memberSince = memberSince;
	}


	public Integer getTotalFeeds() {
		return totalFeeds;
	}


	public void setTotalFeeds(Integer totalFeeds) {
		this.totalFeeds = totalFeeds;
	}


	public Integer getReputation() {
		return reputation;
	}


	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}


	public boolean isVerified() {
		return isVerified;
	}


	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}


	public boolean isBlocked() {
		return isBlocked;
	}


	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}


	public User getUsers() {
		return users;
	}


	public void setUsers(User users) {
		this.users = users;
	}


	@Override
	public String toString() {
		return "Developer [devId=" + devId + ", developerName=" + developerName + ", email=" + email + ", skillLevel="
				+ skillLevel + ", memberSince=" + memberSince + ", totalFeeds=" + totalFeeds + ", reputation="
				+ reputation + ", isVerified=" + isVerified + ", isBlocked=" + isBlocked + ", users=" + users + "]";
	}

	
	
}	