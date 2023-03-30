package me.bingbingpa.leetcode.DataStructuresAndAlgorithms.ArraysAndStrings.SlidingWindow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.math.max

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MaxConsecutiveOnes {

    /**
     * 주어진 이진 배열(nums)에서, 최대 k개의 0을 뒤집어(1로 바꿔) 연속적으로 나타나는 1의 최대 개수를 구하라.
     * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
     * Output: 6
     * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
     * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
     * Output: 10
     * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `Max Consecutive Ones III`(nums: IntArray, k: Int, expected: Int) {
        assertThat(solution(nums, k)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2, 6),
            Arguments.of(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3, 10),
        )
    }
}

private fun solution(nums: IntArray, k: Int): Int {
    var left = 0
    var right = 0
    var numZeros = 0
    var result = 0

    while (right < nums.size) {
        if (nums[right] == 0) {
            numZeros++
        }

        while (numZeros > k) {
            if (nums[left] == 0) {
                numZeros--
            }
            left++
        }

        result = maxOf(result, right - left + 1)
        right++
    }

    return result
}