package me.bingbingpa.leetcode.DataStructuresAndAlgorithms.ArraysAndStrings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FindLength {

    /**
     * 양수로 이루어진 배열과 값 k 가 주어졌을 때, 그 합이 k보다 작거나 같은 가장 긴 하위 배열의 길이를 구하라.
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `Find Length`(input: IntArray, k: Int, expected: Int) {
        assertThat(solution(input, k)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(intArrayOf(3, 1, 2, 7, 4, 2, 1, 1, 5), 8, 4)
        )
    }
}

private fun solution(input: IntArray, k: Int): Int {
    var left = 0
    var curr = 0
    var answer = 0

    for (right in input.indices) {
        curr += input[right]
        if (curr > k) {
            curr -= input[left]
            left++
        }
        answer = answer.coerceAtLeast(right - left + 1)
    }
    return answer
}
