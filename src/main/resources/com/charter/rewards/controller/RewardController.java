package com.charter.rewards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.rewards.dto.CustomerRewardDto;
import com.charter.rewards.service.RewardService;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @GetMapping("/{customerId}")
    public CustomerRewardDto getCustomerRewards(
            @PathVariable Long customerId) {

        return rewardService.getCustomerRewards(customerId);
    }

    @GetMapping
    public List<CustomerRewardDto> getAllCustomerRewards() {

        return rewardService.getAllCustomerRewards();
    }
}