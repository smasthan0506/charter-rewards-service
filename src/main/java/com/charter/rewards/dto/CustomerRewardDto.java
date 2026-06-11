package com.charter.rewards.dto;

import java.util.List;

public class CustomerRewardDto {

	private Long customerId;
	private String customerName;
	private Integer totalRewardPoints;
	private List<MonthlyRewardDto> monthlyRewards;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getTotalRewardPoints() {
		return totalRewardPoints;
	}

	public void setTotalRewardPoints(Integer totalRewardPoints) {
		this.totalRewardPoints = totalRewardPoints;
	}

	public List<MonthlyRewardDto> getMonthlyRewards() {
		return monthlyRewards;
	}

	public void setMonthlyRewards(List<MonthlyRewardDto> monthlyRewards) {
		this.monthlyRewards = monthlyRewards;
	}

	public CustomerRewardDto(Long customerId, String customerName, Integer totalRewardPoints,
			List<MonthlyRewardDto> monthlyRewards) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.totalRewardPoints = totalRewardPoints;
		this.monthlyRewards = monthlyRewards;
	}

	public CustomerRewardDto() {
		super();
	}
	
	

}
