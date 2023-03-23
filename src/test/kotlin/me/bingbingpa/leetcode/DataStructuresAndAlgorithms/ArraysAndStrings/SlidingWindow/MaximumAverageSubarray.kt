package me.bingbingpa.leetcode.DataStructuresAndAlgorithms.ArraysAndStrings.SlidingWindow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MaximumAverageSubarray {

    /**
     * 주어진 정수 배열 nums 는 n개의 요소로 구성되어 있으며, 정수 k가 주어집니다.
     * 길이가 k인 최대 평균 값을 가진 연속적인 부분 배열을 찾아 이 값을 반환하세요. 계산 오차가 10^-5보다 작은 어떤 답변도 허용됩니다.
     * 예시)
     * Input: nums = [1,12,-5,-6,50,3], k = 4
     * Output: 12.75000
     * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     * Input: nums = [5], k = 1
     * Output: 5.00000
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `Maximum Average Subarray`(input: IntArray, k: Int, expected: Double) {
        assertThat(solution(input, k)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(intArrayOf(1, 12, -5, -6, 50, 3), 4, 12.75000),
            Arguments.of(intArrayOf(5), 1, 5.00000),
        )
    }
}

private fun solution(nums: IntArray, k: Int): Double {
    var sum = 0

    for (i in 0 until k) {
        sum += nums[i]
    }

    var maxSum = sum

    for (i in k until nums.size) {
        sum += nums[i] - nums[i - k]
        maxSum = maxOf(maxSum, sum)
    }

    return maxSum.toDouble() / k
}