package me.bingbingpa.leetcode.DataStructuresAndAlgorithms.ArraysAndStrings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReverseString {

    /**
     * 문자열을 반전시키는 함수를 작성합니다. 입력 문자열은 문자 배열 s로 주어집니다.
     * 이 작업을 수행하려면 O(1)의 추가 메모리를 사용하여 입력 배열을 제자리에서 수정해야 합니다.
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `Reverse String`(input: CharArray, expected: CharArray) {
        assertThat(solution(input)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(charArrayOf('h', 'e', 'l', 'l', 'o'), charArrayOf('o', 'l', 'l', 'e', 'h')),
            Arguments.of(charArrayOf('H', 'a', 'n', 'n', 'a', 'h'), charArrayOf('h', 'a', 'n', 'n', 'a', 'H'))
        )
    }
}

private fun solution(input: CharArray): CharArray {
    var left = 0
    var right = input.size - 1
    while (left < right) {
        val temp = input[left]
        input[left] = input[right]
        input[right] = temp
        left++
        right--
    }
    return input
}