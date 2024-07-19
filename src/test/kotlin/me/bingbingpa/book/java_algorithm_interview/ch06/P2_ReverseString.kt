package me.bingbingpa.book.java_algorithm_interview.ch06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class P2_ReverseString {

    /**
     * 문자열 뒤집기
     * 문자열을 뒤집는 함수를 작성하라. 입력값은 문자 배열이며, 리턴 없이 입력 배열 내부를 직접 조작하라.
     * @see <a href ="https://leetcode.com/problems/reverse-string/"> https://leetcode.com/problems/reverse-string/
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `문자열 뒤집기`(input: CharArray, expected: CharArray) {
        //given

        //when
        val result = bookSolution(input)

        //then
        assertThat(result).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                charArrayOf('r', 'a', 'c', 'e', 'c', 'a', 'r'),
                charArrayOf('r', 'a', 'c', 'e', 'c', 'a', 'r'),
            ),
            Arguments.of(
                charArrayOf('h', 'e', 'l', 'l', 'o'),
                charArrayOf('o', 'l', 'l', 'e', 'h'),
            ),
            Arguments.of(
                charArrayOf('H', 'a', 'n', 'n', 'a', 'h'),
                charArrayOf('h', 'a', 'n', 'n', 'a', 'H')
            )
        )
    }
}

private fun solution(input: CharArray): CharArray {
    var start = 0
    var end = input.size - 1
    while (start < end) {
        val temp = input[start]
        input[start] = input[end]
        input[end] = temp

        start++
        end--
    }
    return input
}

private fun bookSolution(input: CharArray): CharArray {
    var start = 0
    var end = input.size - 1
    while (start < end) {
        input[end] = input[start].also { input[start] = input[end] }

        start++
        end--
    }
    return input
}