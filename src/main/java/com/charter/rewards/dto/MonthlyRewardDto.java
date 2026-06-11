package com.charter.rewards.dto;

public class MonthlyRewardDto {

	public MonthlyRewardDto(String month, Integer rewardPoints) {
		super();
		this.month = month;
		this.rewardPoints = rewardPoints;
	}

	private String month;
	private Integer rewardPoints;

	public MonthlyRewardDto() {
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

}
