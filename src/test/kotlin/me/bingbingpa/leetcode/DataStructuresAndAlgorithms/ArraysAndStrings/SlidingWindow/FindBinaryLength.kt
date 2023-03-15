package me.bingbingpa.leetcode.DataStructuresAndAlgorithms.ArraysAndStrings.SlidingWindow

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FindBinaryLength {

    /**
     * 이진 부분 문자열("0"과 "1"만 포함하는 문자열)이 제공된다.
     * 연산은 "0"을 "1"로 뒤집는 것을 포함한다.
     * 최대 한 번의 작업을 수행한 후 "1"만 포함하는 가장 긴 하위 문자열의 길이는 얼마인가?
     * 예를 들어, s = "1101100111"이 주어지면 답은 5입니다. 인덱스 2에서 작업을 수행하면 문자열이 1111100111이 됩니다.
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `Find binary Length`(input: String, expected: Int) {
        Assertions.assertThat(solution(input)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("1101100111", 5)
        )
    }
}

private fun solution(input: String): Int {
    var left = 0
    var curr = 0
    var answer = 0

    for (right in input.indices) {
        if (input[right] == '0') {
            curr++
        }
        while (curr > 1) {
            if (input[left] == '0') {
                curr--
            }
            left++
        }
        answer = answer.coerceAtLeast(right - left + 1)
    }

    return answer
}