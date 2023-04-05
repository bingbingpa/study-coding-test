package me.bingbingpa.leetcode.DataStructuresAndAlgorithms.ArraysAndStrings.prefixSum

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MinimumValueToGetPositive {

    /**
     * Given an array of integers nums, you start with an initial positive value startValue.
     * In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
     * Return the minimum positive value of startValue such that the step by step sum is never less than 1.
     * Example 1:
     *  Input: nums = [-3,2,-3,4,2]
     *  Output: 5
     * Example 2:
     *  Input: nums = [1,2]
     *  Output: 1
     * Example 3:
     *  Input: nums = [1,-2,-3]
     *  Output: 5
     * Constraints:
     *  1 <= nums.length <= 100
     *  -100 <= nums[i] <= 100
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `Minimum Value to Get Positive Step by Step Sum`(input: IntArray, expected: Int) {
        assertThat(solution(input)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(intArrayOf(-3, 2, -3, 4, 2), 5),
            Arguments.of(intArrayOf(1, 2), 1),
            Arguments.of(intArrayOf(1, -2, -3), 5)
        )
    }
}

private fun solution(nums: IntArray): Int {
    var min = 0
    var total = 0

    for (num in nums) {
        total += num
        min = minOf(min, total)
    }
    return -min + 1
}