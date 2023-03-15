package me.bingbingpa.leetcode.DataStructuresAndAlgorithms.ArraysAndStrings.SlidingWindow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NumberOfSubarrays {

    /**
     * 배열 nums 와 양의 정수 k 가 주어졌을 때, 하위 배열에 있는 모든 요소의 곱이 k보다 작은 연속 하위 배열의 수를 반환하라.
     * nums = [10, 5, 2, 6], k = 100, the answer is 8
     * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `Number Of Subarrays`(input: IntArray, k: Int, expected: Int) {
        assertThat(solution(input, k)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(intArrayOf(10, 5, 2, 6), 100, 8)
        )
    }
}

private fun solution(input: IntArray, k: Int): Int {
    if (k <= 1) {
        return 0
    }

    var ans = 0
    var left = 0
    var curr = 1

    for (right in input.indices) {
        curr *= input[right]
        while (left <= right && curr >= k) {
            curr /= input[left]
            left++
        }
        ans += right - left + 1
    }
    return ans
}