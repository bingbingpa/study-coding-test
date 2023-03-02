package me.bingbingpa.leetcode.DataStructuresAndAlgorithms.ArraysAndStrings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SquaresOfSortedArray {

    /**
     * 오름차순으로 정렬된 정수 배열의 숫자가 주어지면, 각 숫자의 제곱을 오름차순으로로 정렬한 배열을 리턴하라.
     * 새로운 배열을 사용하지 않고 해결해보자!
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `Squares of a Sorted Array`(input: IntArray, expected: IntArray) {
        assertThat(solution(input)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(intArrayOf(-7, -3, 2, 3, 11), intArrayOf(4, 9, 9, 49, 121))
        )
    }
}

private fun solution(input: IntArray): IntArray {
    var left = 0
    var right = input.size - 1
    while (left <= right) {
        val temp = input[left]
        input[left] = input[right] * input[right]
        input[right] = temp * temp
        left++
        right--
    }
    input.sort()
    return input
}