package com.charter.rewards.service;

import java.util.List;

import com.charter.rewards.dto.CustomerRewardDto;

/**
 * Service interface for reward calculation and retrieval.
 *  Defines methods to get rewards for a specific customer
 */
public interface RewardService {

	CustomerRewardDto getCustomerRewards(Long customerId);

	List<CustomerRewardDto> getAllCustomerRewards();

}
