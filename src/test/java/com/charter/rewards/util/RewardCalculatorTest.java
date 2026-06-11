package com.charter.rewards.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RewardCalculatorTest {

    @Test
    void testLessThan50() {
        assertEquals(0,
                RewardCalculator.calculateRewardPoints(40));
    }

    @Test
    void testBetween50And100() {
        assertEquals(20,
                RewardCalculator.calculateRewardPoints(70));
    }

    @Test
    void testGreaterThan100() {
        assertEquals(90,
                RewardCalculator.calculateRewardPoints(120));
    }
}