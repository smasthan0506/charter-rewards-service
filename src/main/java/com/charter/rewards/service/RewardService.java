package com.charter.rewards.service;

import java.util.List;

import com.charter.rewards.dto.CustomerRewardDto;

public interface RewardService {

	CustomerRewardDto getCustomerRewards(Long customerId);

	List<CustomerRewardDto> getAllCustomerRewards();

}
